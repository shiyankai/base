package cn.syk.sykStart;

import java.util.Arrays;

/**
 * @Author syk
 * @date 2021/11/30 17:34
 **/
public class Sort {

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 9, 4, 5, 56, 25, 18, 99, 14, 0, 46};
        System.out.println("原数组数据：" + Arrays.toString(arr));
//        System.out.println("排序后数据："+Arrays.toString(maopao(arr)));
//        System.out.println("排序后数据："+Arrays.toString(xuanze(arr)));
//        System.out.println("排序后数据："+Arrays.toString(insert(arr)));
//        System.out.println("排序后数据："+Arrays.toString(xier(arr)));
//        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    //交换数据
    public static void change(int[] arr, int m, int n) {
        if (m != n) {
            arr[n] = arr[m] + arr[n];
            arr[m] = arr[n] - arr[m];
            arr[n] = arr[n] - arr[m];
        } else {
//            如果m==n会导致arr[m]数据覆盖//不想这样就加个temp做中转
        }
    }

    //归并排序
    public static void mergeSort(int[] arr, int start, int end) {
        //判断拆分的不为最小单位
        if (end - start > 0) {
            //再一次拆分，知道拆成一个一个的数据
            mergeSort(arr, start, (start + end) / 2);
            mergeSort(arr, (start + end) / 2 + 1, end);
            //记录开始/结束位置
            int left = start;
            int right = (start + end) / 2 + 1;
            //记录每个小单位的排序结果
            int index = 0;
            int[] result = new int[end - start + 1];
            //如果查分后的两块数据，都还存在
            while (left <= (start + end) / 2 && right <= end) {
                //比较两块数据的大小，然后赋值，并且移动下标
                if (arr[left] <= arr[right]) {
                    result[index] = arr[left];
                    left++;
                } else {
                    result[index] = arr[right];
                    right++;
                }
                //移动单位记录的下标
                index++;
            }
            //当某一块数据不存在了时
            while (left <= (start + end) / 2 || right <= end) {
                //直接赋值到记录下标
                if (left <= (start + end) / 2) {
                    result[index] = arr[left];
                    left++;
                } else {
                    result[index] = arr[right];
                    right++;
                }
                index++;
            }
            //最后将新的数据赋值给原来的列表，并且是对应分块后的下标。
            for (int i = start; i <= end; i++) {
                arr[i] = result[i - start];
            }
        }
    }

    //    快速排序  填坑法好点理解
    public static void quickSort(int[] arr, int start, int end) {
        int low = start, high = end;
        if (high - low <= 0) {
            return;
        }
        boolean flag = true;
        int tempValue = arr[low];
        while (true) {
            if (flag) {
                if (arr[high] >= tempValue) {
                    high--;
                } else {
                    arr[low] = arr[high];
                    low++;
                    flag = false;
                }
            } else {
                if (arr[low] <= tempValue) {
                    low++;
                } else {
                    arr[high] = arr[low];
                    high--;
                    flag = true;
                }
            }
            if (high == low) {
                arr[low] = tempValue;//把最后一个拿出来的坑填上完成任务
                break;
            }
        }
        quickSort(arr, start, low - 1);
        quickSort(arr, low + 1, end);
    }

    //    希尔排序
    public static int[] xier(int[] arr) {
        for (int m = arr.length / 2; m > 0; m /= 2) {
            for (int i = m; i < arr.length; i++) {//比较的基数
                for (int j = i; j > 0 & j - m >= 0; j -= m) {
                    if (arr[j] < arr[j - m]) {
                        change(arr, j, j - m);
                    } else {
                        break;
                    }
                }
            }
        }
        return arr;
    }

    //    插入排序
    public static int[] insert(int[] arr) {
        for (int i = 1; i < arr.length; i++) {//比较的基数
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    change(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
        return arr;
    }

    //冒泡排序
    public static int[] maopao(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    change(arr, j, j + 1);
                }
            }
        }
        return arr;
    }

    //选择排序
    public static int[] xuanze(int[] arr) {
        int minValue, minIndex;
        for (int i = 0; i < arr.length; i++) {
            minValue = arr[i];
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < minValue) {
                    minIndex = j;
                    minValue = arr[j];
                }
            }
            change(arr, i, minIndex);
        }
        return arr;
    }
}
