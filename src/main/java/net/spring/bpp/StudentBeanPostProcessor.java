package net.spring.bpp;

import net.spring.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class StudentBeanPostProcessor implements BeanPostProcessor {
    private static final Logger LOGGER = LoggerFactory.getLogger("StudentBeanPostProcessor");

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Student) {
            LOGGER.info("In postProcessBeforeInitialization " + bean);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Student) {
            LOGGER.info("In postProcessAfterInitialization " + bean);
        }
        return bean;
    }
}
