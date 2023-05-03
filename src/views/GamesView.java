package views;
import java.util.*;
import java.util.Map.*;

import database.Game_Genre;
import javafx.animation.*;
import javafx.beans.value.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.stage.*;
import javafx.util.*;
import javafx.scene.*;

public class GamesView {

    public String css = this.getClass().getResource("/media/style2.css").toExternalForm();
    private GridPane gridGames = new GridPane();
    private Map<Integer, Label> gameLabels = new HashMap<>();
    private Map<Integer, Label> priceLabels = new HashMap<>();
    private Map<Integer, ImageView> allImages = new HashMap<>();
    private Map<ImageView, Integer> allIDs = new HashMap<>();
    private Map<CheckBox, String> allBoxes = new HashMap<>();
    private ToggleGroup group = new ToggleGroup();
    private GridPane filters;
    private TextField resetFilters;
    private TextField searchField;
    private Label libraryLabel = new Label("Library");
    private Label profileLabel = new Label("Profile");
    private Label wishlistLabel = new Label("Wishlist");
    private Label cartLabel = new Label("Cart");
    private GridPane gridPaneNav = new GridPane();
    private Label adminLabel = new Label("Add/Remove");
    private ImageView userImage = new ImageView(new Image(getClass().getResourceAsStream("/media/User1.png")));
    private ImageView searchImage = new ImageView(new Image(getClass().getResourceAsStream("/media/image.png")));

    private void handleMouseEvents(ImageView imageView) {
        double initialScaleX = 1.0;
        double initialScaleY = 1.0;
        double scaleFactor = 0.05;

        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(200), imageView);
        scaleTransition.setToX(initialScaleX + scaleFactor);
        scaleTransition.setToY(initialScaleY + scaleFactor);

        imageView.setOnMouseEntered(event -> {
            scaleTransition.playFromStart();
            imageView.setCursor(Cursor.HAND); // Set cursor to hand when mouse is hovered over
        });

        ScaleTransition scaleTransitionReset = new ScaleTransition(Duration.millis(200), imageView);
        scaleTransitionReset.setToX(initialScaleX);
        scaleTransitionReset.setToY(initialScaleY);

        imageView.setOnMouseExited(event -> {
            scaleTransitionReset.playFromStart();
            imageView.setCursor(Cursor.DEFAULT); // Set cursor back to default when mouse exits
        });
    }

    public GamesView(Stage _stage) {
        VBox vbox = new VBox();
        vbox.setMaxWidth(Double.MAX_VALUE);

        ScrollPane root = new ScrollPane(vbox);
        root.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        root.setFitToWidth(true);

        Label gamesLabel = new Label("Games");
       
        Text filtersLabel = new Text("FILTERS");

        Label priceLabel = new Label("Price");
        priceLabel.getStyleClass().add("genre");

        Label lowerToHigherLabel = new Label("Lower to Higher");
        lowerToHigherLabel.getStyleClass().add("genre-text");

        Label higherTOLowerLabel = new Label("Higher to Lower");
        higherTOLowerLabel.getStyleClass().add("genre-text");

        Label genreLabel = new Label("Genres");
        genreLabel.getStyleClass().add("genre");

        Label actionLabel = new Label("Action");
        actionLabel.getStyleClass().add("genre-text");

        Label sportsLabel = new Label("Sports");
        sportsLabel.getStyleClass().add("genre-text");

        Label adventureLabel = new Label("Adventure");
        adventureLabel.getStyleClass().add("genre-text");

        Label battleRoyalLabel = new Label("Battle Royal");
        battleRoyalLabel.getStyleClass().add("genre-text");

        Label rolePlayLabel = new Label("Role-Play");
        rolePlayLabel.getStyleClass().add("genre-text");

        Label racingLabel = new Label("Racing");
        racingLabel.getStyleClass().add("genre-text");

        Label fightingLabel = new Label("Fighting");
        fightingLabel.getStyleClass().add("genre-text");

        Label realTimeStrategyLabel = new Label("Real-Time Strategy");
        realTimeStrategyLabel.getStyleClass().add("genre-text");

        CheckBox genre1 = new CheckBox();
        genre1.setStyle(
                "-fx-font-size: 12px; -fx-scale-x: 0.8; -fx-scale-y: 0.8; -fx-border-color: #000000;-fx-border-width: 1px; -fx-background-color: transparent; -fx-padding: 0;");

        CheckBox genre2 = new CheckBox();
        genre2.setStyle(
                "-fx-font-size: 12px; -fx-scale-x: 0.8; -fx-scale-y: 0.8; -fx-border-color: #000000;-fx-border-width: 1px; -fx-background-color: transparent; -fx-padding: 0;");

        CheckBox genre3 = new CheckBox();
        genre3.setStyle(
                "-fx-font-size: 12px; -fx-scale-x: 0.8; -fx-scale-y: 0.8; -fx-border-color: #000000;-fx-border-width: 1px; -fx-background-color: transparent; -fx-padding: 0;");

        CheckBox genre4 = new CheckBox();
        genre4.setStyle(
                "-fx-font-size: 12px; -fx-scale-x: 0.8; -fx-scale-y: 0.8; -fx-border-color: #000000;-fx-border-width: 1px; -fx-background-color: transparent; -fx-padding: 0;");

        CheckBox genre5 = new CheckBox();
        genre5.setStyle(
                "-fx-font-size: 12px; -fx-scale-x: 0.8; -fx-scale-y: 0.8; -fx-border-color: #000000;-fx-border-width: 1px; -fx-background-color: transparent; -fx-padding: 0;");

        CheckBox genre6 = new CheckBox();
        genre6.setStyle(
                "-fx-font-size: 12px; -fx-scale-x: 0.8; -fx-scale-y: 0.8; -fx-border-color: #000000;-fx-border-width: 1px; -fx-background-color: transparent; -fx-padding: 0;");

        CheckBox genre7 = new CheckBox();
        genre7.setStyle(
                "-fx-font-size: 12px; -fx-scale-x: 0.8; -fx-scale-y: 0.8; -fx-border-color: #000000;-fx-border-width: 1px; -fx-background-color: transparent; -fx-padding: 0;");

        CheckBox genre8 = new CheckBox();
        genre8.setStyle(
                "-fx-font-size: 12px; -fx-scale-x: 0.8; -fx-scale-y: 0.8; -fx-border-color: #000000;-fx-border-width: 1px; -fx-background-color: transparent; -fx-padding: 0;");

        this.allBoxes = new HashMap<>();

        allBoxes.put(genre1, "Action");
        allBoxes.put(genre2, "Sports");
        allBoxes.put(genre3, "Adventure");
        allBoxes.put(genre4, "Battle Royal");
        allBoxes.put(genre5, "Role-Play");
        allBoxes.put(genre6, "Racing");
        allBoxes.put(genre7, "Fighting");
        allBoxes.put(genre8, "Real-Time Strategy");

        RadioButton radioButton1 = new RadioButton();

        radioButton1.setUserData("lower");
        RadioButton radioButton2 = new RadioButton();

        radioButton2.setUserData("higher");

        this.group = new ToggleGroup();
        radioButton1.setToggleGroup(group);
        radioButton2.setToggleGroup(group);

        this.searchField = new TextField();
        searchField.getStyleClass().add("text-field2");
        searchField.setPrefHeight(12);
        searchField.setPrefWidth(700);
        searchField.setPromptText("Search");
        searchField.setOnMouseClicked(e -> {
            if (searchField.getText().equals(searchField.getPromptText())) {
                searchField.setText("");
            }
        });

        searchImage.setFitWidth(44);
        searchImage.setFitHeight(44);
        Rectangle clip = new Rectangle(searchImage.getFitWidth(), searchImage.getFitHeight());
        clip.setArcWidth(50);
        clip.setArcHeight(50);
        searchImage.setClip(clip);
     

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

        this.resetFilters = new TextField("Reset Filters");
        resetFilters.getStyleClass().add("reset");
        resetFilters.setAlignment(Pos.CENTER);
        resetFilters.setEditable(false);

        gridPaneNav.setPadding(new Insets(20, 0, 20, 60));
        gridPaneNav.setHgap(10);

        gridPaneNav.getStyleClass().addAll("text");
        gamesLabel.getStyleClass().add("label2");
        libraryLabel.getStyleClass().add("label1");
        profileLabel.getStyleClass().add("label1");
        wishlistLabel.getStyleClass().add("label1");
        cartLabel.getStyleClass().add("label1");

        gridPaneNav.add(gamesLabel, 0, 0);
        gridPaneNav.add(libraryLabel, 1, 0);
        gridPaneNav.add(profileLabel, 2, 0);
        gridPaneNav.add(wishlistLabel, 5, 0);
        gridPaneNav.add(cartLabel, 6, 0);
        gridPaneNav.add(lineImage, 7, 0);
        gridPaneNav.add(userImage, 8, 0);

        GridPane.setMargin(gamesLabel, new Insets(0, 0, 0, 0));
        GridPane.setMargin(libraryLabel, new Insets(0, 0, 0, 20));
        GridPane.setMargin(profileLabel, new Insets(0, 0, 0, 20));
        GridPane.setMargin(wishlistLabel, new Insets(0, 0, 0, 550));
        GridPane.setMargin(cartLabel, new Insets(0, 0, 0, 40));
        GridPane.setMargin(lineImage, new Insets(0, 0, 0, 40));
        GridPane.setMargin(userImage, new Insets(0, 0, 0, 35));

        GridPane.setVgrow(gamesLabel, Priority.ALWAYS);
        GridPane.setVgrow(libraryLabel, Priority.ALWAYS);
        GridPane.setVgrow(profileLabel, Priority.ALWAYS);
        GridPane.setVgrow(wishlistLabel, Priority.ALWAYS);
        GridPane.setVgrow(cartLabel, Priority.ALWAYS);
        GridPane.setVgrow(lineImage, Priority.ALWAYS);
        GridPane.setVgrow(userImage, Priority.ALWAYS);

        GridPane searchGrid = new GridPane();
        searchGrid.add(searchField, 0, 0);
        searchGrid.add(searchImage, 0, 0);

        GridPane.setMargin(searchField, new Insets(100, 300, 0, 291));
        GridPane.setMargin(searchImage, new Insets(100, 0, 0, 937));

        this.filters = new GridPane();
        this.filters.setStyle("-fx-background-color: #424242; -fx-background-radius: 50;");
        filtersLabel.setStyle("-fx-font-size: 28; -fx-fill: white;-fx-font-weight: bold;");

        filters.add(filtersLabel, 0, 0);
        filters.add(priceLabel, 0, 1);
        filters.add(lowerToHigherLabel, 0, 2);
        filters.add(higherTOLowerLabel, 0, 3);
        filters.add(genreLabel, 0, 4);
        filters.add(actionLabel, 0, 5);
        filters.add(sportsLabel, 0, 6);
        filters.add(adventureLabel, 0, 7);
        filters.add(battleRoyalLabel, 0, 8);
        filters.add(rolePlayLabel, 0, 9);
        filters.add(racingLabel, 0, 10);
        filters.add(fightingLabel, 0, 11);
        filters.add(realTimeStrategyLabel, 0, 12);
        filters.add(genre1, 1, 5);
        filters.add(genre2, 1, 6);
        filters.add(genre3, 1, 7);
        filters.add(genre4, 1, 8);
        filters.add(genre5, 1, 9);
        filters.add(genre6, 1, 10);
        filters.add(genre7, 1, 11);
        filters.add(genre8, 1, 12);
        filters.add(radioButton1, 1, 2);
        filters.add(radioButton2, 1, 3);

        filters.add(resetFilters, 0, 13);
        GridPane.setMargin(filtersLabel, new Insets(20, 0, 0, 30));
        GridPane.setMargin(priceLabel, new Insets(20, 0, 0, 30));
        GridPane.setMargin(lowerToHigherLabel, new Insets(10, 0, 0, 30));
        GridPane.setMargin(higherTOLowerLabel, new Insets(5, 0, 0, 30));
        GridPane.setMargin(radioButton1, new Insets(10, 0, 0, -46));
        GridPane.setMargin(radioButton2, new Insets(5, 0, 0, -46));
        GridPane.setMargin(genreLabel, new Insets(20, 0, 0, 30));
        GridPane.setMargin(actionLabel, new Insets(10, 0, 0, 30));
        GridPane.setMargin(sportsLabel, new Insets(5, 0, 0, 30));
        GridPane.setMargin(adventureLabel, new Insets(5, 0, 0, 30));
        GridPane.setMargin(battleRoyalLabel, new Insets(5, 0, 0, 30));
        GridPane.setMargin(rolePlayLabel, new Insets(5, 0, 0, 30));
        GridPane.setMargin(racingLabel, new Insets(5, 0, 0, 30));
        GridPane.setMargin(fightingLabel, new Insets(5, 0, 0, 30));
        GridPane.setMargin(realTimeStrategyLabel, new Insets(5, 0, 0, 30));
        GridPane.setMargin(genre1, new Insets(10, 0, 0, -46));
        GridPane.setMargin(genre2, new Insets(5, 0, 0, -46));
        GridPane.setMargin(genre3, new Insets(5, 0, 0, -46));
        GridPane.setMargin(genre4, new Insets(5, 0, 0, -46));
        GridPane.setMargin(genre5, new Insets(5, 0, 0, -46));
        GridPane.setMargin(genre6, new Insets(5, 0, 0, -46));
        GridPane.setMargin(genre7, new Insets(5, 0, 0, -46));
        GridPane.setMargin(genre8, new Insets(5, 0, 0, -46));
        GridPane.setMargin(resetFilters, new Insets(40, 30, 0, 30));
        filters.setMinSize(200, 200);
        filters.setMaxSize(800, 540);
        HBox.setMargin(filters, new Insets(100, 0, 0, 30));
        HBox.setMargin(gridGames, new Insets(0, 0, 0, 25));
        HBox filtersAndGames = new HBox(filters, gridGames);

        vbox.getChildren().addAll(gridPaneNav, searchGrid, filtersAndGames);
        Scene scene = new Scene(root, 1300, 650);
        scene.getStylesheets().add(css);
        _stage.setTitle("Gamer Grills");
        _stage.setResizable(false);
        _stage.setScene(scene);
        _stage.show();
    }

    public void loadGame(List<Game_Genre> list, boolean ifFilter) {
        if (!ifFilter) {
            loadData(list.size());
        }
        loadGame(list);
    }

    public void loadGame(List<Game_Genre> list) {
        String path;
        Image image;
        for (int i = 0; i < list.size(); i++) {
            this.gameLabels.get(i).setText(list.get(i).getGame().getGame_name());
            path = list.get(i).getGame().getGame_image();
            if (!path.equals(allImages.get(i).getImage().getUrl())) {
                image = new Image(path);
                this.allImages.get(i).setImage(image);
                this.allImages.get(i).setCache(true);
                this.allImages.get(i).setCacheHint(CacheHint.SPEED);
            }
            this.allIDs.put(this.allImages.get(i), list.get(i).getGame_id());
            this.priceLabels.get(i).setText(list.get(i).getGame().getPrices().getPrice() + " "
                    + list.get(i).getGame().getPrices().getCurrency());
            if (!this.gameLabels.get(i).isVisible()) {
                this.gameLabels.get(i).setVisible(true);
                this.allImages.get(i).setVisible(true);
                this.priceLabels.get(i).setVisible(true);
            }
        }
        if (gameLabels.size() > list.size()) {
            for (int i = list.size(); i < gameLabels.size(); i++) {
                this.gameLabels.get(i).setVisible(false);
                this.allImages.get(i).setVisible(false);
                this.priceLabels.get(i).setVisible(false);
            }
        }
    }

    private void loadData(int size) {
        int col = 0;
        int row = 0;
        int labelRowOffset = 1;
        int priceRowOffset = 2;
        for (int i = 0; i < size; i++) {
            Label nameLabel = new Label("Test");
            this.gameLabels.put(i, nameLabel);
            nameLabel.setPrefWidth(135);
            nameLabel.setWrapText(true);
            Label priceLabel = new Label("10$");
            this.priceLabels.put(i, priceLabel);
            ImageView gameView = new ImageView(new Image(getClass().getResourceAsStream("/media/game.png")));
            this.allImages.put(i, gameView);
            gameView.setFitWidth(130);
            gameView.setFitHeight(170);
            handleMouseEvents(gameView);
            gridGames.add(gameView, col, row);
            GridPane.setMargin(gameView, new Insets(100, 0, 0,74));
            gridGames.add(nameLabel, col, row + labelRowOffset);
            GridPane.setMargin(nameLabel, new Insets(5, 0, 0, 74));
            gridGames.add(priceLabel, col, row + priceRowOffset);
            GridPane.setMargin(priceLabel, new Insets(0, 0, 10, 74));
            col++;
            if (col > 3) {
                col = 0;
                row += 3;
            }
        }
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

    

    public void addWishlistHandler(EventHandler<MouseEvent> event) {
        wishlistLabel.setOnMouseClicked(event);
    }

    public void addCartHandler(EventHandler<MouseEvent> event) {
        cartLabel.setOnMouseClicked(event);
    }

    public void addToggleGroupHandler(ChangeListener<Toggle> event) {
        group.selectedToggleProperty().addListener(event);
    }

    public void addResetHandler(EventHandler<MouseEvent> event) {
        this.resetFilters.setOnMousePressed(event);
    }

    public void addGGIconHandler(EventHandler<MouseEvent> event) {
        userImage.setOnMouseClicked(event);
    }

    public void resetFilters() {
        for (Map.Entry<CheckBox, String> pair : allBoxes.entrySet()) {
            pair.getKey().setSelected(false);
        }
        if(group.getSelectedToggle()!=null){
            group.getSelectedToggle().setSelected(false);
        }
    }

    public void addCheckBoxListener(ChangeListener<Boolean> event) {
        for (Map.Entry<CheckBox, String> pair : allBoxes.entrySet()) {
            pair.getKey().selectedProperty().addListener(event);
        }
    }

    public void addSearchListener(ChangeListener<String> event) {
        this.searchField.textProperty().addListener(event);
    }

    public Toggle getSelectedToggle() {
        return this.group.getSelectedToggle();
    }

    public String getSearch() {
        return this.searchField.getText();
    }

    public List<String> getSelectedCheckboxes() {
        List<String> selectedCheckboxes = new ArrayList<>();
        for (Node node : this.filters.getChildrenUnmodifiable()) {
            if (node instanceof CheckBox) {
                CheckBox checkbox = (CheckBox) node;
                if (checkbox.isSelected()) {
                    selectedCheckboxes.add(allBoxes.get(checkbox));
                }
            }
        }
        return selectedCheckboxes;
    }

    public void pressedGameHandler(EventHandler<MouseEvent> event) {
        for (Entry<ImageView, Integer> pair : allIDs.entrySet()) {
            pair.getKey().setOnMouseClicked(event);
        }
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
  
}
