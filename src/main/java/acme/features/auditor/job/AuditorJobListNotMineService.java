
package acme.features.auditor.job;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.auditRecords.AuditRecord;
import acme.entities.jobs.Job;
import acme.entities.roles.Auditor;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractListService;

@Service
public class AuditorJobListNotMineService implements AbstractListService<Auditor, Job> {

	@Autowired
	AuditorJobRepository repository;


	@Override
	public boolean authorise(final Request<Job> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<Job> request, final Job entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "reference", "title", "deadline");

	}

	@Override
	public Collection<Job> findMany(final Request<Job> request) {
		assert request != null;

		Collection<AuditRecord> auditrecords;
		List<Job> result = new ArrayList<>();
		Principal principal;

		principal = request.getPrincipal();
		auditrecords = this.repository.findDifferentsByAuditorId(principal.getActiveRoleId());
		for (AuditRecord a : auditrecords) {
			Job j;
			j = a.getJob();
			if (!result.contains(j)) {
				result.add(j);
			}
		}
		return result;
	}

}
