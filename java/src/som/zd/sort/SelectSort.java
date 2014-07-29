package som.zd.sort;

public class SelectSort {
	int n;
	int[] a;
	public void selectSort(){
		int out,in,min;
		for(out=0;out<n-1;out++){
			min = out;
			for(in=out+1;in<n;in++){
				if(a[in]<a[min]){
					min = in;
				}
			}
			int temp = a[min];
			a[min] = a[out];
			a[out] = temp;
		}
	}

}
