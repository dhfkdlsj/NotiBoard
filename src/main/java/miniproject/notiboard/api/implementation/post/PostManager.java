package miniproject.notiboard.api.implementation.post;

import lombok.RequiredArgsConstructor;
import miniproject.notiboard.api.business.post.dto.request.AddPostReq;
import miniproject.notiboard.api.persistence.post.PostRepository;
import miniproject.notiboard.jpa.member.Member;
import miniproject.notiboard.jpa.post.Post;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostManager {

    private final PostRepository postRepository;

    public Post addPost(AddPostReq req) {
        Member member = postRepository.findByName(req.memberName());
        Post newPost = Post.builder()
                .title(req.title())
                .content(req.content())
                .member(member)
                .build();
        return postRepository.save(newPost);
    }
}
