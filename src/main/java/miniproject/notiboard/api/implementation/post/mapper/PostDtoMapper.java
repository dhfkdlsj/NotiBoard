package miniproject.notiboard.api.implementation.post.mapper;

import miniproject.notiboard.api.business.post.dto.response.*;
import miniproject.notiboard.jpa.post.Post;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PostDtoMapper {

    public List<ViewPostsResp> toViewPostsResp(List<Post> posts) {
        return posts.stream()
                .map(post -> new ViewPostsResp(
                        post.getTitle(),
                        post.getId()
                ))
                .collect(Collectors.toList());
    }

    public ViewPostsDetailResp toViewPostDetailResp(Post post) {
        return new ViewPostsDetailResp(post.getId(), post.getTitle(), post.getContent());
    }
}
