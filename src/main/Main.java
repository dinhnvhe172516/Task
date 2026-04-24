package main;

import constants.Message;
import controller.TaskController;
import dto.TaskRequestDTO;
import java.util.Date;
import java.util.Scanner;
import utils.Validation;

/**
 * Main class to run the Task Management program.
 */
public class Main {

    public static void main(String[] args) {
        // Initialize variables
        Scanner sc = new Scanner(System.in);
        TaskController controller = new TaskController();
        int choice;
        int id;
        TaskRequestDTO dto;
        String dateStr;
        Date date;
        double from;
        double to;

        while (true) {
            // Display Menu and get user choice
            System.out.println(Message.MENU);
            System.out.print(Message.INPUT_CHOICE);

            try {
                choice = Validation.getChoice(sc.nextLine(), 1, 4);

                switch (choice) {
                    case 1:
                        // Add Task flow
                        dto = new TaskRequestDTO();

                        // Input Requirement Name
                        System.out.print(Message.INPUT_REQUIREMENT);
                        dto.setRequirementName(
                                Validation.getString(sc.nextLine()));

                        // Input Task Type
                        System.out.print(Message.INPUT_TASK_TYPE);
                        dto.setTaskTypeId(
                                Validation.validateTaskType(
                                        sc.nextLine()));

                        // Input Date
                        System.out.print(Message.INPUT_DATE);
                        dateStr = Validation.getString(sc.nextLine());
                        date = Validation.validateDate(dateStr);
                        dto.setDate(date);

                        // Input Start Time
                        System.out.print(Message.INPUT_FROM);
                        from = Validation.getPositiveDouble(
                                sc.nextLine());
                        dto.setFrom(from);

                        // Input End Time
                        System.out.print(Message.INPUT_TO);
                        to = Validation.getPositiveDouble(
                                sc.nextLine());
                        dto.setTo(to);

                        // Validate plan time constraints
                        Validation.validatePlanTime(from, to);

                        // Input Assignee
                        System.out.print(Message.INPUT_ASSIGNEE);
                        dto.setAssignee(
                                Validation.getString(sc.nextLine()));

                        // Input Reviewer
                        System.out.print(Message.INPUT_REVIEWER);
                        dto.setReviewer(
                                Validation.getString(sc.nextLine()));

                        controller.addTask(dto);
                        System.out.println(Message.SUCCESS_ADD);
                        break;

                    case 2:
                        // Delete Task flow
                        System.out.print(Message.INPUT_ID);
                        id = Validation.getPositiveInt(sc.nextLine());
                        controller.deleteTask(id);
                        System.out.println(Message.SUCCESS_DELETE);
                        break;

                    case 3:
                        // Display All Tasks flow
                        controller.displayTasks();
                        break;

                    case 4:
                        // Exit the program
                        return;
                }

            } catch (Exception e) {
                // Print error message if any exception occurs
                System.out.println(e.getMessage());
            }
        }
    }
}
