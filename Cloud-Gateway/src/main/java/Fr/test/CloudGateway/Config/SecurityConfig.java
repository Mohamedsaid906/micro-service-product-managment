package Fr.test.CloudGateway.Config;

import Fr.test.CloudGateway.Util.http.HttpCustomException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

/**
 * By Mohamed said taleb
 * Desc :this is a security configuration class for our API-Gateway...
 * Add authentication to our API-Gateway
 */
@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity serverHttpSecurity) throws HttpCustomException {
        serverHttpSecurity.csrf().disable();
        return serverHttpSecurity.build();
    }

}
