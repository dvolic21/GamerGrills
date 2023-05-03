package views;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import database.GameSales;
import database.Review;
import javafx.animation.*;
import javafx.application.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.effect.*;
import javafx.scene.image.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.stage.*;
import javafx.util.*;
import javafx.scene.*;

public class GGLibrary {

        public String css = this.getClass().getResource("/media/style2.css").toExternalForm();
        private Label gamesLabel = new Label("Games");
        private Label libraryLabel = new Label("Library");
        private Label profileLabel = new Label("Profile");
        private Label adminLabel = new Label("Add/Remove");
        private Label wishlistLabel = new Label("Wishlist");
        private Label cartLabel = new Label("Cart");
        private ImageView searchImage = new ImageView(new Image(getClass().getResourceAsStream("/media/image.png")));
        private ImageView userImage = new ImageView(new Image(getClass().getResourceAsStream("/media/User1.png")));

        private TextField searchField = new TextField();
        private GridPane gridPaneNav = new GridPane();
        private Text productKeyCodeLabel = new Text("xxxx-xxxx-xxxx-xxxx");
        private Map<Integer, Label> gameLabels = new HashMap<>();
        private Map<Integer, ImageView> allImages = new HashMap<>();
        private Map<ImageView, Integer> allIDs = new HashMap<>();

        // Game display
        private Label publisherLabel = new Label("Publisher:");
        private Label genreLabel = new Label("Genre:");
        private Label dateOfPurchaseLabel = new Label("Date of Purchase:");
        private TextArea specificationsTextArea = new TextArea(
                        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec euismod ex sapien, ut volutpat diam euismod eget. Quisque nec mauris id odio dignissim lobortis nec sit amet nulla. Morbi posuere vestibulum quam eget rutrum. Nullam sed porttitor justo. Donec eu varius diam, non venenatis mauris. Mauris purus odio, commodo quis leo vitae, dignissim tincidunt erat. Quisque semper ut lectus sit amet auctor. In auctor efficitur libero, nec faucibus enim commodo ut. Proin imperdiet dui at justo pharetra, ");
        private TextArea descriptionTextArea = new TextArea(
                        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec euismod ex sapien, ut volutpat diam euismod eget. Quisque nec mauris id odio dignissim lobortis nec sit amet nulla. Morbi posuere vestibulum quam eget rutrum. Nullam sed porttitor justo. Donec eu varius diam, non venenatis mauris. Mauris purus odio, commodo quis leo vitae, dignissim tincidunt erat. Quisque semper ut lectus sit amet auctor. In auctor efficitur libero, nec faucibus enim commodo ut. Proin imperdiet dui at justo pharetra, ");
        private ImageView game1 = new ImageView(new Image(getClass().getResourceAsStream("/media/game.png")));
        private ImageView gameGamesImage = new ImageView(new Image(getClass().getResourceAsStream("/media/game.png")));
        private GridPane gridGames = new GridPane();
        private Text gameLabel = new Text("The Forest");
        private GridPane gridReview = new GridPane();
        private GridPane gridGame = new GridPane();
        private GridPane gridAll = new GridPane();
        private Rectangle rectangle = new Rectangle(500, 50);
        private GridPane gridCode = new GridPane();
        private Label gamesListLabel = new Label("Purchase History");

        private Text productKeyLabel = new Text("Product Key");
        private Label descriptionLabel = new Label("Description:");
        private Label specificationsLabel = new Label("Specifications:");
        private Text reviewsLabel = new Text("Reviews");

        private void handleMouseEvents(ImageView imageView) {
                double initialScaleX = 1.0;
                double initialScaleY = 1.0;
                double scaleFactor = 0.05;
                double shadowOffsetX = 2;
                double shadowOffsetY = 2;

                // Create a drop shadow effect with custom color
                DropShadow dropShadow = new DropShadow();
                dropShadow.setColor(Color.web("#959595"));
                dropShadow.setRadius(5);
                dropShadow.setSpread(0.5);
                dropShadow.setOffsetX(shadowOffsetX);
                dropShadow.setOffsetY(shadowOffsetY);

                // Add a mouse entered event handler
                imageView.setOnMouseEntered(event -> {
                        // Create a scale transition for enlarging the imageView
                        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(200), imageView);
                        scaleTransition.setToX(initialScaleX + scaleFactor);
                        scaleTransition.setToY(initialScaleY + scaleFactor);

                        // Play the scale transition
                        scaleTransition.playFromStart();
                        imageView.setCursor(Cursor.HAND);

                        // Apply the drop shadow effect
                        imageView.setEffect(dropShadow);
                });

                // Add a mouse exited event handler
                imageView.setOnMouseExited(event -> {
                        // Create a scale transition for resetting the imageView to its original size
                        ScaleTransition scaleTransitionReset = new ScaleTransition(Duration.millis(200), imageView);
                        scaleTransitionReset.setToX(initialScaleX);
                        scaleTransitionReset.setToY(initialScaleY);

                        // Play the scale transition reset
                        scaleTransitionReset.playFromStart();
                        imageView.setCursor(Cursor.HAND);

                        // Remove the drop shadow effect
                        imageView.setEffect(null);
                });
        }

        public GGLibrary(Stage _stage) {
                VBox root = new VBox();
                root.setMaxWidth(Double.MAX_VALUE);
                root.setSpacing(0);
                HBox hBox = new HBox();
                ScrollPane scrollPane1 = new ScrollPane();
                ScrollPane scrollPane2 = new ScrollPane();

                scrollPane1.setPrefWidth(0.3 * 1600);
                scrollPane2.setPrefWidth(0.7 * 1600);

                scrollPane1.setFitToWidth(true);
                scrollPane1.setFitToHeight(true);

                scrollPane1.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
                scrollPane2.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
                scrollPane2.setFitToWidth(true);

                gameLabel.getStyleClass().add("game-label");
                publisherLabel.getStyleClass().add("publisher-label");
                genreLabel.getStyleClass().add("genre-label");
                dateOfPurchaseLabel.getStyleClass().add("date-of-purchase-label");
                productKeyLabel.getStyleClass().add("product-key-label");
                productKeyCodeLabel.getStyleClass().add("product-key-code-label");
                descriptionLabel.getStyleClass().add("description-label");
                specificationsLabel.getStyleClass().add("specifications-label");
                reviewsLabel.getStyleClass().add("reviews-label");

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
                game1.setFitWidth(170);
                game1.setFitHeight(245);

                ImageView star = new ImageView(new Image(getClass().getResourceAsStream("/media/starTest.png")));
                star.setFitWidth(100);
                star.setFitHeight(20);

                gameGamesImage.setFitWidth(200);
                gameGamesImage.setFitHeight(290);

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
                libraryLabel.getStyleClass().add("label2");
                profileLabel.getStyleClass().add("label1");
                wishlistLabel.getStyleClass().add("label1");
                cartLabel.getStyleClass().add("label1");
                gamesListLabel.getStyleClass().add("labels-games");

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

                gamesListLabel.getStyleClass().add("label-games-list");
                gamesListLabel.setStyle("-fx-font-size: 30px;");
                gridGames.setStyle("-fx-background-color: #000000;");
                gridGames.add(gamesListLabel, 0, 0);
                GridPane.setMargin(gamesListLabel, new Insets(20, 0, 0, 50));
                GridPane.setVgrow(gamesListLabel, Priority.ALWAYS);

                gridGame.add(gameGamesImage, 0, 0);
                gridGame.add(gameLabel, 4, 0);
                gridGame.add(publisherLabel, 4, 0);
                gridGame.add(dateOfPurchaseLabel, 4, 0);

                gridCode.add(productKeyLabel, 0, 0);
                gridCode.add(productKeyCodeLabel, 0, 1);
                gridCode.add(rectangle, 0, 2);
                productKeyCodeLabel.toFront();

                GridPane.setMargin(gameGamesImage, new Insets(40, 0, 0, 40));
                GridPane.setMargin(gameLabel, new Insets(-220, 0, 0, 20));
                GridPane.setMargin(publisherLabel, new Insets(-100, 0, 0, 20));
                GridPane.setMargin(dateOfPurchaseLabel, new Insets(-20, 0, 0, 20));
                GridPane.setMargin(productKeyLabel, new Insets(-140, 0, 0, 530));
                GridPane.setMargin(rectangle, new Insets(-50, 0, 0, 350));
                GridPane.setMargin(productKeyCodeLabel, new Insets(-50, 0, 0, 455));

                GridPane gridInfo = new GridPane();
                gridInfo.add(descriptionLabel, 0, 1);
                gridInfo.add(specificationsLabel, 1, 1);
                gridInfo.add(descriptionTextArea, 0, 2);
                gridInfo.add(specificationsTextArea, 1, 2);
                gridInfo.add(reviewsLabel, 0, 3);

                descriptionTextArea.setPrefWidth(600);
                specificationsTextArea.setPrefWidth(462);
                descriptionTextArea.setPrefHeight(300);
                specificationsTextArea.setPrefHeight(300);
                descriptionTextArea.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");
                specificationsTextArea.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");

                descriptionTextArea.setWrapText(true);
                descriptionTextArea.setPrefColumnCount(1);
                descriptionTextArea.setEditable(false);
                descriptionTextArea.setMouseTransparent(true);
                specificationsTextArea.setWrapText(true);
                specificationsTextArea.setPrefColumnCount(1);
                specificationsTextArea.setEditable(false);
                specificationsTextArea.setMouseTransparent(true);

                GridPane.setMargin(descriptionLabel, new Insets(30, 0, 0, 70));
                GridPane.setMargin(specificationsLabel, new Insets(30, 0, 0, 100));
                GridPane.setMargin(descriptionTextArea, new Insets(30, 0, 0, 60));
                GridPane.setMargin(specificationsTextArea, new Insets(30, 0, 0, 90));
                GridPane.setMargin(reviewsLabel, new Insets(0, 0, 0, 70));

                gridAll.add(gridGame, 0, 0);
                gridAll.add(gridCode, 0, 1);
                gridAll.add(gridInfo, 0, 2);
                gridAll.add(gridReview, 0, 3);

                scrollPane1.setContent(gridGames);
                scrollPane2.setContent(gridAll);

                hBox.getChildren().addAll(scrollPane1, scrollPane2);
                root.getChildren().addAll(gridPaneNav, hBox);
                Scene scene = new Scene(root, 1300, 650);
                scene.getStylesheets().add(css);
                _stage.setTitle("Gamer Grills");
                _stage.setResizable(false);
                _stage.setScene(scene);
                _stage.show();

                Platform.runLater(() -> {
                        scrollPane1.lookup(".scroll-bar:vertical").setStyle(
                                        "-fx-background-color: #450101; -fx-background-radius: 5;");
                        scrollPane1.lookup(".scroll-bar:vertical .thumb").setStyle(
                                        "-fx-background-color: #450101; -fx-background-radius: 5; -fx-background-insets: 0;");
                        scrollPane1.lookup(".scroll-bar:vertical .thumb:hover").setStyle(
                                        "-fx-background-color: #450101; -fx-background-radius: 5; -fx-background-insets: 0;");
                        scrollPane1.lookup(".scroll-bar:vertical .track").setStyle(
                                        "-fx-background-color: #f8f9fa; -fx-background-radius: 5; -fx-background-insets: 0;");
                        scrollPane1.setStyle("-fx-background-color: transparent; -fx-background-insets: 0;");
                        scrollPane1.setStyle("-fx-background-color: transparent; -fx-background-insets: 0;");

                        scrollPane2.lookup(".scroll-bar:vertical").setStyle(
                                        "-fx-background-color: #450101; -fx-background-radius: 5;");
                        scrollPane2.lookup(".scroll-bar:vertical .thumb").setStyle(
                                        "-fx-background-color: #450101; -fx-background-radius: 5; -fx-background-insets: 0;");
                        scrollPane2.lookup(".scroll-bar:vertical .thumb:hover").setStyle(
                                        "-fx-background-color: #450101; -fx-background-radius: 5; -fx-background-insets: 0;");
                        scrollPane2.lookup(".scroll-bar:vertical .track").setStyle(
                                        "-fx-background-color: #f8f9fa; -fx-background-radius: 5; -fx-background-insets: 0;");
                        scrollPane2.setStyle("-fx-background-color: transparent; -fx-background-insets: 0;");
                        scrollPane2.setStyle("-fx-background-color: transparent; -fx-background-insets: 0;");

                        descriptionTextArea.lookup(".content").setStyle("-fx-background-color: #f4f4f4;");
                        specificationsTextArea.lookup(".content").setStyle("-fx-background-color: #f4f4f4;");
                });

        }

        public void addGamesHandler(EventHandler<MouseEvent> event) {
                gamesLabel.setOnMouseClicked(event);
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

        public void addCartHandler(EventHandler<MouseEvent> event) {
                cartLabel.setOnMouseClicked(event);
        }

        public void addGGIconHandler(EventHandler<MouseEvent> event) {
                userImage.setOnMouseClicked(event);
        }

        public void changeGameHandler(EventHandler<MouseEvent> event) {

        }

        public void createLabel() {
                GridPane.setMargin(adminLabel, new Insets(0, 0, 0, 40));
                adminLabel.getStyleClass().add("label1");
                gridPaneNav.add(adminLabel, 3, 0);
        }

        public String getName() {
                return this.searchField.getText();
        }

        public void pressedGameHandler(EventHandler<MouseEvent> event) {
                for (Entry<ImageView, Integer> pair : allIDs.entrySet()) {
                        pair.getKey().setOnMouseClicked(event);
                }
        }

        public void loadHistory(GameSales gameSales) {
                if (gameSales != null) {
                        if (!gameSales.getGame().getGame_name().equals(this.gameLabel.getText())) {
                                String path = gameSales.getGame().getGame_image();
                                Image image = new Image(path);
                                gameGamesImage.setImage(image);
                                this.gameGamesImage.setImage(image);
                                this.gameLabel.setText(gameSales.getGame().getGame_name());
                                this.publisherLabel.setText("Publisher: "
                                                + gameSales.getGame().getPublisher().getPublisher_name()
                                                + ", Developer: "
                                                + gameSales.getGame().getPublisher().getDeveloper());
                                this.productKeyCodeLabel.setText(gameSales.getGame_code());
                                this.dateOfPurchaseLabel.setText("Date of Purchase: " + gameSales.getDate());
                                this.specificationsTextArea.setText("OS: " + gameSales.getGame().getSpecs().getOS()
                                                + "\nProcessor: " + gameSales.getGame().getSpecs().getProcessor()
                                                + "\nMemory: " + gameSales.getGame().getSpecs().getMemory()
                                                + "\nStorage: "
                                                + gameSales.getGame().getSpecs().getStorage()
                                                + "\nGraphics: " + gameSales.getGame().getSpecs().getGraphics()
                                                + "\nDirectX: "
                                                + gameSales.getGame().getSpecs().getDirectX());
                                this.descriptionTextArea.setText(gameSales.getGame().getGame_description());
                        }

                } else {
                        this.gameGamesImage.setImage(null);
                        this.gameLabel.setText(null);
                        this.publisherLabel.setText(null);
                        this.productKeyCodeLabel.setText(null);
                        this.dateOfPurchaseLabel.setText(null);
                        this.specificationsTextArea.setText(null);
                        this.descriptionTextArea.setText(null);
                        productKeyLabel.setText(null);
                        descriptionLabel.setText(null);
                        specificationsLabel.setText(null);
                        reviewsLabel.setText(null);
                        rectangle.setVisible(false);
                }
        }

        public void loadSideBar(List<GameSales> list) {
                String path;
                Image image;
                for (int i = 0; i < list.size(); i++) {

                        ImageView game1 = new ImageView(new Image(getClass().getResourceAsStream("/media/game.png")));
                        game1.setFitWidth(170);
                        game1.setFitHeight(245);
                        handleMouseEvents(game1);
                        path = list.get(i).getGame().getGame_image();
                        image = new Image(path);
                        game1.setImage(image);
                        Label game1Label = new Label();
                        this.gameLabels.put(i, game1Label);
                        game1Label.setText(list.get(i).getGame().getGame_name());
                        game1Label.setPrefWidth(170);
                        game1Label.setWrapText(true);
                        game1Label.getStyleClass().add("labels-games");
                        this.allImages.put(i, game1);
                        this.allIDs.put(this.allImages.get(i), i);
                        gridGames.add(game1Label, 0, i * 2 + 2);
                        gridGames.add(game1, 0, i * 2 + 1);
                        GridPane.setMargin(game1, new Insets(40, 0, 0, 75));
                        GridPane.setMargin(game1Label, new Insets(5, 0, 0, 75));
                        if (i == 0) {
                                GridPane.setVgrow(game1, Priority.ALWAYS);
                        } else {
                                GridPane.setVgrow(game1, Priority.NEVER);
                        }
                }
        }

        public int getID() {
                for (Entry<ImageView, Integer> pair : allIDs.entrySet()) {
                        if (pair.getKey().isHover())
                                return pair.getValue();
                }
                return -1;
        }

        public void loadReview(List<Review> reviews) {
                if (reviews != null && !reviews.isEmpty()) {
                        int k = 0;

                        for (int i = 0; i < reviews.size(); i++) {
                                Label userLabel1 = new Label();
                                userLabel1.setText(reviews.get(i).getUser_key());
                                TextArea userReviewTextArea = new TextArea();
                                userReviewTextArea.setText(reviews.get(i).getReview_comment());
                                Label rating = new Label(reviews.get(i).getReview_stars() + "/5 STARS");
                                userReviewTextArea.getStyleClass().add("user-review-text-area");
                                userReviewTextArea.setPrefWidth(775);
                                userReviewTextArea.setPrefHeight(70);
                                gridReview.setMaxSize(820, 20);
                                userReviewTextArea.setStyle(
                                                "-fx-background-color: transparent; -fx-border-color: transparent;");
                                userReviewTextArea.setWrapText(true);
                                userReviewTextArea.setPrefColumnCount(1);
                                userReviewTextArea.setEditable(false);
                                userReviewTextArea.setMouseTransparent(true);
                                userReviewTextArea
                                                .setStyle("-fx-font-size: 15;-fx-background-color: transparent; -fx-border-color: transparent;");
                                userLabel1.getStyleClass().add("user-label");
                                rating.getStyleClass().add("user-label");
                                gridReview.setStyle(
                                                "-fx-border-color: black; -fx-border-width: 0.3px; -fx-border-radius: 50; -fx-background-color: white; -fx-background-radius: 50;");
                                gridReview.add(userLabel1, 0, i + k);
                                gridReview.add(userReviewTextArea, 0, i + k + 1);
                                gridReview.add(rating, 1, i + k);
                                k += 2;

                                DropShadow innerShadow = new DropShadow();
                                innerShadow.setOffsetX(4);
                                innerShadow.setOffsetY(4);
                                innerShadow.setRadius(2);
                                innerShadow.setColor(Color.GRAY);
                                gridReview.setEffect(innerShadow);

                                GridPane.setMargin(gridReview, new Insets(50, 0, 30, 70));
                                GridPane.setMargin(userLabel1, new Insets(10, 0, 0, 30));
                                GridPane.setMargin(userReviewTextArea, new Insets(-10, 0, 10, 22));
                                GridPane.setMargin(rating, new Insets(32, 0, 20, -700));

                        }
                }
        }
}
