package InternshipTask3;

abstract class User {
    protected String name;

    public User(String name) {
        this.name = name;
    }

    public abstract void displayRole(); // Abstract method

    public String getName() {
        return name;
    }
}

class Student extends User {
    public Student(String name) {
        super(name);
    }

    @Override
    public void displayRole() {
        System.out.println(name + " is a Student.");
    }
}

class Teacher extends User {
    public Teacher(String name) {
        super(name);
    }

    @Override
    public void displayRole() {
        System.out.println(name + " is a Teacher.");
    }
}
