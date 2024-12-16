package prog.mobile.friendlist;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FriendsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FriendAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        recyclerView = findViewById(R.id.recyclerViewFriends);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new FriendAdapter(FriendData.getFriends(), this::showFriendOptions);
        recyclerView.setAdapter(adapter);

    }


    private void showFriendOptions(int position) {
        Friend friend = FriendData.getFriends().get(position);

        new AlertDialog.Builder(this)
                .setTitle(friend.getName())
                .setItems(new CharSequence[]{"Send Email", "Delete"}, (dialog, which) -> {
                    if (which == 0) {
                        Toast.makeText(this, "Send Email to " + friend.getEmail(), Toast.LENGTH_SHORT).show();
                    } else if (which == 1) {
                        FriendData.removeFriend(position);
                        adapter.notifyItemRemoved(position);
                        Toast.makeText(this, "Friend deleted", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }
}
