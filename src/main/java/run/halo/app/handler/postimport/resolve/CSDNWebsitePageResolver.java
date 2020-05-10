package run.halo.app.handler.postimport.resolve;

import org.springframework.stereotype.Component;
import run.halo.app.handler.postimport.extract.HTML2Md;

import java.io.IOException;
import java.net.URL;

/**
 * @author liujie
 * @time 2020/5/10 12:05 下午
 */
@Component
public class CSDNWebsitePageResolver extends AbstractWebsitePageResolver {
    @Override
    protected String doResolveWebsitePage(String pageUrl) {
        try {
            return HTML2Md.create(document -> document.getElementById("article_content")).convert(new URL(pageUrl), 3000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
