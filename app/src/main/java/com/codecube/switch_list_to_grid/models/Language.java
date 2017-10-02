package com.codecube.switch_list_to_grid.models;

/**
 * Created by gerardojavierzaratepina on 02/10/17.
 */

public class Language {
    private String name;
    private int img;
    private String creator;

    public Language(String name, int img, String creator) {
        this.name = name;
        this.img = img;
        this.creator = creator;
    }

    public Language() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
}
