<?php

/**
 * Bahadır ve Ali arasındaki yemek ücreti hesaplamasını kontrol eder
 *
 * @param int[] 	$mealPrices 				Bahadır ve Ali'nin sipariş verdiği yemeklerin her biri için ödenmesi gereken ücretler
 * @param integer 	$overpaidMealPriceIndex 	mealPrices dizisindeki; Ali'nin yemediği yemek ücretinin bulunduğu index değeri
 * @param integer 	$paidPrice 					Ali'nin ödediği ücret
 * 
 * @return mixed								ücretler doğru şekilde pay edildiyse "Afiyet olsun",
 * 												ücretler yanlış şekilde pay edildiyse Bahadır'ın Ali'ye ödemesi gereken ücret ekrana basılır.
 */ 
function checkMealPriceCalculation($mealPrices, $overpaidMealPriceIndex, $paidPrice)
{
	$mealPricesCount = count($mealPrices);

	if($overpaidMealPriceIndex >= 0 && ($overpaidMealPriceIndex < $mealPricesCount)) {
		unset($mealPrices[$overpaidMealPriceIndex]);
		$receivablePrice = $paidPrice - (array_sum($mealPrices) / 2);
		echo ($receivablePrice === 0 ? 'Afiyet olsun' : $receivablePrice) . PHP_EOL;
	}
}


/*
// Test begin
$mealPrices = [3, 10, 2, 9];
$overpaidMealPriceIndex = 1;
$paidPrice = 12;

checkMealPriceCalculation($mealPrices, $overpaidMealPriceIndex, $paidPrice);
// Test end
*/


// CLI Test begin
$ilk_coklu_satir = explode(' ', rtrim(fgets(STDIN)));
$n = intval($ilk_coklu_satir[0]);
$k = intval($ilk_coklu_satir[1]);
$yemekler_gecici = rtrim(fgets(STDIN));
$yemekler = array_map('intval', preg_split('/ /', $yemekler_gecici, -1,
PREG_SPLIT_NO_EMPTY));
$b = intval(trim(fgets(STDIN)));
checkMealPriceCalculation($yemekler, $k, $b);
// CLI Test end
