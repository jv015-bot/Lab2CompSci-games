import java.util.Scanner;

public class GameMenu {
    public final Scanner scanner = new Scanner(System.in);
    public String userInput = "A";

    public static void main(String[] args) {
        GameMenu gameMenu = new GameMenu();
        gameMenu.runMenu();
    }

    public void runMenu() {
        System.out.println("WELCOME TO YOUR GAMES!!\n");
        while (!"Q".equals(userInput)) {
            System.out.println("Please select a game to play:\n");
            System.out.println("L - Lottery\n");
            System.out.println("C - Craps\n");
            System.out.println("R - Rock Paper Scissors (Out of service)\n");
            System.out.println("E - Rock Paper Scissors Spock (Out of service)\n");
            System.out.println("B - Blackjack (Out of service)\n");
            System.out.println("H - Hangman (Out of service)\n");
            System.out.println("Q - Quit\n");

            userInput = scanner.nextLine().trim().toUpperCase();

            if ("L".equals(userInput)) {
                playLottery();
            } else if ("C".equals(userInput)) {
                playCraps();
            } else if ("R".equals(userInput)) {
                playRockPaperScissors();
            } else if ("E".equals(userInput)) {
                playRockPaperScissorsSpock();
            } else if ("B".equals(userInput)) {
                playBlackjack();
            } else if ("H".equals(userInput)) {
                playHangman();
            } else if (!"Q".equals(userInput)) {
                System.out.println("Invalid selection. Please try again.\n");
            }
        }
    }

    private void playLottery() {
        System.out.println("WELCOME TO THE LOTTERY!!\n");
        userInput = "Y";

        while ("Y".equals(userInput)) {
            System.out.println("Thank you for choosing the lottery!\n");
            int d1 = (int) (Math.random() * 10);
            int d2 = (int) (Math.random() * 10);

            System.out.println("What is your guess for the winning numbers? (put numbers in single digit format I.E: 2 5 or 6 8)\n");

            int userGuess1 = scanner.nextInt();
            int userGuess2 = scanner.nextInt();
            scanner.nextLine();

            if (userGuess1 == d1 && userGuess2 == d2) {
                System.out.println("Congratulations! You guessed the winning numbers! " + d1 + " and " + d2 + " +$10,000\n");
            } else if (userGuess1 == d2 && userGuess2 == d1) {
                System.out.println("Congratulations! You guessed the winning numbers...but in the wrong order. " + d1 + " and " + d2 + " +$3,000\n");
            } else if (userGuess1 == d1 || userGuess1 == d2 || userGuess2 == d1 || userGuess2 == d2) {
                System.out.println("Congratulations! You guessed one of the winning numbers: " + d1 + " and " + d2 + " +$1,000\n");
            } else {
                System.out.println("Sorry, you did not guess any of the winning numbers: " + d1 + " and " + d2 + "\n");
            }

            System.out.println("Would you like to play the lottery? (Y/N)\n");
            userInput = scanner.nextLine().trim().toUpperCase();

            if ("N".equals(userInput)) {
                System.out.println("Returning to main menu...\n");
                return;
            } else if (!"Y".equals(userInput)) {
                System.out.println("Invalid selection. Please try again.\n");
                userInput = "Y";
            }
        }
    }

    private void playCraps() {
        System.out.println("WELCOME TO CRAPS!!\n");
        userInput = "Y";

        while ("Y".equals(userInput)) {
            int d1 = (int) (Math.random() * 6) + 1;
            int d2 = (int) (Math.random() * 6) + 1;
            int dsum = d1 + d2;
            System.out.println("You rolled a " + d1 + " and a " + d2 + " for a total of " + dsum + "\n");

            if (dsum == 7 || dsum == 11) {
                System.out.println("Congratulations! You win!\n");
            } else if (dsum == 2 || dsum == 3 || dsum == 12) {
                System.out.println("Sorry, you lose.\n");
            } else {
                System.out.println("Your point is " + dsum + ". Roll again to try and hit your point before rolling a 7.\n");
                System.out.println("Press enter to roll again.\n");
                scanner.nextLine();

                int point = dsum;
                boolean keepRolling = true;
                while (keepRolling) {
                    int roll1 = (int) (Math.random() * 6) + 1;
                    int roll2 = (int) (Math.random() * 6) + 1;
                    int rollSum = roll1 + roll2;
                    System.out.println("You rolled a " + roll1 + " and a " + roll2 + " for a total of " + rollSum + "\n");

                    if (rollSum == point) {
                        System.out.println("Congratulations! You hit your point and win!\n");
                        keepRolling = false;
                    } else if (rollSum == 7) {
                        System.out.println("Sorry, you rolled a 7 and lose.\n");
                        keepRolling = false;
                    } else {
                        System.out.println("Press enter to roll again.\n");
                        scanner.nextLine();
                    }
                }
            }

            System.out.println("Would you like to play again? (Y/N)\n");
            userInput = scanner.nextLine().trim().toUpperCase();

            if ("N".equals(userInput)) {
                System.out.println("Returning to main menu...\n");
                return;
            } else if (!"Y".equals(userInput)) {
                System.out.println("Invalid selection. Please try again.\n");
                userInput = "Y";
            }
        }
    }

    private void playRockPaperScissors() {
        System.out.println("WELCOME TO ROCK PAPER SCISSORS!!\n");
    }

    private void playRockPaperScissorsSpock() {
        System.out.println("WELCOME TO ROCK PAPER SCISSORS SPOCK!!\n");
    }

    private void playBlackjack() {
        System.out.println("WELCOME TO BLACKJACK!!\n");
    }

    private void playHangman() {
        System.out.println("WELCOME TO HANGMAN!!\n");
    }
}