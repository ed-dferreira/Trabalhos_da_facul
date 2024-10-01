package estudantes.entidades;

public class CuidadosPessoais extends Produto {
    private long validade;
    private String fragancia;

    public CuidadosPessoais(int codigo, String nome, String fabricante, int peso, long validade, String fragancia) {
        super(codigo, nome, fabricante, peso);
        this.validade = validade;
        this.fragancia = fragancia;
    }

    public long getValidade() {
        return validade;
    }

    public String getFragancia() {
        return fragancia;
    }

    @Override
    public String toString() {
        return "CuidadosPessoais {" +
                "Código: " + getCodigo() +
                ", Nome: '" + getNome() + '\'' +
                ", Fabricante: '" + getFabricante() + '\'' +
                ", Peso: " + getPeso() + "g" +
                ", Validade: " + validade +
                ", Fragrância: '" + fragancia + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CuidadosPessoais that = (CuidadosPessoais) obj;
        return getCodigo() == that.getCodigo() && fragancia.equals(that.fragancia);
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(getCodigo());
        result = 31 * result + fragancia.hashCode();
        return result;
    }
}
