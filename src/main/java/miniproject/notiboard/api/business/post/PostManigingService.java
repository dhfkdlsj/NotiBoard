package miniproject.notiboard.api.business.post;

import lombok.RequiredArgsConstructor;
import miniproject.notiboard.api.business.post.dto.request.AddPostReq;
import miniproject.notiboard.api.business.post.dto.request.UpdatePostReq;
import miniproject.notiboard.api.business.post.dto.response.AddPostResp;
import miniproject.notiboard.api.business.post.dto.response.UpdatePostResp;
import miniproject.notiboard.api.business.post.dto.response.ViewPostsDetailResp;
import miniproject.notiboard.api.business.post.dto.response.ViewPostsResp;
import miniproject.notiboard.api.implementation.post.PostManager;
import miniproject.notiboard.api.implementation.post.mapper.PostDtoMapper;
import miniproject.notiboard.jpa.post.Post;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostManigingService implements PostManigingUsecase{

    private final PostManager postManager;
    private final PostDtoMapper postDtoMapper;

    @Override
    @Transactional
    public AddPostResp addPost(AddPostReq req) {
        Post newPost = postManager.addPost(req);
        return postDtoMapper.toAddPostResp(newPost);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ViewPostsResp> viewPosts() {
        List<Post> posts = postManager.viewPost();
        return postDtoMapper.toViewPostsResp(posts);
    }

    @Override
    @Transactional(readOnly = true)
    public ViewPostsDetailResp viewPostsDetail(Long postId) {
        Post post = postManager.viewPostDetail(postId);
        return postDtoMapper.toViewPostDetailResp(post);
    }

    @Override
    @Transactional
    public UpdatePostResp updatePost(Long postId, UpdatePostReq req) {
        postManager.checkExistsPost(postId);
        postManager.updatePost(postId, req);
        return postDtoMapper.toUpdatePostResp(req);
    }

}
