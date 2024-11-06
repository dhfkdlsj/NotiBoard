package miniproject.notiboard.api.presentation.controller.post;

import lombok.RequiredArgsConstructor;
import miniproject.notiboard.api.business.post.PostManigingUsecase;
import miniproject.notiboard.api.business.post.dto.request.AddPostReq;
import miniproject.notiboard.api.business.post.dto.response.AddPostResp;
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
        List<ViewPostsResp> posts = postManigingUsecase.viewPosts(); // 게시글 리스트 가져오기
        return ResponseEntity.ok(posts); // JSON 형식으로 반환
    }

    @GetMapping("/add")
    public String showAddPostPage(Model model) {
        return "addPost"; // addPost.html을 렌더링
    }

    @GetMapping("")
    public String showViewPostsPage(Model model) {
        return "viewPosts"; // viewPosts.html을 렌더링
    }
}
