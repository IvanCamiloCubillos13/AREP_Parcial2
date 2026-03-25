package edu.eci.proxy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ProxyService {

    private final String ACTIVE = System.getenv("SERVICE_ACTIVE");
    private final String PASSIVE = System.getenv("SERVICE_PASSIVE");

    public String forwardRequest(String value) {

        String endpoint = "/math?value=" + value;

        try {
            System.out.println("Calling ACTIVE service");
            return callService(ACTIVE + endpoint);
        } catch (Exception e) {

            System.out.println("Active failed. Switching to PASSIVE");

            try {
                return callService(PASSIVE + endpoint);
            } catch (Exception ex) {
                return "Both services unavailable";
            }
        }
    }

    private String callService(String urlStr) throws Exception {

        URL url = new URL(urlStr);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("GET");

        int responseCode = con.getResponseCode();

        if (responseCode != 200) {
            throw new RuntimeException("Service error");
        }

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));

        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }

        in.close();

        return response.toString();
    }
}