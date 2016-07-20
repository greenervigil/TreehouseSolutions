import random

# generate random number between 1 and 10
secret_num = random.randint(1, 10)

while True:
    # get a number from player
    guess = int(input("Guess a number between 1 and 10  "))
    # compare guess
    #print hit/miss
    if guess == secret_num:
        print("You got it!!!  My number was {}".format(secret_num))
        break
    else:
        print("That is not it!")
