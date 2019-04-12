package com.stas.game;

import java.util.ArrayList;

class Field {

    private int width;
    private int height;
    private int score;


    private int[][] massive;

    Field(int width, int height) {
        this.width = width;
        this.height = height;
        massive = new int[height][width];
    }

    int getWidth() {
        return width;
    }

    int getHeight() {
        return height;
    }

    Integer getValue(int x, int y) {
        if (x >= 0 && x < width && y >= 0 && y < height)
            return massive[y][x];

        return null;
    }

    void setValue(int x, int y, int value) {
        if (x >= 0 && x < width && y >= 0 && y < height)
            massive[y][x] = value;
    }

    void print() {

        int[][] printed = new int[height][width];


        for (int i = 0; i < height; i++) {
            if (width >= 0)
                System.arraycopy(massive[i], 0, printed[i], 0, width);
        }

        int left = Main.tetris.getFigure().getX();
        int top = Main.tetris.getFigure().getY();
        int[][] sqrMassive = Main.tetris.getFigure().getMassive();

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                if (top + i >= height || left + j >= width) continue;

                if (sqrMassive[i][j] == 1)

                    printed[top + i][left + j] = 2;
            }
        }



        System.out.println("---------------------------------------------------------------------------\n");

        for (int i = 0; i < height; i++) {

            for (int j = 0; j < width; j++) {

                int index = printed[i][j];

                if (index == 0)
                    System.out.print(" . ");

                else if (index == 1)
                    System.out.print((char) 27 + "[34m O " + (char)27 + "[0m");

                else if (index == 2)
                    System.out.print((char) 27 + "[34m O " + (char)27 + "[0m");

            }
            System.out.println();
        }


        System.out.println();
        System.out.println();
    }

    void removeLine() {

        ArrayList<int[]>list = new ArrayList<>();


        for (int i = 0; i <getHeight(); i++) {

            int count=0;

            for (int j = 0; j <getWidth() ; j++) {
                count+= massive[i][j];
                score+=count;
            }
            if(count!=width)list.add(massive[i]);
        }

        while (list.size() < height){
            list.add(0,new int[width]);
        }

        massive = list.toArray(new int[height][width]);
    }

    int getScore() {
        return score;
    }
}






