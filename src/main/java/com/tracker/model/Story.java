package com.tracker.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="Stories")
@NamedQueries({ 
	@NamedQuery(name="Story.loadAll", query="Select s From Story s ORDER BY s.createDate"),
	@NamedQuery(name="Story.loadByOwner", query="Select s From Story s where s.developer.id = :id")
})
public class Story extends BaseEntity implements Serializable {

	@Transient
	private static final long serialVersionUID = -6398901634683924632L;

	@Column(name="point_value", nullable=false)
	private Integer pointValue;
	
	@Column(name="title", nullable=false, length=256)
	private String title;
	
	@Column(name="description", nullable=false, columnDefinition="CLOB")
	private String description;
	
	@Enumerated(EnumType.STRING)
	@Column(name="status")
	private Status status;
	
	@ManyToOne
	@JoinColumn(name="developer_id", nullable=true)
	private Developer developer;

	public Story(){
		
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Developer getDeveloper() {
		return developer;
	}

	public void setDeveloper(Developer developer) {
		this.developer = developer;
	}

	public Integer getPointValue() {
		return pointValue;
	}

	public void setPointValue(Integer pointValue) {
		this.pointValue = pointValue;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}
