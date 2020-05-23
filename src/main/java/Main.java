import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        applicationContext.getBean("c");
        E e = applicationContext.getBean("e",E.class);
        e.printMessage("LOl");
        applicationContext.close();
    }
}
