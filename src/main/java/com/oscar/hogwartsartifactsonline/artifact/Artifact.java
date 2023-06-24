package com.oscar.hogwartsartifactsonline.artifact;

import com.oscar.hogwartsartifactsonline.wizard.Wizard;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;


// @Entity -> tell Spring Data JPA to pick up this domain model class
@Entity
public class Artifact implements Serializable {

    // @Id -> tell Spring Data JPA, "id" is a primary key
    @Id
    private String id;

    private String name;

    private String description;

    private String imageUrl;

    // e.g. "many to one" relationship in JAVA
    // artifact n..0 <-> 0..1 wizard
    // artifact is the many side
    // Many artifacts belong to One owner
    @ManyToOne
    private Wizard owner;

    public Artifact() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Wizard getOwner() {
        return owner;
    }

    public void setOwner(Wizard owner) {
        this.owner = owner;
    }
}
