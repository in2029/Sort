package som.zd.sort;

public class SelectSort {
	int n;
	long[] a;
	
	public void swap(int dis1,int dis2){
		long temp = a[dis1];
		a[dis1] = a[dis2];
		a[dis2] = temp;
	}
	
	public void selectSort(){
		int out,in,min;
		for(out=0;out<n-1;out++){
			min = out;
			for(in=out+1;in<n;in++){
				if(a[in]<a[min]){
					min = in;
				}
			}
			swap(min,out);
		}
	}

}
