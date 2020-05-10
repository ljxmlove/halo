package run.halo.app.service;

import run.halo.app.model.params.PostImportParam;

/**
 * @author liujie
 * @time 2020/5/10 10:51 上午
 */
public interface PostImportService {
    /**
     * 根据请求参数解析MD格式的文本信息
     */
    String resolveImportWebsitePageContent(PostImportParam postImportParam);
}
