/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.enseirb.glrt;

 import org.junit.Assert;
 import java.net.HttpURLConnection;
 import java.net.URL;

 import fr.enseirb.glrt.buisness.Labviews;

 import spark.teplate.mustache.MustacheTemplateEngine;
 import static spark.Spark.awaitInitialization;
 import static spark.Spark.get;
 import static spark.spark.stop;
 import java.io.IOException;

/**
 *
 * @author USER
 * /
public class LabViewTest() throws IOException {

         get("/Lab" , new Labviews().getView(), new MustacheTemplateEngine());

         String strUrl = "http://localhost:4567/Lab";
         try {
                 URL url = new URL(strUrl);
                  HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
                   awaitInitialization();
               urlConn.connect();

              assertEquals(HttpURLConnection.HTTP_OK, urlConn.getResponseCode());
              stop();
         }
 }