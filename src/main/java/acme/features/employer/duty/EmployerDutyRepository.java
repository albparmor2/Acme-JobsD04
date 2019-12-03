
package acme.features.employer.duty;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.jobs.Descriptor;
import acme.entities.jobs.Duty;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EmployerDutyRepository extends AbstractRepository {

	@Query("select j.descriptor from Job j where j.id = ?1")
	Descriptor findOneDescriptorByJobId(int id);

	@Query("select d.mandatoryDuties from Descriptor d where d.id = ?1")
	Collection<Duty> findDutiesbyDescriptorId(int id);

	@Query("select d from Duty d where d.id = ?1")
	Duty findOneDutyById(int id);
}
