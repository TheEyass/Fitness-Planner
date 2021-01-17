package repos;

import model.User;

import java.util.*;

import static java.util.Objects.requireNonNull;

public class UserRepository implements Repository<User> {

    private final Set<User> users = new HashSet<>();

    protected UserRepository() {
    }

    public User createUser(String username, String displayName, Integer age){
        final var account = new User(username, displayName, age);
        users.add(account);
        return account;
    }

    @Override
    public Set<User> getAll() {
        return Collections.unmodifiableSet(users);
    }

    public Optional<User> getUser(String username){
        return users.stream().filter(account -> account.getUsername().equals(username)).findAny();
    }

    public boolean removeUser(String username){
        return users.removeIf(userAccount -> userAccount.getUsername().equals(username)); // Returns true if successful at removing
    }
    public void updateUser(String username, String displayName, Integer age){
        users.stream()
            .filter(account -> account.getUsername().equals(username)) // filters it
            .findAny() // returns it
            .ifPresent(account -> {
                if (displayName != null) {
                    account.setDisplayName(displayName);
                }

                if (age != null) {
                    account.setAge(age);
                }
            }); // sets it
    }

    public void load(Collection<User> accounts) {
        requireNonNull(accounts);

        this.users.addAll(accounts);
    }

    @Override
    public void clear() {
        users.clear();
    }
}
