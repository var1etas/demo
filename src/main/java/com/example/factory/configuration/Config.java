package com.example.factory.configuration;

import com.example.factory.beans.BeanOne;
import com.example.factory.beans.BeanThree;
import com.example.factory.beans.BeanTwo;
import com.example.factory.configuration.property.ApplicationProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
@EnableConfigurationProperties(value = ApplicationProperties.class)
public class Config {

    @Bean
    @Profile("test")
    public BeanOne beanOne() {
        return new BeanOne();
    }

    @Bean
    @ConditionalOnBean(name = "beanOne")
    public BeanTwo secondBean() {
        return new BeanTwo();
    }

    @Bean
    @ConditionalOnExpression("#{!'${spring.application.env}'.equals('default')}")
    public BeanThree thirdBean() {
        return new BeanThree();
    }
}
