package in.com.psi.dashboard.entity;

// Generated 6 Feb, 2016 10:56:52 AM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * House generated by hbm2java
 */
@Entity
@Table(name = "house", catalog = "dashboard")
public class House implements java.io.Serializable {

	private Integer id;
	private String name;
	private Set<Employee> employees = new HashSet<Employee>(0);

	public House() {
	}

	public House(String name) {
		this.name = name;
	}

	public House(String name, Set<Employee> employees) {
		this.name = name;
		this.employees = employees;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false, length = 30)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "house")
	public Set<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

}