package springHibernate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import springHibernate.service.ObatService;
import springHibernate.view.Obatview;

/**
 *
 * @author Dewanggga
 */
public class App {

    private static ApplicationContext applicationContext;
    
    public static void main(String[] args) {
            applicationContext = new ClassPathXmlApplicationContext("classpath:spring-configuration.xml");
            new Obatview().setVisible(true);
        }
    
        public static ObatService getObatService(){
            return (ObatService) applicationContext.getBean("ObatService");
        }
}
