package sp3ctrum;

import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Santiago Benoit
 */
public class GUI extends Application {
    
    @Override
    public void start(Stage stage) {
        // start scene
        this.stage = stage;
        Button playButton = new Button("Play");
        playButton.setOnAction((ActionEvent event) -> {
            stage.setScene(playScene);
            level = new Level();
            level.setDepth(10);
            level.setWidth(10);
            level.setHeight(10);
            level.setBluePosition(9, 8, 0);
            level.addTile(new Tile(0, 7, 0, false));
            level.addTile(new Tile(1, 7, 0, false));
            level.addTile(new Tile(4, 7, 0, false));
            level.addTile(new Tile(5, 7, 0, false));
            level.addTile(new Tile(6, 7, 0, false));
            level.addTile(new Tile(9, 7, 0, false));
            level.addTile(new Tile(0, 7, 1, false));
            level.addTile(new Tile(1, 7, 1, false));
            level.addTile(new Tile(2, 7, 1, false));
            level.addTile(new Tile(3, 7, 1, false));
            level.addTile(new Tile(4, 7, 1, false));
            speed = 8;
            refresh();
            playScene.setOnKeyPressed((KeyEvent event2) -> {
                switch (event2.getCode()) {
                    case W:
                        wDown = true;
                        break;
                    case A:
                        aDown = true;
                        break;
                    case S:
                        sDown = true;
                        break;
                    case D:
                        dDown = true;
                        break;
                    case SPACE:
                        spaceDown = true;
                        break;
                    case ESCAPE:
                        escDown = true;
                        break;
                    default:
                        break;
                }
                playScene.setOnKeyReleased((KeyEvent event3) -> {
                    switch (event3.getCode()) {
                        case W:
                        wDown = false;
                        break;
                    case A:
                        aDown = false;
                        break;
                    case S:
                        sDown = false;
                        break;
                    case D:
                        dDown = false;
                        break;
                    case SPACE:
                        spaceDown = false;
                        break;
                    case ESCAPE:
                        escDown = false;
                        break;
                    default:
                        break;
                    }
                });
            });
            startTimer();
        });
        Button editorButton = new Button("Level Editor");
        editorButton.setOnAction((ActionEvent event) -> {
            // add later
        });
        HBox buttonBox = new HBox();
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setPadding(new Insets(10, 10, 10, 10));
        buttonBox.setSpacing(10);
        buttonBox.getChildren().addAll(playButton, editorButton);
        BorderPane titlePane = new BorderPane();
        titlePane.setCenter(buttonBox);
        titleScene = new Scene(titlePane);
        stage.setTitle("SP3CTRUM");
        stage.setScene(titleScene);
        stage.setMinWidth(640);
        stage.setMinHeight(640);
        stage.centerOnScreen();
        stage.show();
        // play scene
        shooting = false;
        playStack = new StackPane();
        Button resumeButton = new Button("Resume");
        Button restartButton = new Button("Restart");
        Button quitButton = new Button("Quit");
        menu = new VBox();
        menu.setPadding(new Insets(10, 10, 10, 10));
        menu.setSpacing(10);
        menu.setStyle("-fx-background-color: rgba(128, 128, 128, 0.5); -fx-border-color: rgba(0, 0, 0, 0.5); -fx-border-width: 1px");
        menu.getChildren().addAll(resumeButton, restartButton, quitButton);
        menu.setVisible(false);
        spriteSheet = new Pane();
        levelGrid = new GridPane();
        levelGrid.setAlignment(Pos.CENTER);
        playStack = new StackPane();
        playStack.getChildren().addAll(levelGrid, spriteSheet, menu);
        playScene = new Scene(playStack);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public void refresh() {
        levelGrid.getChildren().clear();
        spriteSheet.getChildren().clear();
        for (int x = 0; x < level.getWidth(); x++) {
            for (int y = 0; y < level.getHeight(); y++) {
                int fx = x;
                int fy = y;
                StackPane stack = new StackPane();
                stack.setMinSize(64, 64);
                if (level.tileIsAt(x, y, player.getTileZ())) {
                    stack.setStyle("-fx-background-color: " + level.getTile(x, y, player.getTileZ()).getPaintColor().getColorHex() + "; -fx-border-color: #000000; -fx-border-width: 1px");
                } else {
                    stack.setStyle("-fx-background-color: #D3D3D3");
                }
                stack.setOnMousePressed((MouseEvent event) -> {
                    mouseX = fx;
                    mouseY = fy;
                    shootPaint();
                });
                levelGrid.add(stack, x - 1, level.getHeight() - y);
                spriteSheet.getChildren().addAll(playerView, blobView);
                blobView.setLayoutX(blobX);
                blobView.setLayoutY(blobY);
                playerView.setLayoutX(player.getX());
                playerView.setLayoutY(player.getY());
            }
        }
    }
    
    public synchronized void shootPaint() {
        if (!shooting) {
            blobX = player.getX();
            blobY = player.getY();
            int changeX = player.getChangeX(mouseX);
            int changeY = player.getChangeY(mouseY);
            double slope = player.getSlope(mouseX, mouseY);
            while (blobX < mouseX * TILESIZE) {
                
            }
        }
    }
    
    public void startTimer() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (wDown) {
                    player.moveForward();
                }
                if (aDown) {
                    player.moveLeft();
                }
                if (sDown) {
                    player.moveBackward();
                }
                if (dDown) {
                    player.moveRight();
                }
                if (spaceDown) {
                    if (!jumping) {
                        player.jump();
                    }
                }
                if (escDown) {
                    menu.setVisible(true);
                }
                refresh();
            }
        }, 0, delay);
    }
    
    public static final String VERSION = "1.0";
    private Scene titleScene, playScene;
    private GridPane levelGrid;
    public static Level level;
    public static Player player;
    public static double blobX, blobY;
    private Pane spriteSheet;
    private StackPane playStack;
    private BufferedImage playerImg, blobImg;
    private ImageView playerView, blobView;
    private final int delay = 10;
    private static final int TILESIZE = 64;
    private int mouseX, mouseY;
    private VBox menu;
    private Stage stage;
    private boolean wDown, aDown, sDown, dDown, spaceDown, escDown, shooting;
    public static boolean jumping;
    public static int speed;
}
