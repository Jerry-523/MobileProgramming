package prog.mobile.friendlist;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Friend> friendList = new ArrayList<>();
    private FriendAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewFriends);
        Button buttonAddFriend = findViewById(R.id.buttonAddFriend);

        adapter = new FriendAdapter(this, friendList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        buttonAddFriend.setOnClickListener(v -> showAddFriendDialog());
    }

    private void showAddFriendDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Adicionar Amigo");

        final View customLayout = getLayoutInflater().inflate(R.layout.dialog_add_friend, null);
        builder.setView(customLayout);

        builder.setPositiveButton("Criar", (dialog, which) -> {
            // Obtenha os valores dos campos e adicione um novo amigo
        });

        builder.setNegativeButton("Cancelar", null);
        builder.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_settings) {
            
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
