package professor.entidades;

import estudantes.entidades.*;
import java.util.Random;
import professor.gui.Simulador;

/**
 * Classe que representa o supermercado com seus caixas, fiscal e empacotador.
 * <br><br>
 * <strong>Não mexa aqui!!!</strong>
 * 
 * @author Jean Cheiran
 * @version 1.0
 */
public class Supermercado {
    private static final String NOMES[] = {"Xalobax Max", "Vifrex Forte", "Kratolu Nutra", "Qutrasil Flex", "Trovonex Supra", "Lubrimar Z-Force", "Zirbel Crunch", "Fraxonim Duo", "Nubatex Light", "Gluptonix Soft", "Redonix Prime", "Timbalex Forte", "Luxorvit Energy", "Braltine Q7", "Morvex Pura", "Xornex Liquid", "Veltrax Soft", "Protakil Max", "Fistrelon Pro", "Gravotix Shine", "Tivaflex Gold", "Neblux Zero", "Vextrion Ultra", "Zafrolit Super", "Duronox Light", "Noltavix Prime", "Zeltron Power", "Fixatrol Duo", "Qubranix Slim", "Helvionix Vita", "Strovit X4", "Trazolon Boost", "Reltimex Storm", "Quatrolux Flex", "Draxion Nova", "Zanflux Rapid", "Voltixor Prime", "Ultravit Delta", "Ferolonix Zeta", "Graxilon Edge", "Nexovar Swift", "Blitronix Flow", "Trilovex Max", "Zorflex Nitro", "Velatrix Forte", "Xenovit Power", "Faltrinex Pro", "Nevolux Ultra", "Quantrex Supra", "Extronix Blaze"};
    private static final String SUFIXOS[] = {"de Sopa de Pedra", "de Gelatina com Sardinha", "de Pipoca com Alho", "de Sorvete de Mostarda", "de Abacaxi com Pimenta", "de Tomate Caramelizado", "de Marshmallow com Wasabi", "de Cafe com Pepino", "de Queijo com Goiabada Apimentada", "de Alga Marinha Doce", "de Melancia com Bacon", "de Pao de Alho com Chocolate", "de Ovo com Mel", "de Azeitona com Chantilly", "de Biscoito com Salsicha", "de Suco de Beterraba e Mel", "de Melao com Hortela", "de Tofu com Pimenta Doce", "de Cha Verde com Gengibre", "de Macarrao com Laranja", "de Cupcake de Couve", "de Cebola com Chocolate", "de Iogurte com Ketchup", "de Banana com Queijo", "de Peixe com Leite Condensado", "de Cerveja com Sorvete", "de Uva com Pimenta", "de Abobora com Melado", "de Beterraba com Limao", "de Morango com Vinagre", "de Pizza com Goiabada", "de Pipoca com Caramelo de Bacon", "de Chiclete com Manga", "de Refrigerante de Couve", "de Espinafre com Chocolate", "de Amendoim com Maracuja", "de Morango com Mostarda", "de Pimenta com Mel", "de Caju com Hortela", "de Queijo Azul com Doce de Leite", "de Cenoura com Guarana", "de Chocolate com Pimenta e Gengibre", "de Framboesa com Alho", "de Coco com Alho-poro", "de Lichia com Curry", "de Morango com Wasabi", "de Batata Frita com Caramelo", "de Abacaxi com Molho de Tomate", "de Manga com Vinagre Balsamico", "de Mel com Sal Grosso", "de Goiaba com Alho"};
    private static final String FABRICANTES[] = {"Vorius", "Luminis", "Tectum", "Viridis", "Magnus", "Celeritas", "Fortis", "Aeternum", "Ultimus", "Caelus", "Luxor", "Maximus", "Virtus", "Ignis", "Dominus", "Clarus", "Nimbus", "Ventus", "Bellator", "Arcus", "Ferox", "Paxus", "Noctis", "Solis", "Primus", "Celer", "Gladius", "Aeris", "Sanctus", "Auris"};
    private static final String FRAGRANCIAS[] = {"Essencia de Cachorro Molhado", "Aroma de Gato Curioso", "Perfume de Cavalo Selvagem", "Fragrancia de Pato na Chuva", "Cheiro de Coelho Saltitante", "Essencia de Ovelha Sonolenta", "Aroma de Elefante Elegante", "Perfume de Leao Sonolento", "Fragrancia de Peixe Falante", "Cheiro de Vaca Preguicosa", "Essencia de Raposa Sorrateira", "Aroma de Urso Pescador", "Perfume de Tigre Atento", "Fragrancia de Coruja Misteriosa", "Cheiro de Pinguim Dancante", "Essencia de Jacare Charmoso", "Aroma de Ganso Barulhento", "Perfume de Porquinho Brincalhao", "Fragrancia de Tartaruga Rapida", "Cheiro de Cavalo Marinho Sonhador", "Essencia de Camaleao Camuflado", "Aroma de Lobo Solitario", "Perfume de Galo Cantante", "Fragrancia de Panda Preguicoso", "Cheiro de Hipopotamo Dancarino", "Essencia de Lhama Divertida", "Aroma de Aguia Majestosa", "Perfume de Girafa Elegante", "Fragrancia de Gamba Confiante", "Cheiro de Javali Selvagem"};
    private static final String ARMAZENAMENTO[] = {"Metal", "Plastico", "Papelao", "Vidro", "Tecido", "Papelao e Plastico"};
    private static final char PELES[] = {'A', 'C', 'E', 'G', 'I'};
    
    public static final int QUANTIDADE_DE_CAIXAS_NO_SUPERMERCADO = 5;
    
    private static int regrasQuebradas;
    private static int sacolasRasgadas;
    
    private Random gerador;
    private int tempo = 0; //em milissegundos na simulação
    private Empacotador empacotador;
    private Fiscal fiscal;
    private Caixa caixas[];

    /**
     * Construtor padrão do supermercado.
     * Ele sempre cria um novo fiscal, um novo empacotador e 5 caixas.
     * Além disso, a quantidade de regras quebradas e sacolas rasgadas é
     * iniciada em zero.
     */
    public Supermercado() {
        gerador = new Random(1);
        fiscal = new Fiscal();
        caixas = new Caixa[QUANTIDADE_DE_CAIXAS_NO_SUPERMERCADO];
        for (int i = 0; i < QUANTIDADE_DE_CAIXAS_NO_SUPERMERCADO; i++) {
            caixas[i] = new Caixa(fiscal);
        }
        empacotador = new Empacotador();
        
        regrasQuebradas = 0;
        sacolasRasgadas = 0;
    }
    
    /**
     * Retorna a quantidade total de advertências.
     * @return quantidade de advertências
     */
    public static int getAdvertencias(){
        return regrasQuebradas + sacolasRasgadas;
    }
    
    /**
     * Retorna a quantidade de regras quebradas segundo o fiscal.
     * @return quantidade de regras quebradas no ensacolamento
     */
    public static int getRegrasQuebradas(){
        return regrasQuebradas;
    }
    
    /**
     * Retorna a quantidade de sacolas rasgadas por excesso de peso.
     * @return quantidade de sacolas rasgadas
     */
    public static int getSacolasRasgadas(){
        return sacolasRasgadas;
    }
    
    /**
     * Retorna o empacotador.
     * @return empacotador do supermercado
     */
    public Empacotador getEmpacotador() {
        return empacotador;
    }
    
    /**
     * Retorna o fiscal.
     * @return fiscal do supermercado
     */
    public Fiscal getFiscal() {
        return fiscal;
    }
    
    /**
     * Retorna uma caixa específico.
     * O uso desse objeto deve ser cuidadoso, pois é uma referência direta para 
     * um caixa do supermercado, ou seja, modificar o estado interno de um caixa
     * causa modificação efetiva dele no supermercado.
     * @param numero o número do caixa que deve ser retornado (começa em 1)
     * @return caixa do supermercado
     * @throws ArrayIndexOutOfBoundsException se um número de caixa não 
     * existente e pedido (zero ou menos, ou acima do limite)
     */
    public Caixa getCaixa(int numero){
        return caixas[numero-1];
    }
    
    /**
     * Adiciona uma advertência por quebrar regra de empacotamento.
     * Esse método só deve ser usado pelo simulador, porque vai prejudicar
     * a avaliação da eficiência geral do empacotador.
     */
    public static void advertirEmpacotadorQuebrouRegra(){
        regrasQuebradas++;
    }
    
    /**
     * Adiciona uma advertência por rasgar uma sacola.
     * Esse método só deve ser usado pelo simulador, porque vai prejudicar
     * a avaliação da eficiência geral do empacotador.
     */
    public static void advertirEmpacotadorRasgouSacola(){
        sacolasRasgadas++;
    }
    
    
    /**
     * Simula o empacotamento no supermercado e atualiza a interface.
     * Cria produtos novos quando o monte dos caixas estiver com poucos 
     * produtos, verifica as sacolas despachadas para o fiscal transportar,
     * invoca a lógica do empacotador, e avisa a interface do simulador que 
     * pode fazer as atualizações com base no estado do supermercado.
     * @see java.util.Random
     * @see professor.gui.Simulador#atualizarInterface() 
     */
    public void simularSupermercado() {
        //se todos os montes dos caixas estão vazios, cria mais produtos
        int produtosNosMontes = 0;
        for(int i = 0; i < QUANTIDADE_DE_CAIXAS_NO_SUPERMERCADO; i++){
            produtosNosMontes += caixas[i].contarProdutosNoMonte();
        }
        if(produtosNosMontes == 0){
            //cria 1000 produtos no monte de cada caixa
            for (int i = 0; i < QUANTIDADE_DE_CAIXAS_NO_SUPERMERCADO; i++) {
                for(int j = 0; j <= 1000; j++){
                    String nome = NOMES[gerador.nextInt(NOMES.length)];
                    String sufixo = SUFIXOS[gerador.nextInt(SUFIXOS.length)];
                    String fabricante = FABRICANTES[gerador.nextInt(FABRICANTES.length)];
                    String tipoDeArmazenamento = ARMAZENAMENTO[gerador.nextInt(ARMAZENAMENTO.length)];
                    String fragrancia = FRAGRANCIAS[gerador.nextInt(FRAGRANCIAS.length)];
                    char tipoDePele = PELES[gerador.nextInt(PELES.length)];
                    switch(gerador.nextInt(12)){
                        case 0:
                            caixas[i].colocarProdutoNoMonte(new Alimenticio(gerador.nextInt(99999999), nome+" "+sufixo, fabricante, gerador.nextInt(5000) + 1, gerador.nextLong(120000000) + 1726421379));
                            break;
                        case 1:
                            caixas[i].colocarProdutoNoMonte(new Perecivel(gerador.nextInt(99999999), nome+" "+sufixo, fabricante, gerador.nextInt(5000) + 1, gerador.nextLong(120000000) + 1726421379));
                            break;
                        case 2:
                            caixas[i].colocarProdutoNoMonte(new NaoPerecivel(gerador.nextInt(99999999), nome+" "+sufixo, fabricante, gerador.nextInt(5000) + 1, gerador.nextLong(120000000) + 1726421379, tipoDeArmazenamento));
                            break;
                        case 3:
                            caixas[i].colocarProdutoNoMonte(new Refrigerado(gerador.nextInt(99999999), nome+" "+sufixo, fabricante, gerador.nextInt(5000) + 1, gerador.nextLong(120000000) + 1726421379, gerador.nextInt(5)-30));
                            break;
                        case 4:
                            caixas[i].colocarProdutoNoMonte(new Eletroeletronico(gerador.nextInt(99999999), nome, fabricante, gerador.nextInt(5000) + 1, (short)220));
                            break;
                        case 5:
                            caixas[i].colocarProdutoNoMonte(new Papelaria(gerador.nextInt(99999999), nome, fabricante, gerador.nextInt(5000) + 1));
                            break;
                        case 6:
                            caixas[i].colocarProdutoNoMonte(new CuidadosPessoais(gerador.nextInt(99999999), nome+" "+fragrancia, fabricante, gerador.nextInt(5000) + 1, gerador.nextLong(120000000) + 1726421379, fragrancia));
                            break;
                        case 7:
                            caixas[i].colocarProdutoNoMonte(new Higiene(gerador.nextInt(99999999), nome+" "+fragrancia, fabricante, gerador.nextInt(5000) + 1, gerador.nextLong(120000000) + 1726421379, fragrancia));
                            break;
                        case 8:
                            caixas[i].colocarProdutoNoMonte(new Cosmetico(gerador.nextInt(99999999), nome+" "+fragrancia, fabricante, gerador.nextInt(5000) + 1, gerador.nextLong(120000000) + 1726421379, fragrancia, tipoDePele));
                            break;
                        case 9:
                            caixas[i].colocarProdutoNoMonte(new Limpeza(gerador.nextInt(99999999), nome+" "+fragrancia, fabricante, gerador.nextInt(5000) + 1));
                            break;
                        default:
                            caixas[i].colocarProdutoNoMonte(new Produto(gerador.nextInt(99999999), nome+" "+sufixo, fabricante, gerador.nextInt(5000) + 1));
                    }
                }
            }
        }
        
        //invocar o empacotador
        empacotador.agir(getCaixa(empacotador.proximoCaixa), fiscal);
        
        //repôr sacolas que foram despachadas
        for(int i = 0; i < QUANTIDADE_DE_CAIXAS_NO_SUPERMERCADO; i++){
           caixas[i].reporSacolas();
        }
        
        //avança o tempo
        tempo++;
        
        //para a simulação depois de 120 segundos (120000 milissegundos)
        if(tempo >= 120000){
            Simulador.pararSimulacao();
        }
        
    }
}
