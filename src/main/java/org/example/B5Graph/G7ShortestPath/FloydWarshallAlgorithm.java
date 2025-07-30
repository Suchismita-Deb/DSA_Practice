package org.example.B5Graph.G7ShortestPath;

// https://www.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1
/*
Multi Source Shortest Path.
1. Making all vertex used in every path. First going to all nodes using 0.
2. Update the matrix and now via node 1. if it is min then update else continue.
3. Continue for all the nodes k nodes.
4. arr[i][j] = Going from node i to j.
5. arr[i][i] = 0. In th same node if the value is <0 then there is negative cycle.
*/
public class FloydWarshallAlgorithm {
    public void shortest_distance(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = (int) (1e9);
                }
                if (i == j)
                    matrix[i][j] = 0;
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Math.min(matrix[i][j], (matrix[i][k] + matrix[k][j]));
                }
            }
        }

        /*
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j){
                    if(matrix[i][j] < 0 ){
                        System.out.pritnln("Negative Cycle.");
                    }
                }
            }
        }
        */

        // If not reachable then -1.

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == (int) (1e9)) {
                    matrix[i][j] = -1;
                }
            }
        }
    }
}

