/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.dilaw.simplejeeapp.business.chickens.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Walid
 */
@XmlRootElement
@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQuery(name = "getById", query = "select f from Farm where name = :name")
public class Farm implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    long id;
    private String name;
    private String location;
    
    public Farm(long id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public Farm(String name) {
        this.name = name;
    }

    public Farm() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

   
    
}
