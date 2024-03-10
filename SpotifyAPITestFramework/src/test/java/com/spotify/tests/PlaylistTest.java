package com.spotify.tests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.spotify.api.PlayListAPI;
import com.spotify.pojo.Playlist;
import io.qameta.allure.*;
import authmanager.TokenCreator;
import io.restassured.response.Response;
import utils.ConfigReader;

@Epic("Spotify Auth 2.0")
@Feature("Playlist API")

public class PlaylistTest {

	 static String playlistidresponse;
	    @Story("Create Playlist")
		@Description("Creating a playlist for 90's songs collection")
		@Test(priority = 1)
		public void createPlayList() throws IOException
		{
			Playlist reqplaylist = new Playlist();
			
			reqplaylist.setName(ConfigReader.readConfig("name"));
			reqplaylist.setDescription(ConfigReader.readConfig("description"));
			reqplaylist.setPublic(false);
			
		    Response response = PlayListAPI.post(reqplaylist, TokenCreator.renewToken());
		    Playlist resopnseplaylist = response.as(Playlist.class);
		     
		    String namerequest = reqplaylist.getName();
		    String nameresponse = resopnseplaylist.getName();
		      playlistidresponse = resopnseplaylist.getId();
		     
		    Assert.assertEquals(namerequest, nameresponse);
		}
		
	    @Story("Create Playlist")
		@Description("Getting information for created Playlist")
		@Test(priority = 2)
		public void getAPlaylist() throws IOException
		{
	        Playlist reqplaylist = new Playlist();
			
	        reqplaylist.setName(ConfigReader.readConfig("name"));
			reqplaylist.setDescription(ConfigReader.readConfig("description"));
			reqplaylist.setPublic(false);
			
			Response response = PlayListAPI.get(playlistidresponse, TokenCreator.renewToken());
			Playlist responseplaylist = response.as(Playlist.class);
			
			Assert.assertEquals(responseplaylist.getName(), reqplaylist.getName());
			  
		}
		
		// Assignment to create the method for update playlist API - NEED TO CHECK CODE
	    @Story("Update Playlist")
		@Description("Updating a playlist for 90's songs collection")
	    @Test(priority = 3)
		public void updatePlaylist() throws IOException
		{
	         Playlist reqplaylist = new Playlist();
			
	         reqplaylist.setName(ConfigReader.readConfig("name")+"updated value");
				reqplaylist.setDescription(ConfigReader.readConfig("description"));
			reqplaylist.setPublic(false);
			
			Response response = PlayListAPI.update(playlistidresponse ,reqplaylist, TokenCreator.renewToken());
			int statuscode = response.statusCode();
			Assert.assertEquals(statuscode, 200);
		}
		
	    @Story("Create Playlist")
		@Description("Invalid Auth token for creating playlist")
		@Test(priority = 4)
		public void shouldNotBeAbleToCreatePlaylist() throws IOException
		{
	          Playlist reqplaylist = new Playlist();
			
	     	reqplaylist.setName(ConfigReader.readConfig("name"));
			reqplaylist.setDescription(ConfigReader.readConfig("description"));
			reqplaylist.setPublic(false);
			
			Response response = PlayListAPI.post(reqplaylist, "1234");
		    int stscode = response.statusCode();
		     
		    Assert.assertEquals(stscode, 401);
			
		}
		
}
