# include <stdio.h>
# include <stdlib.h>
# include <assert.h>
# include <assert.h>
#include "list.h"

//---------------- Node Implementation ------------------------

Node* create_node(Data *d, Node *n) {
	assert(d);
	Node *node = (Node*) malloc(sizeof(Node));
	node->data = copy_data(d);
	node->next = n;
	return node;
}

void print_node(Node *n) {
	assert(n);
	print_data(n->data);
	return;
}

Node* copy_node(Node *n) {
	assert(n);
	return create_node(n->data, n->next);
}

void destroy_node(Node **n) {
	assert(n && *n);
	destroy_data(&(*n)->data);
	(*n)->data = NULL;
	(*n)->next = NULL;
	free(*n);
	return;
}

//---------------- Linked List Implementation ------------------------

List* create_list() {
	List *list = (List*) malloc(sizeof(List));
	list->head = NULL;
	list->size = 0;
	return list;
}

int is_empty_list(List *list) {
	assert(list);
	return (list->head == NULL);
}

void print_list(List *list) {
	//assert(list);
	Node *current_node = list->head;
	while (current_node != NULL) {
		print_node(current_node);
		printf("-->");
		current_node = current_node->next;
	}
	printf("NULL\n");

	return;
}

void append_list(List *list, Data *d) {
	assert(list && d);
	Node *new_node = create_node(d, NULL);
	if (is_empty_list(list))
		list->head = new_node;
	else {
		Node *current_node = list->head;
		while (current_node->next != NULL)
			current_node = current_node->next;
		current_node->next = new_node;
	}
	list->size++;
	return;
}

void insert_front_list(List *list, Data *d) {
	assert(list && d);
	Node *new_node = create_node(d, list->head);
	list->head = new_node;
	list->size++;

	return;
}

Data* get_data_list(List *list, int index) {
	assert(list);
	return get_node_list(list, index)->data;
}

Node* get_node_list(List *list, int index) {
	assert(list);
	if (index < 0 || index >= list->size) {
		printf("Error(get_node_list): index out of range\n");
		return NULL;
	}

	Node *current_node = list->head;
	int i;
	while (i < index && current_node != NULL) {
		current_node = current_node->next;
		i++;
	}

	return copy_node(current_node);
}

Data* peek_list(List *list) {
	if (is_empty_list(list)) {
		printf("Error(peek_list): list is empty\n");
		return NULL;
	}

	return copy_data(list->head->data);

}

Data* remove_front_list(List *list) {
	if (is_empty_list(list)) {
		printf("Error(remove_front_list): list is empty\n");
		return NULL;
	}

	Node *current = list->head;

	Data *item = copy_data(current->data);

	list->head = current->next;

	destroy_node(&current);
	list->size--;

	return item;

}

Data* min_list(List *list) {
	if (is_empty_list(list)) {
		printf("Error(min_list): list is empty\n");
		return NULL;
	}

	Node *current = list->head;
	Data *item = current->data;

	while (current != NULL) {
		if (compare_data(item, current->data) == 1)
			item = current->data;
		current = current->next;
	}
	return copy_data(item);

}

List* copy_list(List *list) {
	List *list_ = (List*) malloc(sizeof(List));
	list_->head = NULL;
	list_->size = 0;

	if (is_empty_list(list))
		return list_;

	Node *current = list->head;

	while (current != NULL) {
		Node *new_node = create_node(current->data, NULL);
		if (list_->head == NULL)
			list_->head = new_node;
		else {
			Node *current_node = list_->head;
			while (current_node->next != NULL)
				current_node = current_node->next;
			current_node->next = new_node;
		}
		list_->size++;

		current = current->next;
	}
	return list_;
}

void destroy_list(List **list) {
	while (!is_empty_list(*list)) {
		remove_rear_list(*list);
	}

	(*list)->head = NULL;
	(*list)->size = 0;
	free(*list);
	*list = NULL;

	return;
}

Data* remove_rear_list(List *list) {
	assert(list);
	if (is_empty_list(list)) {
		printf("Error(remove_rear_list): list is empty\n");
		return NULL;
	}

	Node *previous = NULL;
	Node *current = list->head;

	while (current->next != NULL) {
		previous = current;
		current = current->next;
	}

	Data *item = copy_data(current->data);

	if (list->size == 1)
		list->head = NULL;
	else
		previous->next = NULL;

	destroy_node(&current);
	list->size--;

	return item;
}

void reverse_list(List *list) {
	assert(list);
	if (is_empty_list(list))
		return;

	Node *previous = NULL;
	Node *current = list->head;
	Node *next_ = current->next;

	while (current->next != NULL) {
		current->next = previous;
		previous = current;
		current = next_;
		next_ = next_->next;
	}

	current->next = previous;
	list->head = current;

	return;
}

List* array_to_list(Data *array, const int size) {
	assert(array);
	List *list = NULL;
	if (size <= 0) {
		printf("Error(array_to_list): invalid array size\n");
		return list;
	}

	int i;
	list = create_list();

	for (i = 0; i < size; i++)
		append_list(list, &array[i]);

	return list;
}

