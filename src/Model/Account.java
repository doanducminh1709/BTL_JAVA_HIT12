package Model;

public class Account extends Person {
    private long amountOfMoney;
    private float hourOfPlay;
    private String userName;
    private String password;


    public Account() {
    }

    public Account(String name, String age, String address, String phoneNb) {
        super(name, age, address, phoneNb);
    }

    public Account( long amountOfMoney, float hourOfPlay ,String userName, String password) {
        this.amountOfMoney = amountOfMoney;
        this.hourOfPlay = hourOfPlay;
        this.userName = userName;
        this.password = password;
    }

    public Account(String name, String age, String address, String phoneNb, long amountOfMoney, float hourOfPlay, String userName, String password) {
        super(name, age, address, phoneNb);
        this.amountOfMoney = amountOfMoney;
        this.hourOfPlay = hourOfPlay;
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(long amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public float getHourOfPlay() {
        return hourOfPlay;
    }

    public void setHourOfPlay(float hourOfPlay) {
        this.hourOfPlay = hourOfPlay;
    }
}
