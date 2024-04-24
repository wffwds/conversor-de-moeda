


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, ParseException {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/" +
                        "v6/edc0d4fb5707b6f645b87abb/latest/USD"))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());


        System.out.println(response.body());

        int opcao;
        double valor;
        Scanner l = new Scanner(System.in);

        do {
            Menu.menu();
            opcao = l.nextInt();

            switch (opcao) {
                case 1:
                    Menu.DolarPesoArgentin();
                    //System.out.println("Digite um valor: ");
                    //valor = l.nextDouble();

                    System.out.println();
                    break;

                case 2:
                    Menu.PesoArgentinoDolar();
                    break;

                case 3:
                    Menu.DolarRealBrasleiro();
                    break;

                case 4:
                    Menu.RealBrasleiroDolar();
                    break;

                case 5:
                    Menu.DolarPesoclombiano();
                    break;

                case 6:
                    Menu.PesoColombianoDolar();
                    break;

                case 7:
                    Menu.Sair();
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 7);

    }
}