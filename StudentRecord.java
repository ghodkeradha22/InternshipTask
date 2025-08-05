package InternshipTask2;
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int id;
    String name;
    double marks;

    Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Marks: " + marks;
    }
}

public class StudentRecord {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            if(choice == 1) {
                System.out.print("Enter ID: ");
                int id = sc.nextInt();
                sc.nextLine(); // clear buffer
                System.out.print("Enter Name: ");
                String name = sc.nextLine();
                System.out.print("Enter Marks: ");
                double marks = sc.nextDouble();
                students.add(new Student(id, name, marks));
                System.out.println("Student added!");
            }

            else if(choice == 2) {
                if(students.isEmpty()) {
                    System.out.println("No student records.");
                } else {
                    for(Student s : students) {
                        System.out.println(s);
                    }
                }
            }

            else if(choice == 3) {
                System.out.print("Enter ID to update: ");
                int id = sc.nextInt();
                boolean found = false;
                for(Student s : students) {
                    if(s.id == id) {
                        sc.nextLine(); // clear buffer
                        System.out.print("Enter new Name: ");
                        s.name = sc.nextLine();
                        System.out.print("Enter new Marks: ");
                        s.marks = sc.nextDouble();
                        System.out.println("Student updated!");
                        found = true;
                        break;
                    }
                }
                if(!found) System.out.println("Student ID not found.");
            }

            else if(choice == 4) {
                System.out.print("Enter ID to delete: ");
                int id = sc.nextInt();
                boolean removed = false;
                for(int i = 0; i < students.size(); i++) {
                    if(students.get(i).id == id) {
                        students.remove(i);
                        System.out.println("Student deleted!");
                        removed = true;
                        break;
                    }
                }
                if(!removed) System.out.println("Student ID not found.");
            }

        } while(choice != 5);

        System.out.println("Thank you!");
        sc.close();
    }
}