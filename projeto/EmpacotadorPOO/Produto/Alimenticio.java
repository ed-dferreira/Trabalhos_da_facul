package Produto;

public class Alimenticio extends Produto {
    private long validade;

    public Alimenticio(int codigo, String nome, String fabricante, int peso, long validade) {
        super(codigo, nome, fabricante, peso);
        this.validade = validade;
    }

    public long getValidade() {
        return validade;
    }

    @Override
    public String toString() {
        return super.toString() + ", Validade: " + validade;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Verifica se é o mesmo objeto
        if (obj == null || getClass() != obj.getClass()) return false; // Verifica a classe
        Alimenticio produto = (Alimenticio) obj;
        return this.getCodigo() == produto.getCodigo(); // Compara o código do produto
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(getCodigo()); // Gera o hash com base no código
    }
}
