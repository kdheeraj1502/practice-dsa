package maxandmin;

import java.util.*;

public class MaxElementSlidingWindow {


    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 4 ,5, 6 , 7};
        int k = 3;
        printMax(arr, arr.length, k);
/*        for (int num : result) {
            System.out.print(num + " ");
        }*/
    }

    static void printMax(int arr[], int N, int K) {
        Deque<Integer> Qi = new LinkedList<>();
        int i;
        for (i = 0; i < K; ++i) {
            while (!Qi.isEmpty() && arr[i] >= arr[Qi.peekLast()])
                Qi.removeLast();
            Qi.addLast(i);
        }
        for (; i < N; ++i) {
            System.out.print(arr[Qi.peek()] + " ");
            while ((!Qi.isEmpty()) && Qi.peek() <= i - K)
                Qi.removeFirst();
            while ((!Qi.isEmpty())
                    && arr[i] >= arr[Qi.peekLast()])
                Qi.removeLast();
            Qi.addLast(i);
        }
        System.out.print(arr[Qi.peek()]);
    }

    static int[] maxSlidingWindow1(int[] arr, int k) {
        int n = arr.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> maxInWindow = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            while (!maxInWindow.isEmpty()
                    && arr[i]
                    >= arr[maxInWindow.peekLast()]) {
                maxInWindow.removeLast();
            }
            maxInWindow.addLast(i);
        }
        ans[0] = arr[maxInWindow.peekFirst()];
        for (int i = k; i < n; i++) {
            while (!maxInWindow.isEmpty()
                    && maxInWindow.peekFirst() <= i - k) {
                maxInWindow.removeFirst();
            }
            while (!maxInWindow.isEmpty()
                    && arr[i]
                    >= arr[maxInWindow.peekLast()]) {
                maxInWindow.removeLast();
            }

            maxInWindow.addLast(i);
            ans[i - k + 1] = arr[maxInWindow.peekFirst()];
        }

        return ans;
    }

    public static List<Integer> maxSlidingWindow(int[] arr, int k) {
        Queue<Pair> queue = new PriorityQueue<>((o1, o2) -> o2.value - o1.value);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            queue.add(new Pair(i, arr[i]));
        }
        result.add(queue.peek().value);
        for (int i = k; i < arr.length; i++) {
            queue.add(new Pair(i, arr[i]));
            while (queue.peek().index <= i - k) {
                queue.poll();
            }
            result.add(queue.peek().value);
        }
        return result;
    }
}

class Pair {
    int index;
    int value;

    Pair(int index, int value) {
        this.index = index;
        this.value = value;
    }
}
