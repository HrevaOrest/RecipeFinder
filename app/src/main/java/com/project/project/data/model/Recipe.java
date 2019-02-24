package com.project.project.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Recipe implements Serializable {

    @SerializedName("imageUrlsBySize")
    @Expose
    private Map<Integer, String> imageUrlsBySize;

    @SerializedName("sourceDisplayName")
    @Expose
    private String sourceDisplayName;

    @SerializedName("ingredients")
    @Expose
    private List<String> ingredients;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("smallImageUrls")
    @Expose
    private List<String> smallImageUrls;

    @SerializedName("recipeName")
    @Expose
    private String recipeName;

    @SerializedName("totalTimeInSeconds")
    @Expose
    private Integer totalTimeInSeconds;

    @SerializedName("attributes")
    @Expose
    private Attributes attributes;

    @SerializedName("flavors")
    @Expose
    private Flavors flavors;

    @SerializedName("rating")
    @Expose
    private Integer rating;

    public Map<Integer, String> getImageUrlsBySize() {
        return imageUrlsBySize;
    }

    public String getSourceDisplayName() {
        return sourceDisplayName;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public String getId() {
        return id;
    }

    public List<String> getSmallImageUrls() {
        return smallImageUrls;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public Integer getTotalTimeInSeconds() {
        return totalTimeInSeconds;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public Flavors getFlavors() {
        return flavors;
    }

    public Integer getRating() {
        return rating;
    }

    public class Attributes{

        @SerializedName("course")
        @Expose
        List<String> course;

        @SerializedName("cuisine")
        @Expose
        List<String> cuisine;

        public List<String> getCourse() {
            return course;
        }

        public List<String> getCuisine() {
            return cuisine;
        }
    }

    public class Flavors{

        @SerializedName("piquant")
        @Expose
        Double piquant;

        @SerializedName("meaty")
        @Expose
        Double meaty;

        @SerializedName("bitter")
        @Expose
        Double bitter;

        @SerializedName("sweet")
        @Expose
        Double sweet;

        @SerializedName("sour")
        @Expose
        Double sour;

        @SerializedName("salty")
        @Expose
        Double salty;

        public Double getPiquant() {
            return piquant;
        }

        public Double getMeaty() {
            return meaty;
        }

        public Double getBitter() {
            return bitter;
        }

        public Double getSweet() {
            return sweet;
        }

        public Double getSour() {
            return sour;
        }

        public Double getSalty() {
            return salty;
        }
    }
}
