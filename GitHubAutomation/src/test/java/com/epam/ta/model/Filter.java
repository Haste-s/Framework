package com.epam.ta.model;

public class Filter {
    private String color;
    private String category;
    private String type;
    private String sorting;

    public Filter(String color, String category,String type,String sorting) {
        this.color = color;
        this.category = category;
        this.type = type;
        this.sorting=sorting;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String color) {
        this.type = type;
    }

    public String getSorting() {
        return sorting;
    }

    public void setSorting(String color) {
        this.sorting = sorting;
    }
}
