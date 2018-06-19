package com.tripforbusiness.model;

import com.tripforbusiness.model.general.GoogleInfo;
import com.tripforbusiness.model.general.ImageSource;
import com.tripforbusiness.model.general.Link;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;
import java.util.List;

@Document(collection = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "The database generated City ID")
    private String id;
    @ApiModelProperty(notes = "The Country ID related to current city")
    private String countryId;
    @ApiModelProperty(notes = "The date and time, when City information was updated")
    private Date updated_at;
    @ApiModelProperty(notes = "The date and time, when City information was created")
    private Date created_at;
    @ApiModelProperty(notes = "The City name")
    private String name;
    @ApiModelProperty(notes = "The City description")
    private String description;
    @ApiModelProperty(notes = "The City time zone")
    private String timeZone;
    @ApiModelProperty(notes = "List of links, for example : Website, Wiki, TripAdvisor etc.")
    private List<Link> links;
    @ApiModelProperty(notes = "List of images related to current City")
    private List<ImageSource> imgSources;
    @ApiModelProperty(notes = "Google info of current City")
    private GoogleInfo googleInfo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public List<ImageSource> getImgSources() {
        return imgSources;
    }

    public void setImgSources(List<ImageSource> imgSources) {
        this.imgSources = imgSources;
    }

    public GoogleInfo getGoogleInfo() {
        return googleInfo;
    }

    public void setGoogleInfo(GoogleInfo googleInfo) {
        this.googleInfo = googleInfo;
    }
}
