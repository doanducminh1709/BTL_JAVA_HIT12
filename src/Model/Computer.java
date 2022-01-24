package Model;

public class Computer {
    private String IdComputer;
    private String ComputerName;
    private String BrandName;
    private String Status;

    public Computer() {
    }

    public Computer(String idComputer, String computerName, String brandName, String status) {
        IdComputer = idComputer;
        ComputerName = computerName;
        BrandName = brandName;
        Status = status;
    }

    public String getIdComputer() {
        return IdComputer;
    }

    public void setIdComputer(String idComputer) {
        IdComputer = idComputer;
    }

    public String getComputerName() {
        return ComputerName;
    }

    public void setComputerName(String computerName) {
        ComputerName = computerName;
    }

    public String getBrandName() {
        return BrandName;
    }

    public void setBrandName(String brandName) {
        BrandName = brandName;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
