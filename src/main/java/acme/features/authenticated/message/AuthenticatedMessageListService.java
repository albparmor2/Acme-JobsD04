
package acme.features.authenticated.message;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.messageThread.Message;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedMessageListService implements AbstractListService<Authenticated, Message> {

	@Autowired
	AuthenticatedMessageRepository repository;


	@Override
	public boolean authorise(final Request<Message> request) {
		assert request != null;

		boolean result;
		int authenticatedId;
		int authenticatedThreadId;
		Principal principal;
		Collection<Integer> usersId;

		principal = request.getPrincipal();
		authenticatedId = principal.getAccountId();
		usersId = this.repository.findManyUsersId(request.getModel().getInteger("id"));
		authenticatedThreadId = this.repository.findUserIdByid(request.getModel().getInteger("id"));
		result = authenticatedThreadId == authenticatedId || usersId.contains(principal.getAccountId());
		return result;
	}

	@Override
	public void unbind(final Request<Message> request, final Message entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "moment", "title");
	}

	@Override
	public Collection<Message> findMany(final Request<Message> request) {
		assert request != null;

		Collection<Message> result;

		result = this.repository.findMessagesByThreadId(request.getModel().getInteger("id"));

		return result;
	}

}
