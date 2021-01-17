package model;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public class User {

    private String username;
    private String displayName;
    private Integer age;

    public User(String username, String displayName, Integer age){
        this.username = username;
        this.displayName = displayName;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public Integer getAge() {
        return age;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
