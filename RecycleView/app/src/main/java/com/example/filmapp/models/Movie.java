package com.example.filmapp.models;

public class Movie {

    private String Titile;
    private String Description;
    private int Thumbnail;
    private String Studio;
    private String Rating;
    private String StramingLink;
    private int CoverImg;

    public Movie(String titile, int thumbnail, int coverImg) {
        Titile = titile;
        Thumbnail = thumbnail;
        CoverImg = coverImg;
    }

    public Movie(String titile, int thumbnail) {
        Titile = titile;
        Thumbnail = thumbnail;
    }

    public Movie(String titile, String description, int thumbnail, String studio, String rating, String stramingLink) {
        Titile = titile;
        Description = description;
        Thumbnail = thumbnail;
        Studio = studio;
        Rating = rating;
        StramingLink = stramingLink;
    }

    public int getCoverImg() {
        return CoverImg;
    }

    public void setCoverImg(int coverImg) {
        CoverImg = coverImg;
    }

    public String getTitile() {
        return Titile;
    }

    public void setTitile(String titile) {
        Titile = titile;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getThumbnail() {
        return Thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }

    public String getStudio() {
        return Studio;
    }

    public void setStudio(String studio) {
        Studio = studio;
    }

    public String getRating() {
        return Rating;
    }

    public void setRating(String rating) {
        Rating = rating;
    }

    public String getStramingLink() {
        return StramingLink;
    }

    public void setStramingLink(String stramingLink) {
        StramingLink = stramingLink;
    }
}
