
package acme.entities.auditRecords;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import acme.entities.jobs.Job;
import acme.entities.roles.Auditor;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class AuditRecord extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	private String				title;

	@NotNull
	private Status				status;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Past
	private Date				creation;

	@NotBlank
	private String				body;


	@Transient
	public boolean isFinalMode() {
		boolean res = false;
		if (this.status == Status.Published) {
			res = true;
		}
		return res;
	};


	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private Auditor	auditor;

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private Job		job;
}
