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
		int j=right+1;
		
			while(true) {
				//游標由左往右找比第一個值小的就進入迴圈
			while(i+1<num.length &&num[++i]<num[left]) {
				
			}
				//游標由右往左找，如果比第一個值大就進入迴圈
			while(j-1 >=0 && num[--j]>num[left]) {
				
			} 
			        //如果i 大於j表示兩個游標都到中間，需要跳出迴圈
					if(i>j) 
						break;
					//交換
					swap(i,j);
			
		}
			//基準值跟比到最後右邊交換
			swap(left,j);
			//遞迴左半邊
			sorting(left,j);
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
