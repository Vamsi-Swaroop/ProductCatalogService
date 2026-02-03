package dev.ismav.productcatalogservice.models;

import java.util.Date;

public abstract class BaseModel {

    private long id;

    private Date createdAt;  //stores date inn epoch format

    private Date updatedAt;

    private State state; //used for soft delete insteqd of hard delete by which we can use Active or inactive

}
