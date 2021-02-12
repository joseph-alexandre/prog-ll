import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GenericUtils {

    public static String formatarDataParaString(Date data){
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        return formatador.format(data);
    }

    public static Date formatarStringParaData(String data)  {
        if (data == null || data.equals(""))
            return null;

        Date date = null;
        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            date = formatter.parse(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String formatarBoolean(Boolean condicao){
        if(condicao){
            return "Sim";
        } else {
            return "Não";
        }
    }

    public static String formatarListaString(List<String> lista){
        String result = "";
        if(lista.size() > 0){
            for (String objeto : lista){
                result += objeto + ", ";
            }
            result = result.substring(0, result.length() - 2);
        }
        return result;
    }

    public static List<String> pegarNomesFuncionarios(List<Funcionario> funcionarios){
        List<String> nomesFuncionarios = new ArrayList<>();
        for (Funcionario funcionario : funcionarios){
            nomesFuncionarios.add(funcionario.getNome());
        }
        return nomesFuncionarios;
    }

    public static String gerarDigitoAleatorio(){
        return "" + (int) (Math.random() * ((9 - 0) + 1));
    }

    public static boolean criarDatabase(String nomeDatabase) throws IOException {
        Path caminhoAtual = Paths.get(System.getProperty("user.dir"), "src", "database");
        File file = new File(caminhoAtual + "\\" + nomeDatabase + ".txt");
        if(!file.exists()){
            file.createNewFile();
            System.out.println("Banco de dados " + file.getName() + " criado.");
            return true;
        }
        System.out.println("A base de dados " + file.getName() + " já existe.");
        return false;
    }

    public static void main(String[] args) throws IOException {

    }


}
