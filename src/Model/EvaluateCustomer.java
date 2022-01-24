package Model;

public class EvaluateCustomer extends  Person{
    private int numberStart;
    private String content;

    public EvaluateCustomer() {
    }

    public EvaluateCustomer(String name, String age, String address, String phoneNb) {
        super(name, age, address, phoneNb);
    }

    public EvaluateCustomer(int numberStart, String content) {
        this.numberStart = numberStart;
        this.content = content;
    }

    public EvaluateCustomer(String name, String age, String address, String phoneNb, int numberStart, String content) {
        super(name, age, address, phoneNb);
        this.numberStart = numberStart;
        this.content = content;
    }

    public int getNumberStart() {
        return numberStart;
    }

    public void setNumberStart(int numberStart) {
        this.numberStart = numberStart;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
