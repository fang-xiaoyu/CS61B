package byog.Core;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

public class Game {
    TERenderer ter = new TERenderer();
    /* Feel free to change the width and height. */
    public static final int WIDTH = 80;
    public static final int HEIGHT = 80;
    public RandomUtils ru;

    /**
     * Method used for playing a fresh game. The game should start from the main menu.
     */
    public void playWithKeyboard() {
    }

    /**
     * Method used for autograding and testing the game code. The input string will be a series
     * of characters (for example, "n123sswwdasdassadwas", "n123sss:q", "lwww". The game should
     * behave exactly as if the user typed these characters into the game after playing
     * playWithKeyboard. If the string ends in ":q", the same world should be returned as if the
     * string did not end with q. For example "n123sss" and "n123sss:q" should return the same
     * world. However, the behavior is slightly different. After playing with "n123sss:q", the game
     * should save, and thus if we then called playWithInputString with the string "l", we'd expect
     * to get the exact same world back again, since this corresponds to loading the saved game.
     * @param input the input string to feed to your program
     * @return the 2D TETile[][] representing the state of the world
     */
    public TETile[][] playWithInputString(String input) {
        // TODO: Fill out this method to run the game using the input passed in,
        // and return a 2D tile representation of the world that would have been
        // drawn if the same inputs had been given to playWithKeyboard().
        String mode = input.substring(0, 1);
        String seed = input.substring(1);
        Random random = new Random(Integer.parseInt(seed));
        TETile[][] finalWorldFrame = new TETile[WIDTH][HEIGHT];

        /** 1. 初始化世界 */
        TETile[][] initWorld = new TETile[WIDTH][HEIGHT];
        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                initWorld[x][y] = Tileset.NOTHING;
            }
        }

        /** 2. 随机生成房间的地砖 */
        int roomNum = ru.uniform(random, 5, 10);
        TETile[][] brickWorld = new TETile[WIDTH][HEIGHT];
        for (int k = 0; k < roomNum; k++) {
            int initWidPos = ru.uniform(random, 0, WIDTH - 10);
            int initHeiPos = ru.uniform(random, 0, HEIGHT - 10);
            int roomWidth = ru.uniform(random, 1, 10);
            int roomHeight = ru.uniform(random, 1, 10);
            for (int i = initWidPos; i < roomWidth + initWidPos; i++) {
                for (int j = initHeiPos; j < roomHeight + initHeiPos; j++) {
                    brickWorld[i][j] = Tileset.FLOOR;
                }
            }
        }


        return brickWorld;
    }


}
