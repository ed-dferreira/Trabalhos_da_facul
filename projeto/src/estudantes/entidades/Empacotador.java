package estudantes.entidades;

import professor.entidades.Caixa;
import professor.entidades.Fiscal;
import professor.entidades.Sacola;

import java.util.Enumeration;

public class Empacotador {
    public int proximoCaixa = 1;

    public void agir(Caixa caixa, Fiscal fiscal) {
        int numeroSacola = 1;

        if (caixa.contarProdutosNoMonte() > 0) {
            for (Produto produto : caixa.getArrayDoMonte()) {
                Sacola sacolaAtual = caixa.getSacola(numeroSacola);
                Produto item = caixa.pegarProdutoDoMonte(produto);
                if (item instanceof Refrigerado) {
                    processarRefrigerado(item, caixa, fiscal, sacolaAtual);
                    numeroSacola++;
                } else if (item instanceof Alimenticio || item instanceof Perecivel || item instanceof NaoPerecivel) {
                    processarAlimenticio(item, caixa, fiscal, sacolaAtual);
                    numeroSacola++;
                } else if (item instanceof CuidadosPessoais || item instanceof Cosmetico || item instanceof Higiene) {
                    processarCuidadosPessoais(item, caixa, fiscal, sacolaAtual);
                    numeroSacola++;
                } else if (item instanceof Eletroeletronico || item instanceof Papelaria) {
                    processarEletroPapelaria(item, caixa, fiscal, sacolaAtual);
                    numeroSacola++;
                } else if (item instanceof Limpeza) {
                    processarLimpeza(item, caixa, fiscal, sacolaAtual);
                    numeroSacola++;
                }
                if (numeroSacola == 5){
                    numeroSacola = 1;
                }

            }
        }
    }


    private void processarRefrigerado(Produto item, Caixa caixa, Fiscal fiscal, Sacola sacolaAtual) {
        ajustarPesoESacola(item, sacolaAtual);

        boolean tempOk = verificarTemperaturaSacola(sacolaAtual);

        if (sacolaAtual != null && pesoCorreto(sacolaAtual) && tempOk) {
            fiscal.despachar(sacolaAtual);
            caixa.reporSacolas();
        }
    }

    private void processarAlimenticio(Produto item, Caixa caixa, Fiscal fiscal, Sacola sacolaAtual) {

        ajustarPesoESacola(item, sacolaAtual);

        if (sacolaAtual != null && pesoCorreto(sacolaAtual)) {
            fiscal.despachar(sacolaAtual);
            caixa.reporSacolas();
        }
    }

    private void processarCuidadosPessoais(Produto item, Caixa caixa, Fiscal fiscal, Sacola sacolaAtual) {

        ajustarPesoESacola(item, sacolaAtual);

        if (sacolaAtual != null && pesoCorreto(sacolaAtual)) {
            fiscal.despachar(sacolaAtual);
            caixa.reporSacolas();
        }
    }

    private void processarEletroPapelaria(Produto item, Caixa caixa, Fiscal fiscal, Sacola sacolaAtual) {

        ajustarPesoESacola(item, sacolaAtual);

        if (sacolaAtual != null && pesoCorreto(sacolaAtual)) {
            fiscal.despachar(sacolaAtual);
            caixa.reporSacolas();
        }
    }

    private void processarLimpeza(Produto item, Caixa caixa, Fiscal fiscal, Sacola sacolaAtual) {

        ajustarPesoESacola(item, sacolaAtual);

        if (sacolaAtual != null && pesoCorreto(sacolaAtual)) {
            //caixa.despacharSacola(sacolaAtual);
            fiscal.despachar(sacolaAtual);
            caixa.reporSacolas();
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


/*
                    if (item instanceof Refrigerado) {
                        sacolaAtual.colocarProdutoNaSacola(item);
                        ajustarPesoESacola(item, sacolaAtual);
                        boolean tempOk = verificarTemperaturaSacola(sacolaAtual);
                        if (sacolaAtual != null && pesoCorreto(sacolaAtual) && tempOk) {
                            caixa.despacharSacola(1);
                            fiscal.despachar(sacolaAtual);
                            caixa.reporSacolas();
                        }
                    } else if (item instanceof Alimenticio || item instanceof Perecivel || item instanceof NaoPerecivel) {
                        sacolaAtual.colocarProdutoNaSacola(item);
                        ajustarPesoESacola(item, sacolaAtual);
                        if (sacolaAtual != null && pesoCorreto(sacolaAtual)) {
                            caixa.despacharSacola(1);
                            fiscal.despachar(sacolaAtual);
                            caixa.reporSacolas();
                        }
                    } else if (item instanceof CuidadosPessoais || item instanceof Cosmetico || item instanceof Higiene) {
                        sacolaAtual.colocarProdutoNaSacola(item);
                        ajustarPesoESacola(item, sacolaAtual);
                        if (sacolaAtual != null && pesoCorreto(sacolaAtual)) {
                            caixa.despacharSacola(1);
                            fiscal.despachar(sacolaAtual);
                            caixa.reporSacolas();
                        }
                    } else if (item instanceof Eletroeletronico || item instanceof Papelaria) {
                        sacolaAtual.colocarProdutoNaSacola(item);
                        ajustarPesoESacola(item, sacolaAtual);
                        if (sacolaAtual != null && pesoCorreto(sacolaAtual)) {
                            caixa.despacharSacola(1);
                            fiscal.despachar(sacolaAtual);
                            caixa.reporSacolas();
                        }
                    } else if (item instanceof Limpeza) {
                        sacolaAtual.colocarProdutoNaSacola(item);
                        ajustarPesoESacola(item, sacolaAtual);
                        if (sacolaAtual != null && pesoCorreto(sacolaAtual)) {
                            caixa.despacharSacola(1);
                            fiscal.despachar(sacolaAtual);
                            caixa.reporSacolas();
                        }
                    }
 */