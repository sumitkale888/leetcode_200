class Solution {
    public void rotate(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=i+1;j<matrix.length;j++){
                // swapp
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
       for(int i=0;i<matrix.length;i++){
        int left=0;
        int right=matrix.length-1;
        while(left<right){
            int t=matrix[i][left];
            matrix[i][left]=matrix[i][right];
            matrix[i][right]=t;
            left++;
            right--;

        }
       
    }}
}

// 1)transpose 
// 2)reverse each row


// Why j = i + 1 is used
// for(int i = 0; i < n; i++){
//     for(int j = i + 1; j < n; j++){

// 👉 This ensures you only swap elements above the diagonal (upper triangle of matrix).