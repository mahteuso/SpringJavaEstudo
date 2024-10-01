package com.mateus.screenmatch.princicpal;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class GoogleBooks {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner read = new Scanner(System.in);
        System.out.println("Digite uma palavra em inglês");

        var conselho = read.nextLine();

        String url = "https://api.adviceslip.com/advice/search/" + conselho;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }

}
