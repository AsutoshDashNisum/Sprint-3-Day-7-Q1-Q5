package com.example.calculator;

public class AsuUserServiceQ3 {
    public void validateAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Underage");
        }
    }
}
