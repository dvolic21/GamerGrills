package views;
import java.util.*;
import database.Cart;
import database.GameSales;
import database.Game_Features;
import database.Game_Genre;
import database.Review;
import database.SystemSpecs;
import database.Wishlist;
import javafx.application.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.effect.*;
import javafx.scene.image.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.*;
import javafx.scene.*;

public class GGGame {

        private int id = -1;
        private int clickedIndex = -1;

        public String css = this.getClass().getResource("/media/style2.css").toExternalForm();
        private Label gamesLabel = new Label("Games");
        private Label libraryLabel = new Label("Library");
        private Label profileLabel = new Label("Profile");
        private Label wishlistLabel = new Label("Wishlist");
        private Label cartLabel = new Label("Cart");
        private Label publisherLabel = new Label("Publisher:");
        private Label genreLabel = new Label("Genre:");
        private Label dateOfPurchaseLabel = new Label("Release Date:");
        private Label descriptionLabel = new Label("Description:");
        private Label specificationsLabel = new Label("Specifications:");

        private Text reviewsLabel = new Text("Reviews");
        private Text game1Label = new Text("The Forest");
        private Text game1PriceLabel = new Text("Price:");
        private Text leaveReviewLabel = new Text("Leave a Review");
        private TextField searchField = new TextField();
        private TextField submitButton = new TextField("Submit");
        private TextField buyButton = new TextField("BUY");
        private TextField wishlistButton = new TextField("WISHLIST");
        private TextField addToCartButton = new TextField("ADD TO CART");
        private TextArea specificationsTextArea = new TextArea("we wu we wu");
        private TextArea descriptionTextArea = new TextArea("we wu");
        private TextArea userInputArea = new TextArea();

        private GridPane gridPaneNav = new GridPane();
        private HBox gamesHBox = new HBox();
        private GridPane gridAll = new GridPane();
        private GridPane gridButtonsPrice = new GridPane();
        private GridPane gridInfo = new GridPane();
        private GridPane gridStars = new GridPane();
        private GridPane gridReview = new GridPane();
        private GridPane gridReviewHeader = new GridPane();
        private GridPane gridReviewText = new GridPane();
        private GridPane gridGame = new GridPane();
        private GridPane gridSubmit = new GridPane();

        private DropShadow innerShadow = new DropShadow();
        private DropShadow innerShadow1 = new DropShadow();

        private ImageView searchImage = new ImageView(new Image(getClass().getResourceAsStream("/media/image.png")));
        private ImageView userImage = new ImageView(new Image(getClass().getResourceAsStream("/media/User1.png")));
        private ImageView lineImage = new ImageView(new Image(getClass().getResourceAsStream("/media/line.png")));
        private ImageView game1 = new ImageView(new Image(getClass().getResourceAsStream("/media/image.png")));
        private ImageView star = new ImageView(new Image(getClass().getResourceAsStream("/media/stars2.png")));
        private ImageView star1 = new ImageView(new Image(getClass().getResourceAsStream("/media/star2.png")));
        private ImageView star2 = new ImageView(new Image(getClass().getResourceAsStream("/media/star2.png")));
        private ImageView star3 = new ImageView(new Image(getClass().getResourceAsStream("/media/star2.png")));
        private ImageView star4 = new ImageView(new Image(getClass().getResourceAsStream("/media/star2.png")));
        private ImageView star5 = new ImageView(new Image(getClass().getResourceAsStream("/media/star2.png")));
        private ImageView[] stars = { star1, star2, star3, star4, star5 };

        public GGGame(Stage _stage) {
                VBox vbox = new VBox();
                vbox.setMaxWidth(Double.MAX_VALUE);
                ScrollPane root = new ScrollPane(vbox);
                root.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
                root.setFitToWidth(true);
                HBox hBox = new HBox();

                game1Label.getStyleClass().add("game-label");
                game1PriceLabel.getStyleClass().add("game-price-label");
                publisherLabel.getStyleClass().add("publisher-label");
                genreLabel.getStyleClass().add("genre-label");
                dateOfPurchaseLabel.getStyleClass().add("date-of-purchase-label");
                descriptionLabel.getStyleClass().add("description-label");
                specificationsLabel.getStyleClass().add("specifications-label");
                reviewsLabel.getStyleClass().add("reviews-label");
                leaveReviewLabel.getStyleClass().add("reviews-label");

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
                game1.setFitWidth(200);
                game1.setFitHeight(290);

                star.setFitWidth(100);
                star.setFitHeight(20);
                star1.setFitWidth(40);
                star1.setFitHeight(40);
                star2.setFitWidth(40);
                star2.setFitHeight(40);
                star3.setFitWidth(40);
                star3.setFitHeight(40);
                star5.setFitWidth(40);
                star5.setFitHeight(40);
                star4.setFitWidth(40);
                star4.setFitHeight(40);
                userImage.setOnMouseEntered(event -> {

                        userImage.setImage(new Image(getClass().getResourceAsStream("/media/User2.png")));
                });
                EventHandler<MouseEvent> starClickHandler = new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                                // get the clicked star image view
                                ImageView clickedStar = (ImageView) event.getSource();

                                // get the index of the clicked star in the stars array
                                clickedIndex = -1;
                                for (int i = 0; i < stars.length; i++) {
                                        if (stars[i] == clickedStar) {
                                                clickedIndex = i;
                                                break;
                                        }
                                }

                                // set the clicked star and all previous stars to the "star" image
                                for (int i = 0; i <= clickedIndex; i++) {
                                        stars[i].setImage(new Image(
                                                        getClass().getResourceAsStream("/media/star1.png")));
                                }

                                // set all remaining stars to the "starZero" image
                                for (int i = clickedIndex + 1; i < stars.length; i++) {
                                        stars[i].setImage(new Image(
                                                        getClass().getResourceAsStream("/media/star2.png")));
                                }
                        }
                };
                star.setOnMouseClicked(starClickHandler);
                star1.setOnMouseClicked(starClickHandler);
                star2.setOnMouseClicked(starClickHandler);
                star3.setOnMouseClicked(starClickHandler);
                star4.setOnMouseClicked(starClickHandler);
                star5.setOnMouseClicked(starClickHandler);

                userImage.setOnMouseEntered(event -> {

                        userImage.setImage(new Image(getClass().getResourceAsStream("/media/User2.png")));
                });

                userImage.setOnMouseExited(event -> {
                        userImage.setImage(new Image(getClass().getResourceAsStream("/media/User1.png")));
                });

                wishlistButton.getStyleClass().add("buttons-game");
                wishlistButton.setAlignment(Pos.CENTER);
                wishlistButton.setEditable(false);
                wishlistButton.setOnMouseClicked(e -> {

                });

                addToCartButton.getStyleClass().add("buttons-game");
                addToCartButton.setAlignment(Pos.CENTER);
                addToCartButton.setEditable(false);
                addToCartButton.setOnMouseClicked(e -> {

                });

                buyButton.getStyleClass().add("buttons-game");
                buyButton.setAlignment(Pos.CENTER);
                buyButton.setEditable(false);
                buyButton.setOnMouseClicked(e -> {

                });

                submitButton.getStyleClass().add("buttons-game");
                submitButton.setAlignment(Pos.CENTER);
                submitButton.setEditable(false);
                submitButton.setOnMouseClicked(e -> {

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

                gridGame.add(game1, 0, 0);
                gridGame.add(game1Label, 1, 1);
                gridGame.add(publisherLabel, 1, 2);
                gridGame.add(genreLabel, 1, 3);
                gridGame.add(dateOfPurchaseLabel, 1, 4);

                GridPane.setMargin(game1, new Insets(80, 0, 0, 80));
                GridPane.setMargin(game1Label, new Insets(-555, 0, 0, 60));
                GridPane.setMargin(publisherLabel, new Insets(-450, 0, 0, 60));
                GridPane.setMargin(genreLabel, new Insets(-370, 0, 0, 60));
                GridPane.setMargin(dateOfPurchaseLabel, new Insets(-290, 0, 0, 60));
                gridGame.setPrefSize(900, 500);

                gridButtonsPrice.add(game1PriceLabel, 0, 0);
                gridButtonsPrice.add(wishlistButton, 0, 1);
                gridButtonsPrice.add(addToCartButton, 0, 2);
                gridButtonsPrice.add(buyButton, 0, 3);

                buyButton.setPrefWidth(250);

                GridPane.setMargin(game1PriceLabel, new Insets(60, 0, 0, 0));
                GridPane.setMargin(wishlistButton, new Insets(10, 0, 0, 0));
                GridPane.setMargin(addToCartButton, new Insets(10, 0, 0, 0));
                GridPane.setMargin(buyButton, new Insets(10, 0, 0, 0));
                ;

                gamesHBox.getChildren().addAll(gridGame, gridButtonsPrice);

                HBox.setMargin(gridButtonsPrice, new Insets(0, 0, 0, 50));

                gridInfo.add(descriptionLabel, 0, 0);
                gridInfo.add(specificationsLabel, 1, 0);
                gridInfo.add(descriptionTextArea, 0, 1);
                gridInfo.add(specificationsTextArea, 1, 1);
                gridInfo.add(reviewsLabel, 0, 3);

                descriptionTextArea.setPrefWidth(830);
                specificationsTextArea.setPrefWidth(400);
                descriptionTextArea.setPrefHeight(300);
                specificationsTextArea.setPrefHeight(500);
                descriptionTextArea
                                .setStyle("-fx-font-size: 17;-fx-background-color: transparent; -fx-border-color: transparent;");
                specificationsTextArea
                                .setStyle("-fx-font-size: 15;-fx-background-color: transparent; -fx-border-color: transparent;");

                descriptionTextArea.setWrapText(true);
                descriptionTextArea.setPrefColumnCount(1);
                descriptionTextArea.setEditable(false);
                descriptionTextArea.setMouseTransparent(true);
                specificationsTextArea.setWrapText(true);
                specificationsTextArea.setPrefColumnCount(1);
                specificationsTextArea.setEditable(false);
                specificationsTextArea.setMouseTransparent(true);

                GridPane.setMargin(descriptionLabel, new Insets(30, 0, 0, 80));
                GridPane.setMargin(specificationsLabel, new Insets(30, 0, 0, 160));
                GridPane.setMargin(descriptionTextArea, new Insets(30, 0, 0, 70));
                GridPane.setMargin(specificationsTextArea, new Insets(30, 0, 0, 150));
                GridPane.setMargin(reviewsLabel, new Insets(-180, 0, 0, 80));

                gridStars.add(star, 0, 0);

                gridReview.prefWidth(100);

                gridReview.setStyle(
                                "-fx-border-color: black; -fx-border-width: 0.3px; -fx-border-radius: 50; -fx-background-color: white; -fx-background-radius: 50;");

                innerShadow.setOffsetX(4);
                innerShadow.setOffsetY(4);
                innerShadow.setRadius(2);
                innerShadow.setColor(Color.GRAY);
                gridReview.setEffect(innerShadow);

                gridReviewHeader.add(leaveReviewLabel, 0, 0);
                gridReviewHeader.add(star1, 1, 0);
                gridReviewHeader.add(star2, 2, 0);
                gridReviewHeader.add(star3, 3, 0);
                gridReviewHeader.add(star4, 4, 0);
                gridReviewHeader.add(star5, 5, 0);
                GridPane.setMargin(gridReviewHeader, new Insets(50, 0, 0, 80));
                GridPane.setMargin(star1, new Insets(0, 0, 0, 20));
                GridPane.setMargin(star2, new Insets(0, 0, 0, 10));
                GridPane.setMargin(star3, new Insets(0, 0, 0, 10));
                GridPane.setMargin(star4, new Insets(0, 0, 0, 10));
                GridPane.setMargin(star5, new Insets(0, 0, 0, 10));

                gridReviewText.setStyle(
                                "-fx-border-color: black; -fx-border-width: 0.3px; -fx-border-radius: 50; -fx-background-color: white; -fx-background-radius: 50;");
                gridReviewText.add(userInputArea, 0, 0);
                userInputArea.setPrefWidth(1010);
                userInputArea.setPrefHeight(300);
                userInputArea.setWrapText(true);
                userInputArea.setPrefColumnCount(1);
                userInputArea.setStyle(
                                "-fx-font-size: 15;-fx-background-color: transparent; -fx-border-color: transparent;");

                innerShadow1.setOffsetX(4);
                innerShadow1.setOffsetY(4);
                innerShadow1.setRadius(2);
                innerShadow1.setColor(Color.GRAY);
                gridReviewText.setEffect(innerShadow1);
                GridPane.setMargin(gridReviewText, new Insets(20, 0, 0, 80));
                GridPane.setMargin(userInputArea, new Insets(0, 0, 0, 60));

                gridReviewText.setMaxSize(1125, 400);
                gridSubmit.add(submitButton, 0, 0);
                GridPane.setMargin(submitButton, new Insets(10, 0, 30, 1010));

                gridAll.add(gamesHBox, 0, 0);
                gridAll.add(gridInfo, 0, 1);
                gridAll.add(gridReview, 0, 2);
                gridAll.add(gridReviewHeader, 0, 3);
                gridAll.add(gridReviewText, 0, 4);
                gridAll.add(gridSubmit, 0, 5);

                hBox.getChildren().add(gridAll);
                vbox.getChildren().addAll(gridPaneNav, hBox);
                Scene scene = new Scene(root, 1300, 650);
                scene.getStylesheets().add(css);
                _stage.setTitle("Gamer Grills");
                _stage.setResizable(false);
                _stage.setScene(scene);
                _stage.show();

                Platform.runLater(() -> {
                        root.lookup(".scroll-bar:vertical").setStyle(
                                        "-fx-background-color: #450101; -fx-background-radius: 5;");
                        root.lookup(".scroll-bar:vertical .thumb").setStyle(
                                        "-fx-background-color: #450101; -fx-background-radius: 5; -fx-background-insets: 0;");
                        root.lookup(".scroll-bar:vertical .thumb:hover").setStyle(
                                        "-fx-background-color: #450101; -fx-background-radius: 5; -fx-background-insets: 0;");
                        root.lookup(".scroll-bar:vertical .track").setStyle(
                                        "-fx-background-color: #f8f9fa; -fx-background-radius: 5; -fx-background-insets: 0;");
                        root.setStyle("-fx-background-color: transparent; -fx-background-insets: 0;");
                        root.setStyle("-fx-background-color: transparent; -fx-background-insets: 0;");

                        userInputArea.lookup(".content").setStyle("-fx-background-color: white;");
                        descriptionTextArea.lookup(".content").setStyle("-fx-background-color: #f4f4f4;");
                        specificationsTextArea.lookup(".content").setStyle("-fx-background-color: #f4f4f4;");
                });
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

        public void addGamesHandler(EventHandler<MouseEvent> event) {
                gamesLabel.setOnMouseClicked(event);
        }

        public void leaveReviewHandler(EventHandler<MouseEvent> event) {
                submitButton.setOnMouseClicked(event);
        }

        public void addToWishlistHandler(EventHandler<MouseEvent> event) {
                wishlistButton.setOnMouseClicked(event);
        }

        public void addToCartHandler(EventHandler<MouseEvent> event) {
                addToCartButton.setOnMouseClicked(event);
        }

        public void addPaymentHandler(EventHandler<MouseEvent> event) {
                buyButton.setOnMouseClicked(event);
        }

        public void loadGame(List<Game_Genre> game_Genres, List<Game_Features> game_Features, List<GameSales> sales,
                        List<Cart> cart, List<Wishlist> wishlist) {
                String path = game_Genres.get(0).getGame().getGame_image();
                Image image = new Image(path);
                game1.setImage(image);
                id = game_Genres.get(0).getGame_id();
                buyButton.setId(game_Genres.get(0).getGame().getGame_name());
                publisherLabel.setText("Publisher: "
                                + game_Genres.get(0).getGame().getPublisher().getPublisher_name()
                                + ", Developer: "
                                + game_Genres.get(0).getGame().getPublisher().getDeveloper());
                genreLabel.setText("Genre: " + game_Genres.get(0).getGenre().getGenre());
                descriptionTextArea.setText(game_Features.get(0).getGames().getGame_description());
                game1Label.setText(game_Features.get(0).getGames().getGame_name());
                SystemSpecs specs = game_Features.get(0).getGames().getSpecs();
                dateOfPurchaseLabel.setText("Release Date: "
                                + game_Features.get(0).getGames().getDate().getRelease_date());
                specificationsTextArea.setText("OS: " + specs.getOS() + "\nProcessor: " + specs.getProcessor()
                                + "\nMemory: " + specs.getMemory() + "\nSpecs: " + specs.getStorage()
                                + "\nGraphics: " + specs.getGraphics() + "\nDirectX: " + specs.getDirectX());
                game1PriceLabel.setText("Price: " + game_Features.get(0).getGames().getPrices().getPrice()
                                + ""
                                + game_Features.get(0).getGames().getPrices().getCurrency());
                for (int i = 0; i < sales.size(); i++) {
                        if (sales.get(i).getGame_key() == id) {
                                buyButton.setVisible(false);
                        }
                }
                for (int i = 0; i < wishlist.size(); i++) {
                        if (wishlist.get(i).getGame_key() == id) {
                                wishlistButton.setText("In Wishlist");
                        }
                }
                for (int i = 0; i < cart.size(); i++) {
                        if (cart.get(i).getGame_key() == id) {
                                addToCartButton.setText("In Cart");
                        }
                }
        }

        public void loadReview(List<Review> reviews) {
                if (!reviews.isEmpty()) {
                        int k = 0;
                        for (int i = 0; i < reviews.size(); i++) {
                                Label userLabel1 = new Label();
                                userLabel1.setText(reviews.get(i).getUser_key());
                                TextArea userReviewTextArea = new TextArea();
                                userReviewTextArea.setText(reviews.get(i).getReview_comment());
                                Label rating = new Label(reviews.get(i).getReview_stars() + "/5 STARS");
                                userReviewTextArea.getStyleClass().add("user-review-text-area");
                                userReviewTextArea.setPrefWidth(1050);
                                userReviewTextArea.setPrefHeight(70);
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
                                gridReview.add(userLabel1, 0, i + k);
                                gridReview.add(userReviewTextArea, 0, i + k + 1);
                                gridReview.add(rating, 1, i + k);
                                gridReview.setMaxSize(1125, 20);
                                k += 2;
                                GridPane.setMargin(gridReview, new Insets(-50, 0, 30, 80));
                                GridPane.setMargin(userLabel1, new Insets(5, 0, 0, 30));
                                GridPane.setMargin(userReviewTextArea, new Insets(-10, 0, 20, 50));
                                GridPane.setMargin(rating, new Insets(28, 0, 20, -1000));
                        }
                }
        }

        public int getStars() {
                return clickedIndex + 1;
        }

        public String getText() {
                return userInputArea.getText();
        }

        public int getID() {
                return id;
        }

        public String getName() {
                return this.searchField.getText();
        }

}