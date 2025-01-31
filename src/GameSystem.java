
import java.util.Arrays;
import java.util.Scanner;
import java.util.SplittableRandom;

public class GameSystem {
    SplittableRandom splittableRandom = new SplittableRandom();
    Scanner scanner = new Scanner(System.in);
    String[] maxChoices = new String[]{"rock","paper","scissor"};
    int aiScore = 0;
    int playerScore = 0;

    GameSystem() {

        String playerHand = "";

        boolean gameon = true;
        while (gameon) {
            String aiChoice = AiSystem(); // getting the Computer's Choice.
            while (!Arrays.asList(maxChoices).contains(playerHand)) {
                System.out.print("Choose Rock,Paper or Scissor:");
                playerHand = scanner.next(); //only takes the first word by next.


            }
            determineWinner(playerHand,aiChoice);
            playerHand = playerHand.toLowerCase();
            System.out.print("Choose Rock,Paper or Scissor:");
            playerHand = scanner.next();

            if(aiScore==2 || playerScore==2){
                gameon =false;
            }

        }

        if (aiScore>playerScore){
            System.out.println("Computer Won with " + (aiScore+1) +" points");
        }
        else{
            System.out.println("You Won with " + (playerScore+1) +" points");
        }
    }


    private String AiSystem(){
        int aiRNG = splittableRandom.nextInt(3); // generates random numbers from 0-2.
        switch (aiRNG){
            case 0:
                return "paper";
            case 1:
                return "rock";
            case 2:
                return "scissor";
        }
        return "";
    }

    private void determineWinner(String playerHand,String aiChoice){

        if (playerHand.equals(aiChoice)){
            System.out.println("You chose " + playerHand + "and Computer chose " + aiChoice);
            System.out.println("Its a Tie.");
        }
        else if (playerHand.equals("rock") && aiChoice.equals("scissor")) {
            System.out.println("You chose "+ playerHand +" and Computer chose " + aiChoice);
            System.out.println("You got a Score.");
            playerScore++; // because player won.
        }
        else if (playerHand.equals("paper") && aiChoice.equals("rock")) {
            System.out.println("You chose "+ playerHand +" and Computer chose " + aiChoice);
            System.out.println("You got a Score.");
            playerScore++; // because player won.
        }
        else if (playerHand.equals("scissor") && aiChoice.equals("paper")) {
            System.out.println("You chose "+ playerHand +" and Computer chose " + aiChoice);
            System.out.println("You got a Score.");
            playerScore++; // because player won.
        }
        else{
            System.out.println("You chose "+ playerHand +" and Computer chose " + aiChoice);
            System.out.println("Computer got a Score.");
            aiScore++; // because computer won.
        }
    }

}



