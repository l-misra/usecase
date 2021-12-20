package com.usecase.errorcode;

public enum ErrorCode {

    INVALID_INPUT("1111", "INVALID_INPUT"), UNKNOWN_ERROR("2222", "UNKNOWN_ERROR");

    private final String errorCode;
    private final String errorMessage;

    ErrorCode(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
