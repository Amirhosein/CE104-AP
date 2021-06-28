package main;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * The type Main window controller.
 */
public class MainWindowController {
    @FXML
    private Pane titlePane;
    @FXML
    private ImageView btnMinimize, btnClose;
    @FXML
    private Label lblResult;

    private double x, y;
    private double num1 = 0;
    private String operator = "+";
    private boolean isEnough = false;

    /**
     * Init.
     *
     * @param stage the stage
     */
    public void init(Stage stage) {
        titlePane.setOnMousePressed(mouseEvent -> {
            x = mouseEvent.getSceneX();
            y = mouseEvent.getSceneY();
        });
        titlePane.setOnMouseDragged(mouseEvent -> {
            stage.setX(mouseEvent.getScreenX() - x);
            stage.setY(mouseEvent.getScreenY() - y);
        });

        btnClose.setOnMouseClicked(mouseEvent -> stage.close());
        btnMinimize.setOnMouseClicked(mouseEvent -> stage.setIconified(true));
    }

    /**
     * On number clicked.
     *
     * @param event the event
     * @throws UnsupportedAudioFileException the unsupported audio file exception
     * @throws IOException                   the io exception
     */
    @FXML
    void onNumberClicked(MouseEvent event) throws UnsupportedAudioFileException, IOException {
        soundEffect();
        int value = Integer.parseInt(((Pane) event.getSource()).getId().replace("btn", ""));
        lblResult.setText(Double.parseDouble(lblResult.getText()) == 0 ? String.valueOf((double) value) : String.valueOf(Double.parseDouble(lblResult.getText()) * 10 + value));
    }

    /**
     * Sound effect.
     *
     * @throws UnsupportedAudioFileException the unsupported audio file exception
     * @throws IOException                   the io exception
     */
    void soundEffect() throws UnsupportedAudioFileException, IOException {
        SimpleAudioPlayer simpleAudioPlayer = new SimpleAudioPlayer(AudioSystem.getAudioInputStream(Objects.requireNonNull(getClass().getResourceAsStream("../resources/sfx/click.wav"))));
        simpleAudioPlayer.start();
    }

    /**
     * On symbol clicked.
     *
     * @param event the event
     * @throws UnsupportedAudioFileException the unsupported audio file exception
     * @throws IOException                   the io exception
     */
    @FXML
    void onSymbolClicked(MouseEvent event) throws UnsupportedAudioFileException, IOException {
        soundEffect();
        String symbol = ((Pane) event.getSource()).getId().replace("btn", "");
        if (symbol.equals("Equals")) {
            double num2 = 0;
            if (!isEnough)
                num2 = Double.parseDouble(lblResult.getText());
            switch (operator) {
                case "+" -> lblResult.setText((num1 + num2) + "");
                case "-" -> lblResult.setText((num1 - num2) + "");
                case "*" -> lblResult.setText((num1 * num2) + "");
                case "/" -> lblResult.setText((num1 / num2) + "");
                case "^" -> lblResult.setText((java.lang.Math.pow(num1, num2)) + "");
                case "sin" -> {
                    lblResult.setText((Math.sin(Math.toRadians(num1))) + "");
                    isEnough = false;
                }
                case "cos" -> {
                    lblResult.setText((Math.cos(Math.toRadians(num1))) + "");
                    isEnough = false;
                }
                case "tan" -> {
                    lblResult.setText(Math.tan(Math.toRadians(num1)) + "");
                    isEnough = false;
                }
            }
            operator = ".";
        } else if (symbol.equals("Clear")) {
            lblResult.setText(String.valueOf(0.0));
            operator = ".";
            isEnough = false;
        } else {
            switch (symbol) {
                case "Plus" -> operator = "+";
                case "Minus" -> operator = "-";
                case "Multiply" -> operator = "*";
                case "Divide" -> operator = "/";
                case "Power" -> operator = "^";
                case "Sin" -> {
                    operator = "sin";
                    isEnough = true;
                }
                case "Cos" -> {
                    operator = "cos";
                    isEnough = true;
                }
                case "Tan" -> {
                    operator = "tan";
                    isEnough = true;
                }
            }
            num1 = Double.parseDouble(lblResult.getText());
            if (!isEnough)
                lblResult.setText(String.valueOf(0.0));
        }
    }
}
