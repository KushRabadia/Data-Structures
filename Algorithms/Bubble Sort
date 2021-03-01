/*
 * ----------------------------------------------------
 * Algorithm name:		Bubble Sort
 *
 * Time Complexity:
 * 					Comparisons		Swaps
 * Worst Case:		O(n^2)			O(n^2)
 * Best Case:		O(n^2)			O(1)
 * Average Case:	O(n^2)			O(n^2)
 *
 * Memory: O(1)
 *
 * Worst sorting algorithm, but stable, can be improved a bit
 * ----------------------------------------------------
 */
void bubble_sort(Data *array, const int size) {
	int i, j;
	for (i = 0; i < size - 1; i++)
		for (j = 0; j < size - i - 1; j++)
			if (compare_data(&array[j], &array[j + 1]) == 1)
				swap_data(&array[j], &array[j + 1]);
	return;
}
