package com.usecase.response;

import com.usecase.errorcode.ErrorCode;

public class ErrorResponse implements Response {

    String errorMessage;
    ErrorCode errorCode;
    boolean status;

    public ErrorResponse(String errorMessage, ErrorCode errorCode, boolean status) {
        super();
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Response [errorMessage=" + errorMessage + ", errorCode=" + errorCode + ", status=" + status + "]";
    }

}
