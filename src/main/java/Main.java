import com.example.service.ConsumoAPI;
import com.example.service.ConverteDados;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

import static com.example.service.ConverteDados.convertStringToMap;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        String endereco = "https://v6.exchangerate-api.com/v6/edc0d4fb5707b6f645b87abb/latest/USD";
        ConsumoAPI consumo = new ConsumoAPI();
        ConverteDados conversor = new ConverteDados();
        var json = consumo.obterDados(endereco);
        Map<String, String> result = convertStringToMap(json);

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
                    System.out.println("OpÃ§Ã£o invÃ¡lida.");
            }
        } while (opcao != 7);

    }
}
