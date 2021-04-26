package in.com.psi.dashboard.entity;

// Generated 6 Feb, 2016 10:56:52 AM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * WorkExperience generated by hbm2java
 */
@Entity
@Table(name = "work_experience", catalog = "dashboard")
public class WorkExperience implements java.io.Serializable {

	private Long id;
	private Employee employee;
	private Long pastExperience;
	private Long psExperience;
	private Long totalExperience;

	public WorkExperience() {
	}

	public WorkExperience(Employee employee, Long pastExperience,
			Long psExperience, Long totalExperience) {
		this.employee = employee;
		this.pastExperience = pastExperience;
		this.psExperience = psExperience;
		this.totalExperience = totalExperience;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id")
	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Column(name = "past_experience")
	public Long getPastExperience() {
		return this.pastExperience;
	}

	public void setPastExperience(Long pastExperience) {
		this.pastExperience = pastExperience;
	}

	@Column(name = "ps_experience")
	public Long getPsExperience() {
		return this.psExperience;
	}

	public void setPsExperience(Long psExperience) {
		this.psExperience = psExperience;
	}

	@Column(name = "total_experience")
	public Long getTotalExperience() {
		return this.totalExperience;
	}

	public void setTotalExperience(Long totalExperience) {
		this.totalExperience = totalExperience;
	}

}