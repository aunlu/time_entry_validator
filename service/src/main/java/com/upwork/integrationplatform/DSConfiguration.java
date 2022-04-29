package com.upwork.integrationplatform;

import com.odesk.agora.configuration.Configuration;
import com.odesk.agora.configuration.WSDependencyConfiguration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class DSConfiguration extends Configuration {

    @Valid
    @NotNull
    public WSDependencyConfiguration directoryDS;

    @Valid
    @NotNull
    public WSDependencyConfiguration offlineTimeRecordsDS;

    @Valid
    @NotNull
    public WSDependencyConfiguration partnerRequestOrchestrator;


}
