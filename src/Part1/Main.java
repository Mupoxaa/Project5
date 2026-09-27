package Part1;

public class Main {
    public static void main(String[] args) {
        Sauna sauna1 = new Sauna("Vodoley", 1000, 10, 2, true);
        Sauna sauna2 = new Sauna("Aqua", 2000, 15, 3, false);

        sauna1.PrintDetails();
        sauna2.PrintDetails();
    }
}