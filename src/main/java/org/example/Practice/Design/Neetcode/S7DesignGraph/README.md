Graph is always to number from 1 or 0 to the node. Graph can be represented by the ArrayList<ArrayList> or HashMap<Integer, Set<>> 

# Design a directed Graph class.

Your Graph class should support the following operations:

`Graph()` will initialize an empty directed graph.  
`void addEdge(int src, int dst)` will add an edge from src to dst if it does not already exist. If either src or dst do not exist, add them to the graph.  
`bool removeEdge(int src, int dst)` will remove the edge from src to dst if it exists. Return whether the edge was removed. Either src or dst may not exist in the graph.
`bool hasPath(int src, int dst)` will return whether there is a path from `src` to `dst`. Assume both src and dst exist in the graph.
Constraints:

Each vertex value will be a unique integer.  
Multiple edges from one vertex to another are not allowed.  
A vertex will not have an edge to itself, but the graph may contain a cycle.  
The graph is not necessarily connected (there may be disconnected components).

```java
class Graph {

    public Graph() {

    }

    public void addEdge(int src, int dst) {
        // src or dst not present in the graph then add. 
        // When the graph is made with HashMap then directly use the method putIfAbsent.
        // Graph in array then need to see, graph size < src or dst then add the nodes.
    }

    public boolean removeEdge(int src, int dst) {

    }

    public boolean hasPath(int src, int dst) {
        
        // any traversal like dfs or bfs
    }
}
```