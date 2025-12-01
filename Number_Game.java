import java.util.*;

public class Number_Game {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int score = 0;
        boolean playAgain = true;

        while (playAgain) {
            int number = rand.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 7;
            boolean guessedCorrect = false;

            System.out.println("\n🎯 Welcome to the Number Guessing Game!");
            System.out.println("I have selected a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts. Good luck!");

            while (attempts < maxAttempts) {
                System.out.print("\nEnter your guess: ");
                int guess = sc.nextInt();
                attempts++;

                if (guess == number) {
                    System.out.println("🎉 Correct! You guessed the number!");
                    System.out.println("Attempts used: " + attempts);

                    // scoring logic: fewer attempts = more score
                    int roundScore = (maxAttempts - attempts + 1) * 10;
                    score += roundScore;

                    System.out.println("You earned " + roundScore + " points! ⭐");
                    guessedCorrect = true;
                    break;
                } else if (guess > number) {
                    System.out.println("📈 Too high! Try again.");
                } else {
                    System.out.println("📉 Too low! Try again.");
                }
            }

            if (!guessedCorrect) {
                System.out.println("\n❌ You've used all attempts!");
                System.out.println("The correct number was: " + number);
            }

            System.out.println("\nYour total score so far: " + score);

            System.out.print("\nDo you want to play again? (yes/no): ");
            String response = sc.next();

            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("\n🏆 Game Over!");
        System.out.println("Final Score: " + score);
        System.out.println("Thanks for playing! 😊");

        sc.close();
    }
}
