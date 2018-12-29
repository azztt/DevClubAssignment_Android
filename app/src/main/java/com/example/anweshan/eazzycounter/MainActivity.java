package com.example.anweshan.eazzycounter;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextSwitcher;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView countTextView;
    Button increaseButton;
    Button resetButton;
    Spinner factorSpinner;
    TextSwitcher myTextSwitcher;
    Animation anim;
    int count;
    int factor;
    ArrayList<Integer> list;
    ArrayAdapter<Integer> SpinnerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countTextView = (TextView) findViewById(R.id.Count);
        increaseButton = (Button) findViewById(R.id.increase);
        resetButton = (Button) findViewById(R.id.reset);
        factorSpinner = (Spinner) findViewById(R.id.factor);

        count = 0;
        anim = new AlphaAnimation(1.0f,1.0f);

        list = new ArrayList<Integer>();
        for (int i = 1 ; i <= 10000 ; i++) {
            list.add(i);
        }


        SpinnerAdapter = new ArrayAdapter<Integer>(this,android.R.layout.simple_spinner_item,list){
            public View getView(int position, View convertView, ViewGroup parent){
                View v = super.getView(position,convertView,parent);
                ((TextView) v).setTextColor(Color.parseColor("#00574B"));
                return v;
            }
            public View getDropDownView(int position, View convertView, ViewGroup parent){
                View v = super.getDropDownView(position,convertView,parent);
                v.setBackgroundColor(Color.parseColor("#00574B"));
                ((TextView) v).setTextColor(Color.parseColor("#ffffff"));
                return v;
            }
        };
        SpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        factorSpinner.setAdapter(SpinnerAdapter);
        initialize();

        increaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increase();
            }
        });
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });

    }

    protected void initialize(){
        countTextView.setText("" + count);
        countTextView.setTextColor(Color.rgb(0,87,75));
    }
    public void increase(){
        factor = (int) factorSpinner.getSelectedItem();
        count = count + factor;
        Animation animFadeOut = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
        countTextView.startAnimation(animFadeOut);
        countTextView.setText("" + count);
        Animation animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        countTextView.startAnimation(animFadeIn);
    }
    public void reset(){
        count = 0;
        Animation animFadeOut = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
        countTextView.startAnimation(animFadeOut);
        countTextView.setText("" + count);
        Animation animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        countTextView.startAnimation(animFadeIn);
    }
}
