from functools import reduce

units = [8, 12, 9, 15, 7]

# a) Days consuming more than 10 units
high = list(filter(lambda x: x > 10, units))
print("High consumption:", high)

# b) Cost at ₹6 per unit
cost = list(map(lambda x: x * 6, units))
print("Daily cost:", cost)

# c) Total consumption
total = reduce(lambda x, y: x + y, units)
print("Total units:", total)

# d) Pure function for electricity bill
def bill(data):
    return sum(data) * 6

print("Total bill:", bill(units))
print("Original units:", units)