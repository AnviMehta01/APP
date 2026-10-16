slots = {
    "S1": ("Car", "Available"),
    "S2": ("Bike", "Occupied"),
    "S3": ("Car", "Available"),
    "S4": ("Bike", "Available"),
    "S5": ("Car", "Occupied")
}

def available_slot(vehicle, slot_type, status):
    return vehicle == slot_type and status == "Available"

print("Available car parking slots:")
for slot, data in slots.items():
    if available_slot("Car", *data):
        print(slot)