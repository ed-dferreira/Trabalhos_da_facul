package entidades;

import Produto.Produto;

import java.util.LinkedList;

/**
 * Classe que representa um fiscal que confere e despacha sacolas para transporte.
 * <br><br>
 * <strong>Não mexa aqui!!!</strong>
 * 
 * @author Jean Cheiran
 * @version 1.0
 */
public class Fiscal {
    public LinkedList<Sacola> sacolasDespachadas;
    
    /**
     * Construtor padrão de Fiscal.
     * Ele sempre cria um fiscal que não despachou nenhuma sacola.
     */
    public Fiscal(){
        sacolasDespachadas = new LinkedList<>();
    }
    
    /**
     * Verifica e despacha uma sacola.
     * O fiscal faz uma série de verificações antes de despachar uma sacola,
     * gerando advertências se houver problemas.<br>
     * 1) Se o peso for menor que 1kg.<br>
     * 2) Se produtos de cuidados pessoais forem guardados com alimentos.<br>
     * 3) Se produtos de limpeza forem guardados com alimentos, 
     * eletroeletrônicos ou produtos de cuidados pessoais.<br>
     * 4) Se produtos refrigerados forem guardados com qualquer outro tipo
     * de produto.<br>
     * 5) Se produtos refrigerados na mesma sacola tiverem diferença de
     * temperatura ideal maior que 15 graus.
     * <br><br>
     * Apenas uma advertência é gerada por sacola mesmo que existam vários
     * problemas com seus produtos.
     * <br><br>
     * Toda sacola é despachada, mesmo que tenha problemas.
     * @param sacola sacola com produtos para ser transportada
     */
    public void despachar(Sacola sacola){
        //verifica peso mínimo da sacola
        int peso = 0;
        for(Produto p : sacola.getArrayDaSacola()){
            peso += p.getPeso();
        }
        if(peso < 1000){
            Supermercado.advertirEmpacotadorQuebrouRegra();
            sacolasDespachadas.add(sacola);
            return;
        }
        
        //cuidados pessoais não podem estar com alimentícios
        for(Produto p : sacola.getArrayDaSacola()){
            if(p instanceof CuidadosPessoais){
                for(Produto o : sacola.getArrayDaSacola()){
                    if(o instanceof Alimenticio){
                        Supermercado.advertirEmpacotadorQuebrouRegra();
                        sacolasDespachadas.add(sacola);
                        return;
                    }
                }
            }
        }
        
        //limpeza não podem estar com alimentícios, eletroeletrônicos e cuidados pessoais
        for(Produto p : sacola.getArrayDaSacola()){
            if(p instanceof Limpeza){
                for(Produto o : sacola.getArrayDaSacola()){
                    if(o instanceof Alimenticio || o instanceof Eletroeletronico || o instanceof CuidadosPessoais){
                        Supermercado.advertirEmpacotadorQuebrouRegra();
                        sacolasDespachadas.add(sacola);
                        return;
                    }
                }
            }
        }
        
        //refrigerados só podem estar com refrigerados
        //e não podem ter temperaturas muito diferentes
        for(Produto p : sacola.getArrayDaSacola()){
            if(p instanceof Refrigerado){
                for(Produto o : sacola.getArrayDaSacola()){
                    if(!(o instanceof Refrigerado)){
                        Supermercado.advertirEmpacotadorQuebrouRegra();
                        sacolasDespachadas.add(sacola);
                        return;
                    }
                    Refrigerado pConvertido = (Refrigerado) p;
                    Refrigerado oConvertido = (Refrigerado) o;
                    if(pConvertido.getTemperaturaIdeal() > oConvertido.getTemperaturaIdeal()+15
                            || pConvertido.getTemperaturaIdeal() < oConvertido.getTemperaturaIdeal()-15){
                        Supermercado.advertirEmpacotadorQuebrouRegra();
                        sacolasDespachadas.add(sacola);
                        return;
                    }
                }
            }
        }
        
        sacolasDespachadas.add(sacola);
    }
    
    /**
     * Retorna a quantidade de sacolas despachados.
     * @return quantidade de sacolas despachados
     */
    public int contarSacolasDespachadas(){
        return sacolasDespachadas.size();
    }
    
    /**
     * Devolve um vetor contendo todas as sacolas despachadas pelo empacotador.
     * As sacolas não estarão em uma ordem definida, pois se misturam no
     * transporte. O uso desse vetor deve ser cuidadoso, pois os elementos são
     * referências para as sacolas que estão também no transporte, ou seja, 
     * modificar o estado interno de uma sacola do vetor causa modificação na
     * mesma sacola. Por outro lado, alterar o vetor não causa efeito no 
     * transporte, ou seja, remover um elemento do vetor não modifica
     * em nada as sacolas já despachadas.
     * @return vetor de sacolas sem ordem garantida
     */
    public Sacola[] getArrayDasSacolasDespachos(){
        return sacolasDespachadas.toArray(Sacola[]::new);
    }
}
