package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Timer;
import javax.swing.JPanel;

public class FigurenPannel extends JPanel{

    private ArrayList<Figur> FigurenListe;
    private ArrayList<Color> ColorList;
    private Point pannelSize = new Point(400, 300);
    private Timer myTimer;
    private FigurFactory figurFactory;

    public FigurenPannel() {
        FigurenListe = new ArrayList<>();
        ColorList = new ArrayList<>();
        figurFactory = new FigurFactory();

        initComponents();
        initColorSet();
        initFiguren();
        setBackground(Color.gray);
        initTimer();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        for (Figur figur : FigurenListe) {
            figur.draw(g);
        }
    }

    private void initTimer(){
        myTimer = new Timer(300, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initFiguren();
                repaint();
                pannelSize = new Point(getWidth(), getHeight());
                System.out.println(FigurenListe.size());
            } 
        });
        myTimer.start();
    }

    private void initFiguren(){
        FigurenListe.add(figurFactory.getKreis(getRandomPosition(), getRandomColor(), getRandomFuelle(), getRandomSize()));
        FigurenListe.add(figurFactory.getViereck(getRandomPosition(), getRandomColor(), getRandomFuelle(), getRandomSize()));
        FigurenListe.add(figurFactory.getDreieck(getRandomPosition(), getRandomColor(), getRandomFuelle(), getRandomSize()));
        FigurenListe.add(figurFactory.getOval(getRandomPosition(), getRandomColor(), getRandomFuelle(), getRandomSize()));
    }

    private Color getRandomColor(){
        Random random = new Random();
        return ColorList.get(random.nextInt(ColorList.size()));
    }

    private boolean getRandomFuelle(){
        Random random = new Random();
        return random.nextBoolean();
    }

    private Point getRandomPosition() {
        Random random = new Random();
        return new Point(random.nextInt(pannelSize.x), random.nextInt(pannelSize.y));
    }

    private Point getRandomSize(){
        Random random = new Random();
        return new Point(random.nextInt(400), random.nextInt(400));
    }
    private void initColorSet(){
        ColorList.add(Color.black);
        ColorList.add(Color.blue);
        ColorList.add(Color.cyan);
        ColorList.add(Color.darkGray);
        ColorList.add(Color.gray);
        ColorList.add(Color.green);
        ColorList.add(Color.lightGray);
        ColorList.add(Color.magenta);
        ColorList.add(Color.orange);
        ColorList.add(Color.pink);
        ColorList.add(Color.red);
        ColorList.add(Color.white);
        ColorList.add(Color.yellow);
        ColorList.remove(getBackground());
    }
    
    @SuppressWarnings("unchecked")
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }
}
