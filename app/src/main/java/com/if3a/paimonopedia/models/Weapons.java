package com.if3a.paimonopedia.models;

public class Weapons {
    private String name;
    private String image;
    private String type;
    private String abilityName;
    private String abilityDescription;
    private String location;
    private String lore;
    private int rarity, baseAtk;
    private double subStat;
    public String getLore() {
        return lore;
    }
    public int getRarity() {
        return rarity;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getType() {
        return type;
    }

    public int getBaseAtk() {
        return baseAtk;
    }

    public double getSubStat() {
        return subStat;
    }

    public String getAbilityName() {
        return abilityName;
    }

    public String getAbilityDescription() {
        return abilityDescription;
    }

    public String getLocation() {
        return location;
    }
}
