import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        applicationContext.getBean("f");
        DBeanWithPrototypeScope firstBeanWithPrototypeScope = applicationContext
                .getBean("d", DBeanWithPrototypeScope.class);
        DBeanWithPrototypeScope secondBeanWithPrototypeScope = applicationContext
                .getBean("d", DBeanWithPrototypeScope.class);
        System.out.println(firstBeanWithPrototypeScope != secondBeanWithPrototypeScope);
        E e = applicationContext.getBean("e",E.class);
        e.printMessage("LOl");
        applicationContext.close();
    }
}
