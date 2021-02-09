#define _CRT_SECURE_NO_WARNINGS
#define _CRT_NONSTDC_NO_DEPRECATE
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<conio.h>
#define max 20

typedef struct student //ѧ��
{ 
	char sno[max];//ѧ��
	char sname[max];//����
	char sex[max];//�Ա�
	char clas[max];//�༶
	char birth[max];//����
	char tel[max];//��ϵ��ʽ
	char add[max];//��ͥ��ַ
	char c[max];//C���Գɼ�
	char math[max];//�����ɼ�
	char eng[max];//Ӣ��ɼ�	
	struct student* next; //��һ�����ݵĵ�ַ
}student;
student* head;

void regist() //�����µ�ѧ����Ϣ
{ 
	char ch; 
	student *s,*ptr; //s�������½�㣬ptr�����ݴ�ͷ��� 
	do 
	{
		s=(student*)malloc(sizeof(student)); // �½�һ��ѧ����� 
		printf("�������ѧ����ѧ��:"); 
		scanf("%s",s->sno); 
		printf("�������ѧ��������:"); 
		scanf("%s",s->sname);
		printf("�������ѧ�����Ա�:"); 
		scanf("%s",s->sex);
		printf("�������ѧ�����ڰ༶:");
		scanf("%s",s->clas);
		printf("�������ѧ��������:"); 
		scanf("%s",s->birth);
		printf("�������ѧ����ϵ��ʽ:"); 
		scanf("%s",s->tel);
		printf("�������ѧ����ͥסַ:");
		scanf("%s",s->add);
		printf("�������ѧ��C���Գɼ�:");
		scanf("%s",s->c);
		printf("�������ѧ�������ɼ�:");
		scanf("%s",s->math);
		printf("�������ѧ��Ӣ��ɼ�:");
		scanf("%s",s->eng);
		ptr=head; 
		head=s;//���½������ͷ 
		s->next=ptr; 
		fflush(stdin); 
		printf("�����Ƿ����ע��?(Y/N)"); 
		scanf("%c",&ch);
	}while(ch=='Y'||ch=='y'); 
	return; 
} 

void ElePrint(char str[]) //�������Ԫ�� 
{ 
	if(str==NULL) exit(0); 
	printf("%s",str); 
	for(unsigned int i=0;i<12-strlen(str);i++) printf(" ");
	return; 
} 

int LinePrint(student *ptr) //���һ�� 
{ 
	if(ptr==NULL) //��鴫������ָ�� 
	return 0; 
	printf("\n"); 
	ElePrint(ptr->sno); 
	ElePrint(ptr->sname); 
	ElePrint(ptr->sex); 
	ElePrint(ptr->clas); 
	ElePrint(ptr->birth); 
	ElePrint(ptr->tel); 
	ElePrint(ptr->add);
	ElePrint(ptr->c); 
	ElePrint(ptr->math); 
	ElePrint(ptr->eng); 
	return 1; 
} 

void print() //���ȫ��ѧ����Ϣ 
{ 
	student *ptr=head;
	printf("\nѧ��\t����\t\t�Ա�\t�༶\t\t����\t��ϵ��ʽ\t��ͥסַ  C����\t\t����\tӢ��ɼ�");
	while(ptr) 
	{ 
		LinePrint(ptr); 
		ptr=ptr->next; 
	} 
	printf("\n"); 
	return; 
}

void search()//��ѯģ�� 
{ 
	int method;//��ѯ��ʽ 
	char no[max],name[max],clas[max],tel[max]; //�������ղ�ѯ�ؼ��� 
	while(1) 
	{ 
		printf("\n��ѡ���ѯ��ʽ"); 
		printf("\n1.��ѧ�Ų�ѯ"); 
		printf("\n2.��������ѯ"); 
		printf("\n3.���༶��ѯ"); 
		printf("\n4.����ϵ��ʽ��ѯ"); 
		printf("\n5.��ӡȫ��ѧ����Ϣ"); ///���ѧ����Ϣ
		printf("\n6.�������˵�\n"); 
		scanf("%d",&method); 
		student *p=head,*temp; 
		switch(method) 
		{ 
		case 1: printf("\n������Ҫ��ѯ��ѧ��:"); scanf("%s",no); 
		while(p) 
		{ 
			if(!strcmp(p->sno,no)) break; 
			else 
			{ 
				temp=p; 
				p=p->next; 
			} 
		} 
		printf("\nѧ��\t����\t\t�Ա�\t�༶\t\t����\t��ϵ��ʽ\t��ͥסַ  C����\t\t����\tӢ��ɼ�");
		LinePrint(p); break; 
		
		case 2: printf("\n������Ҫ��ѯ������:"); scanf("%s",name); 
		printf("\nѧ��\t����\t\t�Ա�\t�༶\t\t����\t��ϵ��ʽ\t��ͥסַ  C����\t\t����\tӢ��ɼ�");
		while(p) 
		{	 
			if(!strcmp(p->sname,name)) 
			LinePrint(p); 
			p=p->next; 
		}break; 

		case 3: printf("\n������ѧ�����ڵİ༶:"); scanf("%s",clas); 
		printf("\nѧ��\t����\t\t�Ա�\t�༶\t\t����\t��ϵ��ʽ\t��ͥסַ  C����\t\t����\tӢ��ɼ�");
		while(p) 
		{ 
			if(!strcmp(p->clas,clas)) 
			LinePrint(p); 
			p=p->next; 
		}break; 

		case 4:printf("\n������ѧ����ϵ��ʽ:"); scanf("%s",tel); 
		printf("\nѧ��\t����\t\t�Ա�\t�༶\t\t����\t��ϵ��ʽ\t��ͥסַ  C����\t\t����\tӢ��ɼ�");
		while(p) 
		{ 
			if(!strcmp(p->tel,tel)) 
			LinePrint(p); 
			p=p->next; 
		}break; 

		case 5:print();break; 
		case 6: return; 
		default:printf("�ܱ�Ǹ�����޴˲�ѯ��ʽ!"); 
		break; 
		} 
	}
} 

void modify()//�޸�ѧ����Ϣ 
{ 
	char num[max]; 
	student *p=head; 
	printf("\n������Ҫ�޸ĵ�ѧ����ѧ��:"); 
	scanf("%s",num); 
	while(p) 
	{ 
		if(!strcmp(p->sno,num)) break; 
		else 
			p=p->next; 
	} 
	if(p==NULL) 
	{ 
		printf("\n����û�д�ѧ������Ϣ!\n"); 
		return; 
	} 
	LinePrint(p);
	printf("\n1.����"); 
	printf("\n2.�Ա�"); 
	printf("\n3.�༶"); 
	printf("\n4.����"); 
	printf("\n5.��ϵ��ʽ"); 
	printf("\n6.��ͥסַ");
	printf("\n7.C���Գɼ�");
	printf("\n8.�����ɼ�");
	printf("\n9.Ӣ��ɼ�"); 
	printf("\n������Ҫ�޸ĵĸ�ѧ������Ϣ:"); 
	char name1[max],sex1[max],clas1[max],birth1[max],tel1[max],add1[max],c1[max],math1[max],eng1[max];
	int select; 
	fflush(stdin); 
	scanf("%d",&select); 
	printf("\n�������µ���Ϣ:"); 
	switch(select) 
	{ 
	case 1:scanf("%s",name1);strcpy(p->sname,name1);break; 
	case 2:scanf("%s",sex1);strcpy(p->sex,sex1);break; 
	case 3:scanf("%s",clas1);strcpy(p->clas,clas1);break; 
	case 4:scanf("%s",birth1);strcpy(p->birth,birth1);break; 
	case 5: scanf("%s",tel1); strcpy(p->tel,tel1); break; 
	case 6: scanf("%s",add1); strcpy(p->add,add1); break; 
	case 7: scanf("%s",c1); strcpy(p->c,c1); break; 
	case 8: scanf("%s",math1); strcpy(p->math,math1); break; 
	case 9: scanf("%s",eng1); strcpy(p->eng,eng1); break; 
	default: printf("\nError!"); break; 
	} 
	LinePrint(p); 
	return; 
}

void del()// ɾ��ĳѧ������Ϣ 
{ 
	student *p=head,*temp=head,*s; 
	char num1[max]; 
	printf("\n������Ҫɾ����ѧ����ѧ��:"); 
	scanf("%s",num1);
	while(p)//���Ҹ�ѧ�����ڵĽ�� 
	{ 
		if(!strcmp(p->sno,num1))break; 
		else 
		{ 
			temp=p; 
			p=p->next; 
		} 
	}//while 
	if(!p) 
	{ 
		printf("\n�����ڴ�ѧ������Ϣ."); 
		return; 
	} 
	LinePrint(p);//�����ѧ������Ϣ 
	printf("\n�������Ҫɾ����ѧ������Ϣ��?(Y/N)"); 
	char ch; 
	fflush(stdin); 
	scanf("%c",&ch); 
	if(ch=='Y'||ch=='y') 
	{ 
		s=p->next; 
		temp->next=s; 
		free(p); 
		printf("\n�Ѿ�ɾ����ѧ������Ϣ."); 
	} 
	return; 
}



void quit() 
{ 
	char ch; 
	printf("\n���Ҫ�˳���(Y/N)"); 
	fflush(stdin); 
	scanf("%c",&ch); 
	if(ch=='Y'||ch=='y') 
		exit(0); 
	return; 
	getch;
}

int main() 
{ 
	int option;
	printf("\n��ӭʹ��ѧ����Ϣ����ϵͳ!"); 

	while(1) 
	{ 
		printf("\n��ѡ����Ҫ�ķ���:"); 
		printf("\n1.����"); 
		printf("\n2.��ѯ"); 
		printf("\n3.�޸�"); 
		printf("\n4.ɾ��"); 
		printf("\n5.���"); 
		printf("\n6.�˳�\n");
		scanf("%d",&option); 
		switch(option) 
		{ 
			case 1:regist();break;
			case 2:search();break;
			case 3:modify();break; 
			case 4:del();break; 
			case 5:print();break; 
			case 6:quit();break; 
		}
	}
	return 0;
}