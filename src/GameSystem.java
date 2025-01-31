
import java.util.Arrays;
import java.util.Scanner;
import java.util.SplittableRandom;

public class GameSystem {
    SplittableRandom splittableRandom = new SplittableRandom();
    Scanner scanner = new Scanner(System.in);
    String[] maxChoices = new String[]{"rock","paper","scissor"};
    int aiScore = 0;
    int playerScore = 0;
    String replay;

    GameSystem() {

        String playerHand = "";

        boolean gameon = true;
        do{
            gameon = true;
            aiScore = 0;
            playerScore = 0;
            while (gameon) {

                playerHand = "";
                String aiChoice = AiSystem(); // getting the Computer's Choice.
                while (!Arrays.asList(maxChoices).contains(playerHand)) {
                    System.out.print("Choose Rock,Paper or Scissor:");
                    playerHand = scanner.next().toLowerCase(); //only takes the first word by next.

                    if (!Arrays.asList(maxChoices).contains(playerHand)) {
                        System.out.println("Choose a proper Option.");
                    }
                }


                determineWinner(playerHand,aiChoice);
                if(aiScore==3 || playerScore==3){
                    gameon =false;
            }
        }
            System.out.println("Your Score: " + playerScore +" Computer Score: " + aiScore);
            if (aiScore>playerScore){
            System.out.println("Computer Won with " + (aiScore) +" points");
        }
        else{
            System.out.println("You Won with " + (playerScore) +" points");
        }
        System.out.println("Do you want to play again? (Press Y or Yes)");
        replay = scanner.next().toLowerCase();
    }while(replay.equals("y") || replay.equals("yes"));
    }


    private String AiSystem(){
        int aiRNG = splittableRandom.nextInt(3); // generates random numbers from 0-2.
        return maxChoices[aiRNG];
    }

    private void determineWinner(String playerHand,String aiChoice){
        System.out.println("You chose " + playerHand + " and the computer chose " + aiChoice + ".");

        if (playerHand.equals(aiChoice)) {
            System.out.println("It's a Tie.");
        } else if ((playerHand.equals("rock") && aiChoice.equals("scissor")) ||
                (playerHand.equals("paper") && aiChoice.equals("rock")) ||
                (playerHand.equals("scissor") && aiChoice.equals("paper"))) {
            System.out.println("You got a Score.");
            playerScore++;
        } else {
            System.out.println("Computer got a Score.");
            aiScore++;
        }
    }

}



