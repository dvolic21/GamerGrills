package views;
import java.text.*;
import java.util.*;
import java.util.Map.*;
import database.Cart;
import database.Game;
import database.User;
import database.Wishlist;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.*;
import javafx.scene.*;

public class GGCart {

        public String css = this.getClass().getResource("/media/style2.css").toExternalForm();
        private Label gamesLabel = new Label("Games");
        private Label libraryLabel = new Label("Library");
        private Label adminLabel = new Label("Add/Remove");
        private Label profileLabel = new Label("Profile");
        private Label wishlistLabel = new Label("Wishlist");
        private Label cartLabel = new Label("Cart");
        private ImageView searchImage = new ImageView(new Image(getClass().getResourceAsStream("/media/image.png")));
        private ImageView userImage = new ImageView(new Image(getClass().getResourceAsStream("/media/User1.png")));
        private ImageView lineImage = new ImageView(new Image(getClass().getResourceAsStream("/media/line.png")));
        private TextField buyButton = new TextField("BUY");
        private GridPane gridAll = new GridPane();
        private GridPane gridPaneNav = new GridPane();
        private TextField searchField = new TextField();
        private Text userCartLabel = new Text("XYZ's");
        private Text priceLabel = new Text("Total Price ");
        private double value = 0;
        private Map<TextField, Integer> allButtons = new HashMap<>();
        private Map<TextField, Integer> allWishlist = new HashMap<>();
        private List<Game> gamesList = new ArrayList<>();
        private VBox v1 = new VBox();
        private VBox v2 = new VBox();
        private GridPane gridEnd = new GridPane();
        private DecimalFormat df = new DecimalFormat("0.00");
        
        public GGCart(Stage _stage) {
                VBox vbox = new VBox();
                vbox.setMaxWidth(Double.MAX_VALUE);
                ScrollPane root = new ScrollPane(vbox);
                root.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
                root.setFitToWidth(true);
                HBox hBox = new HBox();

                buyButton.setId("CartBuyButton");
                buyButton.getStyleClass().add("buttons-game");
                userCartLabel.getStyleClass().add("game-price-label");
                priceLabel.getStyleClass().add("game-price-label");
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

                gridAll.add(userCartLabel, 0, 0);
                GridPane.setMargin(userCartLabel, new Insets(70, 0, 0, 80));
                GridPane.setMargin(priceLabel, new Insets(70, 0, 0, 80));
                GridPane.setMargin(buyButton, new Insets(-50, 0, 0, 1000));
                hBox.getChildren().addAll(v1, v2);
                gridEnd.add(priceLabel, 0, 0);
                gridEnd.add(buyButton, 0, 1);
                vbox.getChildren().addAll(gridPaneNav, gridAll, hBox, gridEnd);
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

        public void addAdminHandler(EventHandler<MouseEvent> event) {
                adminLabel.setOnMouseClicked(event);
        }

        public void addSearchHandler(EventHandler<MouseEvent> event) {
                searchImage.setOnMouseClicked(event);
        }

        public void addWishlistHandler(EventHandler<MouseEvent> event) {
                wishlistLabel.setOnMouseClicked(event);
        }

        public void addGGIconHandler(EventHandler<MouseEvent> event) {
                userImage.setOnMouseClicked(event);
        }

        public void addPaymentHandler(EventHandler<MouseEvent> event) {
                buyButton.setOnMouseClicked(event);
        }

        public void removeCartHandler(EventHandler<MouseEvent> event) {
                for (Entry<TextField, Integer> pair : allButtons.entrySet()) {
                        pair.getKey().setOnMouseClicked(event);
                }
        }

        public void addToWishlistHandler(EventHandler<MouseEvent> event) {
                for (Entry<TextField, Integer> pair : allWishlist.entrySet()) {
                        pair.getKey().setOnMouseClicked(event);
                }
        }

        public void createLabel() {
                GridPane.setMargin(adminLabel, new Insets(0, 0, 0, 40));
                adminLabel.getStyleClass().add("label1");
                gridPaneNav.add(adminLabel, 3, 0);
        }

        public String getName() {
                return this.searchField.getText();
        }

        public void setCart(List<Cart> cart, User user, List<Wishlist> wishlist) {
                this.userCartLabel.setText(user.getUsername() + "'s Cart");
                for (int i = 0; i < cart.size(); i++) {
                        gamesList.add(cart.get(i).getGame());

                        GridPane gridGame = new GridPane();
                        GridPane gridButtonPurchase = new GridPane();

                        ImageView gameView = new ImageView(new Image(getClass().getResourceAsStream("/media/game.png")));
                        String path = cart.get(i).getGame().getGame_image();
                        Image image = new Image(path);
                        gameView.setImage(image);
                        gameView.setFitWidth(200);
                        gameView.setFitHeight(290);

                        Text game1Label = new Text(cart.get(i).getGame().getGame_name());
                        value += cart.get(i).getGame().getPrices().getPrice();
                        Text game1PriceLabel = new Text("Price: " + cart.get(i).getGame().getPrices().getPrice());
                        Label publisherLabel = new Label("Publisher: "
                                        + cart.get(i).getGame().getPublisher().getPublisher_name() + " Developer: "
                                        + cart.get(i).getGame().getPublisher().getDeveloper());
                        Label dateOfRelease = new Label(
                                        "Date of Purchase: " + cart.get(i).getGame().getDate().getRelease_date());
                        game1Label.getStyleClass().add("game-label");
                        game1PriceLabel.getStyleClass().add("game-price-label");
                        publisherLabel.getStyleClass().add("publisher-label");
                        dateOfRelease.getStyleClass().add("date-of-purchase-label");

                        TextField addToWishButton = new TextField("Add To Wishlist");
                        addToWishButton.getStyleClass().add("buttons-game");
                        addToWishButton.setAlignment(Pos.CENTER);
                        addToWishButton.setEditable(false);
                        addToWishButton.setOnMouseClicked(e -> {
                        });
                        for (int k = 0; k < wishlist.size(); k++) {
                                if (wishlist.get(k).getGame_key() == cart.get(i).getGame_key()) {
                                        addToWishButton.setText("In Wishlist");
                                }
                        }
                        TextField removeButton = new TextField("REMOVE");
                        removeButton.getStyleClass().add("buttons-game");
                        removeButton.setAlignment(Pos.CENTER);
                        removeButton.setEditable(false);
                        removeButton.setOnMouseClicked(e -> {
                        });

                        allButtons.put(removeButton, cart.get(i).getGame_key());

                        gridGame.add(gameView, 0, i + 1);
                        gridGame.add(game1Label, 1, i + 2);
                        gridGame.add(publisherLabel, 1, i + 3);
                        gridGame.add(dateOfRelease, 1, i + 4);

                        gridButtonPurchase.add(game1PriceLabel, 6, i + 0);
                        gridButtonPurchase.add(addToWishButton, 6, i + 2);
                        // gridButtonPurchase.add(buyButton, 6, i + 3);
                        gridButtonPurchase.add(removeButton, 6, i + 1);

                        GridPane.setMargin(gameView, new Insets(70, 20, 20, 80));
                        GridPane.setMargin(game1PriceLabel, new Insets(-600, 0, 0, 1000));
                        GridPane.setMargin(removeButton, new Insets(-500, 100, 0, 1000));
                        GridPane.setMargin(addToWishButton, new Insets(-400, 100, 0, 1000));
                        // GridPane.setMargin(buyButton, new Insets(-300, 100, 0, 1000));
                        GridPane.setMargin(game1Label, new Insets(-600, 0, 0, 0));
                        GridPane.setMargin(publisherLabel, new Insets(-500, 0, 0, 0));
                        GridPane.setMargin(dateOfRelease, new Insets(-420, 0, 20, 0));
                        v1.getChildren().add(gridGame);
                        v1.getChildren().add(gridButtonPurchase);

                }
                priceLabel.setText(priceLabel.getText() + ": " + df.format(value) + " USD");
                if (value < 1) {
                        buyButton.setVisible(false);
                }
        }

        public int getID() {
                for (Entry<TextField, Integer> pair : allButtons.entrySet()) {
                        if (pair.getKey().isHover())
                                return pair.getValue();
                }
                return -1;
        }

        public int getID2() {
                for (Entry<TextField, Integer> pair : allWishlist.entrySet()) {
                        if (pair.getKey().isHover())
                                return pair.getValue();
                }
                return -1;
        }

        public List<Game> getGameNames() {
                return this.gamesList;
        }

        public double getTotalPrice() {
                return this.value;
        }
}
