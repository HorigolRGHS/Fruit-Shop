/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package l03lab211;

/**
 * L03 - Create a Java console program to manage a Fruit Shop (Product and Shopping).
 *
 * @author Le Khac Huy - CE180311
 */
public class L03Lab211 {

    /**
     * The main method that executes the Fruit Shop System application.
     *
     * @param args The command line arguments (not used in this application).
     */
    public static void main(String[] args) {
        // Initialize instances of ShopManagement, L03Lab211, and Customer classes
        ShopManagement f = new ShopManagement();
        L03Lab211 lab = new L03Lab211();
        Customer c = new Customer();
        // Load input data from files for ShopManagement and Customer
        f.inputFruitFile();
        f.inputCustomerFile();

        // A variable to receive the choices of users
        int choice;
        do {
            // Display the main menu and prompt the user to choose an option
            lab.menu();
            // Prompt the user to enter choices
            choice = Lib.getInteger("Please choose: ", "Invalid choice, please enter an integer (0-4)!", 0, 4);
            switch (choice) {
                case 0:
                    // Option 0: Remove all sold out fruits
                    f.removeSoldOutFruit();
                    f.showFruitList();
                    break;
                case 1:
                    // Option 1: Create a new fruit using the ShopManagement class
                    f.createFruit();
                    f.showFruitList();
                    break;
                case 2:
                    // Option 2: Display the list of customer orders using the Customer class
                    f.showCustomerList();
                    break;
                case 3:
                    // Option 3: Display the list of available fruits, let customers place orders, and update the available fruit lis
                    f.order();
                    break;
                case 4: // Option 4: Save data to output files, exit the application, and display a farewell message
                    f.outputFruitFile();
                    //f.outputCustomerFile();
                    System.out.println("Thanks for using our application!");
                    break;
            }
        } while (choice != 4); //If enter 4, the loop will end

    }

    /**
     * Displays the main menu of the Fruit Shop System application.
     */
    public void menu() {
        System.out.println("FRUIT SHOP SYSTEM");
        System.out.println("0. Delete all sold out fruits");
        System.out.println("1. Create Fruit");
        System.out.println("2. View orders");
        System.out.println("3. Shopping (for buyer)");
        System.out.println("4. Save and Exit");
    }

}
