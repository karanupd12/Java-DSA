package trie;

class TrieNode{
    TrieNode[] children;
    boolean isEnd;

    public TrieNode(){
        this.children = new TrieNode[26];
        this.isEnd = false;
    }
}

class Trie {

    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            int i = ch - 'a';
            if(node.children[i] == null){
                node.children[i] = new TrieNode();
            }
            node = node.children[i];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            int i = ch - 'a';
            if(node.children[i] == null) return false;
            node = node.children[i];
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(char ch : prefix.toCharArray()){
            int i = ch - 'a';
            if(node.children[i] == null) return false;
            node = node.children[i];
        }
        return true;
    }
}
