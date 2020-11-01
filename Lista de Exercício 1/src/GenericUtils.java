import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GenericUtils {

    public static String formatarData(Date data){
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        return formatador.format(data);
    }

    public static String formatarBoolean(Boolean condicao){
        if(condicao == true){
            return "Sim";
        } else if( condicao == false){
            return "Não";
        }
        return "Não foi possível fazer a conversão. É aceito somente valores de true ou false.";
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
}
