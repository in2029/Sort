package som.zd.sort;

public class InsertSort {
	int n=5;
	long[] a={1,2,8,9,5};
	public void insertSort(){
		int out,in;
		for(out=1;out<n;out++){
			long temp = a[out];
			in = out;
			while(in>0 && a[in-1]>=temp){
				a[in] = a[in-1];
				--in;
			}
			a[in] = temp;
		}
	}
	
	public void display(){
		for(int i=0;i<n;i++){
			System.out.print(a[i]+",");
		}
	}
	
	public static void main(String[] args){
		InsertSort sort = new InsertSort();
		sort.insertSort();
		sort.display();
		
	}
	
}
