package constants;

/**
 * Enum defining the types of tasks in the system.
 */
public enum TaskType {
    CODE(1, "Code"),
    TEST(2, "Test"),
    DESIGN(3, "Design"),
    REVIEW(4, "Review");

    private int id;
    private String name;

    /**
     * Constructor for TaskType enum.
     * 
     * @param id The ID of the task type
     * @param name The display name of the task type
     */
    TaskType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Converts an ID to its corresponding TaskType.
     * 
     * @param id The ID to look up
     * @return The matching TaskType, or null if not found
     */
    public static TaskType fromId(int id) {
        for (TaskType t : values()) {
            if (t.id == id) {
                return t;
            }
        }
        return null;
    }

    /**
     * Gets the name of the task type for display purposes.
     * 
     * @return The name of the task type
     */
    public String getName() {
        return name;
    }
}
