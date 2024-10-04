package estudantes.entidades;

import professor.entidades.Fiscal;
import professor.entidades.Caixa;
import professor.entidades.Sacola;
import professor.entidades.Supermercado;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

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
    Random random = new Random();
    public int proximoCaixa = 1; // Usada para saber para onde o empacotador deve ir

    public void agir(Caixa caixa, Fiscal fiscal) {
        //private boolean crescente = true;

        adicionarProdutosAoMonte(caixa);
        ensacolarProdutos(caixa);
    }

    private void adicionarProdutosAoMonte(Caixa caixa) {
        // Criando instâncias de produtos de Limpeza e adicionando ao monte
        for (int i = 0; i < 20; i++) {
            Limpeza produtoLimpeza = new Limpeza(i, "Produto de Limpeza " + i, "Fabricante " + i, 100 + (i * 10));
            caixa.colocarProdutoNoMonte(produtoLimpeza); // Adiciona produto ao monte através do caixa
        }

        // Criando instâncias de Cuidados Pessoais (Cosméticos) e adicionando ao monte
        for (int i = 0; i < 20; i++) {
            long validadeCosmetico = System.currentTimeMillis() + (i * 24 * 60 * 60 * 1000); // Exemplo de validade crescente
            Cosmetico cosmetico = new Cosmetico(i + 20, "Cosmetico " + i, "Fabricante " + (i + 20), 50 + (i * 5),
                    validadeCosmetico, "Fragrância " + i, (char) ('A' + (i % 4)));
            caixa.colocarProdutoNoMonte(cosmetico); // Adiciona produto ao monte através do caixa
        }

        // Criando instâncias de Higiene e adicionando ao monte
        for (int i = 0; i < 20; i++) {
            long validadeHigiene = System.currentTimeMillis() + (i * 30 * 24 * 60 * 60 * 1000); // Exemplo de validade crescente
            Higiene higiene = new Higiene(i + 40, "Higiene " + i, "Fabricante " + (i + 40), 70 + (i * 10), validadeHigiene,
                    "Fragrância " + i);
            caixa.colocarProdutoNoMonte(higiene); // Adiciona produto ao monte através do caixa
        }

        // Criando instâncias de Papelaria e adicionando ao monte
        for (int i = 0; i < 20; i++) {
            Papelaria papelaria = new Papelaria(i + 100, "Produto de Papelaria " + i, "Fabricante " + (i + 100), 200 + (i * 15));
            caixa.colocarProdutoNoMonte(papelaria); // Adiciona produto ao monte através do caixa
        }

        // Criando instâncias de Eletroeletrônicos e adicionando ao monte
        for (int i = 0; i < 20; i++) {
            Eletroeletronico eletroeletronico = new Eletroeletronico(i + 80, "Eletroeletrônico " + i, "Fabricante " + (i + 80),
                    300 + (i * 25), (short) (110 + (i % 20)));
            caixa.colocarProdutoNoMonte(eletroeletronico); // Adiciona produto ao monte através do caixa
        }

        // Criando instâncias de Produtos Alimentícios Não Perecíveis e adicionando ao monte
        for (int i = 0; i < 20; i++) {
            long validadeNaoPerecivel = System.currentTimeMillis() + (i * 365 * 24 * 60 * 60 * 1000); // Validade anual crescente
            NaoPerecivel alimentoNaoPerecivel = new NaoPerecivel(i + 40, "Alimento Não Perecível " + i, "Fabricante " + (i + 40),
                    150 + (i * 12), validadeNaoPerecivel, "Tipo de Armazenamento " + i);
            caixa.colocarProdutoNoMonte(alimentoNaoPerecivel); // Adiciona produto ao monte através do caixa
        }

        // Criando instâncias de Produtos Alimentícios Perecíveis e adicionando ao monte
        for (int i = 0; i < 20; i++) {
            long validadePerecivel = System.currentTimeMillis() + (i * 15 * 24 * 60 * 60 * 1000); // Exemplo de validade curta
        }
        proximoCaixa++;
    }

    // criar um if para separar os tipos de produto

    private void ensacolarProdutos(Caixa caixa) {
        // Índice da sacola que será usada para adicionar produtos (1 a 5)
        int numeroSacola = 1;

        caixa.contarProdutosNoMonte();

        for (Produto produto : caixa.getArrayDoMonte()) {
            // Tentar remover o produto do monte
            Produto removido = caixa.pegarProdutoDoMonte(produto);
            if (removido != null) {
                caixa.getSacola(numeroSacola).colocarProdutoNaSacola(removido);
                caixa.getSacola(numeroSacola).contarProdutosNaSacola();
                //caixa.getSacola(numeroSacola).pegarProdutoDaSacola(removido);




                // Incrementar o número da sacola (1 a 5) de forma circular
                numeroSacola++;
                if (numeroSacola > Caixa.QUANTIDADE_DE_SACOLAS_NO_CAIXA) {
                    numeroSacola = 1;
                }

            }
        }
        Supermercado s1 = new Supermercado();
        s1.getAdvertencias();
        s1.getRegrasQuebradas();
        s1.getSacolasRasgadas();

      //  Fiscal.SacolasDespachadas(); erro


        // Despachar todas sacolas que ainda possuem produtos após a distribuição
        for (int i = 1; i <= Caixa.QUANTIDADE_DE_SACOLAS_NO_CAIXA; i++) {
            Sacola sacola = caixa.getSacola(i);
            if (sacola != null && sacola.contarProdutosNaSacola() > 0) {//por o peso aqui tambem e devolver um valor para o switch case até fazer o produto ser mais pesado que 1kg e menos de 5kg
                caixa.despacharSacola(i);
                caixa.reporSacolas();
            }
        }


    }

    private int calcularPesoSacola(Sacola sacola) {
        Produto[] produtos = sacola.getArrayDaSacola();
        int pesoTotal = 0;
        for (Produto p : produtos) {
            pesoTotal += p.getPeso();
        }
        return pesoTotal;
    }
}