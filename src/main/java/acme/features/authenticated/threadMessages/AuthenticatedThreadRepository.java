
package acme.features.authenticated.threadMessages;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedThreadRepository extends AbstractRepository {

	@Query("select a from Thread a where a.id = ?1")
	Thread findOneById(int id);

	@Query("select a from Thread a ")
	Collection<Thread> findMany();
}
