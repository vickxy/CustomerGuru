public class MergeTwoVeryLargeArray {
		    private static int nextSpace(int space)
		    {
		        if (space <= 1)
		            return 0;
		        return (space / 2) + (space % 2);
		    }
		 
		    private static void merge(int[] arr1, int[] arr2,
		                              int n, int m) {
		        int i, j, space = n + m;
		        for (space = nextSpace(space); space > 0;
		             space = nextSpace(space))
		        {
		            for (i = 0; i + space < n; i++)
		                if (arr1[i] > arr1[i + space]) {
		                    int temp = arr1[i];
		                    arr1[i] = arr1[i + space];
		                    arr1[i+space] = temp;
		                }
		            for (j = space > n ? space - n : 0 ; 
		                 i < n && j < m; i++, j++)
		                if (arr1[i] > arr2[j]) {
		                    int temp = arr1[i];
		                    arr1[i] = arr2[j];
		                    arr2[j] = temp;
		                }
		 
		            if (j < m)
		            {
		                for (j = 0; j + space < m; j++)
		                    if (arr2[j] > arr2[j + space]) {
		                        int temp = arr2[j];
		                        arr2[j] = arr2[j + space];
		                        arr2[j+space] = temp;
		                    }
		            }
		        }
		    }
		 
		    public static void main(String[] args) {
		        int[] a1 = { 1, 23, 82, 98, 102 };
		        int[] a2 = { 30, 90, 102, 105, 107, 122, 198 };
		        merge(a1, a2, a1.length, a2.length);
		 
		        System.out.print("Merged array without using extra space: ");
		        for (int i = 0; i < a1.length; i++) {
		            System.out.print(a1[i] + " ");
		        }
		        
		        for (int i = 0; i < a2.length; i++) {
		            System.out.print(a2[i] + " ");
		        }
		    }

	}
