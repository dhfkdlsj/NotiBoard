package miniproject.notiboard.api.presentation.controller.post;

import lombok.RequiredArgsConstructor;
import miniproject.notiboard.api.business.post.PostManigingUsecase;
import miniproject.notiboard.api.business.post.dto.request.AddPostReq;
import miniproject.notiboard.api.business.post.dto.response.AddPostResp;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    // GET 요청을 처리하여 addPost.html을 렌더링
    @GetMapping("/add")
    public String showAddPostPage(Model model) {
        return "addPost"; // addPost.html을 렌더링
    }
}
