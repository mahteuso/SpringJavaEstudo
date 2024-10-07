package com.mateus.screenmatch;

import com.mateus.screenmatch.model.DadosSeriado;
import com.mateus.screenmatch.model.DadosSeries;
import com.mateus.screenmatch.model.DadosTemporada;
import com.mateus.screenmatch.service.ConsumoApi;
import com.mateus.screenmatch.service.ConverteDados;
import com.mateus.screenmatch.service.EscolheSerie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
import java.util.stream.Collectors;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

    private final String INIT_URL = "https://www.omdbapi.com/?t=";
    private final String FINAL_URL = "apikey=31cd69a1";

    public static void main(String[] args) {
        SpringApplication.run(ScreenmatchApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        while (true) {
            String busca = EscolheSerie.escolheSerie();

            String uri = INIT_URL + busca + FINAL_URL;

            ConsumoApi consumoApi = new ConsumoApi();

            var json = consumoApi.obterDados(uri);

            System.out.println(json);

            ConverteDados dados = new ConverteDados();

            if (uri.contains("episode")) {
                DadosSeriado episodio = dados.obterDados(json, DadosSeriado.class);
                System.out.println(" ");
                System.out.println(episodio);
                System.out.println(" ");
            } else if (uri.contains("season")) {
                DadosSeriado temporada = dados.obterDados(json, DadosSeriado.class);
                System.out.println(" ");
                System.out.println("Temporada: " + temporada.temporada());
                System.out.println(temporada);
                System.out.println(" ");
                temporada.episodios().stream()
                        .map(e -> e.titulo())
                        .sorted()
                        .forEach(e -> System.out.println("Episódio: " + e));
            } else {
                System.out.println(" ");
                DadosSeries serie = dados.obterDados(json, DadosSeries.class);
                System.out.println(" ");
                System.out.println(serie);
                System.out.println(" ");
                Integer totalTemporadas = serie.totalTemporadas();
                List<List<DadosTemporada>> episodioLista = new ArrayList<>();
                List<DadosSeriado> dtList = new ArrayList<>();
                for (int i = 1; i <= totalTemporadas; i++) {
                    uri = INIT_URL + busca + "&season=" + i + "&" + FINAL_URL;
                    json = consumoApi.obterDados(uri);
                    DadosSeriado dt = dados.obterDados(json, DadosSeriado.class);
                    dtList.add(dt);
                }

                dtList.stream()
                        .map(DadosSeriado::episodios).forEach(e -> episodioLista.add(e));
                List<DadosTemporada> episodiosFinal = new ArrayList<>();
               for (List<DadosTemporada> da : episodioLista){
                   for(DadosTemporada d : da){
                       episodiosFinal.add(d);
                   }
               }


                System.out.println(" ");
                System.out.println("Total de Temporadas: ");
                System.out.println(episodiosFinal);
                System.out.println(" ");


                System.out.println("Top 10 episódios de todas as temporadas: ");
                episodiosFinal.stream()
                        .filter(e -> !e.nota().equalsIgnoreCase("N/A"))
                        .sorted(Comparator.comparing(DadosTemporada::nota).reversed())
                        .limit(5)
                        .forEach(System.out::println);


                List<DadosTemporada> amostra = new ArrayList<>();

                for (DadosTemporada dadosTemporada : episodiosFinal){
                    if (!(dadosTemporada.nota().equals("N/A"))){
                        amostra.add(dadosTemporada);
                    }
                }

                amostra = amostra.stream().sorted().collect(Collectors.toList());


            }

            System.out.println(" ");
            Scanner scan = new Scanner(System.in);
            System.out.println("Se deseja escolher outra série digite sim, caso contrário digite sair: ");
            String escolha = scan.nextLine();
            escolha = escolha.toLowerCase().replaceAll(" ", "");
            if (escolha.equals("sair")) {
                System.out.println(" ");
                System.out.println("Obrigado por acessar nosso Site!!!");
                break;
            }
        }
    }
}
