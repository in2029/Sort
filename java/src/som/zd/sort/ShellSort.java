package som.zd.sort;

public class ShellSort {
	int n;
	long[] a;
	public void shellSort(){
		int out,in;
		long temp;
		
		int h = 1;
		while(h<=n/3){
			h = h*3 + 1;
		}
		
		while(h>0){
			for(out=h;out<n;out++){
				temp = a[out];
				in = out;
				while(in>h-1 && a[in-h]>=temp){
					a[in] = a[in-h];
					in = in-h;
				}
				a[in] = temp;
			}
			h = (h-1)/3;
		}
	}
	
}
