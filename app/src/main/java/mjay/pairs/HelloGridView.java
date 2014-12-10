package mjay.pairs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.Random;


public class HelloGridView extends Activity {

    static int allPairs = 0;
    static int level = 0;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        allPairs = GameLogic.dinosaur.length / 2;   // Used later to determine how many pairs are needed to restart game.


        shuffleDinosaurs();

        final GridView gridview = (GridView) findViewById(R.id.gridview);           //Experimenting with setting fullscreen view.
        gridview.setAdapter(new ImageAdapter(this));
        gridview.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE);


        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {         //Listen for clicks.

                GameLogic.logic(position);                                      // Runs my game logic.

                gridview.invalidateViews();                                     // Tells gridview to update.


                if (allPairs == GameLogic.pairs) {                              // Checks for game completion.

                    GameLogic.cardOpen = false;                                 // resets variables, so that I am certain
                    GameLogic.cardOpen2 = false;                                // that they are reset.
                    GameLogic.pairs = 0;
                    GameLogic.reset = false;

                    level = level + 1;

                    if (level == 0) {

                        GameLogic.dinosaur = new int[6];
                        ImageAdapter.mThumbIds = new Integer[6];

                        System.arraycopy(GameLogic.pairedReset, 0, GameLogic.paired, 0, GameLogic.paired.length);                   //Resets the paired array.
                        System.arraycopy(ImageAdapter.resetThumbIds, 0, ImageAdapter.mThumbIds, 0, ImageAdapter.resetThumbIds.length);   // Copies a fresh set of images.
                        System.arraycopy(GameLogic.dinosaur0, 0, GameLogic.dinosaur, 0, GameLogic.dinosaur0.length);
                        shuffleDinosaurs();
                    }

                    if (level == 1) {

                        GameLogic.dinosaur = new int[12];
                        ImageAdapter.mThumbIds = new Integer[12];

                        System.arraycopy(GameLogic.pairedReset, 0, GameLogic.paired, 0, GameLogic.paired.length);                   //Resets the paired array.
                        System.arraycopy(ImageAdapter.resetThumbIds1, 0, ImageAdapter.mThumbIds, 0, ImageAdapter.resetThumbIds1.length);   // Copies a fresh set of images.
                        System.arraycopy(GameLogic.dinosaur1, 0, GameLogic.dinosaur, 0, GameLogic.dinosaur1.length);
                        shuffleDinosaurs();
                    }

                    if (level == 2) {

                        GameLogic.dinosaur = new int[18];
                        ImageAdapter.mThumbIds = new Integer[18];

                        System.arraycopy(GameLogic.pairedReset, 0, GameLogic.paired, 0, GameLogic.paired.length);                   //Resets the paired array.
                        System.arraycopy(ImageAdapter.resetThumbIds2, 0, ImageAdapter.mThumbIds, 0, ImageAdapter.resetThumbIds2.length);   // Copies a fresh set of images.
                        System.arraycopy(GameLogic.dinosaur2, 0, GameLogic.dinosaur, 0, GameLogic.dinosaur2.length);
                        shuffleDinosaurs();

                        level = -1;
                    }


                    Intent intent = getIntent();
                    finish();                       //Restarts the activity.
                    startActivity(intent);


                }
            }

        });

    }

    public void shuffleDinosaurs() {

        Random randomNo = new Random();  // Random number generator

        for (int i = 0; i < GameLogic.dinosaur.length; i++) {              // Randomises position of dinosaurs.
            int randomPosition = randomNo.nextInt(GameLogic.dinosaur.length);
            int temp = GameLogic.dinosaur[i];
            GameLogic.dinosaur[i] = GameLogic.dinosaur[randomPosition];
            GameLogic.dinosaur[randomPosition] = temp;
        }


    }

}






