
import java.util.Scanner;

public class GraphSimple
{

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
    // ~~~~~~~~~~~~~~~~~~~~~~ (a) ~~~~~~~~~~~~~~~~~~~~~ //
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
	
    private int[][] graph;

    public GraphSimple(int ordre)
    {
        this.graph = new int[ordre][];
    }
	
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
    // ~~~~~~~~~~~~~~~~~~~~~~ (b) ~~~~~~~~~~~~~~~~~~~~~ //
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
    
    public void setAdjacencyList(int vertex, int[] adjList)
    {
        this.graph[vertex] = adjList;
    }
    
    public int[] getAdjacencyList(int vertex)
    {
        return this.graph[vertex];
    }
	
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
    // ~~~~~~~~~~~~~~~~~~~~~~ (c) ~~~~~~~~~~~~~~~~~~~~~ //
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
    
    public int order()
    {
        return this.graph.length;
    }
    
    public int degree(int vertex)
    {
        return this.graph[vertex].length;
    }
    
    public boolean isVertex(int n)
    {
        return n >= 1 && n <= this.order();
    }
    
    public boolean isEdge(int vX, int vY)
    {
        boolean found = false;
        
        for(int i = 0; i < this.graph[vX].length; i++)
        {
            if(this.graph[vX][i] == vY)
            {
                found = true;
                break;
            }
        }
        
        return found;
    }

	
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
    // ~~~~~~~~~~~~~~~~~~~~~~ (d) ~~~~~~~~~~~~~~~~~~~~~ //
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
    private int[][] matrix;
    private boolean isMatrix = false;
    
    public void toMatrix()
    {
        this.matrix = new int[this.order()][this.order()];

	//On remplit de 0:
	for(int i = 0; i < this.order(); i++)
	{
		for(int j = 0; j < this.order(); j++)
		{
			this.matrix[i][j] = 0;
		}
	}

	//On modifie selon graph:
	for(int i = 0; i < this.order(); i++)
	{
		for(int j = 0; j < this.graph[i].length; j++)
		{
			this.matrix[i][this.graph[i][j]] = 1;
		}
	}
	
	this.isMatrix = true;
    }
    
    public void fromMatrix(int[][] adjMat)
    {
        int order = order();
        adjMat = new int[order][];
	int[] buffer = new int[order];
	int cursor = 0;
		
	//On lit la matrice et on ajoute la colonne quand la
	//cellule vaut 1:
	for(int i = 0; i < order; i++)
	{
		for(int j = 0; j < order; j++)
		{
			if(this.matrix[i][j] == 1)
			{
				buffer[cursor] = j+1;
				cursor++;
			}
		}
			
		adjMat[i] = new int[cursor];
		System.arraycopy(buffer, 0, adjMat[i], 0, cursor);
		cursor = 0;
	}
    }
	
	
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
    // ~~~~~~~~~~~~~~~~~~~~~~ (e) ~~~~~~~~~~~~~~~~~~~~~ //
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
    
    public int[][] getMatrix()
    {
        return this.matrix;
    }
	
    // cf. GraphIT
}
