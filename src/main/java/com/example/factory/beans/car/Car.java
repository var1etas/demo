package com.example.factory.beans.car;


import lombok.NonNull;

public interface Car {
    Boolean inStock = true;

    public void postConstruct();

}
