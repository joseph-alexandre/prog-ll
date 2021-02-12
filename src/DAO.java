import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class DAO {

    private final static Path CAMINHO_PASTA_BANCO = Paths.get(System.getProperty("user.dir"), "src", "database");
    private String bancoAtual;
    private static File database;

    public DAO(String nomeDatabase) {
        this.database = criarDatabase(nomeDatabase);
        this.setBancoAtual(nomeDatabase);
    }

    public DAO(String nomeDatabase, Boolean recriarDatabase) {
        this.database = criarDatabase(nomeDatabase, recriarDatabase);
        this.setBancoAtual(nomeDatabase);
    }

    public void setBancoAtual(String nomeBanco){
        this.bancoAtual = CAMINHO_PASTA_BANCO + "\\" + nomeBanco + ".txt";
    }

    public String getBancoAtual(){
        return this.bancoAtual;
    }

    private File criarDatabase(String nomeDatabase) {
        try {
            File file = new File(CAMINHO_PASTA_BANCO + "\\" + nomeDatabase + ".txt");
            if(!file.exists()){
                file.createNewFile();
                System.out.println("Banco de dados " + file.getName() + " criado.");
                return file;
            }
            return file;
        } catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }


    private File criarDatabase(String nomeDatabase, Boolean recriarDatabase) {
        try {
            File file = new File(CAMINHO_PASTA_BANCO + "\\" + nomeDatabase + ".txt");
            if(!file.exists()){
                file.createNewFile();
                System.out.println("Banco de dados " + file.getName() + " criado.");
                return file;
            } else if(recriarDatabase){
                file.delete();
                file.createNewFile();
                System.out.println("Banco de dados " + file.getName() + " recriado.");
            }
            return file;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean inserirRegistro(Object registro){
        String dado = registro.toString() + "\n";
        FileWriter fw = null;
        if(!validaBanco()){
            return false;
        }

        try {
            fw = new FileWriter(database, true);
            fw.write(dado);
            fw.close();
        } catch (FileNotFoundException fnf){
            fnf.printStackTrace();
            return false;
        } catch (IOException io){
            io.printStackTrace();
            return false;
        }
        return true;
    }

    public void inserirRegistros(List<?> registros){
        if(!this.validaBanco()){
            return;
        }
        for (Object registro : registros) {
            inserirRegistro(registro);
        }
    }

    public List<String> lerDados(String caminho){
        this.setBancoAtual(caminho);
        List<String> resultadoArray = new ArrayList<>();
        if(!validaBanco()){
            return null;
        }

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(getBancoAtual()));
            String resultado;
            while((resultado = bufferedReader.readLine()) != null){
                resultadoArray.add(resultado);
            }
            return resultadoArray;
        } catch (FileNotFoundException fnf){
            fnf.printStackTrace();
        } catch (IOException io){
            io.printStackTrace();
        }
        return null;
    }

    public Boolean validaBanco() {
        if (!database.exists()) {
            System.out.println("O banco de dados ainda não foi criado. Crie um para realizar esta operação!");
            return false;
        }
        return true;
    }

    public Boolean validaBanco(String nomeBanco) {
        File banco = new File(CAMINHO_PASTA_BANCO + "\\" +  nomeBanco + ".txt");
        if (!banco.exists()) {
            System.out.println("O banco de dados ainda não foi criado. Crie um para realizar esta operação!");
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }


}
