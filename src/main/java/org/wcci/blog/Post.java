package org.wcci.blog;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

@Entity
public class Post {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String body;
    @ManyToMany
    private Collection<Author> authors;
    @ManyToOne
    private Category category;
    @ManyToMany
    private Collection<Hashtag> tags;
    private LocalDateTime date;

    public Post(){}

    public Post(String name, String body, Category category) {
        this.name = name;
        this.body = body;
        this.tags = new HashSet<>();
        this.authors = new HashSet<>();
        this.category = category;
        this.date = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBody() {
        return body;
    }

    public Collection<Author> getAuthor() {
        return authors;
    }

    public Category getCategory() {
        return category;
    }

    public Collection<Hashtag> getTags() {
        return tags;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id) &&
                Objects.equals(name, post.name) &&
                Objects.equals(body, post.body) &&
                Objects.equals(category, post.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, body, category, date);
    }

    public void addHashtag(Hashtag hashtagToAdd) {
        tags.add(hashtagToAdd);
    }

    public void addAuthor(Author authorToAdd){
        authors.add(authorToAdd);
    }
}