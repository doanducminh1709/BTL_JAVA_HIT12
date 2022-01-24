package Model;

public class Employee extends Person{
    private String IdEmployee;
    private String Job;

    public Employee() {
    }

    public Employee(String name, String age, String address, String phoneNb) {
        super(name, age, address, phoneNb);
    }

    public Employee(String idEmployee, String job) {
        IdEmployee = idEmployee;
        Job = job;
    }

    public Employee(String name, String age, String address, String phoneNb, String idEmployee, String job) {
        super(name, age, address, phoneNb);
        IdEmployee = idEmployee;
        Job = job;
    }

    public String getIdEmployee() {
        return IdEmployee;
    }

    public void setIdEmployee(String idEmployee) {
        IdEmployee = idEmployee;
    }

    public String getJob() {
        return Job;
    }

    public void setJob(String job) {
        Job = job;
    }
}
