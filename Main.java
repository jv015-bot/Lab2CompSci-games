import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static String userInput = "A";

    public static void main(String[] args) {
        System.out.println("WELCOME TO YOUR GAMES!!\n");
        while (!userInput.equals("Q")) {
            System.out.println("Please select a game to play:\n");
            System.out.println("L - Lottery\n");
            System.out.println("C - Craps\n");
            System.out.println("R - Rock Paper Scissors\n");
            System.out.println("E - Rock Paper Scissors Spock (Out of service)\n");
            System.out.println("B - Blackjack\n");
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
            } else if (userInput.equals("Q")) {
                System.out.println("Thank you for playing! Goodbye!\n");
            } else if (!userInput.equals("Q")) {
                System.out.println("Invalid selection. Please try again.\n");
            }
        }
    }

    static void playLottery() {
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

    static void playCraps() {
        // Implementation of the Craps game
        System.out.println("WELCOME TO CRAPS!!\n");
        int networth = 500; // Starting net worth for the player
        int bet = 0; // Reset bet for each game

        userInput = "Y";
        while (userInput.equals("Y")) {
            if (networth <= 0) {
                System.out.println("You have no more money to bet. Returning to main menu...\n");
                return;
            }
            System.out.println("You have a starting net worth of $" + networth + ". How much would you like to bet? (I.E: 50)\n");
            bet = Integer.parseInt(scanner.nextLine());
            networth -= bet; // Deduct the bet from net worth
            System.out.println("Your bet is $" + bet + ".\n");
            int d1 = (int) (Math.random() * 8) + 1;
            int d2 = (int) (Math.random() * 8) + 1;
            int d3 = (int) (Math.random() * 8) + 1;
            int dsum = d1 + d2 + d3;
            System.out.println("You rolled a " + d1 + " and a " + d2 + " and a " + d3 + " for a total of " + dsum + "\n");

            if ((dsum == 9 || dsum == 10 || dsum == 14) || (d1 == 8|| d2 == 8 || d3 == 8) ) {
                System.out.println("Congratulations! You win!\n");
                bet *= 2; // Double the bet after winning
                networth += bet; // Update net worth with the final bet amount
                bet = 0; // Reset bet after winning
                System.out.println("Your bet is now $" + bet + ". and your net worth is now $" + networth + ".\n");
            } else if ((dsum == 8 || dsum == 20 || dsum == 23 || dsum == 24) || (d1 == 1 || d2 == 1 || d3 == 1) ) {
                System.out.println("Sorry, you lose.\n");
                networth -= bet; // Update net worth with the final bet amount
                bet = 0; // Reset bet after losing
                System.out.println("Your bet is now $" + bet + ". and your net worth is now $" + networth + ".\n");
            } else {
                System.out.println("Your point is " + dsum + ". Roll again to try and hit your point before rolling a 15 or a single '8'.\n");
                System.out.println("Press enter to roll again.\n");
                scanner.nextLine(); // Wait for user to press enter
                int point = dsum;
                boolean keepRolling = true;

                while (keepRolling) {
                    
                    int nextD1 = (int) (Math.random() * 8) + 1;
                    int nextD2 = (int) (Math.random() * 8) + 1;
                    int nextD3 = (int) (Math.random() * 8) + 1;
                    int nextDsum = nextD1 + nextD2 + nextD3;
                    System.out.println("You rolled a " + nextD1 + " and a " + nextD2 + " and a " + nextD3 + " for a total of " + nextDsum + "\n");

                    if (nextDsum == point) {
                        System.out.println("Congratulations! You hit your point and win!\n");
                        bet *= 2; // Double the bet after winning
                        System.out.println("Your bet is now $" + bet + ".\n");
                        networth += bet; // Update net worth with the final bet amount
                        System.out.println("Your net worth is now $" + networth + ".\n");
                        keepRolling = false;
                    } else if ((nextDsum == 15) || (nextD1 == 8 || nextD2 == 8 || nextD3 == 8) ) {
                        System.out.println("Sorry, you rolled a 15 or a single '8' and lose.\n");
                        networth -= bet; // Update net worth with the final bet amount
                        bet = 0; // Reset bet after losing
                        System.out.println("Your bet is now $" + bet + ".\n");
                        System.out.println("Your net worth is now $" + networth + ".\n");
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
                System.out.println("Invalid selection. Please play again.\n");
                userInput = "N";
            }
        }
    }

    static void playRockPaperScissors() {
        // Implementation of the Rock Paper Scissors game
        String usermove = "start";
        System.out.println("WELCOME TO ROCK PAPER SCISSORS!!\n");
        System.out.println("Please enter either rock, paper, or scissors to play the game. You can press 'q' anytime to quit.\n");
        while (!usermove.equals("q")) {
            System.out.println("\n");
            int compmove = (int) (Math.random() * 3); // 0 = rock, 1 = paper, 2 = scissors
            usermove = scanner.nextLine().toLowerCase();
            if ((compmove == 0) && usermove.equals("rock")) {
                System.out.println("The computer chose rock and user chose rock. It's a tie! Please play again.\n");
                usermove = "next";
            } else if ((compmove == 0) && usermove.equals("paper")) {
                System.out.println("The computer chose rock and user chose paper. User wins! Please play again.\n");
                usermove = "next";
            } else if ((compmove == 0) && usermove.equals("scissors")) {
                System.out.println("The computer chose rock and user chose scissors. Computer wins! Please play again.\n");
                usermove = "next";
            } else if ((compmove == 1) && usermove.equals("rock")) {
                System.out.println("The computer chose paper and user chose rock. Computer wins! Please play again.\n");
                usermove = "next";
            } else if ((compmove == 1) && usermove.equals("paper")) {
                System.out.println("The computer chose paper and user chose paper. It's a tie! Please play again.\n");
                usermove = "next";
            } else if ((compmove == 1) && usermove.equals("scissors")) {
                System.out.println("The computer chose paper and user chose scissors. User wins! Please play again.\n");
                usermove = "next";
            } else if ((compmove == 2) && usermove.equals("rock")) {
                System.out.println("The computer chose scissors and user chose rock. User wins! Please play again.\n");
                usermove = "next";
            } else if ((compmove == 2) && usermove.equals("paper")) {
                System.out.println("The computer chose scissors and user chose paper. Computer wins! Please play again.\n");
                usermove = "next";
            } else if ((compmove == 2) && usermove.equals("scissors")) {
                System.out.println("The computer chose scissors and user chose scissors. It's a tie! Please play again.\n");
                usermove = "next";
            }
        }   
    }

    static void playRockPaperScissorsSpock() {
        // Implementation of the Rock Paper Scissors Spock game
        System.out.println("WELCOME TO ROCK PAPER SCISSORS SPOCK!!\n");
    }

    static void playBlackjack() {
        System.out.println("WELCOME TO BLACKJACK!!\n");
        while (!userInput.equals("N")) {
            String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
            String[] card = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

            // Create a deck. Each number represents one card.
            int[] deck = new int[52];
            for (int i = 0; i < 52; i++) {
                deck[i] = i;
            }

            // Shuffle the deck.
            for (int i = 51; i > 0; i--) {
                int j = (int) (Math.random() * (i + 1));
                int temp = deck[i];
                deck[i] = deck[j];
                deck[j] = temp;
            }

            String[] playerHand = new String[52];
            String[] computerHand = new String[52];
            int playerCards = 0;
            int computerCards = 0;
            int playerValue = 0;
            int computerValue = 0;
            int playerAces = 0;
            int computerAces = 0;

            // Deal two cards to each hand, alternating between the player and dealer.
            int nextCard = 0;
            for (int i = 0; i < 4; i++) {
                int cardIndex = deck[nextCard++];
                int rank = cardIndex % 13;
                int suit = cardIndex / 13;
                int value = rank < 9 ? rank + 2 : (rank < 12 ? 10 : 11);
                String dealtCard = card[rank] + " of " + suits[suit];

                if (i % 2 == 1) {
                    computerHand[computerCards++] = dealtCard;
                    computerValue += value;
                    if (rank == 12) {
                        computerAces++;
                    }
                } else {
                    playerHand[playerCards++] = dealtCard;
                    playerValue += value;
                    if (rank == 12) {
                        playerAces++;
                    }
                }
            }

            System.out.println("The computer's first card is " + computerHand[0] + ".");

            boolean playing = true;
            while (playing && playerValue <= 21) {
                System.out.println("Your cards: " + playerHand[0] + " and " + playerHand[1]
                        + ". Total: " + playerValue + ".");
                    if (playerValue == 21) {
                        System.out.println("You have a total of 21! You win!\n");
                    return;
                    }
                
                System.out.println("Would you like to hit or stand? (Y/N)\n");
                String choice = scanner.nextLine().trim().toUpperCase();

                if (choice.equals("Y") || choice.equals("YES")) {
                    int cardIndex = deck[nextCard++];
                    int rank = cardIndex % 13;
                    int suit = cardIndex / 13;
                    int value = rank < 9 ? rank + 2 : (rank < 12 ? 10 : 11);
                    playerHand[playerCards++] = card[rank] + " of " + suits[suit];
                    playerValue += value;
                    if (rank == 12) {
                        playerAces++;
                    }
                    while (playerValue > 21 && playerAces > 0) {
                        playerValue -= 10;
                        playerAces--;
                    }
                    System.out.println("You received " + playerHand[playerCards - 1] + ". Total: " + playerValue);
                } else if (choice.equals("N") || choice.equals("NO")) {
                    playing = false;
                } else {
                    System.out.println("Invalid selection. Please choose Y or N.");
                }
            }

            if (playerValue > 21) {
                System.out.println("You busted with a total of " + playerValue + ". The computer wins.\n");
                return;
            }

            System.out.println("The computer's cards are " + computerHand[0] + " and " + computerHand[1]
                + ". Total: " + computerValue);
            while (computerValue <= 17) {
                int cardIndex = deck[nextCard++];
                int rank = cardIndex % 13;
                int suit = cardIndex / 13;
                int value = rank < 9 ? rank + 2 : (rank < 12 ? 10 : 11);
                computerValue += value;
                computerCards++;
                if (rank == 12) {
                    computerAces++;
                }
                while (computerValue > 21 && computerAces > 0) {
                    computerValue -= 10;
                    computerAces--;
                }
                computerHand[computerCards++] = card[rank] + " of " + suits[suit];
                System.out.println("The computer drew " + computerHand[computerCards - 1] + ". Total: " + computerValue);
            }

            System.out.println("Your total: " + playerValue + ". Computer total: " + computerValue + ".");
            if (computerValue > 21 || playerValue > computerValue) {
                System.out.println("Congratulations! You win!\n");
            } else if (playerValue == computerValue) {
                System.out.println("It's a push!\n");
            } else {
                System.out.println("The computer wins.\n");
            }
    
        System.out.println("Would you like to play again? (Y/N)\n");
        userInput = scanner.nextLine().toUpperCase();}
        }

    static void playHangman() {
        // Implementation of the Hangman game
        System.out.println("WELCOME TO HANGMAN!!\n");
    }
}
