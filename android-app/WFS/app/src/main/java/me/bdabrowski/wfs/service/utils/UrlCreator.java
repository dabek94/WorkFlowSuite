package me.bdabrowski.wfs.service.utils;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlCreator {

    private static UrlCreator urlCreator;

    private static String httpProtocol = RESTConsts.HTTP;
    private static String host = RESTConsts.HOST;
    private static int port = RESTConsts.PORT;
    private static String path;

    private static URL url;
    private static String method;

    public static UrlCreator begin(){
        urlCreator = new UrlCreator();
        return urlCreator;
    }

    public UrlCreator protocol(String httpProtocol){
        urlCreator.httpProtocol = httpProtocol;
        return urlCreator;
    }

    public UrlCreator host(String host){
        urlCreator.host = host;
        return urlCreator;
    }
    public UrlCreator port(int port){
        urlCreator.port = port;
        return urlCreator;
    }
    public UrlCreator path(String path){
        urlCreator.path = path;
        return urlCreator;
    }
    public UrlCreator parameters(String...params){
        StringBuilder builder = new StringBuilder();
        builder.append(path);
        for (String parameter:
             params) {
            builder.append("/" + parameter);
        }
        path = builder.toString();

        return urlCreator;
    }

    public UrlCreator method(String method){
        urlCreator.method = method;
        return urlCreator;
    }

    public void create(){
        try {
            urlCreator.url = new URL(httpProtocol, host, port, path);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static URL getUrl(){
        //TODO NULLCHECK
        return url;
    }
    public static String getMethod(){
        //TODO NULLCHECK
        return method;
    }
}
