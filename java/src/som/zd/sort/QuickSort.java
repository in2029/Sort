package som.zd.sort;

public class QuickSort {
	int n=11;
	long[] a={12,324,45,56,67,7,87,16,163,36,46};
	
	public void quickSort(){
		recQuickSort(0,n-1);
	}
	
	public void recQuickSort(int left,int right){
		if(right-left<=0){
			return;
		}else{
			long pivot = a[right];
			
			int partition = partitionIt(left,right,pivot);
			recQuickSort(left,partition-1);
			recQuickSort(partition+1,right);
		}
	}
	
	public int partitionIt(int left,int right,long pivot){
		int leftPtr = left - 1;
		int rightPtr = right;
		
		while(true){
			while(a[++leftPtr]<pivot);
			while(rightPtr>0 && a[--rightPtr]>pivot);
			if(leftPtr>=rightPtr){
				break;
			}else{
				swap(leftPtr,rightPtr);
			}
		}
		swap(leftPtr,right);
		return leftPtr;
	}
	
	public void swap(int dis1,int dis2){
		long temp = a[dis1];
		a[dis1] = a[dis2];
		a[dis2] = temp;
	}
	
	public void dispaly(){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+",");
		}
	}
	
	public static void main(String[] args){
		QuickSort q = new QuickSort();
		q.quickSort();
		q.dispaly();
	}

}
