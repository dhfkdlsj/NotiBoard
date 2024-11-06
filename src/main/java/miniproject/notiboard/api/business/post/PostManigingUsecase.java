package miniproject.notiboard.api.business.post;

import miniproject.notiboard.api.business.post.dto.request.AddPostReq;
import miniproject.notiboard.api.business.post.dto.response.AddPostResp;
import miniproject.notiboard.api.business.post.dto.response.ViewPostsDetailResp;
import miniproject.notiboard.api.business.post.dto.response.ViewPostsResp;

import java.util.List;

public interface PostManigingUsecase {
    AddPostResp addPost(AddPostReq req);
    List<ViewPostsResp> viewPosts();
    ViewPostsDetailResp viewPostsDetail(Long postId);
}
