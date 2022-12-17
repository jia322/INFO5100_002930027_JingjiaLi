package exercise5;

// class for builder pattern
class Employee{
    private String company;
    private String name;
    private int id;

    public Employee setCompany(String name)
    {
        this.company = name;
        return this;
    }

    public Employee setName(String name)
    {
        this.name = name;
        return this;
    }

    public Employee setId(int id)
    {
        this.id = id;
        return this;
    }


    @Override
    public String toString()
    {
        return String.format("Employee: company=%s, name=%s, id=%s",this.company, this.name, this.id);
    }
}

// class for singleton pattern
class Sun {
    private static Sun instance = null;

    public String name;

    private Sun()
    {
        name = "singleton class for the Sun";
    }

    public static Sun getInstance()
    {
        if (instance == null)
            instance = new Sun();
        return instance;
    }
}

// classes for factory method pattern
abstract class Student{
    protected String role;

    abstract String getRole();

}

class FulltimeStudent extends Student{
    //@override
    public String getRole(){
        role = "full-time";
        return role;
    }
}

class ParttimeStudent extends Student{
    //@override
    public String getRole(){
        role = "part-time";
        return role;
    }
}

class StudentFactory{
    public Student getStudent(String role){
        if (role == null){
            return null;
        }
        if (role == "Full-Time"){
            return new FulltimeStudent();
        }
        else if (role == "Part-Time"){
            return new ParttimeStudent();
        }
        else{
            return null;
        }
    }
}

public class Exercise_5 {
    public static void main(String[] args) {
        // test for builder pattern
        System.out.println("Test for builder pattern: ");
        Employee a = new Employee();
        a.setCompany("google").setName("AA").setId(1001);
        System.out.println(a);

        System.out.println("");

        // test for singleton pattern, we can see x and y point to same class Sun object based on test printout
        System.out.println("Test for Singleton pattern: ");
        Sun x = Sun.getInstance();
        Sun y = Sun.getInstance();
        System.out.println("Singleton Sun instance x: "
                + x.hashCode());
        System.out.println("Singleton Sun instance y: "
                + y.hashCode());

        System.out.println("");


        // test for factory design pattern
        StudentFactory student_factory = new StudentFactory();
        Student student_1 = student_factory.getStudent("Full-Time");
        System.out.println("The role for student 1 is " + student_1.getRole());
        Student student_2 = student_factory.getStudent("Part-Time");
        System.out.println("The role for student 2 is " + student_2.getRole());

    }
}