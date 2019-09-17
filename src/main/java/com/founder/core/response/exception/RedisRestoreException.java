package com.founder.core.response.exception;

public class RedisRestoreException extends RuntimeException {
    private static final String MSG_FMT = "Redis exception occurs in service %s.";

    public RedisRestoreException(String serviceName) {
        super(String.format(MSG_FMT, serviceName));
    }
}
