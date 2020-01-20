package edu.psu.jjb24.clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int clickCount = 0;  // The number of times the user clicked
    int[] clickLevels = {243, 81, 27, 9, 3, 1};
    String[] rewardDescriptions = {"The Eiffel Tower", "A 20 foot waterfall", "The London Eye",
            "A sleeping puppy", "A field of sunflowers" , "An unmowed yard"};
    int[] rewardIds = {R.id.imageEiffel, R.id.imageWaterfall, R.id.imageLondonEye,
            R.id.imagePuppy, R.id.imageSunflower, R.id.imageUnmowedYard};
    TextView textClicks;
    TextView textRewards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("life_cycle", "onCreate invoked");
        super.onCreate(savedInstanceState);
        textClicks = (TextView) findViewById(R.id.textClickCount);
        textRewards = (TextView) findViewById(R.id.textEarnings);
        setContentView(R.layout.activity_main);
    }

    public void buttonClick(View button) {
        clickCount++;
        textClicks.setText(clickCount + " clicks.");
        for (int i = 0; i < clickLevels.length; i++) {
            if (clickCount == clickLevels[i]) {
                findViewById(rewardIds[i]).setAlpha(1);
                String text = textRewards.getText().toString();
                Log.d("edu",":" + text + ":");
                if (text.length() == 0) text = "You have won:";
                text += "\n" + rewardDescriptions[i];
                textRewards.setText(text);
                break;
            }
        }
    }

    @Override
    protected void onPause() {
        Log.d("life_cycle", "onPause invoked");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d("life_cycle", "onStop invoked");
        super.onStop();
    }

    public void onRestorelnstanceState(Bundle savedInstanceState) {
        Log.d("life_cycle", "onRestoreInstanceState invoked");
    }

    public void onSaveInstanceState(Bundle outState) {
        Log.d("life_cycle", "onSaveInstanceState invoked");
    }
}
