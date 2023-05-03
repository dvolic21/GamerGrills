package model;
import java.security.GeneralSecurityException;
import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;
import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Date;
import database.*;
import javafx.scene.control.Toggle;
import util.DLException;
import views.GGProfile;

public class GGDatabase {
    private Connection connection = null;
    private String userID;
    private String password;
    private final String dbms = "mysql";
    private final String serverName = "localhost";
    private final String portNum = "3306";
    private final String databaseName = "GamerGrills";
    private MysqlDataSource dataSource = null;
    private User user = null;
    private ArrayList<Game> allGames = new ArrayList<>();
    private ArrayList<Price> allPrices = new ArrayList<>();
    private ArrayList<ReleaseDate> allReleaseDates = new ArrayList<>();
    private ArrayList<Publisher> allPublishers = new ArrayList<>();
    private ArrayList<Rating> allRatings = new ArrayList<>();
    private ArrayList<Features> allFeatures = new ArrayList<>();
    private ArrayList<SystemSpecs> allSystemSpecs = new ArrayList<>();
    private ArrayList<Game_Features> allGame_Features = new ArrayList<>();
    private ArrayList<Genre> allGenres = new ArrayList<>();
    private ArrayList<Game_Genre> allGame_Genres = new ArrayList<>();
    private List<Game> gameWithPrices;
    private List<Game_Genre> genreGames;
    private List<Game_Features> featuresGames;
    private ArrayList<GameSales> purchaseHistory = new ArrayList<>();
    private List<Review> reviews = new ArrayList<>();
    private List<Wishlist> wishlist = new ArrayList<>();
    private List<Cart> cart = new ArrayList<>();
    private Map<Integer, List<Game>> gameMap;

    public GGDatabase() {
        this.userID = "";
        this.password = "";
    }

    /**
     * @deprecated Used to connect to a locally hosted database (not used)
     * @return
     */
    public boolean connect() {
        Properties connectionProps = new Properties();
        connectionProps.put("user", this.userID);
        connectionProps.put("password", this.password);
        try {
            connection = DriverManager.getConnection(
                    "jdbc:" + dbms + "://" + serverName + ":" + portNum + "/" + databaseName,
                    this.userID, this.password);
        } catch (Exception e) {
            new DLException(e);
            JOptionPane.showMessageDialog(null,
                    "Something went wrong. Please contact our technical support.");
            return false;
        }
        return true;
    }

    /**
     * @deprecated Used to connect to a locally hosted database (not used)
     * @return
     */
    public boolean closeConnection() {

        try {
            this.connection.close();
            return this.connection.isClosed();
        } catch (SQLException e) {
            new DLException(e);
            return false;
        }
    }

    public void fillDB() {
        fillGame();
        fillPrices();
        fillReleaseDate();
        fillFeatures();
        fillGameGenres();
        fillGame_Features();
        fillGenres();
        fillPrices();
        fillPublisher();
        fillRating();
        fillReleaseDate();
        fillSystemSpecs();
        fillGameSales();
        fillReview();
        fillWishlist();
        fillCart();
    }

    public void fillGame() {
        try {
            PreparedStatement statement = this.connection.prepareStatement(
                    "SELECT game_id, game_name, game_image, game_description, price_key, release_key, specs_key, rating_key, publisher_key FROM Game");
            ArrayList<ArrayList<String>> getData = getData(statement);
            for (int i = 0; i < getData.size(); i++) {
                allGames.add(new Game(Integer.parseInt(getData.get(i).get(0)), getData.get(i).get(1),
                        getData.get(i).get(2), getData.get(i).get(3), Integer.parseInt(getData.get(i).get(4)),
                        Integer.parseInt(getData.get(i).get(5)), Integer.parseInt(getData.get(i).get(6)),
                        Integer.parseInt(getData.get(i).get(7)), Integer.parseInt(getData.get(i).get(8))));
            }
        } catch (SQLException e) {
            new DLException(e);
        }
    }

    public void fillPrices() {
        try {
            PreparedStatement statement = this.connection.prepareStatement(
                    "SELECT price_id, price, currency, sale, sale_percentage, start_date, end_date FROM Price");
            ArrayList<ArrayList<String>> getData = getData(statement);
            for (int i = 0; i < getData.size(); i++) {
                allPrices.add(new Price(Integer.parseInt(getData.get(i).get(0)),
                        Float.parseFloat(getData.get(i).get(1)), getData.get(i).get(2), getData.get(i).get(3),
                        getData.get(i).get(4), getData.get(i).get(5), getData.get(i).get(6)));
            }
        } catch (SQLException e) {
            new DLException(e);
        }
    }

    public void fillReleaseDate() {
        try {
            PreparedStatement statement = this.connection.prepareStatement(
                    "SELECT release_date_id, release_date FROM ReleaseDate");
            ArrayList<ArrayList<String>> getData = getData(statement);
            for (int i = 0; i < getData.size(); i++) {
                allReleaseDates.add(new ReleaseDate(Integer.parseInt(getData.get(i).get(0)), getData.get(i).get(1)));
            }
        } catch (SQLException e) {
            new DLException(e);
        }
    }

    public void fillPublisher() {
        try {
            PreparedStatement statement = this.connection.prepareStatement(
                    "SELECT publisher_id, publisher_name, developer FROM Publisher");
            ArrayList<ArrayList<String>> getData = getData(statement);
            for (int i = 0; i < getData.size(); i++) {
                allPublishers.add(new Publisher(Integer.parseInt(getData.get(i).get(0)), getData.get(i).get(1),
                        getData.get(i).get(2)));
            }
        } catch (SQLException e) {
            new DLException(e);
        }
    }

    public void fillRating() {
        try {
            PreparedStatement statement = this.connection.prepareStatement(
                    "SELECT rating_id, rating, minimum_age, description FROM Rating");
            ArrayList<ArrayList<String>> getData = getData(statement);
            for (int i = 0; i < getData.size(); i++) {
                allRatings.add(new Rating(Integer.parseInt(getData.get(i).get(0)), getData.get(i).get(1),
                        getData.get(i).get(2), getData.get(i).get(3)));
            }
        } catch (SQLException e) {
            new DLException(e);
        }
    }

    public void fillFeatures() {
        try {
            PreparedStatement statement = this.connection.prepareStatement(
                    "SELECT features_id, name, description FROM Features");
            ArrayList<ArrayList<String>> getData = getData(statement);
            for (int i = 0; i < getData.size(); i++) {
                allFeatures.add(new Features(Integer.parseInt(getData.get(i).get(0)), getData.get(i).get(1),
                        getData.get(i).get(2)));
            }
        } catch (SQLException e) {
            new DLException(e);
        }
    }

    public void fillSystemSpecs() {
        try {
            PreparedStatement statement = this.connection.prepareStatement(
                    "SELECT specs_id, OS, processor, memory, storage, graphics, directX FROM SystemSpecs");
            ArrayList<ArrayList<String>> getData = getData(statement);
            for (int i = 0; i < getData.size(); i++) {
                allSystemSpecs.add(new SystemSpecs(Integer.parseInt(getData.get(i).get(0)), getData.get(i).get(1),
                        getData.get(i).get(2), getData.get(i).get(3), getData.get(i).get(4), getData.get(i).get(5),
                        getData.get(i).get(6)));
            }
        } catch (SQLException e) {
            new DLException(e);
        }
    }

    public void fillGame_Features() {
        try {
            PreparedStatement statement = this.connection.prepareStatement(
                    "SELECT game_features_id, game_key, feature_key FROM Game_Features");
            ArrayList<ArrayList<String>> getData = getData(statement);
            for (int i = 0; i < getData.size(); i++) {
                allGame_Features.add(new Game_Features(Integer.parseInt(getData.get(i).get(0)),
                        Integer.parseInt(getData.get(i).get(1)), Integer.parseInt(getData.get(i).get(2))));
            }
        } catch (SQLException e) {
            new DLException(e);
        }
    }

    public void fillGenres() {
        try {
            PreparedStatement statement = this.connection.prepareStatement(
                    "SELECT genre_key, genre, theme FROM Genre");
            ArrayList<ArrayList<String>> getData = getData(statement);
            for (int i = 0; i < getData.size(); i++) {
                allGenres.add(new Genre(Integer.parseInt(getData.get(i).get(0)),
                        getData.get(i).get(1), getData.get(i).get(2), -1));
            }
        } catch (SQLException e) {
            new DLException(e);
        }
    }

    public void fillGameGenres() {
        try {
            PreparedStatement statement = this.connection.prepareStatement(
                    "SELECT DISTINCT game_id, genre_id, game_genre_id FROM Game_Genre;");
            ArrayList<ArrayList<String>> getData = getData(statement);
            for (int i = 0; i < getData.size(); i++) {
                allGame_Genres.add(new Game_Genre(Integer.parseInt(getData.get(i).get(2)),
                        Integer.parseInt(getData.get(i).get(1)), Integer.parseInt(getData.get(i).get(0))));
            }
        } catch (SQLException e) {
            new DLException(e);
        }
    }

    public void fillGameSales() {
        PreparedStatement statement;
        try {
            statement = this.connection.prepareStatement("SELECT * FROM GameSales WHERE user_key = ?");
            statement.setString(1, user.getUsername());
            ArrayList<ArrayList<String>> getData = getData(statement);
            for (int i = 0; i < getData.size(); i++) {
                purchaseHistory.add(new GameSales(Integer.parseInt(getData.get(i).get(0)), getData.get(i).get(1),
                        Double.parseDouble(getData.get(i).get(2)), getData.get(i).get(3),
                        Integer.parseInt(getData.get(i).get(4)), getData.get(i).get(5),
                        Integer.parseInt(getData.get(i).get(6))));
            }

        } catch (SQLException e) {
            new DLException(e);
        }
    }

    public void fillReview() {
        PreparedStatement statement;
        try {
            statement = this.connection.prepareStatement("SELECT * FROM Review");
            ArrayList<ArrayList<String>> getData = getData(statement);
            for (int i = 0; i < getData.size(); i++) {
                reviews.add(new Review(Integer.parseInt(getData.get(i).get(0)), Integer.parseInt(getData.get(i).get(1)),
                        getData.get(i).get(2), getData.get(i).get(3), Integer.parseInt(getData.get(i).get(4))));
            }
        } catch (SQLException e) {
            new DLException(e);

        }
    }

    public void fillWishlist() {
        PreparedStatement statement;
        try {
            statement = this.connection.prepareStatement("SELECT * FROM Wishlist WHERE user_key = ?");
            statement.setString(1, user.getUsername());
            ArrayList<ArrayList<String>> getData = getData(statement);
            for (int i = 0; i < getData.size(); i++) {
                wishlist.add(
                        new Wishlist(Integer.parseInt(getData.get(i).get(0)), Integer.parseInt(getData.get(i).get(1)),
                                getData.get(i).get(2)));
            }

        } catch (SQLException e) {
            new DLException(e);

        }
    }

    public void fillCart() {
        PreparedStatement statement;
        try {
            statement = this.connection.prepareStatement("SELECT * FROM Cart WHERE user_key = ?");
            statement.setString(1, user.getUsername());
            ArrayList<ArrayList<String>> getData = getData(statement);
            for (int i = 0; i < getData.size(); i++) {
                cart.add(new Cart(Integer.parseInt(getData.get(i).get(0)), Integer.parseInt(getData.get(i).get(1)),
                        getData.get(i).get(2)));
            }
        } catch (SQLException e) {
            new DLException(e);

        }
    }

    public ArrayList<ArrayList<String>> getData(PreparedStatement stmt) {

        ArrayList<ArrayList<String>> list = new ArrayList<>();
        PreparedStatement pStatement = stmt;

        try {
            ResultSet resultSet = pStatement.executeQuery();
            while (resultSet.next()) {
                ArrayList<String> rowList = new ArrayList<>();
                for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                    rowList.add(resultSet.getString(i));
                }
                list.add(rowList);
            }

        } catch (SQLException sqle) {
            new DLException(sqle);
        } catch (Exception e) {
            new DLException(e);
        } finally {
            try {
                pStatement.close();
            } catch (SQLException e) {
                new DLException(e);
            }
        }

        return list;

    }

    public boolean setData(String statement, ArrayList<String> values) {
        boolean isExecuted;
        try {
            PreparedStatement p = prepare(statement, values);
            p.execute();
            p.close();
            isExecuted = true;
        } catch (SQLException sqle) {
            new DLException(sqle);
            isExecuted = false;
        } catch (Exception e) {
            new DLException(e);
            isExecuted = false;
        }

        return isExecuted;

    }

    public PreparedStatement prepare(String statement, ArrayList<String> values) {
        PreparedStatement pStatement = null;
        try {
            pStatement = this.connection.prepareStatement(statement);
            for (int i = 1, j = 0; j < values.size(); i++, j++) {
                pStatement.setString(i, values.get(j));
            }

        } catch (Exception e) {
            new DLException(e);
        }

        return pStatement;
    }

    public User adminLogin(String userID, String userPassword) {
        boolean loginSuccessful = login(userID, userPassword);
        if (loginSuccessful) {
            return this.user;
        } else {
            return null;
        }
    }

    public boolean login(String userID, String userPassword) {
        // Check if the textfields are empty
        if (userID.isEmpty() || userPassword.isEmpty()) {
            return false;
        }

        // Validate the userID parameter
        if (!userID.matches("^[a-zA-Z0-9.@]+$")) {
            return false;
        }

        // Validate the userPassword parameter
        if (userPassword.length() < 6 || userPassword.length() > 14) {
            return false;
        }

        this.dataSource = new MysqlDataSource();
        this.dataSource.setURL("jdbc:mysql://db4free.net:3306/ggdatabase");
        this.dataSource.setUser("dvolic21");
        this.dataSource.setPassword("Valkirion2001");

        PreparedStatement pStatement = null;
        try {
            this.connection = dataSource.getConnection();
            pStatement = connection.prepareStatement("SELECT * FROM User WHERE email = ? OR username = ?");
            pStatement.setString(1, userID);
            pStatement.setString(2, userID);

            ResultSet resultSet = pStatement.executeQuery();
            if (resultSet.next()) {
                String username = resultSet.getString("username");
                String encryptedPassword = resultSet.getString("password");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String city = resultSet.getString("city");
                String zip = resultSet.getString("zip");
                String country = resultSet.getString("country");
                Date date = resultSet.getDate("date_created");
                int role_key = resultSet.getInt("role_key");

                // Decrypt the password
                String keyString = "verysecurekey123";
                byte[] keyBytes = keyString.getBytes();
                SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
                Cipher cipher = Cipher.getInstance("AES");
                cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
                byte[] decryptedPasswordBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedPassword));
                String decryptedPassword = new String(decryptedPasswordBytes);

                // Compare the passwords
                if (decryptedPassword.equals(userPassword)) {
                    this.user = new User(username, decryptedPassword, firstName, lastName, phone, email, address, city,
                            zip, country, date, role_key);
                    GGProfile.firstName = firstName;
                    GGProfile.userPassword = decryptedPassword;
                    GGProfile.lastName = lastName;
                    GGProfile.usernameID = username;
                    GGProfile.userEmail = email;
                    GGProfile.userPhone = phone;
                    GGProfile.userAddress = address;
                    GGProfile.userCity = city;
                    GGProfile.userZip = zip;
                    GGProfile.userCountry = country;
                    return true;
                }
            } else {
                JOptionPane.showMessageDialog(null,
                        "The user is not registered yet or wrong username/password combination.\nPlease close this window to continue.");
            }
        } catch (SQLException sqle) {
            new DLException(sqle);
            JOptionPane.showMessageDialog(null,
                    "Something went wrong. Please contact our technical support.");
        } catch (GeneralSecurityException gse) {
            new DLException(gse);
        } finally {
            try {
                if (pStatement != null)
                    pStatement.close();
            } catch (SQLException e) {
                new DLException(e);
            }
        }

        return false;
    }

    public boolean signUp(String username, String password, String confirmPassword, String firstName, String lastName,
            String email) {
        // Check that all fields are filled
        if (username == null || password == null || confirmPassword == null || firstName == null || lastName == null
                || email == null ||
                username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || firstName.isEmpty()
                || lastName.isEmpty() || email.isEmpty()) {
            
            return false;
        }

        if (username.length() > 15 || username.length() < 4) {
            return false;
        }

        if (firstName.length() > 20) {
            return false;
        }

        if (lastName.length() > 20) {
            return false;
        }

        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            return false;
        }

        if (email.length() > 30) {
            return false;
        }

        if (password.length() > 16 || password.length() < 6) {
            return false;
        }

        // Check that the password and confirmPassword fields match
        if (!password.equals(confirmPassword)) {
            return false;
        }

        try {
            // Create a new DataSource object to connect to the database
            this.dataSource = new MysqlDataSource();
            this.dataSource.setURL("jdbc:mysql://db4free.net:3306/ggdatabase");
            this.dataSource.setUser("dvolic21");
            this.dataSource.setPassword("Valkirion2001");

            // Create a connection and prepare the insert statement
            this.connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO User (username, password, firstName, lastName, email, date_created, role_key) VALUES (?, ?, ?, ?, ?, CURDATE(), 2)");

            // Define secret key for encryption and decryption
            String keyString = "verysecurekey123";
            byte[] keyBytes = keyString.getBytes();
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");

            // Create cipher object for encryption
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

            // Encrypt the password
            byte[] encryptedPasswordBytes = cipher.doFinal(password.getBytes());
            String encryptedPassword = Base64.getEncoder().encodeToString(encryptedPasswordBytes);

            // Set the values for the insert statement
            statement.setString(1, username);
            statement.setString(2, encryptedPassword);
            statement.setString(3, firstName);
            statement.setString(4, lastName);
            statement.setString(5, email);

            GGProfile.firstName = firstName;
            GGProfile.lastName = lastName;
            GGProfile.usernameID = username;
            GGProfile.userEmail = email;
            GGProfile.userPassword = password;

            // Execute the insert statement and close the resources
            int rowsInserted = statement.executeUpdate();
            statement.close();

            // Check if the insert was successful
            if (rowsInserted > 0) {
                // Create a new user object and set the properties
                this.user = new User();
                this.user.setUsername(username);
                this.user.setPassword(password);
                this.user.setFirstName(firstName);
                this.user.setLastName(lastName);
                this.user.setEmail(email);
                return true;
            }

        } catch (SQLException sqle) {
            new DLException(sqle);
            JOptionPane.showMessageDialog(null,
                    "The user with that username already exists.\nPlease close this window to continue.");
        } catch (GeneralSecurityException gse) {
            new DLException(gse);
            JOptionPane.showMessageDialog(null,
                    "Something went wrong. Please contact our technical support.");
        }

        return false;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User newUser) {
        this.user = newUser;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public List<Game> getGame() {
        return getGamesWithPrices();
    }

    public List<Game> getGamesWithPrices() {
        Map<Integer, List<Price>> priceMap = allPrices.stream().collect(Collectors.groupingBy(Price::getPrice_id));
        this.gameWithPrices = allGames.stream().filter(game -> priceMap.containsKey(game.getPrice_key())).map(game -> {
            game.setPrices(priceMap.get(game.getPrice_key()).get(0));
            return game;
        }).collect(Collectors.toList());
        return gameWithPrices;
    }

    public void filterList() {
        List<Game> connectedGame = getGamesWithPrices();
        Map<Integer, List<Genre>> genreMap = allGenres.stream().collect(Collectors.groupingBy(Genre::getGenre_key));
        Map<Integer, List<ReleaseDate>> releaseMap = allReleaseDates.stream()
                .collect(Collectors.groupingBy(ReleaseDate::getRelease_key));
        Map<Integer, List<SystemSpecs>> specsMap = allSystemSpecs.stream()
                .collect(Collectors.groupingBy(SystemSpecs::getSpecs_id));
        Map<Integer, List<Rating>> ratingsMap = allRatings.stream()
                .collect(Collectors.groupingBy(Rating::getRating_id));
        Map<Integer, List<Publisher>> publisherMap = allPublishers.stream()
                .collect(Collectors.groupingBy(Publisher::getPublisher_id));
        Map<Integer, List<Features>> featuresMap = allFeatures.stream()
                .collect(Collectors.groupingBy(Features::getFeatures_id));
        // Game + Price + Release
        connectedGame = connectedGame.stream().filter(game -> releaseMap.containsKey(game.getRelease_key()))
                .map(game -> {
                    game.setDate(releaseMap.get(game.getRelease_key()).get(0));
                    return game;
                }).collect(Collectors.toList());

        // Game + Price + Release + Specs
        connectedGame = connectedGame.stream().filter(game -> specsMap.containsKey(game.getSpecs_key()))
                .map(game -> {
                    game.setSpecs((specsMap.get(game.getSpecs_key())).get(0));
                    return game;
                }).collect(Collectors.toList());

        // Game + Price + Release + Specs + Ratings
        connectedGame = connectedGame.stream().filter(game -> ratingsMap.containsKey(game.getRating_key()))
                .map(game -> {
                    game.setRating(((ratingsMap.get(game.getRating_key()))).get(0));
                    return game;
                }).collect(Collectors.toList());

        // Game + Price + Release + Specs + Ratings + Publisher
        connectedGame = connectedGame.stream().filter(game -> publisherMap.containsKey(game.getPublisher_key()))
                .map(game -> {
                    game.setPublisher(((publisherMap.get(game.getPublisher_key()))).get(0));
                    return game;
                }).collect(Collectors.toList());

        // Game_Feature + Feature
        featuresGames = allGame_Features.stream()
                .filter(game_feature -> featuresMap.containsKey(game_feature.getFeatures_id())).map(game_feature -> {
                    game_feature.setFeatures((featuresMap.get(game_feature.getFeatures_id()).get(0)));
                    return game_feature;
                }).collect(Collectors.toList());
        // Game_Genre + Genre
        List<Game_Genre> ggWithGame = allGame_Genres.stream()
                .filter(game_genre -> genreMap.containsKey(game_genre.getGenre_id())).map(game_genre -> {
                    game_genre.setGenre(genreMap.get(game_genre.getGenre_id()).get(0));
                    return game_genre;
                }).collect(Collectors.toList());
        this.gameMap = connectedGame.stream().collect(Collectors.groupingBy(Game::getGame_id));
        // Game_Genre + Game
        genreGames = ggWithGame.stream().filter(game_genre -> gameMap.containsKey(game_genre.getGame_id()))
                .map(game_genre -> {
                    game_genre.setGame(gameMap.get(game_genre.getGame_id()).get(0));
                    return game_genre;
                }).collect(Collectors.toList());
        for (int i = 0; i < genreGames.size(); i++) {
            Game_Genre currentObject = genreGames.get(i);
            for (int j = i + 1; j < genreGames.size(); j++) {
                Game_Genre compareObject = genreGames.get(j);
                if (currentObject.getGame_id() == (compareObject.getGame_id())) {
                    genreGames.get(i).setGG(compareObject);
                    genreGames.remove(j);
                    j--;
                }
            }

        }
        wishlist = wishlist.stream().filter(game -> gameMap.containsKey(game.getGame_key()))
                .map(game -> {
                    game.setGame(gameMap.get(game.getGame_key()).get(0));
                    return game;
                }).collect(Collectors.toList());
        cart = cart.stream().filter(game -> gameMap.containsKey(game.getGame_key()))
                .map(game -> {
                    game.setGame(gameMap.get(game.getGame_key()).get(0));
                    return game;
                }).collect(Collectors.toList());
        // Game_Features + Feature
        featuresGames = featuresGames.stream().filter(game_feature -> gameMap.containsKey(game_feature.getGame_id()))
                .map(game_feature -> {
                    game_feature.setGames((gameMap.get(game_feature.getGame_id()).get(0)));
                    return game_feature;
                }).collect(Collectors.toList());
        for (int i = 0; i < featuresGames.size(); i++) {
            Game_Features currentObject = featuresGames.get(i);
            for (int j = i + 1; j < featuresGames.size(); j++) {
                Game_Features compareObject = featuresGames.get(j);
                if (currentObject.getGame_id() == (compareObject.getGame_id())) {
                    featuresGames.get(i).setGame_features(compareObject);
                    featuresGames.remove(j);
                    j--;
                }
            }
        }
    }

    public List<GameSales> filterPurchase() {
        return purchaseHistory.stream().filter(game -> gameMap.containsKey(game.getGame_key())).map(game -> {
            game.setGame((gameMap.get(game.getGame_key()).get(0)));
            return game;
        }).collect(Collectors.toList());
    }

    public List<Game_Genre> getFilterList() {
        return genreGames;
    }

    public List<GameSales> getPurchaseHistory() {
        return purchaseHistory;
    }

    public List<Game_Features> getGame_Features(int id) {
        return featuresGames.stream().filter(game -> game.getGame_id() == id).collect(Collectors.toList());
    }

    public List<Game_Genre> getGame_Genres(int id) {
        return genreGames.stream().filter(game -> game.getGame_id() == id).collect(Collectors.toList());
    }

    public List<Game_Features> getGame_Features(String name) {
        return featuresGames.stream().filter(game -> game.getGames().getGame_name().contains(name))
                .collect(Collectors.toList());
    }

    public List<Game_Genre> getGame_Genres(String name) {
        return genreGames.stream().filter(game -> game.getGame().getGame_name().contains(name))
                .collect(Collectors.toList());
    }

    public List<Review> getReview(int id) {
        List<Review> filterReview = reviews.stream().filter(game -> gameMap.containsKey(game.getGame_key()))
                .map(game -> {
                    game.setGame(gameMap.get(game.getGame_key()).get(0));
                    return game;
                }).collect(Collectors.toList());
        return filterReview.stream().filter(game -> game.getGame_key() == id).collect(Collectors.toList());
    }

    public List<Review> getReview(String name) {
        List<Review> filterReview = reviews.stream().filter(game -> gameMap.containsKey(game.getGame_key()))
                .map(game -> {
                    game.setGame(gameMap.get(game.getGame_key()).get(0));
                    return game;
                }).collect(Collectors.toList());
        return filterReview.stream().filter(game -> game.getGame().getGame_name() == name).collect(Collectors.toList());
    }

    public List<Game_Genre> makeQuery(List<String> boxes, String search, Toggle selectedToggle) {
        List<Game_Genre> list = getFilterList();
        if (boxes.size() > 0) {
            for (int i = 0; i < boxes.size(); i++) {
                String box1 = boxes.get(i);
                list = list.stream()
                        .filter(box -> box.getGenre().getGenre().equals(box1)
                                || (box.getGG() != null && box.getGG().getGenre().getGenre().equals(box1)))
                        .collect(Collectors.toList());
            }
        }
        if (!search.isEmpty()) {
            list = list.stream().filter(box -> box.getGame().getGame_name().contains(search))
                    .collect(Collectors.toList());
        }
        if (selectedToggle != null) {
            if (selectedToggle.getUserData().toString().equals("lower")) {
                list.sort(Comparator.comparingDouble(value -> value.getGame().getPrices().getPrice()));
            } else {
                list.sort(Comparator
                        .comparingDouble(value -> ((Game_Genre) value).getGame().getPrices().getPrice())
                        .reversed());
            }
        }
        return list;
    }

    public ArrayList<ArrayList<String>> filterGame(String query) {
        try {
            PreparedStatement statement = this.connection.prepareStatement(query);
            return getData(statement);
        } catch (SQLException e) {
            new DLException(e);
            return null;
        }
    }

    public void sendReview(int stars, String text, int id) {
        String statement = "INSERT INTO Review(review_stars, review_comment, user_key, game_key) VALUES (?,?,?,?)";
        ArrayList<String> values = new ArrayList<>(Arrays.asList(stars + "", text, user.getUsername(), id + ""));
        setData(statement, values);
        reviews.add(new Review(reviews.size() + 1, stars, text, user.getUsername(), id));
    }

    public void sendWishlist(int id) {
        for (int i = 0; i < wishlist.size(); i++) {
            Wishlist currentObject = wishlist.get(i);
            if (currentObject.getUser_key().equals(user.getUsername()) && currentObject.getGame_key() == id) {
                return;
            }
        }

        String statement = "INSERT INTO Wishlist(user_key, game_key) VALUES (?,?)";
        ArrayList<String> values = new ArrayList<>(Arrays.asList(user.getUsername(), id + ""));
        setData(statement, values);
        wishlist.add(new Wishlist(-1, id, user.getUsername()));
        wishlist = wishlist.stream().filter(game -> gameMap.containsKey(game.getGame_key()))
                .map(game -> {
                    game.setGame(gameMap.get(game.getGame_key()).get(0));
                    return game;
                }).collect(Collectors.toList());
    }

    public List<Wishlist> getWishlist() {
        return wishlist;
    }

    public void removeWishlist(int id) {
        String statement = "DELETE FROM Wishlist WHERE game_key = ? AND user_key = ?";
        ArrayList<String> values = new ArrayList<>(Arrays.asList(id + "", user.getUsername()));
        this.setData(statement, values);

        for (int i = 0; i < wishlist.size(); i++) {
            if (wishlist.get(i).getUser_key().equals(user.getUsername()) && wishlist.get(i).getGame_key() == id) {
                wishlist.remove(i);
            }
        }
    }

    public void sendCart(int id) {
        for (int i = 0; i < cart.size(); i++) {
            Cart currentObject = cart.get(i);
            if (currentObject.getUser_key().equals(user.getUsername()) && currentObject.getGame_key() == id) {
                return;
            }
        }

        String statement = "INSERT INTO Cart(user_key, game_key) VALUES (?,?)";
        ArrayList<String> values = new ArrayList<>(Arrays.asList(user.getUsername(), id + ""));
        setData(statement, values);
        cart.add(new Cart(-1, id, user.getUsername()));
        cart = cart.stream().filter(game -> gameMap.containsKey(game.getGame_key()))
                .map(game -> {
                    game.setGame(gameMap.get(game.getGame_key()).get(0));
                    return game;
                }).collect(Collectors.toList());
    }

    public List<Cart> getCart() {
        return cart;
    }

    public void removeCart(int id) {
        String statement = "DELETE FROM Cart WHERE game_key = ? AND user_key = ?";
        ArrayList<String> values = new ArrayList<>(Arrays.asList(id + "", user.getUsername()));
        this.setData(statement, values);
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getUser_key().equals(user.getUsername()) && cart.get(i).getGame_key() == id) {
                cart.remove(i);
            }
        }
    }

    public boolean addGame(Game game, Price price, ReleaseDate release, SystemSpecs specs, Rating rating,
            Publisher publisher) {
        boolean isSuccessful = false;
        if (!gameExists(game.getGame_name())) {
            String price_id = checkForPriceID(price);
            String release_id = checkForReleaseID(release);
            String specs_id = checkForSpecsID(specs);
            String publisher_id = checkForPublisherID(publisher);
            String rating_id = checkForRating(rating);

            if (price_id != null && release_id != null && specs_id != null && publisher_id != null
                    && rating_id != null) {

                String statement = "INSERT INTO Game (game_name, game_image, game_description, price_key, release_key, specs_key, rating_key, publisher_key) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                ArrayList<String> values = new ArrayList<>(
                        Arrays.asList(game.getGame_name(), game.getGame_image(), game.getGame_description(),
                                price_id, release_id, specs_id, rating_id, publisher_id));

                isSuccessful = this.setData(statement, values);
            }
            fillGame();
            fillGameGenres();

        }

        return isSuccessful;
    }

    public Game getLastAddedGame() {
        return allGames.get(allGames.size() - 1);
    }

    public boolean gameExists(String game_name) {
        for (int i = 0; i < allGames.size(); i++) {
            if (allGames.get(i).getGame_name().equals(game_name))
                return true;
        }
        return false;

    }

    public String checkForPriceID(Price price) {
        for (int i = 0; i < allPrices.size(); i++) {
            if (allPrices.get(i).getPrice() == price.getPrice() && allPrices.get(i).getSale().equals(price.getSale()))
                return allPrices.get(i).getPrice_id() + "";
        }
        addPrice(price);
        fillPrices();
        return allPrices.get(allPrices.size() - 1).getPrice_id() + "";

    }

    public String checkForReleaseID(ReleaseDate releaseDate) {
        for (int i = 0; i < allReleaseDates.size(); i++) {
            if (allReleaseDates.get(i).getRelease_date().equals(releaseDate.getRelease_date()))
                return allReleaseDates.get(i).getRelease_key() + "";
        }
        addReleaseDate(releaseDate);
        fillReleaseDate();
        return allReleaseDates.get(allReleaseDates.size() - 1).getRelease_key() + "";

    }

    public String checkForSpecsID(SystemSpecs specs) {
        for (int i = 0; i < allSystemSpecs.size(); i++) {
            if (allSystemSpecs.get(i).getOS().equals(specs.getOS())
                    && allSystemSpecs.get(i).getProcessor().equals(specs.getProcessor())
                    && allSystemSpecs.get(i).getMemory().equals(specs.getMemory())
                    && allSystemSpecs.get(i).getStorage().equals(specs.getStorage())
                    && allSystemSpecs.get(i).getGraphics().equals(specs.getGraphics())
                    && allSystemSpecs.get(i).getDirectX().equals(specs.getDirectX()))
                return allSystemSpecs.get(i).getSpecs_id() + "";
        }
        addSpecs(specs);
        fillSystemSpecs();
        return allSystemSpecs.get(allSystemSpecs.size() - 1).getSpecs_id() + "";

    }

    public String checkForPublisherID(Publisher publisher) {
        for (int i = 0; i < allPublishers.size(); i++) {
            if (allPublishers.get(i).getPublisher_name().equals(publisher.getPublisher_name())
                    && allPublishers.get(i).getDeveloper().equals(publisher.getDeveloper()))
                return allPublishers.get(i).getPublisher_id() + "";
        }
        addPublisher(publisher);
        fillPublisher();
        return allPublishers.get(allPublishers.size() - 1).getPublisher_id() + "";

    }

    public String checkForRating(Rating rating) {
        for (int i = 0; i < allRatings.size(); i++) {
            if (allRatings.get(i).getRating().equals(rating.getRating()))
                return allRatings.get(i).getRating_id() + "";
        }
        return "";

    }

    public boolean addReleaseDate(ReleaseDate releaseDate) {
        String statement = "INSERT INTO ReleaseDate (release_date) VALUES (?)";
        ArrayList<String> values = new ArrayList<>(Arrays.asList(releaseDate.getRelease_date() + ""));

        return this.setData(statement, values);
    }

    public boolean addPrice(Price price) {
        String statement = null;
        ArrayList<String> values = null;
        if (price.getSale().equalsIgnoreCase("Yes")) {
            statement = "INSERT INTO Price (price, currency, sale, sale_percentage, start_date, end_date) VALUES (?, ?, ?, ?, ?, ?)";
            values = new ArrayList<>(Arrays.asList(price.getPrice() + "", price.getCurrency(),
                    price.getSale(), price.getSale_percentage(), price.getStart_date() + "", price.getEnd_date() + ""));

        } else {
            statement = "INSERT INTO Price (price, currency, sale) VALUES (?, ?, ?)";
            values = new ArrayList<>(Arrays.asList(price.getPrice() + "", price.getCurrency(), price.getSale()));

        }

        return this.setData(statement, values);

    }

    public boolean addSpecs(SystemSpecs sysSpecs) {
        String statement = "INSERT INTO SystemSpecs (OS, processor, memory, storage, graphics, directX) VALUES (?, ?, ?, ?, ?, ?)";
        ArrayList<String> values = new ArrayList<>(Arrays.asList(sysSpecs.getOS(), sysSpecs.getProcessor(),
                sysSpecs.getMemory(), sysSpecs.getStorage(), sysSpecs.getGraphics(), sysSpecs.getDirectX()));

        return this.setData(statement, values);
    }

    public boolean addPublisher(Publisher publisher) {
        String statement = "INSERT INTO Publisher (publisher_name, developer) VALUES (?, ?)";
        ArrayList<String> values = new ArrayList<>(
                Arrays.asList(publisher.getPublisher_name(), publisher.getDeveloper()));

        return this.setData(statement, values);
    }

    public boolean addGameGenres(List<String> genre, Game game) {
        boolean isSuccessful = false;
        String statement = "INSERT INTO Game_Genre (genre_id, game_id) VALUES (?, ?)";
        ArrayList<String> values = null;
        for (int i = 0; i < genre.size(); i++) {

            if (allGenres.get(i).getGenre().equals(genre.get(i))) {
                values = new ArrayList<>(Arrays.asList(allGenres.get(i).getGenre_key() + "", game.getGame_id() + ""));
                isSuccessful = setData(statement, values);
            }

        }
        return isSuccessful;

    }

    public boolean deleteGame(int game_id) {
        String statement = "DELETE FROM Game_Features WHERE game_key = ?";
        String statement2 = "DELETE FROM Game_Genre WHERE game_id = ?";
        String statement3 = "DELETE FROM Game WHERE game_id = ?";
        String statement4 = "DELETE FROM Cart WHERE game_id = ?";
        String statement5 = "DELETE FROM Wishlist WHERE game_id = ?";
        String statement6 = "DELETE FROM GameSales WHERE game_id = ?";
        ArrayList<String> values = new ArrayList<>(Arrays.asList(game_id + ""));
        this.setData(statement, values);
        this.setData(statement2, values);
        this.setData(statement4, values);
        this.setData(statement5, values);
        this.setData(statement6, values);
        for (int i = 0; i < allGames.size(); i++) {
            if (allGames.get(i).getGame_id() == game_id) {
                allGames.remove(i);
            }
        }
        filterList();
        return this.setData(statement3, values);
    }

    public boolean addGameSales(GameSales gameSales, TypeOfPayment typeOfPayment, List<String> gameIdList) {
        String statement = "INSERT INTO GameSales (game_code, price, date, type_of_payment, user_key, game_key) VALUES (?, ?, ?, ?, ?, ?)";
        ArrayList<String> values = null;
        boolean isSuccessful = false;
        for (int i = 0; i < gameIdList.size(); i++) {
            values = new ArrayList<>(
                    Arrays.asList(gameSales.getGame_code(), gameSales.getPrice() + "", gameSales.getDate(),
                            typeOfPayment.getType_id() + "", this.user.getUsername(), gameIdList.get(i)));
            isSuccessful = setData(statement, values);
            if (!isSuccessful)
                return isSuccessful;
        }

        return isSuccessful;
    }

    public boolean editUser(User user) {
        String statement = "UPDATE User SET firstName = ?, lastName = ?, phone = ?, email = ?, address = ?, city = ?, zip = ?, country = ? WHERE username = ?";
        ArrayList<String> values = new ArrayList<>(
                Arrays.asList(user.getFirstName(), user.getLastName(), user.getPhone(), user.getEmail(),
                        user.getAddress(), user.getCity(), user.getZip(), user.getCountry(), user.getUsername()));

        return this.setData(statement, values);
    }

    public String generateCode() {
        Random random = new Random();
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < 19; i++) {
            if (i % 5 == 4) {
                code.append("-");
            } else {
                char c = (char) (random.nextInt(26) + 'A');
                if (i % 2 == 0) {
                    code.append(c);
                } else {
                    int n = random.nextInt(10);
                    code.append(n);
                }
            }
        }
        return code.toString();
    }

    public int pickedGame(String gameName){
        for (int i = 0; i < allGames.size(); i++) {
            if(gameName.equals(allGames.get(i).getGame_name())) return i;
        }
        return -1;
    }
}