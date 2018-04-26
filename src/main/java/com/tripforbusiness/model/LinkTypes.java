package com.tripforbusiness.model;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;

@Document(collection = "links_types")
public class LinkTypes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "The database generated Link Type Object ID")
    private String id;
    @ApiModelProperty(notes = "The Link Type ID")
    private String typeId;
    @ApiModelProperty(notes = "The Link Type type", required = true)
    private String type;
    @ApiModelProperty(notes = "The Link Type name", required = true)
    private String name;
    private int v;
    @ApiModelProperty(notes = "The date and time, when link type information was updated", required = true)
    private Date updated_at;
    @ApiModelProperty(notes = "The date and time, when link type information was created", required = true)
    private Date created_at;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
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
}
