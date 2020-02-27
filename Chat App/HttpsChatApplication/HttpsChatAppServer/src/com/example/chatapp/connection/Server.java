package com.example.chatapp.connection;

import java.io.*;
import java.net.*;
import java.util.*;
import java.net.InetSocketAddress;
import java.lang.*;
import com.sun.net.httpserver.HttpsServer;
import java.security.KeyStore;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManagerFactory;
import com.sun.net.httpserver.*;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpsExchange;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Server {

    private static HashMap<String, ArrayList> clients = new HashMap<>();

    public static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange httpExchange) throws IOException {
            String response = "welcome! you got the response.";
            HttpsExchange httpsExchange = (HttpsExchange) httpExchange;
            httpExchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
            httpExchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream outputStream = httpExchange.getResponseBody();
            outputStream.write(response.getBytes());
            outputStream.close();
        }
    }

    public static void main(String[] args) throws Exception {

        try {

            InetSocketAddress address = new InetSocketAddress(9000);
            HttpsServer httpsServer = HttpsServer.create(address, 0);
            SSLContext sslContext = SSLContext.getInstance("TLS");


            char[] password = "password".toCharArray();
            KeyStore ks = KeyStore.getInstance("JKS");
            FileInputStream fileInputStream = new FileInputStream("src/testkey.jks");
            ks.load(fileInputStream, password);


            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
            keyManagerFactory.init(ks, password);

            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("SunX509");
            trustManagerFactory.init(ks);

            sslContext.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), null);
            httpsServer.setHttpsConfigurator(new HttpsConfigurator(sslContext) {
                public void configure(HttpsParameters httpsParameters) {
                    try {
                        SSLContext context = getSSLContext();
                        SSLEngine engine = context.createSSLEngine();
                        httpsParameters.setNeedClientAuth(false);
                        httpsParameters.setCipherSuites(engine.getEnabledCipherSuites());
                        httpsParameters.setProtocols(engine.getEnabledProtocols());

                        SSLParameters sslParameters = context.getSupportedSSLParameters();
                        httpsParameters.setSSLParameters(sslParameters);
                        System.out.println("HTTPS port created successfully");

                    } catch (Exception ex) {
                        System.out.println("Failed to create HTTPS port");
                    }
                }
            });
            httpsServer.createContext("/test", new MyHandler());
            httpsServer.createContext("/register", new registerClient());
            httpsServer.createContext("/send", new sendMessages());
            httpsServer.createContext("/inbox", new getMyMessage());
            httpsServer.createContext("/list", new listofClient());
            httpsServer.createContext("/disconnect", new disconnect());
            httpsServer.setExecutor(null);
            httpsServer.start();
            System.out.println("server started ");

        } catch (Exception exception) {
            System.out.println("Failed to create HTTPS server on port " + 9000 + " of localhost");
            exception.printStackTrace();

        }
    }/*
		// load certificate
String keystoreFilename = getPath() + "testkey.jks";
char[] storepass = "password".toCharArray();
char[] keypass = "password".toCharArray();
String alias = "alias";
FileInputStream fIn = new FileInputStream(keystoreFilename);
KeyStore keystore = KeyStore.getInstance("JKS");
keystore.load(fIn, storepass);
// display certificate
Certificate cert = keystore.getCertificate(alias);
System.out.println(cert);
// setup the key manager factory
KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
kmf.init(keystore, keypass);
// setup the trust manager factory
TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
tmf.init(keystore);

// create https server
server = HttpsServer.create(new InetSocketAddress(port), 0);
// create ssl context
SSLContext sslContext = SSLContext.getInstance(protocol);
// setup the HTTPS context and parameters
sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);
server.setHttpsConfigurator(new HttpsConfigurator(sslContext) {
         public void configure(HttpsParameters params) {
                 try {
                          // initialise the SSL context
                          SSLContext c = SSLContext.getDefault();
                          SSLEngine engine = c.createSSLEngine();
                          params.setNeedClientAuth(false);
                          params.setCipherSuites(engine.getEnabledCipherSuites());
                          params.setProtocols(engine.getEnabledProtocols());
                          // get the default parameters
                          SSLParameters defaultSSLParameters = c.getDefaultSSLParameters();
                          params.setSSLParameters(defaultSSLParameters);
                 } catch (Exception ex) {
                          ex.printStackTrace();
                          System.out.println("Failed to create HTTPS server");
                 }
         }
});*/

    public static class registerClient implements HttpHandler {
        @Override
        public void handle(HttpExchange httpExchange) throws IOException {
            Map<String, Object> parameters = new HashMap<>();
            URI uri = httpExchange.getRequestURI();
            String query = uri.getRawQuery();

            String client = query.substring(query.indexOf("=") + 1, query.length());
            System.out.println(client);

            String response = "You are registered successfully!";

            if (clients.keySet().stream().anyMatch(client::equals)) {
                System.out.println("client Already Present !");
                response = "client Already Present !";
            } else {
                clients.put(client, new ArrayList());
            }

            System.out.println(clients);

            httpExchange.sendResponseHeaders(200, response.length());
            OutputStream outputStream = httpExchange.getResponseBody();
            outputStream.write(response.toString().getBytes());

            outputStream.close();
        }
    }


    public static class listofClient implements HttpHandler {
        @Override
        public void handle(HttpExchange httpExchange) throws IOException {
            // parse request
            Map<String, Object> parameters = new HashMap<String, Object>();
            URI uri = httpExchange.getRequestURI();
            String query = uri.getRawQuery();

            String client = query.substring(query.indexOf("=") + 1, query.length());
            System.out.println(client);

            String response = "";

            for (String name : clients.keySet()) {
                if (client.equals(name)) {
                    response += client + "(You)"+"\n";
                } else {
                    response += name + "\n";
                }
            }

            System.out.println(clients + "Sended");

            httpExchange.sendResponseHeaders(200, response.length());
            OutputStream outputStream = httpExchange.getResponseBody();
            outputStream.write(response.toString().getBytes());

            outputStream.close();
        }
    }

    public static class getMyMessage implements HttpHandler {
        @Override
        public void handle(HttpExchange httpExchange) throws IOException {
            try {

                Map<String, Object> parameters = new HashMap<String, Object>();
                URI uri = httpExchange.getRequestURI();
                String query = uri.getRawQuery();

                String client = query.substring(query.indexOf("=") + 1, query.length());
                System.out.println(client);

                String response = "No_messages";
                if (clients.get(client).size() > 1) {
                    for (String name : clients.keySet()) {
                        if (client.equals(name)) {
                            response = (String) clients.get(name).get(1);
                            clients.get(name).set(1, "");
                        }
                    }
                }

                System.out.println(clients + "Sended");

                httpExchange.sendResponseHeaders(200, response.length());
                OutputStream outputStream = httpExchange.getResponseBody();
                outputStream.write(response.toString().getBytes());

                outputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static class sendMessages implements HttpHandler {
        @Override
        public void handle(HttpExchange httpExchange) throws IOException {

            Map<String, Object> parameters = new HashMap<String, Object>();
            URI requestedUri = httpExchange.getRequestURI();
            String query = requestedUri.getRawQuery();

            System.out.println(parameters);
            try {
                Matcher matcher= Pattern.compile("message=(?<message>\\w*)&receiver=(?<receiver>\\w*)&sender=(?<sender>\\w*)").matcher(query);
                if (matcher.find()) {
                    System.out.println("message: " + matcher.group("message"));
                    System.out.println("receiver name: " + matcher.group("receiver"));
                    System.out.println("sender name: " + matcher.group("sender"));

                    String message = matcher.group("message");
                    String receiver = matcher.group("receiver");
                    String sender = matcher.group("sender");

                    clients.keySet().forEach(name -> {
                        if (receiver.equals(name)) {
                            clients.get(name).add(0, new ArrayList<String>());
                            clients.get(name).add(1, sender + "->" + message);
                        }
                    });

                    System.out.println(clients.values());

                    String response = "messeges sent to: " + receiver;

                    httpExchange.sendResponseHeaders(200, response.length());
                    OutputStream outputStream = httpExchange.getResponseBody();
                    outputStream.write(response.toString().getBytes());

                    outputStream.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }

    public static class disconnect implements HttpHandler {
        @Override
        public void handle(HttpExchange httpExchange) throws IOException {

            Map<String, Object> parameters = new HashMap<String, Object>();
            URI requestedUri = httpExchange.getRequestURI();
            String query = requestedUri.getRawQuery();
            System.out.println(parameters);
            try {
                String client = query.substring(query.indexOf("=") +1, query.length());
                System.out.println(client);
                clients.remove(client);

                String response = "Disconnected";
                response = "Disconnected";

                httpExchange.sendResponseHeaders(200, response.length());
                OutputStream outputStream = httpExchange.getResponseBody();
                outputStream.write(response.toString().getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                httpExchange.close();
            }


        }

    }

}