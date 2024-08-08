package com.xiaogong.hj.two;

import java.util.*;

public class SocialDistancingSeating {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 会议室座位总数
        int seatNum = Integer.parseInt(sc.nextLine());
        String str = sc.nextLine();
        str = str.replace("[", "").replace("]", "");
        String[] parts = str.split(",");
        int[] seatOrLeave = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            seatOrLeave[i] = Integer.parseInt(parts[i].trim());
        }
        int result = getLastIndex(seatOrLeave, seatNum);
        System.out.println(result);
    }

    private static int getLastIndex(int[] arr, int n) {
        // 使用TreeSet来存储已占用的座位
        TreeSet<Integer> occupiedSeats = new TreeSet<>();
        int lastSeat = -1;

        for (int j : arr) {
            if (j > 0) {
                // 新员工进入
                int newSeat = findSeat(occupiedSeats, n);
                occupiedSeats.add(newSeat);
                lastSeat = newSeat;
            } else {
                // 员工离开
                occupiedSeats.remove(-j);
            }
        }
        return lastSeat;
    }

    private static int findSeat(TreeSet<Integer> occupiedSeats, int n) {
        if (occupiedSeats.isEmpty()) {
            return 0;
        }

        // 最大间隔和对应的座位
        int maxDist = 0;
        int seat = 0;

        // 检查第一个位置和第一个已占用位置之间的间隔
        int first = occupiedSeats.first();
        if (first > 0) {
            maxDist = first;
        }

        // 检查最后一个已占用位置和最后一个位置之间的间隔
        int last = occupiedSeats.last();
        if (n - 1 - last > maxDist) {
            maxDist = n - 1 - last;
            seat = n - 1;
        }

        // 检查所有已占用位置之间的间隔
        Integer prev = null;
        for (Integer current : occupiedSeats) {
            if (prev != null) {
                int dist = (current - prev) / 2;
                if (dist > maxDist) {
                    maxDist = dist;
                    seat = prev + dist;
                }
            }
            prev = current;
        }

        return seat;
    }
}
