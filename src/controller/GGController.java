package controller;

import java.io.*;
import java.util.*;

import database.Game;
import database.GameSales;
import database.Price;
import database.Publisher;
import database.Rating;
import database.ReleaseDate;
import database.SystemSpecs;
import database.TypeOfPayment;
import database.User;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.*;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.stage.*;
import model.GGDatabase;
import util.DLException;
import views.AdminAddView;
import views.AdminView;
import views.GGCart;
import views.GGGame;
import views.GGLibrary;
import views.GGPaymentView;
import views.GGProfile;
import views.GGView;
import views.GGWishlist;
import views.GamesView;
import views.PrivacyPolicy;
import views.SignIn;
import views.SignUp;
import views.ToS;

public class GGController {
    private GGDatabase database = null;
    private SignIn signInView = null;
    private SignUp signUpView = null;
    private GGView mainView = null;
    private AdminView adminView = null;
    private AdminAddView adminAddView = null;
    private GamesView gamesView = null;
    private GGGame gameView = null;
    private GGLibrary libraryView = null;
    private GGProfile profileView = null;
    private GGWishlist wishlistView = null;
    private GGCart cartView = null;
    private GGPaymentView paymentView = null;
    private ToS tosView = new ToS();
    private PrivacyPolicy privacyPolicyView = new PrivacyPolicy();
    private Stage stage = null;

    private User retrievedUser = null;

    public GGController(GGDatabase database, Stage stage) {
        this.database = database;
        this.stage = stage;

        if (new File("userinfo.xml").exists()) {
            signInView = new SignIn(stage);
            signInView.retrieveCredentials();
            retrievedUser = database.adminLogin(signInView.getUserID(), signInView.getPassword());
            makeMainView();
        } else
            makeSignInView();
    }

    private class SignInButtonHandler implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent event) {

            retrievedUser = database.adminLogin(signInView.getUserID(), signInView.getPassword());
            if (retrievedUser != null) {
                if (signInView.rememberUser())
                    signInView.createXml();

                makeMainView();
            } else if (signInView.getUserID().isEmpty() || signInView.getPassword().isEmpty()
                    || signInView.getUserID().length() < 4 || signInView.getUserID().length() > 15
                    || signInView.getPassword().length() < 6 || signInView.getPassword().length() > 14) {
                signInView.signInButtonClicked(event);
            } else {
                signInView.userNotRegistered(event);
            }

        }

    }

    private class SignOutButtonHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent event) {
            makeSignInView();
        }
    }

    private class SignUpLinkHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent event) {
            makeSignUpView();
        }
    }

    private class CloseWindowHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent event) {
            makeMainView();
        }
    }

    private class SignUpButtonHandler implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent event) {
            if (database.signUp(signUpView.getUsername(), signUpView.getPassword(), signUpView.getConfirmPassword(),
                    signUpView.getFirstName(), signUpView.getLastName(), signUpView.getEmail())) {
                try {
                    tosView.display();
                } catch (Exception e) {
                    new DLException(e);
                }
                makeMainView();

            } else if (signUpView.getFirstName().isEmpty()
                    || signUpView.getFirstName().length() > 20
                    || signUpView.getFirstName().length() > 20
                    || !signUpView.getFirstName().matches("^[a-zA-Z]+$")
                    || signUpView.getLastName().isEmpty()
                    || signUpView.getLastName().length() > 20
                    || !signUpView.getLastName().matches("^[a-zA-Z]+$")
                    || signUpView.getUsername().isEmpty()
                    || signUpView.getUsername().length() < 4
                    || signUpView.getUsername().length() > 15
                    || !signUpView.getUsername().matches("^[a-zA-Z0-9]+$")
                    || signUpView.getEmail().isEmpty()
                    || signUpView.getEmail().length() > 30
                    || !signUpView.getEmail().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")
                    || signUpView.getPassword().isEmpty()
                    || signUpView.getPassword().length() > 16
                    || signUpView.getPassword().length() < 6
                    || signUpView.getConfirmPassword().isEmpty()
                    || !signUpView.getConfirmPassword().equals(signUpView.getPassword())) {

                signUpView.signUpButtonClicked(event);

            } else {
                signUpView.userExists(event);
            }
        }
    }

    private class SaveProfileHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent event) {
            profileView.saveButton.setVisible(false);
            profileView.phoneField.setEditable(false);
            profileView.addressField.setEditable(false);
            profileView.zipField.setEditable(false);
            profileView.countryField.setEditable(false);
            profileView.cityField.setEditable(false);
            profileView.eMailField.setEditable(false);
            profileView.lNameField.setEditable(false);
            profileView.fNameField.setEditable(false);

            String username = profileView.userNameField.getText().trim();
            String firstName = profileView.fNameField.getText().trim();
            String lastName = profileView.lNameField.getText().trim();
            String phone = profileView.phoneField.getText().trim();
            String email = profileView.eMailField.getText().trim();
            String address = profileView.addressField.getText().trim();
            String zip = profileView.zipField.getText().trim();
            String city = profileView.cityField.getText().trim();
            String country = profileView.countryField.getText().trim();

            if (retrievedUser == null) {
                retrievedUser = new User();
            }

            if (firstName.isEmpty() || firstName.length() > 20 || !firstName.matches("^[a-zA-Z]+$")
                    || lastName.isEmpty() || lastName.length() > 20 || !lastName.matches("^[a-zA-Z]+$")
                    || email.isEmpty() || !email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$") || email.length() < 8
                    || email.length() > 30
                    || (phone.length() > 0 && (!phone.matches("^\\+[0-9 ]+$") || phone.length() > 20))
                    || (city.length() > 0 && (city.length() > 30 || !city.matches("^[a-zA-Z]+$")))
                    || (country.length() > 0 && (country.length() > 30 || !country.matches("^[a-zA-Z]+$")))
                    || (zip.length() > 0
                            && ((zip.length() != 5 && zip.length() != 0) || !zip.matches("^[a-zA-Z0-9]+$")))
                    || (address.length() > 0 && (address.length() > 50 || !address.matches("^[a-zA-Z0-9 ]+$")))) {
                profileView.saveButtonValidation();

            } else {
                retrievedUser.setUsername(username);
                retrievedUser.setFirstName(firstName);
                retrievedUser.setLastName(lastName);
                retrievedUser.setPhone(phone);
                retrievedUser.setEmail(email);
                retrievedUser.setAddress(address);
                retrievedUser.setZip(zip);
                retrievedUser.setCity(city);
                retrievedUser.setCountry(country);
                database.editUser(retrievedUser);
                profileView.successfulInput();
            }
        }
    }

    private class SignInLinkHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent event) {
            makeSignInView();
        }
    }

    // Handler for privacy policy on both views
    private class PrivacyPolicyHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent event) {
            try {
                privacyPolicyView.start(new Stage());
            } catch (Exception e) {
                new DLException(e);
            }
        }

    }

    private class GamesLinkHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent event) {
            makeGamesView();
        }

    }

    private class LibraryLinkHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent event) {
            makeLibraryView(0);
        }

    }

    private class ProfileLinkHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent event) {
            makeProfileView();
        }

    }

    private class AdminAddRemoveHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent event) {
            makeAdminView();
        }

    }

    private class GGIconHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent event) {
            makeMainView();
        }

    }

    private class SearchButtonHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent event) {
            String name = mainView.getName();
            pickedGameView(name);
        }
    }

    private class SearchButtonLibraryHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent event) {
            String name = libraryView.getName();
            pickedGameView(name);
        }

    }

    private class SearchButtonCartHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent event) {
            String name = cartView.getName();
            pickedGameView(name);
        }

    }

    private class SearchButtonWishlistHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent event) {
            String name = wishlistView.getName();
            pickedGameView(name);
        }

    }

    private class SearchButtonProfileHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent event) {
            String name = profileView.getName();
            pickedGameView(name);

        }
    }

    private class SearchButtonGameHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent event) {
            String name = gameView.getName();
            pickedGameView(name);
        }

    }

    private class WishlistHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent event) {
            makeWishlistView();
        }

    }

    private class RemoveCartHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent event) {
            database.removeCart(cartView.getID());
            makeCartView();
        }

    }

    private class addToCartGameHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent event) {
            database.sendCart(gameView.getID());
            pickedGameView(gameView.getID());
        }

    }

    private class addToCartWishlistHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent event) {
            database.sendCart(wishlistView.getID2());
            makeWishlistView();
        }

    }

    private class CartHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent event) {
            makeCartView();
        }

    }

    private class AddGameHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent event) {
            makeAddGamesView();
        }
    }

    private class DeleteGameHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent event) {
            makeAdminView();
        }
    }

    private class AddWishlistHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent event) {
            int id = gameView.getID();
            database.sendWishlist(id);
            pickedGameView(id);
        }
    }

    private class AddGameButtonHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent event) {
            Game game = new Game(0, adminAddView.getGameName(), adminAddView.getGameImgUrl(),
                    adminAddView.getDescription(), 0, 0, 0, 0, 0);
            Price price = new Price(0, Float.parseFloat(adminAddView.getPrice()), adminAddView.getCurrency(),
                    adminAddView.getSale(), adminAddView.getSalePercentage(), adminAddView.getStartDate(),
                    adminAddView.getEndDate());
            ReleaseDate rDate = new ReleaseDate(0, adminAddView.getReleaseDate());
            SystemSpecs sSpecs = new SystemSpecs(0, adminAddView.getOS(), adminAddView.getProcessor(),
                    adminAddView.getRamMemory(), adminAddView.getStorageSpace(), adminAddView.getGraphicsCard(),
                    adminAddView.getDirectX());
            Rating rRating = new Rating(0, adminAddView.getRating(), null, null);
            Publisher publisher = new Publisher(0, adminAddView.getPublisherName(), adminAddView.getDeveloper());
            database.addGame(game, price, rDate, sSpecs, rRating, publisher);
            database.addGameGenres(adminAddView.getPickedGenres(), database.getLastAddedGame());
        }
    }

    private class ToggleGroupHandler implements ChangeListener<Toggle> {
        @Override
        public void changed(ObservableValue<? extends Toggle> arg0, Toggle oldValue, Toggle newValue) {
            gamesView.loadGame(database.makeQuery(gamesView.getSelectedCheckboxes(), gamesView.getSearch(),
                    gamesView.getSelectedToggle()), true);
            gamesView.pressedGameHandler(new PickGameGames());

        }
    }

    private class CheckBoxHandler implements ChangeListener<Boolean> {
        @Override
        public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
            gamesView.loadGame(database.makeQuery(gamesView.getSelectedCheckboxes(), gamesView.getSearch(),
                    gamesView.getSelectedToggle()), true);
            gamesView.pressedGameHandler(new PickGameGames());

        }
    }

    private class ResetHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent arg0) {
            gamesView.resetFilters();
            gamesView.loadGame(database.makeQuery(gamesView.getSelectedCheckboxes(), gamesView.getSearch(),
                    gamesView.getSelectedToggle()), true);
            gamesView.pressedGameHandler(new PickGameGames());

        }
    }

    private class SearchHandler implements ChangeListener<String> {
        @Override
        public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
            gamesView.loadGame(database.makeQuery(gamesView.getSelectedCheckboxes(), gamesView.getSearch(),
                    gamesView.getSelectedToggle()), true);
            gamesView.pressedGameHandler(new PickGameGames());

        }
    }

    private class PickGameMain implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent arg0) {
            int id = mainView.getID();
            pickedGameView(id);
        }

    }

    private class PickGameGames implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent arg0) {
            int id = gamesView.getID();
            pickedGameView(id);
        }

    }

    private class PressedGameHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent arg0) {
            int id = libraryView.getID();
            makeLibraryView(id);
        }

    }

    private class LeaveReviewHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent arg0) {
            String text = gameView.getText();
            int stars = gameView.getStars();
            int id = gameView.getID();
            database.sendReview(stars, text, id);
            gameView.loadReview(database.getReview(id));
        }

    }

    private class AddToWishlistHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent arg0) {
            database.sendWishlist(cartView.getID2());
            makeCartView();
        }

    }

    private class RemoveWishlistHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent arg0) {
            int id = wishlistView.getID();
            database.removeWishlist(id);
            makeWishlistView();
        }

    }

    private class PaymentHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent event) {
            TextField tf = (TextField) event.getSource();
            if (tf.getId().equals("CartBuyButton"))
                makePaymentView(cartView.getGameNames(), cartView.getTotalPrice());
            else
                makePaymentView(Arrays.asList(database.getGame().get(database.pickedGame(tf.getId()))),
                        database.getGame().get(database.pickedGame(tf.getId())).getPrices().getPrice());

        }
    }

    private class BuyHandler implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent event) {
            String firstName = paymentView.fName.getText().trim();
            String lastName = paymentView.lName.getText().trim();
            String creditCard = paymentView.creditCard.getText().trim();
            String expDate = paymentView.expDate.getText().trim();
            String ccvNumber = paymentView.ccvNumber.getText().trim();

            if (firstName == null || firstName.isEmpty() || firstName.length() > 20 || !firstName.matches("^[a-zA-Z]*$")
                    || lastName == null
                    || lastName.isEmpty() || lastName.length() > 20 || !lastName.matches("^[a-zA-Z]*$")
                    || creditCard == null || creditCard.isEmpty() || creditCard.length() < 16
                    || creditCard.length() > 19 || !creditCard.matches("[0-9]+") || expDate == null
                    || !expDate.matches("\\d{2}/\\d{2}") ||
                    ccvNumber == null || !ccvNumber.matches("\\d{3}")) {
                paymentView.buyValidation();
            } else {
                GameSales gameSales = new GameSales(0, database.generateCode(),
                        paymentView.getTotalPrice(), new java.sql.Date(System.currentTimeMillis()) + "",
                        0, null, 0);
                TypeOfPayment typeOfPayment = new TypeOfPayment(4, null);
                List<String> gameIdList = paymentView.getGameIdList();
                database.addGameSales(gameSales, typeOfPayment, gameIdList);
                makeMainView();
            }
        }
    }

    public void makeSignInView() {
        this.signUpView = null; // dereferencing
        this.signInView = new SignIn(this.stage);

        this.signInView.addSignInHandler(new SignInButtonHandler());
        this.signInView.addSignUpHandler(new SignUpLinkHandler());
        this.signInView.addPrivacyHandler(new PrivacyPolicyHandler());
    }

    public void makeSignUpView() {
        this.signInView = null; // dereferencing
        this.signUpView = new SignUp(this.stage);

        this.signUpView.addSignInHandler(new SignInLinkHandler());
        this.signUpView.addSignUpHandler(new SignUpButtonHandler());
        this.signUpView.addPrivacyHandler(new PrivacyPolicyHandler());
    }

    public void makeMainView() {
        this.signInView = null;
        this.signUpView = null;
        this.gamesView = null;
        this.gameView = null;
        this.profileView = null;
        this.wishlistView = null;
        this.cartView = null;
        this.libraryView = null;
        this.adminView = null;

        this.mainView = new GGView(this.stage);
        if (retrievedUser != null && retrievedUser.getRole_key() == 1) {
            mainView.createLabel();
        }
        this.mainView.addGamesHandler(new GamesLinkHandler());
        this.mainView.addLibraryHandler(new LibraryLinkHandler());
        this.mainView.addProfileHandler(new ProfileLinkHandler());
        this.mainView.addAdminHandler(new AdminAddRemoveHandler());
        this.mainView.addSearchHandler(new SearchButtonHandler());
        this.mainView.addWishlistHandler(new WishlistHandler());
        this.mainView.addCartHandler(new CartHandler());
        this.database.fillDB();
        this.mainView.loadGame(this.database.getGame());
        this.database.filterList();
        this.mainView.pressedGameHandler(new PickGameMain());
        this.tosView.closeWindow(new CloseWindowHandler());

    }

    public void makeAdminView() {
        this.gamesView = null;
        this.mainView = null;
        this.gameView = null;
        this.profileView = null;
        this.wishlistView = null;
        this.libraryView = null;
        this.cartView = null;

        this.adminView = new AdminView(this.stage);
        this.adminView.addGames(database.getGame());
        this.adminView.addAddGameHandler(new AddGameHandler());
        this.adminView.addDeleteGameHandler(new DeleteGameHandler());
        this.adminView.addGamesHandler(new GamesLinkHandler());
        this.adminView.addLibraryHandler(new LibraryLinkHandler());
        this.adminView.addProfileHandler(new ProfileLinkHandler());
        this.adminView.addWishlistHandler(new WishlistHandler());
        this.adminView.addCartHandler(new CartHandler());
        this.adminView.addGGIconHandler(new GGIconHandler());
    }

    public void makeAddGamesView() {
        this.gamesView = null;
        this.mainView = null;
        this.gameView = null;
        this.profileView = null;
        this.wishlistView = null;
        this.cartView = null;
        this.libraryView = null;
        this.adminView = null;

        this.adminAddView = new AdminAddView(this.stage);
        this.adminAddView.addAddGameHandler(new AddGameButtonHandler());
        this.adminAddView.addGamesHandler(new GamesLinkHandler());
        this.adminAddView.addLibraryHandler(new LibraryLinkHandler());
        this.adminAddView.addProfileHandler(new ProfileLinkHandler());
        this.adminAddView.addAdminHandler(new AdminAddRemoveHandler());
        this.adminAddView.addWishlistHandler(new WishlistHandler());
        this.adminAddView.addCartHandler(new CartHandler());
        this.adminAddView.addGGIconHandler(new GGIconHandler());

    }

    public void makeGamesView() {
        this.mainView = null;
        this.gameView = null;
        this.profileView = null;
        this.wishlistView = null;
        this.cartView = null;
        this.adminView = null;
        this.libraryView = null;

        this.gamesView = new GamesView(this.stage);
        gamesView.loadGame(database.makeQuery(gamesView.getSelectedCheckboxes(), gamesView.getSearch(),
                gamesView.getSelectedToggle()), false);
        if (retrievedUser != null && retrievedUser.getRole_key() == 1) {
            this.gamesView.createLabel();
        }
        this.gamesView.addToggleGroupHandler(new ToggleGroupHandler());
        this.gamesView.addCheckBoxListener(new CheckBoxHandler());
        this.gamesView.addResetHandler(new ResetHandler());
        this.gamesView.addSearchListener(new SearchHandler());
        this.gamesView.pressedGameHandler(new PickGameGames());
        this.gamesView.addLibraryHandler(new LibraryLinkHandler());
        this.gamesView.addProfileHandler(new ProfileLinkHandler());
        this.gamesView.addAdminHandler(new AdminAddRemoveHandler());
        this.gamesView.addWishlistHandler(new WishlistHandler());
        this.gamesView.addCartHandler(new CartHandler());
        this.gamesView.addGGIconHandler(new GGIconHandler());

    }

    public void makeLibraryView(int id) {
        this.gamesView = null;
        this.mainView = null;
        this.gameView = null;
        this.profileView = null;
        this.wishlistView = null;
        this.cartView = null;
        this.adminView = null;
        this.libraryView = new GGLibrary(this.stage);
        this.libraryView.loadSideBar(database.filterPurchase());
        if (database.filterPurchase().size() > 0) {
            this.libraryView.loadHistory(database.filterPurchase().get(id));
            this.libraryView.loadReview(database.getReview(database.filterPurchase().get(id).getGame_key()));
        } else {
            this.libraryView.loadHistory(null);
        }
        if (retrievedUser != null && retrievedUser.getRole_key() == 1) {
            this.libraryView.createLabel();
        }
        this.libraryView.pressedGameHandler(new PressedGameHandler());
        ;
        this.libraryView.addGamesHandler(new GamesLinkHandler());
        this.libraryView.addProfileHandler(new ProfileLinkHandler());
        this.libraryView.addAdminHandler(new AdminAddRemoveHandler());
        this.libraryView.addSearchHandler(new SearchButtonLibraryHandler());
        this.libraryView.addWishlistHandler(new WishlistHandler());
        this.libraryView.addCartHandler(new CartHandler());
        this.libraryView.addGGIconHandler(new GGIconHandler());

    }

    public void makeProfileView() {
        this.gamesView = null;
        this.mainView = null;
        this.gameView = null;
        this.libraryView = null;
        this.wishlistView = null;
        this.cartView = null;
        this.adminView = null;

        this.profileView = new GGProfile(this.stage);
        if (retrievedUser != null && retrievedUser.getRole_key() == 1) {
            this.profileView.createLabel();
        }
        this.profileView.addGamesHandler(new GamesLinkHandler());
        this.profileView.addLibraryHandler(new LibraryLinkHandler());
        this.profileView.addAdminHandler(new AdminAddRemoveHandler());
        this.profileView.addSearchHandler(new SearchButtonProfileHandler());
        this.profileView.addWishlistHandler(new WishlistHandler());
        this.profileView.addCartHandler(new CartHandler());
        this.profileView.addGGIconHandler(new GGIconHandler());
        this.profileView.pressedSave(new SaveProfileHandler());
        this.profileView.signOutPressed(new SignOutButtonHandler());

    }

    public void makeWishlistView() {
        this.gamesView = null;
        this.mainView = null;
        this.gameView = null;
        this.libraryView = null;
        this.profileView = null;
        this.cartView = null;
        this.adminView = null;

        this.wishlistView = new GGWishlist(this.stage);
        if (retrievedUser != null && retrievedUser.getRole_key() == 1) {
            this.wishlistView.createLabel();
        }
        this.wishlistView.setWishlist(database.getWishlist(), retrievedUser, database.getCart());
        this.wishlistView.addGamesHandler(new GamesLinkHandler());
        this.wishlistView.addLibraryHandler(new LibraryLinkHandler());
        this.wishlistView.addSearchHandler(new SearchButtonWishlistHandler());
        this.wishlistView.addProfileHandler(new ProfileLinkHandler());
        this.wishlistView.addAdminHandler(new AdminAddRemoveHandler());
        this.wishlistView.addCartHandler(new CartHandler());
        this.wishlistView.addGGIconHandler(new GGIconHandler());
        this.wishlistView.removeWishlistHandler(new RemoveWishlistHandler());
        this.wishlistView.addToCartHandler(new addToCartWishlistHandler());
        this.wishlistView.addPaymentHandler(new PaymentHandler());
    }

    public void makeCartView() {
        this.gamesView = null;
        this.mainView = null;
        this.gameView = null;
        this.libraryView = null;
        this.profileView = null;
        this.wishlistView = null;
        this.adminView = null;

        this.cartView = new GGCart(this.stage);
        this.cartView.setCart(database.getCart(), retrievedUser, database.getWishlist());

        if (retrievedUser != null && retrievedUser.getRole_key() == 1) {
            this.cartView.createLabel();
        }
        this.cartView.addGamesHandler(new GamesLinkHandler());
        this.cartView.addLibraryHandler(new LibraryLinkHandler());
        this.cartView.addSearchHandler(new SearchButtonCartHandler());
        this.cartView.addProfileHandler(new ProfileLinkHandler());
        this.cartView.addAdminHandler(new AdminAddRemoveHandler());
        this.cartView.addWishlistHandler(new WishlistHandler());
        this.cartView.addGGIconHandler(new GGIconHandler());
        this.cartView.addPaymentHandler(new PaymentHandler());
        this.cartView.removeCartHandler(new RemoveCartHandler());
        this.cartView.addToWishlistHandler(new AddToWishlistHandler());
    }

    public void pickedGameView(int id) {
        if (this.database.getGame_Features(id).size() > 0 || this.database.getGame_Features(id).size() > 0) {
            this.libraryView = null;
            this.profileView = null;
            this.wishlistView = null;
            this.adminView = null;
            this.gamesView = null;
            this.mainView = null;
            this.cartView = null;
            this.gameView = new GGGame(stage);
            this.gameView.loadGame(this.database.getGame_Genres(id), this.database.getGame_Features(id),
                    this.database.getPurchaseHistory(), this.database.getCart(), this.database.getWishlist());
            this.gameView.loadReview(this.database.getReview(id));
            this.gameView.addGamesHandler(new GamesLinkHandler());
            this.gameView.addLibraryHandler(new LibraryLinkHandler());
            this.gameView.addSearchHandler(new SearchButtonGameHandler());
            this.gameView.addProfileHandler(new ProfileLinkHandler());
            this.gameView.addCartHandler(new CartHandler());
            this.gameView.addWishlistHandler(new WishlistHandler());
            this.gameView.leaveReviewHandler(new LeaveReviewHandler());
            this.gameView.addGGIconHandler(new GGIconHandler());
            this.gameView.addToWishlistHandler(new AddWishlistHandler());
            this.gameView.addToCartHandler(new addToCartGameHandler());
            this.gameView.addPaymentHandler(new PaymentHandler());

        }
    }

    public void pickedGameView(String name) {
        if (this.database.getGame_Features(name).size() > 0 || this.database.getGame_Features(name).size() > 0) {
            this.libraryView = null;
            this.profileView = null;
            this.wishlistView = null;
            this.adminView = null;
            this.gamesView = null;
            this.mainView = null;
            this.cartView = null;
            this.gameView = new GGGame(stage);
            this.gameView.loadGame(this.database.getGame_Genres(name), this.database.getGame_Features(name),
                    this.database.getPurchaseHistory(), this.database.getCart(), this.database.getWishlist());
            this.gameView.loadReview(this.database.getReview(name));
            this.gameView.addGamesHandler(new GamesLinkHandler());
            this.gameView.addLibraryHandler(new LibraryLinkHandler());
            this.gameView.addSearchHandler(new SearchButtonGameHandler());
            this.gameView.addProfileHandler(new ProfileLinkHandler());
            this.gameView.addToWishlistHandler(new AddWishlistHandler());
            this.gameView.addWishlistHandler(new WishlistHandler());
            this.gameView.addCartHandler(new CartHandler());
            this.gameView.leaveReviewHandler(new LeaveReviewHandler());
            this.gameView.addGGIconHandler(new GGIconHandler());
            this.gameView.addToWishlistHandler(new AddWishlistHandler());
            this.gameView.addToCartHandler(new addToCartGameHandler());
            this.gameView.addPaymentHandler(new PaymentHandler());
        }
    }

    public void makePaymentView(List<Game> gameList, double price) {
        this.gamesView = null;
        this.gameView = null;
        this.libraryView = null;
        this.profileView = null;
        this.wishlistView = null;
        this.adminView = null;
        this.mainView = null;
        this.cartView = null;

        this.paymentView = new GGPaymentView(this.stage);
        paymentView.listGames(gameList, price);
        this.paymentView.addGamesHandler(new GamesLinkHandler());
        this.paymentView.addLibraryHandler(new LibraryLinkHandler());
        this.paymentView.addSearchHandler(new SearchButtonGameHandler());
        this.paymentView.addProfileHandler(new ProfileLinkHandler());
        this.paymentView.addCartHandler(new CartHandler());
        this.paymentView.addWishlistHandler(new WishlistHandler());
        this.paymentView.addGGIconHandler(new GGIconHandler());
        this.paymentView.addBuyHandler(new BuyHandler());
    }
}
