package com.marcos.demo;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.marcos.demo.bean.BeanPersonalizado;
import com.marcos.demo.bean.MyBean;
import com.marcos.demo.bean.MyBeanWithDependency;
import com.marcos.demo.bean.MyBeanWithProperties;
import com.marcos.demo.components.ComponentDependency;
import com.marcos.demo.entity.User;
import com.marcos.demo.pojo.UserPojo;
import com.marcos.demo.repository.UserRepository;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	private final Log LOGGER = LogFactory.getLog(DemoApplication.class);

	@Autowired
	@Qualifier("componentTwoImplement")
	private ComponentDependency componentDependency;
	@Autowired
	private MyBean myBean;
	@Autowired
	private MyBeanWithDependency myBeanWithDependency;
	@Autowired
	private BeanPersonalizado beanPersonalizado;
	@Autowired
	private MyBeanWithProperties myBeanWithProperties;
	@Autowired
	private UserPojo userPojo;
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// ejemplosAnteriores();
		saveUsersInDataBase();
		getInformationJpqlFromUser();
	}

	private void getInformationJpqlFromUser() {
		LOGGER.info(
				"Usuario con el metodo findByUserEmail " +
						userRepository.findByUserEmail("Pedro@domain.com")
								.orElseThrow(() -> new RuntimeException("No se encontro el usuario")));

		userRepository.findAndSort("user", Sort.by("id").descending())
				.stream()
				.forEach(user -> LOGGER.info("Usuario con metodo sort " + user));

		userRepository.findByName("John")
				.forEach(user -> LOGGER.info("Usuario con query method " + user.getName()));

		LOGGER.info("Usuario con query method" +
				userRepository.findByEmailAndName("Daniela@domain.com", "Daniela")
						.orElseThrow(() -> new RuntimeException("Usuario no encontrado")));
	}

	private void saveUsersInDataBase() {
		User user1 = new User("John", "john@domain.com", LocalDate.of(2021, 3, 20));
		User user2 = new User("Daniela", "Daniela@domain.com", LocalDate.of(2021, 5, 23));
		User user3 = new User("Pedro", "Pedro@domain.com", LocalDate.of(2000, 12, 1));
		User user4 = new User("John", "john@domain.com", LocalDate.of(2018, 3, 20));
		User user5 = new User("user5", "user5@domain.com", LocalDate.of(2017, 6, 21));
		User user6 = new User("user6", "user6@domain.com", LocalDate.of(2015, 4, 22));
		User user7 = new User("user7", "user7@domain.com", LocalDate.of(2002, 1, 23));
		User user8 = new User("user8", "user8@domain.com", LocalDate.of(2006, 7, 24));
		User user9 = new User("user9", "user9@domain.com", LocalDate.of(2005, 4, 25));
		User user10 = new User("user10", "user10@domain.com", LocalDate.of(2022, 3, 26));
		List<User> list = Arrays.asList(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10);
		list.stream().forEach(userRepository::save);
	}

	private void ejemplosAnteriores() {
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		beanPersonalizado.suma(1, 3);
		System.out.println(myBeanWithProperties.function());
		System.out.println(userPojo.getEmail() + " " + userPojo.getPassword());
		try {
			int value = 10 / 0;
			LOGGER.debug("Mi valor" + value);
		} catch (Exception e) {
			LOGGER.error("Esto es un error al dividir por cero " + e.getMessage());
		}
	}

}
