package com.qhx.controller.util;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Rest<E> {
    private E data;
    private Integer code;
    private String mes;

    public Rest(E data, Integer code, String mes) {
        this.data = data;
        this.code = code;
        this.mes = mes;
    }

    public Rest(E data, Integer code) {
        this.data = data;
        this.code = code;
    }

    public Rest() {
    }
}
