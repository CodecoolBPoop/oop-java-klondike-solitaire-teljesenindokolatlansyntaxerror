package com.codecool.klondike;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;




import java.awt.*;

public class Klondike extends Application {

    private static final double WINDOW_WIDTH = 1400;
    private static final double WINDOW_HEIGHT = 900;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Card.loadCardImages();
        Game game = new Game();
        BorderPane root = new BorderPane(game);
        game.setTableBackground(new Image("/table/green.png"));

        primaryStage.setTitle("Klondike Solitaire by teljesenIndokolatlanSyntaxError");
        primaryStage.setScene(new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT));
        primaryStage.show();

        // Main menu bar
        MenuBar menuBar = new MenuBar();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        root.setTop(menuBar);

        // File menu
        Menu fileMenu = new Menu("File");

        // File menu items
        MenuItem newGameMenuItem = new MenuItem("New Game");
        MenuItem undoMenuItem = new MenuItem("Undo step");
        MenuItem optionsMenuItem = new MenuItem("Options");
        MenuItem exitMenuItem = new MenuItem("Exit Game");
        exitMenuItem.setOnAction(actionEvent -> Platform.exit());

        fileMenu.getItems().addAll(newGameMenuItem, undoMenuItem, optionsMenuItem,
                new SeparatorMenuItem(), exitMenuItem);

        menuBar.getMenus().addAll(fileMenu);
    }

}
