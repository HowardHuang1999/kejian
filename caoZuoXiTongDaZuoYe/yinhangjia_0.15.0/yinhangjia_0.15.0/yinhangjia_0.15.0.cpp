#include <iostream>
#include <cstdio>
#include <cstring>
 
using namespace std;
 
const int maxpro = 100;  //��������
const int maxres = 100;  //�����Դ��
 
int pro; //������
int res; //��Դ��
 
int request[maxres];//����������Դ��Ŀ
//int R[maxres]; //����Դ
int V[maxres]; //���ṩ
int C[maxpro][maxres]; //������
int A[maxpro][maxres]; //�ѷ���
int vis[maxpro]; //��ʾ��i�������Ƿ��ѷ�����Դ��1��ʾ�ѷ���
int path[maxpro];  //��ȫ·��
 
 
//��ȫ״̬�ж�
bool safe() {//true\false. ��(1) ��(0); ��0���棬0����,���Զ��������������Ϊ�����Ĳ����ͷ���ֵ�����Զ���ָ�루bool sex = true; bool* pSex = &sex;��
    int curV[maxres]; //Ŀǰ���ṩ��Դ
    for(int i = 0; i < res; i++)
        curV[i] = V[i];//��ʼ��Ŀǰ���ṩ��Դ=���ṩ��Դ,�൱��Work=Available,��һ������ʼ��
 
    memset(vis, 0, sizeof(vis));//��int vis[xx]����,memset��������һ���ڴ�������ĳ��������ֵ���൱��finish[i] = false,�趨���н��̾�δ���
 
    int flag = 1;
    for(int i1 = 0; i1 < pro; i1++) {
        int i;
        for(i = 0; i < pro; i++) {//��i������
            if(vis[i] == 1) continue;//continue�������ѭ������У������ǲ�ִ��ѭ����ʣ�ಿ�֣�ֱ�ӽ����´�ѭ����
            int flagpro = 1; //0��ʾδ�ҵ����ʵĽ���
            for(int j = 0; j < res; j++) {//��j����Դ
                if(C[i][j] - A[i][j] > curV[j]) {//����Դ-�ѷ�����Դ>Ŀǰ���ṩ��Դ���൱��Need[i] <= Work,�ڶ�������ѯ��ִ�н���Pi���ж��Ƿ������
                    flagpro = 0; break;
                }
            }
            if(flagpro) {
                path[i1] = i;//·��
                vis[i] = 1;//����i�ѷ���
                for(int k = 0; k < res; k++)//k����Դ��
                    curV[k] += A[i][k];//Ŀǰ���ṩ��Դ=Ŀǰ���ṩ��Դ+�ѷ�����Դ,�൱�ڵ�������Pi����ɣ����黹��ռ�õ���Դ
                break;
            }
        }
        if(i == pro) {
            flag = 0;//δ�ҵ����ʽ��̣�����ȫ,����
        }
    }
 
    return flag == 1;//�Ƚ��Ƿ����ҵ����ʽ��̣�= 1����ȫ
}
 
void print() {
    cout << endl << "��ʾ��ǰ״̬" << endl;//endl����
    cout << "���������C" << endl;
    for(int i = 0; i < pro; i++) {//pro������
        for(int j = 0; j < res; j++) {//��Դ��
            printf("%2d ", C[i][j]);//%2d�ǽ����ְ����Ϊ2�������Ҷ��뷽ʽ�����������λ������2λ������߲��ո�
        }
        cout << endl;
    }
 
    cout << "�ѷ������A" << endl;
    for(int i = 0; i < pro; i++) {
        for(int j = 0; j < res; j++) {
            printf("%2d ", A[i][j]);
        }
        cout << endl;
    }
 
    cout << "�������N (C-A)" << endl;
    for(int i = 0; i < pro; i++) {
        for(int j = 0; j < res; j++) {
            printf("%2d ", C[i][j] - A[i][j]);
        }
        cout << endl;
    }
 
   /* cout << "����Դ����R" << endl;
    for(int i = 0; i < res; i++)
        cout << R[i] << ' ';
    cout << endl;*/
 
    cout << "���ṩ��Դ����V" << endl;
    for(int i = 0; i < res; i++)
        cout << V[i] << ' ';
    cout << endl << endl;
}
 
void bank() {
    while(true) {
        cout << endl << "������Դ����1����ʾ��ǰ״̬����2, ��������3" << endl;
        int k;
        cin >> k;//����
        if(k == 3) break;
        else if(k == 2) {
            print(); continue;
        }
        cout << "������������Դ�Ľ��̱��, ���̺�Ϊ0 - " << pro - 1 << endl;
        int proindex;//��������
        cin >> proindex;
        cout << "������˽���ÿ����Դ������Ŀ" << endl;
        for(int i = 0; i < res; i++)
            cin >> request[i];//request����,request����������Դ��Ŀ
 
        //���ý�������Ҫ����Դ�Ƿ��ѳ����������������ֵ
        int flag = 1;  //flagΪ1��ʾû������Ϊ0��ʾ����
        for(int i = 0; i < res; i++) {
            if(request[i] + A[proindex][i] > C[proindex][i])
                flag = 0;
        }
        if(flag == 0) {
            cout << "��Դ����ʧ�ܣ��ý�������Ҫ����Դ�ѳ�������Դ�����ֵ" << endl;
            continue;
        }
 
        //���ϵͳ��ǰ�Ƿ����㹻��Դ����ý��̵�����
        flag = 1;  //flagΪ1���㹻��Դ��Ϊ0��ʾû��
        for(int i = 0; i < res; i++) {
            if(request[i] > V[i])
                flag = 0;
        }
        if(flag == 0) {
            cout << "��Դ����ʧ�ܣ�ϵͳ��ǰû�����㹻��Դ����ý��̵�����" << endl;
            continue;
        }
 
        //���Է�����Դ���ý��̣��õ��µ�״̬
        for(int i = 0; i < res; i++) {
            A[proindex][i] += request[i]; //�ѷ�����Դ����A����
            V[i] -= request[i]; //���ṩ��Դ����V���£����ṩ��Դ��=���ṩ��Դ��-����������Դ��Ŀ
        }
 
        //ִ�а�ȫ���㷨��������״̬�ǰ�ȫ�ģ��������ɣ�����״̬�ǲ���ȫ�ģ���ָ�ԭ״̬�������ý���
        if(safe()) {
            cout << "��Դ����ɹ�" << endl;
            cout << "��ȫ·���ǣ�";
            for(int i = 0; i < pro; i++)
            {
                cout << path[i] << " ";
            }
            cout << endl;
            for(int i = 0; i < pro; i++) {
                int j;
                for(j = 0; j < res; j++) {
                    if(A[i][j] != C[i][j])
                        break;
                }
                if(j == res)
                {
                    for(j = 0; j < res; j++) {
                        V[j] += A[i][j];
                        A[i][j] = 0;
                    }
                }
            }
        }
        else  {
            cout << "��״̬����ȫ����Դ����ʧ��" << endl;
            for(int i = 0; i < res; i++) {
                A[proindex][i] -= request[i]; //�ѷ�����Դ����A����
                V[i] += request[i]; //���ṩ��Դ����V����
            }
        }
    }
}
 
int main()
{
    cout << "����������Դ��: " << endl;
    cin >> res;
    cout << "�������ܽ�����: " << endl;
    cin >> pro;
/*
    cout << "��ֱ�����ÿ����Դ����Ŀ(R����)��Ŀǰ��" << res << "����Դ" << endl;
    for(int i = 0; i < res; i++)
        cin >> R[i];*/
 
    cout << "��ֱ�����ÿ����Դ���ѷ�����Ŀ(V��������Ŀǰ��" << res << "����Դ" << endl;
    for(int i = 0;  i< res; i++)
        cin >> V[i];//V���ṩ
 
    cout << "���������������C������" << res << "����Դ��" << pro << "������" << endl;
    cout << "��ʽ: ÿ�����뵥�����̵���������Դ��Ŀ, ����" << pro << "��" << endl;
    for(int i = 0; i < pro; i++)
        for(int j = 0 ; j < res; j++)
            cin >> C[i][j];//C������
 
    cout << "�������ѷ������A������" << res << "����Դ��" << pro << "������" << endl;
    cout << "��ʽ: ÿ�����뵥�����̵��ѷ�����Դ��Ŀ, ����" << pro << "��" << endl;
 
    for(int i = 0; i < pro; i++)
        for(int j = 0 ; j < res; j++)
            cin >> A[i][j];//A�ѷ���
 
    bank();//ִ�����м��㷨
    return 0;
}
 