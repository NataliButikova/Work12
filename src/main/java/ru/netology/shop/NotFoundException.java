package ru.netology.shop;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String s) {
        super(s);
    }
}