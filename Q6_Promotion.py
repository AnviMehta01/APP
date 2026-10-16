employees = {
    "Ravi": (6, "Completed", 5),
    "Priya": (3, "Completed", 4),
    "Kumar": (8, "Not Completed", 5),
    "Meena": (7, "Completed", 4)
}

def eligible(exp, training, rating):
    return exp >= 5 and training == "Completed" and rating >= 4

print("Eligible employees:")
for name, data in employees.items():
    if eligible(*data):
        print(name)