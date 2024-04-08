package day04;

public class User{
    private String id;
    private String pw;
    private String name;

    User(String id, String pw, String name){
        this.id = id;
        this.pw = pw;
        this.name = name;
    }

    public void setUser(String name, String pw) {
        this.name = name;
        this.pw = pw;
    }

    public String getId() {
        return id;
    }

    public String getPw() {
        return pw;
    }

    public String getName() {
        return name;
    }
}