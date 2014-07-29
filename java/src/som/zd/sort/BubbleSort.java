package som.zd.sort;

public class BubbleSort {
	int n ; 
	long[] a;
	
	public void swap(int dis1,int dis2){
		long temp = a[dis1];
		a[dis1] = a[dis2];
		a[dis2] = temp;
	}
	
	public void bubbleSort(){
		int out,in;
		for(out=n-1;out>1;out--){
			for(in=0;in<out;in++){
				if(a[in]>a[in+1]){
					swap(in,in+1);
				}
			}
		}
	}
	
}
