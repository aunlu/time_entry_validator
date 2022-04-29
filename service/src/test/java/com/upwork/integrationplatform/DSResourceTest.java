package com.upwork.integrationplatform;

import com.odesk.agora.commons.test.ResourceTest;
import com.upwork.integrationplatform.thrift.Ttest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class DSResourceTest extends ResourceTest {
    private static final String THRIFT_TYPE = "application/x-thrift+json";

    @InjectMocks
    private DSResource resource;

    @Override
    protected void setUpResources() throws Exception {
        addResource(resource);
    }

    @Test
    public void getSample() {
        final Response response = target().path("/sample/440823918595309568").request().get();
        assertEquals(200, response.getStatus());
        assertEquals(new Ttest(), response.readEntity(Ttest.class));
    }

    @Test
    public void postSample() {
        final Response response = target().path("/sample").request().post(Entity.entity(new Ttest(), THRIFT_TYPE));
        assertEquals(200, response.getStatus());
        assertEquals("uidOfNewlyCreatedEntity", response.readEntity(String.class));
    }
}
