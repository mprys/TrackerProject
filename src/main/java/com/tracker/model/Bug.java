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
@Table(name="Bugs")
@NamedQueries({
	@NamedQuery(name="Bug.loadAll", query="Select b From Bug b ORDER BY b.createDate"),
	@NamedQuery(name="Bug.loadOpenBugs", query="Select b From Bug b where b.status in ('NEW', 'ESTIMATED') ORDER BY b.createDate")
})
public class Bug extends BaseEntity implements Serializable {

	@Transient
	private static final long serialVersionUID = -8315097934861802498L;
	
	@Column(name="title", nullable=false, length=256)
	private String title;
	
	@Column(name="description", nullable=false, columnDefinition="CLOB")
	private String description;
	
	@Enumerated(EnumType.STRING)
	@Column(name="status", nullable=false)
	private Status status;
	
	@Enumerated(EnumType.STRING)
	@Column(name="priority", nullable=false)
	private Priority priority;

	@ManyToOne
	@JoinColumn(name="developer_id", nullable=true)
	private Developer developer;

	public Bug(){
		
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public Developer getDeveloper() {
		return developer;
	}

	public void setDeveloper(Developer developer) {
		this.developer = developer;
	}
}
