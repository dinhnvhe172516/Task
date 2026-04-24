package controller;

import dto.TaskRequestDTO;
import repository.TaskRepository;
import view.TaskView;

/**
 * Controller class to handle task-related operations between the view and repository.
 */
public class TaskController {

    private TaskRepository taskRepository;
    private TaskView taskView;

    /**
     * Initializes the controller with a new repository and view.
     */
    public TaskController() {
        taskRepository = new TaskRepository();
        taskView = new TaskView();
    }

    /**
     * Adds a new task through the repository.
     * 
     * @param dto The task details to add
     */
    public void addTask(TaskRequestDTO dto) {
        taskRepository.addTask(dto);
    }

    /**
     * Deletes a task by ID through the repository.
     * 
     * @param taskId The ID of the task to delete
     * @throws Exception if deletion fails
     */
    public void deleteTask(int taskId) throws Exception {
        taskRepository.deleteTask(taskId);
    }

    /**
     * Retrieves all tasks and displays them through the view.
     */
    public void displayTasks() {
        taskView.setDataList(taskRepository.getAllTasks());
        taskView.display();
    }
}
