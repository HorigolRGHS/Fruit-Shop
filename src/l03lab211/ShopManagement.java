/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package l03lab211;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

/**
 * L03 - Create a Java console program to manage a Fruit Shop (Product and Shopping).
 *
 * @author Le Khac Huy - CE180311
 */
public class ShopManagement {

    // ArrayList to store a list of fruits
    private ArrayList<Fruit> fruitList = new ArrayList<>();
    // ArrayList to store a list of sold out fruitf
    private ArrayList<Fruit> soldOutFruitList = new ArrayList<>();

    // Hashtable to store customer orders
    private Hashtable<Integer, ArrayList<Customer>> customerTable = new Hashtable<>();

    /**
     * Default constructor for the FruitManagement class.
     */
    public ShopManagement() {
    }

    /**
     * Getter for the fruitList attribute.
     *
     * @return The ArrayList containing Fruit objects.
     */
    public ArrayList<Fruit> getFruitList() {
        return fruitList;
    }

    /**
     * Setter for the fruitList attribute.
     *
     * @param fruitList The ArrayList to set for the ShopManagement.
     */
    public void setFruitList(ArrayList<Fruit> fruitList) {
        this.fruitList = fruitList;
    }

    /**
     * Method to create a new Fruit and add it to the fruitList.
     */
    public void createFruit() {
        // The variable for checking if the user want to continuously create fruits
        boolean willOrder = true;
        do {
            int id = Lib.getInteger("Enter fruit's ID: ", "Only accept an integer which is greater than 0!", 1);
            // The boolean variable to check if the fruit existed
            boolean isExisted = false;
            for (int i = 0; i < soldOutFruitList.size(); i++) {
                // If the fruit name equals one fruit's name in the list, ask the user if they want to import more for quantity
                if (soldOutFruitList.get(i).getId() == id) {
                    // Change the value of isExisted to true;
                    isExisted = true;
                    // Ask if the user want to import more for quantity of the presented fruit
                    if (Lib.yesNo("This fruit presented already but has been sold out:\n"
                            + "+-------+--------------------+-------------+-----------+---------+\n| ID    | Fruit              | Origin      | Quantity  | Price   |\n+-------+--------------------+-------------+-----------+---------+\n"
                            + soldOutFruitList.get(i).toString() + "\n+-------+--------------------+-------------+-----------+---------+ \nDo you want to import more products for this (Y/N)? ",
                            "Invalid choice (only accept y/n or yes/no)!")) {
                        // Get input for imported quantity
                        int quantity = Lib.getInteger("Enter fruit's quantity: ", "Only accept an integer which is greater than 0!", 1);
                        // Update the quantity
                        soldOutFruitList.get(i).setQuantity(soldOutFruitList.get(i).getQuantity() + quantity);
                        fruitList.add(soldOutFruitList.get(i));
                        soldOutFruitList.remove(i);
                        // Show that it is finished
                        System.out.println("Imported successfully!");
                        // Break the loop
                        break;
                    } else {
                        // If the user choose not to import more, do nothing and break the loop
                        break;
                    }
                }
            }
            // The loop to check if the fruit existed
            if (!isExisted) {
                for (int i = 0; i < fruitList.size(); i++) {
                    // If the fruit name equals one fruit's name in the list, ask the user if they want to import more for quantity
                    if (fruitList.get(i).getId() == id) {
                        // Change the value of isExisted to true;
                        isExisted = true;
                        // Ask if the user want to import more for quantity of the presented fruit
                        if (Lib.yesNo("This fruit presented already:\n"
                                + "+-------+--------------------+-------------+-----------+---------+\n| ID    | Fruit              | Origin      | Quantity  | Price   |\n+-------+--------------------+-------------+-----------+---------+\n"
                                + fruitList.get(i).toString() + "\n+-------+--------------------+-------------+-----------+---------+ \nDo you want to import more products for this (Y/N)? ",
                                "Invalid choice (only accept y/n or yes/no)!")) {
                            // Get input for imported quantity
                            int quantity = Lib.getInteger("Enter fruit's quantity: ", "Only accept an integer which is greater than 0!", 1);
                            // Update the quantity
                            fruitList.get(i).setQuantity(fruitList.get(i).getQuantity() + quantity);
                            // Show that it is finished
                            System.out.println("Imported successfully!");
                            // Break the loop
                            break;
                        } else {
                            // If the user choose not to import more, do nothing and break the loop
                            break;
                        }
                    }
                }
            }
            // Create a completely new fruit if is hasn't existed in the list
            if (!isExisted) {
                // Generate a unique id for the new fruit
                //  Get input for the fruit's name
                String name = Lib.getStringWithLettersSpacesOnly("Enter fruit's name: ", "Only accept letters (or letters and spaces)!");
                name = Lib.getName(name);
                //  Get input for the fruit's origin
                String origin = Lib.getStringWithLettersSpacesOnly("Enter fruit's origin: ", "Only accept letters (or letters and spaces)!");
                origin = Lib.getName(origin);
                // Get input for quantity
                int quantity = Lib.getInteger("Enter fruit's quantity: ", "Only accept an integer which is greater than 0!", 1);
                // Get input for price
                double price = Lib.getDouble("Enter fruit's price: ", "Only accept a real number which is greater than 0!", ">", 0);
                // Create a new Fruit object and add it to the fruitList
                fruitList.add(new Fruit(id, name, quantity, price, origin));
                System.out.println("Creat a new fruit successfully!");
                // Check if the user wants to order again
            }
            // Ask if the user want to continuously create fruits
            willOrder = Lib.yesNo("Do you want to continue(Y/N)? ", "Invalid choice (only accept y/n or yes/no)!");
        } while (willOrder);

    }

    /**
     * Method to display the list of fruits.
     */
    public void showFruitList() {
        System.out.println("List of Fruit:");
        System.out.println("+-------+-------+--------------------+-------------+-----------+---------+");
        System.out.println("| No.   | ID    | Fruit              | Origin      | Quantity  | Price   |");
        System.out.println("+-------+-------+--------------------+-------------+-----------+---------+");
        // Display each Fruit object in the fruitList
        for (int i = 0; i < fruitList.size(); i++) {
            System.out.printf("| %5d ", i + 1);
            System.out.println(fruitList.get(i));
        }
        System.out.println("+-------+-------+--------------------+-------------+-----------+---------+");
    }

    /**
     * Method to read data from an input file and populate the fruitList.
     */
    public void inputFruitFile() {
        try {
            // Read data from the input file
            Scanner sc = new Scanner(new File("inputFruit.txt"));
            // The first line contains the number of fruit (N)
            int N = Integer.parseInt(sc.nextLine());
            // The N next lines contain the information of fruits: id, name, quantity, price, origin in each line
            for (int i = 0; i < N; i++) {
                String line = sc.nextLine();
                // Split the line (by the splash) 
                String arr[] = line.split("/+");
                // Change data types correctly when creating a new Fruit object then add to the list
                fruitList.add(new Fruit(Integer.parseInt(arr[0]), arr[1], Integer.parseInt(arr[2]), Double.parseDouble(arr[3]), arr[4]));
            }
        } catch (FileNotFoundException | NumberFormatException e) {
        }
    }

    /**
     * Method to write data to an output file.
     */
    public void outputFruitFile() {
        try {
            // The first line contains the number of fruit (N)
            try ( // Write data to the output file
                    FileWriter out = new FileWriter("outputFruit.txt")) {
                // The first line contains the number of fruit (N)
                out.write(fruitList.size() + "\r\n");
                // The N next lines are the information (toString()) of each fruit
                for (Fruit f : fruitList) {
                    out.write(f.toDataString() + "\r\n");
                }
                // Close the file after writing
            }
        } catch (IOException e) {
        }
    }

    /**
     * Method for ordering fruits
     */
    public void order() {
        // List to store the customer's selected fruits
        ArrayList<Fruit> waitingList = new ArrayList<>();
        // A boolean variable to check if the buyer want to order now
        boolean choice = true;
        do {
            if(fruitList.isEmpty()){
                System.out.println("There are no available fruits now!");
                break;
            }
            showFruitList();
            // Prompt the customer to choose a fruit by entering its ID
            int id = Lib.getInteger("Choose the NO. of the fruit you want to order: ", "Please choose available No.!", 1, fruitList.size());
            // Adjust the index to match the array index
            int index = id - 1;
            // Display the selected fruit's name
            System.out.println("You select: " + fruitList.get(index).getName());
            if (fruitList.get(index).getQuantity() <= 0) {
                // Inform the customer if the selected product is sold out
                System.out.println("Sorry, this product is sold out!");
            } else {
                // Prompt the customer to input the quantity of the selected fruit
                System.out.println("Number of products available: " + fruitList.get(index).getQuantity());
                int quantity = Lib.getInteger("Please input quantity: ", "Only accept an integer ranges from 1 to " + fruitList.get(index).getQuantity() + "!", 1, fruitList.get(index).getQuantity());
                // Create a new Fruit object representing the customer's order and add it to the waitingList 
                // (get every information except the quantity because it need to receive the ordered quantity)
                Fruit waitingFruit = new Fruit(
                        fruitList.get(index).getId(),
                        fruitList.get(index).getName(),
                        quantity, // the ordered quantity
                        fruitList.get(index).getPrice(),
                        fruitList.get(index).getOrigin()
                );
                // Add fruit to the waiting list
                int presentedFruitIndex = -1;
                // Loop through the existing items in the list to check if the fruit is already present
                for (int i = 0; i < waitingList.size(); i++) {
                    if (waitingList.get(i).getId() == fruitList.get(index).getId()) {
                        presentedFruitIndex = i; // Save the index if the fruit is found
                        break;
                    }
                }
                if (presentedFruitIndex != -1) {
                    // If the fruit is already present in the list, update its quantity
                    waitingList.get(presentedFruitIndex).setQuantity(waitingList.get(presentedFruitIndex).getQuantity() + waitingFruit.getQuantity());
                } else {
                    // If the fruit is not present, assign a new ID and add it to the list
                    waitingList.add(waitingFruit);
                }
                // Update the available quantity of the selected fruit
                fruitList.get(index).setQuantity(fruitList.get(index).getQuantity() - quantity);
                // if after being updated, quantity = 0, then add that fruit into soldOutFruitList and remove it from fruitList
                if (fruitList.get(index).getQuantity() == 0) {
                    soldOutFruitList.add(fruitList.get(index));
                    fruitList.remove(index);
                }
            }
            // Ask the customer if they want to continue ordering
            if (!fruitList.isEmpty()) {
                choice = Lib.yesNo("Do you want to order now (Y/N) ", "Invalid choice (only accept y/n or yes/no)!");
            } else {
                System.out.println("All fruits have been sold out!");
                break;
            }
        } while (!choice);
        System.out.println("+-------+-------+--------------------+-------------+-----------+---------+------------+");
        System.out.println("| No.   | ID    |Fruit               | Origin      | Quantity  | Price   | Amount     |");
        System.out.println("+-------+-------+--------------------+-------------+-----------+---------+------------+");
        // A variable to calcutlate the total amount
        double total = 0;
        // Display each fruit in the waitingList with detailed information
        for (int i = 0; i < waitingList.size(); i++) {
            String formattedAmount = "$" + (String.format("%.1f", waitingList.get(i).getAmount()));
            System.out.printf("| %5d ", i + 1);
            System.out.printf(waitingList.get(i) + "%11s |\n", formattedAmount);
            total += waitingList.get(i).getAmount();
        }
        // Display the total amount for the customer's order
        String formattedTotal = "$" + (String.format("%.1f", total));
        System.out.println("+-------+-------+--------------------+-------------+-----------+---------+------------+");
        System.out.printf("|                                                                  TOTAL |%11s |\n", formattedTotal);
        System.out.println("+-------+-------+--------------------+-------------+-----------+---------+------------+\n");
        // Prompt the customer to enter their name for the order
        String customerName = Lib.getStringWithLettersSpacesOnly("Enter your name: ", "Invalid name (only contains letters (or letters and spaces)!");
        customerName = Lib.getName(customerName);
        ArrayList<Customer> waitingCustomerList = new ArrayList<>();
        // If the customer already exists in the customerList, add their previous orders to the waitingList
        // Update the customerList with the customer's name and the final waitingList representing their order
        for (Fruit w : waitingList) {
            waitingCustomerList.add(new Customer(
                    w.getId(),
                    w.getName(),
                    w.getQuantity(),
                    w.getPrice(),
                    w.getOrigin(),
                    customerName
            ));
        }
        customerTable.put(customerTable.size(), waitingCustomerList);
        // Return the updated list of available fruits after the order is placed
    }

    /**
     * Removes fruits with zero quantity from the fruit list. Iterates through
     * the fruit list and removes any fruit with a quantity of zero. Prints a
     * message indicating that all sold-out fruits have been removed.
     */
    void removeSoldOutFruit() {
        soldOutFruitList.clear();
    }

    /**
     * Displays the list of customer orders with detailed information.
     */
    public void showCustomerList() {
        if (customerTable.isEmpty()) {
            System.out.println("There are no orders now!");
        } else {
            // Loop to show all the customers
            for (Map.Entry<Integer, ArrayList<Customer>> entry : customerTable.entrySet()) {
                System.out.println("Customer: " + entry.getValue().get(0).getCustomerName());
                System.out.println("+-------+-------+--------------------+-------------+-----------+---------+------------+");
                System.out.println("| No.   | ID    | Fruit              | Origin      | Quantity  | Price   |  Amount    |");
                System.out.println("+-------+-------+--------------------+-------------+-----------+---------+------------+");
                double total = 0;
                for (int i = 0; i < entry.getValue().size(); i++) {
                    String formattedAmount = "$" + (String.format("%.1f", entry.getValue().get(i).getAmount()));
                    System.out.printf("| %5d ", i + 1);
                    System.out.printf(entry.getValue().get(i) + "%11s |\n", formattedAmount);
                    total += entry.getValue().get(i).getPrice() * entry.getValue().get(i).getQuantity();
                }
                String formattedTotal = "$" + (String.format("%.1f", total));
                System.out.println("+-------+-------+--------------------+-------------+-----------+---------+------------+");
                System.out.printf("|                                                                  TOTAL |%11s |\n", formattedTotal);
                System.out.println("+-------+-------+--------------------+-------------+-----------+---------+------------+\n");
            }
        }
    }

    /**
     * Reads customer data from an input file and populates the customerList.
     */
    public void inputCustomerFile() {
        try {
            Scanner sc = new Scanner(new File("inputCustomer.txt"));
            // Total number of customers
            int T = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < T; i++) {
                // First lines in each loop are customer's name
                int key = Integer.parseInt(sc.nextLine());
                // Total number of fruits in the order
                int N = Integer.parseInt(sc.nextLine());
                // Create a temporary Customer list to receives the list of fruit
                ArrayList<Customer> tempCustomerList = new ArrayList<>();
                // Clear the temporary Customer list after each loop
                tempCustomerList.clear();
                for (int j = 0; j < N; j++) {
                    String line = sc.nextLine();
                    // Split by the slash
                    String arr[] = line.split("/+");
                    // Create a temporary Customer object from the input and add it to the order list, parse date types correctly with id, name, quantity, price, origin, and customerName
                    Customer tempCustomer = new Customer(Integer.parseInt(arr[0]), arr[1], Integer.parseInt(arr[2]), Double.parseDouble(arr[3]), arr[4], arr[5]);
                    // Add Customer to the temporary list
                    tempCustomerList.add(tempCustomer);
                }
                // Populate the customerTable with the customer's name and order list
                customerTable.put(key, tempCustomerList);
            }
        } catch (Exception e) {
        }
    }

    /**
     * Writes customer data to an output file.
     */
    public void outputCustomerFile() {
        try {
            // Total number of customers
            try (FileWriter out = new FileWriter("outputCustomer.txt")) {
                // Total number of customers
                out.write(customerTable.size() + "\r\n");
                // Loop through each customer in the customerList
                for (Map.Entry<Integer, ArrayList<Customer>> entry : customerTable.entrySet()) {
                    // Customer's name
                    out.write(entry.getKey() + "\r\n");
                    // Total number of fruits in the order
                    out.write(entry.getValue().size() + "\r\n");
                    for (Customer c : entry.getValue()) {
                        // Write each Fruit object's details to the output file (id, name, quantity, price, origin)
                        out.write(c.toDataString() + "\r\n");
                    }
                }
                out.close();
            }
        } catch (IOException e) {
        }
    }
}
