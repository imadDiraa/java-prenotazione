package utils;

import java.io.Serializable;

public class Response implements Serializable {
    private String message;
    private int status;
    private Object result;

    public Response(String message, int status, Object result) {
        this.message = message;
        this.status = status;
        this.result = result;
    }

    public Response(String message, int status) {
        this.message = message;
        this.status = status;
        result = null;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
