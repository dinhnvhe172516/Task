package utils;

import constants.Message;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Utility class for data validation.
 */
public final class Validation {

    /**
     * Private constructor to prevent instantiation.
     */
    private Validation() {
    }

    /**
     * Validates that the input string is not empty.
     * 
     * @param input The string to validate
     * @return The trimmed input string
     * @throws Exception if input is empty
     */
    public static String getString(String input) throws Exception {
        if ((input == null) || (input.trim().isEmpty())) {
            throw new Exception(Message.EMPTY_INPUT);
        }
        return input.trim();
    }

    /**
     * Validates and parses a positive integer from a string.
     * 
     * @param input The string to parse
     * @return The positive integer value
     * @throws Exception if input is not a positive integer
     */
    public static int getPositiveInt(String input) throws Exception {
        try {
            int value = Integer.parseInt(input);
            if (value <= 0) {
                throw new Exception(Message.INVALID_POSITIVE);
            }
            return value;
        } catch (NumberFormatException e) {
            throw new Exception(Message.INVALID_NUMBER);
        }
    }

    /**
     * Validates and parses a positive double with .0 or .5 step.
     * 
     * @param input The string to parse
     * @return The validated double value
     * @throws Exception if input is invalid or doesn't follow the step rule
     */
    public static double getPositiveDouble(String input) throws Exception {
        try {
            double value = Double.parseDouble(input);

            // Must be greater than 0
            if (value <= 0) {
                throw new Exception(Message.INVALID_POSITIVE);
            }

            // Only accept .0 or .5 (e.g., 8.0, 8.5, 9.0)
            if (value % 0.5 != 0) {
                throw new Exception(Message.INVALID_TIME_STEP);
            }

            return value;
        } catch (NumberFormatException e) {
            throw new Exception(Message.INVALID_NUMBER);
        }
    }

    /**
     * Validates that the task type is between 1 and 4.
     * 
     * @param input The string to parse
     * @return The valid task type ID
     * @throws Exception if task type is invalid
     */
    public static int validateTaskType(String input) throws Exception {
        try {
            int id = Integer.parseInt(input);

            if (id < 1 || id > 4) {
                throw new Exception(Message.INVALID_TASK_TYPE);
            }

            return id;

        } catch (NumberFormatException e) {
            throw new Exception(Message.INVALID_NUMBER);
        }
    }

    /**
     * Validates and parses a date in dd-MM-yyyy format.
     * 
     * @param input The date string
     * @return The parsed Date object
     * @throws Exception if date format is invalid
     */
    public static Date validateDate(String input) throws Exception {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            sdf.setLenient(false);
            return sdf.parse(input);
        } catch (ParseException e) {
            throw new Exception(Message.INVALID_DATE);
        }
    }

    /**
     * Validates the planned working time (8.0 - 17.5 and from < to).
     * 
     * @param from Start time
     * @param to End time
     * @throws Exception if time constraints are violated
     */
    public static void validatePlanTime(double from, double to) throws Exception {

        // Start time must be at least 8.0
        if (from < 8.0) {
            throw new Exception(Message.INVALID_TIME_FROM);
        }

        // End time must not exceed 17.5
        if (to > 17.5) {
            throw new Exception(Message.INVALID_TIME_TO);
        }

        // Start time must be less than end time
        if (from >= to) {
            throw new Exception(Message.INVALID_TIME_ORDER);
        }
    }

    /**
     * Validates a menu choice within a specified range.
     * 
     * @param input The choice string
     * @param min Minimum valid value
     * @param max Maximum valid value
     * @return The valid choice integer
     * @throws Exception if choice is out of range
     */
    public static int getChoice(String input, int min, int max) throws Exception {
        int choice = getPositiveInt(input);
        if ((choice < min) || (choice > max)) {
            throw new Exception(
                    String.format(Message.INVALID_CHOICE, min, max));
        }
        return choice;
    }
}
