
# coding: utf-8

# In[15]:


def element(index, A, B):
    global res
    i, j = index
    res = 0
    N = len(A[0]) or len(B)
    for k in range(N):
        res += A[i][k] * B[k][j]
    return res
matrix = [[1, 2], [3, 4]]
matrix1 = [[2, 0], [1, 2]]

print(element((1, 0), matrix, matrix1))

