package exercise3;

import java.io.*;

abstract class Shape implements Serializable{

    //Demonstrate abstraction
    public abstract double calculateArea();
    //Demonstrate abstraction
    public abstract double calculatePerimeter();
}

class Triangle extends Shape {
    public double width, height, side_a, side_b, side_c;

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

class Rectangle extends Shape {
    public double width, length;

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

class Circle extends Shape {
    public double radius;
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

class Square extends Shape {
    public double side;

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

public class Exercise_3 {
    public static void main(String[] args) {
        // for this exercise, we use Triangle class as example, other classed should be similar

        Triangle triangle = new Triangle(2.0, 2.0, 1.0, 2.0, 3.0);

        // test of serialization
        String filename = triangle.name;
        try
        {
            //Saving of triangle object in a file
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
            // Method for serialization of object
            out.writeObject(triangle);
            out.close();
            file.close();
            System.out.println(triangle.name + " object has been serialized");
        }
        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }

        // test of deserialization
        Triangle object1 = null;
        try
        {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            object1 = (Triangle)in.readObject();

            in.close();
            file.close();

            System.out.println(triangle.name + " object has been deserialized");
            System.out.println("a = " + object1.side_a);
            System.out.println("b = " + object1.side_b);
            System.out.println("a = " + object1.side_c);
        }

        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }

        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
        }
    }
}
