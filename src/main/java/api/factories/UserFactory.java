package api.factories;

import exeptions.ValidationError;

import java.time.LocalDateTime;

public class UserFactory {

    private String name;
    private String password;
    private String email;

    public boolean isValid () {
        if (name == null || name.isBlank()) return false;
        if(password == null || password.isBlank()) return false;
        if(email == null || email.isBlank()) return false;
        return true;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

}
