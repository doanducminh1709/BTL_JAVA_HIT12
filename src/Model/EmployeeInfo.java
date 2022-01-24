package Model;

public class EmployeeInfo extends Person {

        private int IdCore;
        private String wantTodo;
        private String level;

        public EmployeeInfo() {
        }

    public EmployeeInfo(int idCore, String wantTodo, String level) {
        IdCore = idCore;
        this.wantTodo = wantTodo;
        this.level = level;
    }

    public EmployeeInfo(String name, String age, String address, String phoneNb, int idCore, String wantTodo, String level) {
        super(name, age, address, phoneNb);
        IdCore = idCore;
        this.wantTodo = wantTodo;
        this.level = level;
    }

    public int getIdCore() {
        return IdCore;
    }

    public void setIdCore(int idCore) {
        IdCore = idCore;
    }

    public String getWantTodo() {
        return wantTodo;
    }

    public void setWantTodo(String wantTodo) {
        this.wantTodo = wantTodo;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}

