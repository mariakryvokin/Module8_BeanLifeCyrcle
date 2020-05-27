import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    private static AbstractApplicationContext applicationContext =
            new ClassPathXmlApplicationContext("beans.xml");

    public static void main(String[] args) {
        //showBeanLifeCircle();
        testInjectionPrototypeInSingleton();
        ///testMethodReplacement();
        applicationContext.close();
    }

    private static void testInjectionPrototypeInSingleton() {
        C firstC = applicationContext.getBean("c", C.class);
        C secondC = applicationContext.getBean("c", C.class);
        System.out.println("is d in c prototype " + (firstC.getDPrototype() != secondC.getDPrototype()));
        System.out.println("is c is singleton " + (firstC == secondC));
    }

    private static void showBeanLifeCircle() {
        applicationContext.getBean("f");
    }

    private static void testMethodReplacement() {
        E e = applicationContext.getBean("e",E.class);
        e.printMessage("LOl");
    }
}
