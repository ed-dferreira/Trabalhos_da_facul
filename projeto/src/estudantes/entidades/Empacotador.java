package estudantes.entidades;

import professor.entidades.Fiscal;
import professor.entidades.Caixa;
import professor.entidades.Sacola;
import professor.entidades.Supermercado;

import java.util.LinkedList;

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

    public int proximoCaixa = 1; // Usada para saber para onde o empacotador deve ir



    Caixa caixa;
    Fiscal fiscal;

    Sacola sacola;



    public void agir(Caixa caixa, Fiscal fiscal) {

        caixa.getSacola(1); //pega uma sacola

        caixa.despacharSacola(1); // só manda para o fiscal

        caixa.reporSacolas(); // Todos os espaços do caixa sem sacolas recebem novas sacolas vazias.

        caixa.contarProdutosNoMonte(); //vetor sem ordem definida do monte mas só faz isso e nada mais

        //caixa.pegarProdutoDoMonte(); // retira do monte o produto

        //fiscal.despachar(); //alguma sacola

        fiscal.contarSacolasDespachadas();

        fiscal.getArrayDasSacolasDespachos(); //faz só isso mesmo



        //sacola.colocarProdutoNaSacola(); //retorna um size ou int

        sacola.getArrayDaSacola(); //só mostra o array mesmo

       // sacola.colocarProdutoNaSacola(); //adiciona a sacola e calcula o peso

        //sacola.pegarProdutoDaSacola();





       //codigo aqui

        // separar produtos de acordo com tipo de objeto

    }
}
/*
 * O atributo "proximoCaixa" é usado pelo simulador para mover o empacotador
 * para outro caixa (ou permanecer no mesmo se ele quiser), ou seja, o
 * empacotador sempre vai para o caixa do número indicado nesse atributo
 * após um ciclo de simulação.
 *
 *  * <strong>O empacotador não pode levar produtos com ele</strong> de um
 * caixa para outro, ou seja, você não deve criar atributos com vetores,
 * matrizes ou coleções (ArrayList, HashSet etc.) de produtos.
 * @param caixa o caixa onde está o empacotador
 * @param fiscal fiscal que pode ser consultado sobre as sacolas despachadas
 */
