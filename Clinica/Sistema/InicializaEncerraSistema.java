package Clinica.Sistema;

import java.io.FileNotFoundException;
import java.io.IOException;

import Clinica.Sistema.Cadastro.*;
import Clinica.Sistema.Exceptions.ObjetoNaoEncontradoException;
import Clinica.Sistema.Exceptions.VectorNaoPossuiObjetosException;
import Clinica.Sistema.Persistencia.ManipulaArquivo;

public abstract class InicializaEncerraSistema {
    static boolean statusFuncionamento = true;  
    protected static void startSystem() throws FileNotFoundException, ClassNotFoundException, IOException, VectorNaoPossuiObjetosException, ObjetoNaoEncontradoException{
        ManipulaArquivo.readFileMedicos();
        ManipulaArquivo.readFilePacientes();
    }
    protected static void closeSystem() throws IOException, VectorNaoPossuiObjetosException{
        if(!CadastroMedico.getVectorMedicos().isEmpty()){
            ManipulaArquivo.writeFileMedicos();
        }
        if(!CadastroPaciente.getVectorPacientes().isEmpty()){
            ManipulaArquivo.writeFilePacientes();
        }
        statusFuncionamento = false;
    }
}
