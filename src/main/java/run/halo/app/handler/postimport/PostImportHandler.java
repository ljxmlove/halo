package run.halo.app.handler.postimport;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import run.halo.app.handler.postimport.resolve.AbstractWebsitePageResolver;
import run.halo.app.handler.postimport.resolve.CNBlogsWebsitePageResolver;
import run.halo.app.handler.postimport.resolve.CSDNWebsitePageResolver;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.Objects;

/**
 * @author liujie
 * @time 2020/5/10 11:08 上午
 */
@Component
public class PostImportHandler implements ApplicationContextAware {

    ApplicationContext applicationContext;

    /**
     * 记录
     */
    private Map<WebsiteType, AbstractWebsitePageResolver> websitePageResolverMap = null;

    @PostConstruct
    public void postConstruct() {
        websitePageResolverMap = Maps.newHashMap();

        Map<String, AbstractWebsitePageResolver> websitePageResolves = applicationContext.getBeansOfType(AbstractWebsitePageResolver.class);
        if (MapUtils.isEmpty(websitePageResolves)) {
            return;
        }

        websitePageResolves.forEach((key, value) -> {
            if (Objects.isNull(value)) {
                return;
            }

            websitePageResolverMap.put(value.websiteType(), value);
        });
    }
    /**
     * 解析指定网站的指定页面
     */
    public String resolveWebsitePage(WebsiteType webSiteType, String pageUrl) {
        Preconditions.checkNotNull(webSiteType, "网站类型信息不能为空");
        Preconditions.checkArgument(StringUtils.isNotBlank(pageUrl), "网页地址信息不能为空");
        return websitePageResolverMap.get(webSiteType).resolveWebsitePage(pageUrl);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
