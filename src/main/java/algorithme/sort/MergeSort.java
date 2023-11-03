package algorithme.sort;

import java.time.temporal.Temporal;

public class MergeSort extends SortArray {
	@Override
	protected void doProcess(int[] array) {
		divide(array, 0, array.length - 1);
	}

	private static void divide(int[] a, int startIndex, int endIndex){
		if(startIndex == endIndex) return;
		int midIndex = (startIndex + endIndex) / 2;

		divide(a, startIndex, midIndex);
		divide(a, midIndex + 1, endIndex);
		merge(a, startIndex, midIndex, endIndex);
	}

	private static void merge(int[] a, int startIndex, int midIndex, int endIndex) {
		int i = startIndex;
		int j = midIndex + 1;

		int[] tmpArray = new int[endIndex - startIndex + 1];
		int indexTmpArray = 0;

		while(i <= midIndex && j <= endIndex){
			if(a[i] > a[j]){
				tmpArray[indexTmpArray] = a[j];
				j++;
			} else {
				tmpArray[indexTmpArray] = a[i];
				i++;
			}
			indexTmpArray++;
		}

		while(i <= midIndex) {
			tmpArray[indexTmpArray] = a[i];
			i++;
			indexTmpArray++;
		}

		while(j <= endIndex) {
			tmpArray[indexTmpArray] = a[j];
			j++;
			indexTmpArray++;
		}

		indexTmpArray = 0;
		for(int tmpIndex = startIndex; tmpIndex <= endIndex; tmpIndex++, indexTmpArray++){
			a[tmpIndex] = tmpArray[indexTmpArray];
		}
	}
}
