class Node:
    def __init__(self, info=-1, link=None):
        self.info = info
        self.link = link


class LinkedList:

    def __init__(self):
        self.head = None
        self.tail = None

    def insert_at_end(self, info):
        # Create a new node
        newNode = Node(info)
        if self.head is None:
            self.head = newNode
            self.tail = self.head
        else:
            self.tail.link = newNode
            self.tail = newNode

    def print_all_nodes(self):
        temp = self.head
        while temp:
            print("{}".format(temp.info), end=' -> ')
            temp = temp.link
        print("\n")


# Creating two linked lists
ll_1 = LinkedList()
for i in range(3):
    ll_1.insert_at_end(i+1)

ll_2 = LinkedList()
for i in range(3, 8):
    ll_2.insert_at_end(i+1)
ll_1.head.link.link.link = ll_2.head.link.link

print("Original linked lists :\n")
print("First linked list")
ll_1.print_all_nodes()
print("Second linked list")
ll_2.print_all_nodes()


def point_finder(head1):
    fast, slow = head1, head1
    while (slow and fast and fast.link):
        slow = slow.link
        fast = fast.link.link
        if slow == fast:
            print("slow "+str(slow.info))
            slow = head1
            while slow != fast:
                slow = slow.link
                fast = fast.link
            return slow
    return None


def print_intersection_point(ll_1, ll_2):

    current1, current2 = ll_1.head, ll_2.head

    # flag ptr will be used in the end
    # while repairing the lists
    flag = None

    # Point the flag pointer at the last node
    while (current1.link and current2.link):
        current1 = current1.link
        current2 = current2.link

    if current1.link is None:
        print("if")
        flag = current1
        current1.link = ll_2.head
    # getting the intersection point if it exists

        intersection_point = point_finder(ll_1.head)
    else:
        flag = current2
        current2.link = ll_1.head
        # getting the intersection point if it exists
        intersection_point = point_finder(ll_2.head)

    if not intersection_point:
        print("The given two lists does not intersect")
    else:
        print("Intersection point : {}".format(intersection_point.info))

    # Fix both the lists back to original
    flag.link = None

    # Checking both linked lists after fixing
    print("\nChecking after repairing the lists back to original :\n")
    ll_1.print_all_nodes()
    ll_2.print_all_nodes()


print_intersection_point(ll_1, ll_2)
