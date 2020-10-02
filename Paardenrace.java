import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class Paardenrace extends JFrame implements ActionListener {
    private JButton StartButton;
    private JPanel panel;
    private Paard Herke = new Paard("Herke");
    private Paard Yuri = new Paard("Yuri");

    public static void main(String[] args) {
        Paardenrace frame = new Paardenrace();
        frame.setSize(600, 700);
        frame.createGUI();
        frame.setVisible(true);
    }

    void createGUI() {
        System.out.println("Paard Herke is de ingevulde rectangle\nPaard Yuri is de oningevulde rectangle");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());
        StartButton = new JButton("Start");
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(550, 540));
        window.add(panel);
        window.add(StartButton);
        StartButton.addActionListener(this);
    }
    public void StartRace(){
        while (Herke.getAfstand()< 500 && Yuri.getAfstand()<500){
            Herke.loop();
            Yuri.loop();
            pause(200);
            Graphics paper = panel.getGraphics();
            paper.clearRect(0, 0 , 700, 700);
            paper.fillRect(0,  180,  Herke.getAfstand(), 10);
            paper.drawRect(0, 360, Yuri.getAfstand(), 10);
            paper.drawLine(500,370, 500, 180);

        }
        if (Herke.getAfstand() > Yuri.getAfstand()){
            System.out.println("Paard Herke heeft gewonnen");
            System.exit(0);
        } else if(Yuri.getAfstand() > Herke.getAfstand()) {
            // ik had dit eerst met een else statement gedaan, maar dan werdt de line 2 keer geprint.
            // en ik heb geen idee hoe dat komt.
            System.out.println("Paard Yuri heeft gewonnen");
            System.exit(0);
        }
    }
    public void pause(int mSec) {
        try {
            Thread.sleep(mSec);
        } catch (InterruptedException e) {
            System.out.println("Pauze intteruptie");
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        StartRace();
        
    }
}

