package views;
import java.util.*;
import java.util.Map.Entry;

import database.Game;
import javafx.animation.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.*;
import javafx.event.*;
import javafx.scene.*;

public class GGView {

    public String css = this.getClass().getResource("/media/style2.css").toExternalForm();
    private Label gamesLabel = new Label("Games");
    private Label libraryLabel = new Label("Library");
    private Label profileLabel = new Label("Profile");
    private Label wishlistLabel = new Label("Wishlist");
    private Label adminLabel = new Label("Add/Remove");
    private Label cartLabel = new Label("Cart");
    private Label gamesListLabel = new Label("GAMES ON SALE");
    private ImageView searchImage = new ImageView(new Image(getClass().getResourceAsStream("/media/image.png")));

    private GridPane gridGamesLabel = new GridPane();
    private GridPane gridPaneNav = new GridPane();
    private GridPane gridGames = new GridPane();

    private Map<Integer, Label> gameLabels = new HashMap<>();
    private Map<Integer, Label> priceLabels = new HashMap<>();
    private Map<Integer, ImageView> allImages = new HashMap<>();
    private Map<ImageView, Integer> allIDs = new HashMap<>();
    private TextField searchField = new TextField();

    private static final String[] GAME_IMAGES = {
            "/media/loadImage.png",
            "/media/loadImage2.png",
            "/media/loadImage3.png",
            "/media/loadImage4.png"
    };
    private static final int SLIDE_DELAY = 5000;

    private int currentImageIndex = 0;
    private ImageView imageView;
    private ImageView nextImageView;
    private FadeTransition fadeOut;
    private FadeTransition fadeIn;

    private void handleMouseEvents(ImageView imageView) {
        double initialScaleX = 1.0;
        double initialScaleY = 1.0;
        double scaleFactor = 0.05;

        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(200), imageView);
        scaleTransition.setToX(initialScaleX + scaleFactor);
        scaleTransition.setToY(initialScaleY + scaleFactor);

        imageView.setOnMouseEntered(event -> {
            scaleTransition.playFromStart();
            imageView.setCursor(Cursor.HAND);
        });

        ScaleTransition scaleTransitionReset = new ScaleTransition(Duration.millis(200), imageView);
        scaleTransitionReset.setToX(initialScaleX);
        scaleTransitionReset.setToY(initialScaleY);

        imageView.setOnMouseExited(event -> {
            scaleTransitionReset.playFromStart();
            imageView.setCursor(Cursor.DEFAULT);
        });
    }

    public GGView(Stage _stage) {

        VBox vbox = new VBox();
        vbox.setMaxWidth(Double.MAX_VALUE);
        ScrollPane root = new ScrollPane(vbox);
        root.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        root.setFitToWidth(true);

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
        ImageView userImage = new ImageView(new Image(getClass().getResourceAsStream("/media/User1.png")));
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

        imageView = new ImageView(new Image(GAME_IMAGES[currentImageIndex]));
        imageView.setFitWidth(_stage.getWidth());
        nextImageView = new ImageView(new Image(GAME_IMAGES[(currentImageIndex + 1) % GAME_IMAGES.length]));
        nextImageView.setFitWidth(_stage.getWidth());

        fadeOut = new FadeTransition(Duration.millis(1000), imageView);
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);
        fadeOut.setOnFinished(e -> {
            imageView.setImage(nextImageView.getImage());
            imageView.setOpacity(1.0);
            nextImageView.setImage(new Image(GAME_IMAGES[(++currentImageIndex) % GAME_IMAGES.length]));
            nextImageView.setOpacity(0.0);
            fadeIn.play();
        });

        fadeIn = new FadeTransition(Duration.millis(1000), nextImageView);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);

        _stage.widthProperty().addListener((obs, oldVal, newVal) -> {
            imageView.setFitWidth(1300);
            nextImageView.setFitWidth(1300);
            imageView.setFitHeight(50);
            nextImageView.setFitHeight(50);
        });

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, e -> fadeOut.play()),
                new KeyFrame(Duration.millis(SLIDE_DELAY), e -> {
                }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        GridPane gridPaneGameLoad = new GridPane();
        gridPaneGameLoad.add(imageView, 0, 0);
        gridPaneGameLoad.add(nextImageView, 0, 0);

        gamesListLabel.getStyleClass().add("label-games-list");
        gamesListLabel.setStyle("-fx-font-size: 30px;");
        gridGamesLabel.add(gamesListLabel, 0, 0);

        GridPane.setMargin(gridGames, new Insets(10, 0, 0, 0));
        GridPane.setMargin(gamesListLabel, new Insets(40, 0, 0, 95));
        GridPane.setVgrow(gamesListLabel, Priority.ALWAYS);
        vbox.getChildren().addAll(gridPaneNav, gridPaneGameLoad, gridGamesLabel, gridGames);
        Scene scene = new Scene(root, 1300, 650);
        scene.getStylesheets().add(css);
        _stage.setTitle("Gamer Grills");
        _stage.setResizable(false);
        _stage.setScene(scene);
        _stage.show();
    }

    public void loadSlider() {

    }

    public void loadGame(List<Game> list) {
        loadData(5);
        String path;
        Image image;

        if (list.size() >= 5) {
            for (int i = 0; i < 5; i++) {
                this.gameLabels.get(i).setText(list.get(i).getGame_name());
                path = list.get(i).getGame_image();
                image = new Image(path);
                this.allImages.get(i).setImage(image);
                this.allIDs.put(this.allImages.get(i), list.get(i).getGame_id());
                this.priceLabels.get(i).setText(
                        list.get(i).getPrices().getPrice() + " " + list.get(i).getPrices().getCurrency());
            }
        }

    }

    public void loadData(int size) {
        int imageOffset = 1;
        int labelOffset = 2;
        int priceOffset = 3;
        for (int i = 0; i < size; i++) {
            Label nameLabel = new Label("Test");
            this.gameLabels.put(i, nameLabel);
            Label priceLabel = new Label("10$");
            this.priceLabels.put(i, priceLabel);
            nameLabel.setPrefWidth(130);
            nameLabel.setWrapText(true);
            ImageView gameView = new ImageView(new Image(getClass().getResourceAsStream("/media/game.png")));
            gameView.setPickOnBounds(true);
            this.allImages.put(i, gameView);
            gameView.setFitWidth(145);
            gameView.setFitHeight(205);
            handleMouseEvents(gameView);
            gridGames.add(gameView, i, imageOffset);
            gridGames.add(nameLabel, i, labelOffset);
            gridGames.add(priceLabel, i, priceOffset);
            GridPane.setMargin(gameView, new Insets(40, 0, 0, 95));
            GridPane.setMargin(nameLabel, new Insets(5, 0, 0, 95));
            GridPane.setMargin(priceLabel, new Insets(0, 0, 30, 95));
        }

    }

    public void pressedGameHandler(EventHandler<MouseEvent> event) {
        for (Entry<ImageView, Integer> pair : allIDs.entrySet()) {
            pair.getKey().setOnMouseClicked(event);
        }
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

    public void addCartHandler(EventHandler<MouseEvent> event) {
        cartLabel.setOnMouseClicked(event);
    }

    public int getID() {
        for (Entry<ImageView, Integer> pair : allIDs.entrySet()) {
            if (pair.getKey().isHover())
                return pair.getValue();
        }
        return -1;
    }

    public void createLabel() {
        GridPane.setMargin(adminLabel, new Insets(0, 0, 0, 40));
        adminLabel.getStyleClass().add("label1");
        gridPaneNav.add(adminLabel, 3, 0);
    }

    public String getName() {
        return this.searchField.getText();
    }
}
