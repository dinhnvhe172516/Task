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
            + "3. Display Task\n"
            + "4. Exit\n";
    
    /** Input prompts */
    public static final String INPUT_CHOICE = "Enter your choice: ";
    public static final String INPUT_REQUIREMENT = "Requirement Name: ";
    public static final String INPUT_TASK_TYPE = "Task Type: ";
    public static final String INPUT_DATE = "Date: ";
    public static final String INPUT_FROM = "From: ";
    public static final String INPUT_TO = "To: ";
    public static final String INPUT_ASSIGNEE = "Assignee: ";
    public static final String INPUT_REVIEWER = "Reviewer: ";
    public static final String INPUT_ID = "Enter ID: ";

    /** Error and validation messages */
    public static final String EMPTY_INPUT = "Input cannot be empty";
    public static final String INVALID_NUMBER = "Please enter a valid number";
    public static final String INVALID_POSITIVE = "Value must be greater than 0";
    public static final String INVALID_CHOICE = "Choice must be from %d to %d";
    public static final String INVALID_TASK_TYPE = "Task type must be from 1 to 4";
    public static final String INVALID_DATE = "Invalid date format (dd-MM-yyyy)";
    public static final String INVALID_TIME_STEP = "Time must end in .0 or .5 only";
    public static final String INVALID_TIME_FROM = "Start time must be from 8.0";
    public static final String INVALID_TIME_TO = "End time must not exceed 17.5";
    public static final String INVALID_TIME_ORDER = "Start time must be less than end time";
    public static final String TASK_NOT_EXIST = "Task does not exist";
}
