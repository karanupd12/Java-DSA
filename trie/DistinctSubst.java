package trie;
/*
class TrieNode{
    TrieNode[] children;
    TrieNode(){
        children = new TrieNode[26];
    }
}
*/

public class DistinctSubst { //3 : 43
    public static int countDistinctSubstring(String st) {
        int n = st.length(), count = 0;
        TrieNode root = new TrieNode();

        for(int i = 0; i < n; i++){
            TrieNode node = root;
            for(int j = i; j < n; j++){
                int idx = st.charAt(j) - 'a';
                if(node.children[idx] == null){
                    node.children[idx] = new TrieNode();
                    count++;
                }
                node = node.children[idx];
            }
        }
        return count+1;
    }
}