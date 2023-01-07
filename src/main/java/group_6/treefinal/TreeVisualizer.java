package group_6.treefinal;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Objects;

public class TreeVisualizer extends Application {
    private static ArrayList<Integer> nodes = new ArrayList<>();
    @Override
    public void start(Stage stage) throws Exception {
        BST<Integer> tree = new BST<>();
        BorderPane pane = new BorderPane();
        TreePane view = new TreePane(tree);
        setPane(pane, view, tree);
        setStage(pane, stage, "BST Visualisation");
    }
    public void setStage(BorderPane pane, Stage stage, String title){
        Scene scene = new Scene(pane, 840,480);
        stage.setTitle(title);
        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/tree-icon.png")));
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.show();
    }
    public void setPane(BorderPane pane, TreePane view, BST<Integer> tree){
        pane.setCenter(view);
        TextField textField = new TextField();
        textField.setPrefColumnCount(3);
        textField.setAlignment(Pos.BASELINE_RIGHT);
        Button insert = new Button("Insert");
        Button delete = new Button("Delete");
        Button inorder = new Button("Inorder");
        addFunctionalities(textField, insert, delete, inorder, tree, view);
        HBox hBox = new HBox(5);
        hBox.getChildren().addAll(new Label("Enter a value"), textField, insert, delete, inorder);
        hBox.setAlignment(Pos.BASELINE_CENTER);
        pane.setBottom(hBox);
    }
    public void addFunctionalities(TextField textField, Button insert, Button delete, Button inorder,BST<Integer> tree, TreePane view){
        insert.setOnAction(e->{
            if(textField.getText().length() == 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "You haven't entered anything!", ButtonType.OK);
                alert.getDialogPane().setMinHeight(80);
                alert.show();
            }
            else {
                int key = Integer.parseInt(textField.getText());
                nodes.add(key);
                if (tree.search(key)) {
                    view.displayTree();
                    view.setStatus(key + " is already present!");
                } else {
                    tree.insert(key);
                    view.displayTree();
                    view.setStatus(key + " is inserted!");
                }
                textField.clear();
            }
        });

        delete.setOnAction(e->{
            int key = Integer.parseInt(textField.getText());
            if(!tree.search(key)){
                view.displayTree();
                view.setStatus(key +" is not present!");
            }
            else{
                tree.delete(key);
                view.displayTree();
                view.setStatus(key+" is replaced by its predecessor and is deleted!");
            }
            textField.clear();
        });

        inorder.setOnAction(e -> {
            tree.inorder();
            view.displayTree();
            view.setStatus("Inorder Traversal: " + tree.getStoredResult());
        });
    }
}
