package club.hdqyf.encryption.config;

import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author houdq
 * @version 1.0
 * @ClassName UploadFileConfig
 * @Description 页面全局配置文件
 * @date 2018/10/19 14:45
 **/
@Configuration
public class UploadFileConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("upload");
        registry.addViewController("upload.html").setViewName("upload");
        registry.addViewController("encrypt.html").setViewName("encrypt");
    }

    /**
     * tomcatEmbedded这段代码是为了解决上传文件大于10M出现连接重置的问题。此异常内容GlobalException也捕获不到。
     *
     * @param
     * @return org.springframework.boot.web.servlet.server.ServletWebServerFactory
     * @author houdq
     * @date 2018/10/19 15:37
     */
    @Bean
    public ServletWebServerFactory tomcatEmbedded() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.addConnectorCustomizers((TomcatConnectorCustomizer) connector -> {
            if ((connector.getProtocolHandler() instanceof AbstractHttp11Protocol<?>)) {
                ((AbstractHttp11Protocol<?>) connector.getProtocolHandler()).setMaxSwallowSize(-1);
            }
        });

        return tomcat;
    }
}
