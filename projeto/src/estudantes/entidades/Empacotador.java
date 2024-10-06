package estudantes.entidades;

import professor.entidades.Fiscal;
import professor.entidades.Caixa;
import professor.entidades.Sacola;

public class Empacotador {
    public int proximoCaixa = 1;

    public void agir(Caixa caixa, Fiscal fiscal) {
        for (int e = 0; e < 100; e++){
            int numeroSacola = 1;
            if (caixa.contarProdutosNoMonte() > 0) {
                if (proximoCaixa == 5) {
                    proximoCaixa = 1;
                }
                proximoCaixa++;
                Sacola sacolaAtual = caixa.getSacola(numeroSacola);
                for (Produto produto : caixa.getArrayDoMonte()) {
                    Produto item = caixa.pegarProdutoDoMonte(produto);

                    if (item instanceof Refrigerado) {
                        processarRefrigerado(item, caixa, fiscal);
                    } else if (item instanceof Alimenticio || item instanceof Perecivel || item instanceof NaoPerecivel) {
                        processarAlimenticio(item, caixa, fiscal);
                    } else if (item instanceof Eletroeletronico || item instanceof Papelaria ||
                            item instanceof CuidadosPessoais || item instanceof Cosmetico ||
                            item instanceof Higiene) {
                        processarEletroPapelariaCuidadosPessoais(item, caixa, fiscal);
                    } else if (item instanceof Limpeza) {
                        processarLimpeza(item, caixa, fiscal);
                    } else {
                        // Se o produto não se encaixa em nenhuma das categorias
                        caixa.colocarProdutoNoMonte(item);
                    }
                }
                if (numeroSacola > 5) {
                    numeroSacola = 1;
                }
                numeroSacola++;
            } else {
                if (proximoCaixa > 5) {
                    proximoCaixa = 1;
                }
                proximoCaixa++;
            }
        }
    }
    private void processarRefrigerado(Produto produto, Caixa caixa, Fiscal fiscal) {
        Sacola sacola = caixa.getSacola(1);
        ajustarPesoESacola(produto, sacola);

        boolean tempOk = verificarTemperaturaSacola(sacola);

        if (pesoCorreto(sacola) && tempOk && (sacola != null)) {
            fiscal.despachar(sacola);
        }
    }

    private void processarAlimenticio(Produto produto, Caixa caixa, Fiscal fiscal) {
        Sacola sacola = caixa.getSacola(2);
        ajustarPesoESacola(produto, sacola);

        if (pesoCorreto(sacola) && (sacola != null)) {
            fiscal.despachar(sacola);
        }
    }

    private void processarEletroPapelariaCuidadosPessoais(Produto produto, Caixa caixa, Fiscal fiscal) {
        Sacola sacola = caixa.getSacola(3);
        ajustarPesoESacola(produto, sacola);

        if (pesoCorreto(sacola) && (sacola != null)) {
            fiscal.despachar(sacola);
        }
    }

    private void processarLimpeza(Produto produto, Caixa caixa, Fiscal fiscal) {
        Sacola sacola = caixa.getSacola(4);
        ajustarPesoESacola(produto, sacola);

        if (pesoCorreto(sacola) && (sacola != null)) {
            fiscal.despachar(sacola);
        }
    }

    private void ajustarPesoESacola(Produto produto, Sacola sacola) {
        int pesoTotal = calcularPesoTotal(sacola);

        // Enquanto a sacola estiver acima do peso
        while (pesoTotal >= 5000) {
            sacola.pegarProdutoDaSacola(produto);
            pesoTotal = calcularPesoTotal(sacola);
        }

        // Enquanto a sacola estiver abaixo do peso
        while (pesoTotal < 1000) {
            sacola.colocarProdutoNaSacola(produto);
            pesoTotal = calcularPesoTotal(sacola);
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
