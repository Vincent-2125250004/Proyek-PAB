package com.if3a.paimonopedia.models;

public class Weapons {
    private String name, image, type, abilityName, abilityDescription, location;
    private int rarity, baseAtk;
    private double subStat;

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
