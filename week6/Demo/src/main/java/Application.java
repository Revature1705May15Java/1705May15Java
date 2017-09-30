import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ex.service.CustomerService;

public class Application {

	public static void main(String[] args) {
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		CustomerService service = appContext.getBean("CustomerService", CustomerService.class);
		System.out.println(service.findAll().get(0).getFirstname());
		System.out.println(service.findAll().size());

	}

}
