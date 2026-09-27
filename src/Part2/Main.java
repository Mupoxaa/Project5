package Part2;

import java.util.Scanner;

/*
=== PSEUDOCODE ===
1. Create a Scanner to read input from the console.
2. Display the program title banner.
3. Start a main loop (do-while):
   a. Ask the user for their name.
   b. Ask the user for their age. If they enter text instead of a number, set age to 0.
   c. Ask the user for their preferred anime genre (lowercase).
   d. Call recommendAnime() to print the recommended show based on age and genre.
   e. Call askYesNo() to ask if the user wants to restart the program.
4. If the user chooses 'Y', repeat the loop. If 'N', stop and print a goodbye message.
*/

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        print("=========================================");
        print("=== PART 4: ANIME RECOMMENDER IN LOOP ===");
        print("=========================================");

        boolean repeat;

        do {
            String name = getUserString("\nWhat is your name? ", scanner);

            int age = 0;
            try {
                age = Integer.parseInt(getUserString("Enter your age: ", scanner));
            } catch (NumberFormatException e) {
                print("Invalid age entered, defaulting to 0.");
            }

            String genrePrompt = "Nice to meet you, " + name + "! Enter your preferred genre (action / dark fantasy / comedy / slice of life / romance): ";
            String genre = getUserString(genrePrompt, scanner).toLowerCase();

            print("\nFinding the best anime for " + name + "...");

            // Call decomposed recommendation logic
            recommendAnime(age, genre);

            // Call wrapped Y/N Dialog method
            repeat = askYesNo("\nDo you want to repeat the whole conversation? (Y/N): ", scanner);

        } while (repeat);

        print("\nThank you for using the Anime Recommender System! Enjoy watching!");
    }



    // Wrap output calls
    public static void print(String message) {
        System.out.println(message);
    }

    // Wrap input calls
    public static String getUserString(String prompt, Scanner scanner) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    // Wrap Y/N Dialog
    public static boolean askYesNo(String prompt, Scanner scanner) {
        while (true) {
            String input = getUserString(prompt, scanner);
            if (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes")) {
                return true;
            } else if (input.equalsIgnoreCase("n") || input.equalsIgnoreCase("no")) {
                return false;
            }
            print("Invalid input! Please enter 'Y' or 'N'.");
        }
    }


    public static void recommendAnime(int age, String genre) {
        if (age >= 16) {
            if (genre.equals("dark fantasy") || genre.equals("action")) {
                print("Recommendation: 'Attack on Titan' (Shingeki no Kyojin) - A masterpiece with deep lore, political drama, and intense action!");
            } else if (genre.equals("comedy") || genre.equals("slice of life")) {
                print("Recommendation: 'K-On!' - A wholesome and heartwarming comedy about a high school light music club!");
            } else if (genre.equals("romance")) {
                print("Recommendation: 'Your Name' (Kimi no Na wa) - A beautiful romantic sci-fi story.");
            } else {
                print("Recommendation: 'One Punch Man' - Great combination of action and superhero comedy.");
            }
        } else if (age >= 12 && age < 16) {
            if (genre.equals("action") || genre.equals("dark fantasy")) {
                print("Recommendation: 'Demon Slayer' (Kimetsu no Yaiba) - Epic action and swordsmanship.");
            } else if (genre.equals("comedy") || genre.equals("slice of life")) {
                print("Recommendation: 'K-On!' - Cute girls doing cute things and playing music!");
            } else {
                print("Recommendation: 'Spy x Family' - Fun, action-packed family comedy.");
            }
        } else {
            if (genre.equals("comedy") || genre.equals("romance") || genre.equals("slice of life")) {
                print("Recommendation: 'My Neighbor Totoro' - Wholesome and classic Studio Ghibli film.");
            } else {
                print("Recommendation: 'Pokémon' - Classic adventure for all ages.");
            }
        }
    }
}