package miniproject.notiboard.jpa.dummy;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import miniproject.notiboard.jpa.config.BaseEntity;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Dummy extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
