package estudantes.entidades;

import java.util.Random;
import professor.entidades.*;

/**
 * Classe que traz a lógica do algoritmo de "ensacolamento" dos produtos.
 * <br><br>
 * Você pode incluir novos atributos e métodos nessa classe para criar
 * lógicas mais complexas para o gerenciamento empacotamento de produtos, 
 * mas esses <strong>atributos e métodos devem ser todos privados</strong>. 
 * O único método público deve ser "agir".
 * 
 * @author Jean Cheiran
 * @version 1.0
 */
public class Empacotador {
    
    public int proximoCaixa = 1; //usada para saber para onde o empacotador deve ir
    
    /**
     * Executa a lógica de empacotamento e troca de caixa.
     * Esse método é o único método de controle invocado durante a simulação 
     * do supermercado.
     * <br><br>
     * Aqui podem ser feitas todas as verificações sobre os produtos no monte e
     * nas sacolas do caixa em que o empacotador está. A partir dessas informações,
     * você pode colocar produtos do monte daquele caixa em sacolas e despachar
     * sacolas para o fiscal.
     * <br><br>
     * O atributo "proximoCaixa" é usado pelo simulador para mover o empacotador
     * para outro caixa (ou permanecer no mesmo se ele quiser), ou seja, o
     * empacotador sempre vai para o caixa do número indicado nesse atributo 
     * após um ciclo de simulação.
     * <br><br>
     * <strong>O empacotador não pode levar produtos com ele</strong> de um  
     * caixa para outro, ou seja, você não deve criar atributos com vetores, 
     * matrizes ou coleções (ArrayList, HashSet etc.) de produtos.
     * @param caixa o caixa onde está o empacotador
     * @param fiscal fiscal que pode ser consultado sobre as sacolas despachadas
     */
    public void agir(Caixa caixa, Fiscal fiscal){
        
    }
    
}
