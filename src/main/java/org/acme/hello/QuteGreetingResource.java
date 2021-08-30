package org.acme.hello;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.UserAgent;
import io.quarkus.qute.TemplateInstance;
import io.quarkus.qute.Template;

@Path("/")
@Produces(MediaType.TEXT_HTML)
public class QuteGreetingResource {

    @Inject
    Template greeting;

    @GET
    public TemplateInstance get(@HeaderParam("User-Agent") String userAgent) {
        UserAgent parsed = UserAgent.parseUserAgentString(userAgent);
        return greeting.data("subject",  (parsed.getBrowser() != Browser.UNKNOWN ? parsed.getBrowser().getName(): userAgent));
    }

}