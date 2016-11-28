import java.io.*;
import java.util.*;

public class YoRPG {
    //change this constant to set number of encounters in a game
    private static int encounters = 0;
    private static int explored = 0;
    public final static int MAX_ENCOUNTERS = 5;
    public final static int MAX_EXPLORES = 10;
    private static Player pat;
    private Monster smaug;
    int _class = 1;

    private int moveCount;
    private boolean gameOver;
    private int difficulty = 1;

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
        String name = "pat";

        s = "Welcome to Ye Olde RPG!\n";
        s += "\nChoose your difficulty: \n";
        s += "\t1: Easy\n";
        s += "\t2: Not so easy\n";
        s += "\t3: Beowulf hath nothing on me. Bring it on.\n";
        s += "Selection [1]: ";
        System.out.print( s );


        try {
            difficulty = Integer.parseInt( in.readLine() );
        }
        catch ( IOException | NumberFormatException e ) { }


        s = "\nIntrepid adventurer, what doth thy call thyself? [pat]: ";
        System.out.print( s );

        try {
            String newname = in.readLine();

            if ( ! newname.equals("") ) {
                name = newname;
            }
        }
        catch ( IOException | NullPointerException e ) { }


        System.out.println("\nGlorious adventurer, what class doth thy be?\n"
                + "\t1. Warrior\n"
                + "\t2. Mage\n"
                + "\t3. Rogue\n"
                + "\t4. Barbarian\n"
                + "\t5. Cleric");
        System.out.print("Selection [1]: ");

        try {
            _class = Integer.parseInt(in.readLine());
        }
        catch ( IOException | NumberFormatException e ) { }


        //instantiate the player's character
        if ( _class == 1 ) {
            pat = new Warrior(name);
        }
        else if ( _class == 2 ) {
            pat = new Mage(name);
        }
        else if ( _class == 3 ) {
            pat = new Rogue(name);
        }
        else if ( _class == 4 ) {
            pat = new Barbarian(name);
        }
        else if ( _class == 5 ) {
            pat = new Cleric(name);
        }

        System.out.println("\n" + pat.about());
        System.out.println("\n" + "---" + pat.getClass() + "---");

    }

    // Given the correct inputs, returns:
    // left1    right1
    // left2    right2
    // where "    " is at least minimum large
    // TODO Is there a cleaner way to do this?
    public String spaceGenerator(int i) {
        String retStr = "";

        for ( ; i > 0; i-- ) {
            retStr += " ";
        }

        return retStr;
    }

    public String properSpacing(String left1, String right1, String left2, String right2, int minimum) {
        int longerL = 0;
        int longerR = 0;
        String min = spaceGenerator(minimum);

        if ( left1.length() > left2.length() ) {
            left2 += spaceGenerator( left1.length() - left2.length() );
        } else {
            left1 += spaceGenerator( left2.length() - left1.length() );
        }

        left1 += min;
        left2 += min;

        if ( right1.length() > right2.length() ) {
            left2 += spaceGenerator( right1.length() - right2.length() );
        } else {
            left1 += spaceGenerator( right2.length() - right1.length() );
        }

        return left1 + right1 + "\n" + left2 + right2;
    }


    public boolean playTurn() {
        int i = 1;
        int d1, d2;

        if ( Math.random() >= ( difficulty / 3.0 ) )
            System.out.println( "\nNothing to see here. Move along!" );
        else {
            System.out.println( "\nLo, yonder monster approacheth!" );

            smaug = new Monster();
            encounters++;

            while( smaug.isAlive() && pat.isAlive() ) {
                // Give user the option of using a special attack:
                // If you land a hit, you incur greater damage,
                // ...but if you get hit, you take more damage.
                try {
                    if ( _class != 2 ) {
                        System.out.println( "\nDo you feel lucky? [1]" );
                        System.out.println( "\t1: Nay.\n\t2: Aye!" );
                    } else {
                        System.out.println(" \nFireball or no Fireball? [1]" );
                        System.out.println( "\t1: Nay.\n\t2: Aye!");
                    }
                    i = Integer.parseInt( in.readLine() );
                }
                catch ( IOException | NumberFormatException  e ) { }

                if ( i == 2 )
                    pat.specialize();
                else
                    pat.normalize();

                d1 = pat.attack( smaug );
                d2 = smaug.attack( pat );

                if (_class == 2 && pat.getAttack() == 3.0){
                    if (Math.random() > .5)
                        System.out.println( "\n" + pat.getName() + " roasted the beast for " + d1 + " points of damage.");
                    else
                        System.out.println( "\n" + pat.getName() + " blasted the beast for " + d1 + " points of damage.");
                }
                else {
                    System.out.println( "\n" + pat.getName() + " dealt " + d1 + " points of damage.");
                }

                System.out.println( "Ye Olde Monster smacked " + pat.getName() + " for " + d2 + " points of damage.\n");

                System.out.println(
				   properSpacing(
						 pat.getName() + "'s health:",
						 Integer.toString(pat.getHealth()),
						 "Ye Olde Monster's health:",
						 Integer.toString(smaug.getHealth()),
						 5));
            }

            //option 1: you & the monster perish
            if ( !smaug.isAlive() && !pat.isAlive() ) {
                System.out.println( "\n'Twas an epic battle, to be sure... " +
				    "You cut ye olde monster down, but " +
				    "with its dying breath ye olde monster " +
				    "laid a fatal blow upon thy skull." );
                return false;
            }
            //option 2: you slay the beast
            else if ( !smaug.isAlive() ) {
                System.out.println( "HuzzaaH! Ye olde monster hath been slain!" );

		//purchasing potions to heal is only an option after you slay the beast
		try{
		    System.out.println("\nWould you like to purchase a poition to heal thyself?");
		    System.out.println("\t1: Aye! \n\t2: Nay.");
		    i = Integer.parseInt( in.readLine() );
		}
		
		catch ( IOException e ) { }

		if(i == 1){
		    try{
			System.out.println("\t1: Small Potions: 20 coins \n\t2: Medium Potions: 50 coins \n\t3: Large Potions: 100 coins");
			System.out.println("Which one do you want?");
			i = Integer.parseInt( in.readLine() );
		    }

		    catch (IOException e) { }

		    if(i == 1){
			pat.coins = pat.coins - 20;
			pat.health = pat.health + 20;

			System.out.println("Health: " + pat.health);
			System.out.println("Coins: " + pat.coins);
		    }
		    else if(i == 2){
			pat.coins = pat.coins - 50;
			pat.health = pat.health + 50;
			
			System.out.println("\nHealth: " + pat.health);
			System.out.println("Coins: " + pat.coins);			

		    }
		    else{
			pat.coins = pat.coins - 100;
			pat.health = pat.health + 100;
			
			System.out.println("Health: " + pat.health);
			System.out.println("Coins: " + pat.coins);
		    }
		}
		else{
		    pat.coins = pat.coins;
		}

                return true;
            }
            //option 3: the beast slays you
            else if ( !pat.isAlive() ) {
                System.out.println( "\nYe olde self hath expired. You got dead." );
                return false;
            }
        }

        return true;
    }


    public static void main( String[] args ) {
        YoRPG game = new YoRPG();

        while( explored < MAX_EXPLORES && encounters < MAX_ENCOUNTERS ) {
            if ( !game.playTurn() )
                break;
            explored++;
            System.out.println();
        }

        String alive = "";
        if ( pat.isAlive() ) {
            alive = "won";
        } else {
            alive = "died";
        }

        String beasts = " beast";
        if ( encounters > 1 ) {
            beasts += "s";
        }

        String moves = " move";
        if ( pat.moves > 1 ) {
            moves += "s";
        }

        int score = ( pat.damage_dealt * encounters ) + explored / pat.moves;
        if ( pat.isAlive() ) {
            score *= 2;
        }

        System.out.println("\nYe " + alive + " after dealing "
                + pat.damage_dealt + " damage to " + encounters + beasts
                + " while exploring " + explored + " locations in " + pat.moves
                + moves + ".");

        System.out.println("Final score: " + score);
        System.out.println( "\nThy game doth be over." );
    }
}

