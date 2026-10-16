students = {
    "Arun": ("Pass", "Pass"),
    "Bala": ("Pass", "Fail"),
    "Charan": ("Pass", "Pass"),
    "Divya": ("Fail", "Pass")
}

def eligible(python, ds):
    return python == "Pass" and ds == "Pass"

print("Eligible students:")
for name, results in students.items():
    if eligible(*results):
        print(name)