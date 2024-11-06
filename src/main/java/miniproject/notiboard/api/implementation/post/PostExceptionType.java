package miniproject.notiboard.api.implementation.post;

import lombok.AllArgsConstructor;
import miniproject.notiboard.exception.ExceptionType;
import miniproject.notiboard.exception.Status;

@AllArgsConstructor
public enum PostExceptionType implements ExceptionType {

    POST_NOT_FOUND_EXCEPTION(Status.NOT_FOUND, "게시을를 찾을 수 없습니다.");

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