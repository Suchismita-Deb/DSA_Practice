package org.example.Premium.Amazon.AmazonExplore.Design;

// https://leetcode.com/problems/design-movie-rental-system/description/

import java.util.*;

/*
System can be used to support searching, booking and renting movies. Each shop carries at most one copy of the moviei.

`entries[i] = [shopi, moviei, pricei]`

Regarding the design.

`MovieRentingSystem(int n, int[][] entries)` Initializes the MovieRentingSystem object with n shops and the movies in entries.

Search - Find the cheapest 5 shops that have an unrented copy of the given movie. Sort by price - tie smaller shopi appear first. No shop then []. `List<Integer> search(int movie)` Returns a list of shops that have an unrented copy of the given movie as described above.

Rent - Rents an unrented copy of the given movie from the given shop.  void rent(int shop, int movie) Rents the given movie from the given shop.

Drop - Drops off a previously rented copy of a given movie at a given shop. `void drop(int shop, int movie) Drops off a previously rented `movie` at the given `shop`.

Report - Return the cheapest 5 rented movies (possibly of the same movie id) as list res[i] = [shopi,moviei] describes that the `jth` cheapest rented movie `moviej` was rented from the shop `shopj`. Same sorting logic and then tie in that case the smaller moviei appear first. `List<List<Integer>> report()` Returns a list of cheapest **rented** movies as described above. Report of the rented movies.

rent only be called when there are unrented movie and drop when rented.

Example.
["MovieRentingSystem", "search", "rent", "rent", "report", "drop", "search"]
[[3, [[0, 1, 5], [0, 2, 6], [0, 3, 7], [1, 1, 4], [1, 2, 7], [2, 1, 5]]], [1], [0, 1], [1, 2], [], [1, 2], [2]]

The MovieRentingSystem - `[3, [[0, 1, 5], [0, 2, 6], [0, 3, 7], [1, 1, 4], [1, 2, 7], [2, 1, 5]]]`

search [1] then all other.
In the system, shop[0] has movie 1,2,3 with price 5,6,7.
shop[1] has movie 1,2 with price 4,7.
shop[2] has movie 1 with price 5.
search[1] return the list of shop with movie id 1 in low to high price. Here movie 1 is in shop 0,1,2 and the sorted list [1,0,2] Notice shop 0 and 2 has same price but then sort with shop id.
rent(0,1) rent movie 1 from shop 0. Movies in shop 0 are 2,3.
rent(1,2) rent movie 2 from shop 1. Movies in shop 1 is 1.
report() Return  [[0,1],[1,2]] Movie 1 from shop 0 is cheapest than movie 2 from shop 1.
drop(1,2) Drop off movie 2 at shop 1. Movies in shop 1 are [1,2].
search(2). Return [0,1]. Movie id 2 is in shop 0 and 1.
*/
public class MovieRentingSystem {

    // Map of movieId to available shops with that movie
    private Map<Integer, TreeSet<MovieEntry>> available;
    // Set of rented movies
    private TreeSet<RentedEntry> rented;
    // Map to store price for each (shop, movie)
    private Map<String, Integer> priceMap;

    public MovieRentingSystem(int n, int[][] entries) {
        available = new HashMap<>();
        rented = new TreeSet<>();
        priceMap = new HashMap<>();

        for (int[] entry : entries) {
            int shop = entry[0], movie = entry[1], price = entry[2];
            available.putIfAbsent(movie, new TreeSet<>());
            available.get(movie).add(new MovieEntry(price, shop));
            priceMap.put(shop + "#" + movie, price);
        }
    }

    public List<Integer> search(int movie) {
        List<Integer> result = new ArrayList<>();
        if (!available.containsKey(movie)) return result;

        for (MovieEntry entry : available.get(movie)) {
            result.add(entry.shop);
            if (result.size() == 5) break;
        }
        return result;
    }

    public void rent(int shop, int movie) {
        int price = priceMap.get(shop + "#" + movie);
        available.get(movie).remove(new MovieEntry(price, shop));
        rented.add(new RentedEntry(price, shop, movie));
    }

    public void drop(int shop, int movie) {
        int price = priceMap.get(shop + "#" + movie);
        rented.remove(new RentedEntry(price, shop, movie));
        available.get(movie).add(new MovieEntry(price, shop));
    }

    public List<List<Integer>> report() {
        List<List<Integer>> result = new ArrayList<>();
        for (RentedEntry entry : rented) {
            result.add(Arrays.asList(entry.shop, entry.movie));
            if (result.size() == 5) break;
        }
        return result;
    }

    // Helper class for available movies
    private static class MovieEntry implements Comparable<MovieEntry> {
        int price, shop;

        MovieEntry(int price, int shop) {
            this.price = price;
            this.shop = shop;
        }

        public int compareTo(MovieEntry other) {
            if (this.price != other.price) return this.price - other.price;
            return this.shop - other.shop;
        }

        public boolean equals(Object o) {
            if (!(o instanceof MovieEntry)) return false;
            MovieEntry other = (MovieEntry) o;
            return this.price == other.price && this.shop == other.shop;
        }

        public int hashCode() {
            return Objects.hash(price, shop);
        }
    }

    // Helper class for rented movies
    private static class RentedEntry implements Comparable<RentedEntry> {
        int price, shop, movie;

        RentedEntry(int price, int shop, int movie) {
            this.price = price;
            this.shop = shop;
            this.movie = movie;
        }

        public int compareTo(RentedEntry other) {
            if (this.price != other.price) return this.price - other.price;
            if (this.shop != other.shop) return this.shop - other.shop;
            return this.movie - other.movie;
        }

        public boolean equals(Object o) {
            if (!(o instanceof RentedEntry)) return false;
            RentedEntry other = (RentedEntry) o;
            return this.price == other.price && this.shop == other.shop && this.movie == other.movie;
        }

        public int hashCode() {
            return Objects.hash(price, shop, movie);
        }
    }
}

