package com.shaman.test.giterek.configuration;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import ma.glasnost.orika.Converter;
import ma.glasnost.orika.Mapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import ma.glasnost.orika.impl.DefaultMapperFactory;

@Component
public class OrikaBeanMapper extends ConfigurableMapper implements ApplicationContextAware {

	private MapperFactory factory;
	private ApplicationContext applicationContext;

	public OrikaBeanMapper() {
		super(false);
	}

	@Override
	protected void configure(MapperFactory factory) {
		this.factory = factory;
		addAllSpringBeans(applicationContext);
	}

	@Override
	protected void configureFactoryBuilder(final DefaultMapperFactory.Builder factoryBuilder) {
		// Nothing to configure for now
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void addMapper(Mapper<?, ?> mapper) {
		factory.classMap(mapper.getAType(), mapper.getBType())
				.byDefault()
				.customize((Mapper) mapper)
				.register();
	}

	public void addConverter(Converter<?, ?> converter) {
		factory.getConverterFactory().registerConverter(converter);
	}

	@SuppressWarnings("rawtypes")
	private void addAllSpringBeans(final ApplicationContext applicationContext) {
		Map<String, Mapper> mappers = applicationContext.getBeansOfType(Mapper.class);
		for (Mapper mapper : mappers.values()) {
			addMapper(mapper);
		}
		Map<String, Converter> converters = applicationContext.getBeansOfType(Converter.class);
		for (Converter converter : converters.values()) {
			addConverter(converter);
		}
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
		init();
	}

}