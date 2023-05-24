package net.pcbuilder.model;

import javax.persistence.*;

@Entity
@Table(name = "TBL_CPU")
public class CPUnit {
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(generator = "gen")
	private Long id;
	
	@Column(name = "name")
	private String name;

	@Column(name = "price")
	private long price;
	
	public CPUnit(long id, String name, long price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	public CPUnit() {
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
	
	public void setPrice(long price) {
		this.price = price;
	}
	
	public long getPrice() {
		return this.price;
	}

}
