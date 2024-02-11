package com.playground;

import com.giffing.wicket.spring.boot.starter.app.WicketBootStandardWebApplication;
import com.playground.view.HomePage;
import org.apache.wicket.Page;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class WicketWebApplication extends WicketBootStandardWebApplication {

    public static void main(String[] args){
        new SpringApplicationBuilder()
                .sources(WicketWebApplication.class)
                .run(args);
    }

    @Override
    protected void init() {
        super.init();
    }

    @Override
    public Class<? extends Page> getHomePage() {
        return HomePage.class;
    }
}
