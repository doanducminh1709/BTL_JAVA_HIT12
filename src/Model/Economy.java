package Model;

public class Economy {
    private float HourlyRate;
    private float promotion;

    public Economy() {
    }

    public Economy(float hourlyRate, float promotion) {
        HourlyRate = hourlyRate;
        this.promotion = promotion;
    }

    public float getHourlyRate() {
        return HourlyRate;
    }

    public void setHourlyRate(float hourlyRate) {
        HourlyRate = hourlyRate;
    }

    public float getPromotion() {
        return promotion;
    }

    public void setPromotion(float promotion) {
        this.promotion = promotion;
    }
}
