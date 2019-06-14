package cl.roberto.webapi.eventos.documentacion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@EnableSwagger2
@Configuration
public class SwaggerCofig {

    //swagger-ui.htmll
    //v2/api-docs

    public static final Contact CUSTOMDEFAULT_CONTACT = new Contact("asd test roberto", "http://localhost", "asd@asd.cl");
    public static final ApiInfo CUSTOMAPIINFO = new ApiInfo("Api Documentation", "Api Documentation", "1.0", "urn:tos", CUSTOMDEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");
    public static final Set<String> DEFAULT_PRODUCTO_CONSUMO = new HashSet<String>(Arrays.asList("application/json", "application/xml"));


    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SPRING_WEB).apiInfo(CUSTOMAPIINFO).produces(DEFAULT_PRODUCTO_CONSUMO);
    }
}
