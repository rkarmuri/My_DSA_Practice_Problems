def lemonadeChange(bills):
    # You have 3 bills but you are concerned about having $5 and $10 bills
    five, ten = 0, 0
    for i in bills:
        # if customer gives a $5 bill
        if i==5:
            five += 1
        # If customer gives $10 bill
        elif i==10:
            # Check if any $5 exists, if so deduct $5 and add $10
            if five:
                five -= 1
                ten += 1
            else:
                return False
        # If customer gives a $20 bill
        else:
            # Check if both $10 and $5 bills exist
            if ten and five:
                ten -= 1
                five -= 1
            # Check if you have more than 3 $5 bills
            elif five>=3:
                five -= 3
            else:
                return False
            
    return True


def main():
    g = [5,5,5,10,20]
    res = lemonadeChange(g)
    print("Can you find a change? ", res)


if __name__ == "__main__":
    main()

