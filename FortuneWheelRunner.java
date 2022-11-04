// Class - AP Computer Science A
// Date - 10/12/2022
// Name - Cody Washington

//Packages
import java.lang.*;
import java.util.Scanner;
//Main Runner Class
public class FortuneWheelRunner
{
    public static void main(String[] args)
    {
        //Credit
        System.out.println("[Cody Washington | 10/12/2022 | Wheel of Fortune]");
        //Spacing
        for(int i = 0; i <= 4; i++)
        {
            System.out.println();
        }
        //Setup
        Scanner input = new Scanner(System.in);
        //Input the Phrase
        System.out.print("Your Phrase :: ");
        String phrase = input.nextLine();
        //Clear Console
        System.out.print("\033[H\033[2J");  
        //Create a new game
        FortuneWheel game = new FortuneWheel(phrase.toLowerCase());
        //Gameplay Main-Loop
        while(game.getGameStatus() == false)
        {
            //Prinout Information
            game.graphics();
            //Input Guess Forward to Guess Method
            System.out.print("Enter a Guess :: ");
            String response = input.nextLine();
            
            //Print a message
            switch (game.Guess(response))
            {
                case 0:
                    System.out.println("[You've already guessed that.]");
                    break;
                case 1:
                    System.out.println("[Your guess was in the Phrase.]");
                    break;
                case 2:
                    System.out.println("[Your guess wasn't in the Phrase.]");
                    break;
                case 3:
                    System.out.println("[Your guess wasn't the Phrase.]");
                    break;
                case 4:
                    System.out.println("[Your guess was the Phrase.]");
                    //Update to display the Phrase
                    game.graphics();
                    System.out.println("[Press Anything to Continue.]");
                    input.nextLine();
                    //Ask if Player wants to Continue
                    game.continueplaying();
                    break;
                case 5:
                    System.out.println("[You guessed everything.]");
                    //Update to display the Phrase
                    game.graphics();
                    System.out.println("[Press Anything to Continue.]");
                    input.nextLine();
                    //Ask if Player wants to Continue
                    game.continueplaying();
                    break;
                case 6:
                    System.out.println("[Invalid Guess.]");
                    //Ask if Player wants to Continue
                    game.continueplaying();
                    break;
            }
            //Check if Replay
            if(!(game.getGuessCount() >= 0))
            {
                game.continueplaying();
            }
        }
        //Credits
        System.out.println("_______________________");
        System.out.println("|                     |");
        System.out.println("| Thanks for Playing! |");
        System.out.println("|  - Cody Washington  |");
        System.out.println("|                     |");
        System.out.println("‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");        
    }
}
