package com.example.recipefinder.model;

public class Recipe {
    private int id;
    private String title;
    private String image;
    private int usedIngredientCount;
    private int missedIngredientCount;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public int getUsedIngredientCount() { return usedIngredientCount; }
    public void setUsedIngredientCount(int usedIngredientCount) { this.usedIngredientCount = usedIngredientCount; }

    public int getMissedIngredientCount() { return missedIngredientCount; }
    public void setMissedIngredientCount(int missedIngredientCount) { this.missedIngredientCount = missedIngredientCount; }
}
