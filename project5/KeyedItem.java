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