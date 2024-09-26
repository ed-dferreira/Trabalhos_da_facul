package professor.entidades;

import estudantes.entidades.*;
import java.util.LinkedList;

/**
 * Classe que representa um caixa com monte de produtos e área de sacolas.
 * <br><br>
 * <strong>Não mexa aqui!!!</strong>
 * 
 * @author Jean Cheiran
 * @version 1.0
 */
public class Caixa {
    
    public static final int QUANTIDADE_DE_SACOLAS_NO_CAIXA = 5;
    
    private LinkedList<Produto> monte;
    private Sacola sacolas[];
    private Fiscal fiscal;

    /**
     * Construtor do caixa.
     * Ele sempre começa sem produtos no monte e 5 sacolas vazias.
     * @param fiscal o fiscal que verifica e despacha sacolas
     */
    public Caixa(Fiscal fiscal){
        this.fiscal = fiscal;
        sacolas = new Sacola[QUANTIDADE_DE_SACOLAS_NO_CAIXA];
        for (int i = 0; i < QUANTIDADE_DE_SACOLAS_NO_CAIXA; i++) {
            sacolas[i] = new Sacola();
        }
        monte = new LinkedList<>();
    }
    
    /**
     * Retorna uma sacola do caixa.
     * O uso desse objeto deve ser cuidadoso, pois é uma referência direta para 
     * uma sacola com produtos, ou seja, modificar o estado interno de uma 
     * sacola causa modificação efetiva dela no caixa.
     * @param numero o número da sacola que deve ser retornada (começa em 1)
     * @return sacola do caixa ou null se a sacola foi despachada para o fiscal
     * @throws ArrayIndexOutOfBoundsException se um número da sacola não 
     * existente é pedido (zero ou menos, ou acima do limite)
     */
    public Sacola getSacola(int numero){
        return sacolas[numero-1];
    }
    
    /**
     * Envia uma sacola para despacho.
     * Manda uma sacola específica para o fiscal despachar, mas não faz nenhuma
     * verificação de seus produtos. O espaço dessa sacola recebe o valor
     * null depois de despachada (indiferente ao resultado do despacho).
     * @param numero numero da sacola no caixa que deve ser despachada
     * @throws ArrayIndexOutOfBoundsException se o número da sacola não 
     * existe (zero ou menos, ou acima do limite)
     * @see professor.entidades.Fiscal#despachar(professor.entidades.Sacola) 
     */
    public void despacharSacola(int numero){
        fiscal.despachar(getSacola(numero));
        sacolas[numero-1] = null;
    }
    
    /**
     * Cria novas sacolas vazias no lugar das sacolas despachadas.
     * Todos os espaços do caixa sem sacolas recebem novas sacolas vazias.
     */
    public void reporSacolas(){
        for (int i = 0; i < QUANTIDADE_DE_SACOLAS_NO_CAIXA; i++) {
            if(sacolas[i] == null){
                sacolas[i] = new Sacola();
            }
        }
    }
    
    /**
     * Retorna a quantidade de produtos no caixa para serem ensacolados.
     * @return quantidade de produtos no monte do caixa 
     */
    public int contarProdutosNoMonte(){
        return monte.size();
    }
    
    /**
     * Devolve um vetor contendo todos os produtos no monte do caixa.
     * Os produtos não estarão em uma ordem definida, pois se misturam no
     * monte. O uso desse vetor deve ser cuidadoso, pois os elementos são
     * referências para os produtos que estão também no monte, ou seja, 
     * modificar o estado interno de um produto do vetor causa modificação no
     * mesmo produto do monte. Por outro lado, alterar o vetor não causa
     * efeito no caixa, ou seja, remover um elemento do vetor não modifica
     * em nada os produtos do monte.
     * @return vetor de produtos sem ordem garantida
     */
    public Produto[] getArrayDoMonte(){
        return monte.toArray(Produto[]::new);
    }
    
    /**
     * Coloca um produto no monte do caixa.
     * Esse método é usado basicamente para colocar os produtos comprados pela
     * ricaça no monte dos caixas quando o simulador está funcionando. Ele não
     * precisa (e nem deve) ser usado na lógica do empacotador, pois um produto
     * removido do monte geralmente vai parar em uma sacola e não de volta no
     * monte.
     * <br><br>
     * Use esse método com cautela, pois ele pode ocasionar duplicatas de
     * produtos se usado incorretamente!
     * @param produto o produto a ser adicionado ao monte
     * @see professor.entidades.Supermercado#simularSupermercado() 
     */
    public void colocarProdutoNoMonte(Produto produto){
        monte.add(produto);
    }
    
    /**
     * Pega um produto do monte (removendo ele de lá).
     * Esse método é a base de funcionamento para colocar produtos na sacola,
     * pois os produtos precisam ser retirados do monte antes de serem colocados
     * em uma sacola.
     * @param produto o produto que vai ser tirado do monte 
     * @return o próprio produto que foi removido do monte (sim, eu sei que isso
     * é estranho, mas não é possível indicar o índice ou a posição de um
     * produto do monte porque eles não tem uma ordem garantida, então é
     * necessário usar o próprio produto como parâmetro) 
     */
    public Produto pegarProdutoDoMonte(Produto produto){
        if(monte.remove(produto)){
            return produto;
        }
        return null;
    }
}
