package com.gl.DataStructure.triewitharray;

import java.util.ArrayList;
import java.util.List;

public class TrieDemo {
    public static void main(String[] args) {
        Trie trie = new Trie();
        List<String> stringList = List.of("abc", "abd", "abcd", "abc", "adc", "cat", "dat");
        stringList.stream().forEach(trie::insert);
        stringList.stream().forEach(e -> System.out.println("[" + trie.query(e) + "] -> " + e));
        String t = "abd";
        trie.delete(t);
        System.out.println("[" + trie.query(t) + "] deleted -> " + t);
        trie.delete(t);
        System.out.println("[" + trie.query(t) + "] deleted -> " + t);
        t = "abcf";
        trie.update("abc", t);
        System.out.println("[" + trie.query(t) + "] updated -> " + t);
        stringList.stream().forEach(e -> System.out.println("[" + trie.query(e) + "] -> " + e));
        trie.delete("abc");
        stringList.stream().forEach(e -> System.out.println("[" + trie.query(e) + "] -> " + e));
        System.out.println("trie = " + trie.queryForAutoComplete("a"));
        System.out.println("trie = " + trie.queryForAutoComplete("b"));
        System.out.println("trie = " + trie.queryForAutoComplete("c"));
        System.out.println("trie = " + trie.queryForAutoComplete("d"));


    }
}

class Trie {
    TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        word = word.toLowerCase();
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            if (current.child[word.charAt(i) - 'a'] == null) {
                current.child[word.charAt(i) - 'a'] = new TrieNode();
            }
            current = current.next(word.charAt(i));
        }
        current.terminal++;
    }

    public int query(String word) {
        word = word.toLowerCase();
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            if (current == null || current.next(word.charAt(i)) == null) {
                return 0;
            } else {
                current = current.next(word.charAt(i));
            }
        }
        return current.terminal;
    }

    public List<String> queryForAutoComplete(String word) {
        List<String> autoCompleteList = new ArrayList<>();
        word = word.toLowerCase();
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            if (current == null || current.next(word.charAt(i)) == null) {
                return null;
            } else {
                current = current.next(word.charAt(i));
            }
        }
        search(current, autoCompleteList, word);
        return autoCompleteList;
    }

    public void search(TrieNode currentTrieNode, List<String> autoCompleteList, String preFix) {
        if (currentTrieNode == null) {
            return;
        }
        if (currentTrieNode.terminal > 0) {
            autoCompleteList.add(preFix);
        }
        TrieNode[] trieNodes = currentTrieNode.child;
        for (int i = 0; i < trieNodes.length; i++) {
            if (trieNodes[i] != null) {
                search(trieNodes[i], autoCompleteList, preFix + trieNodes[i].getChar(i));
            }
        }
    }

    public void delete(String word) {
        word = word.toLowerCase();
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            if (current == null) {
                throw new RuntimeException("word not found +" + word);
            } else {
                current = current.next(word.charAt(i));
            }
        }
        if (current.terminal != 0) {
            current.terminal--;
        } else {
            throw new RuntimeException("word not found +" + word);
        }
    }

    public void update(String oldWord, String newWord) {
        delete(oldWord);
        insert(newWord);
    }

    private class TrieNode {
        TrieNode[] child;
        int terminal;

        TrieNode() {
            child = new TrieNode[26];
            terminal = 0;
        }

        TrieNode next(char c) {
            return child[c - 'a'];
        }

        String getChar(int index) {
            return String.valueOf((char) (index + 'a'));
        }
    }
}