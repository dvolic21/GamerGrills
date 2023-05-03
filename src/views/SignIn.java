package views;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.*;
import org.w3c.dom.NodeList;
import util.DLException;
import org.w3c.dom.Node;  
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SignIn {

    private String css = this.getClass().getResource("/media/style.css").toExternalForm();
    private TextField signInTextField = new TextField("Sign In");
    private Text signUpLink = new Text("Sign up");
    private Text privacy = new Text("Privacy Policy");

    private TextField userID = new TextField();
    private PasswordField passwordTextField = new PasswordField();
    private CheckBox rememberMeCheckBox = new CheckBox();

    public Label userIDLabel = new Label();
    public Label userPasswordLabel = new Label();
    public Label userPasswordCharactersLabel = new Label();
    public Label userIDCharacterLabel = new Label();

    private String error = new String("-fx-border-color: red; -fx-border-width: 1px;");

    Scene scene = null;

    public SignIn(Stage _stage) {

        Pane root = new Pane();

        VBox vbox = new VBox();
        vbox.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(30), Insets.EMPTY)));
        vbox.setPadding(new Insets(20));
        vbox.setSpacing(10);
        vbox.setAlignment(Pos.CENTER);

        Text text = new Text("GG");
        text.getStyleClass().add("text");

        VBox.setMargin(text, new Insets(20, 0, 0, 0));
        VBox.setVgrow(text, Priority.ALWAYS);
        vbox.setAlignment(Pos.TOP_CENTER);

        double width = 0.3 * 1300;
        double height = 0.75 * 650;
        vbox.setPrefSize(width, height);
        vbox.setTranslateX((1300 - width) / 2);
        vbox.setTranslateY((570 - height) / 2);

        Text signIn = new Text("Sign in with GG account");
        signIn.getStyleClass().add("sign-in");
        VBox.setMargin(signIn, new Insets(20, 0, 0, 0));

        userID = new TextField();
        userID.getStyleClass().add("text-field");
        userID.setPrefHeight(50);
        userID.setPrefWidth(50);
        userID.setBorder(new Border(
                new BorderStroke(Color.valueOf("#000000"), BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
        userID.setPromptText("Email Address or Username");
        userID.setOnMouseClicked(e -> {
            if (userID.getText().equals(userID.getPromptText())) {
                userID.setText("");
            }
        });

        userIDLabel.setStyle("-fx-text-fill: red; -fx-font-size:14px; -fx-padding:0,0,0,0;");
        VBox.setMargin(userIDLabel, new Insets(-14, 0, 0, -140));
        userIDLabel.setVisible(false);

        userIDCharacterLabel.setStyle("-fx-text-fill: red; -fx-font-size:14px; -fx-padding:0,0,0,0;");
        VBox.setMargin(userIDCharacterLabel, new Insets(-34, 0, 0, -73));
        userIDCharacterLabel.setVisible(false);

        userPasswordLabel.setStyle("-fx-text-fill: red; -fx-font-size:14px; -fx-padding:0,0,0,0;");
        VBox.setMargin(userPasswordLabel, new Insets(-14, 0, 0, -140));
        userPasswordLabel.setVisible(false);

        userPasswordCharactersLabel.setStyle("-fx-text-fill: red; -fx-font-size:14px; -fx-padding:0,0,0,0;");
        VBox.setMargin(userPasswordCharactersLabel, new Insets(-34, 0, 0, -26.6));
        userPasswordCharactersLabel.setVisible(false);


        passwordTextField.getStyleClass().add("text-field");
        passwordTextField.setPrefHeight(50);
        passwordTextField.setPrefWidth(50);
        passwordTextField.setBorder(new Border(
                new BorderStroke(Color.valueOf("#000000"), BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
        passwordTextField.setPromptText("Password"); 
        passwordTextField.setOnMouseClicked(e -> {
            if (passwordTextField.getText().equals(passwordTextField.getPromptText())) {
                passwordTextField.setText("");
            }
        });

        VBox formBox = new VBox();
        formBox.setSpacing(13);
        formBox.setAlignment(Pos.CENTER);
        formBox.getChildren().addAll(userID, userIDLabel, userIDCharacterLabel, passwordTextField, userPasswordLabel,
                userPasswordCharactersLabel);
        formBox.setPadding(new Insets(30, 30, 0, 30));

        rememberMeCheckBox.setStyle(
                "-fx-font-size: 12px; -fx-scale-x: 0.8; -fx-scale-y: 0.8; -fx-border-color: #000000;-fx-border-width: 1px; -fx-background-color: transparent; -fx-padding: 0;");
        Label rememberMeLabel = new Label("Remember Me");
        rememberMeLabel.setStyle("-fx-font-size: 12px;-fx-fill:#808080");

        HBox rememberMeBox = new HBox();
        rememberMeBox.setAlignment(Pos.CENTER_LEFT);
        rememberMeBox.setSpacing(20);
        rememberMeBox.getChildren().addAll(rememberMeCheckBox, rememberMeLabel);
        VBox.setMargin(rememberMeBox, new Insets(-10, 0, 0, 29));

        signInTextField.getStyleClass().add("sign-in-text-field");
        signInTextField.setAlignment(Pos.CENTER);
        signInTextField.setEditable(false);

        VBox.setMargin(signInTextField, new Insets(30, 30, 0, 30));
        Text signUp = new Text("Don’t have a GG account? ");

        signUp.getStyleClass().add("sign-up");
        signUpLink.getStyleClass().add("signUp-red");
        HBox signUpBox = new HBox();

        signUpBox.getChildren().addAll(signUp, signUpLink);

        signUpBox.setAlignment(Pos.CENTER);
        VBox.setMargin(signUpBox, new Insets(5, 0, 0, 0));

        privacy.getStyleClass().add("privacy");

        VBox.setMargin(privacy, new Insets(22.5, 0, 0, 0));

        vbox.getChildren().addAll(text, signIn, formBox, rememberMeBox, signInTextField, signUpBox, privacy);
        root.getChildren().add(vbox);
        scene = new Scene(root, 1300, 650);
        scene.getStylesheets().add(css);
        _stage.setTitle("Gamer Grills");
        _stage.setResizable(false);
        _stage.setScene(scene);
        _stage.show();
    }

    public String getUserID() {
        return userID.getText().trim();
    }

    public String getPassword() {
        return passwordTextField.getText();
    }

    public void addSignInHandler(EventHandler<MouseEvent> evt) {
        signInTextField.setOnMouseClicked(evt);
    }

    public void addSignUpHandler(EventHandler<MouseEvent> evt) {
        signUpLink.setOnMouseClicked(evt);
    }

    public void addPrivacyHandler(EventHandler<MouseEvent> evt) {
        privacy.setOnMouseClicked(evt);
    }

    public void signInButtonClicked(MouseEvent event) {
        if (userID.getText().isEmpty()) {
            userIDLabel.setText("This field can't be empty.");
            userID.setStyle(error);
            userIDCharacterLabel.setVisible(false);
            userIDLabel.setVisible(true);
        } else if (!userID.getText().matches("^[a-zA-Z0-9.@]+$")) {
            VBox.setMargin(userIDCharacterLabel, new Insets(-34, 0, 0, -63));
            userIDLabel.setVisible(false);
            userIDCharacterLabel.setText("Only letters, dots and @ are allowed.");
            userID.setStyle(error);
            userIDCharacterLabel.setVisible(true);
        } else if (userID.getText().length() < 4 || userID.getText().length() > 30) {
            VBox.setMargin(userIDCharacterLabel, new Insets(-34, 0, 0, -22));
            userIDLabel.setVisible(false);
            userIDCharacterLabel.setText("Username must contain 4-30 characters only.");
            userID.setStyle(error);
            userIDCharacterLabel.setVisible(true);
        } else {
            userIDLabel.setVisible(false);
            userIDCharacterLabel.setVisible(false);
            userID.setStyle("");
        }

        if (passwordTextField.getText().isEmpty()) {
            userPasswordLabel.setText("This field can't be empty.");
            passwordTextField.setStyle(error);
            userPasswordCharactersLabel.setVisible(false);
            userPasswordLabel.setVisible(true);
        } else if (passwordTextField.getText().length() < 6 || passwordTextField.getText().length() > 14) {
            userPasswordLabel.setVisible(false);
            userPasswordCharactersLabel.setText("Password must contain 6-14 characters only.");
            passwordTextField.setStyle(error);
            userPasswordCharactersLabel.setVisible(true);
        } else {
            passwordTextField.setStyle("");
            userPasswordLabel.setVisible(false);
            userPasswordCharactersLabel.setVisible(false);
        }
    }

    public void userNotRegistered(MouseEvent event) {
        userPasswordCharactersLabel.setVisible(false);
        userPasswordLabel.setVisible(false);
        userIDLabel.setVisible(false);
        passwordTextField.setStyle("");
        userID.setStyle("");
    }

    public boolean rememberUser(){
        return this.rememberMeCheckBox.isSelected();
    }

    /**
     * Gotten this code from: https://www.tutorialspoint.com/java_xml/java_dom_create_document.htm
     * It has been modified to fit our program.
     */
    public void createXml() {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            Element userElement = doc.createElement("user");
            doc.appendChild(userElement);

            Element usernameXML = doc.createElement("username");
            usernameXML.appendChild(doc.createTextNode(this.getUserID()));
            userElement.appendChild(usernameXML);

            Element passwordXML = doc.createElement("password");
            passwordXML.appendChild(doc.createTextNode(this.getPassword()));
            userElement.appendChild(passwordXML);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("userinfo.xml"));
            transformer.transform(source, result);

            transformer.transform(source, result);
        } catch (Exception e) {
            new DLException(e);
        }
    }

    /**
     * Gotten this code from: https://www.javatpoint.com/how-to-read-xml-file-in-java
     * It has been modified to fit our program.
     */
    public void retrieveCredentials() {
        try {
            File file = new File("userinfo.xml");  
         
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  

            DocumentBuilder db = dbf.newDocumentBuilder();  
            Document doc = db.parse(file);  
            doc.getDocumentElement().normalize();  
            NodeList nodeList = doc.getElementsByTagName("user"); 
            for (int itr = 0; itr < nodeList.getLength(); itr++) {
                Node node = nodeList.item(itr);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    this.userID.setText(eElement.getElementsByTagName("username").item(0).getTextContent());
                    this.passwordTextField.setText(eElement.getElementsByTagName("password").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            new DLException(e);
        }
    }

}
