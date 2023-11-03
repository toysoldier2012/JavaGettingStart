package algorithme.sort;

public class QuickSort extends SortArray{
	@Override
	protected void doProcess(int[] array) {
		recSort(array, 0, array.length - 1);
	}

	private void recSort(int[] array, int startIndex, int endIndex) {
		if(endIndex <= startIndex) return;
		int mid = findIndexForSwap(array, startIndex, endIndex);
		recSort(array, startIndex, mid - 1);
		recSort(array, mid, endIndex);
	}

	private int findIndexForSwap(int[] array, int startIndex, int endIndex) {
		int left = startIndex;
		int right = endIndex - 1;

		while(left != right) {
			if(array[left] >= array[endIndex] && array[right] <= array[endIndex]){
				swap(array, left, right);
			}

			if(array[left] < array[endIndex]) left++;
			else if(array[right] > array[endIndex]) right--;
		}

		if(array[left] > array[endIndex]) {
			swap(array, left, endIndex);
			return left;
		} else return left + 1;

	}

	private void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
}
