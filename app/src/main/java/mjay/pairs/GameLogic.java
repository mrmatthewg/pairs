package mjay.pairs;

import static mjay.pairs.ImageAdapter.mThumbIds;



public class GameLogic {


    public static int[] dinosaur = {
            R.drawable.bronto1, R.drawable.bronto1,             //References the dinosaurs.
            R.drawable.bronto2, R.drawable.bronto2,
            R.drawable.bronto3, R.drawable.bronto3,
            R.drawable.dino1, R.drawable.dino1,
            R.drawable.dino2, R.drawable.dino2,
            R.drawable.dino3, R.drawable.dino3,
            R.drawable.steg1, R.drawable.steg1,
            R.drawable.steg2, R.drawable.steg2,
            R.drawable.steg3, R.drawable.steg3
    };

    static int firstCardDinosaur;
    static int firstCardPosition;
    static int secondCardDinosaur;
    static int secondCardPosition;
    static int pairs;
    static boolean reset = true;
    static boolean cardOpen = false;
    static boolean cardOpen2 = false;
    static boolean paired[] = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
    static boolean pairedReset[] = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

    public static void logic(int position) {

        if (!paired[position]) {
            if (reset == true) {                                                //Checks for reset condition.
                mThumbIds[firstCardPosition] = R.drawable.cardback;
                mThumbIds[secondCardPosition] = R.drawable.cardback;
                reset = false;
                cardOpen = false;
                cardOpen2 = false;
            }
            if (!cardOpen) {
                mThumbIds[position] = dinosaur[position];
                firstCardDinosaur = dinosaur[position];
                firstCardPosition = position;
                cardOpen = true;
            } else {

                if ((!cardOpen2) && (position != firstCardPosition)) {            // Added the && condition,
                    mThumbIds[position] = dinosaur[position];                   // So that double clicks can be avoided.
                    secondCardDinosaur = dinosaur[position];                    // I may move this.
                    secondCardPosition = position;
                    cardOpen2 = true;
                } else {
                    reset = true;
                }

                if (firstCardDinosaur == secondCardDinosaur) {                  // Compares the dinosaurs to check for match.
                    paired[firstCardPosition] = true;                           // Updates the paired array.
                    paired[secondCardPosition] = true;
                    pairs = pairs + 1;                                          // Increments number of pairs.
                    cardOpen = false;
                    cardOpen2 = false;


                } else {
                    reset = true;                                               // Reset to true, for next click.
                }
            }

        }
    }
}



