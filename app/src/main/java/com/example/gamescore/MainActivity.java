package com.example.gamescore;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private int score1 = 0;
    private int score2 = 0;
    private TextView textViewScoreTeam1;
    private TextView textViewScoreTeam2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textViewScoreTeam1 = findViewById(R.id.TextViewScoreTeam1);
        textViewScoreTeam2 = findViewById(R.id.TextViewScoreTeam2);

        if (savedInstanceState != null) {
            score1 = savedInstanceState.getInt("score1");
            score2 = savedInstanceState.getInt("score2");
        }

        updateScore1();
        updateScore2();

        textViewScoreTeam1.setText(String.valueOf(score1));
        textViewScoreTeam2.setText(String.valueOf(score2));

        textViewScoreTeam1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score1++;
                updateScore1();
            }
        });

        textViewScoreTeam2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score2++;
                updateScore2();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    private void updateScore1(){
        textViewScoreTeam1.setText(String.valueOf(score1));
    }
    private void updateScore2(){
        textViewScoreTeam2.setText(String.valueOf(score2));
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("score1", score1);
        outState.putInt("score2", score2);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}