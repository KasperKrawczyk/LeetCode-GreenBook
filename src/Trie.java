class TrieNode {
    public static final int ALPHABET_SIZE = 26;
    private final TrieNode[] children;
    private boolean isLeaf;

    public TrieNode() {
        children = new TrieNode[ALPHABET_SIZE];
    }

    public boolean containsKey(char c) {
        return children[c - 'a'] != null;
    }

    public TrieNode get(char c) {
        return children[c - 'a'];
    }

    public void put(char c, TrieNode node) {
        children[c - 'a'] = node;
    }

    public void setLeaf() {
        isLeaf = true;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

}

class Trie {

    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode curNode = root;
        for (int i = 0; i < word.length(); i++) {
            char curChar = word.charAt(i);
            if (!curNode.containsKey(curChar)) {
                curNode.put(curChar, new TrieNode());
            }
            curNode = curNode.get(curChar);
        }
        curNode.setLeaf();
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isLeaf();
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

    /**
     * Helper method used by startsWith and search. Explores the tree for a given word (which may be a prefix)
     */
    private TrieNode searchPrefix(String word) {
        TrieNode curNode = root;
        for (int i = 0; i < word.length(); i++) {
            char curChar = word.charAt(i);
            if (curNode.containsKey(curChar)) {
                curNode = curNode.get(curChar);
            } else {
                return null;
            }
        }
        return curNode;
    }


}
