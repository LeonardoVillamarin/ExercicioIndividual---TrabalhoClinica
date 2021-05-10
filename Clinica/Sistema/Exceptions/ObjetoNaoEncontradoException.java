package Clinica.Sistema.Exceptions;

public class ObjetoNaoEncontradoException extends Exception{
    public ObjetoNaoEncontradoException(){
        super("O objeto não foi encontrado");
    }
}
