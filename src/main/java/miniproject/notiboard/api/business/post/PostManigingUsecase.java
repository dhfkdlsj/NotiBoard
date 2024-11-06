package miniproject.notiboard.api.business.post;

import miniproject.notiboard.api.business.post.dto.request.AddPostReq;
import miniproject.notiboard.api.business.post.dto.response.AddPostResp;
import miniproject.notiboard.jpa.member.Member;

public interface PostManigingUsecase {
    AddPostResp addPost(AddPostReq req);
}
