package run.halo.app.handler.postimport.resolve;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;

/**
 * @author liujie
 * @time 2020/5/10 11:15 上午
 */
public abstract class AbstractWebsitePageResolver {


    public String resolveWebsitePage(String pageUrl) {
        Preconditions.checkArgument(StringUtils.isNotBlank(pageUrl), "网页地址信息不能为空");

        return doResolveWebsitePage(pageUrl);
    }

    protected abstract String doResolveWebsitePage(String pageUrl);

}
