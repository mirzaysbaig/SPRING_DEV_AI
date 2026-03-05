package EurekaPro.ApiGateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {

        return builder.routes()
                .route(
                "order-service", r->r
                        .path("/order/**")
                                .filters(f->f.rewritePath("/order(?<segment>.*)","/api/order${segment}"))
                        .uri("lb://ORDER-SERVICE")

        ).build();
//         we can add one more route accordingly to us

    }
}
