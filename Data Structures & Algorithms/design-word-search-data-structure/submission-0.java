class WordDictionary {

    class Node {
        Node[] children = new Node[26];
        boolean isEnd;
    }

    Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node curr = root;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';

            if (curr.children[index] == null) {
                curr.children[index] = new Node();
            }

            curr = curr.children[index];
        }

        curr.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(root, word, 0);
    }

    private boolean dfs(Node curr, String word, int index) {

        if (index == word.length()) {
            return curr.isEnd;
        }

        char ch = word.charAt(index);

        if (ch != '.') {
            int pos = ch - 'a';

            if (curr.children[pos] == null) {
                return false;
            }

            return dfs(curr.children[pos], word, index + 1);
        }

        // '.' -> try every possible character
        for (Node child : curr.children) {
            if (child != null && dfs(child, word, index + 1)) {
                return true;
            }
        }

        return false;
    }
}