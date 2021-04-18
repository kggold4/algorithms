package practice;

public class Main {
    public static void main(String[] args) {
        GraphBooleanMatrix m = new GraphBooleanMatrix(5);
        m.connect(1, 2);
        m.connect(2, 4);
        System.out.println(m.toString());
        m.floyd_warshall();
        System.out.println(GraphBooleanMatrix.toString(m.path_matrix()));
    }
}
