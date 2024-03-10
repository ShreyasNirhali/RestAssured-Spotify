package com.spotify.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilders {
	
	public static RequestSpecification reqSpec()
	{
	return new RequestSpecBuilder()
			
	.setBaseUri("https://api.spotify.com")
	.setBasePath("/v1") .setContentType(ContentType.JSON)
	//.addHeader("Authorization", "Bearer BQAG9MudbNacst0l6XgWyOm5ueOKGSmCKJQESnOBFb69TtQmWdRqh_n1J1m4-dINF0pjkKkwcJ-QE2bn5a_0OvQuyJ0-a6pQgEsgSPCK-nNyXAYza8fKqMjLwGdlqrbdfMv9o5D5XMu_YODZoy3Ytq8zmZRv2-l9MXRDfJWECarsDaO48NeTA74GDs63dQ4GHCfDtq36QRCMLvJ_ZZsmyOGXKVguO771uwQX_GZnVDbJQn2XKaxiz0s8jQSxCwTwkfkaW8cZIoKjyQ7j")
	.log(LogDetail.ALL)
	.build();
	}
	

	public static ResponseSpecification resSpec()
	{
	return new ResponseSpecBuilder()
			
	.expectContentType(ContentType.JSON)
	.log(LogDetail.ALL)
	.build();
	}

	
}
