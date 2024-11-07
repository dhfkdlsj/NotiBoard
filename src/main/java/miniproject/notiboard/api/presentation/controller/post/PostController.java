package miniproject.notiboard.api.presentation.controller.post;

import lombok.RequiredArgsConstructor;
import miniproject.notiboard.api.business.post.PostManigingUsecase;
import miniproject.notiboard.api.business.post.dto.request.AddPostReq;
import miniproject.notiboard.api.business.post.dto.request.UpdatePostReq;
import miniproject.notiboard.api.business.post.dto.response.AddPostResp;
import miniproject.notiboard.api.business.post.dto.response.UpdatePostResp;
import miniproject.notiboard.api.business.post.dto.response.ViewPostsDetailResp;
import miniproject.notiboard.api.business.post.dto.response.ViewPostsResp;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostManigingUsecase postManigingUsecase;

    @PostMapping("/add")
    public ResponseEntity<AddPostResp> addPost(@RequestBody AddPostReq addPostReq) {
        AddPostResp resp = postManigingUsecase.addPost(addPostReq);
        return ResponseEntity.ok(resp);
    }

    @GetMapping("/view")
    public ResponseEntity<List<ViewPostsResp>> viewPosts() {
        List<ViewPostsResp> posts = postManigingUsecase.viewPosts();
        return ResponseEntity.ok(posts);
    }

    @PatchMapping("/update/{postId}")
    public ResponseEntity<UpdatePostResp> updatePost(@PathVariable Long postId, @RequestBody UpdatePostReq req) {
        UpdatePostResp resp = postManigingUsecase.updatePost(postId, req);
        return ResponseEntity.ok(resp);
    }

    @GetMapping("/view/{postId}")
    public ResponseEntity<ViewPostsDetailResp> showPostDetailPage(@PathVariable Long postId, Model model) {
        ViewPostsDetailResp resp = postManigingUsecase.viewPostsDetail(postId);
        return ResponseEntity.ok(resp);
    }




}
