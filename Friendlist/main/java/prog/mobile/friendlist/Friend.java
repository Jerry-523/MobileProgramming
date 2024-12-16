package prog.mobile.friendlist;

public class Friend {

    private final String name;
    private final String email;
    private final int age;

    public Friend(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }
}
