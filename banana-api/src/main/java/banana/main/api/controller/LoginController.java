package banana.main.api.controller;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import banana.db.utils.EncryptUtils;
import banana.main.dao.UserDao;
import banana.main.objects.User;

@RestController
public class LoginController {
	
	private final Logger log = Logger.getLogger(LoginController.class);
	
//	@RequestMapping(method=RequestMethod.POST, path="/login")
//	public ResponseEntity<User> verifyLogin(@RequestParam(value="username") String username, @RequestParam(value="password") String password) {
//		
//		log.info("verifyLogin request: name=" + username);
//		
//		UserDao userDao = new UserDao();
//		List<User> lUser = userDao.getUserByName(username);
//		User u = lUser.get(0); //safe to assume that there's only 1 user entry for this username
//		String ePw = EncryptUtils.passwordEncrypt(password);
//		
//		if (u.getPassword().equals(ePw)) {
//			
//			u = new User();
//			u.setUsername(username);
//			
//			log.info("verifyLogin response: [HTTP 200, log-in accepted]" );
//			
//			return new ResponseEntity<>(u, HttpStatus.OK);
//			
//		} else {
//			
//			u = new User();
//			u.setUsername(username);
//			u.setPassword(password);
//			
//			log.info("verifyLogin response: [HTTP 401 Unauthorized]" );
//			
//			return new ResponseEntity<>(u, HttpStatus.UNAUTHORIZED);
//			
//		}
		
//	}

}
