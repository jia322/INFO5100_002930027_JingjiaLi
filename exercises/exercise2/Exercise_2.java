package exercise2;

abstract class Shape{

    //Demonstrate abstraction
    public abstract double calculateArea();
    //Demonstrate abstraction
    public abstract double calculatePerimeter();
}

class Triangle extends Shape{
    double width, height, side_a, side_b, side_c;

    public static String name = "triangle";

    //constructor
    public Triangle(double w, double h, double a, double b, double c){
        super();
        width = w;
        height = h;
        side_a = a;
        side_b = b;
        side_c = c;
    }

    // Demonstrate overiding of base class
    @Override
    public double calculateArea() {
        return width * height / 2;
    }

    // Demonstrate overiding of base class
    @Override
    public double calculatePerimeter() {
        return side_a + side_b + side_c;
    }
}

class Rectangle extends Shape{
    double width, length;

    public static String name = "rectangle";


    //constructor
    public Rectangle(double w, double l){
        super();
        width = w;
        length = l;
    }

    // Demonstrate overiding of base class
    @Override
    public double calculateArea() {
        return width * length;
    }

    // Demonstrate overiding of base class
    @Override
    public double calculatePerimeter() {
        return 2 * (width + length);
    }
}

class Circle extends Shape{
    double radius;
    private static final double PI = 3.1415926;

    public static String name = "circle";

    public Circle(double r){
        super();
        radius = r;
    }

    // Demonstrate overiding of base class
    @Override
    public double calculateArea() {
        return PI * radius * radius;
    }

    // Demonstrate overiding of base class
    @Override
    public double calculatePerimeter() {
        return 2 * PI * radius;
    }
}

class Square extends Shape{
    double side;

    public static String name = "square";

    public Square(double s) {
        super();
        side = s;
    }

    // Demonstrate overiding of base class
    @Override
    public double calculateArea() {
        return side * side;
    }

    // Demonstrate overiding of base class
    @Override
    public double calculatePerimeter() {
        return 4 * side;
    }
}

public class Exercise_2 {
    public static void main(String[] args) {
        // creat of child classes
        Triangle triangle = new Triangle(2.0, 2.0, 1.0, 2.0, 3.0);
        Rectangle rectangle = new Rectangle(2.0, 4.0);
        Circle circle = new Circle(4.0);
        Square square = new Square(4.0);

        // Java Polymorphism
        System.out.println("Demonstrate Java static field (Name) and Polymorphism (calculateArea() and calculatePerimeter())");
        System.out.println("The area of " + Triangle.name + " is: " + triangle.calculateArea());
        System.out.println("The area of " + Rectangle.name + " is: " +  rectangle.calculateArea());
        System.out.println("The area of " + Circle.name + " is: " +  circle.calculateArea());
        System.out.println("The area of " + Square.name + " is: " +  square.calculateArea());
        System.out.println();
        System.out.println("The perimeter of " + Triangle.name + " is: " + triangle.calculatePerimeter());
        System.out.println("The perimeter of " + Rectangle.name + " is: " +  rectangle.calculatePerimeter());
        System.out.println("The perimeter of " + Circle.name + " is: " +  circle.calculatePerimeter());
        System.out.println("The perimeter of " + Square.name + " is: " +  square.calculatePerimeter());
        System.out.println();
    }
}
