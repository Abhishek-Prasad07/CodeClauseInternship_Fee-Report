import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fee {
    private String name;
    private String roll_number;
    private String DOB;
    private double course_fee;
    private double paid_fee;

    public Fee(String name, String roll_number, String DOB, double course_fee, double paid_fee) {
        this.name = name;
        this.roll_number = roll_number;
        this.DOB = DOB;
        this.course_fee = course_fee;
        this.paid_fee = paid_fee;
    }

    public String getName() {
        return name;
    }

    public String getRollNumber() {
        return roll_number;
    }

    public String getDOB() {
        return DOB;
    }

    public double getCourseFee() {
        return course_fee;
    }

    public double getPaidFee() {
        return paid_fee;
    }

    public double getDueFee() {
        return course_fee - paid_fee;
    }
}

class FeeReport {
    private static List<Fee> feeList = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\nFee Report System");
            System.out.println("1. Add Student");
            System.out.println("2. View Student");
            System.out.println("3. Exit");
            System.out.println("\nEnter Your Choice");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudent();
                    break;
                case 3:
                    running = false;
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void addStudent() {
        System.out.println("Enter student name: ");
        String name = sc.next();
        System.out.println("Enter student roll number: ");
        String rollNumber = sc.next();
        System.out.println("Enter student DOB: ");
        String dob = sc.next();
        System.out.println("Enter course fee: ");
        double courseFee = sc.nextDouble();
        System.out.println("Enter paid fee: ");
        double paidFee = sc.nextDouble();

        Fee student = new Fee(name, rollNumber, dob, courseFee, paidFee);
        feeList.add(student);
        System.out.println("Student added successfully!");
    }

    public static void viewStudent() {
        System.out.println("\nStudent List:");
        for (Fee student : feeList) {
            System.out.println("Name: " + student.getName());
            System.out.println("Roll Number: " + student.getRollNumber());
            System.out.println("DOB: " + student.getDOB());
            System.out.println("Course Fee: " + student.getCourseFee());
            System.out.println("Paid Fee: " + student.getPaidFee());
            System.out.println("Due Fee: " + student.getDueFee());
            System.out.println();
        }
    }
}
