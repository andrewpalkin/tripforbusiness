package com.tripforbusiness.model.place;

import io.swagger.annotations.ApiModelProperty;

public class Location {

    @ApiModelProperty(notes = "Country ID")
    private String countryId;
    @ApiModelProperty(notes = "City ID")
    private String cityId;
    @ApiModelProperty(notes = "Site ID")
    private String siteId;

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }
}
