package kruskal;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author taravat
 */
public class node {
    int id;
    int setNumber;
    Circle node;
    Group root;

    public node(int setNumber,int id, Circle node, int x, int y, Group root) {
        this.setNumber=setNumber;
        this.id = id;
        this.node=node;
        this.node.setCenterX(x);
        this.node.setCenterY(y);
        this.node.setRadius(25);
        this.node.setFill(Color.GRAY.darker());
        root.getChildren().add(node);
    }

}
