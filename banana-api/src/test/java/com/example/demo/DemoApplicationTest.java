package com.example.demo;

import java.util.List;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.jboss.logging.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import banana.main.dao.DBResponse;
import banana.main.dao.MongoConnect;
import banana.main.dao.UserDao;
import banana.main.objects.User;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTest {
	
	private final Logger log = Logger.getLogger(this.getClass());
	
	@BeforeEach
	public void setup() {
		MongoConnect.connect();
	}

	@Test
	public void contextLoads() {
		
		try {
			
			UserDao dao = new UserDao();
			User u = new User();
//			u.setUsername("nie");2
//			u.setUsername("nie");
			u.setPassword("nieniepassword");
			u.setEmail("alizaanos@gmail.com");
			u.setRole("Staff");
			DBResponse dbResp = dao.insertUser(u);
			
			log.info("DB Response: " + dbResp);
			
//			DBResponse dbResp = dao.getAllUsers();
//			
//			Logger log = Logger.getLogger(this.getClass().getName());
//			log.info("RESPONSE: " + dbResp);
//			List<User> list = (List<User>)dbResp.getRespObj();
//			for (User u : list) {
//				log.info("User: " + u);
//			}
			
//			log.info("=============================================================");
//			log.info("======================= UPDATE ==============================");
//			log.info("=============================================================");
//			
//			User u = new User();
//			u.setUsername("nie15");
//			u.setPassword("password");
//			u.setEmail("fireandaiz@gmail.com");
//			u.setRole("Staff");
//			dbResp = dao.updateUserByUsername(u);
//			
//			log.info("RESPONSE2: " + dbResp);
			
//			log.info("=============================================================");
//			log.info("======================= UPDATE ==============================");
//			log.info("=============================================================");
//			
//			User u = new User();
//			u.setId("5b2a3ce92558e530f072ffe8");
//			u.setUsername("nie15");
//			u.setPassword("password");
//			u.setEmail("fireandaiz@gmail.com");
//			u.setRole("Staff");
//			dbResp = dao.updateUserById(u);
			
//			log.info("RESPONSE2: " + dbResp);
			
//			dbResp = dao.getUserByName("nie1");
//			log.info("RESPONSE: " + dbResp);
			
		} catch (Exception ex) {
			log.info(ExceptionUtils.getStackTrace(ex));
		}
		
	}

}