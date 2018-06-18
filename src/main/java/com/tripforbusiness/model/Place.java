package com.tripforbusiness.model;

import com.tripforbusiness.model.general.GoogleInfo;
import com.tripforbusiness.model.general.ImageSource;
import com.tripforbusiness.model.general.OpenHour;
import com.tripforbusiness.model.general.Link;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;
import java.util.List;

@Document(collection = "places")
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "The database generated Place Object ID")
    private String id;
    @ApiModelProperty(notes = "The Place ID")
    private int placeId;
    @ApiModelProperty(notes = "The Place level")
    private int placeLevel;
    @ApiModelProperty(notes = "The Place name", required = true)
    private String name;
    @ApiModelProperty(notes = "The Place description", required = true)
    private String desc;
    @ApiModelProperty(notes = "The Place address", required = true)
    private String address;
    @ApiModelProperty(notes = "The Place contact phone number")
    private String phoneNumber;
    private int v;
    @ApiModelProperty(notes = "The date and time, when place information was updated", required = true)
    private Date updated_at;
    @ApiModelProperty(notes = "The date and time, when place information was created", required = true)
    private Date created_at;
    @ApiModelProperty(notes = "The Place priority ")
    private int priority;

    @ApiModelProperty(notes = "Location of place (Country ID, City ID, Site ID)", required = true)
    private Location location;

    @ApiModelProperty(notes = "Category ID", required = true)
    private int[] categoryId;
    @ApiModelProperty(notes = "List of open hours of current place")
    private List<OpenHour> openHours;
    @ApiModelProperty(notes = "List of links, for example : Website, Wiki, TripAdvisor etc.")
    private List<Link> links;
    @ApiModelProperty(notes = "List of images related to current place")
    private List<ImageSource> imgSource;

    @ApiModelProperty(notes = "Google information related to current place", required = true)
    private GoogleInfo googleInfo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }

    public int getPlaceLevel() {
        return placeLevel;
    }

    public void setPlaceLevel(int placeLevel) {
        this.placeLevel = placeLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
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

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int[] getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int[] categoryId) {
        this.categoryId = categoryId;
    }

    public List<OpenHour> getOpenHours() {
        return openHours;
    }

    public void setOpenHours(List<OpenHour> openHours) {
        this.openHours = openHours;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public List<ImageSource> getImgSource() {
        return imgSource;
    }

    public void setImgSource(List<ImageSource> imgSource) {
        this.imgSource = imgSource;
    }

    public GoogleInfo getGoogleInfo() {
        return googleInfo;
    }

    public void setGoogleInfo(GoogleInfo googleInfo) {
        this.googleInfo = googleInfo;
    }
}
