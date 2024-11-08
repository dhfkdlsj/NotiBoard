package miniproject.notiboard.api.implementation.post;

import lombok.RequiredArgsConstructor;
import miniproject.notiboard.api.business.post.dto.request.AddPostReq;
import miniproject.notiboard.api.business.post.dto.request.UpdatePostReq;
import miniproject.notiboard.api.persistence.post.MemberRepository;
import miniproject.notiboard.api.persistence.post.PostRepository;
import miniproject.notiboard.jpa.member.Member;
import miniproject.notiboard.jpa.post.Post;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PostManager {

    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    public Post addPost(AddPostReq req) {
        Member member = memberRepository.findByName(req.memberName());
        Post newPost = Post.builder()
                .title(req.title())
                .content(req.content())
                .member(member)
                .build();
        return postRepository.save(newPost);
    }

    public List<Post> viewPost() {
        return postRepository.findAll();
    }

    public Post viewPostDetail(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new PostException(PostExceptionType.POST_NOT_FOUND_EXCEPTION));
    }

    public void updatePost(Long postId, UpdatePostReq req) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new PostException(PostExceptionType.POST_NOT_FOUND_EXCEPTION));
        post.updatePost(req.title(),req.content());
    }

    public void checkExistsPost(Long postId) {
        postRepository.findById(postId)
                .orElseThrow(() -> new PostException(PostExceptionType.POST_NOT_FOUND_EXCEPTION));
    }

    public void checkExistsPost(String title) {
        List<Post> posts = postRepository.findByTitle(title);
        if (posts.size() <= 0) {
            throw new PostException(PostExceptionType.SEARCH_POST_NOT_FOUNT_EXCEPTION);
        }
    }

    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }

    public List<Post> searchPosts(String title) {
        return postRepository.findByTitleContaining(title);
    }
}
