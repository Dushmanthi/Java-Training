package com.example.chatapp.connection;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Client
{

    private static String ip = "localhost", name = "dushi", port = "9000";
    private static boolean isConnected=false;

    static {
        javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(
                new javax.net.ssl.HostnameVerifier() {

                    public boolean verify(String hostname,
                                          javax.net.ssl.SSLSession sslSession) {
                        if (hostname.equals("127.0.0.1")) {
                            return true;
                        }
                        return false;
                    }
                });
    }


    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        System.out.println("please use 'connect ip:port as name' format");
        String command = scanner.nextLine();
        Pattern regex = Pattern.compile("^connect " +
                "(?<ip>((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?))" +
                ":(?<port>\\d{4})" +
                " as " +
                "(?<name>\\w*)$");
        Matcher matches = regex.matcher(command);

        if (matches.find()) {
            ip = matches.group("ip");
            name = matches.group("name");
            port = matches.group("port");

            System.out.println("successfully connected using: " + ip +" ip address in:  "+ port+ " port as: "+name);

            System.setProperty("javax.net.ssl.trustStore", "src/testkey.jks");
            System.setProperty("javax.net.ssl.trustStorePassword", "password");

            String httpsURL = "https://" + ip + ":" + port + "/register?name=" + name;
            URL url = new URL(httpsURL);
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();

            InputStream inputStream = httpsURLConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String inputLine;
            while ((inputLine = bufferedReader.readLine()) != null) {
                System.out.println(inputLine);
            }
            bufferedReader.close();

            new Thread(() -> {
                Scanner send = new Scanner(System.in);
                System.out.println("Now you can Send messages please use 'send hi->shani' format");
                while (true) {
                    System.out.print(":");
                    String sendToServer = send.nextLine();

                    if (sendToServer.equals("list")) {
                        getList();
                    }

                    if (Pattern.matches("send (?<msg>.*)->(?<name>.*)", sendToServer)) {
                        sendToServer(sendToServer);
                    }

//                    if (sendToServer.equals("inbox")) {
//                        checkInbox();
//                    }
                }
            }).start();


            new Thread(() -> {
                while (true) {

                    try {
                        Thread.sleep(15000);
                        String httpsURL1 = "https://127.0.0.1:9000/inbox?name=" + name;
                        URL url1 = new URL(httpsURL1);
                        HttpsURLConnection httpsURLConnection1 = (HttpsURLConnection) url1.openConnection();

                        InputStream inputStream1 = httpsURLConnection1.getInputStream();
                        InputStreamReader inputStreamReader1 = new InputStreamReader(inputStream1);
                        BufferedReader bufferedReader1 = new BufferedReader(inputStreamReader1);
                        String inputLine1;
                        while ((inputLine1 = bufferedReader1.readLine()) != null) {
                            if (!inputLine1.equals("No_messages"))
                                System.out.println(inputLine1);
                        }
                        bufferedReader1.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        } else {
            System.out.println("Wrong Command !");
        }
    }

    private static void sendToServer(String sendToServer) {
        try {
            System.out.println("send message");
            System.out.println(sendToServer);

            Matcher matcher = Pattern.compile("send (?<message>.*)->(?<name>.*)").matcher(sendToServer);
            if (matcher.find()) {
                System.out.println("message: " + matcher.group("message"));
                System.out.println("receiver name: " + matcher.group("name"));
                String message = matcher.group("message");
                String receiver = matcher.group("name");
                String sender = name;
                System.out.println("sender :" + name);

                String httpsURL1 = "https://127.0.0.1:9000/send?message=" + message + "&receiver=" + receiver + "&sender=" + sender;
                URL url = new URL(httpsURL1);
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();

                InputStream inputStream = httpsURLConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String inputLine;
                while ((inputLine = bufferedReader.readLine()) != null) {
                    System.out.println(inputLine);
                }
                bufferedReader.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void getList() {
        try {
            System.out.println(".....Client list.....");
            String httpsURL1 = "https://127.0.0.1:9000/list?name=" + name;
            URL url = new URL(httpsURL1);
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();

            InputStream inputStream = httpsURLConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String inputLine;
            while ((inputLine = bufferedReader.readLine()) != null) {
                System.out.println(inputLine);
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void checkInbox() {
        try {
            String httpsURL1 = "https://127.0.0.1:9000/inbox?name=" + name;
            URL url = new URL(httpsURL1);
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();

            InputStream inputStream = httpsURLConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String inputLine;
            while ((inputLine = bufferedReader.readLine()) != null) {
                if (!inputLine.equals("no")) {
                    System.out.println(inputLine);
                } else {
                    System.out.println("NO messages !");
                }
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void disconnect() {
        try {
            String httpsURL1 = "https://127.0.0.1:9000/disconnect?name=" + name;
            URL url = new URL(httpsURL1);
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
            InputStream inputStream = httpsURLConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String inputLine;
            while ((inputLine = bufferedReader.readLine()) != null) {
                if (!inputLine.equals("Disconnected")) {
                    System.out.println(inputLine);
                    isConnected = false;
                    name = null;
                } else {
                    System.out.println("Still connected !");
                }
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


