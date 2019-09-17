package com.founder.core.response.exception;

public class ErrorParamInputException extends RuntimeException {
    private static final String msg = "input param error.";
    public ErrorParamInputException() {
        super(msg);
    }
}
