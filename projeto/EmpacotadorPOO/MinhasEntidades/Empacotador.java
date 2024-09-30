package MinhasEntidades;

import entidades.*;

/**
 * Classe que traz a lógica do algoritmo de "ensacolamento" dos produtos.
 * <br><br>
 * Você pode incluir novos atributos e métodos nessa classe para criar
 * lógicas mais complexas para o gerenciamento empacotamento de produtos,
 * mas esses <strong>atributos e métodos devem ser todos privados</strong>.
 * O único método público deve ser "agir".
 *
 * @author Jean Cheiran
 * @version 1.0
 */
public class Empacotador {

    public int proximoCaixa = 1; //usada para saber para onde o empacotador deve ir

    /**
     * Executa a lógica de empacotamento e troca de caixa.
     * Esse método é o único método de controle invocado durante a simulação
     * do supermercado.
     * <br><br>
     * Aqui podem ser feitas todas as verificações sobre os produtos no monte e
     * nas sacolas do caixa em que o empacotador está. A partir dessas informações,
     * você pode colocar produtos do monte daquele caixa em sacolas e despachar
     * sacolas para o fiscal.
     * <br><br>
     * O atributo "proximoCaixa" é usado pelo simulador para mover o empacotador
     * para outro caixa (ou permanecer no mesmo se ele quiser), ou seja, o
     * empacotador sempre vai para o caixa do número indicado nesse atributo
     * após um ciclo de simulação.
     * <br><br>
     * <strong>O empacotador não pode levar produtos com ele</strong> de um
     * caixa para outro, ou seja, você não deve criar atributos com vetores,
     * matrizes ou coleções (ArrayList, HashSet etc.) de produtos.
     * @param caixa o caixa onde está o empacotador
     * @param fiscal fiscal que pode ser consultado sobre as sacolas despachadas
     */
    public void agir(Caixa caixa, Fiscal fiscal){

    }

}

//Duas coisas são críticas na avaliação da eficiência: quantidade total de produtos
//transportados e evitar desperdício de espaço nas sacolas. Assim, transportar 4 produtos de
//peso 1200 gramas em apenas uma sacola é mais eficiente do que transportar os mesmos 4
//produtos em 4 sacolas diferentes.

//5 caixas de supermercado
// O empacotador pode pegar um produto de
//um monte do caixa (que não está em qualquer ordem particular) e colocar em uma sacola
//que esteja aberta naquele caixa.

//Esse empacotador pode também dispensar uma sacola para
//o fiscal transportar ela para o caminhão, liberando o espaço para uma nova sacola vazia
//naquele caixa que será reposta apenas quando ele trocar de caixa. Os produtos dos montes
//serão repostos apenas quando todos os caixas estiverem sem produtos nos montes.

//As regras de dispensa de produtos do supermercado precisam ser cumpridas e visam não
//misturar certos produtos para evitar contaminação, aproveitar o frio de produtos refrigerados
//e seguir normas sanitárias do governo. Por exemplo, produtos de cuidados pessoais não
//podem ser colocados em sacolas com produtos alimentícios de qualquer natureza. Produtos
//de limpeza não podem dividir a sacola com produtos alimentícios, eletroeletrônicos ou
//cuidados pessoais. E, finalmente, produtos refrigerados só podem ser colocados junto de
//outros produtos refrigerados cujas temperaturas não tenham grande diferença (é aceitável,
//no máximo, 15 graus de diferença para mais ou para menos entre quaisquer dois produtos na
//sacola). Descumprir essas regras causa a fúria do fiscal e advertências trabalhistas.
//Cada caixa do supermercado pode manter até cinco sacolas abertas para colocação de
//compras pelo empacotador. Ainda, uma informação de extrema importância é que cada
//sacola suporta, no máximo, 5 quilos (5000 gramas) de produtos. Colocar peso acima do
//limite faz com que a sacola rasgue, os produtos sejam perdidos e uma advertência trabalhista
//seja gerada, embora a sacola seja imediatamente substituída por outra vazia.
//Finalmente, esbanjar sacolas pode gerar advertências também. É esperado que nenhuma
//sacola seja dispensada com menos de 1 quilo (1000 gramas) de produtos dentro.
