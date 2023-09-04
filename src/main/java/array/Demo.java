package array;
    import java.util.*;
import java.io.*;
import java.lang.Math;

    public class Demo{
        public static int MaxLength(int N,int[] A,int M,int[] B){
            if(A == null || B == null) return -1;
            int sumA1 = 0;
            for(int in : A){
                sumA1 += in;
            }
            int sumB1 = 0;
            for(int in : B){
                sumB1 += in;
            }
            if(sumA1 != sumB1) return -1;

            int result = -1;
            int a = 0;
            int b = 0;
            List<Integer> aList = new ArrayList<>();
            List<Integer> bList = new ArrayList<>();
            int sumA = A[a];
            int sumB = B[b];
            while(a < A.length && b < B.length){
                if(sumA == sumB){
                    aList.add(sumA);
                    bList.add(sumB);
                    a++;
                    b++;
                    if(a < A.length)
                        sumA = A[a];
                    if(b < B.length)
                        sumB = B[b];
                }
                else if(a < A.length - 1 && sumA < sumB){
                    sumA += A[a + 1];
                    a++;
                }
                else if(b < B.length - 1 && sumA > sumB){
                    sumB += B[b + 1];
                    b++;
                }

            }
            int resultSumA = 0;
            for(int in : aList){
                resultSumA += in;
            }

            int resultSumB = 0;
            for(int in : bList){
                resultSumB += in;
            }
            if(resultSumA != resultSumB)
                return result;
            if(resultSumA == resultSumB){
                return aList.size();
            }
            return result;
        }

        public static void main (String[]args){
            int input1[] = {11, 2, 3, 5, 6, 1};
            int input2[] = {11, 7, 3, 7};

            System.out.print(MaxLength(5, input1,4,  input2));
            System.out.println();
            System.out.print(maxLen(input1,  input2));
        }

        public static int maxLen(int input1[], int input2[]){
            int maxLen = 0;
            int lenA = input1.length;
            int lenB = input2.length;
            for(int i = 0 ; i < lenA; i++){
                int sumA = 0;
                int sumB = 0;
                for(int j = i; j < lenA; j++){
                    sumA += input1[j];
                    sumB += (j < lenB) ? input2[j] : 0;
                    if(sumA == sumB){
                        int currLen = j - i + 1;
                        maxLen = Math.max(maxLen, currLen);
                    }
                }
            }
            return maxLen;
        }
    }
