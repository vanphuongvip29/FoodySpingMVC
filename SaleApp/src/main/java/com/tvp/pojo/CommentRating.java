/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tvp.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tran van phuong
 */
@Entity
@Table(name = "comment_rating")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CommentRating.findAll", query = "SELECT c FROM CommentRating c"),
    @NamedQuery(name = "CommentRating.findById", query = "SELECT c FROM CommentRating c WHERE c.id = :id"),
    @NamedQuery(name = "CommentRating.findByContent", query = "SELECT c FROM CommentRating c WHERE c.content = :content"),
    @NamedQuery(name = "CommentRating.findByValue", query = "SELECT c FROM CommentRating c WHERE c.value = :value")})
public class CommentRating implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "content")
    private String content;
    @Basic(optional = false)
//    @NotNull
    @Column(name = "value")
    private int value;
    @JoinColumn(name = "food_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Food foodId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userId;

    public CommentRating() {
    }

    public CommentRating(Integer id) {
        this.id = id;
    }

    public CommentRating(Integer id, String content, int value) {
        this.id = id;
        this.content = content;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Food getFoodId() {
        return foodId;
    }

    public void setFoodId(Food foodId) {
        this.foodId = foodId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CommentRating)) {
            return false;
        }
        CommentRating other = (CommentRating) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tvp.pojo.CommentRating[ id=" + id + " ]";
    }
    
}
