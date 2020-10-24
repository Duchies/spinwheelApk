package com.example.spinwheelapk;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

import rubikstudio.library.LuckyWheelView;
import rubikstudio.library.model.LuckyItem;

import static com.example.spinwheelapk.R.*;

public class MainActivity extends AppCompatActivity {

    LuckyWheelView luckyWheelView;
    ArrayList<LuckyItem> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        luckyWheelView = findViewById(id.luckyWheelViewMain);
        arrayList = new ArrayList<>();

        for(int i =0 ; i< 10 ;i++){
             LuckyItem item = new LuckyItem();

             if(i%2 == 0){
                 item.color = Color.parseColor("#FCE79F");
             }else{
                 item.color =  0xffFFF3E0;
             }

            item.topText = ""+i;
            item.icon = drawable.coins;
            arrayList.add(item);

        }

        luckyWheelView.setData(arrayList);
        luckyWheelView.setRound(getRandom());

        luckyWheelView.setLuckyRoundItemSelectedListener(new LuckyWheelView.LuckyRoundItemSelectedListener() {
            @Override
            public void LuckyRoundItemSelected(int index) {
                Toast.makeText(getApplicationContext(),"Number"+index,Toast.LENGTH_LONG).show();
            }
        });

    }

    private int getRandom() {

        Random random = new Random();
       return  random.nextInt(10)+15;
    }

    public void playGame(View view) {

        int index = getRandomIndex();
        luckyWheelView.startLuckyWheelWithTargetIndex(index);
    }

    private int getRandomIndex() {

        int[] idx = new int[] { 1,2,3,4,5,6,7,8,9};
        int rand = new Random().nextInt(idx.length);
        return  idx[rand];
    }
}