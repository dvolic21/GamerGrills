package views;

import java.util.ArrayList;
import java.util.List;

import database.Game;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class GGPaymentView {

        public String css = this.getClass().getResource("/media/style2.css").toExternalForm();
        private Label gamesLabel = new Label("Games");
        private Label libraryLabel = new Label("Library");
        private Label profileLabel = new Label("Profile");
        private Label wishlistLabel = new Label("Wishlist");
        private Label cartLabel = new Label("Cart");
        private Text cartText = new Text("Games:");
        private ImageView searchImage = new ImageView(new Image(getClass().getResourceAsStream("/media/image.png")));
        private ImageView userImage = new ImageView(new Image(getClass().getResourceAsStream("/media/User1.png")));
        private TextField buyButton = new TextField("BUY");
        private Text totalText = new Text("Total:");
        private Text totalPriceLabel = new Text("");
        private GridPane gridGame = new GridPane();
        private GridPane gridPaneNav = new GridPane();
        private List<String> gameIdList = new ArrayList<>();
        private double value = 0;

        public TextField fName;
        public TextField lName;
        public TextField creditCard;
        public TextField expDate;
        public TextField ccvNumber;

        private String error = new String("-fx-border-color: red; -fx-border-width: 1px;");

        public GGPaymentView(Stage _stage) {
                VBox vbox = new VBox();
                vbox.setMaxWidth(Double.MAX_VALUE);
                ScrollPane root = new ScrollPane(vbox);
                root.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
                root.setFitToWidth(true);
                HBox hBox = new HBox();

                totalText.getStyleClass().add("game-label");
                totalPriceLabel.getStyleClass().add("price");
                cartText.getStyleClass().add("game-label");

                TextField searchField = new TextField();
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

                buyButton.getStyleClass().add("buttons-game");
                buyButton.setAlignment(Pos.CENTER);
                buyButton.setEditable(false);
                buyButton.setOnMouseClicked(e -> {

                });

                fName = new TextField();
                fName.getStyleClass().add("text-field");
                fName.setPrefHeight(50);
                fName.setPrefWidth(200);
                fName.setBorder(new Border(
                                new BorderStroke(Color.valueOf("#000000"), BorderStrokeStyle.SOLID, null,
                                                new BorderWidths(1))));
                fName.setPromptText("First Name");
                fName.setOnMouseClicked(e -> {
                        if (fName.getText().equals(fName.getPromptText())) {
                                fName.setText("");
                        }
                });
                lName = new TextField();
                lName.getStyleClass().add("text-field");
                lName.setPrefHeight(50);
                lName.setPrefWidth(200);
                lName.setBorder(new Border(
                                new BorderStroke(Color.valueOf("#000000"), BorderStrokeStyle.SOLID, null,
                                                new BorderWidths(1))));
                lName.setPromptText("Last Name");
                lName.setOnMouseClicked(e -> {
                        if (lName.getText().equals(lName.getPromptText())) {
                                lName.setText("");
                        }
                });

                creditCard = new TextField();
                creditCard.getStyleClass().add("text-field");
                creditCard.setPrefHeight(50);
                creditCard.setPrefWidth(200);
                creditCard.setBorder(new Border(
                                new BorderStroke(Color.valueOf("#000000"), BorderStrokeStyle.SOLID, null,
                                                new BorderWidths(1))));
                creditCard.setPromptText("Credit Card Numbers");
                creditCard.setOnMouseClicked(e -> {
                        if (creditCard.getText().equals(creditCard.getPromptText())) {
                                creditCard.setText("");
                        }
                });

                expDate = new TextField();
                expDate.getStyleClass().add("text-field");
                expDate.setPrefHeight(50);
                expDate.setPrefWidth(50);
                expDate.setBorder(new Border(
                                new BorderStroke(Color.valueOf("#000000"), BorderStrokeStyle.SOLID, null,
                                                new BorderWidths(1))));
                expDate.setPromptText("EXP Date");
                expDate.setOnMouseClicked(e -> {
                        if (expDate.getText().equals(expDate.getPromptText())) {
                                expDate.setText("");
                        }
                });

                ccvNumber = new TextField();
                ccvNumber.getStyleClass().add("text-field");
                ccvNumber.setPrefHeight(50);
                ccvNumber.setPrefWidth(50);
                ccvNumber.setBorder(new Border(
                                new BorderStroke(Color.valueOf("#000000"), BorderStrokeStyle.SOLID, null,
                                                new BorderWidths(1))));
                ccvNumber.setPromptText("CCV");
                ccvNumber.setOnMouseClicked(e -> {
                        if (ccvNumber.getText().equals(ccvNumber.getPromptText())) {
                                ccvNumber.setText("");
                        }
                });

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
                GridPane.setMargin(searchField, new Insets(0, 0, 0, 430));
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

                gridGame.add(cartText, 0, 0);
                GridPane.setMargin(cartText, new Insets(70, 500, 0, 60));

                GridPane gridPayment = new GridPane();
                gridPayment.add(totalText, 0, 0);
                gridPayment.add(totalPriceLabel, 1, 0);
                gridPayment.add(fName, 0, 1);
                gridPayment.add(lName, 1, 1);
                gridPayment.add(creditCard, 0, 2, 2, 1);
                gridPayment.add(expDate, 0, 4);
                gridPayment.add(ccvNumber, 1, 4);
                gridPayment.add(buyButton, 0, 6, 6, 1);

                GridPane.setMargin(totalText, new Insets(70, 0, 0, 0));
                GridPane.setMargin(totalPriceLabel, new Insets(70, 0, 0, -80));
                GridPane.setMargin(fName, new Insets(30, 0, 0, 0));
                GridPane.setMargin(lName, new Insets(30, 0, 0, 20));
                GridPane.setMargin(creditCard, new Insets(30, 0, 0, 0));
                GridPane.setMargin(expDate, new Insets(30, 0, 0, 0));
                GridPane.setMargin(ccvNumber, new Insets(30, 0, 0, 20));
                GridPane.setMargin(buyButton, new Insets(30, 0, 0, 0));

                GridPane.setVgrow(fName, Priority.ALWAYS);
                GridPane.setVgrow(lName, Priority.ALWAYS);
                GridPane.setVgrow(creditCard, Priority.ALWAYS);
                GridPane.setVgrow(expDate, Priority.ALWAYS);
                GridPane.setVgrow(ccvNumber, Priority.ALWAYS);
                GridPane.setVgrow(buyButton, Priority.ALWAYS);

                GridPane gridAll = new GridPane();
                gridAll.add(gridGame, 0, 0);
                gridAll.add(gridPayment, 1, 0);

                hBox.getChildren().add(gridAll);
                vbox.getChildren().addAll(gridPaneNav, hBox);
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

        public void addProfileHandler(EventHandler<MouseEvent> event) {
                profileLabel.setOnMouseClicked(event);
        }

        public void addGGIconHandler(EventHandler<MouseEvent> event) {
                userImage.setOnMouseClicked(event);
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

        public void addBuyHandler(EventHandler<MouseEvent> event) {
                buyButton.setOnMouseClicked(event);
        }

        public double getTotalPrice() {
                return value;
        }

        public void listGames(List<Game> gamesList, double totalPrice) {

                List<Game> list = (List<Game>) gamesList;
                for (int i = 0, j = 1; i < gamesList.size(); i++, j++) {
                        gameIdList.add(list.get(i).getGame_id() + "");
                        Text gameText = new Text(list.get(i).getGame_name());
                        gameText.getStyleClass().add("games");
                        gridGame.add(gameText, 0, j);
                        GridPane.setMargin(gameText, new Insets(30, 500, 0, 60));

                }
                value = totalPrice;
                totalPriceLabel.setText(String.format("$ %6.2f", totalPrice));
        }

        public List<String> getGameIdList() {
                return this.gameIdList;
        }

        public void buyValidation() {
                if (fName == null || fName.getText().isEmpty() || fName.getText().length() > 20
                                || !fName.getText().matches("^[a-zA-Z]*$")) {
                        fName.setStyle(error);
                } else {
                        fName.setStyle("");
                }
                if (lName == null || lName.getText().isEmpty() || lName.getText().length() > 20
                                || !lName.getText().matches("^[a-zA-Z]*$")) {
                        lName.setStyle(error);
                } else {
                        lName.setStyle("");
                }
                if (creditCard == null || creditCard.getText().isEmpty() || creditCard.getText().length() < 16
                                || creditCard.getText().length() > 19 || !creditCard.getText().matches("[0-9]+")) {
                        creditCard.setStyle(error);
                } else {
                        creditCard.setStyle("");
                }
                if (expDate == null || !expDate.getText().matches("^(0?[1-9]|[1-2][0-9]|3[0-1])/(0?[1-9]|1[0-2])$")) {
                        expDate.setStyle(error);
                } else {
                        expDate.setStyle("");
                }
                if (ccvNumber == null || !ccvNumber.getText().matches("\\d{3}")) {
                        ccvNumber.setStyle(error);
                } else {
                        ccvNumber.setStyle("");
                }
        }

}
