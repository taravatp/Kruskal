package kruskal;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.Group;
import javafx.scene.shape.Circle;

/**
 *
 * @author taravat
 */
public class Graph {

    List<node> v = new ArrayList<>();
    List<edge> edges = new ArrayList<>();
    int id;
    Group root;

    public Graph(int id, Group root,List<edge> result) {
        this.id = id;
        this.root = root;
        setNode();
        if (id == 0) {
            setEdge();
        }
        else{
            setEdge(result);
        }
    }

    public Graph(List<edge> edges, int i, Group root) {
        this.id = i;
        this.edges = edges;
        setNode();
        this.root = root;
    }

    void setNode() {
        this.v.add(new node(1, 1, new Circle(), 75 + this.id * 500, 225, this.root));
        this.v.add(new node(2, 2, new Circle(), 225 + this.id * 500, 75, this.root));
        this.v.add(new node(3, 3, new Circle(), 225 + this.id * 500, 325, this.root));
        this.v.add(new node(4, 4, new Circle(), 325 + this.id * 500, 75, this.root));
        this.v.add(new node(5, 5, new Circle(), 325 + this.id * 500, 325, this.root));
        this.v.add(new node(6, 6, new Circle(), 425 + this.id * 500, 225, this.root));
    }

    void setEdge() {
        this.edges.add(new edge(v.get(0), v.get(1), 3));
        this.edges.add(new edge(v.get(0), v.get(2), 1));
        this.edges.add(new edge(v.get(1), v.get(3), 2));
        this.edges.add(new edge(v.get(1), v.get(2), 5));
        this.edges.add(new edge(v.get(2), v.get(3), 4));
        this.edges.add(new edge(v.get(3), v.get(4), 3));
        this.edges.add(new edge(v.get(4), v.get(5), 3));
    }
    void setEdge(List<edge> result)
    {
        for(int i=0 ; i<result.size() ; i++)
        {
           this.edges.add(new edge(v.get(result.get(i).source.id-1),v.get(result.get(i).destination.id-1),result.get(i).weight));
        }
    }
    public void sort() {
        for (int i = 0; i < edges.size() - 1; i++) {
            for (int j = 0; j < edges.size() - i - 1; j++) {
                if (edges.get(j).weight > edges.get(j + 1).weight) {
                    edge temp = new edge(edges.get(j).source, edges.get(j).destination, edges.get(j).weight);
                    edges.set(j, new edge(edges.get(j + 1).source, edges.get(j + 1).destination, edges.get(j + 1).weight));
                    edges.set(j + 1, temp);

                }
            }
        }
    }
}
