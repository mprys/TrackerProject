package com.tracker.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="Developers")
@NamedQueries({
	@NamedQuery(name="Developer.findByName", query="Select d From Developer d where d.name = ?"),
	@NamedQuery(name="Developer.loadAll", query="Select d From Developer d ORDER BY d.createDate")
})
public class Developer extends BaseEntity implements Serializable {

	@Transient
	private static final long serialVersionUID = -3352336893293080090L;
	
	@Column(name="name", nullable=false)
	private String name;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="developer")
	private Set<Story> stories;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="developer")
	private Set<Bug> bugs;

	public Developer(){
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Story> getStories() {
		return stories;
	}

	public void setStories(Set<Story> stories) {
		this.stories = stories;
	}

	public Set<Bug> getBugs() {
		return bugs;
	}

	public void setBugs(Set<Bug> bugs) {
		this.bugs = bugs;
	}
}
