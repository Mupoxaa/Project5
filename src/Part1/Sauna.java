package Part1;

public class Sauna {
    public String name;
    public int price;
    public int numberOfPeople;
    public int minHours;
    public boolean isOpenAtNight;

    // Helper method to print an empty line for formatting
    public static void newLine(){
        System.out.println();
    }

    // Initializes a new Sauna object with the provided parameters
    public Sauna(String name, int price, int numberOfPeople, int minHours, boolean isOpenAtNight){
        this.name = name;
        this.price = price;
        this.numberOfPeople = numberOfPeople;
        this.minHours = minHours;
        this.isOpenAtNight = isOpenAtNight;
    }

    //Method to print detailed information about the sauna
    public void PrintDetails(){
        System.out.println("Name: "+ name +", Price: "+ price +", Number of people: "+numberOfPeople +", Min hours: " + minHours + ", Is open at night: " + isOpenAtNight);
        System.out.println("Minimum price to rent: "+ MinPrice());
        newLine();
    }

    // --- Method to calculate the minimum total rental price ---
    public int MinPrice(){
        return price * minHours;
    }
}


