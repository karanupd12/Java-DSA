package GRAPHS;

public class DisjointSets {
    private int N;
    private int[] parent;
    private int[] rank;                              //height of element in tree

    public DisjointSets(int N){
        parent = new int[N];
        rank = new int[N];
        this.N = N;
        for(int i = 0; i < N; i++)                   //initially everybody willl be their own rep
            parent[i] = i;
    }

    int find(int a){
        if(parent[a] == a) return a;                 //base case - rep found
        return parent[a] = find(parent[a]);                 //path compression; going up the tree
    }

    void union(int a, int b){
        int x = parent[a], y = parent[b];   //find reps of a and b

        if(x == y)
            return;    //no need to do union, they are already in same set(have same rep)

        else if(rank[x] > rank[y])      //rep with more rank will be the parent
            parent[y] = x;

        else if(rank[x] < rank[y])
            parent[x] = y;

        else {
            parent[y] = x;               //or parent[x] = y
            rank[x]++;                   //increasing rank of x rep
        }
    }

    public static void main(String[] args) {
        DisjointSets DSU = new DisjointSets(8);        //{0,1,2,3,4,5,6,7}
        DSU.union(0,1);                             //{01, 2, 3, 4, 5, 6, 7}
        DSU.union(2,7);                             //{01, 27, 3, 4, 5, 6}
        System.out.println(DSU.find(4));    //rep of 4 is 4, as it is not unioned with anyone yet
        DSU.union(0, 2);                            //{0127, 3, 4 ,5, 6}
        DSU.union(2,4);                             //{01274, 3, 5, 6}
        System.out.println(DSU.find(4));    // 0 because 4 is now in this set = {0,1,2,3, 7 4} whose rep is 0
    }
}
