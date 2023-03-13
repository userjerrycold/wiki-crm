package com.wiki.core.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2//开启Swagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {

    //注入配置文件中的项目名称
    @Value("${server.servlet.context-path}")
    private String contextPath;


    /**
     * 不重写 无法匹配路径
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("doc.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    /**
     * 构建 swagger2 api 文档的详细信息函数
     * @return
     */
    private ApiInfo initApiInfo() {
        return new ApiInfoBuilder()
                .title("wiki-crm API")//大标题
                .version( "1.0.0")//版本
                .build();
    }


    /**
     * swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
     * @return
     */
    @Bean
    public Docket restfulApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(initApiInfo())
                .groupName("wiki-crm")
                //.genericModelSubstitutes(DeferredResult.class)
                .genericModelSubstitutes(ResponseEntity.class)
                .useDefaultResponseMessages(true)
                .forCodeGeneration(false)
                //.pathMapping(contextPath) // base，最终调用接口后会和paths拼接在一起
                .select()
                //加了ApiOperation注解的类，才生成接口文档
                //.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                //暴露接口地址的包路径（即此包下的类，才生成接口文档）
                .apis(RequestHandlerSelectors.basePackage("com.wiki.core"))
               // .paths(doFilteringRules())//自定义的过滤规则
                .build();
    }

}