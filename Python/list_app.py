# have a help command
#have a show commmand
# clean code
#make a list that will hold on to items
item_list = []

def show_help():
    # Printout instructions
    print("what is needed?")
    print("""
enter 'done' when you are ready to quit
enter 'help' for the menu
enter 'show' for current list
    """)

def show_list():
    # print list
    print("Here's your list")

    for item in item_list:
        print(item)

def add_item_to_list(new_item):
    # add new items
    item_list.append(new_item)
    print("Added {}.  List now has {} items.".format(new_item, len(item_list)))

show_help()

while True:
    # ask for new items
    new_item = input(" > ")
    # quit app
    if new_item == 'done':
        break
    elif new_item == 'help':
        show_help()
        continue
    elif new_item == 'show':
        show_list()
        continue
    add_item_to_list(new_item)

show_list()
