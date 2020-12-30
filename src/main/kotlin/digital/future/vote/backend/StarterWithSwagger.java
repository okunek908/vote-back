package digital.future.vote.backend;

import io.javalin.Javalin;
import io.javalin.plugin.openapi.OpenApiOptions;
import io.javalin.plugin.openapi.OpenApiPlugin;
import io.javalin.plugin.openapi.ui.SwaggerOptions;
import io.swagger.v3.oas.models.info.Info;


public class StarterWithSwagger {
    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> {
            config.registerPlugin(getConfiguredOpenApiPlugin());
            config.defaultContentType = "application/json";
        }).start(8080);
        app.get("/", ctx -> ctx.result("Hello Javalin & Swagger!"));
    }

    private static OpenApiPlugin getConfiguredOpenApiPlugin() {
        OpenApiOptions options = new OpenApiOptions(new Info().version("1.0").description("Voting Backend API"))
                .activateAnnotationScanningFor("digital.future.vote.backend")
                .path("/swagger-docs") // endpoint for OpenAPI json
                .swagger(new SwaggerOptions("/swagger-ui")) // endpoint for swagger-ui
        ;
        return new OpenApiPlugin(options);
    }
}
