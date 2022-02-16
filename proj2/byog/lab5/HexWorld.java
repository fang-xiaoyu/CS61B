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
    private final static int WIDTH = 60;
    private final static int HEIGHT = 60;
    public static final long SEED = 1111;
    public static final Random RANDOM = new Random(SEED);

    private static TETile randomTile() {
        int tileNum = RANDOM.nextInt(5);
        switch (tileNum) {
            case 0: return Tileset.TREE;
            case 1: return Tileset.FLOWER;
            case 2: return Tileset.GRASS;
            case 3: return Tileset.SAND;
            case 4: return Tileset.MOUNTAIN;
            default: return Tileset.NOTHING;
        }
    }

    public static void addHexagon(TETile[][] world, int size, int width, int height, TETile item) {
        /** 1. world: the world
         *  2. size: size of the Hexagon
         *  3. width: width offset of the Hexagon
         *  4. height: height offset of the Hexagon
         *  5. item: random or specific
         */
        // out of index
        int maxWidth = width + 3 * size - 2;
        int maxHeight = height + 3 * size - 2;
        if (height < 0 || maxHeight >= HEIGHT || width < 0 || maxWidth >= WIDTH) {
            System.out.println("Out of the world!");
            return;
        }
        // draw
        if (item == null) {
            item = randomTile();
        }

        for (int layer = 0; layer < size; layer++) {
            int widIndentation = size - layer - 1;            // calculate the offset of width
            int heiIndentation = 2 * size - layer - 1;        // calculate the opposite row
            int numPerLayer = size + 2 * layer;               // calculate the number of thins at this layer
            for (int wid = 0; wid < numPerLayer; wid++) {
                world[width + wid + widIndentation][height + layer] = item;
                world[width + wid + widIndentation][height + heiIndentation] = item;
            }
        }
    }

    public static void columnGenerator(TETile[][] world, int size, int width, int height, int num) {
        while (num > 0) {
            addHexagon(world, size, width, height, null);
            height = height + 2 * size;
            num -= 1;
        }
    }

    public static void worldGenerator(TETile[][] world, int size, int width, int height) {
        int firstColumnWidth = width;
        int firstColumnHeight = height + 2 * size;
        int widthAdd = 2 * size - 1;
        int heightAdd = size;
        columnGenerator(world, size, firstColumnWidth, firstColumnHeight, 3);
        columnGenerator(world, size, firstColumnWidth + widthAdd, firstColumnHeight - heightAdd, 4);
        columnGenerator(world, size, firstColumnWidth + widthAdd * 2, firstColumnHeight - heightAdd * 2, 5);
        columnGenerator(world, size, firstColumnWidth + widthAdd * 3, firstColumnHeight - heightAdd, 4);
        columnGenerator(world, size, firstColumnWidth + widthAdd * 4, firstColumnHeight, 3);
    }

    public static void main(String[] args) {
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);

        TETile[][] world = new TETile[WIDTH][HEIGHT];
        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                world[x][y] = Tileset.NOTHING;
            }
        }

        worldGenerator(world, 3, 10, 10);
        ter.renderFrame(world);
    }
}
