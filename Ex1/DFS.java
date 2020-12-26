package Ex1;

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
    
    public void initColors()
    {
        for(int i = 0; i < this.graph.order(); i++)
            this.color[i] = Color.Green;
    }
}
