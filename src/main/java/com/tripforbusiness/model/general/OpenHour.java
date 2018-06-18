package com.tripforbusiness.model.general;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class OpenHour {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "The database generated Open Hour Object ID")
    private String id;
    @ApiModelProperty(notes = "The day that place is open, for example 'Monday'", required = true )
    private String day;
    @ApiModelProperty(notes = "The hours range that place is open at same day, for example '6:00am - 12:00am'", required = true)
    private String hours;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }
}
