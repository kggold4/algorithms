package algorithms_1.algo_1_exercise1.lecture;

public class NodeCycle {
    public Integer data;
    public NodeCycle prev, next;
    public Mark m;

    //constructor
    public NodeCycle(Integer data, NodeCycle next) {
        this.data = data;
        this.next = next;
        this.m = Mark.W;
    }

    public String toString() { return "" + this.data; }
}