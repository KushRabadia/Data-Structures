/*
 * ----------------------------------------------------
 * Algorithm name: 		Selection Sort
 *
 * Time Complexity:
 * 					Comparisons		Swaps
 * Worst Case:      O(n^2)			O(n)
 * Best Case:		O(n^2)			O(1)
 * Average Case:	O(n^2)			O(n)
 *
 * Memory:  O(1)
 * Notes:
 * ----------------------------------------------------
 */
void selection_sort(Data *array, const int size) {
	int i, j, min_indx;
	for (i = 0; i < size - 1; i++) {
		min_indx = i;
		for (j = i + 1; j < size; j++)
			if (compare_data(&array[j], &array[min_indx]) == 2)
				min_indx = j;
		swap_data(&array[min_indx], &array[i]);
	}
	return;
}
