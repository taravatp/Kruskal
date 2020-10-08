package kruskal;

import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Line;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author taravat
 */
public class board {

    public void printBoard(Group root) {
        Line line = new Line();
        line.setStartX(500);
        line.setStartY(0);
        line.setEndX(500);
        line.setEndY(500);
        line.setStroke(Color.WHITE);
        line.setStrokeWidth(10);
        root.getChildren().add(line);

        Line line1 = new Line();
        line1.setStartX(0);
        line1.setStartY(440);
        line1.setEndX(1000);
        line1.setEndY(440);
        line1.setStroke(Color.WHITE);
        line1.setStrokeWidth(10);
        root.getChildren().add(line1);

        Text text = new Text();
        text.setText("MY GRAPH");
        text.setX(130);
        text.setY(483);
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 40));
        text.setFill(javafx.scene.paint.Color.CRIMSON);
        root.getChildren().add(text);

        Text text1 = new Text();
        text1.setText("THE MST");
        text1.setX(650);
        text1.setY(483);
        text1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 40));
        text1.setFill(javafx.scene.paint.Color.CRIMSON);
        root.getChildren().add(text1);

    }

    public void printMyGraph(Group root, Graph graph, Stage stage, Scene scene) {
        int count = 0;
        for (int i = 0; i < graph.edges.size(); i++) {
            connect(graph, graph.edges.get(i).source, graph.edges.get(i).destination, root, stage, scene, count);
            if (graph.id == 1) {
                count++;
            }
        }
    }

    public void connect(Graph graph, node a, node b, Group root, Stage stage, Scene scene, int count) {
        int weight = 0;
        for (int i = 0; i < graph.edges.size(); i++) {
            if (graph.edges.get(i).source == a && graph.edges.get(i).destination == b) {
                weight = graph.edges.get(i).weight;
            }
        }
        // System.out.println("inja>"+a.x);
        Line e = new Line();
        e.setStartX(a.node.getCenterX());
        e.setStartY(a.node.getCenterY());
        e.setEndX(b.node.getCenterX());
        e.setEndY(b.node.getCenterY());
        e.setStroke(Color.WHITE);
        e.setStrokeWidth(5);
        if (graph.id == 0) {
            root.getChildren().add(e);
            setWeight(graph, e, weight, root);
        } else {
            func(stage, scene, root, e, count);
        }
    }

    public void setWeight(Graph graph, Line e, int weight, Group root) {
        Text text = new Text();
        text.setText(Integer.toString(weight));
        text.setX((e.getStartX() + e.getEndX()) / 2);
        text.setY((e.getStartY() + e.getEndY()) / 2);
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));
        text.setFill(javafx.scene.paint.Color.CORNFLOWERBLUE);
        root.getChildren().add(text);
    }

    public static void func(Stage stage, Scene scene, Group root, Line e, int count) {
        Task<Void> sleeper = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                try {
                    Thread.sleep(count * 1000);
                } catch (InterruptedException e) {
                }
                return null;
            }
        };
        sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                    root.getChildren().add(e);
                stage.setScene(scene);
                stage.show();

            }
        });
        new Thread(sleeper).start();
    }

}
