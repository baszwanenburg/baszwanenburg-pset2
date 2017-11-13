package com.example.bas.baszwanenburg_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Final extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        
        Intent intentForm = getIntent();
        Story story = (Story) intentForm.getSerializableExtra("story");
        
        TextView finalStory = findViewById(R.id.finalStory);
        String text = story.toString();
        finalStory.setText(text);
    }

    public void openMain(View v) {
        Intent intentMain = new Intent(this, MainActivity.class);
        startActivity(intentMain);
        finish();
    }
}