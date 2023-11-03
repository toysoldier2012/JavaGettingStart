package algorithme.sort;

public abstract class SortArray {
	public int[] sort(int[] array) {
		try {
			tradeEdgeCase(array);
			doProcess(array);
			return array;
		} catch (RuntimeException runtimeException){
			System.out.println(runtimeException.getMessage());
			return array;
		}
	}

	protected void tradeEdgeCase(int[] array) {
		if(array.length == 1)
			throw new RuntimeException("No need for sort");
		if(array.length == 0)
			throw new RuntimeException("Empty array");
	}

	protected abstract void doProcess(int[] array);
}
