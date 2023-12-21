package g2.q5;

public class Hungarian {

    private final int[][] matrix;

    public Hungarian(int[][] matrix) {
        this.matrix = matrix;
    }

    public void solve() {
        rowReduction();
        columnReduction();
        assignTasks();
    }

    private void rowReduction() {
        for (int i = 0; i < matrix.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                }
            }
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] -= min;
            }
        }
    }

    private void columnReduction() {
        for (int j = 0; j < matrix[0].length; j++) {
            int min = Integer.MAX_VALUE;
            for (int[] ints : matrix) {
                if (ints[j] < min) {
                    min = ints[j];
                }
            }
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][j] -= min;
            }
        }
    }

    private void assignTasks() {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] assignment = new int[n][m];

        int[] rowCover = new int[n];
        int[] colCover = new int[m];

        // 反复进行直到所有零元素都被标记为1或者2
        while (true) {
            int[] zeroLocation = findZero(rowCover, colCover);
            int row = zeroLocation[0];
            int col = zeroLocation[1];
            if (row == -1) {
                break;
            }
            assignment[row][col] = 1;
            colCover[col] = 1;
            for (int j = 0; j < m; j++) {
                if (matrix[row][j] == 0) {
                    rowCover[row] = 1;
                    colCover[j] = 2;
                }
            }
        }

        // 指派方案确定，将0（1）所在位置标记为1，其余位置标记为0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (assignment[i][j] == 1) {
                    matrix[i][j] = 1;
                } else {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    private int[] findZero(int[] rowCover, int[] colCover) {
        int[] zeroLocation = new int[2];
        zeroLocation[0] = -1;
        zeroLocation[1] = -1;
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            if (rowCover[i] == 0) {
                for (int j = 0; j < m; j++) {
                    if (colCover[j] == 0 && matrix[i][j] == 0) {
                        zeroLocation[0] = i;
                        zeroLocation[1] = j;
                        return zeroLocation;
                    }
                }
            }
        }
        return zeroLocation;
    }

    public int[] getAssignment() {
        int[] assignment = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    assignment[i] = j;
                    break;
                }
            }
        }
        return assignment;
    }

}
