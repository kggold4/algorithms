package practice;

public interface graph_matrix {
    public boolean[][] copy();
    public void connect(int i, int j);
    public void disconnect(int i, int j);
    public boolean isConnected(int i, int j);
    public String floyd_warshall();
    public String[][] path_matrix();
    public int size();
    public void clear();
}
