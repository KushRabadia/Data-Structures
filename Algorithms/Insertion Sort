/*
 * ----------------------------------------------------
 *  Algorithm name:	Insertion Sort
 *
 * Time Complexity:
 * 					Comparisons		Swaps
 * Worst Case:		O(n^2)			O(n^2)
 * Best Case:		O(n)			O(1)
 * Average Case:	O(n^2)			O(n^2)
 *
 * Memory: O(1)
 * Insertion sort performs better than selection sort
 * 		best when list is partially sorted
 * ----------------------------------------------------
 */
void insertion_sort(Data *array, const int size) {
	int i, j;
	Data key;
	for (i = 1; i < size; i++) {
		key = array[i];
		j = i - 1;
		while (j >= 0 && compare_data(&array[j], &key) == 1) {
			array[j + 1] = array[j];
			j--;
		}
		array[j + 1] = key;
	}
	return;
}
