package Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Krystian on 2017-03-16.
 */
public class Game {

    private int sum;
    private int lives;
    private ArrayList<Box> boxes = new ArrayList<Box>();


    public Game() {
        lives = 1;
        sum = 0;
        int bonusNumber;
        int indexOfBox;

        System.out.println( "### WELCOME IN OUR GAME! ###" );

        List<String> bounty = new ArrayList<String>();
        bounty.add("100 EURO");
        bounty.add("20 EURO");
        bounty.add("20 EURO");
        bounty.add("5 EURO");
        bounty.add("5 EURO");
        bounty.add("5 EURO");
        bounty.add("5 EURO");
        bounty.add("5 EURO");
        bounty.add("EXTRA LIFE");
        bounty.add("GAME OVER");
        bounty.add("GAME OVER");
        bounty.add("GAME OVER");

        List<String> bonus = new ArrayList<String>();
        bonus.add("5 EURO");
        bonus.add("10 EURO");
        bonus.add("20 EURO");
        bonus.add("EXTRA LIFE");

        Random randomizer = new Random();
        int indexOfList;

        // dodaj 12 pudełek i losuj wygrane
        for(int i=0;i<12;i++){
            Box newBox = new Box();
            indexOfList=randomizer.nextInt(bounty.size());
            newBox.setBounty(bounty.get(indexOfList));
            boxes.add(newBox);
            bounty.remove(indexOfList);
        }

        do{ // wskaż pudełko do otworzenia
            System.out.println("### WHICH BOX 1-12 DO YOU WANT TO OPEN? ###");
            Scanner sc = new Scanner(System.in);
            try {
                indexOfBox = sc.nextInt();

                // sprawdź czy pudełko jest już otwarte
                if (boxes.get(indexOfBox-1).getIsOpen() == false) {
                    boxes.get(indexOfBox - 1).open();
                    switch ( boxes.get(indexOfBox - 1).getBounty() ) {
                        case "100 EURO":
                            sum += 100;
                            break;
                        case "20 EURO":
                            sum += 20;
                            break;
                        case "5 EURO":
                            sum += 5;
                            break;
                        case "EXTRA LIFE":
                            lives ++;
                            break;
                        case "GAME OVER":
                            lives --;
                            break;
                    }
                } else {
                    System.out.println("### BOX IS ALREADY OPEN! CHOOSE ANOTHER BOX ###");
                }

                // wypisz stan otwartości pudełek
                for (int i=1;i<13;i++) {
                    if(boxes.get(i-1).getIsOpen()==true) {
                        System.out.println("BOX " + String.valueOf(i) + " IS OPENED: " + String.valueOf(boxes.get(i - 1).getIsOpen()).toUpperCase() + " - " + boxes.get(i - 1).getBounty());
                    }
                    else{
                        System.out.println("BOX " + String.valueOf(i) + " IS OPENED: " + String.valueOf(boxes.get(i - 1).getIsOpen()).toUpperCase());
                    }
                }

                System.out.println("### YOUR CURRENT BOUNTY IS: " + String.valueOf(sum) + " EURO ###");

                //jeśli koniec gry to losuj bonus
                if (lives == 0){
                    bonusNumber = randomizer.nextInt(bonus.size());
                    switch (bonus.get(bonusNumber)){
                        case "5 EURO":
                            sum += 5;
                            System.out.println("### YOUR BONUS IS: " + bonus.get(bonusNumber) + " ###");
                            break;
                        case "10 EURO":
                            sum += 10;
                            System.out.println("### YOUR BONUS IS: " + bonus.get(bonusNumber) + " ###");
                            break;
                        case "20 EURO":
                            sum += 20;
                            System.out.println("### YOUR BONUS IS: " + bonus.get(bonusNumber) + " ###");
                            break;
                        case "EXTRA LIFE":
                            lives += 1;
                            System.out.println("### YOUR BONUS IS: 1 " + bonus.get(bonusNumber) + " ###");
                            break;
                    }
                    bonus.remove(bonusNumber);
                }


            }catch (Exception e){
                System.out.println("### PLEASE ENTER NUMBER BETWEEN 1 AND 12 ###");
            }

        } while (lives>0);

        System.out.println("### YOU ARE OUT OF LIVES. YOU WON: " + String.valueOf(sum) + " EURO! ###");
    }

}
