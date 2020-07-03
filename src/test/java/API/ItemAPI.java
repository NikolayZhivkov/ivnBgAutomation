package API;

import io.restassured.response.Response;
import pojo.Item;

public class ItemAPI extends RestClient {

    private static final String RESOURCE_URI = "/item";
    private static final String BUL_RESOURCE_URI = "/items";

    public Response createItem(Item item){
        return post(RESOURCE_URI,GSON.toJson(item));
    }

    public Response getAllItems(){
        return get(BUL_RESOURCE_URI);
    }

    public Response getItem(String id){
        return get(RESOURCE_URI,id);
    }

    public Response deleteItem(String id){
        return delete(RESOURCE_URI,id);
    }
}
