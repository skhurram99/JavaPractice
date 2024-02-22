import com.practice.classes.CalculateArea;
import com.practice.interfaces.RectangleArea;

public class Main {
    public static void main(String[] args) {
        RectangleArea calArea = new RectangleArea() {
            @Override
            public int area(int length, int width) {
                return length*width;
            }

            @Override
            public int area(int length, int width, int margin) {
                return 0;
            }
        };



        //RectangleArea calculateAreaLam = (l,b) -> l*b;

        //System.out.println(calArea.area(10,30));

        System.out.println(RectangleArea.calculateArea());

    }
}