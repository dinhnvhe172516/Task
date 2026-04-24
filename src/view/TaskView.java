package view;

import dto.TaskResponseDTO;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * View class responsible for displaying task data in a table format.
 */
public class TaskView {

    /** List of task data to be printed */
    private List<TaskResponseDTO> dataList;

    /**
     * Sets the data list to be displayed.
     * 
     * @param dataList The list of task response DTOs
     */
    public void setDataList(List<TaskResponseDTO> dataList) {
        this.dataList = dataList;
    }

    /**
     * Displays the tasks in a formatted table on the console.
     */
    public void display() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        // Print table header
        System.out.printf(
                "%-5s%-15s%-12s%-15s%-15s%-10s%-10s\n",
                "ID", "Name", "Type", "Date",
                "Time", "Assignee", "Reviewer");

        // Print each row of task data
        for (TaskResponseDTO t : dataList) {
            System.out.printf(
                    "%-5d%-15s%-12s%-15s%-15s%-10s%-10s\n",
                    t.getId(),
                    t.getRequirementName(),
                    t.getTaskType(),
                    sdf.format(t.getDate()),
                    t.getTime(),
                    t.getAssignee(),
                    t.getReviewer());
        }
    }
}
