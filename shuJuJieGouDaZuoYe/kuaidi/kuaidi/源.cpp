#include<iostream>//cout
#include<string>
#include <time.h>

using namespace std;//cout����һ ʹ�� std �����ռ�

//�����Ա�˺�����
string zh = "123456";
string mm = "123456";

typedef struct gezi{
	int id;
	int condition;
};
// ��ʼ��ÿ������״̬��0����ø���û�зſ�ݣ�1�������˿�� �ṹ������
gezi geziArr[15] = {
	{ 1, 0 }, { 2,0 }, { 3, 0 }, { 4, 0 },{ 5, 0 }, { 6, 0 }, { 7, 0 }, { 8, 0 },
	{ 9, 0 }, { 10, 0 }, { 11, 0 }, { 12,0 },{ 13, 0 }, { 14, 0 }, { 15, 0 }
};

typedef struct m{
	int id; // ȡ����
	gezi c; // ������ŵĸ���
	string phone; // �û��ֻ�
	m* next;
};

//��������
void home();
m* manage();
void qukuaidi(m *head);
void seegezi();
m* cunkuaidi();

int main(){
	home();
	return 0;
}

// ����չʾ
void home(){
	m* head = new m;
	int num;
	while (1){
		cout << "  ������Ҫ���������" << endl;
		cout << "  1.���Ա��¼" << endl;
		cout << "  2.�û�ȡ���" << endl;
		cout << "  3.�˳�" << endl;
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
			cout << "�����������������" << endl;
			break;
		}
	}
}

//�û�ȡ���
void qukuaidi(m *head){
	int id;
	while (1){
		cout << "������ȡ���루��������0��:";
		cin >> id;
		if (id == 0){
			return;
		}
		m *p = head->next;
		while (p != NULL){
			//�ж�ȡ����
			if (id==p->id){
				cout << "ȡ���ɹ�!" << endl << endl;
				//�޸ĸ��״̬
				geziArr[p->c.id].condition = 0;
				return;
			}
			p = p->next;
		}
		cout << "!!!ȡ�����������������!!!" << endl;
	}
}

m* manage(){
	m *head = new m;
	int num;
	string yzh;
	string ymm;
	cout << "���Ա��ã�" << endl;
	cout << "�������˺ţ�";
	cin >> yzh;
	cout << "���������룺";
	cin >> ymm;
	cout << endl;
	if (yzh.compare(zh) == 0 && ymm.compare(mm) == 0){//�ַ����ȽϺ���
		while (1){
			cout << "  ������Ҫ���������" << endl;
			cout << "  1.�鿴���״̬" << endl;
			cout << "  2.���Ϳ��" << endl;
			cout << "  0.����" << endl;
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
				cout << "�����������������" << endl;
				break;
			}
		}
	}
	else{
		cout << "�˺Ż������������������" << endl;
		manage();
	}
}

//�鿴����״̬
void seegezi(){
	cout << "��ں�\t״̬\t" << endl;
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
		cout << "��������ӵĺ���,���������� 0 :";
		cin >> num;
		switch (num)
		{
		case 1:case 2:case 3:case 4:case 5:case 6:case 7:case 8:
		case 9:case 10:case 11:case 12:case 13:case 14:
		case 15:
			if (geziArr[num-1].condition==1){
				cout << "��" << num << "�Ź����Դ�ſ�ݣ�������ѡ��" << endl;
				break;
			}
			else {
				s->c.id = num - 1;

				cout << "�������ռ��˵��ֻ����룺";
				cin >> s->phone;

				//����ȡ����
				srand(time(0));//�����������
				s->id = rand();
				 cout << "����ɹ�,���ɵ�ȡ����Ϊ:" << s->id << endl;
				// �޸ĸ��״̬
				geziArr[s->c.id].condition = 1;

				p->next = s;
				p = s;

				char b;
				cout << "�Ƿ����������(Y(y)/N(n))��";
				cin >> b;
				cout<<endl;
				switch (b){
				case 'Y':case 'y': break;
				case 'N':case 'n':
					p->next = NULL;
					return head;
				default:
					cout << "�Ƿ����������(Y(y)/N(n))��";
					cin >> b;
					cout << endl;
					continue;
				}
				break;
			}
		case 0:
			return head;
		default:
			cout << "�����������������" << endl;
			break;
		}
	}
}