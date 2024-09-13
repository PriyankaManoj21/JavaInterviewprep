package com.projectinterview;

public class SearchAlgo {

	public static void main(String args[]) {
		
		int index = binarySearch();
		System.out.println(index);
	}
	
	public static int binarySearch() {
		int[] array = {1,4,8,9,20,34,36};
		int start = 0;
		int end = array.length-1;
		System.out.println(end);
		
		int target = 20;
		
		int mid=0;
		
		while(start<=end) {
			 mid = (start +end)/2;
			
			if(array[mid]==target) {
			 return mid;
			}else if(array[mid]<target) {
				start = mid+1;
				
			}else {
				end = mid-1;
			}
			
		}
		return mid;
		
		
		
	}
}
