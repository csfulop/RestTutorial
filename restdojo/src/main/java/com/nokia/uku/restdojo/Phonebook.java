
package com.nokia.uku.restdojo;

import java.util.List;

public class Phonebook {

    public int size() {
        return -1;
    }

    public void add(Entry entry) {
    }

    public List<Entry> searchName(String string) {
        return null;
    }

    public List<Entry> searchPhoneNumber(String string) {
        return null;
    }

    // asList(GIPSZ_JAKAB, KISS_PISTA, NAGY_PISTA).stream()
    // .filter(entry -> {
    // return entry.getName().matches(".*Istvan.*");
    // })
    // .sorted(Comparator.comparing(Entry::getName))
    // .collect(Collectors.toList());

}
