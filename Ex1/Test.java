public class Test
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
    
    
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
	// ~~~~~~~~~~~~~~~~~~ GraphSimple ~~~~~~~~~~~~~~~~~ //
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
	
	GraphSimple gTest = new GraphSimple(order);
	
	for(int i = 0; i < order; i++)
	    gTest.setAdjacencyList(i, graph[i]);
	    
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
	// ~~~~~~~~~~~~~~~~~ DFS on Graph ~~~~~~~~~~~~~~~~~ //
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
        DFS dfsTest = new DFS(gTest);
        dfsTest.printState();
    }
}
