package banana.main.api.controller;

import org.jboss.logging.Logger;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	private final Logger log = Logger.getLogger(UserController.class);
	
//	@RequestMapping(method=RequestMethod.GET, path="/users")
//	public ResponseEntity<List<User>> getUser(@RequestParam(name="un", required=false) String username) {
//		
//		log.debug("getUser request: [username=" + username + "]");
//		
//		UserDao userdao = new UserDao();
//		
//		if (username == null || username.trim().equals("")) {
//			
//			//no username filter, return all
//			DBResponse dbResp = userdao.getAllUsers();
//			
//			if (dbResp.getStatus().equals(DBStatus.SUCCESS)) {
//				
//				List<User> ulist = (List<User>)dbResp.getRespObj();
//				if (ulist.size() > 0) {
//					
//					log.info("getUser response: [username=" + username + ", user list requested --> HTTP 200 OK, returning '" + ulist.size() + "' users]");
//					return new ResponseEntity<List<User>>(ulist, HttpStatus.OK);
//					
//				} else {
//					
//					log.info("getUser response: [username=" + username + ", user list requested --> HTTP 204 NO CONTENT, no user found");
//					return new ResponseEntity(HttpStatus.NO_CONTENT);
//				}
//				
//			} else {
//				
//			}
//			
//		} else {
//			
//			//search for specified user
//			List<User> ulist = userdao.getUserByName(username);
//			if (ulist.size() == 0) {
//				
//				log.error("getUser response: [username=" + username + "] --> HTTP 204 NO CONTENT, user not found");
//				return new ResponseEntity(HttpStatus.NO_CONTENT);
//				
//			} else if (ulist.size() > 1) {
//				
//				log.error("getUser response: [username=" + username + "] --> HTTP 500 INTERNAL SERVER ERROR, multiple users found: " + ulist.size());
//				return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
//				
//			} else {
//				
//				log.info("getUser response: [username=" + username + "] --> HTTP 200 OK, returning user profie");
//				return new ResponseEntity<List<User>>(ulist, HttpStatus.OK);
//				
//			}
//			
//		}
//		
//	}
	
//	@RequestMapping(method=RequestMethod.POST, path="/users", consumes="application/json")
//	public ResponseEntity<> updateUser(@RequestParam(required=true) User u) {
//		
//		UserDao dao = new UserDao();
//		dao.updateUser(u);
//		
//		
//		
//	}
	
}