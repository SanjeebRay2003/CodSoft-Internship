import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();
        sms.loadStudentDataFromFile();
        do {
            System.out.println("Student Management System");
            System.out.println("1. Add new Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search for a Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Save Student Data");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter student Name: ");
                    String Name = scanner.nextLine();
                    System.out.print("Enter roll Number: ");
                    int rollNo = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Grade: ");
                    char Grade = scanner.next().charAt(0);
                    sms.addStudent(new Student(Name, rollNo, Grade));
                    System.out.println("Student added successfully\n");
                }
                case 2 -> {
                    System.out.print("Enter roll number to remove: ");
                    int rollNoToRemove = scanner.nextInt();
                    scanner.nextLine();
                    sms.removeStudent(rollNoToRemove);
                    System.out.println("Student removed successfully\n");
                }
                case 3 -> {
                    System.out.print("Enter roll number to search: ");
                    int rollNoToSearch = scanner.nextInt();
                    scanner.nextLine();
                    Student StudentFound = sms.searchStudent(rollNoToSearch);
                    if (StudentFound != null) {
                        System.out.println("Student found:\n" + StudentFound);
                    } else {
                        System.out.println("Student not found in data.");
                    }
                }
                case 4 -> sms.displayAllStudents();
                case 5 -> sms.saveStudentDataInFile();
                case 6 -> {
                    System.out.println("Exiting...");
                    sms.saveStudentDataInFile();
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (true);
    }
}

class Student implements Serializable {
    private String name;
    private int rollNo;
    private char Grade;

    public Student(String name, int rollNo, char Grade) {
        this.name = name;
        this.rollNo = rollNo;
        this.Grade = Grade;
    }

    public String getName() {
        return name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public char getGrade() {
        return Grade;
    }

    @Override
    public String toString() {
        return "Name : " + name + "\nRoll No : " + rollNo + "\nGrade : " + Grade;
    }
}

class StudentManagementSystem {
    private List<Student> students = new ArrayList<>();
    private static final String data_file = "studentData.txt";

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(int rollNo) {
        students.removeIf(student -> student.getRollNo() == rollNo);
    }

    public Student searchStudent(int rollNo) {
        for (Student student : students) {
            if (student.getRollNo() == rollNo)
                return student;
        }
        return null;
    }

    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void saveStudentDataInFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(data_file))) {
            oos.writeObject(students);
            System.out.println("Student data successfully saved to " + data_file);
        } catch (IOException e) {
            System.err.println("Error saving student data: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void loadStudentDataFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(data_file))) {
            students = (List<Student>) ois.readObject();
            System.out.println("Student data loaded from " + data_file);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading student data: " + e.getMessage());
        }
    }
}

