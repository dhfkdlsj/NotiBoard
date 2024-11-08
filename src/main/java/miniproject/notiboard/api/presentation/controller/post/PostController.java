package miniproject.notiboard.api.presentation.controller.post;

import lombok.RequiredArgsConstructor;
import miniproject.notiboard.api.business.post.PostManigingUsecase;
import miniproject.notiboard.api.business.post.dto.request.AddPostReq;
import miniproject.notiboard.api.business.post.dto.request.UpdatePostReq;
import miniproject.notiboard.api.business.post.dto.response.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostManigingUsecase postManigingUsecase;

    @PostMapping("/add")
    public ResponseEntity<String> addPost(@RequestBody AddPostReq req) {
        postManigingUsecase.addPost(req);
        return ResponseEntity.ok("성공적으로 " + req.title() + " 이(가) 게시되었습니다.");
    }

    @GetMapping("/view")
    public ResponseEntity<List<ViewPostsResp>> viewPosts() {
        List<ViewPostsResp> posts = postManigingUsecase.viewPosts();
        return ResponseEntity.ok(posts);
    }

    @PatchMapping("/update/{postId}")
    public ResponseEntity<String> updatePost(@PathVariable Long postId, @RequestBody UpdatePostReq req) {
        postManigingUsecase.updatePost(postId, req);
        return ResponseEntity.ok("성공적으로 " + postId + " 번 게시글이 수정되었습니다.");
    }

    @GetMapping("/view/{postId}")
    public ResponseEntity<ViewPostsDetailResp> showPostDetailPage(@PathVariable Long postId) {
        ViewPostsDetailResp resp = postManigingUsecase.viewPostsDetail(postId);
        return ResponseEntity.ok(resp);
    }

    @DeleteMapping("/delete/{postId}")
    public ResponseEntity<String> deletePost(@PathVariable Long postId) {
        postManigingUsecase.deletePost(postId);
        return ResponseEntity.ok("성공적으로 " + postId+ " 번 게시글이 삭제되었습니다.");
    }

    @GetMapping("/search")
    public ResponseEntity<List<SearchPostsResp>> searchPosts(@RequestParam String title) {
        List<SearchPostsResp> resp = postManigingUsecase.searchPosts(title);
        return ResponseEntity.ok(resp);
    }

}
