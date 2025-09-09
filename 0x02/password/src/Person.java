public class Person {

    private final String user;

    private final String password;

    public Person(String user, String password) {
        this.password = password;
        this.user = user;
    }

    public boolean checkUser() {
        return user.matches("^[A-Za-z0-9]{8,}$");
    }

    public boolean checkPassword() {
        return password.matches("^(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z0-9]).{8,}$");
    }

}
