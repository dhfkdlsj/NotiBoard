package miniproject.notiboard.api.implementation.dummy;

import lombok.AllArgsConstructor;
import miniproject.notiboard.exception.ExceptionType;
import miniproject.notiboard.exception.Status;

@AllArgsConstructor
public enum DummyExceptionType implements ExceptionType {

    DUMMY_NOT_FOUND_EXCEPTION(Status.NOT_FOUND, "더미를 찾을 수 없습니다.");

    private final Status status;
    private final String message;

    @Override
    public Status status() {
        return null;
    }

    @Override
    public String message() {
        return "";
    }
}
