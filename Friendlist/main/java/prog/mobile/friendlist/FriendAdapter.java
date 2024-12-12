package prog.mobile.friendlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.FriendViewHolder> {
    private List<Friend> friendList;
    private Context context;

    public FriendAdapter(Context context, List<Friend> friendList) {
        this.context = context;
        this.friendList = friendList;
    }

    @NonNull
    @Override
    public FriendViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_friend, parent, false);
        return new FriendViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FriendViewHolder holder, int position) {
        Friend friend = friendList.get(position);
        holder.textViewName.setText(friend.getName());
        holder.textViewEmail.setText(friend.getEmail());
        holder.textViewAge.setText("Idade: " + friend.getAge());

        holder.itemView.setOnClickListener(v -> {
            new AlertDialog.Builder(context)
                    .setTitle("Opções")
                    .setMessage("Enviar email ou deletar amigo?")
                    .setPositiveButton("Enviar Email", (dialog, which) -> {

                    })
                    .setNegativeButton("Deletar", (dialog, which) -> {
                        friendList.remove(position);
                        notifyDataSetChanged();
                    })
                    .show();
        });
    }

    @Override
    public int getItemCount() {
        return friendList.size();
    }

    public static class FriendViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName, textViewEmail, textViewAge;

        public FriendViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewFriendName);
            textViewEmail = itemView.findViewById(R.id.textViewFriendEmail);
            textViewAge = itemView.findViewById(R.id.textViewFriendAge);
        }
    }
}

