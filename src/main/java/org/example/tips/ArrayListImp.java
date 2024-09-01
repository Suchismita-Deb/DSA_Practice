package org.example.tips;

import java.util.*;


class Pair {
    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class ArrayListImp {
    public static void main(String[] args) {
        // ArrayList of own type.
        ArrayList<Pair> arr = new ArrayList<Pair>();
        // Adding new element.
        arr.add(new Pair(1, 2));
        ArrayList<int[]> mst = new ArrayList<>();
        mst.add(new int[]{1, 2});
        // Traverse.
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int val = 0;
        for (int nb : adj.get(val)) {
            // adj = 1->{3,4,5,6,7,8};
            // adj.get(val) is giving {3,4,5,6,7,8}
            // The int for each variable is using the elements.
        }
        List<List<int[]>> list = new ArrayList<>();
        for (int[] nb : list.get(1)) {
            // 1-> [[1,2],[2,3]]
            // list.get(1) will give [[1,2],[2,3]].
        }
        int[][] graph = {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};

        // Meaning node 0 is connected with 1,2,3. Here the graph is already in aj list form.

        // Traverse the node.

        int node = 0; // Meaning to get the connected node of the node 0.
        for (int nb : graph[node]) {
            // nb ->{1,2,3} will be the element in every iteration.
        }

        // When the graph is given like [[1,2],[2,3]] meaning the 0th node is connected with 1 and 2. 1st node connected to 2 and 3 then  we donot need to craete another adj list.
        // When the graph is given like [[0,1],[1,2]] meaning the 0th node is connected to 1 and the 1st node is connected to 2 then we need a adj list.


        // When need to find the shortest path then BFS and if it is weighted and need to work on the weight then heap else queue will work as things will increase in constant way.

        //Comparator in 2d array.
        int[][] logs = {{20190101, 0, 1}, {20190104, 3, 4}, {20190107, 2, 3}};
        // logs[][] = [timestamp, firstValue, secondValue]
        // Sort on the basis of timestamp.
        Arrays.sort(logs, (a, b) -> (a[0] - b[0]));// Ascending order.
        for (int[] log : logs)
            System.out.println(Arrays.toString(log)); // Applicable for 1D Array.
        // [20190101, 0, 1], [20190104, 3, 4], [20190107, 2, 3]

        Arrays.sort(logs, (a, b) -> Integer.compare(b[0], a[0]));// Descending order.
        // System.out.println(Arrays.toString(logs)); // Givjing address.
        for (int[] log : logs)
            System.out.println(Arrays.toString(log));
        // [20190107, 2, 3], [20190104, 3, 4], [20190101, 0, 1]

        // Sort on the basis of first value.
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));// a and b in same order ascending.
        // System.out.println(Arrays.toString(logs)); // Giving address.
        for (int[] log : logs)
            System.out.println(Arrays.toString(log));
        // [20190101, 0, 1], [20190107, 2, 3], [20190104, 3, 4]

        // Arraylist.
        // Sorting the ArrayList based on the first element of each array

        // Collections.sort(logs, new Comparator<int[]>() {
        //    @Override
        //    public int compare(int[] a, int[] b) {
        //        return Integer.compare(a[0], b[0]);
        //    }
        // });
    }
}
