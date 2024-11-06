package miniproject.notiboard.api.business.dummy;

import lombok.RequiredArgsConstructor;
import miniproject.notiboard.api.implementation.dummy.DummyManager;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DummyService implements DummyUsecase{

    private final DummyManager dummyManager;
}
