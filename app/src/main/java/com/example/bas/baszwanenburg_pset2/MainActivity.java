package com.example.bas.baszwanenburg_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import java.io.IOException;
import java.util.Random;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    public InputStream stream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public Story pickStory() throws IOException {
        Random rand = new Random();
        int rng = rand.nextInt(4) + 1;
        if (rng == 1)
            stream = getAssets().open("madlib0_simple.txt");
        else if (rng == 2)
            stream = getAssets().open("madlib1_tarzan.txt");
        else if (rng == 3)
            stream = getAssets().open("madlib2_university.txt");
        else if (rng == 4)
            stream = getAssets().open("madlib3_clothes.txt");
        else if (rng == 5)
            stream = getAssets().open("madlib4_dance.txt");

        Story story = new Story(stream);
        return story;
    }

    public void OpenForm (View view) throws IOException {
        Story story = pickStory();
        Intent intent = new Intent (this, Form.class);
        intent.putExtra("story", story);
        startActivity(intent);
    }
}