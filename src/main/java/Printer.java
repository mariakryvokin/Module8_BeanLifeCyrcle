import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

public class Printer implements MethodReplacer {

    public Object reimplement(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("New printer trint: " + objects[0]);
        return objects;
    }
}
