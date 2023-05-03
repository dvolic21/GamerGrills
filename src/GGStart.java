import controller.GGController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.GGDatabase;

public class GGStart extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage _stage){
        new GGController(new GGDatabase(), _stage);
    }
}
