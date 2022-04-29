package com.upwork.integrationplatform;


import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.odesk.agora.commons.test.rules.EmbeddedServiceRule;
import com.odesk.agora.commons.test.rules.InjectServiceMembersRule;
import com.github.restdriver.clientdriver.ClientDriverRule;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.HttpHeaders;
import java.util.regex.Pattern;

import static com.github.restdriver.clientdriver.RestClientDriver.giveResponse;
import static com.github.restdriver.clientdriver.RestClientDriver.onRequestTo;
import static org.junit.Assert.assertEquals;

import com.upwork.integrationplatform.thrift.Ttest;
import org.apache.commons.io.IOUtils;
import org.junit.*;


public class DSIT {

    private static String DIRECTORY_RESPONSE;

    @Inject
    @Named("default")
    private WebTarget webTarget;

    @ClassRule
    public static final EmbeddedServiceRule embeddedServiceRule = new EmbeddedServiceRule(new DSService());

    @Rule
    public final InjectServiceMembersRule injectServiceMembersRule = new InjectServiceMembersRule(this);

    @Rule
    public final ClientDriverRule directoryDS = new ClientDriverRule(8064);

    @BeforeClass
    public static void beforeClass() throws Exception {
        DIRECTORY_RESPONSE = IOUtils.toString(DSIT.class.getResourceAsStream("directoryDS_response.json"));
    }

    @Before
    public void before() throws Exception {
        directoryDS.addExpectation(
                onRequestTo(Pattern.compile("/persons/nid/.+")).withAnyParams(),
                giveResponse(DIRECTORY_RESPONSE, "application/json").withStatus(200)).anyTimes();
    }

    @Test
    public void ping() {
        final Response response = webTarget.path("/_ping").request().get();
        assertEquals(200, response.getStatus());
    }

    @Test
    public void sampleRequest() throws Exception {
        final Response response = webTarget.path("sample/440823918595309568").request().get();
        assertEquals(200, response.getStatus());
    }
}
