package com.gl.DataStructure.triewithhashmap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TrieDemo {

    public static void main(String[] args) {
        Trie trie = new Trie();
        List.of("abc", "bcd", "abcd", "adb", "ac").stream().forEach(trie::add);
        System.out.println("a = " + trie.search("a"));
        System.out.println("ab = " + trie.search("ab"));
        System.out.println("ac = " + trie.search("ac"));
        System.out.println("ad = " + trie.search("ad"));
        System.out.println("b = " + trie.search("b"));
        System.out.println("bpp = " + trie.search("bpp"));
        System.out.println("bpp = " + trie.search("bpp"));
        System.out.println("adb = " + trie.search("adb"));
        trie.delete("adb");
        System.out.println("adb = " + trie.search("adb"));
        trie.update("adb","nadb");
        System.out.println("n = " + trie.search("n"));
        trie.add("I am searching test");
        trie.add("test is OK");
        System.out.println("I = " + trie.search("I"));
        System.out.println("test = " + trie.search("test"));
        System.out.println("OK = " + trie.search("OK"));
        System.out.println("OK = " + trie.search("OK"));
    }
}

class Trie {
    TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    public void add(String s) {
        TrieNode current = root;
        for (int i = 0; i < s.length(); i++) {
            if (!current.child.containsKey(s.charAt(i))) {
                current.child.put(s.charAt(i), new TrieNode());
            }
            current = current.child.get(s.charAt(i));
        }
        current.isWord = true;
    }

    public List<String> search(String s) {
        List<String> search = new ArrayList<>();
        TrieNode current = root;
        for (int i = 0; i < s.length(); i++) {
            if (current.child.containsKey(s.charAt(i))) {
                current = current.child.get(s.charAt(i));
            } else {
                add(s);
                search.add("search word is not found (" + s + "). so added it for next search");
                return search;
            }
        }
        getAutoCompleteWords(current, search, s);
        return search;
    }

    private void getAutoCompleteWords(TrieNode current, List<String> search, String s) {
        if (current == null) {
            return;
        }
        if (current.isWord) {
            search.add(s);
        }
        current.child.entrySet().stream().forEach(node ->
                getAutoCompleteWords(node.getValue(), search, s.concat(node.getKey().toString()))
        );
    }

    public void delete(String s) {
        TrieNode current = root;
        for (int i = 0; i < s.length(); i++) {
            if (current.child.containsKey(s.charAt(i))) {
                current = current.child.get(s.charAt(i));
            } else {
                System.out.println("delete word is not found (" + s + ")");
                return;
            }
        }
        current.isWord = false;
    }
    public void update(String o, String n)
    {
        delete(o);
        add(n);
    }

    private class TrieNode {
        Map<Character, TrieNode> child = new ConcurrentHashMap<>();
        boolean isWord;
    }
}

