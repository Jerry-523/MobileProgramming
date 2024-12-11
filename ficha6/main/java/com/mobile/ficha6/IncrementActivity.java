package com.mobile.ficha6;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class IncrementActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_increment);

        int counter = getIntent().getIntExtra("counter", 0);
        Button btnIncrement = findViewById(R.id.btnIncrement);

        btnIncrement.setOnClickListener(v -> {
            Intent resultIntent = new Intent();
            resultIntent.putExtra("counter", counter + 1);
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ActivityState", "onStart called in " + getClass().getSimpleName());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ActivityState", "onResume called in " + getClass().getSimpleName());
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ActivityState", "onPause called in " + getClass().getSimpleName());
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ActivityState", "onStop called in " + getClass().getSimpleName());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ActivityState", "onDestroy called in " + getClass().getSimpleName());
    }
}