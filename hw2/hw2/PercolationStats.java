package hw2;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private double[] siteNumList;

    public PercolationStats(int N, int T, PercolationFactory pf) {
        if (N <= 0 || T <= 0) {
            throw new IllegalArgumentException();
        }
        siteNumList = new double[T];

        for (int i = 0; i < T; i++) {
            Percolation p = pf.make(N);
            while (!p.percolates()) {
                int row = StdRandom.uniform(N);
                int col = StdRandom.uniform(N);
                if (!p.isOpen(row, col)) {
                    p.open(row, col);
                }
            }
            siteNumList[i] = (double) p.numberOfOpenSites() / (N * N);
        }
    }

    public double mean() {
        return StdStats.mean(siteNumList);
    }

    public double stddev() {
        return StdStats.stddev(siteNumList);
    }

    public double confidenceLow() {
        return mean() - (1.96 * stddev()) / Math.sqrt(siteNumList.length);
    }

    public double confidenceHigh() {
        return mean() + (1.96 * stddev()) / Math.sqrt(siteNumList.length);
    }
/**
    public static void main(String[] args) {
        PercolationFactory pf = new PercolationFactory();
        PercolationStats ps = new PercolationStats(30, 100, pf);
        System.out.println((ps.confidenceLow() + ps.confidenceHigh()) / 2);
    }*/

}
