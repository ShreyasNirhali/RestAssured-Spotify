package com.spotify.api;

import static io.restassured.RestAssured.given;

import com.spotify.pojo.Playlist;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PlayListAPI {

	
	public static Response post(Playlist requestPlaylist, String token)
	{
		 return given(SpecBuilders.reqSpec())
		 //.header("Authorization", "Bearer "+token)
		 .auth().oauth2(token)
	     .body(requestPlaylist)
	     .when()
	     .post("/users/31syxkl6ll54hg3tru43l7izjur4/playlists")
	     .then()
	     .spec(SpecBuilders.resSpec())
	     .extract()
	     .response();
	}
	
	public static Response get(String playlistidresponse, String token)
	{
		 return given(SpecBuilders.reqSpec())
		 //.header("Authorization", "Bearer "+token)		
		 .auth().oauth2(token)
		 .when()
		 .get("/playlists/"+playlistidresponse)
		 .then()
		 .spec(SpecBuilders.resSpec())
		 .extract()
		 .response();	
	}
	public static Response update(String playlistidresponse, Playlist requestPlaylist, String token)
	{
		
		return given(SpecBuilders.reqSpec())
		//.header("Authorization", "Bearer "+token)				
		.auth().oauth2(token)
		.body(requestPlaylist)
        .when()
        .put("/playlists/"+playlistidresponse) 
        .then()
		.extract()
		.response();
	}
}
