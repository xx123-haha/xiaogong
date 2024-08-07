package com.xiaogong.hj.two;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Program: xiaogong
 * @Description: 广度优先搜索（BFS）
 * @Author: xiongke
 * @Create: 2024-08-07
 */
public class 广度优先搜索_BFS {

    // 内部类 Cell 用于存储每个格子的状态
    static class Cell {
        // x,y表示二维数组下标
        // dist表示数组记录从妈妈位置到达每个格子的最短距离。
        // candies表示数组记录从妈妈位置到达每个格子时收集的最多糖果数。
        int x, y, dist, candies;

        // 构造函数初始化 Cell 的属性
        Cell(int x, int y, int dist, int candies) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.candies = candies;
        }
    }

    /**
     * 主要方法，计算从妈妈的起始位置到宝宝位置的最大糖果数
     * @param grid 二位数字 m*n
     * @param momStart 妈妈的位置
     * @param babyPos 儿子的位置
     * @return 最大糖果数
     */
    public static int maxCandies(int[][] grid, int[] momStart, int[] babyPos) {
        int N = grid.length;

        // 方向数组，用于向上、下、左、右四个方向移动
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // 初始化 BFS 所需的数据结构
        int[][] dist = new int[N][N]; // 记录每个格子到起始点的最短距离
        int[][] candy = new int[N][N]; // 记录到达每个格子时可以收集的最大糖果数
        boolean[][] visited = new boolean[N][N]; // 标记每个格子是否已被访问过

        // 初始化距离矩阵为最大值
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        Queue<Cell> queue = new LinkedList<>();

        // 初始化妈妈的位置
        int momX = momStart[0], momY = momStart[1];
        queue.offer(new Cell(momX, momY, 0, grid[momX][momY])); // 将妈妈的起始位置加入队列
        dist[momX][momY] = 0; // 设置起始距离为 0
        candy[momX][momY] = grid[momX][momY]; // 设置起始糖果数
        visited[momX][momY] = true; // 标记起始位置已访问

        // 开始广度优先搜索
        while (!queue.isEmpty()) {
            Cell current = queue.poll(); // 取出队列中的第一个元素

            // 遍历四个方向
            for (int[] direction : directions) {
                int newX = current.x + direction[0];
                int newY = current.y + direction[1];

                // 检查新位置是否在网格范围内且可通行
                if (newX >= 0 && newX < N && newY >= 0 && newY < N && grid[newX][newY] != -1) {
                    int newDist = current.dist + 1; // 新位置的距离
                    int newCandies = current.candies + grid[newX][newY]; // 新位置的糖果数

                    // 更新新位置的信息
                    if (newDist < dist[newX][newY] ||
                            (newDist == dist[newX][newY] && newCandies > candy[newX][newY])) {
                        dist[newX][newY] = newDist;
                        candy[newX][newY] = newCandies;
                        queue.offer(new Cell(newX, newY, newDist, newCandies)); // 加入队列
                        visited[newX][newY] = true; // 标记为已访问
                    }
                }
            }
        }

        int babyX = babyPos[0], babyY = babyPos[1];
        // 返回宝宝位置的最大糖果数或 -1（如果不可达）
        return visited[babyX][babyY] ? candy[babyX][babyY] : -1;
    }

    // 主方法，用于测试
    public static void main(String[] args) {
        // int[][] grid = {
        //         {1, 2, 3},
        //         {0, -1, 4},
        //         {7, 6, 5}
        // };
        // int[] momStart = {0, 0};
        // int[] babyPos = {2, 2};

        Scanner scanner = new Scanner(System.in);

        // 读取网格大小
        int N = scanner.nextInt();
        int[][] grid = new int[N][N];

        // 读取网格数据
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        // 读取妈妈的起始位置
        int[] momStart = new int[2];
        momStart[0] = scanner.nextInt();
        momStart[1] = scanner.nextInt();

        // 读取宝宝的位置
        int[] babyPos = new int[2];
        babyPos[0] = scanner.nextInt();
        babyPos[1] = scanner.nextInt();

        // 输出结果
        System.out.println(maxCandies(grid, momStart, babyPos));
    }
}
