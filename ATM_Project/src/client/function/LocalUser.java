package client.function;

public class UserInfo {
    private String username;
    private String password;
    private boolean ifAdmin;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return ifAdmin;
    }

    public void setAdmin(boolean ifAdmin) {
        this.ifAdmin = ifAdmin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
