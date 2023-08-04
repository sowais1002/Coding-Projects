import java.util.Scanner;

public class TriviaGame {
    public static void main(String[] args) {
        System.out.println("\t\t\tTRIVIA GAME\n");
        Question[] questions = {
                new Question("Which keyword is used to define a constant variable in Java?"
                        ,new String[]{"Constant","Static","Final"}
                        ,2),
                new Question("In Java, which keyword is used to create a new instance of a class?"
                        ,new String[]{"new","this","instance"}
                        ,0),
                new Question("What is the correct way to declare and initialize an array in Java?"
                        ,new String[]{"int[] numbers = {1, 2, 3, 4, 5}"
                        ,"int numbers[] = (1, 2, 3, 4, 5)"
                        ,"int numbers = [1, 2, 3, 4, 5]"}
                        ,0),
                new Question("What is the purpose of the toString() method in Java?"
                        ,new String[]{"It converts a string to an integer"
                        ," It converts an object to its string representation"
                        ,"It converts an integer to a string"}
                        ,1),
                new Question("Which Java access modifier provides the widest accessibility?"
                        ,new String[]{" private","protected","public"}
                        ,2)
        };
        play(questions);
    }

    public static void play(Question[] questions){
        Scanner sc = new Scanner(System.in);
        int score = 0;

        for (int i=0; i< questions.length; i++){
            Question question = questions[i];
            System.out.println("Question "+(i +1)+": "+question.getQuestion());
            String[] options = question.getOptions();
            for (int j =0; j<options.length; j++){
                System.out.println((j+1)+"."+options[j]);
            }

            System.out.println("Enter your answer (1-"+options.length+"): ");
            int answer = sc.nextInt()-1;

            if(question.isCorrectAnswer(answer)){
                System.out.println("Correct!");
                score++;
            }else {
                System.out.println("Incorrect!");
            }
        }
        System.out.println("Your Final Score is "+score+" out of "+questions.length);
    }
}