package com.stan.excelApi;

public class QuickSort {
    public static int num[]= {41,24,76,11,45,64,21,69,19,36};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
           QuickSort quick=new QuickSort();
           quick.sorting(0, num.length-1);
           for(int i :num) {
        	   System.out.print(i+" ");
           }
	}
	
	public   void sorting(int left,int right ) {
		//最左邊的index 小於最右邊
		if(left <right) {
		 
		int i=left;
		int j=right;
		
			while(true) {
				//游標由左往右找比第一個值小的就進入迴圈
			while( num[i]<num[left]&& i<j) {
				i++;
			}
				//游標由右往左找，如果比第一個值大就進入迴圈
			while( num[j]>num[left] && i<j) {
				j--;
			} 
			        //游標不相等 就交換
					if(i !=j) {
						swap(i,j);
					}else { 
						break;
					}
						  
			
		}
			 
			//遞迴左半邊
			sorting(left,i-1);
			//遞迴右半邊
			sorting(j+1,right);
		}
	}

	public   void swap(int i,int j) {
		int temp=num[i];
		num[i]=num[j];
		num[j]=temp;
	}
}
