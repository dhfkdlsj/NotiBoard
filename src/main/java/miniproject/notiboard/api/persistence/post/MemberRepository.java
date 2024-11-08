package miniproject.notiboard.api.persistence.post;

import miniproject.notiboard.jpa.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<Member, Long> {
    @Query("SELECT m FROM Member m WHERE m.name = :memberName")
    Member findByName(@Param("memberName") String memberName);
}
