package estudantes.entidades;

import professor.entidades.Caixa;
import professor.entidades.Fiscal;
import professor.entidades.Sacola;

import java.util.Enumeration;

public class Empacotador {
    public int proximoCaixa = 1;

    public void agir(Caixa caixa, Fiscal fiscal) {
        int numeroSacola = 1;
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
                proximoCaixa++;
                if (proximoCaixa > 5) {
                    proximoCaixa = 1;
                }
            }
            caixa.reporSacolas();

            if (!pesoCorreto(sacolaAtual)) {
                numeroSacola++;
                if (numeroSacola > 5) {
                    numeroSacola = 1;
                }
                return; // Finaliza a rodada para o próximo caixa e sacola
            }
            sacolaAtual = caixa.getSacola(numeroSacola); // Pega nova sacola
        }
    }


    private void processarRefrigerado(Produto produto, Caixa caixa, Fiscal fiscal) {
        Sacola sacola = caixa.getSacola(1);
        ajustarPesoESacola(produto, sacola);

        boolean tempOk = verificarTemperaturaSacola(sacola);

        if (sacola != null && pesoCorreto(sacola) && tempOk) {
            caixa.despacharSacola(1);
            fiscal.despachar(sacola);
        }
    }

    private void processarAlimenticio(Produto produto, Caixa caixa, Fiscal fiscal) {
        Sacola sacola = caixa.getSacola(2);
        ajustarPesoESacola(produto, sacola);

        if (sacola != null && pesoCorreto(sacola)) {
            caixa.despacharSacola(2);
            fiscal.despachar(sacola);
        }
    }

    private void processarCuidadosPessoais(Produto produto, Caixa caixa, Fiscal fiscal) {
        Sacola sacola = caixa.getSacola(3);
        ajustarPesoESacola(produto, sacola);

        if (sacola != null && pesoCorreto(sacola)) {
            caixa.despacharSacola(3);
            fiscal.despachar(sacola);
        }
    }

    private void processarEletroPapelaria(Produto produto, Caixa caixa, Fiscal fiscal) {
        Sacola sacola = caixa.getSacola(4);
        ajustarPesoESacola(produto, sacola);

        if (sacola != null && pesoCorreto(sacola)) {
            caixa.despacharSacola(4);
            fiscal.despachar(sacola);
        }
    }

    private void processarLimpeza(Produto produto, Caixa caixa, Fiscal fiscal) {
        Sacola sacola = caixa.getSacola(5);
        ajustarPesoESacola(produto, sacola);

        if (sacola != null && pesoCorreto(sacola)) {
            caixa.despacharSacola(5);
            fiscal.despachar(sacola);
        }
    }

    private void ajustarPesoESacola(Produto produto, Sacola sacola) {
        int pesoTotal = calcularPesoTotal(sacola);

        // Se a sacola estiver acima do peso
        if (pesoTotal >= 5000) {
            sacola.pegarProdutoDaSacola(produto);
        } else if (pesoTotal < 1000) {
            // Se a sacola estiver abaixo do peso
            sacola.colocarProdutoNaSacola(produto);
        }
    }

    private int calcularPesoTotal(Sacola sacola) {
        int pesoTotal = 0;
        for (Produto p : sacola.getArrayDaSacola()) {
            pesoTotal += p.getPeso();
        }
        return pesoTotal;
    }

    private boolean pesoCorreto(Sacola sacola) {
        int pesoTotal = calcularPesoTotal(sacola);
        return (pesoTotal >= 1000 && pesoTotal < 5000);
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
