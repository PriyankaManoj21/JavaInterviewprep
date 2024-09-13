package com.projectinterview;

import java.util.Comparator;
import java.util.Objects;

public class User implements Comparable<User>{

	private int id;
	private String name;

	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

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

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}

	@Override
	public int compareTo(User o) {
		return this.id - o.id;
	}

	// comparator 
	public static Comparator<User> namecmp = (o1, o2) -> {return o1.getName().compareTo(o2.getName());};

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(name, other.name);
	}
	
	
	
	
	
}
