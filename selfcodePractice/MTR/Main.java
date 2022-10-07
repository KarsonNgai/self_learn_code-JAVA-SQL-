public class Main {
  public static void main(String[] arg){
    MTRmap.printAll();

    Graph graph = new Graph(10);

    for (MTRmap i : MTRmap.values()){
      graph.addNode(new Node(i.shortname));
    }

    graph.addEdge(0, 1);
    graph.addEdge(1, 2);
    graph.addEdge(2, 3);
    graph.addEdge(4, 5);
    graph.addEdge(5, 6);
    graph.addEdge(6, 7);
    graph.addEdge(3, 8);
    graph.addEdge(8, 9);

    graph.print();

    System.out.println("\n\nHere is the visited map");
    for (MTRmap i: MTRmap.values()){
      System.out.println("Station shortname is: "+i.shortname+" |Station name:"+ i.name);
      graph.depthFirstSearch(i.index);
      System.out.println("\n\n");
    }
  }
}
