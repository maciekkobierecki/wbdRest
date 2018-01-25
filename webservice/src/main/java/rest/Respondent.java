package rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.google.gson.Gson;
import com.google.gson.*;

@Path("/")
public class Respondent {

	@GET
	@Path("get")
	@Produces("text/html")
	public String get() {
		return "noelo";
	}
	
	@GET
	@Path("getProducts")
	public String getProducts(@QueryParam("category") String category) {
		Gson gson=new Gson();
		
		JsonArray array=new JsonArray();
		
		
		//dodawanie czegokolwiek
		for(int i=0; i<10; i++) {
			JsonObject object=new JsonObject();
			object.addProperty("product_name", "name"+i);
			object.addProperty("product_description", "Najlepszy przedmiocik");
			object.addProperty("product_price", "30z³");
			array.add(object);
		}
		
		return array.toString();
	}
	
	@GET
	@Path("getCategories")
	public String getCategories() {
		JsonArray array=new JsonArray();
		
		for(int i=0; i<10; i++) {
			JsonObject object=new JsonObject();
			object.addProperty("category_name", "name"+i);
			object.addProperty("category_count", 30+i);
			array.add(object);
		}
		return array.toString();	
	}
}
