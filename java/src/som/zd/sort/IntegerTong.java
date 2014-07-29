package som.zd.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntegerTong {
	private List<Integer> datas;//桶内的数据，桶内的数据可以无序
	private List<IntegerTong> childTongs;//子桶  子桶之间有序  基数的顺序
	private int wei;//当前桶所依据的基数 对应基准   位高低 位  10个取值  
	
	public IntegerTong(int[] arr,int parentWei){
		if(parentWei<1||arr==null){
			return;
		}
		if(arr.length>10){
			this.datas = new ArrayList<Integer>(10000);
		}else{
			this.datas = new ArrayList<Integer>();
		}
		this.wei = parentWei;
		childTongs = new ArrayList<IntegerTong>();
		for(int i=0;i<arr.length;i++){
			this.datas.add(arr[i]);
		}
	}
	public IntegerTong(List<Integer> arr,int wei){//父桶的位
		if(wei<1||arr==null){
			return;
		}
		this.datas = arr;
		this.wei = wei;
		childTongs = new ArrayList<IntegerTong>();
	}
	//分桶，比递归更彻底的是，在此方法内构造同类型的对象继续调用此方法
	public void toChildTongs(){
		int wei = this.wei-1; //从最高位开始分桶，子桶的wei
		if(wei<1) return;//到最后一个排序基准结束，最后一个排序基准也要排的
		int chushu = (int)Math.pow(10, wei-1);//Integer取当前排序基准上的有序值的实现方式
		Map<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
		for(int i=0;i<datas.size();i++){
			Integer value = datas.get(i);
			int key = (value/chushu)%10;//位和值  高低位  取每个数据在当前排序基准上的有序值
			if(map.get(key)==null){
				map.put(key, new ArrayList<Integer>());
			}
			map.get(key).add(value);
		}
		for(int i=0;i<10;i++){//穷举当前排序基准上的有序值
			if(map.containsKey(i)){
				childTongs.add(new IntegerTong(map.get(i),wei));
			}
		}
		for(IntegerTong tong:childTongs){
			tong.toChildTongs();
		}
	}
	
	public void appendTo(List<Integer> list){
		int size = datas.size();
		if(this.wei==1){
			for(int i=0;i<size;i++){
				list.add(datas.get(i));
			}
		}else if(size==1){
			list.add(datas.get(0));
		}
		else{
			for(int i=0;i<childTongs.size();i++){
				childTongs.get(i).appendTo(list);
			}
		}
	}
	
	public void appendTo(int[] arr,AddIndex index){
		int size = datas.size();
		if(this.wei==1){
			for(int i=0;i<size;i++){
				arr[index.getIndex()] = datas.get(i);
				index.add();
			}
		}else if(size==1){
			arr[index.getIndex()] = datas.get(0);
			index.add();
		}
		else{
			for(int i=0;i<childTongs.size();i++){
				childTongs.get(i).appendTo(arr,index);
			}
		}
	}
	
	public static class AddIndex{
		private int i = 0;
		public void add(){
			this.i = this.i+1;
		}
		public int getIndex(){
			return i;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{1000,3456,1001,345,78,9,6,6};//
		IntegerTong tong = new IntegerTong(arr,5);
		tong.toChildTongs();
		
//		List<Integer> list = new ArrayList<Integer>();
//		tong.appendTo(list);
//		System.out.println(list);
		tong.appendTo(arr,new AddIndex());
		System.out.println(Arrays.toString(arr));
		
	}
	
	
}
