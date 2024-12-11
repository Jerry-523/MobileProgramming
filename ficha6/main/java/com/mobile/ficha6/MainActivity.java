package com.mobile.ficha6;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private int counter = 0;
    private TextView tvCounter;

    private final ActivityResultLauncher<Intent> incrementLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    counter = result.getData().getIntExtra("counter", counter);
                    updateCounter();
                }
            });

    private final ActivityResultLauncher<Intent> decrementLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    counter = result.getData().getIntExtra("counter", counter);
                    updateCounter();
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCounter = findViewById(R.id.tvCounter);
        Button btnIncrement = findViewById(R.id.btnIncrement);
        Button btnDecrement = findViewById(R.id.btnDecrement);
        Button btnReset = findViewById(R.id.btnReset);

        updateCounter();

        btnIncrement.setOnClickListener(v -> {
            Intent intent = new Intent(this, IncrementActivity.class);
            intent.putExtra("counter", counter);
            incrementLauncher.launch(intent); // Certifique-se de usar o Launcher
        });

        btnDecrement.setOnClickListener(v -> {
            Intent intent = new Intent(this, DecrementActivity.class);
            intent.putExtra("counter", counter);
            decrementLauncher.launch(intent); // Certifique-se de usar o Launcher
        });

        btnReset.setOnClickListener(v -> {
            counter = 0;
            updateCounter();
        });
    }

    private void updateCounter() {
        tvCounter.setText(String.valueOf(counter));
    }
}
