package miniproject.notiboard.api.implementation.dummy;

import lombok.RequiredArgsConstructor;
import miniproject.notiboard.api.persistence.dummy.DummyRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DummyManager {

    private final DummyRepository dummyRepository;
}
