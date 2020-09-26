package cz.cvut.fel.nss.tripguide.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * The type User dto.
 */
public class UserDto {

    @NotEmpty
    private String fullName;

    @NotEmpty
    private String username;

    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    private String password;

    @NotEmpty
    private String repassword;

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets username.
     *
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets repassword.
     *
     * @return the repassword
     */
    public String getRepassword() {
        return repassword;
    }

    /**
     * Sets repassword.
     *
     * @param repassword the repassword
     */
    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    /**
     * Gets full name.
     *
     * @return the full name
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Sets full name.
     *
     * @param fullName the full name
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
