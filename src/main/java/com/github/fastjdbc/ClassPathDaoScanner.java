package com.github.fastjdbc;

import java.util.Arrays;
import java.util.Set;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import com.github.fastjdbc.annotations.Dao;

/**
 * 
 * @Description: ClassPathDaoScanner
 * @Author: Fred Feng
 * @Date: 07/01/2025
 * @Version 1.0.0
 */
public class ClassPathDaoScanner extends ClassPathBeanDefinitionScanner {

    public ClassPathDaoScanner(BeanDefinitionRegistry registry) {
        super(registry, false);
    }

    @Override
    protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
        addIncludeFilter(new AnnotationTypeFilter(Dao.class));
        Set<BeanDefinitionHolder> beanDefinitionHolders = super.doScan(basePackages);
        if (beanDefinitionHolders.isEmpty()) {
            logger.warn("No Dao mapping was found in '" + Arrays.toString(basePackages)
                    + "' package. Please check your configuration.");
        } else {
            processBeanDefinitions(beanDefinitionHolders);
        }
        return beanDefinitionHolders;
    }

    @Override
    protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
        return beanDefinition.getMetadata().isInterface()
                && beanDefinition.getMetadata().isIndependent();
    }

    private void processBeanDefinitions(Set<BeanDefinitionHolder> beanDefinitionHolders) {
        GenericBeanDefinition beanDefinition;
        for (BeanDefinitionHolder beanDefinitionHolder : beanDefinitionHolders) {
            beanDefinition = ((GenericBeanDefinition) beanDefinitionHolder.getBeanDefinition());
            beanDefinition.getConstructorArgumentValues()
                    .addGenericArgumentValue(beanDefinition.getBeanClassName());
            beanDefinition.setBeanClass(DaoProxyBeanFactory.class);
            beanDefinition.setAutowireMode(GenericBeanDefinition.AUTOWIRE_BY_TYPE);
        }
    }

}
