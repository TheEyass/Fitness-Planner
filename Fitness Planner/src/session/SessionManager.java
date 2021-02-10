package session;

import static java.util.Objects.requireNonNull;

import repos.Repositories;
import repos.UserRepository;
import java.util.Optional;
import java.util.UUID;

public final class SessionManager {

    private static final SessionManager INSTANCE = new SessionManager();

    private final UserRepository userRepository = Repositories.getUserRepository();

    private Session activeSession;

    protected SessionManager() {
    }

    public static SessionManager getInstance() {
        return INSTANCE;
    }

    public void setActiveSession(String username) {
        requireNonNull(username);

        if (activeSession != null) {
            if (activeSession.getUserUsername().equals(username)) {
                return;
            }
        }

        final var optionalUserAccount = userRepository.getUser(username);

        this.activeSession = new Session(username);
    }

    public void removeActiveSession() {
        activeSession = null;
    }

    public Optional<Session> getActiveSession() {
        return Optional.ofNullable(activeSession);
    }
}
