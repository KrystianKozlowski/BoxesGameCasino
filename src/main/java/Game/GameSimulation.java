package Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Krystian on 2017-03-16.
 */
public class GameSimulation {

    public static int returnBounty() {
        int sum;
        int lives;
        ArrayList<Box> boxes = new ArrayList<Box>();
        lives = 1;
        sum = 0;
        int bonusNumber;
        int indexOfBox;

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

        List<Integer> openingSequence = new ArrayList<Integer>();
        for (int i=0; i<12; i++){
            openingSequence.add(i);
        }

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

        try {
            do { // wskaż pudełko do otworzenia

                indexOfBox = randomizer.nextInt(openingSequence.size());

                // sprawdź czy pudełko jest już otwarte
                boxes.get(openingSequence.get(indexOfBox)).open();
                switch (boxes.get(openingSequence.get(indexOfBox)).getBounty()) {
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
                        lives++;
                        break;
                    case "GAME OVER":
                        lives--;
                        break;
                }
                openingSequence.remove(indexOfBox);

                //jeśli koniec gry to losuj bonus
                if (lives == 0) {
                    bonusNumber = randomizer.nextInt(bonus.size());
                    switch (bonus.get(bonusNumber)) {
                        case "5 EURO":
                            sum += 5;
                            break;
                        case "10 EURO":
                            sum += 10;
                            break;
                        case "20 EURO":
                            sum += 20;
                            break;
                        case "EXTRA LIFE":
                            lives += 1;
                            break;
                    }
                    bonus.remove(bonusNumber);
                }


            } while (lives > 0);
        }catch(Exception e){

        }
        return sum;
    }
}
