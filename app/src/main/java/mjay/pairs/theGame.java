package mjay.pairs;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.larvalabs.svgandroid.SVG;
import com.larvalabs.svgandroid.SVGParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static mjay.pairs.R.*;


public class theGame extends Activity{

    // Create a new ImageView
    public ImageView d1 = (ImageView) findViewById(id.x0);
    public ImageView d2 = (ImageView) findViewById(id.x1);
    public ImageView d3 = (ImageView) findViewById(id.x2);
    public ImageView d4 = (ImageView) findViewById(id.x3);
    public ImageView d5 = (ImageView) findViewById(id.x4);
    public ImageView d6 = (ImageView) findViewById(id.x5);
    public ImageView d7 = (ImageView) findViewById(id.x6);
    public ImageView d8 = (ImageView) findViewById(id.x7);
    public ImageView d1b = (ImageView) findViewById(id.x8);
    public ImageView d2b = (ImageView) findViewById(id.x9);
    public ImageView d3b = (ImageView) findViewById(id.x10);
    public ImageView d4b = (ImageView) findViewById(id.x11);
    public ImageView d5b = (ImageView) findViewById(id.x12);
    public ImageView d6b = (ImageView) findViewById(id.x13);
    public ImageView d7b = (ImageView) findViewById(id.x14);
    public ImageView d8b = (ImageView) findViewById(id.x15);

    /* These colours use 8 digit hex format ARGB library didn't tell me this */
    Integer colour[] = {0xFF1756c9, 0xFF1756c9, 0xFFCC0099, 0xFF993333, 0xFF00CCFF, 0xFFCC6600, 0xFF003300, 0xFFFF0030, 0xFF1756c9, 0xFF1756c9, 0xFF1756c9, 0xFFCC0099, 0xFF993333, 0xFF00CCFF, 0xFFCC6600, 0xFF003300, 0xFFFF0030, 0xFF1756c9};
    ImageView[] dinosaurs = {d1, d2, d3, d4, d5, d6, d7, d8, d1b, d2b, d3b, d4b, d5b, d6b, d7b, d8b};

    int setupFlag = 0;
    int shuffleFlag = 1;
    int cardNumber = 0;
    boolean cardOpened = false;
    int firstCard;
    int secondCard;
    int firstCardNumber;
    boolean paired[] = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*if (setupFlag == 0) {
            addShortcut();
        } */
        if (shuffleFlag == 0){
            shuffleColours();
        }

    }

    public void shuffleColours(){
            Collections.shuffle(Arrays.asList(colour));  //randomise
            shuffleFlag = 1;
        }

    public void colourDinosaur() {
       {
            // Set the background color to white
            dinosaurs[cardNumber].setBackgroundColor(Color.WHITE);
            // Parse the SVG file from the resource
            SVG svg = SVGParser.getSVGFromResource(getResources(), raw.talldinosaur, 0xFF698000/*old colour*/, colour[cardNumber] /*new colour*/);
            // Get a drawable from the parsed SVG and set it as the drawable for the ImageView
            dinosaurs[cardNumber].setBackground(svg.createPictureDrawable());
            // Set the ImageView as the content view for the Activity
            setContentView(dinosaurs[cardNumber]);
        }
       }

    public void cardCloser(){

        dinosaurs[firstCardNumber].setVisibility(View.INVISIBLE);       // Hiding card.
        dinosaurs[cardNumber].setVisibility(View.INVISIBLE);
        cardOpened = false;                                             // Resetting cardopen for future use

    }

    public void paired(){

        paired[cardNumber] = true;     // Used to avoid card being checked again.
        paired[firstCardNumber] = true;
        cardOpened = false;             //Resetting card Open for future use.
    }                                   //Don't need to worry about a previous card being opened.

    public void cardCompare(){

        if (paired[cardNumber] == false) {

            colourDinosaur();                                           // Create card.
            dinosaurs[cardNumber].setVisibility(View.VISIBLE);          // Make it show.

            if (cardOpened = false) {                                   // Check if a card has been opened.
                firstCard = colour[cardNumber];                         // store card design.
                firstCardNumber = cardNumber;                           // store card number.
                cardOpened = true;                                      // toggle card opened logic.
            } else {
                secondCard = colour[cardNumber];                       // store second card design

                if ((firstCard == secondCard) && (cardNumber != firstCardNumber)) { // compare card designs and check that the same card hasn't been pressed.
                    paired();        // when true, go to paired function.
                } else {
                    cardCloser();
                }
            }


        }

    }

    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.x0: cardNumber = 0;
                cardCompare();
            case R.id.x1: cardNumber = 1;
                cardCompare();
            case R.id.x2: cardNumber = 2;
                cardCompare();
            case R.id.x3: cardNumber = 3;
                cardCompare();
            case R.id.x4: cardNumber = 4;
                cardCompare();
            case R.id.x5: cardNumber = 5;
                cardCompare();
            case R.id.x6: cardNumber = 6;
                cardCompare();
            case R.id.x7: cardNumber = 7;
                cardCompare();
            case R.id.x8: cardNumber = 8;
                cardCompare();
            case R.id.x9: cardNumber = 9;
                cardCompare();
            case R.id.x10: cardNumber = 10;
                cardCompare();
            case R.id.x11: cardNumber = 11;
                cardCompare();
            case R.id.x12: cardNumber = 12;
                cardCompare();
            case R.id.x13: cardNumber = 13;
                cardCompare();
            case R.id.x14: cardNumber = 14;
                cardCompare();
            case R.id.x15: cardNumber = 15;
                cardCompare();
        }
    }


}