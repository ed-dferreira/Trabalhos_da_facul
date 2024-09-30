package Produto;

public class Eletroeletronico extends Produto {
    private short tensao;
    public Eletroeletronico(int codigo, String nome, String fabricante, int peso, short tensao) {
        super(codigo, nome, fabricante, peso);
        this.tensao = tensao;
    }
    @Override
    public String toString() {
        return "Eletroeletrônico {" +
                "Código: " + getCodigo() +
                ", Nome: '" + getNome() + '\'' +
                ", Fabricante: '" + getFabricante() + '\'' +
                ", Peso: " + getPeso() + "g" +
                ", Tensão: " + tensao + "V" +
                '}';
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Eletroeletronico that = (Eletroeletronico) obj;
        return getCodigo() == that.getCodigo();
    }
    @Override
    public int hashCode() {
        return Integer.hashCode(getCodigo());
    }
}