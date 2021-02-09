#define _CRT_SECURE_NO_WARNINGS
#define _CRT_NONSTDC_NO_DEPRECATE
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<conio.h>
#define max 20

typedef struct student //学生
{ 
	char sno[max];//学号
	char sname[max];//姓名
	char sex[max];//性别
	char clas[max];//班级
	char birth[max];//生日
	char tel[max];//联系方式
	char add[max];//家庭地址
	char c[max];//C语言成绩
	char math[max];//高数成绩
	char eng[max];//英语成绩	
	struct student* next; //下一个数据的地址
}student;
student* head;

void regist() //插入新的学生信息
{ 
	char ch; 
	student *s,*ptr; //s用来建新结点，ptr用来暂存头结点 
	do 
	{
		s=(student*)malloc(sizeof(student)); // 新建一个学生结点 
		printf("请输入该学生的学号:"); 
		scanf("%s",s->sno); 
		printf("请输入该学生的姓名:"); 
		scanf("%s",s->sname);
		printf("请输入该学生的性别:"); 
		scanf("%s",s->sex);
		printf("请输入该学生所在班级:");
		scanf("%s",s->clas);
		printf("请输入该学生的生日:"); 
		scanf("%s",s->birth);
		printf("请输入该学生联系方式:"); 
		scanf("%s",s->tel);
		printf("请输入该学生家庭住址:");
		scanf("%s",s->add);
		printf("请输入该学生C语言成绩:");
		scanf("%s",s->c);
		printf("请输入该学生高数成绩:");
		scanf("%s",s->math);
		printf("请输入该学生英语成绩:");
		scanf("%s",s->eng);
		ptr=head; 
		head=s;//将新结点插入队头 
		s->next=ptr; 
		fflush(stdin); 
		printf("请问是否继续注册?(Y/N)"); 
		scanf("%c",&ch);
	}while(ch=='Y'||ch=='y'); 
	return; 
} 

void ElePrint(char str[]) //输出单个元素 
{ 
	if(str==NULL) exit(0); 
	printf("%s",str); 
	for(unsigned int i=0;i<12-strlen(str);i++) printf(" ");
	return; 
} 

int LinePrint(student *ptr) //输出一行 
{ 
	if(ptr==NULL) //检查传进来的指针 
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

void print() //输出全部学生信息 
{ 
	student *ptr=head;
	printf("\n学号\t姓名\t\t性别\t班级\t\t生日\t联系方式\t家庭住址  C语言\t\t高数\t英语成绩");
	while(ptr) 
	{ 
		LinePrint(ptr); 
		ptr=ptr->next; 
	} 
	printf("\n"); 
	return; 
}

void search()//查询模块 
{ 
	int method;//查询方式 
	char no[max],name[max],clas[max],tel[max]; //用来接收查询关键字 
	while(1) 
	{ 
		printf("\n请选择查询方式"); 
		printf("\n1.按学号查询"); 
		printf("\n2.按姓名查询"); 
		printf("\n3.按班级查询"); 
		printf("\n4.按联系方式查询"); 
		printf("\n5.打印全部学生信息"); ///浏览学生信息
		printf("\n6.返回主菜单\n"); 
		scanf("%d",&method); 
		student *p=head,*temp; 
		switch(method) 
		{ 
		case 1: printf("\n请输入要查询的学号:"); scanf("%s",no); 
		while(p) 
		{ 
			if(!strcmp(p->sno,no)) break; 
			else 
			{ 
				temp=p; 
				p=p->next; 
			} 
		} 
		printf("\n学号\t姓名\t\t性别\t班级\t\t生日\t联系方式\t家庭住址  C语言\t\t高数\t英语成绩");
		LinePrint(p); break; 
		
		case 2: printf("\n请输入要查询的姓名:"); scanf("%s",name); 
		printf("\n学号\t姓名\t\t性别\t班级\t\t生日\t联系方式\t家庭住址  C语言\t\t高数\t英语成绩");
		while(p) 
		{	 
			if(!strcmp(p->sname,name)) 
			LinePrint(p); 
			p=p->next; 
		}break; 

		case 3: printf("\n请输入学生所在的班级:"); scanf("%s",clas); 
		printf("\n学号\t姓名\t\t性别\t班级\t\t生日\t联系方式\t家庭住址  C语言\t\t高数\t英语成绩");
		while(p) 
		{ 
			if(!strcmp(p->clas,clas)) 
			LinePrint(p); 
			p=p->next; 
		}break; 

		case 4:printf("\n请输入学生联系方式:"); scanf("%s",tel); 
		printf("\n学号\t姓名\t\t性别\t班级\t\t生日\t联系方式\t家庭住址  C语言\t\t高数\t英语成绩");
		while(p) 
		{ 
			if(!strcmp(p->tel,tel)) 
			LinePrint(p); 
			p=p->next; 
		}break; 

		case 5:print();break; 
		case 6: return; 
		default:printf("很抱歉，暂无此查询方式!"); 
		break; 
		} 
	}
} 

void modify()//修改学生信息 
{ 
	char num[max]; 
	student *p=head; 
	printf("\n请输入要修改的学生的学号:"); 
	scanf("%s",num); 
	while(p) 
	{ 
		if(!strcmp(p->sno,num)) break; 
		else 
			p=p->next; 
	} 
	if(p==NULL) 
	{ 
		printf("\n错误：没有此学生的信息!\n"); 
		return; 
	} 
	LinePrint(p);
	printf("\n1.姓名"); 
	printf("\n2.性别"); 
	printf("\n3.班级"); 
	printf("\n4.生日"); 
	printf("\n5.联系方式"); 
	printf("\n6.家庭住址");
	printf("\n7.C语言成绩");
	printf("\n8.高数成绩");
	printf("\n9.英语成绩"); 
	printf("\n请输入要修改的该学生的信息:"); 
	char name1[max],sex1[max],clas1[max],birth1[max],tel1[max],add1[max],c1[max],math1[max],eng1[max];
	int select; 
	fflush(stdin); 
	scanf("%d",&select); 
	printf("\n请输入新的信息:"); 
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

void del()// 删除某学生的信息 
{ 
	student *p=head,*temp=head,*s; 
	char num1[max]; 
	printf("\n请输入要删除的学生的学号:"); 
	scanf("%s",num1);
	while(p)//查找该学生所在的结点 
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
		printf("\n不存在此学生的信息."); 
		return; 
	} 
	LinePrint(p);//输出该学生的信息 
	printf("\n请问真的要删除该学生的信息吗?(Y/N)"); 
	char ch; 
	fflush(stdin); 
	scanf("%c",&ch); 
	if(ch=='Y'||ch=='y') 
	{ 
		s=p->next; 
		temp->next=s; 
		free(p); 
		printf("\n已经删除该学生的信息."); 
	} 
	return; 
}



void quit() 
{ 
	char ch; 
	printf("\n真的要退出？(Y/N)"); 
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
	printf("\n欢迎使用学生信息管理系统!"); 

	while(1) 
	{ 
		printf("\n请选择需要的服务:"); 
		printf("\n1.插入"); 
		printf("\n2.查询"); 
		printf("\n3.修改"); 
		printf("\n4.删除"); 
		printf("\n5.浏览"); 
		printf("\n6.退出\n");
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