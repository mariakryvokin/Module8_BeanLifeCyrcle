import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import java.util.Arrays;

public class F implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, BeanPostProcessor, InitializingBean,
        DisposableBean {

    private Logger logger = LogManager.getLogger();
    private String beanName;

    public void init() {
        logger.info("Custom init method of F bean");
    }

    public void customDestroy() {
        logger.info("Custom destroy method of F bean");
    }

    @PostConstruct
    public void doPostConstruct() {
        logger.info("PostConstruct of F bean");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        logger.info("setBeanFactory:: F singleton= " + beanFactory.isSingleton(beanName));
    }

    @Override
    public void setBeanName(String beanName) {
        this.beanName = beanName;
        logger.info("setBeanName:: Bean Name defined in context= " + beanName);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        logger.info("setApplicationContext:: Bean Definition Names= " +
                Arrays.toString(applicationContext.getBeanDefinitionNames()));
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        logger.info("Post Process Before Initialization method is called : Bean Name " + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        logger.info("Post Process After Initialization method is called : Bean Name " + beanName);
        return bean;
    }

    @Override
    public void destroy() throws Exception {
        logger.info("Destroy method of F bean called !! ");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("afterPropertiesSet method of F bean is called !! ");
    }
}
