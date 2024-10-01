package estudantes.entidades;

public class Perecivel extends Alimenticio {
    public Perecivel(int codigo, String nome, String fabricante, int peso, long validade) {
        super(codigo, nome, fabricante, peso, validade);
    }

    @Override
    public String toString() {
        return "Perecivel {" +
                "Código: " + getCodigo() +
                ", Nome: '" + getNome() + '\'' +
                ", Fabricante: '" + getFabricante() + '\'' +
                ", Peso: " + getPeso() + "g" +
                ", Validade: " + getValidade() +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Perecivel perecivel = (Perecivel) obj;
        return getCodigo() == perecivel.getCodigo() && getValidade() == perecivel.getValidade();
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(getCodigo());
        result = 31 * result + Long.hashCode(getValidade());
        return result;
    }
}