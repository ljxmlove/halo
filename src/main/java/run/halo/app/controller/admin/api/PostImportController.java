package run.halo.app.controller.admin.api;

import cn.hutool.core.util.IdUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import run.halo.app.cache.AbstractStringCacheStore;
import run.halo.app.model.dto.post.BasePostDetailDTO;
import run.halo.app.model.dto.post.BasePostMinimalDTO;
import run.halo.app.model.dto.post.BasePostSimpleDTO;
import run.halo.app.model.entity.Post;
import run.halo.app.model.enums.PostPermalinkType;
import run.halo.app.model.enums.PostStatus;
import run.halo.app.model.params.PostContentParam;
import run.halo.app.model.params.PostImportParam;
import run.halo.app.model.params.PostParam;
import run.halo.app.model.params.PostQuery;
import run.halo.app.model.support.BaseResponse;
import run.halo.app.model.vo.PostDetailVO;
import run.halo.app.service.OptionService;
import run.halo.app.service.PostImportService;
import run.halo.app.service.PostService;

import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.springframework.data.domain.Sort.Direction.DESC;

/**
 * Post controller.
 *
 * @author liujie
 */
@RestController
@RequestMapping("/api/admin/posts/import")
public class PostImportController {

    @Autowired
    private PostImportService postImportService;


    @GetMapping
    @ApiOperation("Lists posts")
    public BaseResponse<String> postImportWebsitePage(PostImportParam postImportParam) {
        return BaseResponse.ok("成功", postImportService.resolveImportWebsitePageContent(postImportParam));
    }

}
