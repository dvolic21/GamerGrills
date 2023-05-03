package views;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PrivacyPolicy extends Application {

    private static final String FILE_NAME = "privacy.txt";

    @Override
    public void start(Stage primaryStage) throws Exception {

        TextArea textArea = new TextArea();
        textArea.setEditable(false);
        textArea.setWrapText(true);
        textArea.setPrefRowCount(10);
        textArea.setPrefColumnCount(200);

        textArea.setPrefHeight(500);

        String fileContent = readFile(FILE_NAME);
        textArea.setText(fileContent);

        VBox root = new VBox();
        root.setPadding(new Insets(10));
        root.getChildren().add(textArea);

        Scene scene = new Scene(root, 400, 500);

        primaryStage.setTitle("File TextArea Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private String readFile(String filePath) throws IOException {
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