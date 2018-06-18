package com.tripforbusiness.model.general;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class ImageSource {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "The database generated Image Source Object ID")
    private String id;
    @ApiModelProperty(notes = "The image source, the load path of image", required = true)
    private String source;
    @ApiModelProperty(notes = "The image source type, for example LOCAL", required = true)
    private String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
