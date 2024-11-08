package com.example.energizeme;

public class Exercise {
    private String name;
    private String type;
    private String description;
    private int image;
    private int Gimage;

    public Exercise(String name, String type, String description, int image, int Gimage) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.image = image;
        this.Gimage = Gimage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getGimage() {
        return Gimage;
    }

    public void setGimage(int gimage) {
        Gimage = gimage;
    }

    @Override
    public String toString() {
        return name;
    }
}
