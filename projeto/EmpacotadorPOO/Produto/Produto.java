package Produto;

/**
 * Classe que define um produto no supermercado.
 * <br><br>
 * Essa classe pode ser estendida. Adicionalmente, ela deve:
 * <br><br>
 * 1) ter um construtor completo,<br>
 * 2) implementar métodos de acesso (getters), sendo que métodos de modificação
 * (setters) NÃO devem ser implementados,<br>
 * 3) sobre-escrever os métodos toString, equals e hashCode,<br>
 * 4) ter um JavaDoc útil e completo.
 * <br><br>
 * <strong>Não devem ser criados métodos adicionais nessa classe.</strong>
 *
 * @author Jean Cheiran
 * @version 1.0
 */

public class Produto {

    // Atributos do produto
    private int codigo;
    private String nome;
    private String fabricante;
    private int peso;

    public Produto(int codigo, String nome, String fabricante, int peso) {
        this.codigo = codigo;
        this.nome = nome;
        this.fabricante = fabricante;
        this.peso = peso;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getFabricante() {
        return fabricante;
    }

    public int getPeso() {
        return peso;
    }

    @Override
    public String toString() {
        return "Produto {" +
                "Código: " + codigo +
                ", Nome: '" + nome + '\'' +
                ", Fabricante: '" + fabricante + '\'' +
                ", Peso: " + peso + "g" +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Produto produto = (Produto) obj;
        return codigo == produto.codigo;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(codigo);
    }
}