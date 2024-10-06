package estudantes.entidades;

import professor.entidades.Caixa;
import professor.entidades.Fiscal;
import professor.entidades.Sacola;

public class Empacotador {
    public int proximoCaixa = 1;
    public Sacola sacolaAtual;

    public void agir(Caixa caixa, Fiscal fiscal) {
        int numeroSacola = 1;
        if (caixa.contarProdutosNoMonte() > 0) {
            sacolaAtual = caixa.getSacola(numeroSacola);
            for (Produto produto : caixa.getArrayDoMonte()) {
                Produto item = caixa.pegarProdutoDoMonte(produto);

                if (item instanceof Refrigerado) {
                    numeroSacola = processarRefrigerado(item, caixa, fiscal, numeroSacola);
                } else if (item instanceof Alimenticio || item instanceof Perecivel || item instanceof NaoPerecivel) {
                    numeroSacola = processarAlimenticio(item, caixa, fiscal, numeroSacola);
                } else if (item instanceof CuidadosPessoais || item instanceof Cosmetico ||
                         item instanceof Higiene) {
                    numeroSacola = processarCuidadosPessoais(item, caixa, fiscal, numeroSacola);
                }else if (item instanceof Eletroeletronico || item instanceof Papelaria){
                    numeroSacola = processarEletroPapelaria(item, caixa, fiscal, numeroSacola);
                } else if (item instanceof Limpeza) {
                    numeroSacola = processarLimpeza(item, caixa, fiscal, numeroSacola);
                }
                if (numeroSacola > 5) {
                    numeroSacola = 1;
                }
            }
        } else {
            proximoCaixa++;
            if (proximoCaixa > 5) {
                proximoCaixa = 1;
            }
        }
    }

    private int processarRefrigerado(Produto produto, Caixa caixa, Fiscal fiscal, int numeroSacola) {
        Sacola sacola = caixa.getSacola(1);
        ajustarPesoESacola(produto, sacola);

        boolean tempOk = verificarTemperaturaSacola(sacola);

        if (pesoCorreto(sacola) && tempOk && (sacola != null)) {
            fiscal.despachar(sacola);
            numeroSacola++;
        }
        return numeroSacola;
    }

    private int processarAlimenticio(Produto produto, Caixa caixa, Fiscal fiscal, int numeroSacola){
        Sacola sacola = caixa.getSacola(2);
        ajustarPesoESacola(produto, sacola);

        if (pesoCorreto(sacola) && (sacola != null)) {
            fiscal.despachar(sacola);
            numeroSacola++;
        }
        return numeroSacola;
    }

    private int processarCuidadosPessoais(Produto produto, Caixa caixa, Fiscal fiscal, int numeroSacola){
        Sacola sacola = caixa.getSacola(3);
        ajustarPesoESacola(produto, sacola);

        if (pesoCorreto(sacola) && (sacola != null)) {
            fiscal.despachar(sacola);
            numeroSacola++;
        }
        return numeroSacola;
    }

    private int processarEletroPapelaria(Produto produto, Caixa caixa, Fiscal fiscal, int numeroSacola){
        Sacola sacola = caixa.getSacola(4);
        ajustarPesoESacola(produto, sacola);

        if (pesoCorreto(sacola) && (sacola != null)) {
            fiscal.despachar(sacola);
            numeroSacola++;
        }
        return numeroSacola;
    }

    private int processarLimpeza(Produto produto, Caixa caixa, Fiscal fiscal, int numeroSacola){
        Sacola sacola = caixa.getSacola(5);
        ajustarPesoESacola(produto, sacola);

        if (pesoCorreto(sacola) && (sacola != null)) {
            fiscal.despachar(sacola);
            numeroSacola++;
        }
        return numeroSacola;
    }

    private void ajustarPesoESacola(Produto produto, Sacola sacola) {
        int pesoTotal = calcularPesoTotal(sacola);

        // Enquanto a sacola estiver acima do peso
        if (pesoTotal >= 5000) {
            sacola.pegarProdutoDaSacola(produto);
            //pesoTotal = calcularPesoTotal(sacola);


            // Enquanto a sacola estiver abaixo do peso
        } else if (pesoTotal < 1000) {
            sacola.colocarProdutoNaSacola(produto);
            //pesoTotal = calcularPesoTotal(sacola);
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