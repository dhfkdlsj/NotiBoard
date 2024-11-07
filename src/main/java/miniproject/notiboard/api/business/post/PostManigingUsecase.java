package miniproject.notiboard.api.business.post;

import miniproject.notiboard.api.business.post.dto.request.AddPostReq;
import miniproject.notiboard.api.business.post.dto.request.UpdatePostReq;
import miniproject.notiboard.api.business.post.dto.response.*;

import java.util.List;

public interface PostManigingUsecase {
    void addPost(AddPostReq req);
    List<ViewPostsResp> viewPosts();
    ViewPostsDetailResp viewPostsDetail(Long postId);
    void updatePost(Long postId, UpdatePostReq req);
    void deletePost(Long postId);
}
