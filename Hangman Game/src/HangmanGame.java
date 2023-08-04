public class HangmanGame {
    public static void main(String[] args) {

        System.out.println("\t\t\tHANGMAN GAME\n");
        Hangman hangman = new Hangman("dogo",3);
        hangman.play();
    }
}