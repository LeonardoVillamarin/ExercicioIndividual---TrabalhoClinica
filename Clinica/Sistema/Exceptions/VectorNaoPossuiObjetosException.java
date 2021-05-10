package Clinica.Sistema.Exceptions;

public class VectorNaoPossuiObjetosException extends Exception{
    public VectorNaoPossuiObjetosException(){
        super("O vector está vazio.");
    }
}
