prices = [500, 1200, 1500, 800, 2000]

# a) Pure function to calculate discount
def discount(price):
    return price * 0.8 if price > 1000 else price

# b) Apply discount using map()
new_prices = list(map(discount, prices))
print("Discounted prices:", new_prices)

# c) Products costing more than ₹1000
eligible = list(filter(lambda p: p > 1000, prices))
print("Eligible products:", eligible)

# d) Original list remains unchanged
print("Original prices:", prices)