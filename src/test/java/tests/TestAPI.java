package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Map;

public class TestAPI extends BaseLibrary{

    @Test(priority = 1)
    public void VerifyListUsers() throws Exception {
        int userCount = getTotalUserCount();
        Assert.assertEquals(userCount,12,"The response body isn't correct");

    }

    @Test(priority = 2)
    public void VerifyCreationUsers() throws Exception {
        for(Map.Entry user : getUserData().entrySet()){
            Map data = (Map)(user.getValue());
            createUsers((String) data.get("name"),(String) data.get("job"));
            System.out.println();
        }
    }

    @Test
    public void VerifyDeleteUsers() throws Exception {
        String id = getExistingUserIds().get(1);
        deleteUser(id);
    }
}
