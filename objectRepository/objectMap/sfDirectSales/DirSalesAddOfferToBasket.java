package objectMap.sfDirectSales;

public class DirSalesAddOfferToBasket {
	
	//Add Offer to Basket
	
		
		public static String offerNameHeader ="//h3[text()='Add Offer to Basket']";
		
		public static String offerList ="//div[@ng-if='viewModel.searchListCategoryOffers.length > 0']";
		
		public static String add2OfferCancelButton = "//button[@id='add-new-product-footer']";
		
		public static String add2OfferButton ="//button[@ng-click='addProductAndClose()']";
		
		public static String summarySection = "//section[@class='summary-section ng-scope']";
		
		public static String productCatalog="//div[@class='product-category']";

}
