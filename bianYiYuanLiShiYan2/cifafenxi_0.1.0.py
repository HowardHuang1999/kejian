def main():
    key = ['<title>','</title>','我的祖国']
    ok = []

    with open("Title.html","r",encoding='utf-8') as f:
        for line in f.readlines():
            k = ''
            flag = 0
            fff = 0
            for item in line:
                if fff == 1:
                    if item != '<':
                        if item != ' ':
                            k +=item
                    else:
                        if k in key:
                            ok.append(k)
                        k = ''
                        fff = 0

                if item == '<':
                    flag = 1
                if flag == 1:
                    if item != ' ':
                        k +=item

                if item == '>':
                    if k in key:
                        ok.append(k)
                    flag = 0
                    fff = 1
                    k = ''
    f.close()
    print(ok)

if __name__ == '__main__':
    main()