package com.example.anweshan.eazzycounter;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView countTextView;
    Button increaseButton;
    Button resetButton;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countTextView = (TextView) findViewById(R.id.Count);
        increaseButton = (Button) findViewById(R.id.increase);
        count = 0;
        initialize();

        increaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increase();
            }
        });


    }

    protected void initialize(){
        countTextView.setText("" + count);
        countTextView.setTextColor(Color.rgb(0,87,75));
    }
    public void increase(){
        count++;
        countTextView.setText("" + count);
    }
}
