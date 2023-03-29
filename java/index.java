public class Test {

    // Function to remove the element
    public static int[] removeTheElement(int[] arr, int index)
    {
        // If the array is empty
        // or the index is not in array range
        // return the original array
        if (arr == null || index < 0
            || index >= arr.length) {
 
            return arr;
        }
 
        // Create another array of size one less
        int[] anotherArray = new int[arr.length - 1];
 
        // Copy the elements except the index
        // from original array to the other array
        for (int i = 0, k = 0; i < arr.length; i++) {
 
            // if the index is
            // the removal element index
            if (i == index) {
                continue;
            }
 
            // if the index is not
            // the removal element index
            anotherArray[k++] = arr[i];
        }
 
        // return the resultant array
        return anotherArray;
    }

    // method for sum of elements in an array
    public static int sum(int arr[])
    {
        int sum = 0; // initialize sum
        int i;
 
        // Iterate through all elements and add them to sum
        for (i = 0; i < arr.length; i++)
            sum += arr[i];
 
        return sum;
    }

    /**
     * Bahadır ve Ali arasındaki yemek ücreti hesaplamasını kontrol eder
     *
     * @param int[]     mealPrices                  Bahadır ve Ali'nin sipariş verdiği yemeklerin her biri için ödenmesi gereken ücretler
     * @param integer   overpaidMealPriceIndex      mealPrices dizisindeki; Ali'nin yemediği yemek ücretinin bulunduğu index değeri
     * @param integer   paidPrice                   Ali'nin ödediği ücret
     * 
     * @return mixed                                ücretler doğru şekilde pay edildiyse "Afiyet olsun",
     *                                              ücretler yanlış şekilde pay edildiyse Bahadır'ın Ali'ye ödemesi gereken ücret ekrana basılır.
     */ 
    public static void checkMealPriceCalculation(int [] mealPrices, int overpaidMealPriceIndex, int paidPrice)
    {
        int mealPricesCount = mealPrices.length;

        if(overpaidMealPriceIndex >= 0 && (overpaidMealPriceIndex < mealPricesCount)) {
            mealPrices = removeTheElement(mealPrices, overpaidMealPriceIndex);
            int receivablePrice = paidPrice - (sum(mealPrices) / 2);
            
            if( receivablePrice == 0 ) {
               System.out.println("Afiyet olsun"); 
            } else {
                System.out.println(receivablePrice);
            }
        }
    }

     public static void main(String []args)
     {
        // Test begin
        int[] mealPrices = new int[]{3, 10, 2, 9};
        int overpaidMealPriceIndex = 1;
        int paidPrice = 12;
        
        checkMealPriceCalculation(mealPrices, overpaidMealPriceIndex, paidPrice);
        // Test end
     }
}