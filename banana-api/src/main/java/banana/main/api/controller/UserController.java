package banana.main.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import banana.db.mongo.dao.UserDao;
import banana.main.objects.User;

@RestController
public class UserController {
	
//	@RequestMapping(method=RequestMethod.GET, path="/users")
	@RequestMapping("/users")
	public List<User> getAllUsers() {
		
		UserDao userdao = new UserDao();
		return userdao.getAllUsers();
		
	}

}
