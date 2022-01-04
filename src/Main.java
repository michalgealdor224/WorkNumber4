import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        main();
    }
    public static final int CHOOSE_NUMBER_ONE = 1;
    public static final int CHOOSE_NUMBER_TWO = 2;
    public static final int CHOOSE_NUMBER_THREE =3;
    public static final int CHOOSE_NUMBER_FOUR =4;
    public static final int CHOOSE_NUMBER_FIVE =5;
    public static final int CHOOSE_NUMBER_SIX= 6;
    public static final int NUMBER_NOT_VALID = 0;
    public static final int NUMBER_HIGHEST = 6;

    public static void main () {
        RealEstate realEstate = new RealEstate();
        Scanner scanner=new Scanner(System.in);

        int choose;
        do {
            System.out.println("""
                    enter 1-for create account
                    2-for login to your account
                    3-for finish""");
            choose = scanner.nextInt();
            if (choose == CHOOSE_NUMBER_ONE) {
                realEstate.createUser();
            }
            if (choose == CHOOSE_NUMBER_TWO) {
                User user = realEstate.login();
                if (user != null) {
                    int chooseOfUser;
                    do {
                        System.out.println("""
                            enter 1- for post a new property
                            2- for remove property
                            3- for view all assets in the system
                            4- for view all user-posted assets
                            5- for search property by parameters
                            6- for disconnect and return to the main program""");
                        chooseOfUser = scanner.nextInt();
                    } while (chooseOfUser < NUMBER_NOT_VALID || chooseOfUser > NUMBER_HIGHEST);

                    if (chooseOfUser == CHOOSE_NUMBER_ONE) {
                        realEstate.postNewProperty(user);
                    }
                    if (chooseOfUser == CHOOSE_NUMBER_TWO) {
                        realEstate.removeProperty(user);
                    }
                    if (chooseOfUser == CHOOSE_NUMBER_THREE) {
                        realEstate.printAllProperties();
                    }
                    if (chooseOfUser == CHOOSE_NUMBER_FOUR) {
                        realEstate.printUserProperties(user);
                    }
                    if (chooseOfUser == CHOOSE_NUMBER_FIVE) {
                        Property[] printProperty=  realEstate.search();
                        for (int i=0; i< printProperty.length; i++) {
                            System.out.println(printProperty[i]);
                        }
                    }
                    if (chooseOfUser == CHOOSE_NUMBER_SIX) {
                    }
                }
            }
        }  while (choose!=CHOOSE_NUMBER_THREE);
    }
}

