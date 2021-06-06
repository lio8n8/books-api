package com.app.books.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import java.util.Set;

/**
 * Contains configs related to converters.
 */
@Configuration
public class ConverterConfigs {

    @Bean
    @Primary
    ConversionService getConversionService(Set<Converter> converters) {
        ConversionServiceFactoryBean conversionServiceFactoryBean = new ConversionServiceFactoryBean();

        conversionServiceFactoryBean.setConverters(converters);
        conversionServiceFactoryBean.afterPropertiesSet();

        return conversionServiceFactoryBean.getObject();
    }
}
