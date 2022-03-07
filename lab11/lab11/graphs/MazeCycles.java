package lab11.graphs;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdDraw;

/**
 *  @author Josh Hug
 */
public class MazeCycles extends MazeExplorer {
    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */
    private Stack<Integer> stack;
    private Maze maze;


    public MazeCycles(Maze m) {
        super(m);
        maze = m;
        distTo[0] = 0;
        edgeTo[0] = 0;
        stack = new Stack<>();
    }

    @Override
    public void solve() {
        // TODO: Your code here!
        solveHelper(0);
    }

    // Helper methods go here
    private void solveHelper(int v) {
        marked[v] = true;
        announce();

        for (int w: maze.adj(v)) {
            if (w == edgeTo[v]) {
                continue;
            }
            if (marked[w]) {
                drawCircle(w, v);
                return;
            }
            edgeTo[w] = v;
            distTo[w] = distTo[v] + 1;
            announce();
            stack.push(w);
        }

        if (!stack.isEmpty()) {
            int next = stack.pop();
            solveHelper(next);
        }

        return;
    }
    /** w: vertex visited twice
        v: the second vertex visiting w
     */
    private void drawCircle(int w, int v) {
        edgeTo[w] = v;
        announce();
    }

}

