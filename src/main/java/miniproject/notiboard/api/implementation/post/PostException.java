package miniproject.notiboard.api.implementation.post;

import miniproject.notiboard.exception.BaseException;
import miniproject.notiboard.exception.ExceptionType;

public class PostException extends BaseException {

    public PostException(ExceptionType exceptionType) {
        super(exceptionType);
    }
}

