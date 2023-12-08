package main;

import java.awt.Point;
import java.awt.Color;
import java.awt.Graphics;

public class FigurFactory {
    
    // Abstracte Klassen
    private abstract class Figur {
        protected String name;
        protected Point position;
        protected Color color;
        protected boolean gefuellt;
        protected Point size;


        public Figur(String name) {
            this.name = name;
        }

        public void setPosition(Point position) {
            this.position = position;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        public void setFuelle(boolean gefuellt) {
            this.gefuellt = gefuellt;
        }

        public void setSize(Point size) {
            this.size = size;
        }

        public abstract void draw(Graphics g);    
    }

    // Child Klassen
    // Kreis Klasse
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

    // Viereck Klasse
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

    // Dreieck Klasse
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

    // Oval Klasse
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
}
