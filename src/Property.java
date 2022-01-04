public class Property {

    private Address address;
    private int numbersOfRooms;
    private int price;
    private int type;
    private boolean forRent;
    private int numberOfHouse;
    private int numberOfFloor;
    private User user;

    public Property (int numbersOfRooms, int price, int type, boolean forRent, int numberOfHouse, int numberOfFloor, User user) {
        this.numbersOfRooms=numbersOfRooms;
        this.price=price;
        this.type=type;
        this.forRent=forRent;
        this.numberOfHouse = numberOfHouse;
        this.numberOfFloor=numberOfFloor;
        this.user= user;
    }

    public static final int ORDINARY_APARTMENT = 1;
    public static final int PENTHOUSE_APARTMENT =2;
    public static final int PRIVET_HOUSE = 3;

    public String toString(){
        String ifForSale= "for rent";
        if (this.forRent) {
            ifForSale= "for sale";
        }
        String typeOfProperty="";
        if (type==ORDINARY_APARTMENT) {
            typeOfProperty= "ordinary apartment";
        }
        if (type==PENTHOUSE_APARTMENT) {
            typeOfProperty= "penthouse apartment";
        }
        if (this.type==PRIVET_HOUSE){
            return  "private house"+ " " +"-" +" " +(this.forRent?"for rent":"for sale") + ":" +"\n" +
                    "" + this.numbersOfRooms + " "+ "rooms"+ " " + "\n" +
                    "price:"+ "" + this.price + "$" +" \n" +
                    "contact info:"+ user;
        }
        else  return   typeOfProperty+ " " +"-" +" " +(this.forRent?"for rent":"for sale") + ":" +"\n" +
                "" + this.numbersOfRooms + " "+ "rooms"+ " " + "floor" + " " + this.numberOfFloor+ "\n" +
                "price:"+ "" + this.price + "$" +" \n" +
                "contact info:"+ user;
    }

    public Address getAddress () {
        return this.address;
    }

    public int getNumbersOfRooms () {
        return this.numbersOfRooms;
    }
    public int getPrice () {
        return this.price;
    }
    public int getType () {
        return this.type;
    }
    public boolean isForRent() {
        return this.forRent;
    }
    public int getNumberOfHouse() {
        return this.numberOfHouse;
    }
    public int getNumberOfFloor () {
        return this.numberOfFloor;
    }
    public User getUser() {
        return this.user;
    }

    public void setAddress (Address address) {
        this.address = address;
    }

    public void setNumbersOfRooms (int numbersOfRooms) {
        this.numbersOfRooms= numbersOfRooms;
    }
    public void setPrice (int price) {
        this.price=price;
    }
    public void setType (int type) {
        this.type=type;
    }
    public void setForRent (boolean forRent) {
        this.forRent =forRent;
    }
    public void setNumberOfHouse(int numbersOfHouse) {
        this.numberOfHouse = numbersOfHouse;
    }
    public void setNumberOfFloor (int numberOfFloor) {
        this.numberOfFloor=numberOfFloor;
    }
    public void setUser(User user) {
        this.user = user;
    }
}

