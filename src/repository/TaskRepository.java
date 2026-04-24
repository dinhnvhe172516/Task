package repository;

import constants.Message;
import constants.TaskType;
import dto.TaskRequestDTO;
import dto.TaskResponseDTO;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import model.Task;

/**
 * Repository for managing tasks in memory.
 */
public class TaskRepository {

    /** List to store tasks */
    private List<Task> taskList;
    /** Variable to store the last ID for auto-incrementing new tasks */
    private int lastId;

    /**
     * Initializes the TaskRepository with an empty list.
     */
    public TaskRepository() {
        taskList = new ArrayList<>();
        lastId = 0;
    }

    /**
     * Adds a new task to the system.
     * 
     * @param dto The data transfer object containing task details
     */
    public void addTask(TaskRequestDTO dto) {
        // Mapping from DTO to Task model
        Task task = new Task(
                ++lastId,
                dto.getTaskTypeId(),
                dto.getRequirementName(),
                dto.getDate(),
                dto.getFrom(),
                dto.getTo(),
                dto.getAssignee(),
                dto.getReviewer()
        );
        // Add the task to the list
        taskList.add(task);
    }

    /**
     * Finds a task by its unique ID.
     * 
     * @param taskId The ID of the task to find
     * @return The Task object if found
     * @throws Exception if the task does not exist
     */
    private Task findTaskById(int taskId) throws Exception {
        for (Task t : taskList) {
            // Check if the ID matches
            if (t.getId() == taskId) {
                return t;
            }
        }
        throw new Exception(Message.TASK_NOT_EXIST);
    }

    /**
     * Deletes a task from the system by its ID.
     * 
     * @param taskId The ID of the task to delete
     * @throws Exception if the task does not exist
     */
    public void deleteTask(int taskId) throws Exception {
        Task task = findTaskById(taskId);
        taskList.remove(task);
    }

    /**
     * Retrieves all tasks formatted for display.
     * 
     * @return A list of TaskResponseDTOs sorted by ID
     */
    public List<TaskResponseDTO> getAllTasks() {
        // Sort tasks by ID in ascending order before returning
        taskList.sort(Comparator.comparing(Task::getId));

        List<TaskResponseDTO> dataList = new ArrayList<>();

        for (Task t : taskList) {
            TaskType type = TaskType.fromId(t.getTaskTypeId());
            String time = String.format("%.1f - %.1f", t.getFrom(), t.getTo());

            // Mapping to ResponseDTO for display in the view
            dataList.add(new TaskResponseDTO(
                    t.getId(),
                    t.getRequirementName(),
                    type.getName(),
                    t.getDate(),
                    time,
                    t.getAssignee(),
                    t.getReviewer()
            ));
        }
        return dataList;
    }
}
