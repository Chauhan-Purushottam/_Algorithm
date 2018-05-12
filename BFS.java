import java.util.*;
import java.io.*;
@SuppressWarnings("unchecked")

class Graph
{

	private int V;
	private LinkedList<Integer> adj[];

	Graph(int v)
	{
		V=v;
		adj = new LinkedList[v];
		for(int i=0;i<v;i++)
			adj[i] = new LinkedList();
	}
	public void addEdge(int u,int v)
	{
		adj[u].add(v);
	}
	public void Bfs(int src)
	{
		LinkedList<Integer> queue = new LinkedList();
		boolean []visited = new boolean[V];
		visited[src] = true;
		queue.add(src);
		System.out.print(src+" ");
		while(queue.size()!=0)
		{
			int temp = queue.poll();
			Iterator <Integer> i = adj[temp].listIterator();
			while(i.hasNext())
			{
				int n = i.next();
				if(!visited[n])
				{
					visited[n]=true;
					queue.add(n);
					System.out.print(n+" ");

				}
			}
		}
		System.out.print("\n");
	}
}
class BFS
{
	public static void main(String [] args)
	{
		int vertex, u ,v,i;
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter Number of vertices of the graph");
		vertex = sc.nextInt();
		Graph graph = new Graph(vertex);
		System.out.println("Enter the Edges of the graph");
		for(i=0;i<vertex;i++)
		{
			u = sc.nextInt();
			v = sc.nextInt();
			graph.addEdge(u,v);			//for undirected Graph
			graph.addEdge(v,u);
		}
		System.out.println("Enter the source vertex");
		graph.Bfs(sc.nextInt());

	}
}