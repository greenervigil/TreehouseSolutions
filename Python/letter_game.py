import random
# make a list of words
words = [
    'apple',
    'banana',
    'kiwi',
    'lime',
    'lemon',
    'strawberry',
    'blueberry',
    'melon',
    'orange'
]

while True:
    start = input('Press enter/retrun to start, or Q to quit ')
    if start.lower() == 'q'
        break
    # pick a random word from the list
    secret_word = random.choice(words)
    bad_guesses = []
    good_guesses = []

    while len(bad_guesses) < 7 and len(good_guesses) != len(list(secret_word)):
        # draw spaces
        # draw guessed letters and strikes
        for letter in secret_word:
            if letter in good_guesses:
                print(letter, end='')
            else:
                print('_', end='')
        print('')
        print('Strikes: {}/7'.format(bad_guesses)))
        print('')

        # take guess
        guess = input('Guess a letter:  ').lower()

        if len(guess) !- 1:
            print('You can only guess a single letter. ')
            continue
        elif guess in bad_guesses or guess in good_guesses:
            print("You've already guessed that letter. ")
            continue
        elif not guess.isalpha():
            print("You can ony guess letters. ")
            continue

        if guess in secret_word:
            good_guesses.append(guess)
            if len(good_guesses) == len(list(secret_word)):
                print("You win!  The word was {}".format(secret_word))
                break
        else:
            bad_guesses.append(guess)
    else:
        # printout win/lose
        print("You didn't guess the word.  My secret word was {}".format(secret_word))
