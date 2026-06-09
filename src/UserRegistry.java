import java.util.HashSet;
import java.util.Set;

public class UserRegistry {
    private Set<User> users;
    private int nextId;

    public UserRegistry() {
        users = new HashSet<>();
        nextId = 1;
    }

    public void registerUser(String login, String password) {
        User newUser = new User(nextId, login, password);

        if (users.contains(newUser)) {
            System.out.println("Користувач " + login + " вже є у списку");
            return;
        }

        users.add(newUser);
        System.out.println("Користувача " + login + " зареєстровано");
        nextId++;
    }

    public void loginUser(String login, String password) {
        User user = findByLogin(login);

        if (user == null || !user.checkPassword(password)) {
            System.out.println("Неможливо ідентифікувати або аутентифікувати користувача");
            return;
        }

        user.login();
        System.out.println("Користувач " + login + " увійшов у систему");
    }

    public void logoutUser(int userId) {
        User user = findById(userId);

        if (user == null) {
            System.out.println("Користувача з id " + userId + " не знайдено");
            return;
        }

        user.logout();
        System.out.println("Користувач " + user.getName() + " вийшов із системи");
    }

    public boolean isUserRegistered(String login) {
        return findByLogin(login) != null;
    }

    public void removeUser(int id) {
        User user = findById(id);

        if (user == null) {
            System.out.println("Користувача з id " + id + " не знайдено");
            return;
        }

        users.remove(user);
        System.out.println("Користувача " + user.getName() + " видалено");
    }

    public void printTotalUniqueUsers() {
        System.out.println("Кількість унікальних користувачів: " + users.size());
    }

    public void displayAllUsers() {
        if (users.isEmpty()) {
            System.out.println("Список користувачів порожній");
            return;
        }

        System.out.println("Усі користувачі:");

        for (User user : users) {
            System.out.println(
                    "id: " + user.getId()
                            + ", login: " + user.getName()
                            + ", logged in: " + user.isLoggedIn()
                            + ", last login: " + user.getLastLoginDate()
            );
        }
    }

    private User findByLogin(String login) {
        for (User user : users) {
            if (user.getName().equals(login)) {
                return user;
            }
        }

        return null;
    }

    private User findById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }

        return null;
    }
}
