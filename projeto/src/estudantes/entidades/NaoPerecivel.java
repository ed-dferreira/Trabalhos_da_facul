package estudantes.entidades;

public class NaoPerecivel extends Alimenticio {
    private String tipoDeArmazenamento;

    public NaoPerecivel(int codigo, String nome, String fabricante, int peso, long validade, String tipoDeArmazenamento) {
        super(codigo, nome, fabricante, peso, validade);
        this.tipoDeArmazenamento = tipoDeArmazenamento;
    }

    public String getTipoDeArmazenamento() {
        return tipoDeArmazenamento;
    }

    @Override
    public String toString() {
        return "NaoPerecivel {" +
                "Código: " + getCodigo() +
                ", Nome: '" + getNome() + '\'' +
                ", Fabricante: '" + getFabricante() + '\'' +
                ", Peso: " + getPeso() + "g" +
                ", Validade: " + getValidade() +
                ", Tipo de Armazenamento: '" + tipoDeArmazenamento + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        NaoPerecivel naoPerecivel = (NaoPerecivel) obj;
        return getCodigo() == naoPerecivel.getCodigo() &&
                getValidade() == naoPerecivel.getValidade() &&
                tipoDeArmazenamento.equals(naoPerecivel.tipoDeArmazenamento);
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(getCodigo());
        result = 31 * result + Long.hashCode(getValidade());
        result = 31 * result + tipoDeArmazenamento.hashCode();
        return result;
    }
}
