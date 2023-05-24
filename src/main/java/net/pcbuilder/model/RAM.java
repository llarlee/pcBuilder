package net.pcbuilder.model;

import javax.persistence.*;

@Entity
@Table(name = "TBL_RAM")
public class RAM {
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(generator = "gen")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "size")
	private String size;

	@Column(name = "price")
	private long price;
	
	public RAM(long id, String name, String size, long price) {
		super();
		this.id = id;
		this.name = name;
		this.size = size;
		this.price = price;
	}
	
	public RAM() {
		super();
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setSize(String size) {
		this.size = size;
	}
	
	public String getSize() {
		return this.size;
	}
	
	public void setPrice(long price) {
		this.price = price;
	}
	
	public long getPrice() {
		return this.price;
	}

}
