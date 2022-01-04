public class Address {
    private String nameOfCity;
    private String nameOfStreet;

    public Address (String nCity, String nStreet) {
        nameOfCity=nCity;
        nameOfStreet= nStreet;
    }
    public String getNameOfCity () {
        return this.nameOfCity;
    }
    public String getNameOfStreet () {
        return this.nameOfStreet;
    }
    public void setNameOfCity (String nameOfCity) {
        this.nameOfCity= nameOfCity;
    }
    public void setNameOfStreet(String nameOfStreet){
        this.nameOfStreet= nameOfStreet;
    }
}
