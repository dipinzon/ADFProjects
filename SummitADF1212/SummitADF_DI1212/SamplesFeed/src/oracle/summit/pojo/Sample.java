package oracle.summit.pojo;

public class Sample {
    private String name;
    private String link;
    private String image;
    private String description;

    public Sample(String name, String link, String image, String description) {
        super();
        this.name = name;
        this.link = link;
        this.image = image;
        this.description = description;
    }

    public Sample() {
        super();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
