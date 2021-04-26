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
 * Country generated by hbm2java
 */
@Entity
@Table(name = "country", catalog = "dashboard")
public class Country implements java.io.Serializable {

	private Integer id;
	private String sortname;
	private String name;
	private Set<Employee> employeesForPermanentCountryId = new HashSet<Employee>(
			0);
	private Set<Employee> employeesForPresentCountryId = new HashSet<Employee>(
			0);
	private Set<State> states = new HashSet<State>(0);

	public Country() {
	}

	public Country(String sortname, String name) {
		this.sortname = sortname;
		this.name = name;
	}

	public Country(String sortname, String name,
			Set<Employee> employeesForPermanentCountryId,
			Set<Employee> employeesForPresentCountryId, Set<State> states) {
		this.sortname = sortname;
		this.name = name;
		this.employeesForPermanentCountryId = employeesForPermanentCountryId;
		this.employeesForPresentCountryId = employeesForPresentCountryId;
		this.states = states;
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

	@Column(name = "sortname", nullable = false, length = 3)
	public String getSortname() {
		return this.sortname;
	}

	public void setSortname(String sortname) {
		this.sortname = sortname;
	}

	@Column(name = "name", nullable = false, length = 150)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "countryByPermanentCountryId")
	public Set<Employee> getEmployeesForPermanentCountryId() {
		return this.employeesForPermanentCountryId;
	}

	public void setEmployeesForPermanentCountryId(
			Set<Employee> employeesForPermanentCountryId) {
		this.employeesForPermanentCountryId = employeesForPermanentCountryId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "countryByPresentCountryId")
	public Set<Employee> getEmployeesForPresentCountryId() {
		return this.employeesForPresentCountryId;
	}

	public void setEmployeesForPresentCountryId(
			Set<Employee> employeesForPresentCountryId) {
		this.employeesForPresentCountryId = employeesForPresentCountryId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
	public Set<State> getStates() {
		return this.states;
	}

	public void setStates(Set<State> states) {
		this.states = states;
	}

}