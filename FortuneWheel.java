//Project : Wheel of Fortune
//Date : 10/19/2022
//Name : Cody Washington

//Packages
import java.lang.*;

//Processing Handler
public class FortuneWheel
{
    //Instance Variables
    private String phrase;
    private int guess_count;

    private LetterList letterList = new LetterList();
    private GameStatus Game_Status = new Game_Status();

    //CONSTRUCTORS

    //Constructor Given no Parameters
    public FortuneWheel()
    {
        //Assume Defaults
        phrase = "Jelatinone";
        LetterList.Basic();
        guess_count = (phrase.length()+1);
    }
    public FortuneWheel(int x)
    {

    }
}

//Graphics Handler
class FWGraphics
{
    //Instance Variables

    //CONSTRUCTORS

    public FWGraphics()
    {

    }
}
class GameStatus
{
    //
    boolean Game_Status = false;

    public boolean GetStatus()
    {
        return Game_Status;
    }
    //Converts Game Status
    public String ConvertStatus()
    {
        if (Game_Status)
        {
            return "Win";
        } else
        {
            return "Undetermined";
        }
    }
    public void SetStatus(boolean x)
    {
        Game_Status = x;
    }
    public void SetStatus()
    {
        Game_Status = false;
    }
}
class LetterList
{
    //Instance Variables
    String[] StringList = {"",};

    //Default CheckList
    char[] CharacterList = {' ',',','!','@','#','$','%','^','&',
                            '(',')','[',']','{','}','/','|',':',
                            ';','-','_','~','1','2','3','4','5',
                            '6','7','8','9','0','+','=','.','"'};
    LetterList()
    {

    }
    LetterList(String C)
    {
        StringList.add
    }

}
