package np.com.sagunrajlage.higherorlower;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static np.com.sagunrajlage.higherorlower.R.id.guesseditText;
import static np.com.sagunrajlage.higherorlower.R.layout.activity_main;

public class MainActivity extends AppCompatActivity {
    int randomnumber, count;
    TextView guessnumberTextView;
    EditText guesseditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);
        guessnumberTextView = (TextView) findViewById(R.id.guessnumberTextView);
        guesseditText = (EditText) findViewById(R.id.guesseditText);
        Random rand = new Random();
        randomnumber = rand.nextInt(20) + 1;


    }

    public void makeToast(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }


    public void guess(View view) {
        count++;

        if (guesseditText.getText().length() > 0) {
            int guessInt = Integer.parseInt(guesseditText.getText().toString());
            if (guessInt > randomnumber) {
                makeToast("Guess a lower number!");
            } else if (guessInt < randomnumber) {
                makeToast("Guess a higher number!");
            } else {
                makeToast("You got it! " + randomnumber + " was the number. Now guess the new number I chose.");
                makeToast("Number of counts: "+count);
                Random rand = new Random();
                randomnumber = rand.nextInt(20) + 1;
                count=0;
            }
            guesseditText.setText("");
            guessnumberTextView.setText("Number of guesses: " + Integer.toString(count));
        } else {
            makeToast("Please guess a number.");
        }
    }

}
