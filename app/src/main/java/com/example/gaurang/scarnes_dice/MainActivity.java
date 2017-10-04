package com.example.gaurang.scarnes_dice;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static com.example.gaurang.scarnes_dice.R.id.cmpscr;
import static com.example.gaurang.scarnes_dice.R.id.textView6;
import static com.example.gaurang.scarnes_dice.R.id.yrscr;

public class MainActivity extends AppCompatActivity {
    public static int usroverallscore;
    public static int usrturnscore;
    public static int cmpoverallscore;
    public static int cmptempscore;
    public static int usrtempscore;
    public static int cmpturnscore;
    Button hold;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button hold= (Button) findViewById(R.id.button2);
    }

    public void rollaction(View v) {

        userroll();

     }

public void userroll()
{
    TextView yrscr=(TextView)findViewById(R.id.yrscr);
    createToast("user turn",1000);
    int dice_number=new Random().nextInt(6)+1;
   // TextView your_score=(TextView)findViewById(R.id.textView5);

    ImageView image=(ImageView)findViewById(R.id.imageView);
    usrtempscore=dice_number;

    if(usroverallscore<100)
    {
        switch (dice_number)
        {
            case 1:
                image.setImageResource(R.drawable.dice1);
                usrturnscore=0;
                usrtempscore=0;
                yrscr.setText("0");
                final Handler h1=new Handler();
                 h1.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        computerroll();

                    }

                },3000);

                break;
            case 2:
                image.setImageResource(R.drawable.dice2);
                break;

            case 3:
                image.setImageResource(R.drawable.dice3);
                break;

            case 4:
                image.setImageResource(R.drawable.dice4);
                break;

            case 5:
                image.setImageResource(R.drawable.dice5);
                break;

            case 6:
                image.setImageResource(R.drawable.dice6);
                break;
        }
        usrturnscore=usrtempscore+usrturnscore;
        yrscr.setText(String.valueOf(usrturnscore));

    }
    else
    {
        Toast.makeText(MainActivity.this,"You won",Toast.LENGTH_SHORT).show();
    }
}


public void computerroll()
    {
        TextView cmpscr=(TextView)findViewById(R.id.cmpscr);
        createToast("computer turn",1000);
        int dice_number=new Random().nextInt(6)+1;
        ImageView image=(ImageView)findViewById(R.id.imageView);
        TextView cmp_score=(TextView)findViewById(R.id.textView6);

        cmptempscore=dice_number;

        if(cmpoverallscore<100) {
            switch (dice_number) {
                case 1:
                    image.setImageResource(R.drawable.dice1);
                    break;
                case 2:
                    image.setImageResource(R.drawable.dice2);
                    break;

                case 3:
                    image.setImageResource(R.drawable.dice3);
                    break;

                case 4:
                    image.setImageResource(R.drawable.dice4);
                    break;

                case 5:
                    image.setImageResource(R.drawable.dice5);
                    break;

                case 6:
                    image.setImageResource(R.drawable.dice6);
                    break;
            }
            if (dice_number == 1) {
                cmpturnscore = 0;
                cmptempscore = 0;
                cmpscr.setText("0");
                final Handler h2 = new Handler();
                cmpturnscore=cmpturnscore+cmptempscore;
                cmpscr.setText(String.valueOf(cmpturnscore));
                h2.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        createToast("user turn come", 1000);

                        userroll();
                    }
                }, 3000);

            } else {
                if (cmpturnscore < 15) {
                    cmpturnscore=cmpturnscore+cmptempscore;
                    cmpscr.setText(String.valueOf(cmpturnscore));

                    final Handler h3 = new Handler();
                    h3.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            computerroll();
                        }
                    }, 3000);
                } else {
                    cmpoverallscore += cmpturnscore;
                    cmpturnscore = 0;
                    cmpscr.setText("0");
                    cmp_score.setText(String.valueOf(cmpoverallscore));
                    createToast("user ready", 800);

                }


            }
        }
        else
        {
            Toast.makeText(MainActivity.this,"You won",Toast.LENGTH_SHORT).show();
        }
    }


    public void holdaction(View v) {
       // Toast.makeText(MainActivity.this,"holding",Toast.LENGTH_SHORT).show();
        TextView yrscr=(TextView)findViewById(R.id.yrscr);
       // TextView cmp_score=(TextView)findViewById(R.id.textView6);
        TextView your_score=(TextView)findViewById(R.id.textView5);

        usroverallscore+=usrturnscore;
        usrturnscore=0;
        usrtempscore=0;
        yrscr.setText("0");
        your_score.setText(String.valueOf(usroverallscore));
        final Handler h5=new Handler();


        h5.postDelayed(new Runnable() {
            @Override
            public void run() {
                computerroll();
            }
        },3000);



    }
   /* public void cmphold()
    {
        TextView cmp_score=(TextView)findViewById(R.id.textView6);
        TextView cmpscr=(TextView)findViewById(R.id.cmpscr);
        cmpturnscore=cmpturnscore+cmptempscore;
        cmpscr.setText(String.valueOf(cmpturnscore));

        if(cmpturnscore<15)
        {
            final Handler h3=new Handler();

            h3.postDelayed(new Runnable() {
                @Override
                public void run() {
                    computerroll();
                }
            },3000);
        }
        else
        {
            cmpoverallscore+=cmpturnscore;
            cmpturnscore=0;
            cmpscr.setText("0");
            cmp_score.setText(String.valueOf(cmpoverallscore));

        }

    }*/
    public void resetaction(View v) {
        TextView cmp_score=(TextView)findViewById(R.id.textView6);
        TextView your_score=(TextView)findViewById(R.id.textView5);
        TextView yrscr=(TextView)findViewById(R.id.yrscr);
        TextView cmpscr=(TextView)findViewById(R.id.cmpscr);
        your_score.setText("0");
        cmp_score.setText("0");
        usroverallscore=0;
        usrturnscore=0;
        cmpturnscore=0;
        cmpoverallscore=0;
        yrscr.setText("0");
        cmpscr.setText("0");


    }
    private void createToast(String msg,int time){
        final Toast toast = Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG);
        toast.show();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                toast.cancel();
            }
        },time);
    }



}

