public class DFS
{
    private GraphSimple graph;
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
    
    
    //~~~~~~ Debug:
    public void printState()
    {
        int order = this.graph.order();
        
        System.out.print("Colors: ");
        for(int i = 0; i < order; i++)
            System.out.print(this.color[i] + " ");
        System.out.println("\n");
        
        
        System.out.print("Distances: ");
        for(int i = 0; i < order; i++)
            System.out.print(this.distance[i] + " ");
        System.out.println("\n");
        
        
        System.out.print("Parents: ");
        for(int i = 0; i < order; i++)
            System.out.print(this.parent[i] + " ");
        System.out.println("\n");
    }
}
