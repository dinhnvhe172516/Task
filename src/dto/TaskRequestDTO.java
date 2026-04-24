package dto;

import java.util.Date;

/**
 * Data Transfer Object for capturing user input when creating a task.
 */
public class TaskRequestDTO {

    private int taskTypeId;
    private String requirementName;
    private Date date;
    private double from;
    private double to;
    private String assignee;
    private String reviewer;

    /**
     * Gets the task type ID.
     * @return The task type ID
     */
    public int getTaskTypeId() {
        return taskTypeId;
    }

    /**
     * Sets the task type ID.
     * @param taskTypeId The task type ID to set
     */
    public void setTaskTypeId(int taskTypeId) {
        this.taskTypeId = taskTypeId;
    }

    /**
     * Gets the requirement name.
     * @return The requirement name
     */
    public String getRequirementName() {
        return requirementName;
    }

    /**
     * Sets the requirement name.
     * @param requirementName The requirement name to set
     */
    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    /**
     * Gets the task date.
     * @return The task date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the task date.
     * @param date The task date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Gets the start time.
     * @return The start time
     */
    public double getFrom() {
        return from;
    }

    /**
     * Sets the start time.
     * @param from The start time to set
     */
    public void setFrom(double from) {
        this.from = from;
    }

    /**
     * Gets the end time.
     * @return The end time
     */
    public double getTo() {
        return to;
    }

    /**
     * Sets the end time.
     * @param to The end time to set
     */
    public void setTo(double to) {
        this.to = to;
    }

    /**
     * Gets the assignee name.
     * @return The assignee name
     */
    public String getAssignee() {
        return assignee;
    }

    /**
     * Sets the assignee name.
     * @param assignee The assignee name to set
     */
    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    /**
     * Gets the reviewer name.
     * @return The reviewer name
     */
    public String getReviewer() {
        return reviewer;
    }

    /**
     * Sets the reviewer name.
     * @param reviewer The reviewer name to set
     */
    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }
}
