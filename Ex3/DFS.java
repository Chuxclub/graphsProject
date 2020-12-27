import java.util.*;

public class DFS
{
    private GraphSimple graph;
    
    //Ex2:
    private boolean isConnected;
    
    private Color[] color;
    private int[] distance;
    private int[] parent;
    
    public DFS(GraphSimple graph)
    {
        this.graph = graph;
        int order = graph.order();
        
        color = new Color[order];
        distance = new int[order];
        parent = new int[order];
        
        initColors();
    }
    
    public void execDFS()
    {
        int order = this.graph.order();
        boolean isConnected = true;
        
        for(int i = 0; i < order; i++)
        {
            if(this.getColor(i) == Color.Green)
            {
                //Ex2:
                if(i > 0)
                    isConnected = false;

                vertexDFS(i);
            }
        }
        
        this.isConnected = isConnected;
        this.printState();
    }
    
    public Color getColor(int vertex)
    {
        return this.color[vertex];
    }
    
    public int getDistance(int vertex)
    {
        return this.distance[vertex];
    }
    
    public int getParent(int vertex)
    {
        return this.parent[vertex];
    }
    
    public void initColors()
    {
        for(int i = 0; i < this.graph.order(); i++)
            this.color[i] = Color.Green;
    }
    
    public void setColor(int vertex, Color color)
    {
        this.color[vertex] = color;
    }
    
    public void setDistance(int vertex, int distance)
    {
        this.distance[vertex] = distance;
    }
    
    public void setParent(int vertex, int parent)
    {
        this.parent[vertex] = parent;
    }
    
    
    public void vertexDFS(int v)
    {
        //On crée une file d'attente locale à l'algorithme:
        int order = this.graph.order();
        LinkedList<Integer> waitingQueue = new LinkedList<>();
        
        //On ajoute la racine dans la file et on initialise ses valeurs:
        waitingQueue.add(v);
        this.setDistance(v, 0);
        this.setColor(v, Color.Orange);
        this.setParent(v, 0);
        
        
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
        //~~~~~~~~~~ Itération ~~~~~~~~~//
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
        
        while(!(waitingQueue.isEmpty()))
        {
            int vertex = waitingQueue.remove();
            int[] vertexAdjList = this.graph.getAdjacencyList(vertex);
        
            for(int i = 0; i < vertexAdjList.length; i++)
            {
                if(this.getColor(vertexAdjList[i]) == Color.Green)
                {
                    this.setColor(vertexAdjList[i], Color.Orange);
                    this.setDistance(vertexAdjList[i], this.getDistance(vertex) + 1);
                    this.setParent(vertexAdjList[i], vertex + 1);
                    waitingQueue.add(vertexAdjList[i]);
                }
            }
        
            this.setColor(vertex, Color.Red);
        }
    }
    
    
    //~~~~~~ Debug:
    public void printState()
    {
        int order = this.graph.order();
        
        System.out.print("Colors         : ");
        for(int i = 0; i < order; i++)
            System.out.print(this.color[i] + " ");
        System.out.println("\n");
        
        
        System.out.print("Distances      : ");
        for(int i = 0; i < order; i++)
            System.out.print(this.distance[i] + " ");
        System.out.println("\n");
        
        
        System.out.print("Parents        : ");
        for(int i = 0; i < order; i++)
            System.out.print(this.parent[i] + " ");
        System.out.println("\n");
        
        //Ex2:
        System.out.print("Connectivity   : ");
        System.out.println(this.isConnected + " \n");
    }
}
