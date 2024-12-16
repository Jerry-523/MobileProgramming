package prog.mobile.friendlist;
import java.util.ArrayList;
import java.util.List;

public class FriendData {

    public static List<Friend> friends = new ArrayList<>();

    public static void addFriend(Friend friend) {
        friends.add(friend);
    }

    public static void removeFriend(int position) {
        if (position >= 0 && position < friends.size()) {
            friends.remove(position);
        }
    }

    public static List<Friend> getFriends() {
        return new ArrayList<>(friends);
    }
}
