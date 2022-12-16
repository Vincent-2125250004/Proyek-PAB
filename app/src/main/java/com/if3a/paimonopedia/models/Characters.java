package com.if3a.paimonopedia.models;

import java.util.ArrayList;
import java.util.List;

public class Characters {

    private String name;
    private String icon;
    private String title;
    private String weapon;
    private String region;
    private String faction;
    private String image;
    private String constellation;
    private String birthday;
    private String description;
    private String element;
    private int rarity;
    private List<talents> talents;

    public List<com.if3a.paimonopedia.models.talents> getTalents() {
        return talents;
    }
    public String getElement() {
        return element;
    }
    public String getName() {
        return name;
    }

    public int getRarity() {
        return rarity;
    }

    public String getIcon() {
        return icon;
    }

    public String getTitle() {
        return title;
    }

    public String getWeapon() {
        return weapon;
    }

    public String getRegion() {
        return region;
    }

    public String getFaction() {
        return faction;
    }

    public String getImage() {
        return image;
    }

    public String getConstellation() {
        return constellation;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getDescription() {
        return description;
    }
}