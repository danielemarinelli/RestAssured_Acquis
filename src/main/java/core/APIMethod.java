package core;

import java.util.HashMap;

public class APIMethod {

    private String hostUrl;
    private String methodName;
    private HttpMethod httpMethod;
    private HashMap<String, String> params = new HashMap();
    private ParametersType reqParamType = ParametersType.JSON;
    private String methodUrlWithParam;

    public APIMethod(String hostUrl, String methodName, HttpMethod httpMethod) {
        if (methodName.contains("@@param")) {
                      this.methodUrlWithParam = methodName;
                  }else{
                      this.methodName = methodName;
                  }
            this.methodName = methodName;
            this.httpMethod = httpMethod;
            this.hostUrl = hostUrl;
        }

        public void addMethodParam(String param){
            if (this.methodUrlWithParam.contains("@@param")) {
                this.methodName = this.methodUrlWithParam;
                this.methodName = this.methodName.replaceFirst("@@param", param);
            }
        }


        public String getRestMethodPath() {
            return methodName;
        }


        public String getHostUrl() {
            return hostUrl;
        }


        public HttpMethod getRestHttpMethodType() {
            return httpMethod;
        }


        public ParametersType getRestParametersType() {
            return reqParamType;
        }

}
