package exercise0;

class Chair{
    static final String name = "Chair";
    String color, vendor, material;
    int year;
    double price, weight, width, height, max_load;

    public Chair(){
        System.out.println("Creation of object of class " + name);
    }

    public void printColor(){
        System.out.println(color);
    }

    public void printVendor(){
        System.out.println(vendor);
    }

    public double getPrice(){
        return price;
    }
}

class Table{
    static final String name = "Table";
    String color, vendor, material, usage;
    int year;
    double price, weight, length, width, height;

    public Table(){
        System.out.println("Creation of object of class " + name);
    }

    public void printColor(){
        System.out.println(color);
    }

    public void printVendor(){
        System.out.println(vendor);
    }

    public void printUsage(){
        System.out.println(usage);
    }

    public double getPrice(){
        return price;
    }
}

class Monitor{
    static final String name = "Monitor";
    String color, vendor, material;
    int year, resolution;
    double price, weight, length, width, height;
    boolean isRotate;

    public Monitor(){
        System.out.println("Creation of object of class " + name);
    }

    public void printColor(){
        System.out.println(color);
    }

    public void printVendor(){
        System.out.println(vendor);
    }

    public double getPrice(){
        return price;
    }
}

class Lamp{
    static final String name = "lamp";
    String style, brand, material;
    int year;
    boolean isOn;
    double price, length, height;
    public Lamp() {
        System.out.println("Creation of object of class " + name);
    }
    public void printStyle() {
        System.out.println(style);
    }
    public void printBrand() {
        System.out.println(brand);
    }
    public double getPrice() {
        return price;
    }

}


class Door{
    static final String name = "door";
    String style, brand, material;
    int year;
    boolean isOn;
    double price, length, height;
    public Door() {
        System.out.println("Creation of object of class " + name);
    }
    public void printStyle() {
        System.out.println(style);
    }
    public void printBrand() {
        System.out.println(brand);
    }
    public double getPrice() {
        return price;
    }


}

class Student{
    static final String name = "student";
    String sex;
    int age, totalMarks;
    boolean wearGlasses;
    double weight, height, score;
    public Student() {
        System.out.println("Creation of object of class " + name);
    }
    public void printAge() {
        System.out.println(age);
    }
    public void printScore() {
        System.out.println(score);
    }
    public double getHeight() {
        return height;
    }


}

class Car{
    static final String name = "car";
    String style, brand, material, color;
    int year;
    boolean isOn;
    double price, weight;
    public Car() {
        System.out.println("Creation of object of class " + name);
    }
    public void printStyle() {
        System.out.println(style);
    }
    public void printBrand() {
        System.out.println(brand);
    }
    public double getPrice() {
        return price;
    }


}

class House{
    static final String name = "house";
    String style, material, structure;
    int year;
    boolean isOpen;
    double price, length, height;
    public House() {
        System.out.println("Creation of object of class " + name);
    }
    public void printStyle() {
        System.out.println(style);
    }
    public void printMaterial() {
        System.out.println(material);
    }
    public double getPrice() {
        return price;
    }

    class Room{
        static final String name = "room";
        String style, material;
        int year;
        boolean isMasterRoom;
        double price, length, height, width;
        public Room() {
            System.out.println("Creation of object of class " + name);
        }
        public void printStyle() {
            System.out.println(style);
        }
        public void pringYear() {
            System.out.println(year);
        }
        public double getPrice() {
            return price;
        }


    }

    class Floor{
        static final String name = "floor";
        String style, brand, material;
        int year;
        boolean isSlip;
        double price, length, height, width;
        public Floor() {
            System.out.println("Creation of object of class " + name);
        }
        public void printStyle() {
            System.out.println(style);
        }
        public void printBrand() {
            System.out.println(brand);
        }
        public double getPrice() {
            return price;
        }


    }

}

public class Exercise_0 {
    public static void main(String[] args) {
        Chair chair1 = new Chair();
        Chair chair2 = new Chair();
        Chair chair3 = new Chair();
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        Door door1 = new Door();
        Door door2 = new Door();
        Door door3 = new Door();
        House house1 = new House();
        House house2 = new House();
        House house3 = new House();
        Lamp lamp1 = new Lamp();
        Lamp lamp2 = new Lamp();
        Lamp lamp3 = new Lamp();
        Monitor monitor1 = new Monitor();
        Monitor monitor2 = new Monitor();
        Monitor monitor3 = new Monitor();
        Student student1 = new Student();
        Student student2 = new Student();
        Student student3 = new Student();
        Table table1 = new Table();
        Table table2 = new Table();
        Table table3 = new Table();
        House.Room room1 = house1.new Room();
        House.Room room2 = house2.new Room();
        House.Room room3 = house3.new Room();
        House.Floor floor1 = house1.new Floor();
        House.Floor floor2 = house2.new Floor();
        House.Floor floor3 = house3.new Floor();


    }
}
