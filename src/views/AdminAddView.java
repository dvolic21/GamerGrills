package views;
import java.util.*;
import javafx.collections.FXCollections;
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

public class AdminAddView {

    public String css = this.getClass().getResource("/media/style2.css").toExternalForm();
    private TextField gameName = new TextField();
    private TextField publisherName = new TextField();
    private TextField addGames = new TextField("ADD");
    private TextField gameImageUrl = new TextField();
    private TextField rating = new TextField();
    private TextField developer = new TextField();
    private TextField priceField = new TextField();
    private TextField releaseDateField = new TextField();
    private TextField currency = new TextField();
    private TextField sale = new TextField();
    private TextField salePercentage = new TextField();
    private TextField saleStart = new TextField();
    private TextField saleEnd = new TextField();
    private TextArea descriptionArea = new TextArea();
    private TextField operatingSystem = new TextField();
    private TextField processor = new TextField();
    private TextField memory = new TextField();
    private TextField storage = new TextField();
    private TextField graphics = new TextField();
    private TextField directX = new TextField();
    private Label gamesLabel = new Label("Games");
    private Label libraryLabel = new Label("Library");
    private Label profileLabel = new Label("Profile");
    private Label wishlistLabel = new Label("Wishlist");
    private Label cartLabel = new Label("Cart");
    private Label addRemove = new Label("Add/Remove");
    private Map<CheckBox, String> gameGenres = new HashMap<>();

    String rRating[] = { "E", "T", "M", "RP" };

    ComboBox<String> rRatingComboBox = new ComboBox<String>(FXCollections.observableArrayList(rRating));
    private ImageView userImage = new ImageView(new Image(getClass().getResourceAsStream("/media/User1.png")));

    public AdminAddView(Stage _stage) {
        VBox vbox = new VBox();
        vbox.setMaxWidth(Double.MAX_VALUE);
        ScrollPane root = new ScrollPane(vbox);
        root.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        root.setFitToWidth(true);

        rRatingComboBox.setPromptText("R-Rating");

        developer.getStyleClass().add("text-field");
        developer.setPrefHeight(50);
        developer.setPrefWidth(200); // Update preferred width to match "priceField"
        developer.setBorder(new Border(
                new BorderStroke(Color.valueOf("#000000"), BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
        developer.setPromptText("Developer");
        developer.setOnMouseClicked(e -> {
            if (developer.getText().equals(developer.getPromptText())) {
                developer.setText("");
            }
        });

        priceField.getStyleClass().add("text-field");
        priceField.setPrefHeight(50);
        priceField.setPrefWidth(200);
        priceField.setBorder(new Border(
                new BorderStroke(Color.valueOf("#000000"), BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
        priceField.setPromptText("Price");
        priceField.setOnMouseClicked(e -> {
            if (priceField.getText().equals(priceField.getPromptText())) {
                priceField.setText("");
            }
        });

        releaseDateField.getStyleClass().add("text-field");
        releaseDateField.setPrefHeight(50);
        releaseDateField.setPrefWidth(200);
        releaseDateField.setBorder(new Border(
                new BorderStroke(Color.valueOf("#000000"), BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
        releaseDateField.setPromptText("Release Date");
        releaseDateField.setOnMouseClicked(e -> {
            if (releaseDateField.getText().equals(releaseDateField.getPromptText())) {
                releaseDateField.setText("");
            }
        });

        addGames.getStyleClass().add("text-field");
        addGames.setPrefHeight(50);
        addGames.setPrefWidth(200);
        addGames.setBorder(new Border(
                new BorderStroke(Color.valueOf("#000000"), BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
        addGames.setPromptText("Release Date");
        addGames.setOnMouseClicked(e -> {
            if (addGames.getText().equals(addGames.getPromptText())) {
                addGames.setText("");
            }
        });

        gameName.getStyleClass().add("text-field");
        gameName.setPrefHeight(50);
        gameName.setPrefWidth(200);
        gameName.setBorder(new Border(
                new BorderStroke(Color.valueOf("#000000"), BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
        gameName.setPromptText("Game Name");
        gameName.setOnMouseClicked(e -> {
            if (gameName.getText().equals(gameName.getPromptText())) {
                gameName.setText("");
            }
        });
        publisherName.getStyleClass().add("text-field");
        publisherName.setPrefHeight(50);
        publisherName.setPrefWidth(200);
        publisherName.setBorder(new Border(
                new BorderStroke(Color.valueOf("#000000"), BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
        publisherName.setPromptText("Publisher Name");
        publisherName.setOnMouseClicked(e -> {
            if (publisherName.getText().equals(publisherName.getPromptText())) {
                publisherName.setText("");
            }
        });

        gameImageUrl.getStyleClass().add("text-field");
        gameImageUrl.setPrefHeight(50);
        gameImageUrl.setPrefWidth(200);
        gameImageUrl.setBorder(new Border(
                new BorderStroke(Color.valueOf("#000000"), BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
        gameImageUrl.setPromptText("Image Url");
        gameImageUrl.setOnMouseClicked(e -> {
            if (gameImageUrl.getText().equals(gameImageUrl.getPromptText())) {
                gameImageUrl.setText("");
            }
        });

        currency.getStyleClass().add("text-field");
        currency.setPrefHeight(50);
        currency.setPrefWidth(200);
        currency.setBorder(new Border(
                new BorderStroke(Color.valueOf("#000000"), BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
        currency.setPromptText("Currency");
        currency.setOnMouseClicked(e -> {
            if (currency.getText().equals(currency.getPromptText())) {
                currency.setText("");
            }
        });
        sale.getStyleClass().add("text-field");
        sale.setPrefHeight(50);
        sale.setPrefWidth(200);
        sale.setBorder(new Border(
                new BorderStroke(Color.valueOf("#000000"), BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
        sale.setPromptText("Sale(yes/no)");
        sale.setOnMouseClicked(e -> {
            if (sale.getText().equals(sale.getPromptText())) {
                sale.setText("");
            }
        });
        salePercentage.getStyleClass().add("text-field");
        salePercentage.setPrefHeight(50);
        salePercentage.setPrefWidth(200);
        salePercentage.setBorder(new Border(
                new BorderStroke(Color.valueOf("#000000"), BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
        salePercentage.setPromptText("Sale percentage");
        salePercentage.setOnMouseClicked(e -> {
            if (salePercentage.getText().equals(salePercentage.getPromptText())) {
                salePercentage.setText("");
            }
        });

        saleStart.getStyleClass().add("text-field");
        saleStart.setPrefHeight(50);
        saleStart.setPrefWidth(200);
        saleStart.setBorder(new Border(
                new BorderStroke(Color.valueOf("#000000"), BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
        saleStart.setPromptText("Sale start Date");
        saleStart.setOnMouseClicked(e -> {
            if (saleStart.getText().equals(saleStart.getPromptText())) {
                saleStart.setText("");
            }
        });

        saleEnd.getStyleClass().add("text-field");
        saleEnd.setPrefHeight(50);
        saleEnd.setPrefWidth(200);
        saleEnd.setBorder(new Border(
                new BorderStroke(Color.valueOf("#000000"), BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
        saleEnd.setPromptText("Sale end Date");
        saleEnd.setOnMouseClicked(e -> {
            if (saleEnd.getText().equals(saleEnd.getPromptText())) {
                saleEnd.setText("");
            }
        });

        rating.getStyleClass().add("text-field");
        rating.setPrefHeight(50);
        rating.setPrefWidth(200);
        rating.setBorder(new Border(
                new BorderStroke(Color.valueOf("#000000"), BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
        rating.setPromptText("Rating('E', 'T', 'M', 'RP')");
        rating.setOnMouseClicked(e -> {
            if (rating.getText().equals(rating.getPromptText())) {
                rating.setText("");
            }
        });

        operatingSystem.getStyleClass().add("text-field");
        operatingSystem.setPrefHeight(50);
        operatingSystem.setPrefWidth(200);
        operatingSystem.setBorder(new Border(
                new BorderStroke(Color.valueOf("#000000"), BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
        operatingSystem.setPromptText("Operating System");
        operatingSystem.setOnMouseClicked(e -> {
            if (operatingSystem.getText().equals(operatingSystem.getPromptText())) {
                operatingSystem.setText("");
            }
        });

        processor.getStyleClass().add("text-field");
        processor.setPrefHeight(50);
        processor.setPrefWidth(200);
        processor.setBorder(new Border(
                new BorderStroke(Color.valueOf("#000000"), BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
        processor.setPromptText("Processor");
        processor.setOnMouseClicked(e -> {
            if (processor.getText().equals(processor.getPromptText())) {
                processor.setText("");
            }
        });

        memory.getStyleClass().add("text-field");
        memory.setPrefHeight(50);
        memory.setPrefWidth(200);
        memory.setBorder(new Border(
                new BorderStroke(Color.valueOf("#000000"), BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
        memory.setPromptText("Ram Memory");
        memory.setOnMouseClicked(e -> {
            if (memory.getText().equals(memory.getPromptText())) {
                memory.setText("");
            }
        });

        storage.getStyleClass().add("text-field");
        storage.setPrefHeight(50);
        storage.setPrefWidth(200);
        storage.setBorder(new Border(
                new BorderStroke(Color.valueOf("#000000"), BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
        storage.setPromptText("Storage space");
        storage.setOnMouseClicked(e -> {
            if (storage.getText().equals(storage.getPromptText())) {
                storage.setText("");
            }
        });

        graphics.getStyleClass().add("text-field");
        graphics.setPrefHeight(50);
        graphics.setPrefWidth(200);
        graphics.setBorder(new Border(
                new BorderStroke(Color.valueOf("#000000"), BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
        graphics.setPromptText("Graphics Card");
        graphics.setOnMouseClicked(e -> {
            if (graphics.getText().equals(graphics.getPromptText())) {
                graphics.setText("");
            }
        });

        directX.getStyleClass().add("text-field");
        directX.setPrefHeight(50);
        directX.setPrefWidth(200);
        directX.setBorder(new Border(
                new BorderStroke(Color.valueOf("#000000"), BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
        directX.setPromptText("DirectX");
        directX.setOnMouseClicked(e -> {
            if (directX.getText().equals(directX.getPromptText())) {
                directX.setText("");
            }
        });

        Text gameProperties = new Text("Game Properties");
        Text releaseDate = new Text("Release Date");
        Text publisherProperties = new Text("Publisher Properties");
        Text priceProperties = new Text("Price Properties");
        Text saleProperties = new Text("Sale Properties");
        Text saleDates = new Text("Sale Date");
        Text rRating = new Text("R Rating");
        Text genreLabel = new Text("Genre");
        Label actionLabel = new Label("Action");
        Label sportsLabel = new Label("Sports");
        Label adventureLabel = new Label("Adventure");
        Label battleRoyalLabel = new Label("Battle Royal");
        Label rolePlayLabel = new Label("Role-Play");
        Label racingLabel = new Label("Racing");
        Label fightingLabel = new Label("Fighting");
        Label realTimeStrategyLabel = new Label("Real-Time Strategy");
        Text descriptionLabel = new Text("Description:");
        Text specificationsLabel = new Text("Specifications:");

        descriptionLabel.getStyleClass().add("labels-admin");
        specificationsLabel.getStyleClass().add("labels-admin");
        genreLabel.getStyleClass().add("labels-admin");
        gameProperties.getStyleClass().add("labels-admin");
        releaseDate.getStyleClass().add("labels-admin");
        publisherProperties.getStyleClass().add("labels-admin");
        priceProperties.getStyleClass().add("labels-admin");
        saleProperties.getStyleClass().add("labels-admin");
        saleDates.getStyleClass().add("labels-admin");
        rRating.getStyleClass().add("labels-admin");

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

        gameGenres.put(genre1, "Action");
        gameGenres.put(genre2, "Sports");
        gameGenres.put(genre3, "Adventure");
        gameGenres.put(genre4, "Battle Royal");
        gameGenres.put(genre5, "Role-Play");
        gameGenres.put(genre6, "Racing");
        gameGenres.put(genre7, "Fighting");
        gameGenres.put(genre8, "Real-Time Strategy");

        addGames.getStyleClass().add("sign-in-text-field4");
        addGames.setAlignment(Pos.CENTER);
        addGames.setEditable(false);
        addGames.setOnMouseClicked(e -> {

        });

        ImageView lineImage = new ImageView(new Image(getClass().getResourceAsStream("/media/line.png")));
        lineImage.setFitWidth(2);
        lineImage.setFitHeight(60);


        userImage.setFitWidth(50);
        userImage.setFitHeight(50);

        userImage.setOnMouseEntered(event -> {

            userImage.setImage(new Image(getClass().getResourceAsStream("/media/User2.png")));
        });

        userImage.setOnMouseExited(event -> {
            userImage.setImage(new Image(getClass().getResourceAsStream("/media/User1.png")));
        });

        GridPane gridPaneNav = new GridPane();
        gridPaneNav.setPadding(new Insets(20, 0, 20, 60));
        gridPaneNav.setHgap(10);

        gridPaneNav.getStyleClass().addAll("text");
        gamesLabel.getStyleClass().add("label1");
        libraryLabel.getStyleClass().add("label1");
        profileLabel.getStyleClass().add("label1");
        wishlistLabel.getStyleClass().add("label1");
        cartLabel.getStyleClass().add("label1");
        addRemove.getStyleClass().add("label1");

        gridPaneNav.add(gamesLabel, 0, 0);
        gridPaneNav.add(libraryLabel, 1, 0);
        gridPaneNav.add(profileLabel, 2, 0);
        gridPaneNav.add(addRemove, 3, 0);
        gridPaneNav.add(wishlistLabel, 5, 0);
        gridPaneNav.add(cartLabel, 6, 0);
        gridPaneNav.add(lineImage, 7, 0);
        gridPaneNav.add(userImage, 8, 0);

        GridPane.setMargin(gamesLabel, new Insets(0, 0, 0, 0));
        GridPane.setMargin(libraryLabel, new Insets(0, 0, 0, 40));
        GridPane.setMargin(profileLabel, new Insets(0, 0, 0, 40));
        GridPane.setMargin(addRemove, new Insets(0, 0, 0, 40));
        GridPane.setMargin(wishlistLabel, new Insets(0, 0, 0, 490));
        GridPane.setMargin(cartLabel, new Insets(0, 0, 0, 60));
        GridPane.setMargin(lineImage, new Insets(0, 0, 0, 60));
        GridPane.setMargin(userImage, new Insets(0, 0, 0, 35));

        HBox hBox = new HBox();

        GridPane gridGames = new GridPane();
        gridGames.setVgap(10);
        gridGames.setHgap(10);
        gridGames.setPrefWidth(500);
        gridGames.add(gameProperties, 0, 0);
        gridGames.add(gameName, 0, 1);
        gridGames.add(gameImageUrl, 1, 1);
        gridGames.add(releaseDate, 0, 2);
        gridGames.add(releaseDateField, 0, 3);
        gridGames.add(publisherProperties, 0, 4);
        gridGames.add(publisherName, 0, 5);
        gridGames.add(developer, 1, 5);
        gridGames.add(priceProperties, 0, 6);
        gridGames.add(priceField, 0, 7);
        gridGames.add(currency, 1, 7);
        gridGames.add(saleProperties, 0, 8);
        gridGames.add(sale, 0, 9);
        gridGames.add(salePercentage, 1, 9);
        gridGames.add(saleDates, 0, 10);
        gridGames.add(saleStart, 0, 11);
        gridGames.add(saleEnd, 1, 11);
        gridGames.add(rRating, 0, 12);
        gridGames.add(rRatingComboBox, 0, 13);
        gridGames.add(genreLabel, 0, 14);

        gridGames.add(actionLabel, 0, 15);
        gridGames.add(sportsLabel, 0, 16);
        gridGames.add(adventureLabel, 0, 17);
        gridGames.add(battleRoyalLabel, 0, 18);
        gridGames.add(rolePlayLabel, 0, 19);
        gridGames.add(racingLabel, 0, 20);
        gridGames.add(fightingLabel, 0, 21);
        gridGames.add(realTimeStrategyLabel, 0, 22);

        gridGames.add(genre1, 1, 15);
        gridGames.add(genre2, 1, 16);
        gridGames.add(genre3, 1, 17);
        gridGames.add(genre4, 1, 18);
        gridGames.add(genre5, 1, 19);
        gridGames.add(genre6, 1, 20);
        gridGames.add(genre7, 1, 21);
        gridGames.add(genre8, 1, 22);

        GridPane.setMargin(gameProperties, new Insets(21, 0, 0, 100));
        GridPane.setMargin(releaseDate, new Insets(21, 0, 0, 100));
        GridPane.setMargin(publisherProperties, new Insets(21, 0, 0, 100));
        GridPane.setMargin(priceProperties, new Insets(21, 0, 0, 100));
        GridPane.setMargin(saleProperties, new Insets(21, 0, 0, 100));
        GridPane.setMargin(saleDates, new Insets(21, 0, 0, 100));
        GridPane.setMargin(rRating, new Insets(21, 0, 0, 100));
        GridPane.setMargin(gameName, new Insets(10, 0, 0, 100));
        GridPane.setMargin(publisherName, new Insets(10, 0, 0, 100));
        GridPane.setMargin(gameImageUrl, new Insets(10, 0, 0, 20));
        GridPane.setMargin(rRatingComboBox, new Insets(10, 0, 0, 100));
        GridPane.setMargin(developer, new Insets(10, 0, 0, 20));
        GridPane.setMargin(priceField, new Insets(10, 0, 0, 100));
        GridPane.setMargin(currency, new Insets(10, 0, 0, 20));
        GridPane.setMargin(sale, new Insets(10, 0, 0, 100));
        GridPane.setMargin(salePercentage, new Insets(10, 0, 0, 20));
        GridPane.setMargin(saleStart, new Insets(10, 0, 0, 100));
        GridPane.setMargin(saleEnd, new Insets(10, 0, 0, 20));
        GridPane.setMargin(releaseDateField, new Insets(10, 0, 0, 100));
        GridPane.setMargin(genreLabel, new Insets(21, 0, 0, 100));
        GridPane.setMargin(actionLabel, new Insets(21, 0, 0, 100));
        GridPane.setMargin(sportsLabel, new Insets(21, 0, 0, 100));
        GridPane.setMargin(adventureLabel, new Insets(21, 0, 0, 100));
        GridPane.setMargin(battleRoyalLabel, new Insets(21, 0, 0, 100));
        GridPane.setMargin(rolePlayLabel, new Insets(21, 0, 0, 100));
        GridPane.setMargin(racingLabel, new Insets(21, 0, 0, 100));
        GridPane.setMargin(fightingLabel, new Insets(21, 0, 0, 100));
        GridPane.setMargin(realTimeStrategyLabel, new Insets(21, 0, 30, 100));
        GridPane.setMargin(genre1, new Insets(21, 0, 0, 0));
        GridPane.setMargin(genre2, new Insets(21, 0, 0, 0));
        GridPane.setMargin(genre3, new Insets(21, 0, 0, 0));
        GridPane.setMargin(genre4, new Insets(21, 0, 0, 0));
        GridPane.setMargin(genre5, new Insets(21, 0, 0, 0));
        GridPane.setMargin(genre6, new Insets(21, 0, 0, 0));
        GridPane.setMargin(genre7, new Insets(21, 0, 0, 0));
        GridPane.setMargin(genre8, new Insets(0, 0, 0, 0));

        GridPane.setVgrow(developer, Priority.ALWAYS);
        GridPane.setVgrow(priceField, Priority.ALWAYS);
        GridPane.setVgrow(releaseDateField, Priority.ALWAYS);

        GridPane gridFields = new GridPane();
        gridFields.add(descriptionLabel, 0, 0);
        gridFields.add(specificationsLabel, 0, 2);
        gridFields.add(descriptionArea, 0, 1);
        gridFields.add(operatingSystem, 0, 3);
        gridFields.add(processor, 0, 4);
        gridFields.add(memory, 0, 5);
        gridFields.add(storage, 0, 6);
        gridFields.add(graphics, 0, 7);
        gridFields.add(directX, 0, 8);
        gridFields.add(addGames, 0, 9);
        GridPane.setMargin(descriptionLabel, new Insets(21, 10, 0, 200));
        GridPane.setMargin(descriptionArea, new Insets(10, 10, 0, 200));
        GridPane.setMargin(specificationsLabel, new Insets(21, 10, 0, 200));
        GridPane.setMargin(operatingSystem, new Insets(10, 10, 0, 200));
        GridPane.setMargin(processor, new Insets(10, 10, 0, 200));
        GridPane.setMargin(memory, new Insets(10, 10, 0, 200));
        GridPane.setMargin(storage, new Insets(10, 10, 0, 200));
        GridPane.setMargin(graphics, new Insets(10, 10, 0, 200));
        GridPane.setMargin(directX, new Insets(10, 10, 0, 200));

        descriptionArea.setWrapText(true);
        descriptionArea.setPrefColumnCount(1);
        descriptionArea.setPrefWidth(400);
        descriptionArea.setMinHeight(Region.USE_PREF_SIZE);
        descriptionArea.setMaxHeight(Region.USE_PREF_SIZE);
        descriptionArea.setPrefHeight(400);

        GridPane.setMargin(addGames, new Insets(50, 10, 0, 200));
        hBox.getChildren().addAll(gridGames, gridFields);
        vbox.getChildren().addAll(gridPaneNav, hBox);
        Scene scene = new Scene(root, 1300, 650);
        scene.getStylesheets().add(css);
        _stage.setTitle("Gamer Grills");
        _stage.setResizable(false);
        _stage.setScene(scene);
        _stage.show();
    }

    public void addAddGameHandler(EventHandler<MouseEvent> event) {
        addGames.setOnMouseClicked(event);
    }

    public String getGameName() {
        return this.gameName.getText().trim();
    }

    public String getGameImgUrl() {
        return this.gameImageUrl.getText().trim();
    }

    public String getReleaseDate() {
        return this.releaseDateField.getText().trim();
    }

    public String getRating() {
        return rRatingComboBox.getValue();
    }

    public String getPublisherName() {
        return this.publisherName.getText().trim();
    }

    public String getDeveloper() {
        return this.developer.getText().trim();
    }

    public String getPrice() {
        return this.priceField.getText().trim();
    }

    public String getCurrency() {
        return this.currency.getText().trim();
    }

    public String getSale() {
        return this.sale.getText().trim();
    }

    public String getSalePercentage() {
        return this.salePercentage.getText().trim();
    }

    public String getStartDate() {
        return this.saleStart.getText().trim();
    }

    public String getEndDate() {
        return this.saleEnd.getText().trim();
    }

    public String getDescription() {
        return this.descriptionArea.getText().trim();
    }

    public String getOS() {
        return this.operatingSystem.getText().trim();
    }

    public String getProcessor() {
        return this.processor.getText().trim();
    }

    public String getRamMemory() {
        return this.memory.getText().trim();
    }

    public String getStorageSpace() {
        return this.storage.getText().trim();
    }

    public String getGraphicsCard() {
        return this.graphics.getText().trim();
    }

    public String getDirectX() {
        return this.directX.getText().trim();
    }

    public List<String> getPickedGenres() {
        ArrayList<String> pickedGenresArray = new ArrayList<>();
        for (Map.Entry<CheckBox, String> element : gameGenres.entrySet()) {
            if (element.getKey().isSelected())
                pickedGenresArray.add(element.getValue());

        }
        return pickedGenresArray;
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
        addRemove.setOnMouseClicked(event);
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


}
