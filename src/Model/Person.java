package Model;

public class Person {
    protected String name;
    protected String age;
    protected String address;
    protected String phoneNb;

    public Person() {
    }

    public Person(String name, String age, String address, String phoneNb) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.phoneNb = phoneNb;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNb() {
        return phoneNb;
    }

    public void setPhoneNb(String phoneNb) {
        this.phoneNb = phoneNb;
    }
}
