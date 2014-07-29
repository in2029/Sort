package som.zd.sort;

public class BubbleSort {
	int n ; 
	int[] a;
	public void bubbleSort(){
		int out,in;
		for(out=n-1;out>1;out--){
			for(in=0;in<out;in++){
				if(a[in]>a[in+1]){
					int temp = a[in];
					a[in] = a[in+1];
					a[in+1] = temp;
				}
			}
		}
	}
	
}
