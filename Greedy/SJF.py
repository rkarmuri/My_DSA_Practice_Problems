def SJF(bt):
    time, waitTime = 0, 0
    bt.sort() # Sort the array to help add all the wait times and times

    for i in bt:
        waitTime += time
        time += i

    return waitTime//len(bt)

def main():
    bt = [4,3,2,1,7]
    res = SJF(bt)
    print("The average shortest job first time is: ",res)


if __name__ =="__main__":
    main()