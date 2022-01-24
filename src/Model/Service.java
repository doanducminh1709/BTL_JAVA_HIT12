package Model;

public class Service {
    private String idService;
    private String nameService;
    private int priceService;
    private String unit;

    public Service() {
    }

    public Service(String idService, String nameService, int priceService , String unit) {
        this.idService = idService;
        this.nameService = nameService;
        this.priceService = priceService;
        this.unit = unit;
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

    public int getPriceService() {
        return priceService;
    }

    public void setPriceService(int priceService) {
        this.priceService = priceService;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
