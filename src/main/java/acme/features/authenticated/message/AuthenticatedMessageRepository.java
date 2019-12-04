
package acme.features.authenticated.message;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.messageThread.Message;
import acme.entities.messageThread.Thread;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedMessageRepository extends AbstractRepository {

	@Query("select m from Message m where m.id = ?1")
	Message findOneById(int id);

	@Query("select t from Thread t where t.id = ?1")
	Thread findThreadByid(int id);

	@Query("select m from Message m join m.thread t where t.id = ?1")
	Collection<Message> findMessagesByThreadId(int id);

}
