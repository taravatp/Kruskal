package kruskal;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

import javafx.stage.Stage;

/**
 *
 * @author taravat
 */
public class Kruskal extends Application {

    @Override
    public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root, 1000, 500);
        scene.setFill(Color.BLACK.brighter());
        board board = new board();

        Graph graph1 = new Graph(0, root, null);//node va yal ra misazad

        List<edge> result = new ArrayList<>();
        result = kruskal(graph1);
        System.out.println(result.size());
        Graph graph2 = new Graph(1, root, result);

        board.printBoard(root);
        board.printMyGraph(root, graph1, stage, scene);
        board.printMyGraph(root, graph2, stage, scene);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public List<edge> kruskal(Graph graph) {
        //result=tohi
        List<edge> result = new ArrayList<>();
        //for each vertex v do make-set
        int set[] = new int[graph.v.size()];//parent
        for (int i = 0; i < set.length; i++) {

            set[i] = graph.v.get(i).id;
        }

        int count[] = new int[graph.v.size()];
        for (int i = 0; i < count.length; i++) {
            count[i] = 1;
        }
        //sort the edges into nondecresing order by weight
        graph.sort();
        for (int i = 0; i < graph.edges.size(); i++) {
            System.out.println(graph.edges.get(i).source.id + " " + graph.edges.get(i).destination.id + " weight " + graph.edges.get(i).weight);
        }
        for (int i = 0; i < graph.edges.size(); i++) {
            if (set[graph.edges.get(i).source.id - 1] != set[graph.edges.get(i).destination.id - 1])//if find set(u)!=find set(v)
            {
                result.add(graph.edges.get(i));//a=a ejtema (u,v)
                if (count[graph.edges.get(i).source.id - 1] >= count[graph.edges.get(i).destination.id - 1]) {

                    for (int j = 0; j < graph.edges.size(); j++) {
                        if (set[graph.edges.get(j).destination.id - 1] == set[graph.edges.get(i).destination.id - 1]) {
                            count[graph.edges.get(j).source.id - 1]++;
                            count[graph.edges.get(j).destination.id - 1] = count[graph.edges.get(i).source.id - 1];
                            set[graph.edges.get(j).destination.id - 1] = set[graph.edges.get(i).source.id - 1];
                        }

                    }
                } else {

                    for (int j = 0; j < graph.edges.size(); j++) {
                        if (set[graph.edges.get(j).source.id - 1] == set[graph.edges.get(i).source.id - 1]) {
                            count[graph.edges.get(j).destination.id - 1]++;
                            count[graph.edges.get(j).source.id - 1] = count[graph.edges.get(i).destination.id - 1];
                            set[graph.edges.get(j).source.id - 1] = set[graph.edges.get(i).destination.id - 1];
                        }

                    }
                }
            }
        }
        System.out.println("my result=>");
        for (int i = 0; i < result.size(); i++) {
            System.out.println("shomare yal=>" + i + " source= " + result.get(i).source.id + " dest= " + result.get(i).destination.id);
        }

        return result;
    }

}
