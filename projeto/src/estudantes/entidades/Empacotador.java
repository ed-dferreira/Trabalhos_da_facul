package estudantes.entidades;

import professor.entidades.Caixa;
import professor.entidades.Fiscal;
import professor.entidades.Sacola;
import professor.entidades.Supermercado; // Certifique-se de importar a classe Supermercado


import java.util.Enumeration;

public class Empacotador {
    public int proximoCaixa = 1;
    public void agir(Caixa caixa, Fiscal fiscal) {
        int numeroSacola = 1;
        while (caixa.contarProdutosNoMonte() > 0) {
            Sacola sacolaAtual = caixa.getSacola(numeroSacola);
            for (Produto produto : caixa.getArrayDoMonte()) {
                Produto item = caixa.pegarProdutoDoMonte(produto);
                if (item instanceof Refrigerado) {
                    processarRefrigerado(item, caixa, fiscal);
                } else if (item instanceof Alimenticio || item instanceof Perecivel || item instanceof NaoPerecivel) {
                    processarAlimenticio(item, caixa, fiscal);
                } else if (item instanceof CuidadosPessoais || item instanceof Cosmetico || item instanceof Higiene) {
                    processarCuidadosPessoais(item, caixa, fiscal);
                } else if (item instanceof Eletroeletronico || item instanceof Papelaria) {
                    processarEletroPapelaria(item, caixa, fiscal);
                } else if (item instanceof Limpeza) {
                    processarLimpeza(item, caixa, fiscal);
                }
                if (caixa.contarProdutosNoMonte() == 0) {
                    caixa.reporSacolas();
                }
                if (caixa.contarProdutosNoMonte() == 0) {
                    proximoCaixa++;
                    if (proximoCaixa == 6) {
                        proximoCaixa = 1;

                    }
                }
                numeroSacola++;
                if (numeroSacola > 5) {
                    numeroSacola = 1;
                }
                return;
            }
        }
    }

    private void processarRefrigerado(Produto produto, Caixa caixa, Fiscal fiscal) {
        Sacola sacola = caixa.getSacola(1);
        ajustarPesoESacola(caixa, produto, sacola);

        boolean tempOk = verificarTemperaturaSacola(sacola);

        if (sacola != null && tempOk) {
            fiscal.despachar(caixa.getSacola(1));
        }
    }

    private void processarAlimenticio(Produto produto, Caixa caixa, Fiscal fiscal) {
        Sacola sacola = caixa.getSacola(2);
        ajustarPesoESacola(caixa, produto, sacola);

        if (sacola != null ){
            fiscal.despachar(caixa.getSacola(2));
        }
    }

    private void processarCuidadosPessoais(Produto produto, Caixa caixa, Fiscal fiscal) {
        Sacola sacola = caixa.getSacola(3);
        ajustarPesoESacola(caixa, produto, sacola);

        if (sacola != null ){
            fiscal.despachar(caixa.getSacola(3));
        }
    }

    private void processarEletroPapelaria(Produto produto, Caixa caixa, Fiscal fiscal) {
        Sacola sacola = caixa.getSacola(4);
        ajustarPesoESacola(caixa, produto, sacola);

        if (sacola != null ){
            fiscal.despachar(caixa.getSacola(4));
        }
    }

    private void processarLimpeza(Produto produto, Caixa caixa, Fiscal fiscal) {
        Sacola sacola = caixa.getSacola(5);
        ajustarPesoESacola(caixa, produto, sacola);

        if (sacola != null ){
            fiscal.despachar(caixa.getSacola(5));
        }
    }

    private void ajustarPesoESacola(Caixa caixa, Produto produto, Sacola sacola) {
        int pesoTotal;
        // Ajustar peso e sacola enquanto necessário
        do {
            pesoTotal = 0;

            // Calcular peso total da sacola
            for (Produto p : sacola.getArrayDaSacola()) {
                pesoTotal += p.getPeso();
            }

            // Se a sacola estiver acima do peso
            if (pesoTotal > 5000) {
                sacola.pegarProdutoDaSacola(produto);
                caixa.colocarProdutoNoMonte(produto);

            }
            // Se a sacola estiver abaixo do peso
            else if (pesoTotal < 1500) {
                caixa.pegarProdutoDoMonte(produto);
                sacola.colocarProdutoNaSacola(produto);
            }

        } while (pesoTotal > 5000 || pesoTotal < 1500);
    }

    private boolean verificarTemperaturaSacola(Sacola sacola) {
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
        return true;
    }
}
