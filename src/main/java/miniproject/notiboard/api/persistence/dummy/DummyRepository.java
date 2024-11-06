package miniproject.notiboard.api.persistence.dummy;

import miniproject.notiboard.jpa.dummy.Dummy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DummyRepository extends JpaRepository<Dummy, Long> {
}
