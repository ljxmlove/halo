package run.halo.app.handler.postimport.resolve;

import com.google.common.base.Preconditions;
import com.vladsch.flexmark.html2md.converter.FlexmarkHtmlConverter;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import run.halo.app.handler.postimport.WebsiteType;

import java.net.URL;
import java.util.Objects;

/**
 * @author liujie
 * @time 2020/5/10 11:15 上午
 */
public abstract class AbstractWebsitePageResolver {


    @SneakyThrows
    public String resolveWebsitePage(String pageUrl) {
        Preconditions.checkArgument(StringUtils.isNotBlank(pageUrl), "网页地址信息不能为空");

        Document doc = Jsoup.parse(new URL(pageUrl), 2000);
        Element postContentElement = doExtractWebsitePagePostContent(doc);
        if (Objects.isNull(postContentElement)) {
            return null;
        }
        return FlexmarkHtmlConverter.builder().build().convert(postContentElement.html());
    }

    /**
     * 获取博客正文
     */
    protected abstract Element doExtractWebsitePagePostContent(Document doc );

    /**
     * 网站类型
     * @return
     */
    public abstract WebsiteType websiteType();

}
