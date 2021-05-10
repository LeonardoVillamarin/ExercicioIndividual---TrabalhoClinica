package Clinica.Sistema.Persistencia;

import java.io.*;
import java.util.Vector;

import Clinica.Beans.Medico;
import Clinica.Beans.Paciente;
import Clinica.Sistema.StatusAtendimento;
import Clinica.Sistema.Cadastro.*;
import Clinica.Sistema.Exceptions.ObjetoNaoEncontradoException;
import Clinica.Sistema.Exceptions.VectorNaoPossuiObjetosException;

public class ManipulaArquivo {
    public static void writeFilePacientes() throws FileNotFoundException, IOException, VectorNaoPossuiObjetosException{
        if(CadastroPaciente.getVectorPacientes().size() == 0){
            throw new VectorNaoPossuiObjetosException();
        }
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Clinica\\Sistema\\Persistencia\\Pacientes.dat"));
        oos.writeObject(CadastroPaciente.getVectorPacientes());
        oos.flush();
        oos.close();
    }
    public static void readFilePacientes() throws FileNotFoundException, IOException, ClassNotFoundException, ObjetoNaoEncontradoException, VectorNaoPossuiObjetosException{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Clinica\\Sistema\\Persistencia\\Pacientes.dat"));
        Vector<Paciente> p = (Vector<Paciente>)ois.readObject();
        ois.close();
        if(p.size() == 0){
            throw new VectorNaoPossuiObjetosException();
        }
        if(p.get(0) == null){
            throw new ObjetoNaoEncontradoException();
        }
        for(Paciente paciente : p){
            CadastroPaciente.setVectorPacientes(paciente);
        }
    }
    public static void writeFileMedicos() throws IOException, VectorNaoPossuiObjetosException{
        if(CadastroMedico.getVectorMedicos().size() == 0){
            throw new VectorNaoPossuiObjetosException();
        }
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Clinica\\Sistema\\Persistencia\\Medicos.dat"));
        oos.writeObject(CadastroMedico.getVectorMedicos());
        oos.flush();
        oos.close();
    }
    public static void readFileMedicos() throws FileNotFoundException, IOException, ClassNotFoundException, VectorNaoPossuiObjetosException, ObjetoNaoEncontradoException{                                                                
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Clinica\\Sistema\\Persistencia\\Medicos.dat"));
        Vector<Medico> m = (Vector<Medico>)ois.readObject();
        ois.close();
        if(m.size() == 0){
            throw new VectorNaoPossuiObjetosException();
        }
        if(m.get(0) == null){
            throw new ObjetoNaoEncontradoException();
        }
        for(Medico medico : m){
            medico.setStatus(StatusAtendimento.AGUARDANDO);
            CadastroMedico.setVectorMedicos(medico);
        }
    }
}
