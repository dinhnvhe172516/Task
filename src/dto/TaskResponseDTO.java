package dto;

import java.util.Date;

/**
 * Data Transfer Object for sending task data to be displayed on the screen.
 */
public class TaskResponseDTO {

    private int id;
    private String requirementName;
    private String taskType;
    private Date date;
    private String time;
    private String assignee;
    private String reviewer;

    /**
     * Parameterized constructor.
     * 
     * @param id Task ID
     * @param requirementName Name of the requirement
     * @param taskType Type of the task
     * @param date Date of the task
     * @param time Formatted time range
     * @param assignee Name of the person assigned to the task
     * @param reviewer Name of the person reviewing the task
     */
    public TaskResponseDTO(int id,
            String requirementName,
            String taskType,
            Date date,
            String time,
            String assignee,
            String reviewer) {

        this.id = id;
        this.requirementName = requirementName;
        this.taskType = taskType;
        this.date = date;
        this.time = time;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }

    /**
     * Gets the task ID.
     * @return The task ID
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the requirement name.
     * @return The requirement name
     */
    public String getRequirementName() {
        return requirementName;
    }

    /**
     * Gets the task type name.
     * @return The task type name
     */
    public String getTaskType() {
        return taskType;
    }

    /**
     * Gets the task date.
     * @return The task date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Gets the formatted time range.
     * @return The time range string
     */
    public String getTime() {
        return time;
    }

    /**
     * Gets the assignee name.
     * @return The assignee name
     */
    public String getAssignee() {
        return assignee;
    }

    /**
     * Gets the reviewer name.
     * @return The reviewer name
     */
    public String getReviewer() {
        return reviewer;
    }
}
