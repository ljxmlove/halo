package run.halo.app.handler.postimport;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import run.halo.app.handler.postimport.resolve.AbstractWebsitePageResolver;
import run.halo.app.handler.postimport.resolve.CSDNWebsitePageResolver;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * @author liujie
 * @time 2020/5/10 11:08 上午
 */
@Component
public class PostImportHandler {

    @Autowired
    CSDNWebsitePageResolver csdnWebsitePageResolver;

    /**
     * 记录
     */
    private Map<WebsiteType, AbstractWebsitePageResolver> websitePageResolverMap = null;

    @PostConstruct
    public void postConstruct() {
        websitePageResolverMap = Maps.newHashMap();
        websitePageResolverMap.put(WebsiteType.CSDN, csdnWebsitePageResolver);
    }
    /**
     * 解析指定网站的指定页面
     */
    public String resolveWebsitePage(WebsiteType webSiteType, String pageUrl) {
        Preconditions.checkNotNull(webSiteType, "网站类型信息不能为空");
        Preconditions.checkArgument(StringUtils.isNotBlank(pageUrl), "网页地址信息不能为空");
        return websitePageResolverMap.get(webSiteType).resolveWebsitePage(pageUrl);
    }

}
