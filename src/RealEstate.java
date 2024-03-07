import java.util.Objects;
import java.util.Scanner;

public class RealEstate {
    private User[] users;
    private Property[] properties;
    private Address[] addresses;

    public static final int LENGTH_OF_ARRAY =0;
    public static final int LENGTH_OF_SECOND_ARRAY =10;
    public static final int FIRST_LOCATION_IN_ARRAY = 0;
    public static final int SECOND_LOCATION_IN_ARRAY = 1;
    public static final int THIRD_LOCATION_IN_ARRAY = 2;
    public static final int FOURTH_LOCATION_IN_ARRAY = 3;
    public static final int FIFTH_LOCATION_IN_ARRAY = 4;
    public static final int SIXTH_LOCATION_IN_ARRAY = 5;
    public static final int SEVENTH_LOCATION_IN_ARRAY = 6;
    public static final int EIGHTH_LOCATION_IN_ARRAY = 7;
    public static final int NINTH_LOCATION_IN_ARRAY = 8;
    public static final int TENTH_LOCATION_IN_ARRAY = 9;



    public RealEstate() {

        users = new User[LENGTH_OF_ARRAY];
        properties = new Property[LENGTH_OF_ARRAY];
        addresses = new Address[LENGTH_OF_SECOND_ARRAY];
        Address address1 = new Address("ashdod", "hanasi");
        Address address2 = new Address("ashdod", "hamacabim");
        Address address3 = new Address("haifa", "eli");
        Address address4 = new Address("tel aviv", "yossi");
        Address address5 = new Address("ashdod", "moshe");
        Address address6 = new Address("natania", "reuven");
        Address address7 = new Address("jerusalem", "etzion");
        Address address8 = new Address("tel aviv", "hahagana");
        Address address9 = new Address("haifa", "gefen");
        Address address10 = new Address("ashdod", "rimon");
        addresses[FIRST_LOCATION_IN_ARRAY] = address1;
        addresses[SECOND_LOCATION_IN_ARRAY] = address2;
        addresses[THIRD_LOCATION_IN_ARRAY] = address3;
        addresses[FOURTH_LOCATION_IN_ARRAY] = address4;
        addresses[FIFTH_LOCATION_IN_ARRAY] = address5;
        addresses[SIXTH_LOCATION_IN_ARRAY] = address6;
        addresses[SEVENTH_LOCATION_IN_ARRAY] = address7;
        addresses[EIGHTH_LOCATION_IN_ARRAY] = address8;
        addresses[NINTH_LOCATION_IN_ARRAY] = address9;
        addresses[TENTH_LOCATION_IN_ARRAY] = address10;
    }

    public User[] getUsers() {
        return this.users;
    }

    public Property[] getProperties() {
        return this.properties;
    }

    public Address[] getAddresses() {
        return this.addresses;
    }

    public void setUsers(User[] user) {
        for (int i=0; i< user.length;i++) {
            this.users[i] = user[i];
        }
    }

    public void setProperties(Property[] properties1,Property[] properties2) {
        for (int i=0; i< properties2.length-1;i++) {
            properties1[i] = properties2[i];
        }
    }

    public void setAddresses(Address[] addresses) {
        this.addresses = addresses;
    }
    public static final int FIRST_NUMBER = 0;
    public static final int SECOND_NUMBER = 5;
    public static final int LENGTH_VALID = 10;
    public static final int ASCII_SUBTRACTION= 48;
    public static final int FIRST_LOCATION_IN_STRING = 0;
    public static final int SECOND_LOCATION_IN_STRING = 1;


    public void createUser() {
        Scanner scanner = new Scanner(System.in);
        boolean ifExists = true;
        String userName;
        do {
            System.out.println("enter userName:");
            userName = scanner.nextLine();
            for (int i = 0; i < users.length; i++) {
                if (users[i].getUserName().equals(userName)) {
                    ifExists = false;
                    break;
                }
            }
        } while (!ifExists);
        boolean ifChar = false;
        boolean ifNumber = false;
        String password;
        do {
            System.out.println("enter password:");
            password = scanner.nextLine();
            for (int i = 0; i < password.length(); i++) {
                if (password.charAt(i) == '_' || password.charAt(i) == '%'
                        || password.charAt(i) == '$') {
                    ifChar = true;
                }
                if (Character.isDigit(password.charAt(i))) {
                    ifNumber = true;
                }
            }
            if (!ifChar || !ifNumber) {
                System.out.println("password is not strong");
            }
        } while (!ifChar || !ifNumber);
        boolean ifNumberValid = false;

        String phoneNumber;
        do {
            System.out.println("enter your phone number:");
            phoneNumber = scanner.nextLine();
            if (phoneNumber.charAt(FIRST_LOCATION_IN_STRING) - ASCII_SUBTRACTION == FIRST_NUMBER &&
                    phoneNumber.charAt(SECOND_LOCATION_IN_STRING) - ASCII_SUBTRACTION == SECOND_NUMBER && phoneNumber.length() == LENGTH_VALID) {
                ifNumberValid = true;
            }
            if (!ifNumberValid) {
                System.out.println("the phone number is not valid");
            }
        } while (!ifNumberValid);

        System.out.println("enter true for mediator, false for regular user:");
        boolean type = scanner.nextBoolean();
        User newUser = new User(userName, password, phoneNumber, type);
        newUser.setUserName(userName);
        newUser.setPassword(password);
        newUser.setPhoneNumber(phoneNumber);
        newUser.setIfMediator(type);
        User[] newUsers = new User[users.length + 1];
        for (int i = 0; i < users.length; i++) {
            newUsers[i] = users[i];
        }
        newUsers[users.length] = newUser;
        users= new User[newUsers.length];
        setUsers(newUsers);
    }

    public User login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter user name:");
        String userName = scanner.nextLine();
        System.out.println("enter user password:");
        String password = scanner.nextLine();
        boolean ifExistsUsername = false;
        boolean ifExistsPassword = false;
        int location = 0;
        for (int i = location; i < this.users.length; i++, location++) {
            if (this.users[i].getUserName().equals(userName)) {
                ifExistsUsername = true;
            }
            if (this.users[i].getPassword().equals(password)) {
                ifExistsPassword = true;
                break;
            }
        }
        if (ifExistsPassword && ifExistsUsername) {
            return users[location];
        } else {
            return null;
        }
    }
    public static final int NO_MORE_PUBLICATION =0;

    public boolean postNewProperty(User user) {
        boolean ifEverythingGood = false;
        int countOfMax;
        int currentCount = 0;
        if (user.isIfMediator()) {
            countOfMax = 10;
        } else {
            countOfMax = 3;
        }
        for (int i = 0; i < properties.length; i++) {
            if (properties[i].getUser().equals(user.getUserName())) {
                currentCount++;
            }
        }
        int possibleAmountOfPublication = countOfMax - currentCount;
        if (possibleAmountOfPublication == NO_MORE_PUBLICATION) {
            System.out.println("you have reached the possible amount of publications");
            ifEverythingGood = false;
        }
        int i;
        int j;
        int location = 0;
        boolean ifHave;
        String[] namesOfCities = new String[this.addresses.length];
        for (i = 0; i < addresses.length; i++) {
            ifHave=false;
            for (j = 0; j < namesOfCities.length; j++) {
                if (Objects.equals(namesOfCities[j], addresses[i].getNameOfCity())) {
                    ifHave = true;
                    break;
                }
            }
            if (!ifHave) {
                namesOfCities[location] = addresses[i].getNameOfCity();
                System.out.println(namesOfCities[location]);
                location++;
            }
        }
        String city;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("enter city from the list:");
            city = scanner.nextLine();
            for (int k = 0; k < namesOfCities.length; k++) {
                if (city.equals(namesOfCities[k])) {
                    ifEverythingGood = true;
                }
            }
        }while (!ifEverythingGood);

        for (int m = 0; m < addresses.length; m++) {
            if (addresses[m].getNameOfCity().equals(city)) {
                System.out.println(addresses[m].getNameOfStreet());
            }
        }
        int locationOfStreetOnArray=0;
        String[]  namesOfStreet = new String[this.addresses.length];
        for (int s = 0; s < this.addresses.length; s++) {
            if (addresses[s].getNameOfCity().equals(city)) {
                namesOfStreet[locationOfStreetOnArray] = addresses[s].getNameOfStreet();
                locationOfStreetOnArray++;
            }
        }
        String[] newNameOfStreets= new String[locationOfStreetOnArray];
        for (int a=0;a<newNameOfStreets.length; a++) {
            newNameOfStreets[a] = namesOfStreet[a];
        }
        namesOfStreet = new String[locationOfStreetOnArray];
        for (int g=0; g<newNameOfStreets.length; g++) {
            namesOfStreet[g] = newNameOfStreets[g];
        }

        boolean ifExists = false;
        do {
            System.out.println("enter name of street:");
            String street = scanner.nextLine();
            for (j = 0; j < namesOfStreet.length; j++) {
                if (namesOfStreet[j].equals(street)) {
                    ifExists = true;
                    break;
                }
            }
        } while (!ifExists);

        {
            System.out.println("""
                            enter type of property-
                            1 for ordinary apartment in a building
                            2 for penthouse apartment in a building
                            3 for private house""");
            int typeOfProperty = scanner.nextInt();
            int floorOfProperty=0;
            if (typeOfProperty == 1 || typeOfProperty==2) {
                System.out.println("enter floor");
                floorOfProperty = scanner.nextInt();
            }
            System.out.println("enter amount of rooms");
            int amountOfRooms = scanner.nextInt();
            System.out.println("enter number of property");
            int numberOfProperty = scanner.nextInt();
            System.out.println("if the property to rent enter true for sell enter false");
            boolean ifForRent = scanner.nextBoolean();
            System.out.println("enter price of the property");
            int priceOfProperty = scanner.nextInt();
            Property property = new Property(amountOfRooms, priceOfProperty,typeOfProperty , ifForRent, numberOfProperty, floorOfProperty, user);
            Property [] newProperties = new Property[properties.length+1];
            for (int r=0; r<properties.length; r++) {
                newProperties[r] = properties[r];
            }
            newProperties[newProperties.length-1] = property;
            properties= new Property[newProperties.length];
            for (int f=0; f<newProperties.length; f++) {
                properties[f] = newProperties[f];
            }
            ifEverythingGood = true;

        }

        return ifEverythingGood;

    }


    public void removeProperty(User user) {
        Scanner scanner = new Scanner(System.in);
        int countOfPosts = 0;
        int location = 0;
        for (int i = 0; i < properties.length; i++) {
            if (user.getUserName().equals(properties[i].getUser().getUserName())) {
                countOfPosts++;
                System.out.println(location + "-" + properties[i]);
                location++;
            }
        }
        Property[] propertiesOfPeople = new Property[countOfPosts];
        for (int i = 0; i < propertiesOfPeople.length; i++) {
            for (int j = 0; j < properties.length; j++) {
                if (user.getUserName().equals(properties[j].getUser().getUserName())) {
                    propertiesOfPeople[i] = properties[j];
                    i++;
                }
            }
        }
        int numberOfProperty;
        if (countOfPosts > 0) {
            do {
                System.out.println("enter number of property");
                numberOfProperty = scanner.nextInt();
            } while (numberOfProperty > location || numberOfProperty < 0 );
            int i;
            Property propertyToDelete = propertiesOfPeople[numberOfProperty];
            for (i=0; i< properties.length; i++) {
                if (properties[i].equals(propertyToDelete)){
                    properties[i] =null;
                    break;
                }
            }
            properties [i] = properties[properties.length-1];
            properties[properties.length-1]= null;
            System.out.println("the property deleted successfully");

        }
        if (countOfPosts == 0) {
            System.out.println("no properties found");
            return;
        }
    }

    public void printAllProperties() {
        for (int i = 0; i < properties.length; i++) {
            System.out.println(properties[i]);
        }
        if (properties.length==0) {
            System.out.println("not found properties");
        }
    }
    public static final int DOESNT_MATTERS = -999;

    public void printUserProperties(User user) {
        boolean ifFoundProperties= false;
        for (int i = 0; i < properties.length; i++) {
            if (properties[i].getUser().getUserName().equals(user.getUserName())) {
                System.out.println(properties[i]);
                ifFoundProperties=true;
            }
            if (!ifFoundProperties) {
                System.out.println("no found properties");
            }
        }
    }
    public static final int FOR_SALE = 1;
    public static final int FOR_RENT = 2;
    public static final int NUMBER_NOT_VALID = 0;
    public static final int BIGGEST_VALID_NUMBER = 3;


    public Property[] search() {
        boolean status=false;
        Scanner scanner = new Scanner(System.in);
        int isRent;
        System.out.println("answer the following criteria which is not relevant to you enter -999");
        do {
            System.out.println("enter 1 for rent, 2 for sale");
            isRent = scanner.nextInt();
        } while (isRent!= FOR_SALE && isRent!=FOR_RENT && isRent!= DOESNT_MATTERS);
        int type;
        do {
            System.out.println("""
                enter type of property-
                1 for ordinary apartment in a building
                2 for penthouse apartment in a building
                3 for private house""");
            type = scanner.nextInt();
        } while ( type < NUMBER_NOT_VALID || type> BIGGEST_VALID_NUMBER);

        System.out.println("what is the desired number of rooms?");
        int numberOfRooms = scanner.nextInt();
        System.out.println("what is the minimum price range?");
        int minimum = scanner.nextInt();
        System.out.println("what is the maximum price range?");
        int maximum = scanner.nextInt();
        int countRelevantProperty = 0;
        Property[] relevantProperty = new Property[0];
        if (properties.length==0){
            System.out.println("no found property");
        }
        boolean ifGood=false;
        if (isRent==FOR_SALE) {
            status= true;
        }
        for (int i = 0; i < properties.length; i++) {
            if ((properties[i].isForRent() == status || isRent == DOESNT_MATTERS) && (properties[i].getType() == type || type == DOESNT_MATTERS)
                    && (properties[i].getRoomsNumber() == numberOfRooms || numberOfRooms == DOESNT_MATTERS) &&
                    (properties[i].getPrice() > minimum || minimum == DOESNT_MATTERS) &&
                    (properties[i].getPrice() < maximum || maximum == DOESNT_MATTERS)) {
                ifGood = true;
                countRelevantProperty++;
                relevantProperty = new Property[countRelevantProperty];
                for (int j = 0; j < relevantProperty.length; j++) {
                    relevantProperty[j] = properties[i];
                }
            }
        }
        if (!ifGood){
            System.out.println("no found property");
        }

        return relevantProperty;
    }
}

