package mjay.pairs;

import static mjay.pairs.ImageAdapter.mThumbIds;



public class GameLogic {


    public static Integer[] dinosaur = {
            R.drawable.bronto1, R.drawable.bronto1,
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
    static int wrongCardPosition;
    static boolean cardOpen = false;
    static boolean wrongCard = false;
    static boolean paired[] = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};


    public static void logic(int position) {


        if (!paired[position]) {
            if (!cardOpen) {
                mThumbIds[position] = dinosaur[position];
                firstCardDinosaur = dinosaur[position];
                firstCardPosition = position;
                cardOpen = true;
            } else {

                if (dinosaur[position].equals(firstCardDinosaur)) {
                    mThumbIds[position] = dinosaur[position];
                    paired[position] = true;     // Used to avoid card being checked again.
                    paired[firstCardPosition] = true;
                    cardOpen = false;
                } else {
                    mThumbIds[firstCardPosition] = R.drawable.cardback;
                    mThumbIds[position] = dinosaur[position];
                    wrongCard = true;
                    cardOpen = true;
                    wrongCardPosition = position;
                }


            }

        }

    }
}