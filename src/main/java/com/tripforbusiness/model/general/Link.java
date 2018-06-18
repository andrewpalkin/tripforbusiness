package com.tripforbusiness.model.general;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "The database generated Link Object ID")
    private String id;
    @ApiModelProperty(notes = "The Link type", required = true)
    private String type;
    @ApiModelProperty(notes = "The Link name", required = true)
    private String name;
    @ApiModelProperty(notes = "The Link URL", required = true)
    private String url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getURL() {
        return url;
    }

    public void setURL(String url) {
        this.url = url;
    }
}

