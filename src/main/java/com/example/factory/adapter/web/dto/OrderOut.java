package com.example.factory.adapter.web.dto;

public record OrderOut(Float price, Info info){
    public record Info(Long id, String date){}
}
