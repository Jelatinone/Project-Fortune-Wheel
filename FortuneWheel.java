// Class - AP Computer Science A
// Date - 10/12/2022
// Name - Cody Washington
//Packages
import java.lang.*;
import java.util.Scanner;
//Main Class
public class FortuneWheel 
{
    //Instance Variables
    private String phrase;
    //Special Characters Already Added for Conveience
    private String letterlist = " !@#$%^&*()[]{}|:;?/+=~-_'";
    private boolean game_status = false;
    private int guess_count;
    
    
    //CONSTRUCTORS
    
    //Constructor given Phrase.
    public FortuneWheel(String p)
    {
        //Set Instance 
        phrase = p.toLowerCase();
        guess_count = (phrase.length() + 1);
        titlecard();
    }
    //Constructor not given Phrase.
    public FortuneWheel()
    {
        //Set Instance
        phrase = "cody is cool";
        guess_count = (phrase.length() + 1);
        titlecard();
    }
    //Replay the game without instantiating a new game given Phrase.
    public void Replay(String p)
    {
        phrase = p.toLowerCase();
        guess_count = (phrase.length() + 1);
        letterlist = " !@#$%^&*()[]{}|:;?/+=~-_'";
        game_status = false;
        titlecard();
    }
    //Replay the game without instantiating a new game not given Phrase.
    public void Replay()
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
        System.out.print("\033[H\033[2J");
        System.out.print("Your Phrase :: ");
        phrase = input.nextLine().toLowerCase();
        //Clear Console
        System.out.print("\033[H\033[2J");
        guess_count = (phrase.length() + 1);
        letterlist = " !@#$%^&*()[]{}|:;?/+=~-_'";
        game_status = false;
        titlecard();
    }
    //LOGICAL METHODS
    
    //Displays Phrase Based on Letter List
    public String displayPhrase()
    {
        String Displayed_Phrase = "";
        for(int i = 0; i <= (phrase.length()-1); i++)
        {
            char phrase_character = phrase.charAt(i);
            for(int j = 0; j <= (letterlist.length()-1); j++)
            {
                char letterlist_character = letterlist.charAt(j);
                //The Iterating Letterlist character 
                if(letterlist_character == phrase_character)
                {
                    //Add character to return string
                    Displayed_Phrase += phrase_character;
                    break;
                }
                //The terating Letterlist character is last checked
                else if(j == (letterlist.length()-1))
                {
                    //Add aterisk to return string
                    Displayed_Phrase += "*";
                }
            }
        }
        //Win Checking
        if(Displayed_Phrase == phrase)
        {
            game_status = true;
        }
        //Return results
        return Displayed_Phrase;
    }
    //Takes in a Guess String, adds to letterlist and Substracts from Guess.
    public int Guess(String guess)
    {
        //Clear Screen
        System.out.print("\033[H\033[2J");  
        //Variables
        int guess_length = (guess.length()-1);
        String Previous_DisplayPhrase = displayPhrase();
        //Convert Lower
        guess = guess.toLowerCase();
        //Guess is a Character
        if(guess_length == 0)
        {
            //Check against letterlist
            for(int i = 0; i <= (letterlist.length()-1); i++)
            {
                //Previously Guessed
                if(guess.charAt(0) == letterlist.charAt(i))
                {
                    return 0;
                }
            }
            //Newly Guessed
            letterlist+= guess;
            guess_count--;
            //DisplayPhrase Unaffected
            if(displayPhrase().equals(Previous_DisplayPhrase))
            {
                return 2;
            }
            //DisplayPhrase affected
            else
            {
                //Check if the Updated Display equals the phrase
                if(displayPhrase().equals(phrase))
                {
                    //All Characters Gussed
                    game_status = true;
                    return 5;
                }
                //Does not equal phrase
                else
                {
                    //Guess was in the phrase, but not all guessed.
                    return 1;
                }
            }
        }
        //Guess is a phrase
        else if(guess_length >= 1)
        {
            guess_count -= 3;
            //Guess is Phrase
            if(guess.equals(phrase))
            {
                letterlist+=guess;
                return 4;
            }
            //Guess is not phrase
            else
            {
                return 3;
            }
        }
        //Guess invalid
        return 6;

    }
    //Displays game information
    public void graphics()
    {
        //Variables
        int phrase_length = (phrase.length()-1);
        String Spacing = "";
        //FORMATING
        System.out.println();
        System.out.println("[Remaining Guesses : "+getGuessCount()+"]");
        System.out.println();
        System.out.println();
        //Top Box Bar       
        System.out.print("__");
        for(int i = 0; i <= (phrase_length +2); i++)
        {
            System.out.print("_");
            Spacing += " ";
        }
        System.out.print("\n");
        //Middle
        System.out.println("|"+Spacing+"|");
        System.out.println("| "+displayPhrase()+" |");
        System.out.println("|"+Spacing+"|");
        //Bottom Box Bar
        System.out.print("‾‾");
        for(int i = 0; i <= (phrase_length + 2); i++)
        {
            System.out.print("‾");
        }
        //Spacing
        for(int i = 0; i <= 3; i++)
        {
            System.out.println();
        }
        
    }
    //Prints out a title card for WOF.    
    public void titlecard()
    {
        //Game title and Credits
        System.out.println("____________________");
        System.out.println("|------------------|");
        System.out.println("| WHEEL-OF-FORTUNE |");
        System.out.println("|------------------|");
        System.out.println("‾‾‾|=[CODY  W.]=|‾‾‾");
        System.out.println("   ‾‾‾‾‾‾‾‾‾‾‾‾‾‾");
        //Spacing
        System.out.println();
    }
    public void continueplaying()
    {
        //Clear Screen 
        System.out.print("\033[H\033[2J");  
        System.out.println("[Game over, Would you like to keep playing?]");
        System.out.println();
        Scanner input = new Scanner(System.in);
        if(input.next().toLowerCase().charAt(0) == 'n')
        {
            guess_count = 0;
        }
        else
        {
            Replay();
        }
    }
    //ACESSOR METHODS
    public String getPhrase()
    {
        return phrase;
    }
    public String getLetterList()
    {
        return letterlist;
    }
    public int getGuessCount()
    {
        return guess_count;
    }
    public boolean getGameStatus()
    {
        return game_status;
    }
}
