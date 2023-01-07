package group_6.treefinal;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AnimationBSTController implements Initializable {
    @FXML public ImageView treeImage;
    @FXML public Button nextButton;
    @FXML public Label lbTitle;
    @FXML public ImageView appleImage2;
    @FXML public ImageView appleImage1;
    @FXML public ImageView appleImage3;
    @FXML public Line lineRight;
    @FXML public Line lineLeft;
    @FXML public AnchorPane introPane;
    @FXML public Label lbNum1;
    @FXML public Label lbNum2;
    @FXML public Label lbNum3;
    Stage stage;
    Scene scene;
    public void switchToMainView(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("main-view.fxml"));
        Parent root = loader.load();
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setFullScreen(false);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        playIntro();
    }
    private void playIntro () {
        setAllToInvisible();
        fadeInLabel(lbTitle, 3000);
        PauseTransition pause = new PauseTransition(Duration.millis(3000));
        pause.setOnFinished(e -> {
            fadeInImage(treeImage,1000);
            PauseTransition pause1 = new PauseTransition(Duration.millis(1000));
            pause1.setOnFinished(e1 -> {
                fadeInImage(appleImage2,1000);
                fadeInLabel(lbNum2, 1000);
                PauseTransition pause2 = new PauseTransition(Duration.millis(1000));
                pause2.setOnFinished(e2 -> {
                    fadeInImage(appleImage1,1000);
                    fadeInLabel(lbNum1, 1000);
                    PauseTransition pause3 = new PauseTransition(Duration.millis(1000));
                    pause3.setOnFinished(e3 -> {
                        fadeInImage(appleImage3,1000);
                        fadeInLabel(lbNum3,1000);
                        PauseTransition pause4 = new PauseTransition(Duration.millis(1000));
                        pause4.setOnFinished(e4 -> {
                            fadeInLine(lineLeft, 1000);
                            PauseTransition pause5 = new PauseTransition(Duration.millis(1000));
                            pause5.setOnFinished(e5 -> {
                                fadeInLine(lineRight,1000);
                                PauseTransition pause6 = new PauseTransition(Duration.millis(1000));
                                pause6.setOnFinished(e6 -> {
                                    fadeInButton(nextButton,1000);
                                }); pause6.play();
                            }); pause5.play();
                        }); pause4.play();
                    }); pause3.play();
                }); pause2.play();
            }); pause1.play();
        }); pause.play();
    }
    private void setAllToInvisible() {
        treeImage.setOpacity(0);
        nextButton.setOpacity(0);
        lbTitle.setOpacity(0);
        appleImage1.setOpacity(0);
        appleImage2.setOpacity(0);
        appleImage3.setOpacity(0);
        lineLeft.setOpacity(0);
        lineRight.setOpacity(0);
        lbNum1.setOpacity(0);
        lbNum2.setOpacity(0);
        lbNum3.setOpacity(0);
    }
    private void fadeInImage(ImageView image, int duration) {
        FadeTransition fadeIn = new FadeTransition();
        fadeIn.setNode(image);
        fadeIn.setDuration(Duration.millis(duration));
        fadeIn.setCycleCount(1);
        fadeIn.setInterpolator(Interpolator.LINEAR);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        fadeIn.play();
    }
    private void fadeInButton(Button button, int duration) {
        FadeTransition fadeIn = new FadeTransition();
        fadeIn.setNode(button);
        fadeIn.setDuration(Duration.millis(duration));
        fadeIn.setCycleCount(1);
        fadeIn.setInterpolator(Interpolator.LINEAR);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        fadeIn.play();
    }
    private void fadeInLine(Line line, int duration) {
        FadeTransition fadeIn = new FadeTransition();
        fadeIn.setNode(line);
        fadeIn.setDuration(Duration.millis(duration));
        fadeIn.setCycleCount(1);
        fadeIn.setInterpolator(Interpolator.LINEAR);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        fadeIn.play();
    }
    private void fadeInLabel(Label label, int duration) {
        FadeTransition fadeIn = new FadeTransition();
        fadeIn.setNode(label);
        fadeIn.setDuration(Duration.millis(duration));
        fadeIn.setCycleCount(1);
        fadeIn.setInterpolator(Interpolator.LINEAR);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        fadeIn.play();
    }
}