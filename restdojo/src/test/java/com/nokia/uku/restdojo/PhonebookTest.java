
package com.nokia.uku.restdojo;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.nokia.uku.restdojo.Entry;
import com.nokia.uku.restdojo.Phonebook;

public class PhonebookTest {

    private static final Entry KISS_PISTA = new Entry("Kiss Istvan", "+36201234567");
    private static final Entry NAGY_PISTA = new Entry("Nagy Istvan", "+36202345678");
    private static final Entry GIPSZ_JAKAB = new Entry("Gipsz Jakab", "+36203456789");

    @Test
    public void shouldCreateEmptyPhonebook() {
        // given

        // when
        Phonebook phonebook = new Phonebook();

        // then
        assertThat(phonebook, is(not(nullValue())));
        assertThat(phonebook.size(), is(0));
    }

    private Phonebook phonebook;

    @Before
    public void setUp() {
        phonebook = new Phonebook();
    }

    @Test
    public void shouldAddEntry() {
        // given

        // when
        loadPhonebook();

        // then
        assertThat(phonebook.size(), is(3));
    }

    private void loadPhonebook() {
        phonebook.add(NAGY_PISTA);
        phonebook.add(KISS_PISTA);
        phonebook.add(GIPSZ_JAKAB);
    }

    @Test
    public void testSearchAll() {
        // given
        loadPhonebook();

        // when
        List<Entry> result = phonebook.searchName("");

        // then
        assertThat(result, is(asList(GIPSZ_JAKAB, KISS_PISTA, NAGY_PISTA)));
    }

    @Test
    public void testSearchNonexistent() {
        // given
        loadPhonebook();

        // when
        List<Entry> result = phonebook.searchName("nonexistent");

        // then
        assertThat(result, is(asList()));
    }

    @Test
    public void testSearchName() {
        // given
        loadPhonebook();

        // when
        List<Entry> result = phonebook.searchName("Istvan");

        // then
        assertThat(result, is(asList(KISS_PISTA, NAGY_PISTA)));
    }

    @Test
    public void testSearchPhoneNumber() {
        // given
        loadPhonebook();

        // when
        List<Entry> result = phonebook.searchPhoneNumber("789");

        // then
        assertThat(result, is(asList(GIPSZ_JAKAB)));
    }

}
