package Fr.test.CloudGateway.Config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuring the gateway to redirect Actuator endpoint requests to the corresponding microservice.
 *
 * @Author [Mohamed Said Taleb]
 * Creation date : 12/03/2023
 */
@Configuration
public class ActuatorConfig {
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes().route("microservice-referential", r -> r.path("/actuator/**").filters(f -> f.rewritePath("/actuator/(?<segment>.*)", "/${segment}")).uri("lb://microservice-referential")).build();
    }
}
