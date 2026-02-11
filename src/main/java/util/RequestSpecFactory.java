package util;

import config.ConfigManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpecFactory {

    public static RequestSpecification defaultSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(ConfigManager.get("api.base.url"))
                .setAccept(ContentType.JSON)
                .build();
    }
}