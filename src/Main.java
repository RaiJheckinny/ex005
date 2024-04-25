import javax.swing.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    static List<Integer> numerosDoUsuario = new LinkedList<>();
    public static void main(String[] args) {
        while (true){
            String dadosMenu = inputJOptionPane("1.Cadastrar Numeros\n2.Imprimir Lista Crecente\n3.Imprimir Lista Decrecente\n4.Sair","Menu");

            switch (dadosMenu){
                case "1":
                    String dadosString = inputJOptionPane("Digite numeros separados por virgula","Lista de Numeros");
                    if(isTraformarStringEmInteleger(dadosString)){
                        cadastrarStringEmArrayInteleger(dadosString,numerosDoUsuario);
                    }
                    break;
                case "2":
                    imprimir(arrayCrescente(numerosDoUsuario));
                    break;
                case "3":
                    imprimir(arrayDecrecente(numerosDoUsuario));
                    break;
                case "4":
                    System.exit(0);
                    break;
                default:
                    imprimir("Valor Informado Invalido");


            }

        }
    }

    private static String arrayDecrecente(List<Integer> arrayInteger) {
        arrayInteger.sort((a,b)-> b - a);
        return arrayInteger.stream().map(Object::toString).reduce("",(acc, elemento)-> acc + " "+ elemento);
    }

    private static String arrayCrescente(List<Integer> arrayInteger) {
        arrayInteger.sort((a,b)-> a - b);
        return arrayInteger.stream().map(Object::toString).reduce("",(acc, elemento)-> acc + "\n"+ elemento);
    }

    private static String inputJOptionPane(String mensagem, String menu) {
        return JOptionPane.showInputDialog(null,mensagem, menu,JOptionPane.QUESTION_MESSAGE);
    }

    private static void cadastrarStringEmArrayInteleger(String dadosString, List<Integer> listInteleger) {
        splitStringArray(dadosString).forEach(dadosArrayInteger -> listInteleger.add(dadosArrayInteger));
    }

    private static boolean isTraformarStringEmInteleger(String dadosString) {
        List<String> dadosArrayString = Arrays.asList(dadosString.split(","));
        try {
            dadosArrayString.forEach(dado -> Integer.parseInt(dado));
        } catch (NumberFormatException e) {
            imprimir("Valor Informado Invalido");
            return false;
        }
        return true;
    }

    private static List<Integer> splitStringArray(String dados) {
        List<String> dadosArrayString = Arrays.asList(dados.split(","));
        return dadosArrayString.stream().map(dado -> Integer.parseInt(dado)).collect(Collectors.toList());
    }
    public static void imprimir(String imprimirString){
        JOptionPane.showMessageDialog(null,imprimirString);
    }

}