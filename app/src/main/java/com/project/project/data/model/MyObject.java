package com.project.project.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MyObject {

    @SerializedName("criteria")
    @Expose
    private Criteria criteria;

    @SerializedName("matches")
    @Expose
    private ArrayList<Recipe> recipeList;

    @SerializedName("facetCounts")
    @Expose
    private FaceCounts facetCounts;

    @SerializedName("totalMatchCount")
    @Expose
    private Integer totalMatchCount;

    @SerializedName("attribution")
    @Expose
    private Attribution attribution;

    public class Criteria{

    }

    public class FaceCounts{

    }

    public class Attribution{

        @SerializedName("html")
        @Expose
        String html;

        @SerializedName("url")
        @Expose
        String url;

        @SerializedName("text")
        @Expose
        String text;

        @SerializedName("logo")
        @Expose
        String logo;

        public String getHtml() {
            return html;
        }

        public String getUrl() {
            return url;
        }

        public String getText() {
            return text;
        }

        public String getLogo() {
            return logo;
        }
    }

    public Criteria getCriteria() {
        return criteria;
    }

    public ArrayList<Recipe> getRecipeList() {
        return recipeList;
    }

    public FaceCounts getFacetCounts() {
        return facetCounts;
    }

    public Integer getTotalMatchCount() {
        return totalMatchCount;
    }

    public Attribution getAttribution() {
        return attribution;
    }
}

