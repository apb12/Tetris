package com.stas.igra;


import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

     class KeyboardListener extends Thread
    {
        private Queue<KeyEvent> keyEvents = new ArrayBlockingQueue<>(100);

        @Override
        public void run()
        {
            JFrame frame = new JFrame("Tetris");
            frame.setTitle("Tetris");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.setUndecorated(true);
            frame.setSize(400, 400);
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setLayout(new GridBagLayout());

            frame.setOpacity(0.0f);
            frame.setVisible(true);

            frame.addFocusListener(new FocusListener()
            {
                @Override
                public void focusGained(FocusEvent e)
                {

                }

                @Override
                public void focusLost(FocusEvent e)
                {
                    System.exit(0);
                }
            });


            frame.addKeyListener(new KeyListener()
            {

                public void keyTyped(KeyEvent e)
                {

                }

                public void keyReleased(KeyEvent e)
                {

                }

                public void keyPressed(KeyEvent e)
                {
                    keyEvents.add(e);
                }
            });
        }


         boolean hasKeyEvents()
        {
            return !keyEvents.isEmpty();
        }

         KeyEvent getEventFromTop()
        {
            return keyEvents.poll();
        }
    }

