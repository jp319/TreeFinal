package group_6.treefinal;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainViewController {
    @FXML public Button bstButton;
    @FXML
    private void bstAction() {
        bstButton.setOnAction(e -> {
            try {
                setStage(new TreeVisualizer());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
    }
    private void setStage(TreeVisualizer menu) throws Exception {
        Stage menuStage = new Stage();
        menu.start(menuStage);
        menuStage.show();
    }
}