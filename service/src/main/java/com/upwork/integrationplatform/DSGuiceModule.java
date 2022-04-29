package com.upwork.integrationplatform;

import com.google.inject.Singleton;
import com.odesk.agora.guice.GuiceModule;
import com.upwork.integrationplatform.dao.TimeEntryDao;
import com.upwork.integrationplatform.service.TimeEntryValidatorService;
import com.upwork.integrationplatform.thrift.Ttest;

import com.google.inject.Provides;
import com.odesk.agora.shiro.IUserPermissionsProvider;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.skife.jdbi.v2.DBI;


public class DSGuiceModule extends GuiceModule<DSConfiguration> {

    @Provides
    public Subject providesSubject() {
        return SecurityUtils.getSubject();
    }

    @Override
    protected void configure() {
        super.configure();
        bind(IUserPermissionsProvider.class).to(PermissionsProvider.class);
        bind(TimeEntryValidatorService.class).in(Singleton.class);
    }

    @Provides
    @Singleton
    private TimeEntryDao providesTimeEntryDao(DBI dbi) {
        return dbi.onDemand(TimeEntryDao.class);
    }

}
