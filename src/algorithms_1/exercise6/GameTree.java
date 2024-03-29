package algorithms_1.exercise6;

/**
 * Game Numbers - Exhaustive Search Algorithm
 * Game assumption: number's amount is even
 * (array's length is even) 
 * Complexity: O(2^n)
 */
class Node{
	int index1, index2, diff1, diff2;
	boolean yes1, yes2;
	public Node(int index1, int index2){
		this.index1 = index1;
		this.index2 = index2;
		this.diff1 = 0;
		this.diff2 = 0;
		yes1 = false;
		yes2 = false;
	}
	public String toString(){
		return "["+index1+","+index2+"]"+
		" diff1 = "+diff1+" diff2 = "+diff2+
		" yes1 = "+yes1 + " yes2 = "+yes2;
	}
}// End Class Node

public class GameTree {
	// Class Node
	// Every node contains 2 sub-nodes: 1 - right, 2 - left  
	// index1, index2 - index of number in the sequence of prices
	// diff1 - sum of the first player, when choose the right child-node
	// diff2 - sum of the first player, when choose the left child-node

	// Class GameTree	
	private Node[] nodes;
	private int[] prices;
	/** parent returns the parent of vertex  i*/
	private  int parent(int i){return i/2;}
	/** leftChild returns the left child of vertex  i*/
	private  int leftChild(int i){return 2*i;}
	/** rightChild returns the right child of vertex  i*/
	private  int rightChild(int i){return 2*i+1;}

	// constructor 
	public GameTree(int []arr){
		prices = new int[arr.length+1];
		for (int i=1; i<prices.length; i++){
			prices[i] = arr[i-1];
		}	
		// create tree
		int len = (int)Math.pow(2, arr.length);
		int n = arr.length;
		nodes = new Node[len];
		nodes[1] = new Node(1,n);
		for (int i=1; i<nodes.length/2; i++){
			nodes[leftChild(i)] = new Node(nodes[i].index1+1,nodes[i].index2);
			nodes[rightChild(i)] = new Node(nodes[i].index1,nodes[i].index2-1);
		}
	}
	
	public int getWinPrice(){
		// set difference for leaves
		int level = nodes.length/2;
		for(int i=nodes.length/2; i<nodes.length; i++){
			nodes[i].diff1 = -prices[nodes[i].index1];
			nodes[i].diff2 = -prices[nodes[i].index2];
		}
		//printTree();
		// set difference to parents
		level = level/2;
		int factor = 1;
		int winPrice = 0, diff1=0, diff2=0;
		int m1 = 0, m2 = 0;
		for(int i=nodes.length-1; i>1; i=i-2){
			int par = parent(i);
			diff1 = nodes[i].diff1 + factor*prices[nodes[par].index2];
			diff2 = nodes[i].diff2 + factor*prices[nodes[par].index2];
			m1 = Math.max(diff1, diff2);
			if (factor>0) m1 = Math.min(diff1, diff2);
			nodes[par].diff1 = m1;
			diff1 = nodes[i-1].diff1 + factor*prices[nodes[par].index1];
			diff2 = nodes[i-1].diff2 + factor*prices[nodes[par].index1];
			m2 = Math.max(diff1, diff2);
			if (factor>0) m2 = Math.min(diff1, diff2);
			nodes[par].diff2 = m2;
			// build path
			if (factor>0){
				if (m1 >= m2) nodes[par].yes1 = true;
				else nodes[par].yes2 = true;
			}
			else{
				if (m1 >= m2) nodes[par].yes2 = true;
				else nodes[par].yes1 = true;
			}
			if (par == level){
				level = level/2;
				factor = -factor;
				System.out.println(i+",  factor: "+factor+", level: "+level);
			}
		}
		//printTree();
		winPrice = Math.max(m1, m2);
		return winPrice;
	}
	public void printPath(){
		String s = "";
		int child = 1;
		for (int i=2; i<prices.length; i++){
			if (nodes[child].yes1){
				s = s + nodes[child].index2 + "->";
				child = rightChild(child);
			}
			else if (nodes[child].yes2){
				s = s + nodes[child].index1 + "->";
				child = leftChild(child);
			}
		}
		s = s + nodes[child].index2;
		System.out.println("path: " + s);
	}

	public void printTree(){
		System.out.println();
		for (int i=1; i<nodes.length; i++){
			System.out.println(i+")  "+nodes[i].toString());
		}
		System.out.println();
	}
	
	public static int[] randArray(int size){
		int [] arr = new int[size];
		for(int i=0; i<arr.length; i++){
			arr[i] = (int)(Math.random()*100);
		}
		return arr;
	}
	public static void printIntegerArray(int [] arr){
		for(int t=0; t<arr.length; t++){
			System.out.print(arr[t]+", ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int arr[] = {1,3,6,1,3,6}; // winPrice = 6,  path: 6->5->1->2->3->4
		int arr1[] = {1,3,6,6,3,1};  // winPrice = 0, path: 6->1->5->2->4->3
		int arr2[] = {5,10,4,1};  // winPrice = 2,  path: 4->1->2->3
		int arr3[] = {7,10,20,1};  // winPrice = 16,  path: 1->2->3->4
		int arr4[] = {1,2,3,4};  // winPrice = 2,  path: 4->3->2->1
		int arr5[] = {1, 5, 3, 3, 5, 3};   // winPrice = 2,  path: 6->1->5->2->4->3
		int arr6[] = {3, 5, 3, 3, 5, 1};   // winPrice = 2,  path: 1->2->3->4->5->6
		int []arr7 = {5,20,10,1};  // winPrice = 6, path: 4->1->2->3
		int []arr8 = {1,20,17,4};  // winPrice = 6, path: 4->1->2->3
		int []arr9 = {10,17};  // winPrice = 7,  path: 2->1
		int arr10[] = {1,2,3,4,1,2,3,4}; // winPrice = 4,  path: 8->7->6->1->2->3->4->5
		int arr11[] = {1,2,3,4,5,6,7,8,9,10}; // winPrice = 5, path: 10->9->8->7->6->5->4->3->2->1
		int arr13[] = {48, 30, 1, 8, 5, 35}; // winPrice: 45, path: 1->6->2->3->4->5
		int arr12[] =randArray(8);
		printIntegerArray(arr7);
		GameTree gt = new GameTree(arr7);
		int winPrice = gt.getWinPrice();
		gt.printTree();
		gt.printPath();
		System.out.println("winPrice: "+winPrice);
	}
}
