package com.rencc.leetcode.primary.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @title 有效的数独
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * <p>
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * ["5","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * [
 * ["8","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: false
 * 解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
 * 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 * 说明:
 * <p>
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 给定数独序列只包含数字 1-9 和字符 '.' 。
 * 给定数独永远是 9x9 形式的。
 */
public class Array30 {
    /**
     * 暴力法
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>(9);
            for (int j = 0; j < 9; j++) {
                if (String.valueOf(board[i][j]).equals(".")) {
                    continue;
                }
                if (map.containsKey(Integer.valueOf(board[i][j]))) {
                    return false;
                }
                map.put(Integer.valueOf(board[i][j]), 1);
            }
        }
        for (int i = 0; i < 9; i++) {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>(9);
            for (int j = 0; j < 9; j++) {
                if (String.valueOf(board[j][i]).equals(".")) {
                    continue;
                }
                if (map.containsKey(Integer.valueOf(board[j][i]))) {
                    return false;
                }
                map.put(Integer.valueOf(board[j][i]), 1);
            }
        }
        int n = 0;
        int i = 0;
        int j = 0;
        while (n < 9) {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>(9);
            if (j == 9 && i < 6) {
                j = 0;
                i = i + 3;
            }
            int endi = i + 3;
            int endj = j + 3;
            while (i < endi) {
                System.out.println("i=" + i + ";j=" + j);
                if (j == endj) {
                    j = j - 3;
                }
                while (j < endj) {
                    if (String.valueOf(board[i][j]).equals(".")) {
                        j++;
                        continue;
                    }
                    if (map.containsKey(Integer.valueOf(board[i][j]))) {
                        return false;
                    }
                    map.put(Integer.valueOf(board[i][j]), 1);
                    j++;
                }
                i++;
            }
            i = i - 3;
            n++;
        }
        return true;
    }

    /**
     * 一遍遍历
     * 巧妙之处：块数组索引获取 (i / 3) * 3 + j / 3;
     * @param board
     * @return
     */
    public boolean isValidSudoku2(char[][] board) {
        // init data
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer>[] columns = new HashMap[9];
        HashMap<Integer, Integer>[] boxes = new HashMap[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<Integer, Integer>(9);
            columns[i] = new HashMap<Integer, Integer>(9);
            boxes[i] = new HashMap<Integer, Integer>(9);
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = (int) num;
                    //块儿数独索引
                    int boxIndex = (i / 3) * 3 + j / 3;
                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
                    boxes[boxIndex].put(n, boxes[boxIndex].getOrDefault(n, 0) + 1);

                    if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[boxIndex].get(n) > 1) {
                        return false;
                    }
                }
            }
        }
        return true;

    }

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '3', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '3', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '7', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        boolean validSudoku = new Array30().isValidSudoku2(board);
        System.out.println(validSudoku);
    }
}
