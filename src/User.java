import java.util.List;

public abstract class User {

    private String FirstName;
    private String LastName;
    private String phoneNumber;
    private String email;
    public String userName;
    private String ID;
    private String address;
    private String password;

    public User(String ID, String firstName, String lastName, String phoneNumber, String email, String userName,  String address, String password) {
        FirstName = firstName;
        LastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.userName = userName;
        this.ID = ID;
        this.address = address;
        this.password = password;
    }

    public void logIn(String userName, String password){}

    public void changePassword(String newPassword, String oldPassword){}

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getID() {
        return ID;
    }

    public String getAddress() {
        return address;
    }

}
