package Model;

public class ServiceCustomer extends Person {

    private String idService;
    private String nameService;
    private int countOrTime;
    private int serviceCost;


    public ServiceCustomer(){}
    public ServiceCustomer(String name, String age, String address, String phoneNb
            , String idService,String nameService , int countOrTime, int serviceCost) {
        super(name, age, address, phoneNb);
        this.idService = idService;
        this.nameService = nameService;
        this.countOrTime = countOrTime;
        this.serviceCost = serviceCost;
    }

    public String getIdService() {
        return idService;
    }

    public void setIdService(String idService) {
        this.idService = idService;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public int getCountOrTime() {
        return countOrTime;
    }

    public void setCountOrTime(int countOrTime) {
        this.countOrTime = countOrTime;
    }

    public int getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(int serviceCost) {
        this.serviceCost = serviceCost;
    }
}
