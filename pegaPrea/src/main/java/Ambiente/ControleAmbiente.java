package Ambiente;
import org.example.TelaJogo;
import java.io.IOException;

public class ControleAmbiente {
    TelaJogo gp;
    Ambiente[] ambientes;

    public ControleAmbiente(TelaJogo gp) {
        this.gp = gp;
        ambientes = new Ambiente[10];
        getAmbienteImagens();
    }
    public void getAmbienteImagens(){
        try {
            ambientes[0] = new Ambiente();
            //ambientes[0].image =

//seguir trabalhando nisso posteriormente

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
