package core;

public class APIMethods {

    public static APIMethod GET_API_REQRES = new APIMethod(Environments.reqresEndPoint(), "api/users?page=2", HttpMethod.GET);
    public static APIMethod POST_API_REQRES = new APIMethod(Environments.reqresEndPoint(), "api/users", HttpMethod.POST);
    public static APIMethod DELETE_API_REQRES = new APIMethod(Environments.reqresEndPoint(), "api/users/@@param", HttpMethod.DELETE);
}
