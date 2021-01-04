package digital.future.vote.backend

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import digital.future.vote.backend.polls.Poll
import digital.future.vote.backend.polls.PollsController
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.*
import io.javalin.plugin.openapi.OpenApiOptions
import io.javalin.plugin.openapi.OpenApiPlugin
import io.javalin.plugin.openapi.ui.SwaggerOptions
import io.swagger.v3.oas.models.info.Info

fun main(args: Array<String>) {
    ObjectMapper().registerKotlinModule()
    Javalin.create { conf ->
        conf.registerPlugin(OpenApiPlugin(getOpenApiOptions()))
        conf.defaultContentType = "application/json"
    }
        .start(8080)
        .get("/") { ctx -> ctx.result("Hello Javalin & Kotlin!") }
        .routes {
            get("version"){ ctx -> ctx.result("Vote Backend Version 1.0")}
            path("poll"){
                get { ctx -> PollsController::getAllPolls }
            }
    }



}

fun getOpenApiOptions(): OpenApiOptions {
    return OpenApiOptions(Info()
            .version("1.0")
            .description("Voting Backend API")
        )
        .activateAnnotationScanningFor("digital.future.vote.backend")
        .path("/swagger-docs") // endpoint for OpenAPI json
        .swagger(SwaggerOptions("/swagger-ui")) // endpoint for swagger-ui
}