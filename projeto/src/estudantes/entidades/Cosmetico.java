package estudantes.entidades;

public class Cosmetico extends CuidadosPessoais {
    private char tipoDePele;

    public Cosmetico(int codigo, String nome, String fabricante, int peso, long validade, String fragancia, char tipoDePele) {
        super(codigo, nome, fabricante, peso, validade, fragancia);
        this.tipoDePele = tipoDePele;
    }

    public char getTipoDePele() {
        return tipoDePele;
    }

    @Override
    public String toString() {
        return "Cosmetico {" +
                "Código: " + getCodigo() +
                ", Nome: '" + getNome() + '\'' +
                ", Fabricante: '" + getFabricante() + '\'' +
                ", Peso: " + getPeso() + "g" +
                ", Validade: " + getValidade() + // Usando o getter da classe pai
                ", Fragrância: '" + getFragancia() + '\'' + // Usando o getter da classe pai
                ", Tipo de Pele: " + tipoDePele +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cosmetico cosmetico = (Cosmetico) obj;
        return getCodigo() == cosmetico.getCodigo();
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(getCodigo());
    }
}
