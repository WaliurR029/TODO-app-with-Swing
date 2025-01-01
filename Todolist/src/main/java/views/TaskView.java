package views;

import javax.swing.*;

public class TaskView {
    public JFrame frame;
    public JTable table;
    public JButton addButton, deleteButton, updateButton;

    public TaskView() {
        frame = new JFrame("To-Do List");
        table = new JTable();
        addButton = new JButton("Add Task");
        deleteButton = new JButton("Delete Task");
        updateButton = new JButton("Update Task");

        JPanel panel = new JPanel();
        panel.add(addButton);
        panel.add(deleteButton);
        panel.add(updateButton);

        frame.add(new JScrollPane(table), "Center");
        frame.add(panel, "South");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
