package stackjava.com.hibernatedemo.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "company")
public class Company {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name")
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
	private Set<Employee> listEmployee = new HashSet<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Employee> getListEmployee() {
		return listEmployee;
	}

	public void setListEmployee(Set<Employee> listEmployee) {
		this.listEmployee = listEmployee;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + "]";
	}
	
}
