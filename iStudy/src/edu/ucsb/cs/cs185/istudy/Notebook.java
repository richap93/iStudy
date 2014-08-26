package edu.ucsb.cs.cs185.istudy;

public class Notebook {

	int id;
	String name;
	String created_at;
	
	public Notebook() {
		
		
		
	}
	
	public Notebook(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCreatedAt(String created_at) {
		this.created_at = created_at;
	}
	
	public long getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	public String getCreatedAt(){
		return this.created_at;
	}
	
	
}
