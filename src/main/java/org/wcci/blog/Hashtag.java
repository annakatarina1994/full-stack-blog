package org.wcci.blog;

import java.util.Collection;

public class Hashtag {
    private String tag;
    private Collection<Post> posts;

    public String getTag() {
        return tag;
    }

    public Collection<Post> getPosts() {
        return posts;
    }
}
