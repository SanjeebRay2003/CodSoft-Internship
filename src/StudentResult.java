import java.util.Scanner;

public class StudentResult {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Name = ");
        String StudetName = input.nextLine();
        System.out.print("Roll number = ");
        String RollNumber = input.next();

        int subjects = 5;
        int totalMarks;
        int averagePercentage;

        System.out.println("Enter the obtained marks between 0 - 100");

        System.out.println("Enter the marks of Physics : ");
        int Physics = input.nextInt();
        System.out.println("Enter the marks of Chemistry : ");
        int Chemestry = input.nextInt();
        System.out.println("Enter the marks of Math : ");
        int Math = input.nextInt();
        System.out.println("Enter the marks of English : ");
        int English = input.nextInt();
        System.out.println("Enter the marks of Hindi : ");
        int Hindi = input.nextInt();

        System.out.println("\n\n\nResults =>");

        System.out.printf("Student name : %s \n", StudetName);
        System.out.printf("Roll-Number : %s \n", RollNumber);
        totalMarks = Physics + Chemestry + Math + English + Hindi;
        System.out.printf("Total marks = %d\n", totalMarks);
        averagePercentage = totalMarks / subjects;
        System.out.printf("Percentage = %d\n",
                averagePercentage);

        if (averagePercentage >= 90) {
            System.out.println("Grade = A");
        } else if (averagePercentage > 80) {
            System.out.println("Grade = B");
        } else if (averagePercentage >= 70) {
            System.out.println("Grade = C");
        }

        else if (averagePercentage >= 40) {
            System.out.println("Grade = C+");
        } else {
            System.out.println("You are fail !");
        }
        input.close();

    }

}
