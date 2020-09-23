package tests;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import core.*;
import datamodel.CreateUser;
import io.restassured.response.Response;
import org.junit.Assert;
import org.testng.annotations.BeforeTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseLibrary {

    private RestSession session;
    private static HashMap<String,Map> userData;


    @BeforeTest
    public void initTest() throws Exception {
        Environments.load();
        userData =  Data.getData();
    }

    public void createUsers(String name, String job) throws Exception {
        session = new RestSession();
        Response resp = session.sendRequest(APIMethods.POST_API_REQRES, getUserBody(name,job));
        Assert.assertEquals(resp.getStatusCode(),201);
    }

    public HashMap<String, Map> getUserData(){
        return userData;
    }

    public int getTotalUserCount() throws Exception {
        session = new RestSession();
        Response resp = session.sendRequest(APIMethods.GET_API_REQRES);
        Assert.assertEquals(resp.getStatusCode(),200);
        String allResponse = resp.getBody().asString();
        String[] partsOfAllResponse = allResponse.split(",");
        String fieldTotal = partsOfAllResponse[2];
        String checkNumberFromResponse = fieldTotal.substring(8, 10);
        return Integer.parseInt(checkNumberFromResponse);
    }

    public List<String> getExistingUserIds() throws Exception {
        List<String> ids = new ArrayList<>();
        session = new RestSession();
        Response resp = session.sendRequest(APIMethods.GET_API_REQRES);
        Assert.assertEquals(resp.getStatusCode(),200);
        JsonObject jsonObject = JsonParser.parseString(resp.asString()).getAsJsonObject();
        JsonArray data = jsonObject.getAsJsonArray("data");
        for(JsonElement obj : data){
            ids.add(obj.getAsJsonObject().get("id").toString());
        }
        return ids;
    }


    private CreateUser getUserBody(String name, String job) {
            CreateUser user = new CreateUser();
            user.setName(name);
            user.setJob(job);
         return user;
    }

    public void deleteUser(String id) throws Exception {
        APIMethods.DELETE_API_REQRES.addMethodParam((String) id);
        session = new RestSession();
        Response resp = session.sendRequest(APIMethods.DELETE_API_REQRES);
        org.testng.Assert.assertEquals(resp.getStatusCode(),204);
    }
}
