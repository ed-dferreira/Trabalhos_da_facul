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
        ensacolarProdutos(caixa, fiscal);
    }


    private void ensacolarProdutos(Caixa caixa, Fiscal fiscal) {
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
            }
        }
        proximoCaixa++;
        if(proximoCaixa > 5){
            proximoCaixa = 1;
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
            if (calculoPeso(caixa, sacola, refrigerado) == true && verificaTemp(sacola) == true && sacola != null) {
                fiscal.despachar(sacola);
            }
        }
    }

    private void apenasAlimenticios(Caixa caixa, Sacola sacola, Produto removido, Fiscal fiscal) {//Certo
        for (Produto produto : caixa.getArrayDoMonte()) {
            Produto alimenticio = caixa.pegarProdutoDoMonte(produto); //tem que por os pereciveis e não pereciveis
            if (!(alimenticio instanceof Alimenticio || alimenticio instanceof Perecivel || alimenticio instanceof NaoPerecivel)) {
                caixa.colocarProdutoNoMonte(alimenticio);
            }
            if (calculoPeso(caixa, sacola, alimenticio) == true && sacola != null) {
                fiscal.despachar(sacola);
            }
        }
    }

    private void eletroPapelaria(Caixa caixa, Sacola sacola, Produto removido, Fiscal fiscal) {//Certo
        for (Produto produto : caixa.getArrayDoMonte()) {
            Produto eletronicoPapelaria = caixa.pegarProdutoDoMonte(produto);
            if (!(eletronicoPapelaria instanceof Eletroeletronico || eletronicoPapelaria instanceof Papelaria ||
                    eletronicoPapelaria instanceof CuidadosPessoais ||  eletronicoPapelaria instanceof Cosmetico ||
                    eletronicoPapelaria instanceof Higiene)) {
                caixa.colocarProdutoNoMonte(eletronicoPapelaria);
            }
            if (calculoPeso(caixa, sacola, eletronicoPapelaria) == true && sacola != null) {
                fiscal.despachar(sacola);
            }
        }
    }

    private void cuidadosPessoais(Caixa caixa, Sacola sacola, Produto removido, Fiscal fiscal) {//Certo
        for (Produto produto : caixa.getArrayDoMonte()) {
            Produto cuidadoPessoal = caixa.pegarProdutoDoMonte(produto);
            if (!(cuidadoPessoal instanceof CuidadosPessoais || cuidadoPessoal instanceof Cosmetico || cuidadoPessoal instanceof Higiene)) {
                caixa.colocarProdutoNoMonte(cuidadoPessoal);
            }
            if (calculoPeso(caixa, sacola, cuidadoPessoal) == true && sacola != null) {
                fiscal.despachar(sacola);
            }
        }
    }

    private void apenasLimpeza(Caixa caixa, Sacola sacola, Produto removido, Fiscal fiscal) { //certo
        for (Produto produto : caixa.getArrayDoMonte()) {
            Produto limpeza = caixa.pegarProdutoDoMonte(produto);
            if (!(limpeza instanceof Limpeza)) {
                caixa.colocarProdutoNoMonte(limpeza);
            }
            if (calculoPeso(caixa, sacola, limpeza) == true && sacola != null) {
                fiscal.despachar(sacola);
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