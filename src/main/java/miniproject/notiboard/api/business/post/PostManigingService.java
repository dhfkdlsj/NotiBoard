package miniproject.notiboard.api.business.post;

import lombok.RequiredArgsConstructor;
import miniproject.notiboard.api.business.post.dto.request.AddPostReq;
import miniproject.notiboard.api.business.post.dto.request.UpdatePostReq;
import miniproject.notiboard.api.business.post.dto.response.*;
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
    public void addPost(AddPostReq req) {
        postManager.addPost(req);
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
    public void updatePost(Long postId, UpdatePostReq req) {
        postManager.checkExistsPost(postId);
        postManager.updatePost(postId, req);
    }

    @Override
    @Transactional
    public void deletePost(Long postId) {
        postManager.checkExistsPost(postId);
        postManager.deletePost(postId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SearchPostsResp> searchPosts(String title) {
        postManager.checkExistsPost(title);
        List<Post> posts = postManager.searchPosts(title);
        return postDtoMapper.toSearchPostsResp(posts);
    }

}
