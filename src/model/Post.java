package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name = "Post")
public class Post {

    private int id;
    private String title;
    private String body;
    private String[] tags;
    private int reactions;

    public Post() {}
    
    public Post(int id, String title, String body, String[] tags, int reactions) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.tags = tags;
        this.reactions = reactions;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String[] getTags() {
        return tags;
    }

    public int getReactions() {
        return reactions;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public void setReactions(int reactions) {
        this.reactions = reactions;
    }
}
