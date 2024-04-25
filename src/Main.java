import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/" +
                        "v6/edc0d4fb5707b6f645b87abb/latest/USD"))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

       Map<String, String> result = convertStringToMap(response.body());

        int opcao;
        Scanner l = new Scanner(System.in);
        do {
            double valor, resultado = 0, rate;
            Menu.menu();
            opcao = l.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite um valor: ");
                    valor = l.nextDouble();
                    rate = Double.parseDouble(result.get("ARS"));
                    resultado =  rate * valor;
                    System.out.println("Valor "+valor+" [USD] corresponde ao valor final de ==> "+resultado+" ARS");
                    break;

                case 2:
                    System.out.println("Digite um valor: ");
                    valor = l.nextDouble();
                    rate = Double.parseDouble(result.get("ARS"));
                    resultado =  valor / rate;
                    System.out.println("Valor "+valor+" [ARS] corresponde ao valor final de ==> "+resultado+" [USD]");
                    break;

                case 3:
                    System.out.println("Digite um valor: ");
                    valor = l.nextDouble();
                    rate = Double.parseDouble(result.get("BRL"));
                    resultado =  rate * valor;
                    System.out.println("Valor "+valor+" [USD] corresponde ao valor final de ==> "+resultado+" [BRL]");
                    break;

                case 4:
                    System.out.println("Digite um valor: ");
                    valor = l.nextDouble();
                    rate = Double.parseDouble(result.get("BRL"));
                    resultado =  valor / rate;
                    System.out.println("Valor "+valor+" [BRL] corresponde ao valor final de ==> "+resultado+" [USD]");
                    break;

                case 5:
                    System.out.println("Digite um valor: ");
                    valor = l.nextDouble();
                    rate = Double.parseDouble(result.get("COP"));
                    resultado =  rate * valor;
                    System.out.println("Valor "+valor+" [USD] corresponde ao valor final de ==> "+resultado+" [COP]");
                    break;

                case 6:
                    System.out.println("Digite um valor: ");
                    valor = l.nextDouble();
                    rate = Double.parseDouble(result.get("COP"));
                    resultado =  valor / rate;
                    System.out.println("Valor "+valor+" [ARS] corresponde ao valor final de ==> "+resultado+" [USD]");
                    break;

                case 7:
                    Menu.Sair();
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 7);

    }

    public static Map<String, String> convertStringToMap(String data) {
        Map<String, String> map = new HashMap<>();
        StringTokenizer tokenizer = new StringTokenizer(data, " ");

        while (tokenizer.hasMoreTokens()){
            String token = tokenizer.nextToken();
            if(token.contains(":")){
                String[] keyValue = token.split(":");
                map.put(keyValue[0].replace("\"", ""),
                        keyValue[1].replace(",", ""));
            }
        }
        return map;
    }
}