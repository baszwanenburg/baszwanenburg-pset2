package com.example.bas.baszwanenburg_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Form extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        Intent intent = getIntent();
        Story story = (Story) intent.getSerializableExtra("story");
        givePrompt(story);
    }

    public void fillInStory(View v) {
        Intent intent = getIntent();
        Story story = (Story) intent.getSerializableExtra("story");

        EditText userInput = findViewById(R.id.userInput);
        String newWord = userInput.getText().toString();
        userInput.setText("");
        story.fillInPlaceholder(newWord);

        if (story.isFilledIn()) {
            OpenFinal(story);
        }
        givePrompt(story);
    }

    public void givePrompt(Story story) {
        TextView wordsLeft = findViewById(R.id.wordsLeft);
        TextView wordType = findViewById(R.id.wordType);

        int wordCount = story.getPlaceholderRemainingCount();
        String wordsLeftString = wordCount + " word(s) left";
        wordsLeft.setText(wordsLeftString);

        String wordsTypeString = "Please type a/an " + story.getNextPlaceholder();
        wordType.setText(wordsTypeString);
    }

    private void OpenFinal(Story story) {
        Intent intentForm = new Intent(this, Final.class);
        intentForm.putExtra("story", story);

        startActivity(intentForm);
    }
}