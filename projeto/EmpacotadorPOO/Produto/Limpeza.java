package Produto;

public class Limpeza extends Produto {
    public Limpeza(int codigo, String nome, String fabricante, int peso) {
        super(codigo, nome, fabricante, peso);
    }

    @Override
    public String toString() {
        return "Limpeza {" +
                "Código: " + getCodigo() +
                ", Nome: '" + getNome() + '\'' +
                ", Fabricante: '" + getFabricante() + '\'' +
                ", Peso: " + getPeso() + "g" +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Limpeza limpeza = (Limpeza) obj;
        return getCodigo() == limpeza.getCodigo();
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(getCodigo());
    }
}
