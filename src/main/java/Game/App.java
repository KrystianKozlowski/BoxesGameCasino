package Game;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String option;

        System.out.println( "############################" );
        System.out.println( "#### 1 - PLAY NEW GAME  ####" );
        System.out.println( "#### 2 - EXPECTED VALUE ####" );
        System.out.println( "#### 3 - QUIT GAME      ####" );
        System.out.println( "#############################" );

        Scanner sc = new Scanner(System.in);


        do {
            option = sc.nextLine();
            if(option.equals("1")){
                Game newGame = new Game();
                            }
            else if(option.equals("2")){
                System.out.println("CALCULATING AVERAGE RESULT FOR 10 MILION GAMES...");
                int prize;
                double sum = 0;
                for (int i = 0; i < 10000000; i++) {
                    prize = GameSimulation.returnBounty();
                    sum += prize;
                }
                System.out.format("%.2f EURO", sum/10000000);
            }
            else if(option.equals("3")) {
                System.out.println( "### SEE YA ! ###" );
                System.exit(0);
            }
            else{
                System.out.println( "### CHOOSE 1, 2 OR 3 ###" );
            }
        }  while(!option.equals("1") && !option.equals("2") && !option.equals("3"));



    }
}
