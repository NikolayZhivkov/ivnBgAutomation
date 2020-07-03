package API;

import io.restassured.response.Response;
import pojo.BankAccount;

public class BankAccountAPI extends RestClient {

    private static final String RESOURCE_URI = "settings/bankaccounts";


    /**
     * Creates bank accounts via API
     * @param bankAccount bank account pojo
     * @return response
     */

    public Response createBankAccount(BankAccount bankAccount){
       return post(RESOURCE_URI,GSON.toJson(bankAccount));


    }


}
