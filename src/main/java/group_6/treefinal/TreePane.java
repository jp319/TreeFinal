package group_6.treefinal;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

import java.util.Objects;

public class TreePane extends Pane {
    private BST<Integer> tree;
    private double radius = 15;
    private double vGap = 50;
    protected TreePane() { }
    TreePane(BST<Integer> tree) {
        this.tree = tree;
        setStatus("Tree is empty");
        //setBackground(new Background(new BackgroundFill(Color.web("#" + "40E0D0"), CornerRadii.EMPTY, Insets.EMPTY)));
        setBackground(new Background(new BackgroundFill(Color.web("rgb(31,37,41)"), CornerRadii.EMPTY, Insets.EMPTY)));
        //Tree BG
        String treePath = "images/tree.png";
        Image newImage =new Image(Objects.requireNonNull(getClass().getResourceAsStream(treePath)));
        ImageView treeImage = new ImageView(newImage);
        treeImage.setFitWidth(595);
        treeImage.setFitHeight(450);
        treeImage.setX(100);
        treeImage.setY(5);
        getChildren().add(treeImage);
    }
    public void setStatus(String msg){
        Text text = new Text(20, 20,msg);
        text.setFill(Color.WHITE);
        getChildren().add(text);
    }
    public void displayTree(){
        this.getChildren().clear();
        //Tree BG
        String treePath = "images/tree.png";
        Image newImage =new Image(Objects.requireNonNull(getClass().getResourceAsStream(treePath)));
        ImageView treeImage = new ImageView(newImage);
        treeImage.setFitWidth(595);
        treeImage.setFitHeight(450);
        treeImage.setX(100);
        treeImage.setY(5);
        getChildren().add(treeImage);
        ///
        if(tree.getRoot() != null){
            displayTree(tree.getRoot(), getWidth() / 2, vGap, getWidth() / 4, Color.rgb(31, 37, 41));
        }
    }
    protected void displayTree(TreeNode<Integer> root, double x, double y, double hGap, Color color){
        if(root.left != null){
            Line line = new Line(x - hGap, y + vGap, x, y);
            line.setStroke(Color.WHITE);
            getChildren().add(line);
            displayTree(root.left, x - hGap, y + vGap, hGap / 2,color);
        }
        if (root.right != null){
            Line line = new Line(x + hGap, y + vGap, x, y);
            line.setStroke(Color.WHITE);
            getChildren().add(line);
            displayTree(root.right, x + hGap, y + vGap, hGap / 2, color);
        }
        ImageView apple = new ImageView();
        String applePath = "images/apple.png";
        Image newImage =new Image(Objects.requireNonNull(getClass().getResourceAsStream(applePath)));
        apple.setImage(newImage);
        apple.setX(x-20);
        apple.setY(y-30);
        apple.setFitHeight(50);
        apple.setFitWidth(50);
        Text text = new Text(x - 4, y + 4,root.element + "");
        text.setFill(Color.WHITE);
        getChildren().addAll(apple, text);
    }
}
