/**
 * Bahadır ve Ali arasındaki yemek ücreti hesaplamasını kontrol eder
 *
 * @param int[] 	mealPrices 				    Bahadır ve Ali'nin sipariş verdiği yemeklerin her biri için ödenmesi gereken ücretler
 * @param integer 	overpaidMealPriceIndex 	    mealPrices dizisindeki; Ali'nin yemediği yemek ücretinin bulunduğu index değeri
 * @param integer 	paidPrice 					Ali'nin ödediği ücret
 * 
 * @return mixed								ücretler doğru şekilde pay edildiyse "Afiyet olsun",
 * 												ücretler yanlış şekilde pay edildiyse Bahadır'ın Ali'ye ödemesi gereken ücret ekrana basılır.
 */ 
function checkMealPriceCalculation(mealPrices, overpaidMealPriceIndex, paidPrice)
{
	let mealPricesCount = mealPrices.length;

	if(overpaidMealPriceIndex >= 0 && (overpaidMealPriceIndex < mealPricesCount)) {
	    mealPrices.splice(overpaidMealPriceIndex, 1);
	    let receivablePrice = paidPrice - (mealPrices.reduce((a, b) => a + b, 0) / 2);
	    console.log(receivablePrice === 0 ? 'Afiyet olsun' : receivablePrice);
	}
}



// Test	begin
let mealPrices = [3, 10, 2, 9];
let overpaidMealPriceIndex = 1;
let paidPrice = 12;

checkMealPriceCalculation(mealPrices, overpaidMealPriceIndex, paidPrice);
// Test end
