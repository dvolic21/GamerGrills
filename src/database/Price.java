package database;

public class Price {
    private int price_id;
    private float price;
    private String currency;
    private String sale;
    private String sale_percentage;
    private String start_date;
    private String end_date;

    public Price(int price_id, float price, String currency, String sale, String sale_percentage, String start_date,
            String end_date) {
        this.price_id = price_id;
        this.price = price;
        this.currency = currency;
        this.sale = sale;
        this.sale_percentage = sale_percentage;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public int getPrice_id() {
        return price_id;
    }

    public void setPrice_id(int price_id) {
        this.price_id = price_id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }

    public String getSale_percentage() {
        return sale_percentage;
    }

    public void setSale_percentage(String sale_percentage) {
        this.sale_percentage = sale_percentage;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

}
