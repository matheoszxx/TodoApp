
package model;

import java.util.Date;

/**
 *
 * @author matheus.silva
 */
public class Tasks {
    
    //ATRIBUTOS
    private int id;
    private int idProject;
    private String name;
    private String description;
    private boolean status;
    private String notes;
    private Date deadline;
    private Date createdDate;
    private Date updateDate;
    
    //CONSTRUTOR
    public Tasks(int id, int idProject, String name, String description, boolean status, String notes, Date deadline, Date createdDate, Date updateDate) {
        this.id = id;
        this.idProject = idProject;
        this.name = name;
        this.description = description;
        this.status = status;
        this.notes = notes;
        this.deadline = deadline;
        this.createdDate = createdDate;
        this.updateDate = updateDate;
    }
    
    public Tasks(){
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

    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
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

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
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
    
    //TOSTRING()
    @Override
    public String toString() {
        return "Tasks{" + "id=" + id + ", idProject=" + idProject + ", name=" + name + ", description=" + description + ", status=" + status + ", notes=" + notes + ", deadline=" + deadline + ", createdDate=" + createdDate + ", updateDate=" + updateDate + '}';
    }
    
}
