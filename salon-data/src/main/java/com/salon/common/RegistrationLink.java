package com.salon.common;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RegistrationLink {

    @Value("${app.host}")
    private String appHost;
    @Value("${app.name}")
    private String appName;
    @Value("${app.activatepath}")
    private String appActivatePath;

    public String getAppHost() {
        return appHost;
    }

    public void setAppHost(String appHost) {
        this.appHost = appHost;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppActivatePath() {
        return appActivatePath;
    }

    public void setAppActivatePath(String appActivatePath) {
        this.appActivatePath = appActivatePath;
    }
}
