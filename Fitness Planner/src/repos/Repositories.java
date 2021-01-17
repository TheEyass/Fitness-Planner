package repos;

public class Repositories {

    private static UserRepository USER_REPOSITORY = new UserRepository();

    private Repositories(){}

    public static UserRepository getUserRepository(){ return USER_REPOSITORY; }
}
