package main;

import java.awt.Point;
import java.awt.Color;
import java.awt.Graphics;

public abstract class Figur {
        protected String name;
        protected Point position;
        protected Color color;
        protected boolean gefuellt;
        protected Point size;


        public Figur(String name) {
            this.name = name;
        }

        public Figur setPosition(Point position) {
            this.position = position;
            return this;
        }

        public Figur setColor(Color color) {
            this.color = color;
            return this;
        }

        public Figur setFuelle(boolean gefuellt) {
            this.gefuellt = gefuellt;
            return this;
        }

        public Figur setSize(Point size) {
            this.size = size;
            return this;
        }

        public Figur build(){
            return this;
        }

        public abstract void draw(Graphics g);    
    }