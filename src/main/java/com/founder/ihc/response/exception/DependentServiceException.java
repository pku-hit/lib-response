package com.founder.ihc.response.exception;

/**
 * 公共异常
 */
public class DependentServiceException extends RuntimeException {
    private static final String MSG_FMT = "DependentService %s exception.";

    public DependentServiceException(String serviceName) {
        super(String.format(MSG_FMT, serviceName));
    }
}
