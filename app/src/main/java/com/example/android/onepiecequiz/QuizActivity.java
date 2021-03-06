package com.example.android.onepiecequiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * This QuizActivity displays from question 1 to question 8 about One Piece.
 */

public class QuizActivity extends AppCompatActivity{

    private int count;

    private CheckBox tashigiCheckBox;
    private CheckBox kuinaCheckBox;
    private CheckBox nicoRobinCheckBox;
    private CheckBox nojikoCheckBox;
    private CheckBox redForceCheckBox;
    private CheckBox thousandSunnyCheckBox;
    private CheckBox mobyDickCheckBox;
    private CheckBox goingMerryCheckBox;
    private EditText editText;

    private String[] quizResult = new String[8];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // Find submit button
        Button submitButton = findViewById(R.id.submit_button);

        // Find checkbox for Tashigi
        tashigiCheckBox = findViewById(R.id.tashigi_checkbox);

        // Find checkbox for kuina
        kuinaCheckBox = findViewById(R.id.kuina_checkbox);

        // Find checkbox for NicoRobin
        nicoRobinCheckBox = findViewById(R.id.nico_robin_checkbox);

        // Find checkbox for Nojiko
        nojikoCheckBox = findViewById(R.id.nojiko_checkbox);

        // Find checkbox for Going Merry
        goingMerryCheckBox = findViewById(R.id.going_merry_checkbox);

        // Find checkbox for Thousand Sunny
        thousandSunnyCheckBox = findViewById(R.id.thousand_sunny_checkbox);

        // Find checkbox for Moby Dick
        mobyDickCheckBox = findViewById(R.id.moby_dick_checkbox);

        // Find checkbox for Red Force
        redForceCheckBox = findViewById(R.id.red_force_checkbox);

        // Find the editText for question 6
        editText = findViewById(R.id.six_edit_text);

        // Set a click listener on submit button
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Check if the answer to question 4 is "Tashigi" and "Kuina"
                if (tashigiCheckBox.isChecked() && kuinaCheckBox.isChecked()
                        && !nicoRobinCheckBox.isChecked() && !nojikoCheckBox.isChecked()) {
                    count += 1;
                    quizResult[3] = getString(R.string.o);
                }
                else {
                    quizResult[3] = getString(R.string.x);
                }

                // Check if the answer to question 6 is "Reverse Mountain"
                // Get text string form editText and remove whitespace
                String numberSixAnswer = editText.getText().toString().trim();

                // Compare with the correct answer to see if the answer is correct.
                if (numberSixAnswer.toLowerCase().equals(getString(R.string.reverse_mountain))) {
                    count += 1;
                    quizResult[5] = getString(R.string.o);
                }
                else {
                    quizResult[5] = getString(R.string.x);
                }

                // Check if the answer to question 8 is "Going Merry" and "Thousand Sunny"
                if (goingMerryCheckBox.isChecked() && thousandSunnyCheckBox.isChecked()
                        && !mobyDickCheckBox.isChecked() && !redForceCheckBox.isChecked()) {
                    count += 1;
                    quizResult[7] = getString(R.string.o);
                }
                else {
                    quizResult[7] = getString(R.string.x);
                }

                // Create a new intent to open the {@link ScoreActivity}
                Intent quizIntent = new Intent(QuizActivity.this, ScoreActivity.class);
                // Pass count value from QuizActivity to ScoreActivity
                quizIntent.putExtra("count", count);

                // Pass quizResult value from QuizActivity to ScoreActivity
                quizIntent.putExtra("result", quizResult);

                // Start the new activity
                Toast.makeText(QuizActivity.this, getString(R.string.toast_message)+ " " + count + "/8", Toast.LENGTH_SHORT).show();
                startActivity(quizIntent);
            }
        });

        // Check if the answer to question 1 is "He cannot swim."
        // Find the radio group in question 1
        RadioGroup numberOneGroup = findViewById(R.id.number_one_radio_group);
        numberOneGroup.clearCheck();
        numberOneGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if (checkedId == R.id.swim_radio) {
                    count += 1;
                    quizResult[0] = getString(R.string.o);
                }
                else {
                    quizResult[0] = getString(R.string.x);
                }
            }
        });

        // Check if the answer to question 2 is "Sanji"
        // Find radio group for question 2
        RadioGroup numberTwoGroup = findViewById(R.id.number_two_radio_group);
        numberTwoGroup.clearCheck();
        // This listener gets triggered whenever the checked radio button changed in this radio group
        numberTwoGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if (checkedId == R.id.sanji_radio) {
                    count += 1;
                    quizResult[1] = getString(R.string.o);
                }
                else {
                    quizResult[1] = getString(R.string.x);
                }
            }
        });

        // Check if the answer to question 3 is "Arlong Pirates"
        // Find the radio group in question 3
        RadioGroup numberThreeGroup = findViewById(R.id.number_three_radio_group);
        numberThreeGroup.clearCheck();
        numberThreeGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if (checkedId == R.id.arlong_radio) {
                    count += 1;
                    quizResult[2] = getString(R.string.o);
                }
                else {
                    quizResult[2] = getString(R.string.x);
                }
            }
        });

        // Check if the answer to question 5 is "Doctor"
        // Find the radio group in question 5
        RadioGroup numberFiveGroup = findViewById(R.id.number_five_radio_group);
        numberFiveGroup.clearCheck();
        numberFiveGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if (checkedId == R.id.doctor_radio) {
                    count += 1;
                    quizResult[4] = getString(R.string.o);
                }
                else {
                    quizResult[4] = getString(R.string.x);
                }
            }
        });

        // Check if the answer to question 7 is "30 million beri"
        // Find the radio group in question 7
        RadioGroup numberSevenGroup = findViewById(R.id.number_seven_radio_group);
        numberSevenGroup.clearCheck();
        numberSevenGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if (checkedId == R.id.berries_3000_radio) {
                    count += 1;
                    quizResult[6] = getString(R.string.o);
                }
                else {
                    quizResult[6] = getString(R.string.x);
                }
            }
        });

        // Navigate with the app icon in the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    // Go back to the previous screen when up button is clicked.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}