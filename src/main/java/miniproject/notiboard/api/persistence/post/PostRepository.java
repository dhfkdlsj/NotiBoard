package miniproject.notiboard.api.persistence.post;

import miniproject.notiboard.jpa.member.Member;
import miniproject.notiboard.jpa.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PostRepository extends JpaRepository<Post, Long> {
    @Query("SELECT m FROM Member m WHERE m.name = :memberName")
    Member findByName(@Param("memberName") String memberName);
}
