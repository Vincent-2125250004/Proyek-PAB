package com.if3a.paimonopedia.models;

public class Artifacts {
    public String name;
    public String image;
    public String type;
    public String description;
    public String lore;
    public String location;
    public int rarity;
    public ArtifactSet artifactSet;

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getLore() {
        return lore;
    }

    public String getLocation() {
        return location;
    }

    public ArtifactSet getArtifactsSets() {
        return artifactSet;
    }

    public String getName() {
        return name;
    }

    public int getRarity() {
        return rarity;
    }

    public String getImage() {
        return image;
    }

}
