package views;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.*;

public class ToS {

    private static final String FILE_NAME = "termsOfService.txt";
    private static Stage stage = new Stage();

    private TextArea textArea;
    private TextField acceptButtonClicked;

    public void display() throws Exception {
        Class<?> clazz = ToS.class; // get the Class object of the current class
        String css = clazz.getResource("/media/style.css").toExternalForm(); // load the CSS file

        stage.initModality(Modality.APPLICATION_MODAL);
        textArea = new TextArea();
        textArea.setEditable(false);
        textArea.setWrapText(true);
        textArea.setPrefRowCount(10);
        textArea.setPrefColumnCount(200);

        textArea.setPrefHeight(500);

        String fileContent = readFile(FILE_NAME);
        textArea.setText(fileContent);
        textArea.setOnScroll((event) -> {
            double visibleHeight = textArea.getHeight();
            double totalHeight = textArea.getMaxHeight();
            double scrollTop = textArea.getScrollTop();
            if (totalHeight - visibleHeight - scrollTop <= 1) {
                acceptButtonClicked.setDisable(false);
            }
        });

        acceptButtonClicked = new TextField("Accept");
        acceptButtonClicked.getStyleClass().add("sign-in-text-field2");
        acceptButtonClicked.setAlignment(Pos.CENTER);
        acceptButtonClicked.setEditable(false);
        acceptButtonClicked.setDisable(true);
        acceptButtonClicked.setOnMouseClicked(event -> {
            stage.close();
        });

        VBox root = new VBox();
        root.setPadding(new Insets(10));
        root.getChildren().addAll(textArea, acceptButtonClicked);

        Scene scene = new Scene(root, 400, 500);
        scene.getStylesheets().add(css); // add the CSS file
        stage.setTitle("File TextArea Example");
        stage.setScene(scene);
        stage.showAndWait();
    }

    public void closeWindow(EventHandler<MouseEvent> event) {
        if (acceptButtonClicked != null) {
            acceptButtonClicked.setOnMouseClicked(event);
        }
    }

    private static String readFile(String filePath) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(new File(filePath)))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append('\n');
            }
        }
        return sb.toString();
    }

}