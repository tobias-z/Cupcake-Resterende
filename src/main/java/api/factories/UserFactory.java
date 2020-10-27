package api.factories;

import exeptions.ValidationError;

import java.time.LocalDateTime;

public class UserFactory {

    private int id;
    private String name;
    private String password;
    private String password2;
    private String email;
    private LocalDateTime createdAt;
    private byte[] salt;
    private byte[] secret;
    private String role;
    private int ranked;

    public boolean isValid (UserFactory userFactory) {
        if (userFactory == null) {
            return false;

        } else {
            return true;
        }
    }
    public void setId(int id) throws ValidationError {
        if(id < 0) throw new ValidationError("Id'en burde ikke være under 0");
        this.id = id;
    }

    public void setId(String number) throws ValidationError {
        try {
            setId(Integer.parseInt(number));
        } catch (NumberFormatException e){
            throw new ValidationError(e.toString());
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setCreatedAt(String ldt) throws ValidationError {
        try {
            setCreatedAt(LocalDateTime.parse(ldt));
        } catch (NumberFormatException e){
            throw new ValidationError(e.toString());
        }
    }

    public void setSalt(byte[] salt) {
        this.salt = salt;
    }

    public void setSecret(byte[] secret) {
        this.secret = secret;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setRanked(int ranked) throws ValidationError {
        if(ranked < 0) throw new ValidationError("Tillykke du har formået at få en rank på under 0");
        this.ranked = ranked;
    }

    public void setRanked(String number) throws ValidationError {
        try {
            setRanked(Integer.parseInt(number));
        } catch (NumberFormatException e){
            throw new ValidationError(e.toString());
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getPassword2() {
        return password2;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public byte[] getSalt() {
        return salt;
    }

    public byte[] getSecret() {
        return secret;
    }

    public String getRole() {
        return role;
    }

    public int getRanked() {
        return ranked;
    }
}
