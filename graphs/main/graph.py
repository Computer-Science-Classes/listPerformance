import pandas as pd
import matplotlib.pyplot as plt

# Read the CSV file
data = pd.read_csv('performance_data.csv')

# Set up the plot
plt.figure(figsize=(10, 6))
plt.bar(data['Test'], data['Duration'], color='skyblue')

# Adding title and labels
plt.title('Performance Comparison')
plt.xlabel('Test')
plt.ylabel('Duration (nanoseconds)')

# Display values on the bars
for index, value in enumerate(data['Duration']):
    plt.text(index, value, f'{value}', ha='center', va='bottom')

# Show the plot
plt.show()
