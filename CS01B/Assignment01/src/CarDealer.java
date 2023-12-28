
/**
 * @version 1.0  07-02-2020
 * @author Andrew Li
 * <br>
 * Purpose: CarDealer class contains private methods encapsulated within the public run() method, which displays the menu  <br>
 * and gives the user different view and search options. Methods from the Vehicle class are implemented in the init() method <br>
 * to construct new Vehicle objects and adjust the values within the Vehicle objects. <br>
 * <br>
 * Revision History: <br>
 * Date 07-02-2020 <br>
 * Programmer Andrew Li <br>
 * 
 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CarDealer
{

    private Vehicle[] vehicleList;
    private String dealerLocation;
    private int vehicleCount;
    private static String dealerBrand = "Big Brain Dealership";
    private static final int MAX_NUM_CARS = 1024;

    // default constructor
    public CarDealer()
    {
        vehicleList = new Vehicle[MAX_NUM_CARS];
        vehicleCount = 0;
        dealerLocation = "The Lost City";
    }

    // non-default constructor
    public CarDealer(String dealerLocation)
    {
        vehicleList = new Vehicle[MAX_NUM_CARS];
        vehicleCount = 0;
        this.dealerLocation = dealerLocation;
    }

    private void printMenu()
    {
        System.out.println("\n           MENU");
        System.out.println("1. View vehicle inventory");
        System.out.println("2. Search by make and model");
        System.out.println("3. Search by price");
        System.out.println("4. Search similar vehicles");
        System.out.println("5. Quit");
    }

    private void viewInventory()
    {
        System.out.println("-------------------------------------------");
        System.out.println("|             Vehicle Inventory           |");
        System.out.println("-------------------------------------------\n");
        System.out.println("Make         Model           Year  Price");
        System.out.println("-------------------------------------------");

        for (int c = 0; c < vehicleList.length; ++c)
        {
            if (vehicleList[c] != null)
            {
                System.out.println(vehicleList[c].toString());
            }
        }
    }

    private void searchMakeModel()
    {
        String makeSearch = null;
        String modelSearch = null;
        boolean foundIt = false;
        try
        {
            BufferedReader makeReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the car make:");
            makeSearch = makeReader.readLine();
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        try
        {
            BufferedReader modelReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the car model:");
            modelSearch = modelReader.readLine();
            String makeModel = makeSearch.trim() + modelSearch.trim();
            for (int i = 0; i < vehicleList.length; i++)
            {
                if (vehicleList[i] != null)
                {
                    if (vehicleList[i].toMakeModel().equalsIgnoreCase(makeModel))
                    {
                        System.out.println(vehicleList[i].toString());
                        foundIt = true;
                    }
                }
            }
            if (!foundIt)
            {
                System.out.println("No such vehicle is found.\n");
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private void searchPriceRange()
    {
        boolean isFound = false;
        double minPrice = 0.00;
        double maxPrice = 0.00;
        String test = "";

        try
        {
            BufferedReader search = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter minimum price:");
            minPrice = Double.parseDouble(search.readLine());
            System.out.println("Enter maximum price:");
            maxPrice = Double.parseDouble(search.readLine());
            for (int i = 0; i < vehicleList.length; i++)
            {
                if (vehicleList[i] != null)
                {
                    if (minPrice <= vehicleList[i].getPrice() && vehicleList[i].getPrice() <= maxPrice)
                    {
                        System.out.println(vehicleList[i].toString());
                        isFound = true;
                    }
                }
            }
            if (!isFound)
            {
                System.out.println("No cars were found within the price range of $" + minPrice + " to $" + maxPrice);
            }
        } catch (Exception e)
        {
            System.out.println("Enter a valid number.");
        }
    }

    // searchSimilar method extra credit
    private void searchSimilar()
    {
        String makeSearch;
        String modelSearch;
        String yearSearch;
        boolean found = false;

        try
        {
            BufferedReader search = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the car make:");
            makeSearch = search.readLine();
            System.out.println("Enter the car model:");
            modelSearch = search.readLine();
            System.out.println("Enter the car year:");
            yearSearch = search.readLine();

            Vehicle car = new Vehicle(makeSearch, modelSearch, Integer.parseInt(yearSearch), 0);

            for (int k = 0; k < vehicleList.length; k++)
            {
                if (vehicleList[k] != null)
                {
                    if (car.getYear() >= vehicleList[k].getYear())
                    {
                        if (car.equals(vehicleList[k]))
                        {

                            System.out.println(vehicleList[k].toString());
                            found = true;
                        }
                    } else
                    {
                        // not
                        //System.out.println("Last index >>>>>>>> " + k);
                        break;
                    }
                }
            }
            if (!found)
            {
                System.out.println("No such vehicle is found.");
            }
        } catch (Exception e)
        {
            System.out.println("Please enter valid values.");
        }

    }

    private void quit()
    {
        System.out.println("Thanks for using " + dealerBrand + " at " + dealerLocation + "!");
    }

    public void init()
    {
        String[] makeArr =
        { "Ford", "Ferrari", "BMW", "Ford", "Porsche", "Porsche", "Cadillac", "Toyota", "Rolls-Royce", "Toyota", "Lamborghini" };
        String[] modelArr =
        { "Taurus", "FF", "325i", "Taurus", "911 Convertible","911 Convertible", "ATS Sedan", "Prius", "Phantom", "Camry",
                "Aventador S" };
        int[] yearArr =
        { 2012, 2013, 2014, 2014, 2014, 2014, 2015, 2015, 2016, 2017, 2020 };
        double[] priceArr =
        { 9566.99, 302450.99, 37899.88, 17899.00, 103925.00, 200.99, 42955.00, 30005.05, 471175.00, 22158.95, 417826.99 };

        for (; vehicleCount < makeArr.length; ++vehicleCount)
        {
            if (vehicleCount % 2 == 0)
            {
                vehicleList[vehicleCount] = new Vehicle();
                vehicleList[vehicleCount].changeMake(makeArr[vehicleCount]);
                vehicleList[vehicleCount].changeModel(modelArr[vehicleCount]);
                vehicleList[vehicleCount].changeYear(yearArr[vehicleCount]);
                vehicleList[vehicleCount].changePrice(priceArr[vehicleCount]);

            } else
            {
                vehicleList[vehicleCount] = new Vehicle(makeArr[vehicleCount], modelArr[vehicleCount],
                        yearArr[vehicleCount], priceArr[vehicleCount]);

            }
        }
    }

    public void run()
    {
        boolean isUsing = true;
        int userChoice;

        System.out.println("Welcome to " + dealerBrand + " at " + dealerLocation);
        System.out.println("Loading vehicles from Database. Please wait ...");
        System.out.println("Done.");
        Scanner menu = new Scanner(System.in);

        do
        {
            this.printMenu();
            System.out.println("Enter your choice:");
            if (menu.hasNextInt())
            {
                userChoice = menu.nextInt();
                switch (userChoice)
                {
                case 1:
                    viewInventory();
                    menu.nextLine();
                    break;
                case 2:
                    searchMakeModel();
                    menu.nextLine();
                    break;
                case 3:
                    searchPriceRange();
                    menu.nextLine();
                    break;
                case 4:
                    searchSimilar();
                    break;
                case 5:
                    quit();
                    isUsing = false;
                default:
                    System.out.println("Please enter a valid number.");
                    menu.nextLine();
                }
            } else
            {
                System.out.println("Please enter a valid number.");
                menu.nextLine();
            }
        } while (isUsing);
    }

    // accessor / mutator methods
    public static int getMaxNumVcls()
    {
        return MAX_NUM_CARS;
    }

    public static String getDealerBrand()
    {
        return dealerBrand;
    }

    public String getDealerLocation()
    {
        return dealerLocation;
    }

    public int getNumVcls()
    {
        return vehicleCount;
    }

    public static void main(String[] args)
    {
        CarDealer dealer = new CarDealer();
        dealer.init();
        dealer.viewInventory();
    }
}
