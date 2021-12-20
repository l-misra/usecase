package com.usecase.response;

public class SuccessResponse implements Response {

    private String message;
    private boolean status;
    private Object object;

    public SuccessResponse(String message, boolean status, Object object) {
        super();
        this.message = message;
        this.status = status;
        this.object = object;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "Response [message=" + message + ", status=" + status + ", object=" + object + "]";
    }

}
