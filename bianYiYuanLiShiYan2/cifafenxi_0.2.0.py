def main():
    key = ['<title>', '</title>', '我的祖国']
    cin = []

    with open("Title.html", "r", encoding='utf-8') as dfa:
        for line in dfa.readlines():
            top = ''
            flag = 0
            bottom = 0
            for item in line:
                if bottom == 1:
                    if item != '<':
                        if item != ' ':
                            top += item
                    else:
                        if top in key:
                            cin.append(top)
                        top = ''
                        bottom = 0

                if item == '<':
                    flag = 1u
                if flag == 1:
                    if item != ' ':
                        top += item

                if item == '>':
                    if top in key:
                        cin.append(top)
                    flag = 0
                    bottom = 1
                    top = ''
    dfa.close()
    print(cin)


if __name__ == '__main__':
    main()
