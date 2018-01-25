package rest;

import java.awt.List;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

import com.google.gson.Gson;
import com.google.gson.*;

@Path("/")
public class Respondent {
	public static final String IN_TROLLEY="in_trolley";
	
	@Context 
	private HttpServletRequest request;
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
			object.addProperty("product_id", "name"+i);
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
	
	@POST
	@Path("addToTrolley")
	public String addToTrolley(
			@QueryParam("product_id") int id) {
		addToSession(id);
		return "OK 200";
		
	}
	
	private void addToSession(int id) {
		HttpSession session=request.getSession();
		Object obj=session.getAttribute(IN_TROLLEY);
		if(obj==null)
			session.setAttribute(IN_TROLLEY, new ArrayList<Integer>());
		ArrayList<Integer> list=(ArrayList<Integer>)obj;
		list.add(id);
	}
	
	@GET
	@Path("getTrolley")
	public String getInTrolley()
	{
		JsonObject jsonObject=null;
		ArrayList<Integer> list=getIdsInTrolley();
		JsonArray array=new JsonArray();
		for(int i:list) {
			jsonObject=getProductAsJSON(i);
			array.add(jsonObject);
		}
		return array.toString();		
	}
	
	private ArrayList<Integer> getIdsInTrolley(){
		HttpSession session=request.getSession();
		Object inTrolley=session.getAttribute(IN_TROLLEY);
		ArrayList<Integer> list=null;
		if(inTrolley!=null) {
			list=(ArrayList<Integer>)inTrolley;
		}
		return list;
	}
	
	private JsonObject getProductAsJSON(int id) {
		JsonObject object=new JsonObject();
		//tutaj dodac obieranie z bazy przedmiotu o takim id
		object.addProperty("product_id", id);
		object.addProperty("product_description", "Najlepszy przedmiocik");
		object.addProperty("product_price", "30z³");
		return object;
	}
	
}
