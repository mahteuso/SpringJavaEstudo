package com.mateus.screenmatch.service;

import java.util.Scanner;

public class EscolheSerie {

    public static String escolheSerie() {

        String busca = "";
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Coloque o nome de uma série: ");
            String escolha = "";
            escolha += scan.nextLine();
            busca = escolha.replaceAll(" ", "+");
            busca = busca + "&";
            System.out.println("Se quiser escolha uma temporada de 1 a 5 ou caso queira terminar a busca digite sair: ");
            escolha = scan.nextLine();
            if (!escolha.isEmpty()) {
                escolha = escolha.toLowerCase().replaceAll(" ", "");
                if (escolha.equals("sair")) {
                    break;
                }
                busca += "season=" + escolha + "&";
                System.out.println("Se quiser escolha um episódio de 1 a 15 ou caso queira terminar a busca digite sair: ");
                escolha = scan.nextLine();
                if (!escolha.isEmpty()) {
                    escolha = escolha.toLowerCase().replaceAll(" ", "");
                    if (escolha.equals("sair")) {
                        break;
                    }
                    busca += "episode=" + escolha + "&";
                }
                return busca;
            }
        }
        return busca;
    }
}
