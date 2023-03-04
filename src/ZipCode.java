public class ZipCode {
    private String zipCode;
    private String city;
    private String state;

    public ZipCode(String zipCode, String city, String state) {
        this.zipCode = zipCode;
        this.city = city;
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String toString() {
        return zipCode + "---" + city + "---" + state;
    }
}
