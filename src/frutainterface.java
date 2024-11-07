import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

public class frutainterface {

    private Set<String> frutas;  //campo para armazenar frutas
    private JTextField campoAdicionarFruta;
    private JTextField campoResultado;

    public frutainterface() {
        frutas = new HashSet<>();  //conjunto de frutas
        criarInterface();
    }

    private void criarInterface() {
        //frame principal
        JFrame frame = new JFrame("Sistema de Gerenciamento de Frutas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLayout(new BorderLayout());

        //adicionar frutas
        JLabel labelAdicionarFruta = new JLabel("Nome da Fruta:");
        campoAdicionarFruta = new JTextField(20);

        JPanel painelEntrada = new JPanel();
        painelEntrada.setLayout(new FlowLayout());
        painelEntrada.add(labelAdicionarFruta);
        painelEntrada.add(campoAdicionarFruta);

        //todos os botoes
        JButton botaoAdicionarFruta = new JButton("Adicionar Fruta");
        JButton botaoRemoverFruta = new JButton("Remover Fruta");
        JButton botaoVerificarFruta = new JButton("Verificar Fruta");
        JButton botaoListarFrutas = new JButton("Listar Frutas");

        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new FlowLayout());
        painelBotoes.add(botaoAdicionarFruta);
        painelBotoes.add(botaoRemoverFruta);
        painelBotoes.add(botaoVerificarFruta);
        painelBotoes.add(botaoListarFrutas);

        //tela de resultado
        JLabel labelResultado = new JLabel("Resultado: ");
        campoResultado = new JTextField(30);
        campoResultado.setEditable(false);

        JPanel painelResultado = new JPanel();
        painelResultado.setLayout(new FlowLayout());
        painelResultado.add(labelResultado);
        painelResultado.add(campoResultado);

        //posição dos paineis
        frame.add(painelEntrada, BorderLayout.NORTH);
        frame.add(painelBotoes, BorderLayout.CENTER);
        frame.add(painelResultado, BorderLayout.SOUTH);

        //Adicionar fruta
        botaoAdicionarFruta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fruta = campoAdicionarFruta.getText().trim();
                if (!fruta.isEmpty()) {
                    if (frutas.add(fruta)) {
                        campoResultado.setText(fruta + " foi adicionada.");
                    } else {
                        campoResultado.setText(fruta + " já está presente.");
                    }
                } else {
                    campoResultado.setText("Digite o nome de uma fruta.");
                }
            }
        });

        //Remover fruta
        botaoRemoverFruta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fruta = campoAdicionarFruta.getText().trim();
                if (frutas.remove(fruta)) {
                    campoResultado.setText(fruta + " foi removida.");
                } else {
                    campoResultado.setText(fruta + " não foi encontrada.");
                }
            }
        });

        //Verificar fruta
        botaoVerificarFruta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fruta = campoAdicionarFruta.getText().trim();
                if (frutas.contains(fruta)) {
                    campoResultado.setText(fruta + " está presente no conjunto.");
                } else {
                    campoResultado.setText(fruta + " não foi encontrada.");
                }
            }
        });

        //Listar frutas
        botaoListarFrutas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (frutas.isEmpty()) {
                    campoResultado.setText("Nenhuma fruta cadastrada.");
                } else {
                    campoResultado.setText("Frutas: " + frutas.toString());
                }
            }
        });

        //Exibir a interface, deixar visivel
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Executa a interface gráfica
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new frutainterface();
            }
        });
    }
}
