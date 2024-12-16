package prog.mobile.friendlist;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private EditText inputName;
    private EditText inputEmail;
    private EditText inputBirthYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        inputName = findViewById(R.id.input_name);
        inputEmail = findViewById(R.id.input_email);
        inputBirthYear = findViewById(R.id.input_birth_year);
        Button buttonCancel = findViewById(R.id.button_cancel);
        Button buttonCreate = findViewById(R.id.button_create);

        buttonCancel.setOnClickListener(v -> {
            inputName.setText("");
            inputEmail.setText("");
            inputBirthYear.setText("");
        });

        buttonCreate.setOnClickListener(v -> {
            String name = inputName.getText().toString().trim();
            String email = inputEmail.getText().toString().trim();
            String birthYearStr = inputBirthYear.getText().toString().trim();

            if (name.isEmpty() || email.isEmpty() || birthYearStr.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            int birthYear;
            try {
                birthYear = Integer.parseInt(birthYearStr);
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Invalid year of birth", Toast.LENGTH_SHORT).show();
                return;
            }

            int age = 2024 - birthYear;
            Friend friend = new Friend(name, email, age);
            FriendData.addFriend(friend);
            Toast.makeText(this, "Friend added", Toast.LENGTH_SHORT).show();
            inputName.setText("");
            inputEmail.setText("");
            inputBirthYear.setText("");
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_friends) {
            Intent intent = new Intent(MainActivity.this, FriendsActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
