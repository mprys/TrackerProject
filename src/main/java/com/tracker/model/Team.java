package com.tracker.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.BatchSize;

@Entity
@Table(name="Teams")
@NamedQueries({@NamedQuery(name="loadAllTeams", query="Select T From Team T")})
public class Team extends BaseEntity implements Serializable {


	@Transient
	private static final long serialVersionUID = -5104039842982989400L;

	@Column(name="name", nullable=false)
	private String name;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="team_user", joinColumns={@JoinColumn(name = "team_id")}, inverseJoinColumns={@JoinColumn(name = "user_id")})
	@BatchSize(size=5)
	private Set<User> members = new HashSet<User>();
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="team")
	@BatchSize(size=5)
	private Set<Project> projects = new HashSet<Project>();
	
	public Team() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<User> getMembers() {
		return members;
	}

	public void setMembers(Set<User> members) {
		this.members = members;
	}

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}
}
