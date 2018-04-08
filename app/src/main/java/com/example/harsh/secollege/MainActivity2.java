package com.example.harsh.secollege;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener{
    private CardView card11,card22,card33,card44;


    @Override
    protected void onCreate(Bundle savedInstanceState)
{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        card11 = (CardView) findViewById(R.id.card1);
        card22 = (CardView) findViewById(R.id.card2);
        card33 = (CardView) findViewById(R.id.card3);
        card44 = (CardView) findViewById(R.id.card4);
        card11.setOnClickListener(this);
        card22.setOnClickListener(this);
        card33.setOnClickListener(this);
        card44.setOnClickListener(this);


        }



@Override
public void onClick(View v) {

        Intent i;


        switch (v.getId()) {
        case R.id.card1:
        i = new Intent(this, MainActivity.class);
        startActivity(i);
        break;
        case R.id.card2:
        i = new Intent(this, Results.class);
        startActivity(i);
        break;
        case R.id.card3:
                i = new Intent(this,Match.class);
                startActivity(i);
                break;

                case R.id.card4:
                        i = new Intent(this,Addhar.class);
                        startActivity(i);
                        break;

                default:
                break;

        }
        }


}
