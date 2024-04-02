package com.example.factory.adapter.web.errors;

import lombok.Getter;

@Getter
public class MethodNotAllowedException extends RuntimeException{
    private int code = 502;
    private String message = "Method Not Allowed";
}
