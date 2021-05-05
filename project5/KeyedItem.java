/**
 *  Project: #5
 *  Source Code File:KeyedItem.java
 *  Author: Sungwoong Ha
 *  Description: This is java implementation of KeyedItem.
 *  Due: 5/13/21
 */
package project5;

public abstract class KeyedItem {
    private String searchKey;

    public KeyedItem(String key) {

        searchKey = key;

    } // end constructor

    public String getKey() {

        return searchKey;

    } // end getKey
} // end KeyedItem