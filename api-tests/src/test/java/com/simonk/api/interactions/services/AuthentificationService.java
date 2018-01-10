package com.simonk.api.interactions.services;

import com.simonk.api.interactions.dto.Authentification;
import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

public class AuthentificationService extends AbstractBaseService {

	public AuthentificationService(String base) {
		super(base);
	}

	private final String apiEndpoint = getBaseUrl() + "auth/";

    public Response postAuth(Authentification payload){
        return given().spec(getSpec())
                .body(payload)
                .when()
                .post(apiEndpoint);
    }
}
