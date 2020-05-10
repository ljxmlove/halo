package run.halo.app.model.params;

import lombok.Data;
import run.halo.app.handler.postimport.WebsiteType;

/**
 * @author liujie
 * @time 2020/5/10 10:48 上午
 */
@Data
public class PostImportParam {

    /**
     * 网站类型
     */
    private WebsiteType importWebsiteType;

    /**
     * 导入的网页地址
     */
    private String importWebsiteUrl;
}
