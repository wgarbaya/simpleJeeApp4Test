/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.dilaw.simplejeeapp.business.chickens.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Garbaya
 */
@XmlRootElement
@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQuery(name ="all", query = "SELECT c FROM Chicken c")
public class Chicken {
    @Id
    @GeneratedValue
    private long id;
    private int age;
    private String name;

    public Chicken() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Chicken( String name, int age) {
        this.age = age;
        this.name = name;
    }
    
}
