package byog.lab5;

import org.junit.Test;

import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {
    private static final int WIDTH = 60, HEIGHT = 60;

    public static class Position {
        private final int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int x() {
            return x;
        }

        public int y() {
            return y;
        }
    }

    private static void fillWorld(TETile[][] world, int width, int height) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                world[i][j] = Tileset.NOTHING;
            }
        }
    }

    /* p is the left bound of the line */
    private static void addLine(TETile[][] world, Position p, int length, TETile pattern) {
        for (int i = 0; i < length; i++) {
            world[p.x() + i][p.y()] = pattern;
        }
    }

    /* p is the lower left point of the hexagon */
    public static void addHexagon(TETile[][] world, Position p, int size, TETile pattern) {
        for (int i = 0; i < size; i++) {
            addLine(world, new Position(p.x() - i, p.y() + i), size + 2 * i, pattern);
            addLine(world, new Position(p.x() - i, p.y() + 2 * size - 1 - i), size + 2 * i, pattern);
        }
    }

    public static void main(String[] args) {
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);

        TETile[][] world = new TETile[WIDTH][HEIGHT];
        fillWorld(world, WIDTH, HEIGHT);

        Position startPos = new Position(20, 20);
        addHexagon(world, startPos, 5, Tileset.WALL);

        ter.renderFrame(world);
    }
}
