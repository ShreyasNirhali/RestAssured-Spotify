package authmanager;

import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class TokenCreator {

	
	public static String renewToken()
	{
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("grant_type", "refresh_token");
		param.put("refresh_token", "AQAvSUIqIYysyDUv4lkIn3b9DfOR4SMCkpJIzgDKIfgMKOVW2bsFdHuEHNYGu87_sE7OPh40IajxxWbMfF0L6khJFv9J5pM99yY32W_23ANOZ2wosGWEGDjGgSQDIzS4Egw");
		param.put("client_id", "cec8502078c54f57814bc252a40ef836");
		param.put("client_secret", "d44d3d65979f48268b2f0f11ba802f9a");
		
		RestAssured.baseURI = "https://accounts.spotify.com";
		     Response response = given()
		        .contentType(ContentType.URLENC)
		        .formParams(param)
		        .when()
		        .post("/api/token")
		        .then()
		        .extract()
		        .response();
		     
		     if(response.statusCode()!=200)
		     {
		    	 throw new RuntimeException("Failed to create the access token");
		     }
		     String token = response.path("access_token");
		     
		     return token;
		         
	}
}
