package API;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestClient {

    private static final String BASE_URI = "https://nzhivkov.inv.bg/login";
    private static final String BASE_PATH = "/RESTapi";
    private static final String RESOURCE = "settings/bankaccounts";
   protected final Gson GSON  = new GsonBuilder().setPrettyPrinting().create();


    static {
        RestAssured.baseURI = BASE_URI;
        RestAssured.basePath = BASE_PATH;
        RestAssured.authentication = RestAssured.preemptive().basic("nizhivkov@gmail.com","123456");
    }

    protected Response post(String url, String body){
        Response response = RestAssured
                .given()
                .log().all()
                .body(body)
                .when()
                .post(url);
        response.prettyPrint();
        return response;

    }

    protected Response get(String url,String id){
        Response response = RestAssured
                .given()
                .log().all()
                .when()
                .get(url + "/" + id);
        response.prettyPrint();
        return response;

    }

    protected Response get(String url) {
        Response response = RestAssured
                .given()
                .log().all()
                .when()
                .get(url);
        response.prettyPrint();
        return response;
    }



    protected Response delete(String url,String id){
        Response response = RestAssured
                .given()
                .log().all()
                .when()
                .get(url + "/" + id);
        response.prettyPrint();
        return response;

    }
}
