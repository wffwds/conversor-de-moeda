
public class Menu {

    public Menu() {
    }

    public static void menu(){
        System.out.println("***********************************************" +
                "************************************************");
        System.out.println("1) Dolar ==> Peso argentino");
        System.out.println("2) Peso argentino ==> Dolar");
        System.out.println("3) Dolar ==> Real brasileiro");
        System.out.println("4) Real brasileiro ==> Dolar");
        System.out.println("5) Dolar ==> Peso colombiano");
        System.out.println("6) Peso colombiano ==> Dolar");
        System.out.println("7) Sair");
        System.out.println("Escolha uma opção válida: ");
    }
    public static void DolarPesoArgentin(){
        System.out.println("Dolar ==> Peso argentino.");

    }

    public static void PesoArgentinoDolar(){
        System.out.println("Peso argentino ==> Dolar.");
    }

    public static void DolarRealBrasleiro(){
        System.out.println("Dolar ==> Real brasileiro.");
    }

    public static void RealBrasleiroDolar(){
        System.out.println("Real brasileiro ==> Dolar.");
    }

    public static void DolarPesoclombiano(){
        System.out.println("Dolar ==> Peso colombiano.");
    }

    public static void PesoColombianoDolar(){
        System.out.println("Peso colombiano ==> Dolar.");
    }

    public static void Sair(){
        System.out.println("Finalizando o programa.");
        return;
    }

}
