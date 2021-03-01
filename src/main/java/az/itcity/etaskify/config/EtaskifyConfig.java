package az.itcity.etaskify.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class EtaskifyConfig {
    private String jwtSecret;

    public String getJwtSecret() {
        return jwtSecret;
    }

    public void setJwtSecret(String jwtSecret) {
        this.jwtSecret = jwtSecret;
    }
}
