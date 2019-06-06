package com.example.hm;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class ResultActivity extends AppCompatActivity {
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResult = findViewById(R.id.tvResult);
        showResults();
    }
    private void showResults(){
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        Bundle bundle = getIntent().getExtras();
        int progamming = bundle.getInt("programming");
        int dataStricture = bundle.getInt("dataStricture");
        int algorithm = bundle.getInt("algorithm");
        int sum = progamming + dataStricture + algorithm;
        double average = sum / 3.0;
        String text = "progamming = " + progamming +
                "\ndataStricture = " + dataStricture +
                "\nalgorithm = " + algorithm +
                "\nsum = " + sum +
                "\naverage = " + nf.format(average);
        tvResult.setText(text);
        alert(average);
    }

    private void alert(double average){
        String message = new String();
        String title = new String();
        int pic = 0;

        if(average == 100){
            message = "Congratulation";
            title = "Pass";
            pic = R.drawable.t;
        }
        else if(average >= 80 || average <= 99){
            message = "good!!";
            title = "Pass";
            pic = R.drawable.circle;
        }
        else if(average >= 60 || average <= 79){
            message = "soso!!";
            title = "Pass";
            pic = R.drawable.triangle;
        }
        else {
            message = "stupid!!";
            title = "Fail";
            pic = R.drawable.x;
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message);
        builder.setTitle(title);
        builder.setIcon(pic);
        builder.show();
        builder.setPositiveButton("OK",null);
        builder.setNegativeButton("Cancel",null);
        builder.setNeutralButton("Nothing",null);
    }

    public void onBackClick(View view){
        finish();
    }
}
