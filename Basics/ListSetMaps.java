package Basics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;

public class ListSetMaps {
    // List, Set, and Map are interfaces in Java Collections Framework.
    // List is an ordered collection (also known as a sequence).
    // Set is a collection that cannot contain duplicate elements.
    // Map is an object that maps keys to values.
    // Linked List is a part of the Java Collections Framework and implements the List interface.

    // List: ArrayList, LinkedList
    List<String> list = new ArrayList<>();
    List<String> linkedList = new LinkedList<>();
    Set<String> set = new HashSet<>();
    Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        ListSetMaps example = new ListSetMaps();
        example.list.add("Apple");
        example.list.add("Banana");
        example.set.add("Orange");
        example.set.add("Grapes");
        example.map.put("John", 25);
        example.map.put("Jane", 30);
        example.linkedList.add("Cherry");
        example.linkedList.add("Mango");
        System.out.println("List, Set and Maps in Java"+
                "\nList: " + example.list +
                "\nSet: " + example.set +
                "\nMap: " + example.map +
                "\nLinkedList: " + example.linkedList);
    }

}
