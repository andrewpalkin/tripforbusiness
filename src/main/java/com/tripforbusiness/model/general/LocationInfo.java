package com.tripforbusiness.model.general;

import io.swagger.annotations.ApiModelProperty;

public class LocationInfo {

    @ApiModelProperty(notes = "Longitude of a place")
    private String lng;
    @ApiModelProperty(notes = "Latitude of a place")
    private String lat;

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }
}
