public class Main
{
    public static void main(String[] args)
    {
        GraphSimpleIO.initialize();
        int order = GraphSimpleIO.getScanner().nextInt();
        GraphSimple gTest = new GraphSimple(order);
          
        if(args.length == 0)
        {
            // On lit le tableau de listes d'adjacences depuis un
	    // fichier texte:	
	    int[][] graph = new int[order][];
	    graph = GraphSimpleIO.getGraph(graph);
	
	    // On instancie un objet graphe simple en lui associant
	    // le tableau de listes d'adjacences lu précédemment:
	    for(int i = 0; i < order; i++)
	        gTest.setAdjacencyList(i, graph[i]);
        }
        
        else if(args[0].equals("-m"))
        {
            // On lit la matrices d'adjacences depuis un
	    // fichier texte:	
            int[][] mat = new int[order][];
            mat = GraphSimpleIO.getMatrix(order);
            
            // On instancie un objet graphe simple en lui associant
	    // la matrice d'adjacence lue précédemment:
	    gTest.fromMatrix(mat);
        }
        
        else
        {
            System.out.println("Wrong arguments (only -m is allowed:"
            + " -m option allows to read adjacency matrix from file" 
            + " instead of adjacency lists array).");
            System.exit(-1);
        }
        
        // On exécute l'algorithme de parcours en largeur sur
	// le graphe simple instancié précédemment:
        DFS dfsTest = new DFS(gTest);
        dfsTest.execDFS();  
    }
}
