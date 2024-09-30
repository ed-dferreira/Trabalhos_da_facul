package Produto;

public class Refrigerado extends Perecivel {
    private int temperaturaIdeal;

    public Refrigerado(int codigo, String nome, String fabricante, int peso, long validade, int temperaturaIdeal) {
        super(codigo, nome, fabricante, peso, validade);
        this.temperaturaIdeal = temperaturaIdeal;
    }

    public int getTemperaturaIdeal() {
        return temperaturaIdeal;
    }

    @Override
    public String toString() {
        return "Refrigerado {" +
                "Código: " + getCodigo() +
                ", Nome: '" + getNome() + '\'' +
                ", Fabricante: '" + getFabricante() + '\'' +
                ", Peso: " + getPeso() + "g" +
                ", Validade: " + getValidade() +
                ", Temperatura Ideal: " + temperaturaIdeal + "°C" +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Refrigerado refrigerado = (Refrigerado) obj;
        return getCodigo() == refrigerado.getCodigo() &&
                getValidade() == refrigerado.getValidade() &&
                temperaturaIdeal == refrigerado.temperaturaIdeal;
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(getCodigo());
        result = 31 * result + Long.hashCode(getValidade());
        result = 31 * result + Integer.hashCode(temperaturaIdeal);
        return result;
    }
}
