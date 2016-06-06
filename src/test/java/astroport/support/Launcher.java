package astroport.support;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Launcher {

    private static HttpServer server;
    public static int port = 8080;

    public static void startAppServer() throws IOException {
        server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext( "/astroport-creation", exchange -> {
            exchange.getResponseHeaders().set("Content-Type", "text/html");
            String body = "<html>" +
                    "<head>" +
                    "   <title>Create new astroport</title>" +
                    "   <style>" +
                    "       .form { display:flex }" +
                    "       @media(max-width:320px) { " +
                    "           .form { flex-direction: column } " +
                    "           input { width:100px; height:20px } " +
                    "       }" +
                    "       @media(min-width:321px) { " +
                    "           input { width:150px; height:25px } " +
                    "       }" +
                    "   </style>" +
                    "</head>" +
                    "<body>" +
                    "   <section class=\"form\">" +
                    "       <label id=\"astroport-creation-invitation\">New astroport</label>" +
                    "       <input id=\"astroport-name\"/>" +
                    "   </section>" +
                    "</body>" +
                    "</html>";
            exchange.sendResponseHeaders( 200, body.length() );
            exchange.getResponseBody().write( body.getBytes() );
            exchange.close();
        } );
        server.start();
    }

    public static void stopServerAndCloseBrowser() {
        server.stop( 0 );
        AppDriver.close();
    }

    public static void main(String... argv) throws Exception {
        Launcher.port = 5000;
        startAppServer();
    }
}
