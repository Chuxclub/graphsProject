
public class GraphIT
{
    public static void main(String[] args)
    {
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
	// ~~~~~~~~~~~~~~~~~ GraphSimpleIO ~~~~~~~~~~~~~~~~ //
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
	
        GraphSimpleIO.initialize();
        int order = GraphSimpleIO.getScanner().nextInt();
        
        int[][] graph = new int[order][];
        graph = GraphSimpleIO.getGraph(graph);
        
        GraphSimpleIO.printGraph(graph);
        System.out.println("\n");
    
    
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
	// ~~~~~~~~~~~~~~~~~~ GraphSimple ~~~~~~~~~~~~~~~~~ //
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
	
	GraphSimple gTest = new GraphSimple(order);
	
	for(int i = 0; i < order; i++)
	    gTest.setAdjacencyList(i, graph[i]);
	    
	gTest.toMatrix();
	GraphSimpleIO.printMatrix(gTest.getMatrix());
    }
}
