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
public class Customer extends Fruit {

    private String customerName; // Name of the customer

    /**
     * Default constructor for the Customer class.
     */
    public Customer() {
    }

    /**
     * Constructor for the Customer class. Initializes a Customer object with
     * the specified parameters.
     *
     * @param id The unique identifier for the customer.
     * @param name The name of the item purchased.
     * @param quantity The quantity of the item purchased.
     * @param price The price of the item per unit.
     * @param origin The origin of the item.
     * @param customerName The name of the customer.
     */
    public Customer(int id, String name, int quantity, double price, String origin, String customerName) {
        super(id, name, quantity, price, origin);
        this.customerName = customerName;
    }

    /**
     * Gets the name of the customer.
     *
     * @return The customer's name.
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Sets the name of the customer.
     *
     * @param customerName The new name for the customer.
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * Returns a string representation of the customer's data.
     *
     * @return A string containing the customer's data.
     */
    @Override
    public String toDataString() {
        return super.toDataString() + "/" + customerName;
    }

}
