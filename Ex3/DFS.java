import java.util.*;

public class DFS
{
    private GraphSimple graph;
    
    //Ex2:
    private boolean isConnected;
    
    private Vertices vertices;
    
    //Ex3:
    private int[] component;
    
    public DFS(GraphSimple graph)
    {
        this.graph = graph;
        int order = graph.order();
        
        this.vertices = new Vertices(order);
        
        //Ex3:
        component = new int[order];
        
        initColors();
    }
    
    public void execDFS()
    {
        int order = this.graph.order();
        boolean isConnected = true;
        
        for(int i = 0; i < order; i++)
        {
            if(this.vertices.getColor(i) == Color.Green)
            {
                //Ex2:
                if(i > 0)
                    isConnected = false;

                vertexDFS(i);
            }
        }
        
        //Ex2:
        this.isConnected = isConnected;
        
        //Debug:
        this.printState();
    }
      
    //Ex3:
    public int getComponent(int vertex)
    {
        return this.component[vertex];
    }
    
    public void initColors()
    {
        for(int i = 0; i < this.graph.order(); i++)
            this.vertices.setColor(i, Color.Green);
    }
    
    //Ex3:
    public void setComponent(int vertex, int component)
    {
        this.component[vertex] = component;
    }
    
    public void vertexDFS(int v)
    {
        //On crée une file d'attente locale à l'algorithme:
        int order = this.graph.order();
        LinkedList<Integer> waitingQueue = new LinkedList<>();
        
        //On ajoute la racine dans la file et on initialise ses valeurs:
        waitingQueue.add(v);
        this.vertices.setDistance(v, 0);
        this.vertices.setColor(v, Color.Orange);
        this.vertices.setParent(v, 0);
        
        //Ex3:
        this.setComponent(v, v + 1);
        
        
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
        //~~~~~~~~~~ Itération ~~~~~~~~~//
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
        
        while(!(waitingQueue.isEmpty()))
        {
            int vertex = waitingQueue.remove();
            int[] vertexAdjList = this.graph.getAdjacencyList(vertex);
        
            for(int i = 0; i < vertexAdjList.length; i++)
            {
                if(this.vertices.getColor(vertexAdjList[i]) == Color.Green)
                {
                    this.vertices.setColor(vertexAdjList[i], Color.Orange);
                    this.vertices.setDistance(vertexAdjList[i], this.vertices.getDistance(vertex) + 1);
                    this.vertices.setParent(vertexAdjList[i], vertex + 1);
                    
                    //Ex3:
                    this.setComponent(vertexAdjList[i], v + 1);
                    
                    waitingQueue.add(vertexAdjList[i]);
                }
            }
        
            this.vertices.setColor(vertex, Color.Red);
        }
    }
    
    
    //~~~~~~ Debug:
    public void printState()
    {
        int order = this.graph.order();
        
        printVertices();
        System.out.print("Colors         : ");
        for(int i = 0; i < order; i++)
            System.out.print(this.vertices.getColor(i) + " ");
        System.out.println("\n");
        
        
        printVertices();
        System.out.print("Distances      : ");
        for(int i = 0; i < order; i++)
            System.out.print(this.vertices.getDistance(i) + " ");
        System.out.println("\n");
        
        
        printVertices();
        System.out.print("Parents        : ");
        for(int i = 0; i < order; i++)
            System.out.print(this.vertices.getParent(i) + " ");
        System.out.println("\n");
        
        
        //Ex2:
        System.out.print("Connectivity   : ");
        System.out.println(this.isConnected + " \n");
        
        
        //Ex3:
        printVertices();
        System.out.print("Components     : ");
        for(int i = 0; i < order; i++)
            System.out.print(this.component[i] + " ");
        System.out.println("\n");
    }
    
    public void printVertices()
    {
        int order = this.graph.order();
        
        System.out.print("Vertices       : ");
        for(int i = 0; i < order; i++)
            System.out.print(i+1 + " ");
        System.out.println();
    }
}
