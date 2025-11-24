package Basics;

// Abstract class Shape is created to define a common interface for all shapes.
// It contains an abstract method calculateArea which must be implemented by all subclasses.
// The subclasses Circle, Rectangle, and Square implement the calculateArea method
// according to their specific formulas for area calculation.
// The main method demonstrates polymorphism by creating instances of different shapes
// and calling the calculateArea method on them.
abstract class Shape {
    abstract int calculateArea(int length, int breadth);
}

class Circle extends Shape {
    int calculateArea(int length, int breadth) {
        if (length != breadth) {
            throw new IllegalArgumentException("For a circle, provide the same value for length and breadth as the radius.");
        }
        return (int) (Math.PI * length * length);
    }
}
class Rectangle extends Shape {
    int calculateArea(int length, int breadth) {
        return length * breadth;
    }
}
class Square extends Shape {
    int calculateArea(int length, int breadth) {
        if (length != breadth) {
            throw new IllegalArgumentException("For a square, length and breadth must be equal.");
        }
        return length * length;
    }
}
public class Encapsulation {
    public static void main(String[] args) {
        Shape circle = new Circle(); // Polymorphism
        Shape rectangle = new Rectangle();
        Shape square = new Square();
        int length = 4;
        int breadth = 6;

        System.out.println("Area of Circle: " + circle.calculateArea(length, length));
        System.out.println("Area of Rectangle: " + rectangle.calculateArea(length, breadth));
        System.out.println("Area of Square: " + square.calculateArea(length, length));
        
    }
}
