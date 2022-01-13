package my.service.myAuth;

import my.service.myAuth.domain.AppOrg;
import my.service.myAuth.domain.AppRole;
import my.service.myAuth.domain.AppUser;
import my.service.myAuth.service.AppUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class MyAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyAuthApplication.class, args);
	}

//	@Bean
//	PasswordEncoder passwordEncoder(){
//		return new BCryptPasswordEncoder();
//	}

	@Bean
	CommandLineRunner run(AppUserService userService){
		return orgs->{
			userService.saveRole(new AppRole(null,"ROLE_USER"));
			userService.saveRole(new AppRole(null,"ROLE_MANAGER"));
			userService.saveRole(new AppRole(null,"ROLE_ADMIN"));
			userService.saveRole(new AppRole(null,"ROLE_SUPER_ADMIN"));

			userService.saveOrg(new AppOrg(null,"1000","APT"));
			userService.saveOrg(new AppOrg(null,"2000","CNN"));

			userService.saveUser(new AppUser(null,"John","john@yahoo.com.tw","12345",new ArrayList<>(),new ArrayList<>()));
			userService.saveUser(new AppUser(null,"kevin","kevin@yahoo.com.tw","12345",new ArrayList<>(),new ArrayList<>()));
			userService.saveUser(new AppUser(null,"eric","eric@yahoo.com.tw","12345",new ArrayList<>(),new ArrayList<>()));
			userService.saveUser(new AppUser(null,"alen","alen@yahoo.com.tw","12345",new ArrayList<>(),new ArrayList<>()));

			userService.addRoleToUser("john","ROLE_USER");
			userService.addRoleToUser("kevin","ROLE_MANAGER");
			userService.addRoleToUser("kevin","ROLE_USER");
			userService.addRoleToUser("eric","ROLE_ADMIN");
			userService.addRoleToUser("alen","ROLE_SUPER_ADMIN");
			userService.addRoleToUser("alen","ROLE_ADMIN");

			userService.addOrgToUser("john","CNN");
			userService.addOrgToUser("kevin","APT");
			userService.addOrgToUser("eric","APT");
			userService.addOrgToUser("alen","APT");



		};
	}
}
