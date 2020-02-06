import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.text.DateFormat;
import java.util.Date;


public class APP implements ActionListener {
    private JLabel contribuintes;
    private JTextField campodata, numeroContribuintes;
    private JMenuBar mnBarra;
    private JMenu mnSobre;
    private Image iconeTitulo;
    private ImageIcon background = new ImageIcon(getClass().getResource("programming-flag.png"));
    private JLabel fundo, auxiliar;
    private javax.swing.Timer timer;


    private JMenuItem miAutores;
    //private JMenu mnExportar;
    //private JMenu miSair;
    private JFrame jFramePrincipal;
    private JButton botaoIniciar, feito;


    public APP() {
        jFramePrincipal = new JFrame("Real time codding");
        mnBarra = new JMenuBar();
        //miSair = new JMenu("Sair");
        contribuintes = new JLabel("Quantidade de participantes");
        numeroContribuintes = new JTextField();
        campodata = new JTextField();
        mnSobre = new JMenu("Sobre");
        feito = new JButton("Feito");
        //mnExportar  = new JMenu("Exportar Classe java");
        botaoIniciar = new JButton("Iniciar");
        miAutores = new JMenuItem("Info autores");

        inicializarComponentes();

    }

    public void inicializarComponentes() {

        Image img = background.getImage();
        Image temp = img.getScaledInstance(900, 650, Image.SCALE_SMOOTH);
        background = new ImageIcon(temp);
        fundo = new JLabel(background);
        fundo.setLayout(null);
        auxiliar = new JLabel(background);
        jFramePrincipal.setContentPane(auxiliar);


        mnBarra.add(mnSobre);
        //mnBarra.add(mnExportar);
        //miSair.addActionListener(this);
        botaoIniciar.addActionListener(this);
        mnSobre.add(miAutores);
        miAutores.addActionListener(this);
        feito.addActionListener(this);
        jFramePrincipal.setJMenuBar(mnBarra);
        jFramePrincipal.add(numeroContribuintes);
        jFramePrincipal.add(contribuintes);
        jFramePrincipal.add(feito);

        jFramePrincipal.add(botaoIniciar);
        URL path = this.getClass().getResource("programming-flag.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(path);

        jFramePrincipal.setIconImage(iconeTitulo);

        botaoIniciar.setBounds(380, 520, 150, 30);

        botaoIniciar.setEnabled(false);
        numeroContribuintes.setBounds(380, 470, 150, 30);
        contribuintes.setBounds(180, 470, 200, 30);
        feito.setBounds(540, 470, 100, 30);
        jFramePrincipal.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFramePrincipal.getContentPane().setLayout(null);
        jFramePrincipal.setPreferredSize(new java.awt.Dimension(900, 650));
        jFramePrincipal.pack();
        jFramePrincipal.setLocationRelativeTo(null);
        jFramePrincipal.setResizable(false);
        //HORA E DATA
        Date data = new Date();
        DateFormat sdf = DateFormat.getDateInstance(DateFormat.DEFAULT);
        //System.out.println(formatador.format(data));
        campodata.setText(sdf.format(data));
        campodata.setBounds(730, 10, 100, 50);
        campodata.setBorder(new LineBorder(Color.WHITE, 0, false));
        campodata.setFont(new Font("arial", Font.BOLD, 16));
        jFramePrincipal.add(campodata);
        campodata.setEnabled(false);
        //feito.setEnabled(false);
        contribuintes.setFont(new Font("arial", Font.CENTER_BASELINE, 14));
        numeroContribuintes.setFont(new Font("arial", Font.CENTER_BASELINE, 14));
        jFramePrincipal.getRootPane().setDefaultButton(botaoIniciar);

    }


    @Override
    public void actionPerformed(ActionEvent e) {


        if ((!numeroContribuintes.getText().trim().isEmpty()) && (e.getSource().equals(feito))) {
            System.out.println(numeroContribuintes.getText());
            botaoIniciar.setEnabled(true);
            feito.setEnabled(false);
            numeroContribuintes.setEditable(false);

        }

        if (e.getSource().equals(botaoIniciar)) {
        } else if (e.getSource().equals(miAutores)) {
            JOptionPane.showMessageDialog(null, "Ainda não implementado");
        }

    }


    public static void main(String[] args) {
        try {

            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        APP principal = new APP();
        principal.jFramePrincipal.setVisible(true);

    }


}
