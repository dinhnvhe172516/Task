package utils;

import constants.Message;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Utility class providing static methods for data validation and parsing.
 * This class handles common input validations such as strings, integers,
 * doubles, dates, and domain-specific rules for task management.
 */
public final class Validation {

    /**
     * Private constructor to prevent instantiation.
     */
    private Validation() {
    }

    /**
     * Validates that the provided input string is not null or empty after trimming.
     * 
     * @param input The raw string input to validate.
     * @return The trimmed version of the input string if valid.
     * @throws Exception If the input is null or consists only of whitespace.
     */
    public static String getString(String input) throws Exception {
        if ((input == null) || (input.trim().isEmpty())) {
            throw new Exception(Message.EMPTY_INPUT);
        }
        return input.trim();
    }

    /**
     * Parses a string into a positive integer.
     * 
     * @param input The numeric string to parse.
     * @return The parsed positive integer.
     * @throws Exception If the input is not a valid integer or is not greater than zero.
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
     * Parses a string into a positive double and validates that it follows the 0.5 hour step rule.
     * 
     * @param input The numeric string to parse.
     * @return The validated double value.
     * @throws Exception If the input is not a valid number, is not positive, or doesn't end in .0 or .5.
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
     * Validates that the provided task type ID is within the valid range (1-4).
     * 
     * @param input The task type ID string.
     * @return The parsed integer ID if valid.
     * @throws Exception If the ID is not a number or is outside the range [1, 4].
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
     * Parses and validates a date string against the "dd-MM-yyyy" format.
     * 
     * @param input The date string to parse.
     * @return The parsed Date object.
     * @throws Exception If the date format is incorrect or the date is invalid.
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
     * Validates the planned working hours constraints.
     * Rules: Start must be >= 8.0, End must be <= 17.5, and Start < End.
     * 
     * @param from The start time.
     * @param to The end time.
     * @throws Exception If any of the timing constraints are violated.
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
     * Validates a menu selection or any choice within a specific integer range.
     * 
     * @param input The choice string to parse.
     * @param min The minimum acceptable value (inclusive).
     * @param max The maximum acceptable value (inclusive).
     * @return The parsed integer choice if within range.
     * @throws Exception If the choice is not a number or is outside the specified range.
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
