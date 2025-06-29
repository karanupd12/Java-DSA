package greedyAlgorithms;
import heaps.Heap;

import java.util.*;

public class HuffmanCoder {
    //step 1 : create encoder and decoder hashmaps
    HashMap<Character, String> encoder;
    HashMap<String, Character> decoder;

    //step 2 : define the huffman node
    private class Node implements Comparable<Node>{
        Character data;
        int cost;  //frequency
        Node left, right;
        public Node (Character data, int cost) {
            this.data = data;
            this.cost = cost;
            left = right = null;
        }
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public HuffmanCoder(String feeder) throws Exception {  //feeder is the text that we need to compress
        //step 3 : creating frequency hashmap
        HashMap<Character, Integer> fmap = new HashMap<>();
        for (int i = 0; i < feeder.length(); i++) {
            char c = feeder.charAt(i);
            if (fmap.containsKey(c)) {
                int ov = fmap.get(c);  //ov = orignal value
                ov++;
                fmap.put(c, ov);
            } else {
                fmap.put(c, 1);
            }
        }

        //step 4 : creating minheap from frequency map
        Heap<Node> minHeap = new Heap<>();
        //calling entry set from our frequency map
        Set<Map.Entry<Character, Integer>> entrySet = fmap.entrySet();
        //now iterate on it
        for (Map.Entry<Character, Integer> entry : entrySet) {
            Node node = new Node(entry.getKey(), entry.getValue());
            minHeap.insert(node);
        }

        //step 5 : remove 2 nodes from min heap and create a new node with their summed cost
        //at the end of this loops we will be left with just one node in heap i.e final tree (ft)
        while (minHeap.size() != 1) {
            Node first = minHeap.remove();
            Node second = minHeap.remove();
            Node newNode = new Node('\0', first.cost + second.cost);
            newNode.left = first;
            newNode.right = second;
            minHeap.insert(newNode);
        }

        //step 6 : fill encoder and decoder using final tree 'ft' i.e; 0 to left and 1 to right node
        Node ft = minHeap.remove();
        this.encoder = new HashMap<>();
        this.decoder = new HashMap<>();
        this.initEncoderDecoder(ft, "");
    }
    //function used to encode decode
    private void initEncoderDecoder(Node node, String s) {
        if (node == null){
            return ;
        }
        if (node.left == null && node.right == null){
            //we reached leaf
            this.encoder.put(node.data, s);
            this.decoder.put(s, node.data);
        }
        initEncoderDecoder(node.left, s+"0");
        initEncoderDecoder(node.right, s+"1");
    }

    //ste 7 : encoding and decoding for user
    public String encode (String source){
        String ans = "";
        // Bitset can be used: like an array but with a bit at each index
        for (int i = 0; i < source.length(); i++) {
            ans = ans + encoder.get(source.charAt(i));
        }
        return ans;
    }

    public String decode(String codedString) {
        String key = "";
        String ans = "";
        for(int i=0; i<codedString.length(); i++) {
            key = key + codedString.charAt(i);
            if(decoder.containsKey(key)) {
                ans = ans + decoder.get(key);
                key = "";
            }
        }
        return ans;
    }

    public static void main(String[] args) throws Exception{
        String str = "abbccda";
        HuffmanCoder hf = new HuffmanCoder(str);
        String cs = hf.encode(str);
        System.out.println(cs);
        String dc = hf.decode(cs);
        System.out.println(dc);
    }
}
