public class WordleGame {
    public static void main(String[] args) {
        System.out.println("\t\t\tWORDLE GAME");
        Wordle wordle = new Wordle("Car",3);
        wordle.play();
    }
}