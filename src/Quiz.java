
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Quiz {
    static int CurrentQuestion = 0;
    static int YourScore = 0;
    static Question[] questions;
    static Timer timer;

    public static void main(String[] args) {
        StartQuestions();
        startQuiz();
    }

    static void StartQuestions() {
        questions = new Question[4];
        questions[0] = new Question("Eritrea, which became the 182nd member of the UN in 1993, is in the continent of",
                new String[] {"Asia", "China", "Africa", "Russia" }, 2);
        questions[1] = new Question("First human heart transplant operation conducted by Dr. Christiaan Barnard on Louis Washkansky, was conducted in?",
                new String[] { "1967", "1968", "1958", "1922" }, 0);
        questions[2] = new Question("Hitler party which came into power in 1933 is known as?",
                new String[] { "Labour Party", "Nazi Party", "Ku-Klux-Klan", "Democratic Party" }, 1);
        questions[3] = new Question("Golf player Vijay Singh belongs to which country?",
                new String[] { "India", "Fiji", "USA", "UK" }, 1);
    }

    static void startQuiz() {
//        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Quiz!");
        System.out.println("--------------------");

        timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                System.out.println("\nTime's up for this question! Moving to the next question.");
                displayNextQuestion();
            }
        }, 20000);

        displayNextQuestion();
    }

    static void displayNextQuestion() {
        if (CurrentQuestion < questions.length) {
            Question currentQuestion = questions[CurrentQuestion];
            System.out.println("\n" + currentQuestion.questionText());

            for (int i = 0; i < currentQuestion.options().length; i++) {
                System.out.println((i + 1) + ". " + currentQuestion.options()[i]);
            }

            Scanner scanner = new Scanner(System.in);
            System.out.print("Select your answer (1-" + currentQuestion.options().length + "): ");
            int userAnswer = scanner.nextInt() - 1;

            if (userAnswer == currentQuestion.correctAnswer()) {
                YourScore++;
            }

            CurrentQuestion++;
            timer.cancel();
            timer = new Timer();
            timer.schedule(new TimerTask() {

                public void run() {
                    System.out.println("\nTime's up for this question! Moving to the next question.");
                    displayNextQuestion();
                }
            }, 20000);

            displayNextQuestion();
        } else {
            endQuiz();
        }
    }

    static void endQuiz() {
        System.out.println("\nQuiz Finished!");
        System.out.println("Your score: " + YourScore + "/" + questions.length);
        System.out.println("Thank you for playing!");
    }
}

record Question(String questionText, String[] options, int correctAnswer) {
}