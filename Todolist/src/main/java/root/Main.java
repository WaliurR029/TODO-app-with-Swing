package root;

import controllers.TaskController;
import dao.TaskDAO;
import views.TaskView;

public class Main {
    public static void main(String[] args) {
        TaskView view = new TaskView();
        TaskDAO dao = new TaskDAO();
        new TaskController(view, dao);
    }
}
