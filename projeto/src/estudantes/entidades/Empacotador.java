package estudantes.entidades;

import professor.entidades.Fiscal;
import professor.entidades.Caixa;
import professor.entidades.Sacola;
import professor.entidades.Supermercado;

import java.util.Random;

public class Empacotador {
    private Random random = new Random();
    public int proximoCaixa = 1;
    
    public void agir(Caixa caixa, Fiscal fiscal) {
        while(true) {
            adicionarProdutosAoMonte(caixa);
            ensacolarProdutos(caixa, fiscal, proximoCaixa);
            proximoCaixa++;
            if (proximoCaixa > 5){
                proximoCaixa = 1;
            }
        }
    }

    private void adicionarProdutosAoMonte(Caixa caixa) {
        int quantidadeItens = 10;

        for (int i = 0; i < quantidadeItens; i++) {
            Limpeza produtoLimpeza = new Limpeza(i, "Produto de Limpeza " + i, "Fabricante " + i, 100 + (i * 10));
            caixa.colocarProdutoNoMonte(produtoLimpeza);
        }

        // Criando instâncias de Cuidados Pessoais (Cosméticos) e adicionando ao monte
        for (int i = 0; i < quantidadeItens; i++) {
            long validadeCosmetico = System.currentTimeMillis() + (i * 24 * 60 * 60 * 1000); // Exemplo de validade crescente
            Cosmetico cosmetico = new Cosmetico(i + 20, "Cosmetico " + i, "Fabricante " + (i + 20), 50 + (i * 5),
                    validadeCosmetico, "Fragrância " + i, (char) ('A' + (i % 4)));
            caixa.colocarProdutoNoMonte(cosmetico);
        }

        // Criando instâncias de Higiene e adicionando ao monte
        for (int i = 0; i < quantidadeItens; i++) {
            long validadeHigiene = System.currentTimeMillis() + (i * 30 * 24 * 60 * 60 * 1000);
            Higiene higiene = new Higiene(i + 40, "Higiene " + i, "Fabricante " + (i + 40), 70 + (i * 10), validadeHigiene,
                    "Fragrância " + i);
            caixa.colocarProdutoNoMonte(higiene);
        }

        // Criando instâncias de Papelaria e adicionando ao monte
        for (int i = 0; i < quantidadeItens; i++) {
            Papelaria papelaria = new Papelaria(i + 100, "Produto de Papelaria " + i, "Fabricante " + (i + 100), 200 + (i * 15));
            caixa.colocarProdutoNoMonte(papelaria);
        }

        // Criando instâncias de Eletroeletrônicos e adicionando ao monte
        for (int i = 0; i < quantidadeItens; i++) {
            Eletroeletronico eletroeletronico = new Eletroeletronico(i + 80, "Eletroeletrônico " + i, "Fabricante " + (i + 80),
                    300 + (i * 25), (short) (110 + (i % 20)));
            caixa.colocarProdutoNoMonte(eletroeletronico);
        }

        // Criando instâncias de Produtos Alimentícios Não Perecíveis e adicionando ao monte
        for (int i = 0; i < quantidadeItens; i++) {
            long validadeNaoPerecivel = System.currentTimeMillis() + (i * 365 * 24 * 60 * 60 * 1000);
            NaoPerecivel alimentoNaoPerecivel = new NaoPerecivel(i + 40, "Alimento Não Perecível " + i, "Fabricante " + (i + 40),
                    150 + (i * 12), validadeNaoPerecivel, "Tipo de Armazenamento " + i);
            caixa.colocarProdutoNoMonte(alimentoNaoPerecivel);
        }

        // Criando instâncias de Produtos Alimentícios Perecíveis e adicionando ao monte
        for (int i = 0; i < quantidadeItens; i++) {
            long validadePerecivel = System.currentTimeMillis() + (i * 15 * 24 * 60 * 60 * 1000);
            Perecivel alimentoPerecivel = new Perecivel(i + 60, "Alimento Perecível " + i, "Fabricante " + (i + 60),
                    200 + (i * 10), validadePerecivel);
            caixa.colocarProdutoNoMonte(alimentoPerecivel);
        }
        if (proximoCaixa > 5) {
            proximoCaixa = 1;
        }
        proximoCaixa++;
    }

    private void ensacolarProdutos(Caixa caixa, Fiscal fiscal, int proximoCaixa) {
        int numeroSacola = 1;

        caixa.contarProdutosNoMonte();

        for (Produto produto : caixa.getArrayDoMonte()) {
            Produto removido = caixa.pegarProdutoDoMonte(produto);
            if (proximoCaixa > 5) {
                proximoCaixa = 1;
            }
            if (removido != null) {
                Sacola sacolaAtual = caixa.getSacola(numeroSacola);
                if (sacolaAtual != null) {
                    sacolaAtual.colocarProdutoNaSacola(removido);
                    switch (numeroSacola) {
                        case 1:
                            apenasRefrigerados(caixa, sacolaAtual, removido, fiscal);
                            break;
                        case 2:
                            cuidadosPessoais(caixa, sacolaAtual, removido, fiscal);
                            break;
                        case 3:
                            apenasAlimenticios(caixa, sacolaAtual, removido, fiscal);
                            break;
                        case 4:
                            apenasLimpeza(caixa, sacolaAtual, removido, fiscal);
                            break;
                        case 5:
                            eletroPapelaria(caixa, sacolaAtual, removido, fiscal);
                            break;
                        default:
                            break;
                    }

                    if (calculoPeso(caixa, sacolaAtual, produto)) {
                        fiscal.despachar(sacolaAtual);
                    }
                }
                numeroSacola++;
                if (numeroSacola > 5) {
                    numeroSacola = 1;
                }
                proximoCaixa++;
            }
        }
    }

    // refrigerados só podem estar com refrigerados
    // e não podem ter temperaturas muito diferentes +- 15 graus
    private void apenasRefrigerados(Caixa caixa, Sacola sacola, Produto removido, Fiscal fiscal) {//certo
        for (Produto produto : caixa.getArrayDoMonte()) {
            Produto refrigerado = caixa.pegarProdutoDoMonte(produto);
            if (!(refrigerado instanceof Refrigerado)) {
                caixa.colocarProdutoNoMonte(refrigerado);
            }
            if (calculoPeso(caixa, sacola, refrigerado) == true && verificaTemp(sacola) == true) {
                fiscal.despachar(sacola);
                caixa.reporSacolas();
            }
        }
    }

    private void apenasAlimenticios(Caixa caixa, Sacola sacola, Produto removido, Fiscal fiscal) {//Certo
        for (Produto produto : caixa.getArrayDoMonte()) {
            Produto alimenticio = caixa.pegarProdutoDoMonte(produto); //tem que por os pereciveis e não pereciveis
            if (!(alimenticio instanceof Alimenticio || alimenticio instanceof Perecivel || alimenticio instanceof NaoPerecivel)) {
                caixa.colocarProdutoNoMonte(alimenticio);
            }
            if (calculoPeso(caixa, sacola, alimenticio) == true) {
                fiscal.despachar(sacola);
                caixa.reporSacolas();
            }
        }
    }

    private void eletroPapelaria(Caixa caixa, Sacola sacola, Produto removido, Fiscal fiscal) {//Certo
        for (Produto produto : caixa.getArrayDoMonte()) {
            Produto eletronicoPapelaria = caixa.pegarProdutoDoMonte(produto);
            if (!(eletronicoPapelaria instanceof Eletroeletronico || eletronicoPapelaria instanceof Papelaria)) {
                caixa.colocarProdutoNoMonte(eletronicoPapelaria);
            }
            if (calculoPeso(caixa, sacola, eletronicoPapelaria) == true) {
                fiscal.despachar(sacola);
                caixa.reporSacolas();
            }
        }
    }

    private void cuidadosPessoais(Caixa caixa, Sacola sacola, Produto removido, Fiscal fiscal) {//Certo
        for (Produto produto : caixa.getArrayDoMonte()) {
            Produto cuidadoPessoal = caixa.pegarProdutoDoMonte(produto);
            if (!(cuidadoPessoal instanceof CuidadosPessoais || cuidadoPessoal instanceof Cosmetico || cuidadoPessoal instanceof Higiene)) {
                caixa.colocarProdutoNoMonte(cuidadoPessoal);
            }
            if (calculoPeso(caixa, sacola, cuidadoPessoal) == true) {
                fiscal.despachar(sacola);
                caixa.reporSacolas();
            }
        }
    }

    private void apenasLimpeza(Caixa caixa, Sacola sacola, Produto removido, Fiscal fiscal) { //certo
        for (Produto produto : caixa.getArrayDoMonte()) {
            Produto limpeza = caixa.pegarProdutoDoMonte(produto);
            if (!(limpeza instanceof Limpeza)) {
                caixa.colocarProdutoNoMonte(limpeza);
            }
            if (calculoPeso(caixa, sacola, limpeza) == true) {
                fiscal.despachar(sacola);
                caixa.reporSacolas();
            }
        }
    }

    private boolean sacolaAcimaDoPeso(Sacola sacola) {
        int pesoTotal = 0;
        for (Produto produto : sacola.getArrayDaSacola()) {
            pesoTotal += produto.getPeso();
        }
        if (pesoTotal >= 5000) {
            return true;
        } else {
            return false;
        }
    }

    private boolean sacolaAbaixoDoPeso(Sacola sacola) {
        int pesoTotal = 0;
        for (Produto produto : sacola.getArrayDaSacola()) {
            pesoTotal += produto.getPeso();
        }
        if (pesoTotal < 1000) {
            return true;
        } else {
            return false;
        }
    }

    private boolean calculoPeso(Caixa caixa, Sacola sacola, Produto removido) {
        while (sacolaAcimaDoPeso(sacola)) {
            sacola.pegarProdutoDaSacola(removido);
        }
        while (sacolaAbaixoDoPeso(sacola)) {
            sacola.colocarProdutoNaSacola(removido);
        }
        if (!sacolaAbaixoDoPeso(sacola) && !sacolaAcimaDoPeso(sacola)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean verificaTemp(Sacola sacola) {
        for (Produto produto1 : sacola.getArrayDaSacola()) {
            if (produto1 instanceof Refrigerado) {
                Refrigerado temp1 = (Refrigerado) produto1;
                for (Produto produto2 : sacola.getArrayDaSacola()) {
                    if (produto2 instanceof Refrigerado) {
                        Refrigerado temp2 = (Refrigerado) produto2;
                        if (Math.abs(temp1.getTemperaturaIdeal() - temp2.getTemperaturaIdeal()) > 15) {
                            return false; // Temperaturas muito diferentes
                        }
                    }
                }
            }
        }
        return true; // Todas as temperaturas estão dentro do limite
    }
}