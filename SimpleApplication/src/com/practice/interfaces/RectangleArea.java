package com.practice.interfaces;

public interface RectangleArea {

    public static int calculateArea(){
        return 10;
    }
    public int area(int length, int width);

    public int area(int length, int width, int margin);

    /*
    1. default method cannot have same method signature of other methods in this interface
     */
    default int area(){
        return 10;
    }

    default int anotherArea(){
        return 100;
    }



}
