package core;

import static core.Config.ENV;

public class Environments {

    private static String reqresEndPoint;

    public static void load() {
        if (ENV.equalsIgnoreCase("DEV")) {
            reqresEndPoint = "https://reqres.in";
        }

        if (ENV.equalsIgnoreCase("INT")) {
            reqresEndPoint = "https://reqres.in";
        }

        if (ENV.equalsIgnoreCase("PREPROD")) {
            reqresEndPoint = "https://reqres.in";
        }

        if (ENV.equalsIgnoreCase("PROD")) {
            reqresEndPoint = "https://reqres.in";
        }
    }

    public static String reqresEndPoint() {
        return reqresEndPoint;
    }


}
