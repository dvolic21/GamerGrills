package views;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SignUp {

    private String css = this.getClass().getResource("/media/style.css").toExternalForm();
    private Text signUpLink = new Text("Sign In");
    private TextField signInTextField = new TextField("Sign Up");
    private Text privacy = new Text("Privacy Policy");
    private TextField firstNameTextField = new TextField();
    private TextField lastNameTextField = new TextField();
    private TextField usernameTextField = new TextField();
    private TextField emailTextField = new TextField();

    private PasswordField passwordTextField = new PasswordField();
    private PasswordField passwordTextField2 = new PasswordField();

    private String error = new String("-fx-border-color: red; -fx-border-width: 1px;");
    private Label firstNameValidation = new Label();
    private Label lastNameValidation = new Label();
    private Label usernameValidation = new Label();
    private Label emailValidation = new Label();
    private Label passwordValidation = new Label();
    private Label passwordValidation2 = new Label();
    private Label fNameValidation = new Label();
    private Label lNameValidationLabel = new Label();
    private Label usernameValidationLabel = new Label();
    private Label emailValidationLabel = new Label();
    private Label passwordValidationLabel1 = new Label();
    private Label passwordValidationLabel2 = new Label();
    public SignUp(Stage _stage) {

        
        Pane root = new Pane();

        VBox vbox = new VBox();
        vbox.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(30), Insets.EMPTY)));
        vbox.setPadding(new Insets(20));
        vbox.setSpacing(10);
        vbox.setAlignment(Pos.CENTER);

        vbox.setAlignment(Pos.TOP_CENTER);

        double width = 0.3 * 1300;
        double height = 0.5 * 650;
        vbox.setPrefSize(width, height);
        vbox.setTranslateX((1300 - width) / 2);
        vbox.setTranslateY((380 - height) / 2);

        Text signIn = new Text("Sign Up For GG account");
        signIn.getStyleClass().add("sign-in");
        VBox.setMargin(signIn, new Insets(10, 0, 0, 0));

        firstNameTextField.getStyleClass().add("text-field");
        firstNameTextField.setPrefHeight(50);
        firstNameTextField.setPrefWidth(150);
        firstNameTextField.setBorder(new Border(
                new BorderStroke(Color.valueOf("#000000"), BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
        firstNameTextField.setPromptText("First Name");

        lastNameTextField.getStyleClass().add("text-field");
        lastNameTextField.setPrefHeight(50);
        lastNameTextField.setPrefWidth(150);
        lastNameTextField.setBorder(new Border(
                new BorderStroke(Color.valueOf("#000000"), BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
        lastNameTextField.setPromptText("Last Name");

        Label firstNameLabel = new Label("Write your First Name");
        firstNameLabel.setStyle("-fx-font-size: 11.5px;-fx-fill:#000000;");
        firstNameLabel.setPadding(new Insets(3, 0, 0, 0));
        firstNameLabel.setAlignment(Pos.CENTER_LEFT);
        Label lastNameLabel = new Label("Write your Last Name");
        lastNameLabel.setStyle("-fx-font-size: 11.5px;-fx-fill:#000000;");
        lastNameLabel.setPadding(new Insets(3, 0, 0, 33));
        lastNameLabel.setAlignment(Pos.CENTER_LEFT);

        HBox nameBox = new HBox();
        nameBox.getChildren().addAll(firstNameTextField, lastNameTextField);
        nameBox.setSpacing(10);

        usernameTextField.getStyleClass().add("text-field");
        usernameTextField.setPrefHeight(50);
        usernameTextField.setPrefWidth(50);
        usernameTextField.setBorder(new Border(
                new BorderStroke(Color.valueOf("#000000"), BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
        usernameTextField.setPromptText("Username");
        usernameTextField.setOnMouseClicked(e -> {
            if (usernameTextField.getText().equals(usernameTextField.getPromptText())) {
                usernameTextField.setText("");
            }
        });

        emailTextField.getStyleClass().add("text-field");
        emailTextField.setPrefHeight(50);
        emailTextField.setPrefWidth(50);
        emailTextField.setBorder(new Border(
                new BorderStroke(Color.valueOf("#000000"), BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
        emailTextField.setPromptText("Email Address");
        emailTextField.setOnMouseClicked(e -> {
            if (emailTextField.getText().equals(emailTextField.getPromptText())) {
                emailTextField.setText("");
            }
        });

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

        passwordTextField2.getStyleClass().add("text-field");
        passwordTextField2.setPrefHeight(50);
        passwordTextField2.setPrefWidth(50);
        passwordTextField2.setBorder(new Border(
                new BorderStroke(Color.valueOf("#000000"), BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
        passwordTextField2.setPromptText("Confirm Password"); 
        passwordTextField2.setOnMouseClicked(e -> {
            if (passwordTextField2.getText().equals(passwordTextField2.getPromptText())) {
                passwordTextField2.setText("");
            }
        });

        Label emailLabel = new Label("Write your Email Address");
        emailLabel.setStyle("-fx-font-size: 11.5px;-fx-fill:#000000;");
        emailLabel.setPadding(new Insets(2, 0, 0, 0));
        emailLabel.setAlignment(Pos.CENTER_LEFT);

        Label passwordLabel = new Label("Write your Password");
        passwordLabel.setStyle("-fx-font-size: 11.5px;-fx-fill:#000000;");
        passwordLabel.setPadding(new Insets(2, 0, 0, 0));
        passwordLabel.setAlignment(Pos.CENTER_LEFT);

        Label password2Label = new Label("Confirm your Password");
        password2Label.setStyle("-fx-font-size: 11.5px;-fx-fill:#000000;");
        password2Label.setPadding(new Insets(2, 0, 0, 0));
        password2Label.setAlignment(Pos.CENTER_LEFT);

        Label usernameLabel = new Label("Write your Username");
        usernameLabel.setStyle("-fx-font-size: 11.5px;-fx-fill:#000000;");
        usernameLabel.setPadding(new Insets(2, 0, 0, 0));
        usernameLabel.setAlignment(Pos.CENTER_LEFT);

        HBox nameBoxLabels = new HBox();
        nameBoxLabels.getChildren().addAll(firstNameLabel, lastNameLabel);
        nameBoxLabels.setSpacing(10);

        /********************************************
         * Start of error messages
         *****************************************/

        HBox validationBoxName = new HBox();

        fNameValidation.setStyle("-fx-text-fill: red; -fx-font-size:14px; -fx-padding:0,0,0,0;");
        HBox.setMargin(fNameValidation, new Insets(0, 0, 0, 0));
        fNameValidation.setVisible(false);
        lNameValidationLabel.setStyle("-fx-text-fill: red; -fx-font-size:14px; -fx-padding:0,0,0,0;");
        HBox.setMargin(lNameValidationLabel, new Insets(0, 0, 0, 27));
        lNameValidationLabel.setVisible(false);
        lNameValidationLabel.setLayoutX(27);
        fNameValidation.setPrefWidth(128);
        validationBoxName.getChildren().addAll(fNameValidation, lNameValidationLabel);

        usernameValidationLabel.setStyle("-fx-text-fill: red; -fx-font-size:14px; -fx-padding:0,0,0,0;");
        VBox.setMargin(usernameValidationLabel, new Insets(0, 0, 0, 0));
        usernameValidationLabel.setVisible(false);

        emailValidationLabel.setStyle("-fx-text-fill: red; -fx-font-size:14px; -fx-padding:0,0,0,0;");
        VBox.setMargin(emailValidationLabel, new Insets(0, 0, 0, 0));
        emailValidationLabel.setVisible(false);

        passwordValidationLabel1.setStyle("-fx-text-fill: red; -fx-font-size:14px; -fx-padding:0,0,0,0;");
        VBox.setMargin(passwordValidationLabel1, new Insets(0, 0, 0, 0));
        passwordValidationLabel1.setVisible(false);

        passwordValidationLabel2.setStyle("-fx-text-fill: red; -fx-font-size:14px; -fx-padding:0,0,0,0;");
        VBox.setMargin(passwordValidationLabel2, new Insets(0, 0, 0, 0));
        passwordValidationLabel2.setVisible(false);

        /*******************************************
         * End of error messages ****************************************
         */

        VBox formBox = new VBox();
        formBox.getChildren().addAll(nameBoxLabels, nameBox, validationBoxName, usernameLabel, usernameTextField,
                usernameValidationLabel, emailLabel,
                emailTextField, emailValidationLabel, passwordLabel, passwordTextField, passwordValidationLabel1,
                password2Label,
                passwordTextField2, passwordValidationLabel2);
        formBox.setPadding(new Insets(10, 30, 0, 30));

        signInTextField.getStyleClass().add("sign-in-text-field");
        signInTextField.setAlignment(Pos.CENTER);
        signInTextField.setEditable(false);

        VBox.setMargin(signInTextField, new Insets(5, 30, 0, 30));
        Text signUp = new Text("Already have a GG account? ");

        signUp.getStyleClass().add("sign-up");
        signUpLink.getStyleClass().add("signUp-red");
        HBox signUpBox = new HBox();
        signUpBox.getChildren().addAll(signUp, signUpLink);

        signUpBox.setAlignment(Pos.CENTER);
        VBox.setMargin(signUpBox, new Insets(0, 0, 0, 0));

        privacy.getStyleClass().add("privacy");

        VBox.setMargin(privacy, new Insets(-10, 0, 0, 0));

        vbox.getChildren().addAll(signIn, formBox, signInTextField, signUpBox, privacy);
        root.getChildren().add(vbox);
        Scene scene = new Scene(root, 1300, 650);
        scene.getStylesheets().add(css);
        _stage.setTitle("Gamer Grills");
        _stage.setResizable(false);
        _stage.setScene(scene);
        _stage.show();
    }

    public String getFirstName() {
        return this.firstNameTextField.getText().trim();
    }

    public String getLastName() {
        return this.lastNameTextField.getText().trim();
    }

    public String getUsername() {
        return this.usernameTextField.getText().trim();
    }

    public String getEmail() {
        return this.emailTextField.getText().trim();
    }

    public String getPassword() {
        return this.passwordTextField.getText();
    }

    public String getConfirmPassword() {
        return this.passwordTextField2.getText();
    }

    public void addSignInHandler(EventHandler<MouseEvent> evt) {
        signUpLink.setOnMouseClicked(evt);
    }

    public void addSignUpHandler(EventHandler<MouseEvent> evt) {
        
        signInTextField.setOnMouseClicked(evt);
    }

    public void addPrivacyHandler(EventHandler<MouseEvent> evt) {
        privacy.setOnMouseClicked(evt);
    }

    public void signUpButtonClicked(MouseEvent event) {
        if (firstNameTextField.getText().isEmpty()) {
            fNameValidation.setText("Field can't be empty.");
            firstNameTextField.setStyle(error);
            fNameValidation.setVisible(true);
        } else if (firstNameTextField.getText().length() > 20) {
            fNameValidation.setText("Only 20 characters");
            firstNameTextField.setStyle(error);
            fNameValidation.setVisible(true);
        } else if (!firstNameTextField.getText().matches("^[a-zA-Z]+$")) {
            fNameValidation.setText("No Signs.");
            firstNameTextField.setStyle(error);
            fNameValidation.setVisible(true);
        } else {
            firstNameTextField.setStyle("");
            fNameValidation.setVisible(false);

        }

        if (lastNameTextField.getText().isEmpty()) {
            lNameValidationLabel.setText("Field can't be empty.");
            lastNameTextField.setStyle(error);
            lNameValidationLabel.setVisible(true);
        } else if (lastNameTextField.getText().length() > 20) {
            lNameValidationLabel.setText("Only 20 characters.");
            lastNameTextField.setStyle(error);
            lNameValidationLabel.setVisible(true);
        } else if (!lastNameTextField.getText().matches("^[a-zA-Z]+$")) {
            lNameValidationLabel.setText("No Signs.");
            lastNameTextField.setStyle(error);
            lNameValidationLabel.setVisible(true);
        } else {
            lastNameTextField.setStyle("");
            lNameValidationLabel.setVisible(false);
        }

        if (usernameTextField.getText().isEmpty()) {
            usernameValidationLabel.setText("This field can't be empty.");
            usernameTextField.setStyle(error);
            usernameValidationLabel.setVisible(true);
        } else if (usernameTextField.getText().length() < 4) {
            usernameValidationLabel.setText("The username can't be less than 4 characters.");
            usernameTextField.setStyle(error);
            usernameValidationLabel.setVisible(true);
        } else if (usernameTextField.getText().length() > 15) {
            usernameValidationLabel.setText("Can be 15 characters max.");
            usernameTextField.setStyle(error);
            usernameValidationLabel.setVisible(true);
        } else if (!usernameTextField.getText().matches("^[a-zA-Z0-9]+$")) {
            usernameValidationLabel.setText("Can only contains letters and numbers");
            usernameTextField.setStyle(error);
            usernameValidationLabel.setVisible(true);
        } else {
            usernameTextField.setStyle("");
            usernameValidationLabel.setVisible(false);
        }

        if (emailTextField.getText().isEmpty()) {
            emailValidationLabel.setText("This field can't be empty.");
            emailTextField.setStyle(error);
            emailValidationLabel.setVisible(true);
        } else if (emailTextField.getText().length() > 30 || emailTextField.getText().length() < 8) {
            emailValidationLabel.setText("The email can be 8 to 30 characters long.");
            emailTextField.setStyle(error);
            emailValidationLabel.setVisible(true);
        } else if (!emailTextField.getText().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            emailValidationLabel.setText("Invalid email format.");
            emailTextField.setStyle(error);
            emailValidationLabel.setVisible(true);
        } else {
            emailTextField.setStyle("");
            emailValidationLabel.setVisible(false);
        }

        if (passwordTextField.getText().isEmpty()) {
            passwordValidationLabel1.setText("This field can't be empty.");
            passwordTextField.setStyle(error);
            passwordValidationLabel1.setVisible(true);
        } else if (passwordTextField.getText().length() < 6) {
            passwordValidationLabel1.setText("Can't be shorter than 6 characters");
            passwordTextField.setStyle(error);
            passwordValidationLabel1.setVisible(true);
        } else if (passwordTextField.getText().length() > 16) {
            passwordValidationLabel1.setText("Can't be longer than 16 characters");
            passwordTextField.setStyle(error);
            passwordValidationLabel1.setVisible(true);
        } else {
            passwordTextField.setStyle("");
            passwordValidationLabel1.setVisible(false);
        }

        if (passwordTextField2.getText().isEmpty()) {
            passwordValidationLabel2.setText("This field can't be empty.");
            passwordTextField2.setStyle(error);
            passwordValidationLabel2.setVisible(true);
        } else if (!passwordTextField2.getText().equals(passwordTextField.getText())) {
            passwordValidationLabel2.setText("Passwords do not match.");
            passwordTextField2.setStyle(error);
            passwordValidationLabel2.setVisible(true);
        } else {
            passwordTextField2.setStyle("");
            passwordValidationLabel2.setVisible(false);
        }
        
    }

    public void userExists(MouseEvent event) {
        firstNameValidation.setVisible(false);
        lastNameValidation.setVisible(false);
        usernameValidation.setVisible(false);
        emailValidation.setVisible(false);
        passwordValidation.setVisible(false);
        passwordValidation2.setVisible(false);

        firstNameValidation.setStyle("");
        lastNameValidation.setStyle("");
        usernameValidation.setStyle("");
        emailValidation.setStyle("");
        passwordValidation.setStyle("");
        passwordValidation2.setStyle("");

    }
}
