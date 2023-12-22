package model;

import java.util.Date;

/**
 *
 * @author matheus.silva
 */
public class Project {
    
    //ATRIBUTOS
    private int id;
    private String name;
    private String description;
    private Date createdDate;
    private Date updateDate;
    
    //CONSTRUTOR                            //parametros
    public Project(int id, String name, String description, Date createdDate, Date updateDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createdDate = createdDate;
        this.updateDate = updateDate;
    }
    
    public Project(){
        this.createdDate = new Date();
        this.updateDate = new Date();
    
    }
    
    //ACESSORES
    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
    
    //MÉTODO TOOSTRING()
    @Override
    public String toString() {
        return this.name;
    }
    
    
}
