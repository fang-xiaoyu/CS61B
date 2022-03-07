package lab11.graphs;

import edu.princeton.cs.algs4.MinPQ;

import java.util.HashMap;

/**
 *  @author Josh Hug
 */
public class MazeAStarPath extends MazeExplorer{
    private int s;
    private int t;
    private boolean targetFound = false;
    private Maze maze;
    private MinPQ<AStarVertex> pq;

    public class AStarVertex implements Comparable<Object> {
        private int vertex;
        private int AStarDist;
        public AStarVertex(int v, int d){
            vertex = v;
            AStarDist = d;
        }

        @Override
        public int compareTo(Object o) {
            AStarVertex toCompared = (AStarVertex) o;
            return AStarDist - toCompared.AStarDist;
        }

        @Override
        public int hashCode() {
            return vertex;
        }

    }
    public MazeAStarPath(Maze m, int sourceX, int sourceY, int targetX, int targetY) {
        super(m);
        maze = m;
        s = maze.xyTo1D(sourceX, sourceY);
        t = maze.xyTo1D(targetX, targetY);
        distTo[s] = 0;
        edgeTo[s] = s;
        pq = new MinPQ<>();
    }

    /** Estimate of the distance from v to the target. */
    private int h(int v) {
        int vx = maze.toX(v);
        int vy = maze.toY(v);
        int tx = maze.toX(t);
        int ty = maze.toY(t);
        return Math.abs(vx - tx) + Math.abs(vy - ty);
    }

    /** Finds vertex estimated to be closest to target. */
    private int findMinimumUnmarked() {
        return -1;
        /* You do not have to use this method. */
    }

    /** Performs an A star search from vertex s. */
    private void astar(int v) {
        // TODO
        marked[v] = true;
        announce();

        if (v == t) {
            targetFound = true;
        }

        if (targetFound) {
            return;
        }

        AStarVertex asv = new AStarVertex(v, h(v) + distTo[v]);
        for (int w: maze.adj(asv.vertex)) {
            if (!marked[w]) {
                edgeTo[w] = asv.vertex;
                announce();
                distTo[w] = distTo[v] + 1;
                AStarVertex wsv = new AStarVertex(w, h(w) + distTo[w]);
                pq.insert(wsv);
            }
        }

        if (!pq.isEmpty()) {
            int next = pq.delMin().vertex;
            astar(next);
            if (targetFound) {
                return;
            }
        }
    }

    @Override
    public void solve() {
        astar(s);
    }

}

