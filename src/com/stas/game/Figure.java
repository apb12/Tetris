package com.stas.game;

class Figure {

    private int[][] massive;

    private int x;
    private int y;



    Figure(int x, int y, int[][] massive) {
        this.x = x;
        this.y = y;
        this.massive = massive;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    int[][] getMassive() {
        return massive;
    }

    void rotate() {
        int[][] massiveTemp = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                massiveTemp[i][j] = massive[j][i];
            }
        } massive = massiveTemp;
    }

    void left() {
        x--;
        if (!chekPosition())
            x++;
    }

    void right() {
        x++;
        if (!chekPosition())
            x--;
    }

    void up() {
        y--;
    }

    void down() {
        y++;
    }

    void fastDown() {
        while (chekPosition()) {
            y++;
        }y--;
    }

    boolean chekPosition() {
        Field field = Main.tetris.getField();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (massive[i][j] == 1) {
                    if (y + i >= field.getHeight())
                        return false;

                    Integer value = field.getValue(x + j, y + i);
                    if (value == null || value == 1)
                        return false;
                }
            }
        } return true;
    }

    void isLanded() {
        Field field = Main.tetris.getField();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (massive[i][j] == 1)
                    field.setValue(x + j, y + i, 1);

            }
        }
    }
}

