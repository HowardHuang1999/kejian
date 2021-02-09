#include<iostream>//cout
#include<string>
#include <time.h>

using namespace std;//cout方法一 使用 std 命名空间

//初快递员账号密码
string zh = "123456";
string mm = "123456";

typedef struct gezi{
	int id;
	int condition;
};
// 初始化每个格子状态，0代表该格子没有放快递，1则代表放了快递 结构体数组
gezi geziArr[15] = {
	{ 1, 0 }, { 2,0 }, { 3, 0 }, { 4, 0 },{ 5, 0 }, { 6, 0 }, { 7, 0 }, { 8, 0 },
	{ 9, 0 }, { 10, 0 }, { 11, 0 }, { 12,0 },{ 13, 0 }, { 14, 0 }, { 15, 0 }
};

typedef struct m{
	int id; // 取件码
	gezi c; // 快递所放的格子
	string phone; // 用户手机
	m* next;
};

//函数声明
void home();
m* manage();
void qukuaidi(m *head);
void seegezi();
m* cunkuaidi();

int main(){
	home();
	return 0;
}

// 界面展示
void home(){
	m* head = new m;
	int num;
	while (1){
		cout << "  请输入要操作的序号" << endl;
		cout << "  1.快递员登录" << endl;
		cout << "  2.用户取快递" << endl;
		cout << "  3.退出" << endl;
		cin >> num;
		cout << endl;
		switch (num){
		case 1:
			head = manage();
			break;
		case 2:
			qukuaidi(head);
			break;
		case 3:
			exit(0);
			break;
		default:
			cout << "输入错误，请重新输入" << endl;
			break;
		}
	}
}

//用户取快递
void qukuaidi(m *head){
	int id;
	while (1){
		cout << "请输入取件码（返回输入0）:";
		cin >> id;
		if (id == 0){
			return;
		}
		m *p = head->next;
		while (p != NULL){
			//判断取件码
			if (id==p->id){
				cout << "取件成功!" << endl << endl;
				//修改格口状态
				geziArr[p->c.id].condition = 0;
				return;
			}
			p = p->next;
		}
		cout << "!!!取件码错误，请重新输入!!!" << endl;
	}
}

m* manage(){
	m *head = new m;
	int num;
	string yzh;
	string ymm;
	cout << "快递员你好！" << endl;
	cout << "请输入账号：";
	cin >> yzh;
	cout << "请输入密码：";
	cin >> ymm;
	cout << endl;
	if (yzh.compare(zh) == 0 && ymm.compare(mm) == 0){//字符串比较函数
		while (1){
			cout << "  请输入要操作的序号" << endl;
			cout << "  1.查看格口状态" << endl;
			cout << "  2.派送快递" << endl;
			cout << "  0.返回" << endl;
			cin >> num;
			switch (num){
			case 1:
				seegezi();
				break;
			case 2:
				head = cunkuaidi();
				break;
			case 0:return head;
			default:
				cout << "输入错误，请重新输入" << endl;
				break;
			}
		}
	}
	else{
		cout << "账号或密码错误，请重新输入" << endl;
		manage();
	}
}

//查看柜子状态
void seegezi(){
	cout << "格口号\t状态\t" << endl;
	for (int i = 0; i <15; i++){
		cout << geziArr[i].id << "\t"
			<< geziArr[i].condition << "\t" << endl;
	}
	cout << endl;
}

m* cunkuaidi(){
	m *head = new m;
	m *p = head, *s;
	while (true){
		s = new m;
		int num;
		cout << "请输入格子的号码,返回请输入 0 :";
		cin >> num;
		switch (num)
		{
		case 1:case 2:case 3:case 4:case 5:case 6:case 7:case 8:
		case 9:case 10:case 11:case 12:case 13:case 14:
		case 15:
			if (geziArr[num-1].condition==1){
				cout << "第" << num << "号柜子以存放快递，请重新选择" << endl;
				break;
			}
			else {
				s->c.id = num - 1;

				cout << "请输入收件人的手机号码：";
				cin >> s->phone;

				//生成取件码
				srand(time(0));//种下随机种子
				s->id = rand();
				 cout << "存入成功,生成的取件码为:" << s->id << endl;
				// 修改格口状态
				geziArr[s->c.id].condition = 1;

				p->next = s;
				p = s;

				char b;
				cout << "是否继续放入快递(Y(y)/N(n))：";
				cin >> b;
				cout<<endl;
				switch (b){
				case 'Y':case 'y': break;
				case 'N':case 'n':
					p->next = NULL;
					return head;
				default:
					cout << "是否继续放入快递(Y(y)/N(n))：";
					cin >> b;
					cout << endl;
					continue;
				}
				break;
			}
		case 0:
			return head;
		default:
			cout << "输入错误，请重新输入" << endl;
			break;
		}
	}
}