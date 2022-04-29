package com.upwork.integrationplatform;

import com.google.common.collect.Sets;
import com.odesk.agora.shiro.BasicAuthorizationInfo;
import com.odesk.agora.shiro.IUserPermissionsProvider;
import com.odesk.agora.shiro.UserPrincipal;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.DomainPermission;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PermissionsProvider implements  IUserPermissionsProvider{

    private static final Logger LOGGER = LoggerFactory.getLogger(PermissionsProvider.class);

    @Override
    public BasicAuthorizationInfo getBasicAuthorizationInfo(final UserPrincipal principal, final Permission permission) {
        LOGGER.debug("Started getBasicAuthorizationInfo(principal={}, permission={})", principal, permission);

        final BasicAuthorizationInfo authorizationInfo = new BasicAuthorizationInfo();
        authorizationInfo.setPermissions(Sets.newHashSet(new DomainPermission("read", "authzKey")));

        LOGGER.debug("Done getBasicAuthorizationInfo(principal={}, permission={}); authorizationInfo.getPermissions={}", principal, permission, authorizationInfo.getPermissions());
        return authorizationInfo;
    }

}