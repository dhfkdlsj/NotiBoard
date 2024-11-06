package miniproject.notiboard.api.presentation.controller.dummy;

import lombok.RequiredArgsConstructor;
import miniproject.notiboard.api.business.dummy.DummyUsecase;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/dummys")
@RequiredArgsConstructor
public class DummyController {

    private final DummyUsecase dummyUsecase;

}
