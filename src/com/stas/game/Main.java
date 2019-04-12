package com.stas.game;
import java.awt.event.KeyEvent;

public class Main {

private Field field;
private Figure figure;
private boolean gameOver;

private Main(int width, int height) {

        field = new Field(width, height);
        figure = null;
        }

Field getField() {
        return field;
        }

Figure getFigure() {

            return figure;
        }

private void run() throws Exception {

        KeyboardListener keyboardListener = new KeyboardListener();
        keyboardListener.start();

        gameOver = false;

        figure = FigureFabric.createFigure(field.getWidth() / 2, 0);

        while (!gameOver) {

        if (keyboardListener.hasKeyEvents()) {

        KeyEvent event = keyboardListener.getEventFromTop();

        if (event.getKeyChar() == 'q') return;
        if(event.getKeyChar() == 'p'){
            System.out.println((char) 27 + "[33m PAUSE 10 SEC,BE READY " + (char)27 + "[0m");
           Thread.sleep(10000);}

        if (event.getKeyCode() == KeyEvent.VK_LEFT)
        figure.left();

        else if (event.getKeyCode() ==  KeyEvent.VK_RIGHT)
        figure.right();

        else if (event.getKeyCode() ==  KeyEvent.VK_UP)
        figure.rotate();

        else if (event.getKeyCode() ==  KeyEvent.VK_DOWN)
        figure.fastDown();
        }

        step();
        field.print();
        Thread.sleep(600);
        }


        System.out.println((char) 27 + "[31m GAME OVER!!! " + (char)27 + "[0m");
        }

 private void step() {
        figure.down();
               System.out.println("YOUR SCORE IS : " +field.getScore());


        if (!figure.chekPosition()) {
        figure.up();
        figure.isLanded();


        gameOver = figure.getY() <= 1;

        field.removeLine();


        figure = FigureFabric.createFigure(field.getWidth() / 2, 0);

        }
        }




static Main tetris;
public static void main(String[] args) throws Exception{


        tetris = new Main(12, 20);
        tetris.run();
        }

        }