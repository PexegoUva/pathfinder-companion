package com.pexegouva.pathfinder_companion.features.enemies_list;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Enemy")
public class Enemy {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "name")
    public String name;

    // Defense
    @ColumnInfo(name = "ca")
    public int ca;

    @ColumnInfo(name = "flat_footed")
    public int flatFooted;

    @ColumnInfo(name = "touch")
    public int touch;

    @ColumnInfo(name = "pg")
    public int pg;

    @ColumnInfo(name = "fort")
    public int fort;

    @ColumnInfo(name = "ref")
    public int ref;

    @ColumnInfo(name = "vol")
    public int vol;

    @ColumnInfo(name = "resists")
    public String resists;

    // Combat
    @ColumnInfo(name = "speed")
    public int speed;

    @ColumnInfo(name = "initiative")
    public int initiative;

    @ColumnInfo(name = "attack")
    public int attack;

    @ColumnInfo(name = "damage")
    public String damage;

    // Skills
    @ColumnInfo(name = "feats")
    public String feats;

    @ColumnInfo(name = "specials")
    public String specials;

    @ColumnInfo(name = "experience_points")
    public int experiencePoints;

    public Enemy() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCa() {
        return ca;
    }

    public void setCa(int ca) {
        this.ca = ca;
    }

    public int getFlatFooted() {
        return flatFooted;
    }

    public void setFlatFooted(int flatFooted) {
        this.flatFooted = flatFooted;
    }

    public int getTouch() {
        return touch;
    }

    public void setTouch(int touch) {
        this.touch = touch;
    }

    public int getPg() {
        return pg;
    }

    public void setPg(int pg) {
        this.pg = pg;
    }

    public int getFort() {
        return fort;
    }

    public void setFort(int fort) {
        this.fort = fort;
    }

    public int getRef() {
        return ref;
    }

    public void setRef(int ref) {
        this.ref = ref;
    }

    public int getVol() {
        return vol;
    }

    public void setVol(int vol) {
        this.vol = vol;
    }

    public String getResists() {
        return resists;
    }

    public void setResists(String resists) {
        this.resists = resists;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public String getDamage() {
        return damage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    public String getFeats() {
        return feats;
    }

    public void setFeats(String feats) {
        this.feats = feats;
    }

    public String getSpecials() {
        return specials;
    }

    public void setSpecials(String specials) {
        this.specials = specials;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints = experiencePoints;
    }
}
