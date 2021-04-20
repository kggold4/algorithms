package practice;

public class GraphWeightedMatrix implements weighted_graph_matrix {

    private final int infinity = Integer.MAX_VALUE;
    private int size;
    private int[][] mat;

    public GraphWeightedMatrix(int n) {
        this.size = n;
        this.mat = new int[this.size][this.size];
        clear();
    }

    @Override
    public int[][] copy() {
        int[][] newMatrix = new int[this.size][this.size];
        for(int i = 0; i < this.size; i++) {
            for(int j = 0; j < this.size; j++) {
                newMatrix[i][j] = this.mat[i][j];
            }
        }
        return newMatrix;
    }

    @Override
    public void connect(int i, int j, int w) { this.mat[i][j] = w; }

    @Override
    public int getWeight(int i, int j) { return this.mat[i][j]; }

    @Override
    public void disconnect(int i, int j) { this.mat[i][j] = Integer.MAX_VALUE; }

    @Override
    public boolean isConnected(int i, int j) {
        if(this.mat[i][j] < Integer.MAX_VALUE) return true;
        else return false;
    }

    @Override
    public void floyd_warshall() {
        for(int k = 0; k < this.size; k++) {
            for(int i = 0; i < this.size; i++) {
                for(int j = 0; j < this.size; j++) {
                    if(this.mat[i][k] != infinity && this.mat[k][j] != infinity) {
                        this.mat[i][j] = Math.min(this.mat[i][j], this.mat[i][k] + this.mat[k][j]);
                    }
                }
            }
        }
    }

    @Override
    public String[][] path_matrix() {
        return new String[0][];
    }

    @Override
    public int size() { return this.size; }

    @Override
    public void clear() {
        for(int i = 0; i < this.size; i++) {
            for(int j = 0; j < this.size; j++) {
                this.mat[i][j] = Integer.MAX_VALUE;
            }
        }
    }
}
