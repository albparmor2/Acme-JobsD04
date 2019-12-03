
package acme.entities.messageThread;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;

import acme.framework.entities.Authenticated;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Thread extends DomainEntity {

	/**
	 *
	 */
	private static final long					serialVersionUID	= 1L;

	@NotBlank
	private String								title;

	@Temporal(TemporalType.TIMESTAMP)
	@Past
	private Date								moment;

	@NotEmpty
	@OneToMany
	private Collection<@Valid Message>			messages;

	@NotEmpty
	@OneToMany
	private Collection<@Valid Authenticated>	users;
}
