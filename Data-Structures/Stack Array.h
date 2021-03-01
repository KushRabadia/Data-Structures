/*
 * ---------------------------------
 * Student Name: Kush Rabadia Kantilal Nanji
 * Student ID: 193231170
 * Student Email: nanj1170@mylaurier.ca
 * ---------------------------------
 */

#ifndef STACK_ARRAY_H_
#define STACK_ARRAY_H_

#define True 1
#define False 0

#include "data.h"

typedef struct {
	Data *array;   //stack array
	int top;       //index for top of the stack
	int capacity;  //maximum capacity of stack
} Stack;

Stack* create_stack(int stack_capacity);
void destroy_stack(Stack **s);
Data* pop_stack(Stack *s);
int push_stack(Stack *s, Data *d);
void print_stack(Stack *s);
Data* peek_stack(Stack *s);
int len_stack(Stack *s);
int is_empty_stack(Stack *s);
int is_full_stack(Stack *s);
Stack* copy_stack(Stack *s);

#endif /* STACK_ARRAY_H_ */