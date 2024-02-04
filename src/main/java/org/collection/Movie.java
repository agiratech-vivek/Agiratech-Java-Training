package org.collection;

import java.util.List;
import java.util.Set;

public class Movie {
    private String title;
    private Set<Language> languages;

    public Movie() {
    }

    public Movie(String title, Set<Language> languages) {
        this.title = title;
        this.languages = languages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(Set<Language> languages) {
        this.languages = languages;
    }
}
