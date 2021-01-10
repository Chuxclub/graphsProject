import java.util.*;

public class DFS
{
    private GraphSimple graph;
    private Vertices vertices;
    
    //Ex2:
    private boolean isConnected;
    
    public DFS(GraphSimple graph)
    {
        this.graph = graph;
        int order = graph.order();
        
        this.vertices = new Vertices(order);
        
        initColors();
    }
    
    // Exécute le parcours en largeur sur toutes
    // les composantes connexes du graphe (on choisit une 
    // nouvelle racine pour chaque composante connexe, si le graphe
    // n'a qu'une seule composante connexe alors tous les sommets auront
    // été explorés dès le premier tour de boucle) : 
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
    
    public void initColors()
    {
        for(int i = 0; i < this.graph.order(); i++)
            this.vertices.setColor(i, Color.Green);
    }
    
    // Exécute le parcours en largeur sur la composante connexe
    // du graphe dans laquelle se trouve le sommet passé en paramètre v:
    public void vertexDFS(int v)
    {
        // On crée une file d'attente locale à l'algorithme:
        int order = this.graph.order();
        LinkedList<Integer> waitingQueue = new LinkedList<>();
        
        // On ajoute la racine dans la file et on initialise ses valeurs:
        waitingQueue.add(v);
        this.vertices.setDistance(v, 0);
        this.vertices.setColor(v, Color.Orange);
        this.vertices.setParent(v, 0);
        
        
        // ============== Itération ==============
        
        // Tant que la file d'attente n'est pas vide:
        while(!(waitingQueue.isEmpty()))
        {
            // On retire le sommet en tête:
            int vertex = waitingQueue.remove();
            
            // On récupère la liste d'adjacence du sommet retiré:
            int[] vertexAdjList = this.graph.getAdjacencyList(vertex);
        
            // On parcourt cette liste de voisins:
            for(int i = 0; i < vertexAdjList.length; i++)
            {
                // Si le voisin n'a pas encore été exploré on affecte les valeurs
                // correspondantes en conséquence:
                if(this.vertices.getColor(vertexAdjList[i]) == Color.Green)
                {
                    this.vertices.setColor(vertexAdjList[i], Color.Orange);
                    this.vertices.setDistance(vertexAdjList[i], this.vertices.getDistance(vertex) + 1);
                    this.vertices.setParent(vertexAdjList[i], vertex + 1);
                    
                    waitingQueue.add(vertexAdjList[i]);
                }
            }
        
            // Le sommet en tête que nous avions retiré de la file d'attente
            // est maintenant complètement exploré:
            this.vertices.setColor(vertex, Color.Red);
        }
        
        // ============ Fin Itération =============
    }
    
    
    
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
    //~~~~~~~~~~ Debugging ~~~~~~~~~//
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
        
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
            System.out.printf("%3d ", this.vertices.getDistance(i));
        System.out.println("\n");
        
        
        printVertices();
        System.out.print("Parents        : ");
        for(int i = 0; i < order; i++)
            System.out.printf("%3d ", this.vertices.getParent(i));
        System.out.println("\n");
        
        
        //Ex2:
        System.out.print("Connectivity   : ");
        System.out.println(this.isConnected + " \n");
    }
    
    public void printVertices()
    {
        int order = this.graph.order();
        
        System.out.print("Vertices       : ");
        for(int i = 0; i < order; i++)
            System.out.printf("%3d ", i+1);
        System.out.println();
    }
}
