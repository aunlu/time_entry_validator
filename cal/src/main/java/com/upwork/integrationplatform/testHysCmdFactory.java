package com.upwork.integrationplatform;

import com.odesk.agora.commons.hystrix.WsDependencyHysCmdBuilder;
import com.odesk.agora.hystrix.GenericWsDependencyHystrixCommand;
import com.upwork.integrationplatform.thrift.Ttest;

public class testHysCmdFactory {
    private static final String serviceName = "validatorService";

    public GenericWsDependencyHystrixCommand<Ttest> getEntity(final String uid) {
        return new WsDependencyHysCmdBuilder<Ttest>(serviceName, "getEntity")
            .path("/sample/{0}", uid)
            .get(Ttest.class);
    }

    public GenericWsDependencyHystrixCommand<String> createEntity(final Ttest payload) {
        return new WsDependencyHysCmdBuilder<String>(serviceName, "createEntity")
            .path("/sample")
            .post(String.class, payload);
    }
}
