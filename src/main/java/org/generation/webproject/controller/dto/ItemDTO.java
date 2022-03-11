package org.generation.webproject.controller.dto;

//ItemDTO is NOT an Entity Class, not for mapping with the database table and columns

//DTO refers to Data Transfer Object, the role of this class is to transfer data
// (object) from/to client and service layer through controller

public class ItemDTO {

    //Do not need the ID

    private String name;
    private String description;
    private String imageUrl;
    private String style;
    private double price;

    public ItemDTO( String name, String description, String imageUrl, String style, double price)
    {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.style = style;
        this.price = price;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription( String description )
    {
        this.description = description;
    }

    public String getImageUrl()
    {
        return imageUrl;
    }

    public void setImageUrl( String imageUrl )
    {
        this.imageUrl = imageUrl;
    }

    public void setStyle(String style) { this.style = style; }

    public String getStyle() { return style; }

    public void setPrice(double price) { this.price = price; }

    public double getPrice() { return price; }

}
