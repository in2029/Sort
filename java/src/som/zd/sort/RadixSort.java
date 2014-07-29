package som.zd.sort;

public class RadixSort {
	public void radixSort(int[] number,int b){
		int k = 0;
		int m = 1;
		int n = 1;
		int[][] temp = new int[10][number.length];
		int[] order = new int[10];
		while(m<=b){
			for(int i=0;i<number.length;i++){
				int lsd = (number[i]/n)%10;
				temp[lsd][order[lsd]] = number[i];
				order[lsd]++;
			}
			for(int i=0;i<10;i++){
				if(order[i]!=0){
					for(int j=0;j<order[i];j++){
						number[k] = temp[i][j];
						k++;
					}
				}
				order[i] = 0;
			}
			n *= 10;
			k = 0;
			m++;
		}
	}
	
	public static void main(String[] args){
		int[] data = {12,13,14,15,9,8,7,6};
		RadixSort sort = new RadixSort();
		sort.radixSort(data, data.length);
		for(int i=0;i<data.length;i++){
			System.out.print(data[i]+",");
		}
	}

}
