public class Address {
    private String streetNum;
    private String streetName;
    private String apartmentNum;
    private String city;
    private String state;
    private int zipCode;

    public Address(String sNum, String sName, String aptNum, String c, String s, int zc) {
        streetNum = sNum;
        streetName = sName;
        apartmentNum = aptNum;
        city = c;
        state = s;
        zipCode = zc;
    }

    public Address(Address other) {
        streetNum = other.streetNum;
        streetName = other.streetName;
        apartmentNum = other.apartmentNum;
        city = other.city;
        state = other.state;
        zipCode = other.zipCode;
    }

    public Address(String ads) {
        streetNum = ads.substring(0, ads.indexOf(" "));
        String restOfAds = ads.substring(ads.indexOf(" ") + 1);
        int indOfAPT = restOfAds.indexOf("Apt");

        streetName = restOfAds.substring(0, indOfAPT - 1);
        int indOfComma = restOfAds.indexOf(", ");
        apartmentNum = restOfAds.substring(indOfAPT + 4, indOfComma);

        restOfAds = restOfAds.substring(indOfComma + 2);
        String[] split = restOfAds.split(", ");
        city = split[0];

        String[] remaining = split[1].split(" ");
        state = remaining[0];
        zipCode = Integer.parseInt(remaining[1]);
    }

    public String getStreetNum() {
        return streetNum;
    }

    public void setStreetNum(String streetNum) {
        this.streetNum = streetNum;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getApartmentNum() {
        return apartmentNum;
    }

    public void setApartmentNum(String apartmentNum) {
        this.apartmentNum = apartmentNum;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }



}
