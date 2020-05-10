package run.halo.app.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import run.halo.app.exception.BadRequestException;
import run.halo.app.handler.postimport.PostImportHandler;
import run.halo.app.model.params.PostImportParam;
import run.halo.app.service.PostImportService;

import java.util.Objects;

/**
 * @author liujie
 * @time 2020/5/10 10:51 上午
 */
@Service
public class PostImportServiceImpl implements PostImportService {

    @Autowired
    PostImportHandler postImportHandler;

    @Override
    public String resolveImportWebsitePageContent(PostImportParam postImportParam) {
        if (Objects.isNull(postImportParam.getImportWebsiteType())
                || StringUtils.isBlank(postImportParam.getImportWebsiteUrl())) {
            throw new BadRequestException("参数信息错误");
        }

        return postImportHandler.resolveWebsitePage(postImportParam.getImportWebsiteType(), postImportParam.getImportWebsiteUrl());
    }
}
