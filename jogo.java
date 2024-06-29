package MAIUSCULAS_vs_minusculas;
import java.util.Scanner;
public class jogo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.close();
        System.out.println("Hi");
    }
}

/*
 * Alternativa 2: MAIÚSCULAS vs. minúscula
 * Você deve criar um programa para um jogo que ocorre em uma matriz 3 x 3
representando um lago onde duas cidades competem para construir uma ponte: a cidade das
letras MAIÚSCULAS quer a ponte formada por suas letras e a cidade das letras minúsculas,
por sua vez, quer a ponte formada por suas letras. Os números não gostam de se envolver
com construção civil e preferiram ficar fora dessa disputa. Embora essa ponte vá ser usada
por todas as letras, a obra de engenharia executada por uma cidade ou outra vai servir como
demonstração de competência profissional para as gerações de letras futuras.

Cada jogadora representa uma engenheira das cidades e tem o objetivo de formar uma
sequência de 3 letras do tipo da cidade que representa para que a ponte seja construída.

O estado inicial do jogo é completamente vazio. A jogadora das minúsculas joga
sempre primeiro, colocando uma letra qualquer em um espaço qualquer do lago. Depois
disso, a jogadora das MAIÚSCULA pode escolher colocar uma letra em um espaço não
ocupado do lago ou colocar uma letra MAIÚSCULA superior sobre um espaço de uma letra
minúscula que já está no lago (veja os detalhes abaixo). Depois, a jogadora das minúsculas
pode escolher colocar uma letra em um espaço não ocupado ou colocar uma letra minúscula
superior sobre um espaço de uma letra MAIÚSCULA que já está no lago. O jogo segue
dessa forma na alternância de turnos entre as jogadoras. Depois que uma jogadora usa uma
letra, ela não pode usar aquela letra novamente.

Uma jogadora ganha quando completar uma sequência de 3 letras que controla na
horizontal, na vertical ou na diagonal.

O uso de letras com diacríticos (sinais gráficos que alteram o papel ou a fonética das
letras) não é permitido, ou seja, nada de acentos circunflexos (letras com chapéu), til (letras
com penteado estravagante), cedilha (letras com rabinho) etc

Uma letra superior é aquela localizada mais para o final do alfabeto. Por exemplo:
• M é superior a F
• B é inferior a D
• Z é superior a todas as outras letras (então use-o com sabedoria).

Em um exemplo de jogada, se fosse a vez das MAIÚSCULAS jogarem e o estado do
lago fosse a referência a seguir (hifens representam os espaços vazios), então elas poderiam
ganhar colocando 'Z' sobre 'y'

FUNCIONALIDADE BÔNUS

Deve ser possível salvar o estado do jogo em um arquivo de texto que guarda na
primeira linha a letra da jogadora que deve fazer a próxima jogada (a letra 'M' se for a
jogadora das MAIÚSCULAS ou 'm' se for a jogadora das minúsculas), depois uma linha
contendo a sequência de letras minúsculas já usadas e uma linha contendo a sequência de
letras maiúsculas usadas. O arquivo ainda tem outras 3 linhas de caracteres que representam
o estado do jogo, sendo:
 
Qualquer letra maiúscula para as posições da cidade das MAIÚSCULAS
Qualquer letra minuscula para as posições da cidade das minúsculas
'-' para as posições vazias

Exemplo de arquivo:

M
ahdbzy
GTFWZ
aZy
dzW
-T
*/
