package model;

import java.util.Date;

/**
 * Model class representing a Task in the system.
 */
public class Task {

    private int id;
    private int taskTypeId;
    private String requirementName;
    private Date date;
    private double from;
    private double to;
    private String assignee;
    private String reviewer;

    /**
     * Parameterized constructor to initialize a Task.
     * 
     * @param id Task ID
     * @param taskTypeId ID of the task type
     * @param requirementName Name of the requirement
     * @param date Date of the task
     * @param from Start time
     * @param to End time
     * @param assignee Name of the assignee
     * @param reviewer Name of the reviewer
     */
    public Task(int id, int taskTypeId, String requirementName,
            Date date, double from, double to,
            String assignee, String reviewer) {

        this.id = id;
        this.taskTypeId = taskTypeId;
        this.requirementName = requirementName;
        this.date = date;
        this.from = from;
        this.to = to;
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
     * Gets the task type ID.
     * @return The task type ID
     */
    public int getTaskTypeId() {
        return taskTypeId;
    }

    /**
     * Gets the requirement name.
     * @return The requirement name
     */
    public String getRequirementName() {
        return requirementName;
    }

    /**
     * Gets the task date.
     * @return The task date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Gets the start time.
     * @return The start time
     */
    public double getFrom() {
        return from;
    }

    /**
     * Gets the end time.
     * @return The end time
     */
    public double getTo() {
        return to;
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
