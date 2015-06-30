package org.sayem.api.spotify;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

/**
 * Created by syed.sayem on 6/29/15.
 */
public class Album {

    @Test
    public void getAlbum(){

        RestAssured.baseURI = "https://api.spotify.com/v1";

        JsonPath response = given()
                .contentType("application/json")
                .pathParam("id", "0CZUbYCniBFqvgfTiaWPoz")
                .expect()
                .statusCode(200)

                .when()
                .get("/albums/{id}").jsonPath();

        String winnerIds = response.getString("artists.name");
        System.out.println(winnerIds);

    }
}
