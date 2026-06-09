import java.time.LocalDateTime;
import java.util.Objects;

public class User {
    private int id;
    private String name;
    private String password;
    private LocalDateTime lastLoginDate;
    private boolean isLoggedIn;

    public User(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.lastLoginDate = null;
        this.isLoggedIn = false;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public void login() {
        this.isLoggedIn = true;
        this.lastLoginDate = LocalDateTime.now();
    }

    public void logout() {
        this.isLoggedIn = false;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public LocalDateTime getLastLoginDate() {
        return lastLoginDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        User user = (User) obj;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
