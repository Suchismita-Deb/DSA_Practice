package org.example.graph.G10DSU.DsuPractice;

// https://leetcode.com/problems/the-earliest-moment-when-everyone-become-friends/description/
// logs where logs[i] = [timestampi, xi, yi] indicates that xi and yi will be friends at the time timestamp.
// Return the earliest time for which every person became acquainted with every other person. If there is no such earliest time, return -1.

// Input: logs = [[20190101,0,1],[20190104,3,4],[20190107,2,3],[20190211,1,5],[20190224,2,4],[20190301,0,3],[20190312,1,2],[20190322,4,5]], n = 6
// Output: 20190301
import java.util.Arrays;

public class EarliestMomentWhenEveryoneBecomesFriend {
    class Solution {
        public int earliestAcq(int[][] logs, int n) {
            Arrays.sort(logs, (x, y) -> x[0] - y[0]); // Sort on the basis of the timestamp.
            int components = n;
            DSU dsu = new DSU(n);
            for(int[] log: logs){
                int timeStamp = log[0];
                int x = log[1];
                int y = log[2];
                if(dsu.union(x,y)){
                    components--; // Union will reduce the count of component.
                    if(components == 1)
                        return timeStamp;
                }
            }
            return -1;
        }
    }

    class DSU{

        private int[] parent;
        private int[] rank;

        public DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for(int i = 0; i<n; i++)
                parent[i] = i;
        }

        public boolean union(int u, int v){
            int par_u = findParent(u);
            int par_v = findParent(v);

            if(par_u == par_v)
                // Already connected then return false;
                return false;

            if(rank[par_u] < rank[par_v]){
                parent[par_u] = par_v;
            }else if(rank[par_u] > rank[par_v]){
                parent[par_v] = par_u;
            }else{
                parent[par_v] = par_u;
                rank[par_u]++;
            }

            return true;
        }

        private int findParent(int v){
            if(parent[v] == v)
                return v;
            return parent[v] = findParent(parent[v]);
        }
    }
}
