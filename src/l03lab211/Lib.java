/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package l03lab211;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * L03 - Create a Java console program to manage a Fruit Shop (Product and Shopping).
 * The useful personal library that is used for all programs. This help input
 * any type of data correctly.
 *
 * @author Le Khac Huy - CE180311
 */
public class Lib {

    public static Scanner sc = new Scanner(System.in);

    /**
     * Check a valid integer
     *
     * @param iMsg Prompt the user to enter an integer
     * @param eMsg Prompt the user to enter again when getting errors
     * @return A valid integer
     */
    public static int getInteger(String iMsg, String eMsg) {
        int n;
        while (true) {
            try {
                System.out.print(iMsg);
                // Parse an integer from the user's input using the nextLine() method and store it in the variable 'n'.
                n = Integer.parseInt(sc.nextLine());
                return n;
            } catch (Exception e) {
                System.out.println(eMsg);
            }

        }
    }

    /**
     * Check a valid integer with a min value of range
     *
     * @param iMsg Prompt the user to enter an integer
     * @param eMsg Prompt the user to enter again when getting errors
     * @param min The min value
     * @return A valid integer with a min value of range
     */
    public static int getInteger(String iMsg, String eMsg, int min) {
        int n;
        while (true) {
            try {
                System.out.print(iMsg);
                // Parse an integer from the user's input using the nextLine() method and store it in the variable 'n'.
                n = Integer.parseInt(sc.nextLine());
                if (n < min) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println(eMsg);
            }

        }
    }

    /**
     * Check a valid integer within a fixed range
     *
     * @param iMsg Prompt the user to enter an integer
     * @param eMsg Prompt the user to enter again when getting errors
     * @param min The min value
     * @param max The max value
     * @return A valid integer within a fixed range
     */
    public static int getInteger(String iMsg, String eMsg, int min, int max) {
        if (min > max) {
            int temp = min;
            min = max;
            max = temp;
        }
        int n;
        while (true) {
            try {
                System.out.print(iMsg);
                // Parse an integer from the user's input using the nextLine() method and store it in the variable 'n'.
                n = Integer.parseInt(sc.nextLine());
                if (n < min || n > max) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println(eMsg);
            }

        }
    }

    /**
     * Check a valid real number
     *
     * @param iMsg Prompt the user to enter an real number
     * @param eMsg Prompt the user to enter again when getting errors
     * @return A valid real number
     */
    public static double getDouble(String iMsg, String eMsg) {
        double n;
        while (true) {
            try {
                System.out.print(iMsg);
                // Parse an real number from the user's input using the nextLine() method and store it in the variable 'n'.
                n = Double.parseDouble(sc.nextLine());
                return n;
            } catch (Exception e) {
                System.out.println(eMsg);
            }

        }
    }

    /**
     * Check a valid real number with a min value of range
     *
     * @param iMsg Prompt the user to enter an real number
     * @param eMsg Prompt the user to enter again when getting errors
     * @param min The min value
     * @return A valid real number with a min value of range
     */
    public static double getDouble(String iMsg, String eMsg, double min) {
        double n;
        while (true) {
            try {
                System.out.print(iMsg);
                // Parse an real number from the user's input using the nextLine() method and store it in the variable 'n'.
                n = Double.parseDouble(sc.nextLine());
                if (n < min) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println(eMsg);
            }
        }
    }

    /**
     * Check a valid real number within a fixed range
     *
     * @param iMsg Prompt the user to enter an real number
     * @param eMsg Prompt the user to enter again when getting errors
     * @param min The min value
     * @param max The max value
     * @return A valid real number within a fixed range
     */
    public static double getDouble(String iMsg, String eMsg, double min, double max) {
        if (min > max) {
            double temp = min;
            min = max;
            max = temp;
        }
        double n;
        while (true) {
            try {
                System.out.print(iMsg);
                // Parse an real number from the user's input using the nextLine() method and store it in the variable 'n'.
                n = Double.parseDouble(sc.nextLine());
                if (n < min || n > max) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println(eMsg);
            }
        }
    }

    /**
     * Enter a valid string
     *
     * @param iMsg Prompt the user to enter a string
     * @param eMsg Prompt the user to enter again when getting errors
     * @return A valid string
     */
    public static String getString(String iMsg, String eMsg) {
        String s;
        while (true) {
            try {
                System.out.print(iMsg);
                s = sc.nextLine();
                // Check if the string is empty (consider a string with all spaces is an empty string)
                if (s.trim().isEmpty()) {
                    throw new Exception();
                }
                return s;
            } catch (Exception e) {
                System.out.println(eMsg);
            }
        }
    }

    /**
     * Enter a valid string
     *
     * @param iMsg Prompt the user to enter a string
     * @param eMsg Prompt the user to enter again when getting errors
     * @return A valid string
     */
    public static String getStringWithLettersSpacesOnly(String iMsg, String eMsg) {
        String s;
        while (true) {
            try {
                System.out.print(iMsg);
                s = sc.nextLine();
                // Check if the string is empty (consider a string with all spaces is an empty string)
                if (s.trim().isEmpty()) {
                    throw new Exception();
                }
                // Check if the string contains any other than letters and spaces
                if (!Pattern.matches("^[a-zA-Z\\s]+$", s)) {
                    throw new Exception();
                }
                return s.trim();
            } catch (Exception e) {
                System.out.println(eMsg);
            }
        }
    }

    /**
     * Enter a valid string with a fixed number of characters
     *
     * @param iMsg Prompt the user to enter a string
     * @param eMsg Prompt the user to enter again when getting errors
     * @param len The number of characters that the string has
     * @return A valid string with the fixed number of characters
     */
    public static String getString(String iMsg, String eMsg, int len) {
        String s;
        while (true) {
            try {
                System.out.print(iMsg);
                s = sc.nextLine();
                // Check if the string is empty (consider a string with all spaces is an empty string)
                if (s.trim().isEmpty() || s.trim().length() != len) {
                    throw new Exception();
                }
                return s;
            } catch (Exception e) {
                System.out.println(eMsg);
            }
        }
    }

    /**
     * Prompts the user with a yes/no question and validates the input.
     *
     * @param iMsg The input message to display, asking for a yes or no
     * response.
     * @param eMsg The error message to display for invalid input.
     * @return true if the user input is 'y' or 'yes', false if 'n' or 'no'.
     */
    public static boolean yesNo(String iMsg, String eMsg) {
        String s;
        while (true) {
            try {
                System.out.print(iMsg);
                s = sc.nextLine();
                // Validate input length and handle variations of 'yes' and 'no'
                if (s.trim().isEmpty() || s.trim().length() < 1 || s.trim().length() > 3) {
                    throw new Exception();
                }
                if (s.trim().equalsIgnoreCase("y") || s.trim().equalsIgnoreCase("yes")) {
                    return true;
                } else if (s.trim().equalsIgnoreCase("n") || s.trim().equalsIgnoreCase("n0")) {
                    return false;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println(eMsg);
            }

        }
    }

    /**
     * Capitalizes first letters of each word in a given string and change other
     * to lower
     *
     * @param s The input string.
     * @return The string with each word capitalized.
     */
    public static String getName(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        String result = "";
        // A variable to check if the next letter need to be capitalized
        boolean capitalizeNext = true;
        // Iterate through each character in the input string
        for (int i = 0; i < s.length(); i++) {
            if (Character.isWhitespace(s.charAt(i))) {
                result += s.charAt(i);
                // If whitespace is encountered, set flag to capitalize the next word
                capitalizeNext = true;
            } else if (capitalizeNext) {
                // Capitalize the first letter of each word
                result += s.toUpperCase().charAt(i);
                capitalizeNext = false;
            } else {
                // Keep the rest of the characters as they are
                result += s.toLowerCase().charAt(i);
            }
        }
        // Return without excess white space
        return result.trim();

    }

    /**
     * Gets user input for an integer, validates it based on specified
     * conditions, and returns the validated number.
     *
     * @param iMsg The input message to display.
     * @param eMsg The error message to display for invalid input.
     * @param denote The condition to check against ("<", "<=", "=", "!=", ">",
     * ">=").
     * @param d The reference value to compare against.
     * @return The validated integer.
     */
    public static int getInteger(String iMsg, String eMsg, String denote, double d) {
        int n;
        while (true) {
            try {
                System.out.print(iMsg);
                // Parse a real number from the user's input using the nextLine() method and store it in the variable 'n'.
                n = Integer.parseInt(sc.nextLine());

                // Check the specified conditions based on the 'denote' parameter.
                if (denote.equals("<")) {
                    if (n >= d) {
                        throw new Exception();
                    }
                } else if (denote.equals("<=")) {
                    if (n > d) {
                        throw new Exception();
                    }
                } else if (denote.equals("=")) {
                    if (n != d) {
                        throw new Exception();
                    }
                } else if (denote.equals("!=")) {
                    if (n == d) {
                        throw new Exception();
                    }
                } else if (denote.equals(">")) {
                    if (n <= d) {
                        throw new Exception();
                    }
                } else if (denote.equals(">=")) {
                    if (n < d) {
                        throw new Exception();
                    }
                }
                // Return the validated real number.
                return n;
            } catch (Exception e) {
                System.out.println(eMsg);
            }
        }
    }

    /**
     * Gets user input for a real number, validates it based on specified
     * conditions, and returns the validated number.
     *
     * @param iMsg The input message to display.
     * @param eMsg The error message to display for invalid input.
     * @param denote The condition to check against ("<", "<=", "=", "!=", ">",
     * ">=").
     * @param d The reference value to compare against.
     * @return The validated real number.
     */
    public static double getDouble(String iMsg, String eMsg, String denote, int d) {
        double n;
        while (true) {
            try {
                System.out.print(iMsg);
                // Parse a real number from the user's input using the nextLine() method and store it in the variable 'n'.
                n = Double.parseDouble(sc.nextLine());

                // Check the specified conditions based on the 'denote' parameter.
                if (denote.equals("<")) {
                    if (n >= d) {
                        throw new Exception();
                    }
                } else if (denote.equals("<=")) {
                    if (n > d) {
                        throw new Exception();
                    }
                } else if (denote.equals("=")) {
                    if (n != d) {
                        throw new Exception();
                    }
                } else if (denote.equals("!=")) {
                    if (n == d) {
                        throw new Exception();
                    }
                } else if (denote.equals(">")) {
                    if (n <= d) {
                        throw new Exception();
                    }
                } else if (denote.equals(">=")) {
                    if (n < d) {
                        throw new Exception();
                    }
                }
                // Return the validated real number.
                return n;
            } catch (Exception e) {
                System.out.println(eMsg);
            }
        }
    }

}
