package com.cine.model.response;

public class ApiResponse {

    private String mensaje;
    private Object data;

    public ApiResponse(String mensaje, Object data) {
        this.mensaje = mensaje;
        this.data = data;
    }

    public String getMensaje() { return mensaje; }
    public Object getData() { return data; }
}
