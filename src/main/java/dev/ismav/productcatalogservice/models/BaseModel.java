package dev.ismav.productcatalogservice.models;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.*;


import java.util.Date;

@MappedSuperclass
public abstract class BaseModel {

    @Id
    private long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    private Date createdAt;  //stores date inn epoch format

    private Date updatedAt;

    private State state; //used for soft delete instead of hard delete by which we can use Active or inactive

}
