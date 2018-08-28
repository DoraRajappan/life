package demo;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.life.service.UserService;
import org.life.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ComponentScan("org.life")
@RestController
public class UiApplication {
	//@Autowired 
	//UserServiceImpl userService;
	@RequestMapping("/resource")
	public Map<String,Object> home() {
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("id", UUID.randomUUID().toString());
		model.put("content", "Hello World");
		return model;
	}
	@RequestMapping("/login")
	public void login(String userName, String password) {
		//try {

			//org.life.entity.User user = userService.get(userName);
			//if (user == null) {
				/*FacesMessage msg = new FacesMessage("User not exist in system.");
				FacesContext.getCurrentInstance().addMessage("null", msg);
				setInfoMessage("User not exist in system."); */
			//} else if (!user.getPassword().equals(password)) {
				/*FacesMessage msg = new FacesMessage("Password do not match.");

				FacesContext.getCurrentInstance().addMessage("null", msg);
				setInfoMessage("Password do not match.");
				succeed = "failure";
				*/
			//} else {
				/*succeed = "success";
				// get last login info
				lastLogin = loginServiceBean.getLastLoggedin(user.getId());
				// set current logininfo
				currentLogin = new Login();
				currentLogin.setUserId(user.getId());
				currentLogin.setLoggedInDate(new Timestamp(System
						.currentTimeMillis()));
				loginServiceBean.createOrUpdate(currentLogin);
				this.id = user.getId();
				this.userId = user.getId();
				this.firstName = user.getFirstName();
				this.surName = user.getSurname();
		*/		
			//}

		//} finally {

		//}

	}
	/*
	public void createAccountJPA() {

		org.lifebook.entity.User userEJB = new org.lifebook.entity.User();

		userEJB.setUserId(name);
		userEJB.setPassword(password);
		userEJB.setFirstName(firstName);
		userEJB.setSurname(surName);
		userEJB.setCountryCode(country);
		userEJB.setZipCode(zipCode);
		userServiceBean.createOrUpdate(userEJB);
		succeed = "success";
		org.lifebook.entity.User user = userServiceBean.get(name);
		this.id = user.getId();
		this.userId = user.getId();
		this.firstName = user.getFirstName();
		this.surName = user.getSurname();
		List<org.lifebook.entity.Domain> domainsEJB = domainServiceBean
				.getDomainList();
		domainsEJB = domainServiceBean.getDomainList();
		Domain localDomain;
		for (org.lifebook.entity.Domain domain : domainsEJB) {
			localDomain = new Domain();
			localDomain.setId(domain.getId());
			localDomain.setName(domain.getName());
			domains.add(localDomain);
		}
	}
	*/
	public static void main(String[] args) {
		SpringApplication.run(UiApplication.class, args);
	}

}
