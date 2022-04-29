package com.upwork.integrationplatform;

import com.google.inject.servlet.GuiceFilter;
import com.odesk.agora.AgoraApplication;
import com.upwork.integrationplatform.service.TimeEntryValidatorService;
import io.dropwizard.setup.Environment;
import org.glassfish.jersey.media.multipart.MultiPartFeature;

public class DSService extends AgoraApplication<DSConfiguration, DSGuiceModule> {
    public static void main(final String[] args) throws Exception {
        new DSService().run(args);
    }

    @SuppressWarnings("unchecked")
    protected DSService() {
        super("validatorService", DSConfiguration.class, null, new DSGuiceModule(), DSResource.class);
    }

    @Override
    public void run(final DSConfiguration configuration, final Environment environment) throws Exception {
        super.run(configuration, environment);
        environment.servlets()
                .addFilter("Guice Filter", GuiceFilter.class)
                .addMappingForUrlPatterns(null, false, "/*");

        environment.jersey().register(MultiPartFeature.class);
//        getGuiceInjector().getInstance(TimeEntryValidatorService.class).run();
    }
}
