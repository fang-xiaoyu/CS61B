package hw4.puzzle;

import edu.princeton.cs.algs4.MinPQ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solver {
    private MinPQ<Node> pq;
    private int moves;
    private List<WorldState> solution;
    private List<Node> steps;
    private List<WorldState> everEnqueued;
    private Map<WorldState, Integer> map;


    private class Node implements Comparable<Node> {
        private WorldState ws;
        private int moves;
        private Node previous;
        private int priority;

        private Node(WorldState w, int m, Node p) {
            ws = w;
            moves = m;
            previous = p;
            if (!map.containsKey(w)) {
                int dist = w.estimatedDistanceToGoal();
                map.put(w, dist);
            }
            priority = map.get(w) + moves;
        }

        @Override
        public int compareTo(Node n) {
            return this.priority - n.priority;
        }

        @Override
        public int hashCode() {
            return ws.hashCode();
        }
    }
    public Solver(WorldState initial) {
        pq = new MinPQ<>();
        moves = 0;
        solution = new ArrayList<>();
        steps = new ArrayList<>();
        everEnqueued = new ArrayList<>();
        map = new HashMap<>();

        pq.insert(new Node(initial, 0, null));
        everEnqueued.add(initial);
        SolverHelper();
    }

    public void SolverHelper() {
        Node X = pq.delMin();
        moves = X.moves;
        steps.add(X);
        if (X.ws.isGoal()) {
            return;
        } else {
            for (WorldState w : X.ws.neighbors()) {
                Node toAdd = new Node(w, moves + 1, X);
                if (steps.contains(toAdd) || everEnqueued.contains(w)) {
                    continue;
                }
                pq.insert(toAdd);
                everEnqueued.add(w);
            }
            SolverHelper();
        }
    }

    public int moves() {
        return moves;
    }

    public Iterable<WorldState> solution() {
        Node goal = steps.get(steps.size() - 1);
        solution.add(goal.ws);
        Node previous = goal.previous;
        while (previous != null) {
            solution.add(previous.ws);
            previous = previous.previous;
        }
        List<WorldState> result = new ArrayList<>(solution.size() - 1);
        for (int i = 0; i < solution.size(); i++) {
            result.add(i, solution.get(solution.size() - i - 1));
        }
        return result;
    }
}
