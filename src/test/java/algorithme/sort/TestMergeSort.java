package algorithme.sort;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

public class TestMergeSort {
	private int[] array1 = {3, 5, 8, 2, 1, 9, 4, 7, 6};
	private int[] array2 = {1};
	private int[] array3 = new int[0];
//	private SortArray sortArray = new MergeSort();

	private SortArray sortArray = new QuickSort();

	@Test
	public void should_merge_sort_return_right_array(){
		assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9]", Arrays.toString(sortArray.sort(array1)));
	}

	@Test
	public void should_merge_sort_return_array_directly(){
		assertEquals("[1]", Arrays.toString(sortArray.sort(array2)));
	}

	@Test
	public void should_merge_sort_return_empty_array_directly(){
		assertEquals("[]", Arrays.toString(sortArray.sort(array3)));
	}
}
