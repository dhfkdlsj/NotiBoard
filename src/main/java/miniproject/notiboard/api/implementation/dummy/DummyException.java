package miniproject.notiboard.api.implementation.dummy;

import miniproject.notiboard.exception.BaseException;
import miniproject.notiboard.exception.ExceptionType;

public class DummyException extends BaseException {

    public DummyException(ExceptionType exceptionType) {
        super(exceptionType);
    }
}
