package com.linzoe.common.spring;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DynamicBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

	@Value("spring.dynamic.inject.class:")
	private String clzes;

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

	}

	@SuppressWarnings("rawtypes")
	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		if (StringUtils.isEmpty(clzes)) {
			return;
		}
		List<String> clzList = Arrays.asList(clzes.split(","));
		for (String clzName : clzList) {
			if (clzName.trim().equals("")) {
				continue;
			}
			try {
				Class clz = Class.forName(clzName);
				BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(clz);
				// 注入属性
				// builder.addPropertyValue("name", "sfz_" + i);
				registry.registerBeanDefinition(clz.getSimpleName(), builder.getBeanDefinition());
				log.info("注入class={}到spring容器中", clzName);
			} catch (Exception e) {
				log.error("注入到spring容器失败,class={}", clzName);
				log.error(e.getMessage());
			}
		}
	}

}
