package com.gl.DataStructure;

import java.util.ArrayList;
import java.util.List;

public class TrieDemo {
    public static void main(String[] args) {
        final List<String> setOfStrings = new ArrayList<>();
        setOfStrings.add("pqrs");
        setOfStrings.add("pprt");
        setOfStrings.add("psst");
        setOfStrings.add("qqrs");
        setOfStrings.add("pqrs");
        final Trie trie = new Trie();
        setOfStrings.forEach(trie::insert);
        System.out.println(trie.search("psst"));
        System.out.println(trie.search("psstq"));
        System.out.println(trie.search("qqrs"));
        System.out.println(trie.search("psst"));
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        if (word == null || word.isEmpty()) {
            throw new IllegalArgumentException("Invalid input");
        }
        word = word.toLowerCase();
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (current.child[index] == null) {
                TrieNode node = new TrieNode();
                current.child[index] = node;
                current = node;
            } else {
                current = current.child[index];
            }
        }
        current.isWord = true;
    }

    public boolean search(String word) {
        if (word == null || word.isEmpty()) {
            return false;
        }
        word = word.toLowerCase();
        TrieNode current = root;
        int i = 0;
        for (i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (current.child[index] != null) {
                current = current.child[index];
            } else {
                break;
            }
        }
        if (i == word.length() && current.isWord) {
            return true;
        } else {
            return false;
        }
    }

    private class TrieNode {
        TrieNode[] child;
        boolean isWord;

        public TrieNode() {
            this.child = new TrieNode[26];
            this.isWord = false;
        }
    }
}


