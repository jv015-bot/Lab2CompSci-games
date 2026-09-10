
String userInput = "A";

void playLottery() {
    // Implementation of the Lottery game
    System.out.println("WELCOME TO THE LOTTERY!!\n");
    userInput = "Y";
    while (userInput.equals("Y")) {
        System.out.println("Thank you for choosing the lottery!\n");
        int d1 = (int) (Math.random() * 10);
        int d2 = (int) (Math.random() * 10);

        System.out.println("What is your guess for the winning numbers? (put numbers in single digit format I.E: 2 5 or 6 8)\n");

        int userGuess1 = scanner.nextInt();
        int userGuess2 = scanner.nextInt();
        scanner.nextLine(); // consume the remaining newline so nextLine() reads correctly

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
        userInput = scanner.nextLine().toUpperCase();

        if (userInput.equals("N")) {
            System.out.println("Returning to main menu...\n");
            return;
        } else if (!userInput.equals("Y")) {
            System.out.println("Invalid selection. Please try again.\n");
            userInput = "Y";
        }
    }
}

void playCraps() {
    // Implementation of the Craps game
    System.out.println("WELCOME TO CRAPS!!\n");
    While (userInput.equals("Y")) {
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
            scanner.nextLine(); // Wait for user to press enter
            int point = dsum;
            boolean keepRolling = true;
            while (keepRolling) {
                int d1 = (int) (Math.random() * 6) + 1;
                int d2 = (int) (Math.random() * 6) + 1;
                int dsum = d1 + d2;
                System.out.println("You rolled a " + d1 + " and a " + d2 + " for a total of " + dsum + "\n");
                if (dsum == point) {
                    System.out.println("Congratulations! You hit your point and win!\n");
                    keepRolling = false;
                } else if (dsum == 7) {
                    System.out.println("Sorry, you rolled a 7 and lose.\n");
                    keepRolling = false;
                }
            }
        }
        System.out.println("Would you like to play again? (Y/N)\n");
        userInput = scanner.nextLine().toUpperCase();

        if (userInput.equals("N")) {
            System.out.println("Returning to main menu...\n");
            return;
        } else if (!userInput.equals("Y")) {
            System.out.println("Invalid selection. Please try again.\n");
            userInput = "Y";
        }
}

void playRockPaperScissors() {
    // Implementation of the Rock Paper Scissors game
    System.out.println("WELCOME TO ROCK PAPER SCISSORS!!\n");
}

void playRockPaperScissorsSpock() {
    // Implementation of the Rock Paper Scissors Spock game
    System.out.println("WELCOME TO ROCK PAPER SCISSORS SPOCK!!\n");
}

void playBlackjack() {
    // Implementation of the Blackjack game
    System.out.println("WELCOME TO BLACKJACK!!\n");
}

void playHangman() {
    // Implementation of the Hangman game
    System.out.println("WELCOME TO HANGMAN!!\n");
}

System.out.println("WELCOME TO YOUR GAMES!!\n");
while (!userInput.equals("Q")) {
    System.out.println("Please select a game to play:\n");
    System.out.println("L - Lottery\n");
    System.out.println("C - Craps\n");
    System.out.println("R - Rock Paper Scissors(Out of service)\n");
    System.out.println("E - Rock Paper Scissors Spock (Out of service)\n");
    System.out.println("B - Blackjack (Out of service)\n");
    System.out.println("H - Hangman (Out of service)\n");
    System.out.println("Q - Quit\n");

    userInput = scanner.nextLine().toUpperCase();

    if (userInput.equals("L")) {
        playLottery();
    } else if (userInput.equals("C")) {
        playCraps();
    } else if (userInput.equals("R")) {
        playRockPaperScissors();
    } else if (userInput.equals("E")) {
        playRockPaperScissorsSpock();
    } else if (userInput.equals("B")) {
        playBlackjack();
    } else if (userInput.equals("H")) {
        playHangman();
    } else if (!userInput.equals("Q")) {
        System.out.println("Invalid selection. Please try again.\n");
    }
}