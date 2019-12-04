
package acme.features.authenticated.message;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.messageThread.Message;
import acme.entities.messageThread.Thread;
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

		Thread thread = this.repository.findThreadByid(request.getModel().getInteger("id"));
		List<Authenticated> lsaut = (List<Authenticated>) thread.getUsers();
		Principal principal = request.getPrincipal();
		boolean res = false;
		for (int i = 0; i < lsaut.size(); i++) {
			if (lsaut.get(i).getUserAccount().getId() == principal.getAccountId()) {
				res = true;
				break;
			}
		}
		return res;
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
