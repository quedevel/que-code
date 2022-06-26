package com.quecode.chapter12;

import java.io.Serializable;
import java.util.Arrays;

public class Elvis implements Serializable {
    public static final Elvis INSTANCE = new Elvis();
    private Elvis(){}
    private Object readResolve() { return INSTANCE; }
    private String[] favoriteSongs = {"Gimme Gimme", "Bad"};
    public void print(){
        System.out.println(Arrays.toString(favoriteSongs));
    }
}
