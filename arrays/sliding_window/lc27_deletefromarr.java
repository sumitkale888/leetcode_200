package sliding_window;

public class lc27_deletefromarr {
    
}
class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0; 
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}

import numpy as np
import pandas as pd
import seaborn as sns
import matplotlib.pyplot as plt
%matplotlib inline

from google.colab import drive
drive.mount('/content/drive')

df = pd.read_csv('/content/drive/MyDrive/Salary.csv')

df.info()
df.isnull().sum()

plt.figure(figsize=(6,4))
sns.scatterplot(x='YearsExperience', y='Salary', data=df)
plt.title("Years of Experience vs Salary")
plt.show()

X = df[['YearsExperience']]
y = df['Salary']

from sklearn.model_selection import train_test_split

X_train, X_test, y_train, y_test = train_test_split(
    X,
    y,
    test_size=0.2,
    random_state=42
)

from sklearn.linear_model import LinearRegression

model = LinearRegression()

model.fit(X_train, y_train)

print("Slope:", model.coef_[0])
print("Intercept:", model.intercept_)

y_pred = model.predict(X_test)

print(y_pred)

plt.figure(figsize=(6,4))

plt.scatter(X, y, color='blue', label='Actual Data')

plt.plot(X, model.predict(X), color='red', linewidth=2, label='Regression Line')

plt.xlabel("Years of Experience")
plt.ylabel("Salary")
plt.title("Simple Linear Regression")
plt.legend()

plt.show()

experience = [[6.5]]

predicted_salary = model.predict(experience)

print("Predicted Salary:", predicted_salary[0])