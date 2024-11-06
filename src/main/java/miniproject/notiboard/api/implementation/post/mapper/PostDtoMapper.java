package miniproject.notiboard.api.implementation.post.mapper;

import miniproject.notiboard.api.business.post.dto.response.AddPostResp;
import miniproject.notiboard.api.business.post.dto.response.ViewPostsResp;
import miniproject.notiboard.jpa.post.Post;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PostDtoMapper {

    public AddPostResp toAddPostResp(Post newPost) {
        return new AddPostResp("성공적으로 " + newPost.getMember().getName() + "이(가) 작성한 " + newPost.getTitle() + " 이(가) 등록되었습니다.");
    }

    public List<ViewPostsResp> toViewPostsResp(List<Post> posts) {
        return posts.stream()
                .map(post -> new ViewPostsResp(
                        post.getTitle()
                ))
                .collect(Collectors.toList());
    }
}
