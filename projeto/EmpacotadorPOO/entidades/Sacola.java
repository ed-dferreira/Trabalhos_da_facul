package entidades;

import Produto.Produto;

import java.util.LinkedList;

/**
 * Classe que representa uma sacola para colocar produtos.
 * <br><br>
 * <strong>Não mexa aqui!!!</strong>
 * 
 * @author Jean Cheiran
 * @version 1.0
 */
public class Sacola {
    
    private LinkedList<Produto> produtos;
    
    /**
     * Construtor padrão de Sacola.
     * Ele sempre cria uma sacola vazia.
     */
    public Sacola(){
        produtos = new LinkedList<>();
    }
    
    /**
     * Retorna a quantidade de produtos na sacola.
     * @return quantidade de produtos na sacola
     */
    public int contarProdutosNaSacola(){
        return produtos.size();
    }
    
    /**
     * Devolve um vetor contendo todos os produtos da sacola.
     * Os produtos não estarão em uma ordem definida, pois se misturam na
     * sacola. O uso desse vetor deve ser cuidadoso, pois os elementos são
     * referências para os produtos que estão também na sacola, ou seja, 
     * modificar o estado interno de um produto do vetor causa modificação no
     * mesmo produto da sacola. Por outro lado, alterar o vetor não causa
     * efeito na sacola, ou seja, remover um elemento do vetor não modifica
     * em nada os produtos da sacola.
     * @return vetor de produtos sem ordem garantida
     */
    public Produto[] getArrayDaSacola(){
        return produtos.toArray(Produto[]::new);
    }
    
    /**
     * Inclui um produto na sacola.
     * O produto não é removido de qualquer outra estrutura que faça parte
     * quando vai para a sacola, ou seja, é necessário tirar o produto do monte
     * e só depois colocar ele na sacola.
     * @param produto produto que será colocado na sacola (um valor null será ignorado)
     */
    public void colocarProdutoNaSacola(Produto produto){
        if(produto == null){
            return;
        }
        
        produtos.add(produto);
        
        int peso = 0;
        for(Produto p : produtos){
            peso += p.getPeso();
        }
        if(peso > 5000){
            produtos = new LinkedList<>();
            Supermercado.advertirEmpacotadorRasgouSacola();
        }
    }
    
    /**
     * Remove um produto da sacola.
     * Remove a primeira ocorrência do produto passado como parâmetro na sacola
     * se houver aquele produto na sacola. Se aquele produto não existir, o
     * método retorna null. A busca pelo produto é feita usando o método
     * equals.
     * @param produto produto para ser retirado
     * @return produto encontrado, ou null se não for encontrado na sacola
     */
    public Produto pegarProdutoDaSacola(Produto produto){
        if(produtos.remove(produto)){
            return produto;
        }
        return null;
    }
    
}
