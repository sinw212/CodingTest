from datetime import datetime

def solution(s):
    s = list(s)
    s_split = []

    while len(s) != 1:
        ss_split = []
        ss_split.append("".join(s[0:10]))
        del(s[0:11])
        ss_split.append("".join(s[0:2]))
        del(s[0:3])
        ss_split.append("".join(s[0:3]))
        del(s[0:4])
        ss_split.append("".join(s[0:4]))
        del(s[0:5])
        ss_split.append(("".join(s).split(" "))[0])
        del(s[0:len(("".join(s).split(" "))[0])])
        s_split.append(ss_split)
    print(s_split)

    count = 0
    for i in s_split:
        if (int(i[0]) >= (240 * (2**10))) and \
                (datetime.strptime(str(i[1]) + " " + str(i[2]) + " " + str(i[3]), "%d %b %Y").date() > datetime.strptime("31 Jan 1990", "%d %b %Y").date()):
            count += 1

    if count == 0:
        return "NO FILES"
    else:
        return count

print(solution(" 779091968 23 Sep 2009 system.zip"
               " 284164096 14 Aug 2013 to-do-list.xml"
               " 714080256 19 Jun 2013 blockbuster.mpeg"
               "       329 12 Dec 2010 notes.xml"
               " 444596224 17 Jan 1950 delete-this.zip"
               "       641 24 May 1987 setup.png"
               "    245760 16 Jul 2005 archive.zip"
               " 839909376 31 Jan 1990 library.dll "))
