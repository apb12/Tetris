package com.stas.game;

class FigureFabric {

    private static final int[][][] SQRE = {{
            {1, 1, 0},
            {0, 1, 1},
            {0, 0, 0}}, {

            {1, 0, 0},
            {1, 1, 0},
            {0, 1, 0}}, {

            {0, 1, 0},
            {0, 1, 0},
            {0, 1, 0}}, {

            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 0}}, {

            {1, 1, 1},
            {0, 1, 0},
            {0, 0, 0}}, {

            {1, 0, 0},
            {1, 0, 0},
            {1, 1, 0}}, {

            {0, 0, 1},
            {0, 0, 1},
            {0, 1, 1}}, {

            {0, 1, 0},
            {1, 1, 1},
            {0, 1, 0}}, {

            {0, 0, 0},
            {0, 1, 0},
            {1, 1, 1}}, {

            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}}
    };

    static Figure createFigure(int x, int y) {
        int index = (int) (Math.random() * 10);
        return new Figure(x, y, SQRE[index]);
    }
}