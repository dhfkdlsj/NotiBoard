package miniproject.notiboard.api.business.post;

import lombok.RequiredArgsConstructor;
import miniproject.notiboard.api.business.post.dto.request.AddPostReq;
import miniproject.notiboard.api.business.post.dto.response.AddPostResp;
import miniproject.notiboard.api.business.post.dto.response.ViewPostsDetailResp;
import miniproject.notiboard.api.business.post.dto.response.ViewPostsResp;
import miniproject.notiboard.api.implementation.post.PostManager;
import miniproject.notiboard.api.implementation.post.mapper.PostDtoMapper;
import miniproject.notiboard.jpa.post.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostManigingService implements PostManigingUsecase{

    private final PostManager postManager;
    private final PostDtoMapper postDtoMapper;

    @Override
    public AddPostResp addPost(AddPostReq req) {
        Post newPost = postManager.addPost(req);
        return postDtoMapper.toAddPostResp(newPost);
    }

    @Override
    public List<ViewPostsResp>   viewPosts() {
        List<Post> posts = postManager.viewPost();
        return postDtoMapper.toViewPostsResp(posts);
    }

    @Override
    public ViewPostsDetailResp viewPostsDetail(Long postId) {
        return null;
    }

}
