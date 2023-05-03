package views;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.*;
import javafx.scene.*;

public class GGProfile {

    public static String firstName = new String();
    public static String lastName = new String();
    public static String usernameID = new String();
    public static String userPassword = new String();
    public static String userPhone = new String();
    public static String userEmail = new String();
    public static String userAddress = new String();
    public static String userCity = new String();
    public static String userZip = new String();
    public static String userCountry = new String();
    public static String userDate = new String();

    public String css = this.getClass().getResource("/media/style2.css").toExternalForm();
    private Label gamesLabel = new Label("Games");
    private Label libraryLabel = new Label("Library");
    private Label adminLabel = new Label("Add/Remove");
    private Label profileLabel = new Label("Profile");
    private Label wishlistLabel = new Label("Wishlist");
    private Label cartLabel = new Label("Cart");
    private ImageView searchImage = new ImageView(new Image(getClass().getResourceAsStream("/media/image.png")));
    private ImageView userImage = new ImageView(new Image(getClass().getResourceAsStream("/media/User1.png")));

    private GridPane gridPaneNav = new GridPane();
    private TextField searchField = new TextField();

    public TextField saveButton = new TextField("Save");
    public TextField signOut = new TextField("Sign Out");

    public TextField fNameField = new TextField("");
    public TextField lNameField = new TextField("");
    public TextField userNameField = new TextField("");
    public TextField eMailField = new TextField("");
    public PasswordField passwordTextField = new PasswordField();
    public TextField cityField = new TextField("");
    public TextField countryField = new TextField("");
    public TextField zipField = new TextField("");
    public TextField addressField = new TextField("");
    public TextField phoneField = new TextField("");

    private Label fNameLabel = new Label();
    private Label lNameLabel = new Label();
    private Label emailLabel = new Label();
    private Label cityLabel = new Label();
    private Label countryLabel = new Label();
    private Label zipLabel = new Label();
    private Label addressLabel = new Label();
    private Label phoneLabel = new Label();

    private String error = new String("-fx-border-color: red; -fx-border-width: 1px;");

    public GGProfile(Stage _stage) {
        VBox vbox = new VBox();
        vbox.setMaxWidth(Double.MAX_VALUE);
        ScrollPane root = new ScrollPane(vbox);
        root.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        root.setFitToWidth(true);

        Text fName = new Text("First Name");
        Text lName = new Text("Last Name");
        Text username = new Text("Username");
        Text email = new Text("E-mail");
        Text password = new Text("Password");
        Text city = new Text("City");
        Text country = new Text("Country");
        Text zip = new Text("ZIP");
        Text address = new Text("Address");
        Text phone = new Text("Phone");

        fName.getStyleClass().add("lables");
        lName.getStyleClass().add("lables");
        username.getStyleClass().add("lables");
        email.getStyleClass().add("lables");
        password.getStyleClass().add("lables");
        city.getStyleClass().add("lables");
        country.getStyleClass().add("lables");
        zip.getStyleClass().add("lables");
        address.getStyleClass().add("lables");
        phone.getStyleClass().add("lables");
        GridPane editSaveGrid = new GridPane();

        searchField.getStyleClass().add("text-field");
        searchField.setPrefHeight(12);
        searchField.setPrefWidth(200);
        searchField.setPromptText("Search");
        searchField.setOnMouseClicked(e -> {
            if (searchField.getText().equals(searchField.getPromptText())) {
                searchField.setText("");
            }
        });

        searchImage.setFitWidth(34);
        searchImage.setFitHeight(33);
        ImageView lineImage = new ImageView(new Image(getClass().getResourceAsStream("/media/line.png")));
        lineImage.setFitWidth(2);
        lineImage.setFitHeight(60);
        userImage.setFitWidth(55);
        userImage.setFitHeight(40);

        userImage.setOnMouseEntered(event -> {

            userImage.setImage(new Image(getClass().getResourceAsStream("/media/User2.png")));
        });

        userImage.setOnMouseExited(event -> {
            userImage.setImage(new Image(getClass().getResourceAsStream("/media/User1.png")));
        });

        fNameField.setText(firstName);
        fNameField.setEditable(false);
        fNameField.getStyleClass().add("text-field");
        fNameField.setPrefHeight(40);
        fNameField.setPrefWidth(300);
        fNameField.setBorder(new Border(
                new BorderStroke(Color.valueOf("#000000"), BorderStrokeStyle.SOLID, null, new BorderWidths(1))));

        lNameField.setEditable(false);
        lNameField.setText(lastName);
        lNameField.getStyleClass().add("text-field");
        lNameField.setPrefHeight(40);
        lNameField.setPrefWidth(300);
        lNameField.setBorder(new Border(
                new BorderStroke(Color.valueOf("#000000"), BorderStrokeStyle.SOLID, null, new BorderWidths(1))));

        userNameField.setText(usernameID);
        userNameField.setEditable(false);
        userNameField.getStyleClass().add("text-field");
        userNameField.setPrefHeight(40);
        userNameField.setPrefWidth(620);
        userNameField.setBorder(new Border(
                new BorderStroke(Color.valueOf("#000000"), BorderStrokeStyle.SOLID, null, new BorderWidths(1))));

        eMailField.setEditable(false);
        eMailField.setText(userEmail);
        eMailField.getStyleClass().add("text-field");
        eMailField.setPrefHeight(40);
        eMailField.setPrefWidth(620);
        eMailField.setBorder(new Border(
                new BorderStroke(Color.valueOf("#000000"), BorderStrokeStyle.SOLID, null, new BorderWidths(1))));

        passwordTextField.setText(userPassword);
        passwordTextField.setEditable(false);
        passwordTextField.getStyleClass().add("text-field");
        passwordTextField.setPrefHeight(40);
        passwordTextField.setPrefWidth(620);
        passwordTextField.setBorder(new Border(
                new BorderStroke(Color.valueOf("#000000"), BorderStrokeStyle.SOLID, null, new BorderWidths(1))));

        cityField.setEditable(false);
        cityField.setText(userCity);
        cityField.getStyleClass().add("text-field");
        cityField.setPrefHeight(40);
        cityField.setPrefWidth(300);
        cityField.setBorder(new Border(
                new BorderStroke(Color.valueOf("#000000"), BorderStrokeStyle.SOLID, null, new BorderWidths(1))));

        countryField.setEditable(false);
        countryField.setText(userCountry);
        countryField.getStyleClass().add("text-field");
        countryField.setPrefHeight(40);
        countryField.setPrefWidth(300);
        countryField.setBorder(new Border(
                new BorderStroke(Color.valueOf("#000000"), BorderStrokeStyle.SOLID, null, new BorderWidths(1))));

        zipField.setEditable(false);
        zipField.setText(userZip);
        zipField.getStyleClass().add("text-field");
        zipField.setPrefHeight(40);
        zipField.setPrefWidth(300);
        zipField.setBorder(new Border(
                new BorderStroke(Color.valueOf("#000000"), BorderStrokeStyle.SOLID, null, new BorderWidths(1))));

        addressField.setEditable(false);
        addressField.setText(userAddress);
        addressField.getStyleClass().add("text-field");
        addressField.setPrefHeight(40);
        addressField.setPrefWidth(300);
        addressField.setBorder(new Border(
                new BorderStroke(Color.valueOf("#000000"), BorderStrokeStyle.SOLID, null, new BorderWidths(1))));

        phoneField.setEditable(false);
        phoneField.setText(userPhone);
        phoneField.getStyleClass().add("text-field");
        phoneField.setPrefHeight(40);
        phoneField.setPrefWidth(300);
        phoneField.setBorder(new Border(
                new BorderStroke(Color.valueOf("#000000"), BorderStrokeStyle.SOLID, null, new BorderWidths(1))));

        saveButton.getStyleClass().add("buttons-game");
        saveButton.setAlignment(Pos.CENTER);
        saveButton.setEditable(false);
        saveButton.setVisible(false);

        TextField editButton = new TextField("Edit");
        editButton.getStyleClass().add("buttons-game");
        editButton.setAlignment(Pos.CENTER);
        editButton.setEditable(false);

        editButton.setOnMouseClicked(e -> {

            if (!saveButton.isVisible()) {
                saveButton.setVisible(true);
            }
            phoneField.setEditable(true);
            addressField.setEditable(true);
            zipField.setEditable(true);
            countryField.setEditable(true);
            cityField.setEditable(true);
            eMailField.setEditable(true);
            lNameField.setEditable(true);
            fNameField.setEditable(true);

        });

        signOut.getStyleClass().add("sign-out-field");
        signOut.setAlignment(Pos.CENTER);
        signOut.setEditable(false);

        gridPaneNav.setPadding(new Insets(20, 0, 20, 60));
        gridPaneNav.setHgap(10);

        gridPaneNav.getStyleClass().addAll("text");
        gamesLabel.getStyleClass().add("label1");
        libraryLabel.getStyleClass().add("label1");
        profileLabel.getStyleClass().add("label1");
        wishlistLabel.getStyleClass().add("label1");
        cartLabel.getStyleClass().add("label1");

        gridPaneNav.add(gamesLabel, 0, 0);
        gridPaneNav.add(libraryLabel, 1, 0);
        gridPaneNav.add(profileLabel, 2, 0);
        gridPaneNav.add(searchField, 3, 0);
        gridPaneNav.add(searchImage, 4, 0);
        gridPaneNav.add(wishlistLabel, 5, 0);
        gridPaneNav.add(cartLabel, 6, 0);
        gridPaneNav.add(lineImage, 7, 0);
        gridPaneNav.add(userImage, 8, 0);

        GridPane.setMargin(gamesLabel, new Insets(0, 0, 0, 0));
        GridPane.setMargin(libraryLabel, new Insets(0, 0, 0, 20));
        GridPane.setMargin(profileLabel, new Insets(0, 0, 0, 20));
        GridPane.setMargin(searchField, new Insets(0, 0, 0, 410));
        GridPane.setMargin(searchImage, new Insets(1, 0, 0, -10));
        GridPane.setMargin(wishlistLabel, new Insets(0, 0, 0, 40));
        GridPane.setMargin(cartLabel, new Insets(0, 0, 0, 40));
        GridPane.setMargin(lineImage, new Insets(0, 0, 0, 40));
        GridPane.setMargin(userImage, new Insets(0, 0, 0, 35));

        GridPane.setVgrow(gamesLabel, Priority.ALWAYS);
        GridPane.setVgrow(libraryLabel, Priority.ALWAYS);
        GridPane.setVgrow(profileLabel, Priority.ALWAYS);
        GridPane.setVgrow(searchField, Priority.ALWAYS);
        GridPane.setVgrow(wishlistLabel, Priority.ALWAYS);
        GridPane.setVgrow(cartLabel, Priority.ALWAYS);
        GridPane.setVgrow(lineImage, Priority.ALWAYS);
        GridPane.setVgrow(userImage, Priority.ALWAYS);


         /********************************************
         * Start of error messages
         *****************************************/

         fNameLabel.setStyle("-fx-text-fill: red; -fx-font-size:14px; -fx-padding:0,0,0,0;");
         fNameLabel.setVisible(false);

         lNameLabel.setStyle("-fx-text-fill: red; -fx-font-size:14px; -fx-padding:0,0,0,0;");
         lNameLabel.setVisible(false);
        
         emailLabel.setStyle("-fx-text-fill: red; -fx-font-size:14px; -fx-padding:0,0,0,0;");
         emailLabel.setVisible(false);
 
         cityLabel.setStyle("-fx-text-fill: red; -fx-font-size:14px; -fx-padding:0,0,0,0;");
         cityLabel.setVisible(false);

         countryLabel.setStyle("-fx-text-fill: red; -fx-font-size:14px; -fx-padding:0,0,0,0;");
         countryLabel.setVisible(false);
         
         
         zipLabel.setStyle("-fx-text-fill: red; -fx-font-size:14px; -fx-padding:0,0,0,0;");
         zipLabel.setVisible(false);
         

         addressLabel.setStyle("-fx-text-fill: red; -fx-font-size:14px; -fx-padding:0,0,0,0;");
         addressLabel.setVisible(false);
         
         phoneLabel.setStyle("-fx-text-fill: red; -fx-font-size:14px; -fx-padding:0,0,0,0;");
         phoneLabel.setVisible(false);
         
 
         /*******************************************
          * End of error messages ****************************************
          */


        HBox hBox = new HBox();

        GridPane gridNames = new GridPane();
        gridNames.add(fName, 0, 0);
        gridNames.add(lName, 1, 0);
        gridNames.add(fNameField, 0, 1);
        gridNames.add(lNameField, 1, 1);
        gridNames.add(fNameLabel, 0, 2);
        gridNames.add(lNameLabel, 1, 2);



        GridPane gridUser = new GridPane();
        gridUser.add(username, 0, 0);
        gridUser.add(userNameField, 0, 1);
        
        GridPane gridEmail = new GridPane();
        gridEmail.add(email, 0, 0);
        gridEmail.add(eMailField, 0, 1);
        gridEmail.add(emailLabel, 0, 2);

        GridPane gridPassword = new GridPane();
        gridPassword.add(password, 0, 0);
        gridPassword.add(passwordTextField, 0, 1);

        GridPane gridInfo1 = new GridPane();
        gridInfo1.add(gridNames, 0, 0);
        gridInfo1.add(gridUser, 0, 1);
        gridInfo1.add(gridEmail, 0, 2);
        gridInfo1.add(gridPassword, 0, 3);


        GridPane.setMargin(lName, new Insets(0, 0, 0, 20));
        GridPane.setMargin(lNameField, new Insets(0, 0, 0, 20));
        GridPane.setMargin(lNameLabel, new Insets(0, 0, 0, 20));

        GridPane.setMargin(gridNames, new Insets(15, 0, 10, 40));
        GridPane.setMargin(gridUser, new Insets(15, 0, 10, 40));
        GridPane.setMargin(gridEmail, new Insets(15, 0, 10, 40));
        GridPane.setMargin(gridPassword, new Insets(15, 0, 10, 40));

       

        GridPane gridInfo2 = new GridPane();
        gridInfo2.add(city, 0, 0);
        gridInfo2.add(cityField, 0, 1);
        gridInfo2.add(cityLabel, 0, 2);

        gridInfo2.add(country, 1, 0);
        gridInfo2.add(countryField, 1, 1);
        gridInfo2.add(countryLabel, 1, 2);



        gridInfo2.add(zip, 0,3);
        gridInfo2.add(zipField, 0, 4);
        gridInfo2.add(zipLabel, 0, 5);

        gridInfo2.add(address, 1, 3);
        gridInfo2.add(addressField, 1, 4);
        gridInfo2.add(addressLabel, 1, 5); 


        gridInfo2.add(phone, 0, 6);
        gridInfo2.add(phoneField, 0, 7);
        gridInfo2.add(phoneLabel, 0, 8);

        

        GridPane.setMargin(city, new Insets(15, 50, 0, 150));
        GridPane.setMargin(cityField, new Insets(0, 50, 0, 150));
        GridPane.setMargin(cityLabel, new Insets(0, 50, 0, 150));

        GridPane.setMargin(country, new Insets(15, 50, 0, 40));
        GridPane.setMargin(countryField, new Insets(0, 50, 0, 40));
        GridPane.setMargin(countryLabel, new Insets(0, 50, 0, 40));

        GridPane.setMargin(zip, new Insets(15, 50, 0, 150));
        GridPane.setMargin(zipField, new Insets(0, 50, 0, 150));
        GridPane.setMargin(zipLabel, new Insets(0, 50, 0, 150));

        GridPane.setMargin(address, new Insets(15, 50, 0, 40));
        GridPane.setMargin(addressField, new Insets(0, 50, 0, 40));
        GridPane.setMargin(addressLabel, new Insets(0, 50, 0, 40));

        GridPane.setMargin(phone, new Insets(15, 50, 0, 150));
        GridPane.setMargin(phoneField, new Insets(0, 50, 0, 150));
        GridPane.setMargin(phoneLabel, new Insets(0, 50, 0, 150));

        editSaveGrid.add(editButton, 0, 0);
        editSaveGrid.add(saveButton, 1, 0);

        GridPane.setMargin(editButton, new Insets(100, 0, 0, 0));
        GridPane.setMargin(saveButton, new Insets(100, 0, 0, 00));
        editSaveGrid.setAlignment(Pos.CENTER);
        editSaveGrid.setHgap(20);

        GridPane signOutGrid = new GridPane();
        signOutGrid.add(signOut, 0, 0);
        GridPane.setMargin(signOut, new Insets(20, 0, 40, 0));
        signOut.setPrefWidth(400);
        signOutGrid.setAlignment(Pos.CENTER);

        hBox.getChildren().addAll(gridInfo1, gridInfo2);
        vbox.getChildren().addAll(gridPaneNav, hBox, editSaveGrid, signOutGrid);
        Scene scene = new Scene(root, 1300, 650);
        scene.getStylesheets().add(css);
        _stage.setTitle("Gamer Grills");
        _stage.setResizable(false);
        _stage.setScene(scene);
        _stage.show();
    }

    public void addGamesHandler(EventHandler<MouseEvent> event) {
        gamesLabel.setOnMouseClicked(event);
    }

    public void addLibraryHandler(EventHandler<MouseEvent> event) {
        libraryLabel.setOnMouseClicked(event);
    }

    public void addAdminHandler(EventHandler<MouseEvent> event) {
        adminLabel.setOnMouseClicked(event);
    }

    public void addSearchHandler(EventHandler<MouseEvent> event) {
        searchImage.setOnMouseClicked(event);
    }

    public void addWishlistHandler(EventHandler<MouseEvent> event) {
        wishlistLabel.setOnMouseClicked(event);
    }

    public void addCartHandler(EventHandler<MouseEvent> event) {
        cartLabel.setOnMouseClicked(event);
    }

    public void addGGIconHandler(EventHandler<MouseEvent> event) {
        userImage.setOnMouseClicked(event);
    }

    public void pressedSave(EventHandler<MouseEvent> event) {
        saveButton.setOnMouseClicked(event);
    }

    public void signOutPressed(EventHandler<MouseEvent> event) {
        signOut.setOnMouseClicked(event);
    }

    public void createLabel() {
        GridPane.setMargin(adminLabel, new Insets(0, 0, 0, 40));
        adminLabel.getStyleClass().add("label1");
        gridPaneNav.add(adminLabel, 3, 0);
    }

    public String getName() {
        return searchField.getText();
    }

    public void saveButtonValidation() {
        if (fNameField.getText().isEmpty()) {
            fNameLabel.setText("This field can't be empty.");
            fNameField.setStyle(error);
            fNameLabel.setVisible(true);
        } else if (fNameField.getText().length() > 20) {
            fNameLabel.setText("First name can be 20 characters long.");
            fNameField.setStyle(error);
            fNameLabel.setVisible(true);
        } else if (!fNameField.getText().matches("^[a-zA-Z]+$")) {
            fNameLabel.setText("Can only contain letters.");
            fNameField.setStyle(error);
            fNameLabel.setVisible(true);
        } else {
            fNameLabel.setVisible(false);
            fNameField.setStyle("");
        }

        if (lNameField.getText().isEmpty()) {
            lNameLabel.setText("This field can't be empty.");
            lNameLabel.setVisible(true);
            lNameField.setStyle(error);
        } else if (lNameField.getText().length() > 20) {
            lNameLabel.setText("Last name can be 20 characters long.");
            lNameLabel.setVisible(true);
            lNameField.setStyle(error);
        } else if (!lNameField.getText().matches("^[a-zA-Z]+$")) {
            lNameLabel.setText("Can only contain letters.");
            lNameField.setStyle(error);
            lNameLabel.setVisible(true);
        } else {
            lNameLabel.setVisible(false);
            lNameField.setStyle("");
        }

        if (eMailField.getText().isEmpty()) {
            emailLabel.setText("This field can't be empty.");
            emailLabel.setVisible(true);
            eMailField.setStyle(error);
        } else if (!eMailField.getText().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            emailLabel.setText("Invalid email format.");
            emailLabel.setVisible(true);
            eMailField.setStyle(error);
        } else if (eMailField.getText().length() < 8 || eMailField.getText().length() > 30) {
            emailLabel.setText("Email must be from 8 to 30 characters long.");
            emailLabel.setVisible(true);
            eMailField.setStyle(error);
        } else {
            emailLabel.setVisible(false);
            eMailField.setStyle("");
        }

        if (phoneField.getText() != null && !phoneField.getText().isEmpty()) {
            if (!phoneField.getText().matches("^\\+[0-9 ]+$")) {
                phoneLabel.setText("Invalid format. Phone number must start with +.");
                phoneLabel.setVisible(true);
                phoneField.setStyle(error);
            } else if (phoneField.getText().length() > 20) {
                phoneLabel.setText("Phone can be 20 characters long");
                phoneLabel.setVisible(true);
                phoneField.setStyle(error);
            } else {
                phoneLabel.setVisible(false);
                phoneField.setStyle("");
            }
        } else {
            phoneLabel.setVisible(false);
            phoneField.setStyle("");
        }

        if (cityField.getText() != null && !cityField.getText().isEmpty()) {
            if (cityField.getText().length() > 30) {
                cityLabel.setText("City can be maximum 30 characters long.");
                cityField.setStyle(error);
                cityLabel.setVisible(true);
            } else if (!cityField.getText().matches("^[a-zA-Z]+$")) {
                cityLabel.setText("City can only contain letters.");
                cityField.setStyle(error);
                cityLabel.setVisible(true);
            } else {
                cityLabel.setVisible(false);
                cityField.setStyle("");
            }
        } else {
            cityLabel.setVisible(false);
            cityField.setStyle("");
        }

        if (countryField.getText() != null && !countryField.getText().isEmpty()) {
            if (countryField.getText().length() > 30) {
                countryLabel.setText("Country can be maximum 30 characters long.");
                countryLabel.setVisible(true);
                cityField.setStyle(error);
            } else if (!countryField.getText().matches("^[a-zA-Z]+$")) {
                countryLabel.setText("Country can only contain letters.");
                countryLabel.setVisible(true);
                countryField.setStyle(error);
            } else {
                countryLabel.setVisible(false);
                countryField.setStyle("");
            }
        } else {
            countryLabel.setVisible(false);
            countryField.setStyle("");
        }

        if (zipField.getText() != null && !zipField.getText().isEmpty()) {
            if (zipField.getText().length() != 5 && zipField.getText().length() != 0) {
                zipLabel.setText("ZIP can be either 0 or 5 characters long.");
                zipLabel.setVisible(true);
                zipField.setStyle(error);
            } else if (!zipField.getText().matches("^[a-zA-Z0-9]+$")) {
                zipLabel.setText("ZIP can only contain letters and numbers.");
                zipLabel.setVisible(true);
                zipField.setStyle(error);
            } else {
                zipLabel.setVisible(false);
                zipField.setStyle("");
            }
        } else {
            zipLabel.setVisible(false);
            zipField.setStyle("");
        }

        if (addressField.getText() != null && !addressField.getText().isEmpty()) {
            if (addressField.getText().length() > 50) {
                addressLabel.setText("Address can be a maximum of 50 characters long.");
                addressLabel.setVisible(true);
                addressField.setStyle(error);
            } else if (!addressField.getText().matches("^[a-zA-Z0-9 ]+$")) {
                addressLabel.setText("Address can only contain letters and numbers.");
                addressLabel.setVisible(true);
                addressField.setStyle(error);
            } else {
                addressLabel.setVisible(false);
                addressField.setStyle("");
            }
        } else {
            addressLabel.setVisible(false);
            addressField.setStyle("");
        }
    }

    public void successfulInput() {
        fNameLabel.setVisible(false);
        lNameLabel.setVisible(false);
        emailLabel.setVisible(false);
        cityLabel.setVisible(false);
        countryLabel.setVisible(false);
        zipLabel.setVisible(false);
        addressLabel.setVisible(false);
        phoneLabel.setVisible(false);

        fNameField.setStyle("");
        lNameField.setStyle("");
        eMailField.setStyle("");
        cityField.setStyle("");
        countryField.setStyle("");
        zipField.setStyle("");
        addressField.setStyle("");
        phoneField.setStyle("");
    }

}
