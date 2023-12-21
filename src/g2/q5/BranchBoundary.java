package g2.q5;

import java.util.PriorityQueue;

public class BranchBoundary {
    private static class Node implements Comparable<Node> {
        int level; // 当前节点对应的人员编号
        int cost; // 当前节点对应的成本
        int[] assignment; // 当前节点对应的任务分配方案

        public Node(int level, int cost, int[] assignment) {
            this.level = level;
            this.cost = cost;
            this.assignment = assignment;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(cost, other.cost);
        }
    }

    private final int n; // 任务和人员的数量
    private final int[][] personCosts; // 每个人员完成每项任务的成本
    private final int[] assignment; // 最优分配方案
    private int bestCost; // 最优成本

    public BranchBoundary(int[][] personCosts) {
        this.n = personCosts.length;
        this.personCosts = personCosts;
        this.assignment = new int[n];
        this.bestCost = Integer.MAX_VALUE;
    }

    public void solve() {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        int[] initialAssignment = new int[n];
        queue.offer(new Node(0, 0, initialAssignment));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int level = node.level;

            if (level == n) {
                if (node.cost < bestCost) {
                    bestCost = node.cost;
                    System.arraycopy(node.assignment, 0, assignment, 0, n);
                }
            } else {
                for (int i = 0; i < n; i++) {
                    if (node.assignment[i] == 0) {
                        int[] newAssignment = node.assignment.clone();
                        newAssignment[i] = level + 1;
                        int newCost = node.cost + personCosts[level][i];
                        queue.offer(new Node(level + 1, newCost, newAssignment));
                    }
                }
            }
        }
    }

    public int[] getAssignment() {
        return assignment;
    }
}
