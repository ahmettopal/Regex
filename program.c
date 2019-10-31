#include "stdio.h"
#include "stdlib.h"

void WriteArray(int *p, int size)
{
	int i = 0;
	for(; i<size; i++) printf("%d", p[i]);
}

int ArrayCollect(int *p,int size)
{
	int i =0;
	int sum=0;
	for(;i<size;i++) sum += p[i];
	return sum;
}

int main()
{
		
	int x,y;
	printf("x:");
	scanf("%d",&x);
	printf("y:");
	scanf("%d",&y);
	int result = x+y;
	printf("Result:%d\n\n",result);
	int *Array = malloc(3*sizeof(int));
	Array[0]=x;
	Array[1]=y;
	
	Array[2]=result;
	WriteArray(Array,3);
	printf("\n\nToplam Deger:%d",ArrayCollect(Array,3));
	free(Array);
	return 0;
	
}

 