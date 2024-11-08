package miniproject.notiboard.api.persistence.post;

import miniproject.notiboard.jpa.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("SELECT p FROM Post p WHERE p.title LIKE CONCAT('%', :title, '%')")
    List<Post> findByTitle(@Param("title") String title);

    @Query("SELECT p FROM Post p JOIN FETCH p.member WHERE p.title LIKE CONCAT('%', :title, '%')")
    List<Post> findByTitleContaining(@Param("title") String title);
}
