@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Value("${appName.allowedApi}")
    private String myAllowedApi;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("GET", "POST", "PUT", "DELETE").allowedOrigins(myAllowedApi);
    }
}