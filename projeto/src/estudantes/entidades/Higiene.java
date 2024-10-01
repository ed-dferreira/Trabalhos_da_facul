package estudantes.entidades;

public class Higiene extends CuidadosPessoais {
    public Higiene(int codigo, String nome, String fabricante, int peso, long validade, String fragancia) {
        super(codigo, nome, fabricante, peso, validade, fragancia);
    }

    @Override
    public String toString() {
        return "Higiene {" +
                "Código: " + getCodigo() +
                ", Nome: '" + getNome() + '\'' +
                ", Fabricante: '" + getFabricante() + '\'' +
                ", Peso: " + getPeso() + "g" +
                ", Validade: " + getValidade() + // Se 'validade' for um atributo, considere fazer um getter na classe pai.
                ", Fragrância: '" + getFragancia() + '\'' + // Se 'fragancia' for um atributo, considere fazer um getter na classe pai.
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Higiene higiene = (Higiene) obj;
        return getCodigo() == higiene.getCodigo() &&
                getValidade() == higiene.getValidade() &&
                getFragancia().equals(higiene.getFragancia());
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(getCodigo());
        result = 31 * result + Long.hashCode(getValidade());
        result = 31 * result + getFragancia().hashCode();
        return result;
    }
}