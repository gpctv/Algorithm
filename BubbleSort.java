package com.stan.excelApi;

public class BubbleSort {
    public static int array[]= {45, 23, 18, 10, 6, 8, 67, 98, 30, 50};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
           bubble();
           for(int i=0;i<array.length;i++) {
           System.out.print(array[i]+" ");
           }
	}
	
	public static void bubble() {
		for(int i=0;i<array.length-1;i++) {
			for(int j=0;j<array.length-1;j++) {
				if(array[j]>array[j+1]) {
					swap(j,j+1);
				}
			}
		}
	}
	

	
	public static void swap(int i,int j) {
		int temp=array[i];
		array[i]=array[j];
		array[j]=temp;
	}
}
