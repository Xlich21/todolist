package com.alex.todolist;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "todo_table", schema = "alex_fenichiu")
public class ToDoListDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "category")
    private String category;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Basic(optional = false)
    @Column(name = "adding_date", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date addingDate;

    @Basic(optional = false)
    @Column(name = "expiration_date", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date expirationDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public Date getAddingDate() {
        return addingDate;
    }

    public void setAddingDate(Date addingDate) {
        this.addingDate = addingDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}
