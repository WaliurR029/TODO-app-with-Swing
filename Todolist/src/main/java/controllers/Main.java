package controllers;

import javax.swing.UIManager;

import dao.TaskDAO;
import views.TaskView;
import utils.UIUtils;
import java.awt.Font;

public class Main {
    public static void main(String[] args) {
        // Set Nimbus Look and Feel
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.err.println("Failed to apply Nimbus Look and Feel. Using default.");
        }

        // Set Global Font
        UIUtils.setGlobalFont(new Font("Arial", Font.PLAIN, 16));

        // Launch the application
        TaskView view = new TaskView();
        TaskDAO dao = new TaskDAO();
        new TaskController(view, dao);
    }
}
