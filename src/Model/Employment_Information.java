package Model;

public class Employment_Information extends Person {
    private String infoSchool;
    private int idCore;
    private String wantTodo;

    public Employment_Information(String infoSchool, int idCore, String wantTodo) {
        this.infoSchool = infoSchool;
        this.idCore = idCore;
        this.wantTodo = wantTodo;
    }

    public Employment_Information(String name, String age, String address, String phoneNb, String infoSchool, int idCore, String wantTodo) {
        super(name, age, address, phoneNb);
        this.infoSchool = infoSchool;
        this.idCore = idCore;
        this.wantTodo = wantTodo;
    }

    public String getInfoSchool() {
        return infoSchool;
    }

    public void setInfoSchool(String infoSchool) {
        this.infoSchool = infoSchool;
    }

    public int getIdCore() {
        return idCore;
    }

    public void setIdCore(int idCore) {
        this.idCore = idCore;
    }

    public String getWantTodo() {
        return wantTodo;
    }

    public void setWantTodo(String wantTodo) {
        this.wantTodo = wantTodo;
    }
}
