import java.util.Scanner;

public class GraphSimpleIO
{
	private static Scanner scanner;
        
        // Afin d'interdire l'instanciation de cette classe:
	private GraphSimpleIO(){} 
        
        // Retourne un graphe composé de sommets
        // les sommets correspondent à ceux donnés en entrée System.in:
        public static int[][] getGraph(int[][] graph)
	{
            Scanner sc = getScanner();
            int graphSize = graph.length;
            graph = new int[graphSize][];

            int[] buffer = new int[graphSize];
            int cursor = 0;
            int j = 0;
            int vertex = 0;
		
            for(int i = 0; i < graphSize; i++)
	    {
                vertex = sc.nextInt();
                j = sc.nextInt();

                while(j != 0)
                {
                    buffer[cursor] = j-1;
                    cursor++;
                    j = sc.nextInt();
                }

                graph[vertex-1] = new int[cursor];
                System.arraycopy(buffer, 0, graph[vertex-1], 0, cursor);
                cursor = 0;
           }
           
           return graph;
	}
        
        public static int getInt()
	{
	    return scanner.nextInt();
	}
	
        // Retourne une matrice de taille matSize par matSize
        // elle est remplie avec les nombres données en entrée System.in:
	public static int[][] getMatrix(int matSize)
	{
		Scanner sc = getScanner();
		int[][] mat = new int[matSize][matSize];

		// On remplit:
		for(int i = 0; i < matSize; i++)
		{
			for(int j = 0; j < matSize; j++)
			{
				mat[i][j] = sc.nextInt();
			}
		}
		
		return mat;
	}
	
	public static Scanner getScanner()
	{
	    return scanner;
	}
        
	public static void initialize()
	{
	    scanner = new Scanner(System.in);
	}
        
	public static void printMatrix(int[][] mat)
	{
	    for(int i = 0; i < mat.length; i++)
            {
                for(int j = 0; j < mat[i].length;  j++)
                {
                    System.out.print(mat[i][j] + " ");
                }

                System.out.println();
            }
	}
	
	
	public static void printGraph(int[][] graph)
	{
	    System.out.println(graph.length + "\n");
		
            for(int i = 0; i < graph.length; i++)
            {
                for(int j = 0; j < graph[i].length; j++)
                {
                    System.out.print(graph[i][j] + 1 + " ");
                }

                System.out.println("0");
            }
	}

	public static void rawPrintGraph(int[][] graph)
	{
	    printGraph(graph);
	}
	
}
