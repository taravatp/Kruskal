package kruskal;

/**
 *
 * @author taravat
 */
public class edge {

    node source;
    node destination;
    int weight;

    public edge(node source, node dest, int weight) {
        this.source = source;
        this.destination = dest;
        this.weight = weight;
    }

}
