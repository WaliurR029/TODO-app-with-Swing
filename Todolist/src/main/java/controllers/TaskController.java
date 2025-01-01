package controllers;

import dao.TaskDAO;
import models.Task;
import views.TaskView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TaskController {
    private TaskView view;
    private TaskDAO dao;

    public TaskController(TaskView view, TaskDAO dao) {
        this.view = view;
        this.dao = dao;
        initialize();
    }

    private void initialize() {
        loadTasks();

        view.addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = JOptionPane.showInputDialog("Enter task title:");
                String description = JOptionPane.showInputDialog("Enter task description:");
                dao.addTask(new Task(0, title, description, "Pending"));
                loadTasks();
            }
        });

        view.deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = view.table.getSelectedRow();
                if (selectedRow != -1) {
                    int taskId = (int) view.table.getValueAt(selectedRow, 0);
                    dao.deleteTask(taskId);
                    loadTasks();
                } else {
                    JOptionPane.showMessageDialog(view.frame, "Please select a task to delete.");
                }
            }
        });

        view.updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = view.table.getSelectedRow();
                if (selectedRow != -1) {
                    int taskId = (int) view.table.getValueAt(selectedRow, 0);
                    String title = JOptionPane.showInputDialog("Enter new task title:");
                    String description = JOptionPane.showInputDialog("Enter new task description:");
                    String status = JOptionPane.showInputDialog("Enter new task status:");
                    dao.updateTask(new Task(taskId, title, description, status));
                    loadTasks();
                } else {
                    JOptionPane.showMessageDialog(view.frame, "Please select a task to update.");
                }
            }
        });
    }

    private void loadTasks() {
        List<Task> tasks = dao.getAllTasks();
        String[] columns = {"ID", "Title", "Description", "Status"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        for (Task task : tasks) {
            model.addRow(new Object[]{task.getId(), task.getTitle(), task.getDescription(), task.getStatus()});
        }

        view.table.setModel(model);
    }
}