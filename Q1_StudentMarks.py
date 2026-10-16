from functools import reduce

marks = [45, 60, 75, 35, 90, 50]

# a) Students scoring 50 or above
passed = list(filter(lambda x: x >= 50, marks))
print("Passed marks:", passed)

# b) Add 5 grace marks, maximum 100
grace = list(map(lambda x: min(x + 5, 100), marks))
print("Marks after grace:", grace)

# c) Calculate total marks
total = reduce(lambda x, y: x + y, grace)
print("Total marks:", total)