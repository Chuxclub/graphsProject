public class Vertice {
    
    private Color[] color;
    private int[] distance;
    private int[] parent;
    
    public Vertice(int order)
    {
        color = new Color[order];
        distance = new int[order];
        parent = new int[order];
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
}
