package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Timer;

public class FigurenPannel extends javax.swing.JPanel {

    private ArrayList<Figur> FigurenListe;
    private ArrayList<Color> ColorList;
    private Point pannelSize = new Point(400, 300);
    private Timer myTimer;

    
    public FigurenPannel() {
        FigurenListe = new ArrayList<>();
        ColorList = new ArrayList<>();

        initComponents();
        initColorSet();
        initTimer();
        setBackground(Color.gray);

        initFiguren();
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
        FigurenListe.add( new Kreis());
        FigurenListe.add( new Viereck());
        FigurenListe.add(new Dreieck());
        FigurenListe.add( new Oval());
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

    // Asbtract Class
    private abstract class Figur {
        protected String name;
        protected Point position;
        protected Color color;
        protected boolean gefuellt;
        protected Point size;


        public Figur(String name) {
            this.name = name;
            this.position = getRandomPosition();
            this.color = getRandomColor();
            this.gefuellt = getRandomFuelle();
            this.size = getRandomSize();
        }

        public void setColor(Color color) {
            this.color = color;
        }

        public void setFuelle(boolean gefuellt) {
            this.gefuellt = gefuellt;
        }

        

        public abstract void draw(Graphics g);    
    }


    // Figur Classen
    private class Kreis extends Figur{

        private int durchmesser;
        public Kreis(){
            super("Kreis");
            this.durchmesser = size.x;
        }

        @Override
        public void draw(Graphics g) {
            g.setColor(color);
            if (!gefuellt) {
                g.drawOval(position.x, position.y, durchmesser, durchmesser);
            } else {
                g.fillOval(position.x, position.y, durchmesser, durchmesser);
            }
            
        }
    }

    private class Viereck extends Figur{

        public Viereck(){
            super("Viereck");
        }

        @Override
        public void draw(Graphics g) {
            g.setColor(color);
            if (!gefuellt) {
                g.drawRect(position.x, position.y, size.x, size.y);
            } else {
                g.fillRect(position.x, position.y, size.x, size.y);
            }
        }
    }

    private class Dreieck extends Figur {
        private int[] xPoints;
        private int[] yPoints;

        public Dreieck() {
            super("Dreieck");
            initializeDreieck();
        }

        private void initializeDreieck() {
            xPoints = new int[] { position.x, position.x + size.x, position.x - size.x };
            yPoints = new int[] { position.y, position.y + size.y, position.y + size.y };
        }

        @Override
        public void draw(Graphics g) {
            g.setColor(color);

            if (!gefuellt) {
                g.drawPolygon(xPoints, yPoints, 3);
            } else {
                g.fillPolygon(xPoints, yPoints, 3);
            }
        }
    }

    private class Oval extends Figur{

        public Oval(){
            super("Oval");
        }

        @Override
        public void draw(Graphics g) {
            g.setColor(color);
            if (!gefuellt) {
                g.drawOval(position.x, position.y, size.x, size.y);
            } else {
                g.fillOval(position.x, position.y, size.x, size.y);
            }
            
        }
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
