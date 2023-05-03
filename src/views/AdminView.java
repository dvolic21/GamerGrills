package views;
import java.util.*;
import java.util.Map.Entry;

import database.Game;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.scene.*;

public class AdminView {

    public String css = this.getClass().getResource("/media/style2.css").toExternalForm();
    private TextField addGames = new TextField("ADD");
    private Label gamesLabel = new Label("Games");
    private Label libraryLabel = new Label("Library");
    private Label profileLabel = new Label("Profile");
    private Label wishlistLabel = new Label("Wishlist");
    private Label cartLabel = new Label("Cart");
    private Label addRemove = new Label("Add/Remove");
    private ImageView userImage = new ImageView(new Image(getClass().getResourceAsStream("/media/User1.png")));
    private GridPane gridGames = new GridPane();
    private Map<TextField, Integer> allDelete = new HashMap<>();

    public AdminView(Stage _stage) {
        VBox vbox = new VBox();
        vbox.setMaxWidth(Double.MAX_VALUE);
        ScrollPane root = new ScrollPane(vbox);
        root.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        root.setFitToWidth(true);

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
        addGames.getStyleClass().add("sign-in-text-field3");
        addGames.setAlignment(Pos.CENTER);
        GridPane.setMargin(addGames, new Insets(100, 20, 0, 550));

        vbox.getChildren().addAll(gridPaneNav, gridGames);
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

    public void addDeleteGameHandler(EventHandler<MouseEvent> event) {
        for (Entry<TextField, Integer> pair : allDelete.entrySet()) {
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

    public void addWishlistHandler(EventHandler<MouseEvent> event) {
        wishlistLabel.setOnMouseClicked(event);
    }

    public void addCartHandler(EventHandler<MouseEvent> event) {
        cartLabel.setOnMouseClicked(event);
    }

    public void addGGIconHandler(EventHandler<MouseEvent> event) {
        userImage.setOnMouseClicked(event);
    }

    public void addGames(List<Game> games) {
        for (int i = 0; i < games.size(); i++) {
            Label game = new Label(games.get(i).getGame_name());
            TextField delete = new TextField("Delete");
            delete.getStyleClass().add("sign-in-text-field2");
            delete.setAlignment(Pos.CENTER);
            delete.setEditable(false);
            allDelete.put(delete, games.get(i).getGame_id());
            gridGames.add(game, 0, i);
            gridGames.add(delete, 1, i);
            GridPane.setMargin(game, new Insets(10, 0, 0, 20));
            GridPane.setMargin(delete, new Insets(10, 20, 0, 550));
            GridPane.setHgrow(game, Priority.ALWAYS);
        }
        gridGames.add(addGames, 1, games.size() + 2);
    }

    public int getID() {
        for (Entry<TextField, Integer> pair : allDelete.entrySet()) {
            if (pair.getKey().isHover())
                return pair.getValue();
        }
        return -1;
    }
}
