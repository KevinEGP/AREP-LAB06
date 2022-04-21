package co.edu.eci;

import static spark.Spark.*;
import java.io.*;  
import java.net.*;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public class LoginService {
    
    public static void main( String[] args ) {
        port(getPort());
        staticFiles.location("/public");
        get("/", "text/html", (req, res) -> {
            res.redirect("index.html");            
            return null;
        });
        
        get("/login", (req, res) -> {
            try {
                HttpResponse<String> response = Unirest.get("127.0.0.1" + "/login").header("accept", "application/json").asString();
                return response.getBody();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        });

    }

    public static int getPort() {
        if (System.getenv("PORT") != null) {
        return Integer.parseInt(System.getenv("PORT"));
        }
        return 8080;
    }
}