package Simulador;

import java.awt.Color;
import java.util.TimerTask;
import entidades.Supermercado;

/**
 * Simulador gráfico do Supermercado.
 * <br><br>
 * <strong>Não mexa aqui!!!</strong>
 * 
 * @author Jean Cheiran
 * @version 1.0
 */
public class Simulador extends javax.swing.JFrame {

    private static Supermercado supermercado;
    private static TimerTask tarefaSimular;
    private static TimerTask tarefaAtualizarGUI;
    private static Simulador instancia;
    
    /**
     * Invoca o simulador de ensacolamento do supermercado.
     * Esse método é um intermediário no contexto da interface gráfica com
     * usuário para ser usado nas chamadas agendadas do Timer. Ele é necessário,
     * embora seja indesejado.
     */
    public void simular(){
        supermercado.simularSupermercado();
    }
    
    /**
     * Cancela a invocação periódica de tarefas de atualização e simulação.
     * Esse método finaliza as tarefas agendadas de simulação do supermercado
     * (envolvendo criação de produtos, ação do empacotador etc.) e de 
     * atualização da interface com usuário (atualização dos textos dos rótulos,
     * mudança de cores etc.). 
     * Esse método deve incluir no futuro a sumarização de estatísticas de 
     * eficiência do empacotador.
     * @see Simulador#atualizarInterface()
     * @see entidades.Supermercado#simularSupermercado()
     * 
     */
    public static void pararSimulacao(){
        tarefaSimular.cancel();
        tarefaAtualizarGUI.cancel();
        Simulador.getInstancia().atualizarInterface();
    }
    
    /**
     * Padrão de projeto Singleton para obter o simulador.
     * @return instância única de Simulador
     */
    public static Simulador getInstancia(){
        if(instancia == null){
            instancia = new Simulador();
        }
        return instancia;
    }
    
    /**
     * Creates new form Simulador
     */
    private Simulador() {
        initComponents();
        supermercado = new Supermercado();
    }
    
    /**
     * Atualiza os elementos na tela com base no estado do supermercado.
     * Esse método é invocado pelo Simulador a cada segundo.
     */
    public void atualizarInterface(){
        labelMonteQuantidadeCaixa1.setText(""+supermercado.getCaixa(1).contarProdutosNoMonte());
        labelMonteQuantidadeCaixa2.setText(""+supermercado.getCaixa(2).contarProdutosNoMonte());
        labelMonteQuantidadeCaixa3.setText(""+supermercado.getCaixa(3).contarProdutosNoMonte());
        labelMonteQuantidadeCaixa4.setText(""+supermercado.getCaixa(4).contarProdutosNoMonte());
        labelMonteQuantidadeCaixa5.setText(""+supermercado.getCaixa(5).contarProdutosNoMonte());
        
        labelSacola1QuantidadeCaixa1.setText(""+supermercado.getCaixa(1).getSacola(1).contarProdutosNaSacola());
        labelSacola2QuantidadeCaixa1.setText(""+supermercado.getCaixa(1).getSacola(2).contarProdutosNaSacola());
        labelSacola3QuantidadeCaixa1.setText(""+supermercado.getCaixa(1).getSacola(3).contarProdutosNaSacola());
        labelSacola4QuantidadeCaixa1.setText(""+supermercado.getCaixa(1).getSacola(4).contarProdutosNaSacola());
        labelSacola5QuantidadeCaixa1.setText(""+supermercado.getCaixa(1).getSacola(5).contarProdutosNaSacola());
        
        labelSacola1QuantidadeCaixa2.setText(""+supermercado.getCaixa(2).getSacola(1).contarProdutosNaSacola());
        labelSacola2QuantidadeCaixa2.setText(""+supermercado.getCaixa(2).getSacola(2).contarProdutosNaSacola());
        labelSacola3QuantidadeCaixa2.setText(""+supermercado.getCaixa(2).getSacola(3).contarProdutosNaSacola());
        labelSacola4QuantidadeCaixa2.setText(""+supermercado.getCaixa(2).getSacola(4).contarProdutosNaSacola());
        labelSacola5QuantidadeCaixa2.setText(""+supermercado.getCaixa(2).getSacola(5).contarProdutosNaSacola());
        
        labelSacola1QuantidadeCaixa3.setText(""+supermercado.getCaixa(3).getSacola(1).contarProdutosNaSacola());
        labelSacola2QuantidadeCaixa3.setText(""+supermercado.getCaixa(3).getSacola(2).contarProdutosNaSacola());
        labelSacola3QuantidadeCaixa3.setText(""+supermercado.getCaixa(3).getSacola(3).contarProdutosNaSacola());
        labelSacola4QuantidadeCaixa3.setText(""+supermercado.getCaixa(3).getSacola(4).contarProdutosNaSacola());
        labelSacola5QuantidadeCaixa3.setText(""+supermercado.getCaixa(3).getSacola(5).contarProdutosNaSacola());
        
        labelSacola1QuantidadeCaixa4.setText(""+supermercado.getCaixa(4).getSacola(1).contarProdutosNaSacola());
        labelSacola2QuantidadeCaixa4.setText(""+supermercado.getCaixa(4).getSacola(2).contarProdutosNaSacola());
        labelSacola3QuantidadeCaixa4.setText(""+supermercado.getCaixa(4).getSacola(3).contarProdutosNaSacola());
        labelSacola4QuantidadeCaixa4.setText(""+supermercado.getCaixa(4).getSacola(4).contarProdutosNaSacola());
        labelSacola5QuantidadeCaixa4.setText(""+supermercado.getCaixa(4).getSacola(5).contarProdutosNaSacola());
        
        labelSacola1QuantidadeCaixa5.setText(""+supermercado.getCaixa(5).getSacola(1).contarProdutosNaSacola());
        labelSacola2QuantidadeCaixa5.setText(""+supermercado.getCaixa(5).getSacola(2).contarProdutosNaSacola());
        labelSacola3QuantidadeCaixa5.setText(""+supermercado.getCaixa(5).getSacola(3).contarProdutosNaSacola());
        labelSacola4QuantidadeCaixa5.setText(""+supermercado.getCaixa(5).getSacola(4).contarProdutosNaSacola());
        labelSacola5QuantidadeCaixa5.setText(""+supermercado.getCaixa(5).getSacola(5).contarProdutosNaSacola());
        
        labelSacolasTransportadasQuantidade.setText(""+supermercado.getFiscal().contarSacolasDespachadas());
        
        labelAdvertenciasQuantidade.setText(""+supermercado.getAdvertencias());
        if(supermercado.getAdvertencias() > 5 && supermercado.getAdvertencias() < 10){
            advertencias.setBackground(Color.YELLOW);
        }else if(supermercado.getAdvertencias() >= 10){
            advertencias.setBackground(Color.RED);
        }
        
        repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fundo = new javax.swing.JPanel();
        caixa1 = new javax.swing.JPanel();
        labelCaixa1 = new javax.swing.JLabel();
        labelMonteCaixa1 = new javax.swing.JLabel();
        labelMonteQuantidadeCaixa1 = new javax.swing.JLabel();
        sacola5Caixa1 = new javax.swing.JPanel();
        labelSacola5Caixa1 = new javax.swing.JLabel();
        labelSacola5QuantidadeCaixa1 = new javax.swing.JLabel();
        sacola4Caixa1 = new javax.swing.JPanel();
        labelSacola4Caixa1 = new javax.swing.JLabel();
        labelSacola4QuantidadeCaixa1 = new javax.swing.JLabel();
        sacola3Caixa1 = new javax.swing.JPanel();
        labelSacola3Caixa1 = new javax.swing.JLabel();
        labelSacola3QuantidadeCaixa1 = new javax.swing.JLabel();
        sacola2Caixa1 = new javax.swing.JPanel();
        labelSacola2Caixa1 = new javax.swing.JLabel();
        labelSacola2QuantidadeCaixa1 = new javax.swing.JLabel();
        sacola1Caixa1 = new javax.swing.JPanel();
        labelSacola1Caixa1 = new javax.swing.JLabel();
        labelSacola1QuantidadeCaixa1 = new javax.swing.JLabel();
        caixa2 = new javax.swing.JPanel();
        labelCaixa2 = new javax.swing.JLabel();
        labelMonteCaixa2 = new javax.swing.JLabel();
        labelMonteQuantidadeCaixa2 = new javax.swing.JLabel();
        sacola1Caixa2 = new javax.swing.JPanel();
        labelSacola1Caixa2 = new javax.swing.JLabel();
        labelSacola1QuantidadeCaixa2 = new javax.swing.JLabel();
        sacola2Caixa2 = new javax.swing.JPanel();
        labelSacola2Caixa2 = new javax.swing.JLabel();
        labelSacola2QuantidadeCaixa2 = new javax.swing.JLabel();
        sacola3Caixa2 = new javax.swing.JPanel();
        labelSacola3Caixa2 = new javax.swing.JLabel();
        labelSacola3QuantidadeCaixa2 = new javax.swing.JLabel();
        sacola4Caixa2 = new javax.swing.JPanel();
        labelSacola4Caixa2 = new javax.swing.JLabel();
        labelSacola4QuantidadeCaixa2 = new javax.swing.JLabel();
        sacola5Caixa2 = new javax.swing.JPanel();
        labelSacola5Caixa2 = new javax.swing.JLabel();
        labelSacola5QuantidadeCaixa2 = new javax.swing.JLabel();
        caixa3 = new javax.swing.JPanel();
        labelCaixa3 = new javax.swing.JLabel();
        labelMonteCaixa3 = new javax.swing.JLabel();
        labelMonteQuantidadeCaixa3 = new javax.swing.JLabel();
        sacola1Caixa3 = new javax.swing.JPanel();
        labelSacola1Caixa3 = new javax.swing.JLabel();
        labelSacola1QuantidadeCaixa3 = new javax.swing.JLabel();
        sacola2Caixa3 = new javax.swing.JPanel();
        labelSacola2Caixa3 = new javax.swing.JLabel();
        labelSacola2QuantidadeCaixa3 = new javax.swing.JLabel();
        sacola3Caixa3 = new javax.swing.JPanel();
        labelSacola3Caixa3 = new javax.swing.JLabel();
        labelSacola3QuantidadeCaixa3 = new javax.swing.JLabel();
        sacola4Caixa3 = new javax.swing.JPanel();
        labelSacola4Caixa3 = new javax.swing.JLabel();
        labelSacola4QuantidadeCaixa3 = new javax.swing.JLabel();
        sacola5Caixa3 = new javax.swing.JPanel();
        labelSacola5Caixa3 = new javax.swing.JLabel();
        labelSacola5QuantidadeCaixa3 = new javax.swing.JLabel();
        caixa4 = new javax.swing.JPanel();
        labelCaixa4 = new javax.swing.JLabel();
        labelMonteCaixa4 = new javax.swing.JLabel();
        labelMonteQuantidadeCaixa4 = new javax.swing.JLabel();
        sacola1Caixa4 = new javax.swing.JPanel();
        labelSacola1Caixa4 = new javax.swing.JLabel();
        labelSacola1QuantidadeCaixa4 = new javax.swing.JLabel();
        sacola2Caixa4 = new javax.swing.JPanel();
        labelSacola2Caixa4 = new javax.swing.JLabel();
        labelSacola2QuantidadeCaixa4 = new javax.swing.JLabel();
        sacola3Caixa4 = new javax.swing.JPanel();
        labelSacola3Caixa4 = new javax.swing.JLabel();
        labelSacola3QuantidadeCaixa4 = new javax.swing.JLabel();
        sacola4Caixa4 = new javax.swing.JPanel();
        labelSacola4Caixa4 = new javax.swing.JLabel();
        labelSacola4QuantidadeCaixa4 = new javax.swing.JLabel();
        sacola5Caixa4 = new javax.swing.JPanel();
        labelSacola5Caixa4 = new javax.swing.JLabel();
        labelSacola5QuantidadeCaixa4 = new javax.swing.JLabel();
        caixa5 = new javax.swing.JPanel();
        labelCaixa5 = new javax.swing.JLabel();
        labelMonteCaixa5 = new javax.swing.JLabel();
        labelMonteQuantidadeCaixa5 = new javax.swing.JLabel();
        sacola1Caixa5 = new javax.swing.JPanel();
        labelSacola1Caixa5 = new javax.swing.JLabel();
        labelSacola1QuantidadeCaixa5 = new javax.swing.JLabel();
        sacola2Caixa5 = new javax.swing.JPanel();
        labelSacola2Caixa5 = new javax.swing.JLabel();
        labelSacola2QuantidadeCaixa5 = new javax.swing.JLabel();
        sacola3Caixa5 = new javax.swing.JPanel();
        labelSacola3Caixa5 = new javax.swing.JLabel();
        labelSacola3QuantidadeCaixa5 = new javax.swing.JLabel();
        sacola4Caixa5 = new javax.swing.JPanel();
        labelSacola4Caixa5 = new javax.swing.JLabel();
        labelSacola4QuantidadeCaixa5 = new javax.swing.JLabel();
        sacola5Caixa5 = new javax.swing.JPanel();
        labelSacola5Caixa5 = new javax.swing.JLabel();
        labelSacola5QuantidadeCaixa5 = new javax.swing.JLabel();
        transporte = new javax.swing.JPanel();
        labelTransporte = new javax.swing.JLabel();
        labelSacolasTranspotadas = new javax.swing.JLabel();
        labelSacolasTransportadasQuantidade = new javax.swing.JLabel();
        advertencias = new javax.swing.JPanel();
        labelAdvertencias = new javax.swing.JLabel();
        labelAdvertenciasQuantidade = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));

        fundo.setBackground(new java.awt.Color(255, 255, 255));
        fundo.setMaximumSize(new java.awt.Dimension(800, 600));
        fundo.setMinimumSize(new java.awt.Dimension(800, 600));
        fundo.setPreferredSize(new java.awt.Dimension(800, 600));

        caixa1.setBackground(new java.awt.Color(255, 204, 204));

        labelCaixa1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelCaixa1.setText("Caixa 1");

        labelMonteCaixa1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMonteCaixa1.setText("Monte");

        labelMonteQuantidadeCaixa1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelMonteQuantidadeCaixa1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMonteQuantidadeCaixa1.setText("-");

        sacola5Caixa1.setBackground(new java.awt.Color(255, 255, 255));

        labelSacola5Caixa1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSacola5Caixa1.setText("Sacola 5");

        labelSacola5QuantidadeCaixa1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelSacola5QuantidadeCaixa1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSacola5QuantidadeCaixa1.setText("-");

        javax.swing.GroupLayout sacola5Caixa1Layout = new javax.swing.GroupLayout(sacola5Caixa1);
        sacola5Caixa1.setLayout(sacola5Caixa1Layout);
        sacola5Caixa1Layout.setHorizontalGroup(
            sacola5Caixa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sacola5Caixa1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sacola5Caixa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sacola5Caixa1Layout.createSequentialGroup()
                        .addComponent(labelSacola5Caixa1)
                        .addGap(0, 5, Short.MAX_VALUE))
                    .addComponent(labelSacola5QuantidadeCaixa1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        sacola5Caixa1Layout.setVerticalGroup(
            sacola5Caixa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sacola5Caixa1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSacola5Caixa1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelSacola5QuantidadeCaixa1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        sacola4Caixa1.setBackground(new java.awt.Color(255, 255, 255));

        labelSacola4Caixa1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSacola4Caixa1.setText("Sacola 4");

        labelSacola4QuantidadeCaixa1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelSacola4QuantidadeCaixa1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSacola4QuantidadeCaixa1.setText("-");

        javax.swing.GroupLayout sacola4Caixa1Layout = new javax.swing.GroupLayout(sacola4Caixa1);
        sacola4Caixa1.setLayout(sacola4Caixa1Layout);
        sacola4Caixa1Layout.setHorizontalGroup(
            sacola4Caixa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sacola4Caixa1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sacola4Caixa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sacola4Caixa1Layout.createSequentialGroup()
                        .addComponent(labelSacola4Caixa1)
                        .addGap(0, 5, Short.MAX_VALUE))
                    .addComponent(labelSacola4QuantidadeCaixa1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        sacola4Caixa1Layout.setVerticalGroup(
            sacola4Caixa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sacola4Caixa1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSacola4Caixa1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelSacola4QuantidadeCaixa1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        sacola3Caixa1.setBackground(new java.awt.Color(255, 255, 255));

        labelSacola3Caixa1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSacola3Caixa1.setText("Sacola 3");

        labelSacola3QuantidadeCaixa1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelSacola3QuantidadeCaixa1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSacola3QuantidadeCaixa1.setText("-");

        javax.swing.GroupLayout sacola3Caixa1Layout = new javax.swing.GroupLayout(sacola3Caixa1);
        sacola3Caixa1.setLayout(sacola3Caixa1Layout);
        sacola3Caixa1Layout.setHorizontalGroup(
            sacola3Caixa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sacola3Caixa1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sacola3Caixa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelSacola3Caixa1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(labelSacola3QuantidadeCaixa1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        sacola3Caixa1Layout.setVerticalGroup(
            sacola3Caixa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sacola3Caixa1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSacola3Caixa1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelSacola3QuantidadeCaixa1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        sacola2Caixa1.setBackground(new java.awt.Color(255, 255, 255));

        labelSacola2Caixa1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSacola2Caixa1.setText("Sacola 2");

        labelSacola2QuantidadeCaixa1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelSacola2QuantidadeCaixa1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSacola2QuantidadeCaixa1.setText("-");

        javax.swing.GroupLayout sacola2Caixa1Layout = new javax.swing.GroupLayout(sacola2Caixa1);
        sacola2Caixa1.setLayout(sacola2Caixa1Layout);
        sacola2Caixa1Layout.setHorizontalGroup(
            sacola2Caixa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sacola2Caixa1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sacola2Caixa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelSacola2Caixa1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(labelSacola2QuantidadeCaixa1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        sacola2Caixa1Layout.setVerticalGroup(
            sacola2Caixa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sacola2Caixa1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSacola2Caixa1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelSacola2QuantidadeCaixa1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        sacola1Caixa1.setBackground(new java.awt.Color(255, 255, 255));

        labelSacola1Caixa1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSacola1Caixa1.setText("Sacola 1");

        labelSacola1QuantidadeCaixa1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelSacola1QuantidadeCaixa1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSacola1QuantidadeCaixa1.setText("-");

        javax.swing.GroupLayout sacola1Caixa1Layout = new javax.swing.GroupLayout(sacola1Caixa1);
        sacola1Caixa1.setLayout(sacola1Caixa1Layout);
        sacola1Caixa1Layout.setHorizontalGroup(
            sacola1Caixa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sacola1Caixa1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sacola1Caixa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelSacola1QuantidadeCaixa1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelSacola1Caixa1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addContainerGap())
        );
        sacola1Caixa1Layout.setVerticalGroup(
            sacola1Caixa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sacola1Caixa1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSacola1Caixa1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelSacola1QuantidadeCaixa1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout caixa1Layout = new javax.swing.GroupLayout(caixa1);
        caixa1.setLayout(caixa1Layout);
        caixa1Layout.setHorizontalGroup(
            caixa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(caixa1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(labelCaixa1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(caixa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelMonteCaixa1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelMonteQuantidadeCaixa1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addComponent(sacola1Caixa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sacola2Caixa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sacola3Caixa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sacola4Caixa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sacola5Caixa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        caixa1Layout.setVerticalGroup(
            caixa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(caixa1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(caixa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sacola3Caixa1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sacola2Caixa1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sacola1Caixa1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sacola5Caixa1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(caixa1Layout.createSequentialGroup()
                        .addGroup(caixa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelCaixa1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(caixa1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(labelMonteCaixa1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelMonteQuantidadeCaixa1)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(sacola4Caixa1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        caixa2.setBackground(new java.awt.Color(255, 204, 153));

        labelCaixa2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelCaixa2.setText("Caixa 2");

        labelMonteCaixa2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMonteCaixa2.setText("Monte");

        labelMonteQuantidadeCaixa2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelMonteQuantidadeCaixa2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMonteQuantidadeCaixa2.setText("-");

        sacola1Caixa2.setBackground(new java.awt.Color(255, 255, 255));

        labelSacola1Caixa2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSacola1Caixa2.setText("Sacola 1");

        labelSacola1QuantidadeCaixa2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelSacola1QuantidadeCaixa2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSacola1QuantidadeCaixa2.setText("-");

        javax.swing.GroupLayout sacola1Caixa2Layout = new javax.swing.GroupLayout(sacola1Caixa2);
        sacola1Caixa2.setLayout(sacola1Caixa2Layout);
        sacola1Caixa2Layout.setHorizontalGroup(
            sacola1Caixa2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sacola1Caixa2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sacola1Caixa2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelSacola1QuantidadeCaixa2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelSacola1Caixa2, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addContainerGap())
        );
        sacola1Caixa2Layout.setVerticalGroup(
            sacola1Caixa2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sacola1Caixa2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSacola1Caixa2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelSacola1QuantidadeCaixa2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        sacola2Caixa2.setBackground(new java.awt.Color(255, 255, 255));

        labelSacola2Caixa2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSacola2Caixa2.setText("Sacola 2");

        labelSacola2QuantidadeCaixa2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelSacola2QuantidadeCaixa2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSacola2QuantidadeCaixa2.setText("-");

        javax.swing.GroupLayout sacola2Caixa2Layout = new javax.swing.GroupLayout(sacola2Caixa2);
        sacola2Caixa2.setLayout(sacola2Caixa2Layout);
        sacola2Caixa2Layout.setHorizontalGroup(
            sacola2Caixa2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sacola2Caixa2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sacola2Caixa2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelSacola2Caixa2, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(labelSacola2QuantidadeCaixa2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        sacola2Caixa2Layout.setVerticalGroup(
            sacola2Caixa2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sacola2Caixa2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSacola2Caixa2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelSacola2QuantidadeCaixa2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        sacola3Caixa2.setBackground(new java.awt.Color(255, 255, 255));

        labelSacola3Caixa2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSacola3Caixa2.setText("Sacola 3");

        labelSacola3QuantidadeCaixa2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelSacola3QuantidadeCaixa2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSacola3QuantidadeCaixa2.setText("-");

        javax.swing.GroupLayout sacola3Caixa2Layout = new javax.swing.GroupLayout(sacola3Caixa2);
        sacola3Caixa2.setLayout(sacola3Caixa2Layout);
        sacola3Caixa2Layout.setHorizontalGroup(
            sacola3Caixa2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sacola3Caixa2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sacola3Caixa2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelSacola3Caixa2, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(labelSacola3QuantidadeCaixa2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        sacola3Caixa2Layout.setVerticalGroup(
            sacola3Caixa2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sacola3Caixa2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSacola3Caixa2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelSacola3QuantidadeCaixa2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        sacola4Caixa2.setBackground(new java.awt.Color(255, 255, 255));

        labelSacola4Caixa2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSacola4Caixa2.setText("Sacola 4");

        labelSacola4QuantidadeCaixa2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelSacola4QuantidadeCaixa2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSacola4QuantidadeCaixa2.setText("-");

        javax.swing.GroupLayout sacola4Caixa2Layout = new javax.swing.GroupLayout(sacola4Caixa2);
        sacola4Caixa2.setLayout(sacola4Caixa2Layout);
        sacola4Caixa2Layout.setHorizontalGroup(
            sacola4Caixa2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sacola4Caixa2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sacola4Caixa2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sacola4Caixa2Layout.createSequentialGroup()
                        .addComponent(labelSacola4Caixa2)
                        .addGap(0, 5, Short.MAX_VALUE))
                    .addComponent(labelSacola4QuantidadeCaixa2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        sacola4Caixa2Layout.setVerticalGroup(
            sacola4Caixa2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sacola4Caixa2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSacola4Caixa2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelSacola4QuantidadeCaixa2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        sacola5Caixa2.setBackground(new java.awt.Color(255, 255, 255));

        labelSacola5Caixa2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSacola5Caixa2.setText("Sacola 5");

        labelSacola5QuantidadeCaixa2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelSacola5QuantidadeCaixa2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSacola5QuantidadeCaixa2.setText("-");

        javax.swing.GroupLayout sacola5Caixa2Layout = new javax.swing.GroupLayout(sacola5Caixa2);
        sacola5Caixa2.setLayout(sacola5Caixa2Layout);
        sacola5Caixa2Layout.setHorizontalGroup(
            sacola5Caixa2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sacola5Caixa2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sacola5Caixa2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sacola5Caixa2Layout.createSequentialGroup()
                        .addComponent(labelSacola5Caixa2)
                        .addGap(0, 5, Short.MAX_VALUE))
                    .addComponent(labelSacola5QuantidadeCaixa2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        sacola5Caixa2Layout.setVerticalGroup(
            sacola5Caixa2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sacola5Caixa2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSacola5Caixa2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelSacola5QuantidadeCaixa2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout caixa2Layout = new javax.swing.GroupLayout(caixa2);
        caixa2.setLayout(caixa2Layout);
        caixa2Layout.setHorizontalGroup(
            caixa2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(caixa2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(labelCaixa2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(caixa2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelMonteCaixa2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelMonteQuantidadeCaixa2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addComponent(sacola1Caixa2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sacola2Caixa2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sacola3Caixa2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sacola4Caixa2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sacola5Caixa2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        caixa2Layout.setVerticalGroup(
            caixa2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(caixa2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(caixa2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(caixa2Layout.createSequentialGroup()
                        .addGroup(caixa2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelCaixa2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(caixa2Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(labelMonteCaixa2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelMonteQuantidadeCaixa2)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, caixa2Layout.createSequentialGroup()
                        .addGroup(caixa2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(sacola5Caixa2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sacola4Caixa2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sacola3Caixa2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sacola2Caixa2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sacola1Caixa2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );

        caixa3.setBackground(new java.awt.Color(255, 255, 204));

        labelCaixa3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelCaixa3.setText("Caixa 3");

        labelMonteCaixa3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMonteCaixa3.setText("Monte");

        labelMonteQuantidadeCaixa3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelMonteQuantidadeCaixa3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMonteQuantidadeCaixa3.setText("-");

        sacola1Caixa3.setBackground(new java.awt.Color(255, 255, 255));

        labelSacola1Caixa3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSacola1Caixa3.setText("Sacola 1");

        labelSacola1QuantidadeCaixa3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelSacola1QuantidadeCaixa3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSacola1QuantidadeCaixa3.setText("-");

        javax.swing.GroupLayout sacola1Caixa3Layout = new javax.swing.GroupLayout(sacola1Caixa3);
        sacola1Caixa3.setLayout(sacola1Caixa3Layout);
        sacola1Caixa3Layout.setHorizontalGroup(
            sacola1Caixa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sacola1Caixa3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sacola1Caixa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelSacola1QuantidadeCaixa3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelSacola1Caixa3, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addContainerGap())
        );
        sacola1Caixa3Layout.setVerticalGroup(
            sacola1Caixa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sacola1Caixa3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSacola1Caixa3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelSacola1QuantidadeCaixa3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        sacola2Caixa3.setBackground(new java.awt.Color(255, 255, 255));

        labelSacola2Caixa3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSacola2Caixa3.setText("Sacola 2");

        labelSacola2QuantidadeCaixa3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelSacola2QuantidadeCaixa3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSacola2QuantidadeCaixa3.setText("-");

        javax.swing.GroupLayout sacola2Caixa3Layout = new javax.swing.GroupLayout(sacola2Caixa3);
        sacola2Caixa3.setLayout(sacola2Caixa3Layout);
        sacola2Caixa3Layout.setHorizontalGroup(
            sacola2Caixa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sacola2Caixa3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sacola2Caixa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelSacola2Caixa3, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(labelSacola2QuantidadeCaixa3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        sacola2Caixa3Layout.setVerticalGroup(
            sacola2Caixa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sacola2Caixa3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSacola2Caixa3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelSacola2QuantidadeCaixa3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        sacola3Caixa3.setBackground(new java.awt.Color(255, 255, 255));

        labelSacola3Caixa3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSacola3Caixa3.setText("Sacola 3");

        labelSacola3QuantidadeCaixa3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelSacola3QuantidadeCaixa3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSacola3QuantidadeCaixa3.setText("-");

        javax.swing.GroupLayout sacola3Caixa3Layout = new javax.swing.GroupLayout(sacola3Caixa3);
        sacola3Caixa3.setLayout(sacola3Caixa3Layout);
        sacola3Caixa3Layout.setHorizontalGroup(
            sacola3Caixa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sacola3Caixa3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sacola3Caixa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelSacola3Caixa3, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(labelSacola3QuantidadeCaixa3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        sacola3Caixa3Layout.setVerticalGroup(
            sacola3Caixa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sacola3Caixa3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSacola3Caixa3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelSacola3QuantidadeCaixa3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        sacola4Caixa3.setBackground(new java.awt.Color(255, 255, 255));

        labelSacola4Caixa3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSacola4Caixa3.setText("Sacola 4");

        labelSacola4QuantidadeCaixa3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelSacola4QuantidadeCaixa3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSacola4QuantidadeCaixa3.setText("-");

        javax.swing.GroupLayout sacola4Caixa3Layout = new javax.swing.GroupLayout(sacola4Caixa3);
        sacola4Caixa3.setLayout(sacola4Caixa3Layout);
        sacola4Caixa3Layout.setHorizontalGroup(
            sacola4Caixa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sacola4Caixa3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sacola4Caixa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sacola4Caixa3Layout.createSequentialGroup()
                        .addComponent(labelSacola4Caixa3)
                        .addGap(0, 5, Short.MAX_VALUE))
                    .addComponent(labelSacola4QuantidadeCaixa3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        sacola4Caixa3Layout.setVerticalGroup(
            sacola4Caixa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sacola4Caixa3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSacola4Caixa3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelSacola4QuantidadeCaixa3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        sacola5Caixa3.setBackground(new java.awt.Color(255, 255, 255));

        labelSacola5Caixa3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSacola5Caixa3.setText("Sacola 5");

        labelSacola5QuantidadeCaixa3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelSacola5QuantidadeCaixa3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSacola5QuantidadeCaixa3.setText("-");

        javax.swing.GroupLayout sacola5Caixa3Layout = new javax.swing.GroupLayout(sacola5Caixa3);
        sacola5Caixa3.setLayout(sacola5Caixa3Layout);
        sacola5Caixa3Layout.setHorizontalGroup(
            sacola5Caixa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sacola5Caixa3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sacola5Caixa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sacola5Caixa3Layout.createSequentialGroup()
                        .addComponent(labelSacola5Caixa3)
                        .addGap(0, 5, Short.MAX_VALUE))
                    .addComponent(labelSacola5QuantidadeCaixa3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        sacola5Caixa3Layout.setVerticalGroup(
            sacola5Caixa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sacola5Caixa3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSacola5Caixa3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelSacola5QuantidadeCaixa3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout caixa3Layout = new javax.swing.GroupLayout(caixa3);
        caixa3.setLayout(caixa3Layout);
        caixa3Layout.setHorizontalGroup(
            caixa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(caixa3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(labelCaixa3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(caixa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelMonteCaixa3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelMonteQuantidadeCaixa3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sacola1Caixa3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sacola2Caixa3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sacola3Caixa3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sacola4Caixa3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sacola5Caixa3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        caixa3Layout.setVerticalGroup(
            caixa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(caixa3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(caixa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(caixa3Layout.createSequentialGroup()
                        .addGroup(caixa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelCaixa3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(caixa3Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(labelMonteCaixa3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelMonteQuantidadeCaixa3)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, caixa3Layout.createSequentialGroup()
                        .addGroup(caixa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(sacola5Caixa3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sacola4Caixa3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sacola3Caixa3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sacola2Caixa3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sacola1Caixa3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );

        caixa4.setBackground(new java.awt.Color(204, 255, 204));

        labelCaixa4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelCaixa4.setText("Caixa 4");

        labelMonteCaixa4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMonteCaixa4.setText("Monte");

        labelMonteQuantidadeCaixa4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelMonteQuantidadeCaixa4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMonteQuantidadeCaixa4.setText("-");

        sacola1Caixa4.setBackground(new java.awt.Color(255, 255, 255));

        labelSacola1Caixa4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSacola1Caixa4.setText("Sacola 1");

        labelSacola1QuantidadeCaixa4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelSacola1QuantidadeCaixa4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSacola1QuantidadeCaixa4.setText("-");

        javax.swing.GroupLayout sacola1Caixa4Layout = new javax.swing.GroupLayout(sacola1Caixa4);
        sacola1Caixa4.setLayout(sacola1Caixa4Layout);
        sacola1Caixa4Layout.setHorizontalGroup(
            sacola1Caixa4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sacola1Caixa4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sacola1Caixa4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelSacola1QuantidadeCaixa4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelSacola1Caixa4, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addContainerGap())
        );
        sacola1Caixa4Layout.setVerticalGroup(
            sacola1Caixa4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sacola1Caixa4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSacola1Caixa4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelSacola1QuantidadeCaixa4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        sacola2Caixa4.setBackground(new java.awt.Color(255, 255, 255));

        labelSacola2Caixa4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSacola2Caixa4.setText("Sacola 2");

        labelSacola2QuantidadeCaixa4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelSacola2QuantidadeCaixa4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSacola2QuantidadeCaixa4.setText("-");

        javax.swing.GroupLayout sacola2Caixa4Layout = new javax.swing.GroupLayout(sacola2Caixa4);
        sacola2Caixa4.setLayout(sacola2Caixa4Layout);
        sacola2Caixa4Layout.setHorizontalGroup(
            sacola2Caixa4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sacola2Caixa4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sacola2Caixa4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelSacola2Caixa4, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(labelSacola2QuantidadeCaixa4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        sacola2Caixa4Layout.setVerticalGroup(
            sacola2Caixa4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sacola2Caixa4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSacola2Caixa4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelSacola2QuantidadeCaixa4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        sacola3Caixa4.setBackground(new java.awt.Color(255, 255, 255));

        labelSacola3Caixa4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSacola3Caixa4.setText("Sacola 3");

        labelSacola3QuantidadeCaixa4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelSacola3QuantidadeCaixa4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSacola3QuantidadeCaixa4.setText("-");

        javax.swing.GroupLayout sacola3Caixa4Layout = new javax.swing.GroupLayout(sacola3Caixa4);
        sacola3Caixa4.setLayout(sacola3Caixa4Layout);
        sacola3Caixa4Layout.setHorizontalGroup(
            sacola3Caixa4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sacola3Caixa4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sacola3Caixa4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelSacola3Caixa4, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(labelSacola3QuantidadeCaixa4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        sacola3Caixa4Layout.setVerticalGroup(
            sacola3Caixa4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sacola3Caixa4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSacola3Caixa4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelSacola3QuantidadeCaixa4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        sacola4Caixa4.setBackground(new java.awt.Color(255, 255, 255));

        labelSacola4Caixa4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSacola4Caixa4.setText("Sacola 4");

        labelSacola4QuantidadeCaixa4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelSacola4QuantidadeCaixa4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSacola4QuantidadeCaixa4.setText("-");

        javax.swing.GroupLayout sacola4Caixa4Layout = new javax.swing.GroupLayout(sacola4Caixa4);
        sacola4Caixa4.setLayout(sacola4Caixa4Layout);
        sacola4Caixa4Layout.setHorizontalGroup(
            sacola4Caixa4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sacola4Caixa4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sacola4Caixa4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sacola4Caixa4Layout.createSequentialGroup()
                        .addComponent(labelSacola4Caixa4)
                        .addGap(0, 5, Short.MAX_VALUE))
                    .addComponent(labelSacola4QuantidadeCaixa4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        sacola4Caixa4Layout.setVerticalGroup(
            sacola4Caixa4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sacola4Caixa4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSacola4Caixa4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelSacola4QuantidadeCaixa4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        sacola5Caixa4.setBackground(new java.awt.Color(255, 255, 255));

        labelSacola5Caixa4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSacola5Caixa4.setText("Sacola 5");

        labelSacola5QuantidadeCaixa4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelSacola5QuantidadeCaixa4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSacola5QuantidadeCaixa4.setText("-");

        javax.swing.GroupLayout sacola5Caixa4Layout = new javax.swing.GroupLayout(sacola5Caixa4);
        sacola5Caixa4.setLayout(sacola5Caixa4Layout);
        sacola5Caixa4Layout.setHorizontalGroup(
            sacola5Caixa4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sacola5Caixa4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sacola5Caixa4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sacola5Caixa4Layout.createSequentialGroup()
                        .addComponent(labelSacola5Caixa4)
                        .addGap(0, 5, Short.MAX_VALUE))
                    .addComponent(labelSacola5QuantidadeCaixa4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        sacola5Caixa4Layout.setVerticalGroup(
            sacola5Caixa4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sacola5Caixa4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSacola5Caixa4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelSacola5QuantidadeCaixa4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout caixa4Layout = new javax.swing.GroupLayout(caixa4);
        caixa4.setLayout(caixa4Layout);
        caixa4Layout.setHorizontalGroup(
            caixa4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(caixa4Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(labelCaixa4, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(caixa4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelMonteCaixa4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelMonteQuantidadeCaixa4, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addComponent(sacola1Caixa4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sacola2Caixa4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sacola3Caixa4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sacola4Caixa4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sacola5Caixa4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        caixa4Layout.setVerticalGroup(
            caixa4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(caixa4Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(caixa4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(caixa4Layout.createSequentialGroup()
                        .addGroup(caixa4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelCaixa4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(caixa4Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(labelMonteCaixa4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelMonteQuantidadeCaixa4)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, caixa4Layout.createSequentialGroup()
                        .addGroup(caixa4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(sacola5Caixa4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sacola4Caixa4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sacola3Caixa4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sacola2Caixa4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sacola1Caixa4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );

        caixa5.setBackground(new java.awt.Color(204, 255, 255));

        labelCaixa5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelCaixa5.setText("Caixa 5");

        labelMonteCaixa5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMonteCaixa5.setText("Monte");

        labelMonteQuantidadeCaixa5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelMonteQuantidadeCaixa5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMonteQuantidadeCaixa5.setText("-");

        sacola1Caixa5.setBackground(new java.awt.Color(255, 255, 255));

        labelSacola1Caixa5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSacola1Caixa5.setText("Sacola 1");

        labelSacola1QuantidadeCaixa5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelSacola1QuantidadeCaixa5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSacola1QuantidadeCaixa5.setText("-");

        javax.swing.GroupLayout sacola1Caixa5Layout = new javax.swing.GroupLayout(sacola1Caixa5);
        sacola1Caixa5.setLayout(sacola1Caixa5Layout);
        sacola1Caixa5Layout.setHorizontalGroup(
            sacola1Caixa5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sacola1Caixa5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sacola1Caixa5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelSacola1QuantidadeCaixa5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelSacola1Caixa5, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addContainerGap())
        );
        sacola1Caixa5Layout.setVerticalGroup(
            sacola1Caixa5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sacola1Caixa5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSacola1Caixa5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelSacola1QuantidadeCaixa5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        sacola2Caixa5.setBackground(new java.awt.Color(255, 255, 255));

        labelSacola2Caixa5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSacola2Caixa5.setText("Sacola 2");

        labelSacola2QuantidadeCaixa5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelSacola2QuantidadeCaixa5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSacola2QuantidadeCaixa5.setText("-");

        javax.swing.GroupLayout sacola2Caixa5Layout = new javax.swing.GroupLayout(sacola2Caixa5);
        sacola2Caixa5.setLayout(sacola2Caixa5Layout);
        sacola2Caixa5Layout.setHorizontalGroup(
            sacola2Caixa5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sacola2Caixa5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sacola2Caixa5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelSacola2Caixa5, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(labelSacola2QuantidadeCaixa5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        sacola2Caixa5Layout.setVerticalGroup(
            sacola2Caixa5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sacola2Caixa5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSacola2Caixa5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelSacola2QuantidadeCaixa5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        sacola3Caixa5.setBackground(new java.awt.Color(255, 255, 255));

        labelSacola3Caixa5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSacola3Caixa5.setText("Sacola 3");

        labelSacola3QuantidadeCaixa5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelSacola3QuantidadeCaixa5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSacola3QuantidadeCaixa5.setText("-");

        javax.swing.GroupLayout sacola3Caixa5Layout = new javax.swing.GroupLayout(sacola3Caixa5);
        sacola3Caixa5.setLayout(sacola3Caixa5Layout);
        sacola3Caixa5Layout.setHorizontalGroup(
            sacola3Caixa5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sacola3Caixa5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sacola3Caixa5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelSacola3Caixa5, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(labelSacola3QuantidadeCaixa5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        sacola3Caixa5Layout.setVerticalGroup(
            sacola3Caixa5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sacola3Caixa5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSacola3Caixa5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelSacola3QuantidadeCaixa5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        sacola4Caixa5.setBackground(new java.awt.Color(255, 255, 255));

        labelSacola4Caixa5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSacola4Caixa5.setText("Sacola 4");

        labelSacola4QuantidadeCaixa5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelSacola4QuantidadeCaixa5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSacola4QuantidadeCaixa5.setText("-");

        javax.swing.GroupLayout sacola4Caixa5Layout = new javax.swing.GroupLayout(sacola4Caixa5);
        sacola4Caixa5.setLayout(sacola4Caixa5Layout);
        sacola4Caixa5Layout.setHorizontalGroup(
            sacola4Caixa5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sacola4Caixa5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sacola4Caixa5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sacola4Caixa5Layout.createSequentialGroup()
                        .addComponent(labelSacola4Caixa5)
                        .addGap(0, 5, Short.MAX_VALUE))
                    .addComponent(labelSacola4QuantidadeCaixa5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        sacola4Caixa5Layout.setVerticalGroup(
            sacola4Caixa5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sacola4Caixa5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSacola4Caixa5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelSacola4QuantidadeCaixa5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        sacola5Caixa5.setBackground(new java.awt.Color(255, 255, 255));

        labelSacola5Caixa5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSacola5Caixa5.setText("Sacola 5");

        labelSacola5QuantidadeCaixa5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelSacola5QuantidadeCaixa5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSacola5QuantidadeCaixa5.setText("-");

        javax.swing.GroupLayout sacola5Caixa5Layout = new javax.swing.GroupLayout(sacola5Caixa5);
        sacola5Caixa5.setLayout(sacola5Caixa5Layout);
        sacola5Caixa5Layout.setHorizontalGroup(
            sacola5Caixa5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sacola5Caixa5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sacola5Caixa5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sacola5Caixa5Layout.createSequentialGroup()
                        .addComponent(labelSacola5Caixa5)
                        .addGap(0, 5, Short.MAX_VALUE))
                    .addComponent(labelSacola5QuantidadeCaixa5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        sacola5Caixa5Layout.setVerticalGroup(
            sacola5Caixa5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sacola5Caixa5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSacola5Caixa5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelSacola5QuantidadeCaixa5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout caixa5Layout = new javax.swing.GroupLayout(caixa5);
        caixa5.setLayout(caixa5Layout);
        caixa5Layout.setHorizontalGroup(
            caixa5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(caixa5Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(labelCaixa5, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(caixa5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelMonteCaixa5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelMonteQuantidadeCaixa5, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sacola1Caixa5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sacola2Caixa5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sacola3Caixa5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sacola4Caixa5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sacola5Caixa5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        caixa5Layout.setVerticalGroup(
            caixa5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(caixa5Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(caixa5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(caixa5Layout.createSequentialGroup()
                        .addGroup(caixa5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelCaixa5, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(caixa5Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(labelMonteCaixa5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelMonteQuantidadeCaixa5)))
                        .addGap(0, 12, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, caixa5Layout.createSequentialGroup()
                        .addGroup(caixa5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(sacola5Caixa5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sacola4Caixa5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sacola3Caixa5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sacola2Caixa5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sacola1Caixa5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );

        labelTransporte.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelTransporte.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTransporte.setText("Transporte");

        labelSacolasTranspotadas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSacolasTranspotadas.setText("Sacolas transportadas");

        labelSacolasTransportadasQuantidade.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        labelSacolasTransportadasQuantidade.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSacolasTransportadasQuantidade.setText("-");

        javax.swing.GroupLayout transporteLayout = new javax.swing.GroupLayout(transporte);
        transporte.setLayout(transporteLayout);
        transporteLayout.setHorizontalGroup(
            transporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transporteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(transporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTransporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelSacolasTranspotadas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelSacolasTransportadasQuantidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        transporteLayout.setVerticalGroup(
            transporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transporteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTransporte, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(labelSacolasTranspotadas)
                .addGap(18, 18, 18)
                .addComponent(labelSacolasTransportadasQuantidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(40, 40, 40))
        );

        labelAdvertencias.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelAdvertencias.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAdvertencias.setText("Advertências");

        labelAdvertenciasQuantidade.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        labelAdvertenciasQuantidade.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAdvertenciasQuantidade.setText("-");

        javax.swing.GroupLayout advertenciasLayout = new javax.swing.GroupLayout(advertencias);
        advertencias.setLayout(advertenciasLayout);
        advertenciasLayout.setHorizontalGroup(
            advertenciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(advertenciasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelAdvertencias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(advertenciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(advertenciasLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(labelAdvertenciasQuantidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        advertenciasLayout.setVerticalGroup(
            advertenciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(advertenciasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelAdvertencias, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(advertenciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(advertenciasLayout.createSequentialGroup()
                    .addGap(79, 79, 79)
                    .addComponent(labelAdvertenciasQuantidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(79, 79, 79)))
        );

        javax.swing.GroupLayout fundoLayout = new javax.swing.GroupLayout(fundo);
        fundo.setLayout(fundoLayout);
        fundoLayout.setHorizontalGroup(
            fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fundoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fundoLayout.createSequentialGroup()
                        .addGroup(fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(caixa2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(caixa3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(caixa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(transporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(fundoLayout.createSequentialGroup()
                        .addGroup(fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(caixa4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(caixa5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(advertencias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18))
        );
        fundoLayout.setVerticalGroup(
            fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fundoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(fundoLayout.createSequentialGroup()
                        .addComponent(caixa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(caixa2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(transporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(caixa3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(fundoLayout.createSequentialGroup()
                        .addComponent(caixa4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(caixa5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(advertencias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Simulador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Simulador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Simulador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Simulador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            Simulador.getInstancia().setVisible(true);
        });
        
        tarefaSimular = new TimerTask() {
                    @Override
                    public void run() {
                        Simulador.getInstancia().simular();
                    }
                };
        
        tarefaAtualizarGUI = new TimerTask() {
                    @Override
                    public void run() {
                        Simulador.getInstancia().atualizarInterface();
                    }
                };
        
        /* começa a invocação da tarefa a cada 1 segundo, começando com 3 segundos de atraso */
        new java.util.Timer().schedule(tarefaAtualizarGUI,3000,1000);
        
        /* começa a invocação da tarefa a cada 1 milissegundo, começando com 3 segundos de atraso */
        new java.util.Timer().schedule(tarefaSimular,3000,1);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel advertencias;
    private javax.swing.JPanel caixa1;
    private javax.swing.JPanel caixa2;
    private javax.swing.JPanel caixa3;
    private javax.swing.JPanel caixa4;
    private javax.swing.JPanel caixa5;
    private javax.swing.JPanel fundo;
    private javax.swing.JLabel labelAdvertencias;
    private javax.swing.JLabel labelAdvertenciasQuantidade;
    private javax.swing.JLabel labelCaixa1;
    private javax.swing.JLabel labelCaixa2;
    private javax.swing.JLabel labelCaixa3;
    private javax.swing.JLabel labelCaixa4;
    private javax.swing.JLabel labelCaixa5;
    private javax.swing.JLabel labelMonteCaixa1;
    private javax.swing.JLabel labelMonteCaixa2;
    private javax.swing.JLabel labelMonteCaixa3;
    private javax.swing.JLabel labelMonteCaixa4;
    private javax.swing.JLabel labelMonteCaixa5;
    private javax.swing.JLabel labelMonteQuantidadeCaixa1;
    private javax.swing.JLabel labelMonteQuantidadeCaixa2;
    private javax.swing.JLabel labelMonteQuantidadeCaixa3;
    private javax.swing.JLabel labelMonteQuantidadeCaixa4;
    private javax.swing.JLabel labelMonteQuantidadeCaixa5;
    private javax.swing.JLabel labelSacola1Caixa1;
    private javax.swing.JLabel labelSacola1Caixa2;
    private javax.swing.JLabel labelSacola1Caixa3;
    private javax.swing.JLabel labelSacola1Caixa4;
    private javax.swing.JLabel labelSacola1Caixa5;
    private javax.swing.JLabel labelSacola1QuantidadeCaixa1;
    private javax.swing.JLabel labelSacola1QuantidadeCaixa2;
    private javax.swing.JLabel labelSacola1QuantidadeCaixa3;
    private javax.swing.JLabel labelSacola1QuantidadeCaixa4;
    private javax.swing.JLabel labelSacola1QuantidadeCaixa5;
    private javax.swing.JLabel labelSacola2Caixa1;
    private javax.swing.JLabel labelSacola2Caixa2;
    private javax.swing.JLabel labelSacola2Caixa3;
    private javax.swing.JLabel labelSacola2Caixa4;
    private javax.swing.JLabel labelSacola2Caixa5;
    private javax.swing.JLabel labelSacola2QuantidadeCaixa1;
    private javax.swing.JLabel labelSacola2QuantidadeCaixa2;
    private javax.swing.JLabel labelSacola2QuantidadeCaixa3;
    private javax.swing.JLabel labelSacola2QuantidadeCaixa4;
    private javax.swing.JLabel labelSacola2QuantidadeCaixa5;
    private javax.swing.JLabel labelSacola3Caixa1;
    private javax.swing.JLabel labelSacola3Caixa2;
    private javax.swing.JLabel labelSacola3Caixa3;
    private javax.swing.JLabel labelSacola3Caixa4;
    private javax.swing.JLabel labelSacola3Caixa5;
    private javax.swing.JLabel labelSacola3QuantidadeCaixa1;
    private javax.swing.JLabel labelSacola3QuantidadeCaixa2;
    private javax.swing.JLabel labelSacola3QuantidadeCaixa3;
    private javax.swing.JLabel labelSacola3QuantidadeCaixa4;
    private javax.swing.JLabel labelSacola3QuantidadeCaixa5;
    private javax.swing.JLabel labelSacola4Caixa1;
    private javax.swing.JLabel labelSacola4Caixa2;
    private javax.swing.JLabel labelSacola4Caixa3;
    private javax.swing.JLabel labelSacola4Caixa4;
    private javax.swing.JLabel labelSacola4Caixa5;
    private javax.swing.JLabel labelSacola4QuantidadeCaixa1;
    private javax.swing.JLabel labelSacola4QuantidadeCaixa2;
    private javax.swing.JLabel labelSacola4QuantidadeCaixa3;
    private javax.swing.JLabel labelSacola4QuantidadeCaixa4;
    private javax.swing.JLabel labelSacola4QuantidadeCaixa5;
    private javax.swing.JLabel labelSacola5Caixa1;
    private javax.swing.JLabel labelSacola5Caixa2;
    private javax.swing.JLabel labelSacola5Caixa3;
    private javax.swing.JLabel labelSacola5Caixa4;
    private javax.swing.JLabel labelSacola5Caixa5;
    private javax.swing.JLabel labelSacola5QuantidadeCaixa1;
    private javax.swing.JLabel labelSacola5QuantidadeCaixa2;
    private javax.swing.JLabel labelSacola5QuantidadeCaixa3;
    private javax.swing.JLabel labelSacola5QuantidadeCaixa4;
    private javax.swing.JLabel labelSacola5QuantidadeCaixa5;
    private javax.swing.JLabel labelSacolasTransportadasQuantidade;
    private javax.swing.JLabel labelSacolasTranspotadas;
    private javax.swing.JLabel labelTransporte;
    private javax.swing.JPanel sacola1Caixa1;
    private javax.swing.JPanel sacola1Caixa2;
    private javax.swing.JPanel sacola1Caixa3;
    private javax.swing.JPanel sacola1Caixa4;
    private javax.swing.JPanel sacola1Caixa5;
    private javax.swing.JPanel sacola2Caixa1;
    private javax.swing.JPanel sacola2Caixa2;
    private javax.swing.JPanel sacola2Caixa3;
    private javax.swing.JPanel sacola2Caixa4;
    private javax.swing.JPanel sacola2Caixa5;
    private javax.swing.JPanel sacola3Caixa1;
    private javax.swing.JPanel sacola3Caixa2;
    private javax.swing.JPanel sacola3Caixa3;
    private javax.swing.JPanel sacola3Caixa4;
    private javax.swing.JPanel sacola3Caixa5;
    private javax.swing.JPanel sacola4Caixa1;
    private javax.swing.JPanel sacola4Caixa2;
    private javax.swing.JPanel sacola4Caixa3;
    private javax.swing.JPanel sacola4Caixa4;
    private javax.swing.JPanel sacola4Caixa5;
    private javax.swing.JPanel sacola5Caixa1;
    private javax.swing.JPanel sacola5Caixa2;
    private javax.swing.JPanel sacola5Caixa3;
    private javax.swing.JPanel sacola5Caixa4;
    private javax.swing.JPanel sacola5Caixa5;
    private javax.swing.JPanel transporte;
    // End of variables declaration//GEN-END:variables
}
