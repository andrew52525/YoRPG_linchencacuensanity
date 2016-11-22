import java.io.*;
import java.util.*;

public class YoRPG {
    //change this constant to set number of encounters in a game
    public final static int MAX_ENCOUNTERS = 5;
    private Character pat = new Warrior("Warrior");
    private Monster smaug;

    private int moveCount;
    private boolean gameOver;
    private int difficulty;

    private InputStreamReader isr;
    private BufferedReader in;


    public YoRPG() {
        moveCount = 0;
        gameOver = false;
        isr = new InputStreamReader( System.in );
        in = new BufferedReader( isr );
        newGame();
    }


    public void newGame() {
        String s;
        String name = "";
        String _class = "";

        s = "Welcome to Ye Olde RPG!\n";
        s += "\nChoose your difficulty: \n";
        s += "\t1: Easy\n";
        s += "\t2: Not so easy\n";
        s += "\t3: Beowulf hath nothing on me. Bring it on.\n";
        s += "Selection: ";
        System.out.print( s );


        try {
            difficulty = Integer.parseInt( in.readLine() );
        }
        catch ( IOException e ) { }
        System.out.println("\n");


        System.out.println(pat.about());
        System.out.print("Glorious adventurer, what class doth thy be?\nSelection: ");

        try {
            _class = in.readLine().toLowerCase();
        }
        catch ( IOException e ) { }


        s = "Intrepid warrior, what doth thy call thyself? (State your name): ";
        System.out.print( s );

        try {
            name = in.readLine();
        }
        catch ( IOException e ) { }

        //instantiate the player's character
        if ( _class.equals("warrior") ) {
            System.out.println("Get ready, Warrior " + name + "!");
            pat = new Warrior(name);
        }
        else if ( _class.equals("mage") ) {
            System.out.println("Get ready, Mage " + name + "!");
            pat = new Mage(name);
        }
        else if ( _class.equals("rogue") ) {
            System.out.println("Get ready, Rogue " + name + "!");
            pat = new Rogue(name);
        }
        else if ( _class.equals("barbarian") ) {
            System.out.println("Get ready, Barbarian " + name + "!");
            pat = new Barbarian(name);
        }
        else if ( _class.equals("cleric") ) {
            System.out.println("Get ready, Cleric " + name + "!");
            pat = new Cleric(name);
        }
    }


    public boolean playTurn() {
        int i = 1;
        int d1, d2;

        if ( Math.random() >= ( difficulty / 3.0 ) )
            System.out.println( "\nNothing to see here. Move along!" );
        else {
            System.out.println( "\nLo, yonder monster approacheth!" );

            smaug = new Monster();

            while( smaug.isAlive() && pat.isAlive() ) {

                // Give user the option of using a special attack:
                // If you land a hit, you incur greater damage,
                // ...but if you get hit, you take more damage.
                try {
                    System.out.println( "\nDo you feel lucky?" );
                    System.out.println( "\t1: Nay.\n\t2: Aye!" );
                    i = Integer.parseInt( in.readLine() );
                }
                catch ( IOException e ) { }

                if ( i == 2 )
                    pat.specialize();
                else
                    pat.normalize();

                d1 = pat.attack( smaug );
                d2 = smaug.attack( pat );

                System.out.println( "\n" + pat.getName() + " dealt " + d1 + " points of damage.");

                System.out.println( "Ye Olde Monster smacked " + pat.getName() + " for " + d2 + " points of damage.\n");

                System.out.println(pat.getName() + "'s health:\t\t\t" + pat.getHealth());
                System.out.println("Ye Olde Monster's health:\t" + smaug.getHealth());
            }

            //option 1: you & the monster perish
            if ( !smaug.isAlive() && !pat.isAlive() ) {
                System.out.println( "'Twas an epic battle, to be sure... " +
                        "You cut ye olde monster down, but " +
                        "with its dying breath ye olde monster. " +
                        "laid a fatal blow upon thy skull." );
                return false;
            }
            //option 2: you slay the beast
            else if ( !smaug.isAlive() ) {
                System.out.println( "HuzzaaH! Ye olde monster hath been slain!" );
                return true;
            }
            //option 3: the beast slays you
            else if ( !pat.isAlive() ) {
                System.out.println( "Ye olde self hath expired. You got dead." );
                return false;
            }
        }

        return true;
    }


    public static void main( String[] args ) {
        YoRPG game = new YoRPG();

        int encounters = 0;
        while( encounters < MAX_ENCOUNTERS ) {
            if ( !game.playTurn() )
                break;
            encounters++;
            System.out.println();
        }

        System.out.println( "Thy game doth be over." );
    }
}

