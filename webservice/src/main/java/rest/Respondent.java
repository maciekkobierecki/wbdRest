package rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/")
public class Respondent {

	@GET
	@Path("get")
	@Produces("text/html")
	public String get() {
		return "noelo";
	}
}
