package g2.q5;

public class Q5JobAssignment {

    public static void main(String[] args) {
        int[][] costs = {
                {3, 8, 2, 10},
                {9, 7, 5, 3},
                {1, 5, 4, 3},
                {4, 5, 7, 9}
        };
        System.out.println("任务分布如下：");
        System.out.println(
                """
                        [3, 8, 2, 10]
                        [9, 7, 5, 3]
                        [1, 5, 4, 3]
                        [4, 5, 7, 9]"""
        );

        BranchBoundary branchBoundary = new BranchBoundary(costs);
        branchBoundary.solve();
        int[] assignment = branchBoundary.getAssignment();
        System.out.println("任务分配：");
        for (int i = 0; i < assignment.length; i++) {
            System.out.println("人员" + (i + 1) + "分配任务" + (assignment[i]));
        }
        System.out.println("该任务分配方式会使分配成本最小");

        BruteForce bruteForce = new BruteForce(costs);
        bruteForce.solve();
        assignment = bruteForce.getAssignment();
        System.out.println("任务分配：");
        for (int i = 0; i < assignment.length; i++) {
            System.out.println("任务" + (i + 1) + "交给员工" + (assignment[i] + 1));
        }
        System.out.println("该任务分配方式会使分配成本最小");

        Hungarian hungarian = new Hungarian(costs);
        hungarian.solve();
        assignment = hungarian.getAssignment();
        System.out.println("任务分配：");
        for (int i = 0; i < assignment.length; i++) {
            System.out.println("任务" + (i + 1) + "交给员工" + (assignment[i] + 1));
        }
        System.out.println("该任务分配方式会使分配成本最小");
    }

}
