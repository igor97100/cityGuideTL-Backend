package com.cityGuideTL.backend.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Photo implements Comparable<Photo>, Serializable {
    @JsonProperty("id")
    @JsonIgnoreProperties()
    private String photoID;
    @JsonProperty("longitude")
    private String longitude;
    @JsonProperty("latitude")
    private String latitude;

    @JsonIgnore
    private Point point;

    private int totalNearPhotos = 0;

    public int getTotalNearPhotos() {
        return totalNearPhotos;
    }

    public void setTotalNearPhotos(int totalNearPhotos) {
        this.totalNearPhotos = totalNearPhotos;
    }

    public void increaseTotalNearPhotosByOne(){
        totalNearPhotos ++;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public Photo(String photoID) {
        this.photoID = photoID;
    }

    public Photo() {
    }

    public String getPhotoID() {
        return photoID;
    }

    public Photo(String photoID, String longitude, String latitude, int totalNearPhotos) {
        this.photoID = photoID;
        this.longitude = longitude;
        this.latitude = latitude;
        this.totalNearPhotos = totalNearPhotos;
        this.point = new Point(Double.parseDouble(longitude),Double.parseDouble(latitude));
    }
    public Photo(String longitude, String latitude){
        this.longitude = longitude;
        this.latitude = latitude;
        this.point = new Point(Double.parseDouble(longitude),Double.parseDouble(latitude));
    }

    public void setPhotoID(String photoID) {
        this.photoID = photoID;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @Override
    public int compareTo(Photo comparesTo) {
        if (this.totalNearPhotos > comparesTo.totalNearPhotos) {
            return 1;
        }
        if (this.totalNearPhotos < comparesTo.totalNearPhotos) {
            return -1;
        }
        if (this.totalNearPhotos == comparesTo.totalNearPhotos) {
            return 0;
        }
        return 0;
    }
}
