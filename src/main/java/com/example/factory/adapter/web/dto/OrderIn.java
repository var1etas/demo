package com.example.factory.adapter.web.dto;

public record OrderIn(Float price, Info info){
    public record Info(String date){}
}
