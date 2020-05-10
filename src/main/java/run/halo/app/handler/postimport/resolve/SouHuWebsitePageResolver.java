package run.halo.app.handler.postimport.resolve;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;
import run.halo.app.handler.postimport.WebsiteType;


/**
 * @author liujie
 * @time 2020/5/10 12:05 下午
 */
@Component
public class SouHuWebsitePageResolver extends AbstractWebsitePageResolver {

    @Override
    protected Element doExtractWebsitePagePostContent(Document doc) {
        return doc.getElementsByTag("article").first();
    }

    @Override
    public WebsiteType websiteType() {
        return WebsiteType.SOU_HU;
    }
}
