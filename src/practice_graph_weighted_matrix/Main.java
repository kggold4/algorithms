package practice_graph_weighted_matrix;

public class Main {
    public static void main(String[] args) {
        weighted_graph_matrix m = new GraphWeightedMatrix(5);
        m.connect(1, 2, 15);
        m.connect(2, 4, 12);
        System.out.println(m);
        m.floyd_warshall();
        System.out.println(m);
        System.out.println(GraphWeightedMatrix.toString(m.path_matrix()));
    }
}
