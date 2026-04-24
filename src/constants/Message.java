package constants;

/**
 * Class containing all system messages and display strings.
 */
public final class Message {

    /**
     * Private constructor to prevent instantiation.
     */
    private Message() {
    }

    /** Menu title and options */
    public static final String MENU = "\n========= Task Management Program =========\n"
            + "1. Add Task\n"
            + "2. Delete Task\n"
            + "3. Display Tasks\n"
            + "4. Exit\n";
    
    /** Input prompts */
    public static final String INPUT_CHOICE = "Enter your choice: ";
    public static final String INPUT_REQUIREMENT = "Requirement Name: ";
    public static final String INPUT_TASK_TYPE = "Task Type: ";
    public static final String INPUT_DATE = "Date (dd-MM-yyyy): ";
    public static final String INPUT_FROM = "From (8.0, 8.5, ...): ";
    public static final String INPUT_TO = "To (8.5, 9.0, ...): ";
    public static final String INPUT_ASSIGNEE = "Assignee: ";
    public static final String INPUT_REVIEWER = "Reviewer: ";
    public static final String INPUT_ID = "Enter ID: ";

    /** Success messages */
    public static final String SUCCESS_ADD = "Task added successfully.";
    public static final String SUCCESS_DELETE = "Task deleted successfully.";

    /** Error and validation messages */
    public static final String EMPTY_INPUT = "Input cannot be empty.";
    public static final String INVALID_NUMBER = "Please enter a valid numeric value.";
    public static final String INVALID_POSITIVE = "Value must be a positive number greater than zero.";
    public static final String INVALID_CHOICE = "Choice must be in the range [%d - %d].";
    public static final String INVALID_TASK_TYPE = "Task type must be between 1 and 4.";
    public static final String INVALID_DATE = "Invalid date format. Please use dd-MM-yyyy.";
    public static final String INVALID_TIME_STEP = "Time must be in 0.5 hour increments (e.g., 8.0, 8.5).";
    public static final String INVALID_TIME_FROM = "Start time must be at least 8.0.";
    public static final String INVALID_TIME_TO = "End time must be at most 17.5.";
    public static final String INVALID_TIME_ORDER = "Start time must be strictly less than end time.";
    public static final String TASK_NOT_EXIST = "Task ID not found in the system.";
}
