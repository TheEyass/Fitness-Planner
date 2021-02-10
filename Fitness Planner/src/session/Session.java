package session;

import static java.util.Objects.requireNonNull;

import java.util.UUID;

public final class Session {

    private final String username;

    public Session(String username) {
        this.username = requireNonNull(username);
    }

    public String getUserUsername() {
        return username;
    }
}
