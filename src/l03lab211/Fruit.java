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
public class Fruit {

    private int id;            // Unique identifier for the fruit
    private String name;       // Name of the fruit
    private double price;      // Price of the fruit
    private int quantity;      // Quantity of the fruit
    private String origin;     // Origin of the fruit

    /**
     * Default constructor for the Fruit class.
     */
    public Fruit() {
    }

    /**
     * Parameterized constructor for the Fruit class.
     *
     * @param id Unique identifier for the fruit.
     * @param name Name of the fruit.
     * @param quantity Quantity of the fruit.
     * @param price Price of the fruit.
     * @param origin Origin of the fruit.
     */
    public Fruit(int id, String name, int quantity, double price, String origin) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.origin = origin;
    }

    /**
     * Getter for the id attribute.
     *
     * @return The id of the fruit.
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for the id attribute.
     *
     * @param id The id to set for the fruit.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter for the name attribute.
     *
     * @return The name of the fruit.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the name attribute.
     *
     * @param name The name to set for the fruit.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the price attribute.
     *
     * @return The price of the fruit.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Setter for the price attribute.
     *
     * @param price The price to set for the fruit.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Getter for the quantity attribute.
     *
     * @return The quantity of the fruit.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Setter for the quantity attribute.
     *
     * @param quantity The quantity to set for the fruit.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Getter for the origin attribute.
     *
     * @return The origin of the fruit.
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * Setter for the origin attribute.
     *
     * @param origin The origin to set for the fruit.
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * Calculates and returns the total amount for the item(s) based on quantity
     * and price.
     *
     * @return The total amount for the item(s).
     */
    public double getAmount() {
        return price * quantity;
    }

    @Override
    /**
     * Override the toString method to provide a formatted string representation
     * of the Fruit.
     *
     * @return A formatted string containing the attributes of the fruit.
     */
    public String toString() {
        String formattedPrice = "$" + (String.format("%.1f", price));
        return String.format("|%6d | %-19s| %-12s|%10s |%8s |", id, name, origin, (quantity > 0 ? quantity : "Sold out!"), formattedPrice);
    }

    /**
     * The method to provide a formatted string to input data files
     *
     * @return Formatted string to input data files
     */
    public String toDataString() {
        return String.format("%d/%s/%d/%.1f/%s", id, name, quantity, price, origin);
    }
}
