package Produto;

public class Papelaria extends Produto {
    public Papelaria(int codigo, String nome, String fabricante, int peso) {
        super(codigo, nome, fabricante, peso);
    }

    @Override
    public String toString() {
        return "Papelaria {" +
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
        Papelaria papelaria = (Papelaria) obj;
        return getCodigo() == papelaria.getCodigo();
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(getCodigo());
    }
}