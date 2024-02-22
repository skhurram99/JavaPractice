package com.practice.classes;

import com.practice.interfaces.RectangleArea;

/*
default method let us extend the functionality of existing interfaces
without enforcing any change to the classes that have already implemented them.

 */
public class CalculateArea implements RectangleArea {

    @Override
    public int area(int length, int width) {
        return 0;
    }

    @Override
    public int area(int length, int width, int margin) {
        return 0;
    }
}
