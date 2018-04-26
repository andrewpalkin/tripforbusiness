package com.tripforbusiness.model.place;

import io.swagger.annotations.ApiModelProperty;

public class GoogleInfo {

    @ApiModelProperty(notes = "Google place id, can be used in Google API calls")
    private String googlePlaceId;
    @ApiModelProperty(notes = "Location info (lng, lat)")
    private LocationInfo locationInfo;

    public String getGooglePlaceId() {
        return googlePlaceId;
    }

    public void setGooglePlaceId(String googlePlaceId) {
        this.googlePlaceId = googlePlaceId;
    }

    public LocationInfo getLocationInfo() {
        return locationInfo;
    }

    public void setLocationInfo(LocationInfo locationInfo) {
        this.locationInfo = locationInfo;
    }
}
