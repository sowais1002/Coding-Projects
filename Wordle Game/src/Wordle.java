import java.util.Scanner;

public class Wordle {
    final String secretWord;

    final int attempts;

    public Wordle(String secretWord, int attempts) {
        this.secretWord = secretWord;
        this.attempts = attempts;
    }

    public void play(){
        Scanner sc = new Scanner(System.in);
        int remainingAttempts = attempts;

        System.out.println("The length of the Secret Word is: "+secretWord.length());
        while(remainingAttempts > 0){
            System.out.println("Attempts Remaining: "+remainingAttempts);
            System.out.println("\nEnter your guess: ");
            String guess = sc.nextLine();

            if(guess.length() != secretWord.length()){
                System.out.println("Invalid guess! Enter a word with same length as secret word");
                continue;
            }

            int correctChars = 0;
            int correctPositions = 0;

            for(int i=0; i < secretWord.length(); i++){
                char c = guess.charAt(i);
                if(c == secretWord.charAt(i)){
                    correctPositions++;
                }
                if(secretWord.indexOf(c) >= 0){
                    correctChars++;
                }
            }

            if(correctPositions == secretWord.length()){
                System.out.println("Correct guess!");
                break;
            }else{
                System.out.println("Correct Characters: "+correctChars);
                System.out.println("Correct Positions: "+correctPositions);
                remainingAttempts--;
            }
        }
        if(remainingAttempts == 0){
            System.out.println("Sorry, you are out of attempts." +
                    "\nThe Secret Word was: "+secretWord);
        }
    }
}
