package testExecutionData;

import fetchDataFromExcelFiles.ExcelDataFetch;

public class ProductConfigurationD03 {
	public static String getNonQuotableProduct(String product) {
		String productToReturn;

		productToReturn = ExcelDataFetch.searchDT(10, product);

		return productToReturn;
	}

	public static String getCategoryMappedOfOrderableProduct(String product) throws Exception {
		String categoryMapped;

		switch (product) {
		// D02 StandAlone Mapping of products' category
		// Section Adv Telco Sol Workplace of PB
		case "M2M KORE":
			categoryMapped = "M2M KORE (FO)";
			break;

		// Section Advanced Workplace of PB
		case "PABX":
			categoryMapped = "PABX (FO)";
			break;
		case "Microsoft Office 365 MS Teams":
			categoryMapped = "Microsoft Office 365 MS Teams (FO)";
			break;
		case "Temporary rental PABX":
			categoryMapped = "Temporary rental PABX (FO)";
			break;
		case "Call Connect":
			categoryMapped = "Call Connect (FO)";
			break;
		case "Cloud Mail Security":
			categoryMapped = "Cloud Mail Security (FO)";
			break;
		case "Personal Cloud":
			categoryMapped = "Personal Cloud (FO)";
			break;
		case "Cloud Exchange":
			categoryMapped = "Cloud Exchange (FO)";
			break;
		case "EM+S (Microsoft)":
			categoryMapped = "EM+S (Microsoft) (FO)";
			break;
		case "Microsoft Office 365":
			categoryMapped = "Microsoft Office 365 (FO)";
			break;

		// Section Compute & Storage of PB
		case "Hosting (Shared)":
			categoryMapped = "Hosting (Shared) (FO)";
			break;
		case "Housing (not BiLAN)":
			categoryMapped = "Housing (not BiLAN) (FO)";
			break;
		case "Proximus Azure Services":
			categoryMapped = "Proximus Azure Services (FO)";
			break;
		case "Cloud vContainer":
			categoryMapped = "Cloud vContainer (FO)";
			break;

		// Section DNS/Webhosting of PB
		case "DNS":
			categoryMapped = "DNS (FO)";
			break;

		// Section Enterprise Pack Together of PB
		case "Enterprise Pack Together":
			categoryMapped = "Enterprise Pack Together (FO)";
			break;

		// Section IOT & Analytics of PB
		case "Internet of Things":
			categoryMapped = "Internet of Things (FO)";
			break;

		// Section Mass Market of PB
		case "CPE":
			categoryMapped = "CPE (FO)";
			break;
		case "Joint Offer":
			categoryMapped = "Joint Offer (FO)";
			break;
		case "Mass Market":
			categoryMapped = "Mass Market (FO)";
			break;
		case "Pack (with mobile)":
			categoryMapped = "Pack (with mobile) (FO)";
			break;
		case "Pack (without mobile)":
			categoryMapped = "Pack (without mobile) (FO)";
			break;
		case "Proximus TV":
			categoryMapped = "Proximus TV (FO)";
			break;
		case "Proximus TV App (TV Everywhere)":
			categoryMapped = "Proximus TV App (TV Everywhere) (FO)";
			break;
		case "Bizz Call Connect":
			categoryMapped = "Bizz Call Connect (FO)";
			break;
		case "Multiline":
			categoryMapped = "Multiline (FO)";
			break;
		case "Mobile BONE":
			categoryMapped = "Mobile BONE (FO)";
			break;

		// Section Mobile of PB
		case "Engage":
			categoryMapped = "Engage (FO)";
			break;
		case "Mobile Prepaid":
			categoryMapped = "Mobile Prepaid (FO)";
			break;

		// Section Netw Conn & Serv of PB
		case "Explore":
			categoryMapped = "Explore (FO)";
			break;
		case "E-Line":
			categoryMapped = "E-Line (FO)";
			break;
		case "Explore BiLAN Teleworking":
			categoryMapped = "Explore BiLAN Teleworking (FO)";
			break;
		case "Explore International with voice":
			categoryMapped = "Explore International with voice (FO)";
			break;
		case "Explore Mobile Worker":
			categoryMapped = "Explore Mobile Worker (FO)";
			break;
		case "Explore Mono without voice":
			categoryMapped = "Explore Mono without voice (FO)";
			break;
		case "Explore Mono with voice":
			categoryMapped = "Explore Mono with voice (FO)";
			break;
		case "IP Pack on BiLAN/Explore":
			categoryMapped = "IP Pack on BiLAN/Explore (FO)";
			break;
		case "Leased Line":
			categoryMapped = "Leased Line (FO)";
			break;
		case "Split Plan-IFE/PFE":
			categoryMapped = "Split Plan-IFE/PFE (FO)";
			break;
		case "Split Plan/IFE Tool":
			categoryMapped = "Split Plan/IFE Tool";
			break;
		
		// Section Next Gen Comm of PB
		case "Conversational Chatbot":
			categoryMapped = "Conversational Chatbot (FO)";
			break;
		case "Interact":
			categoryMapped = "Interact (FO)";
			break;
		case "Proximus DocDrop":
			categoryMapped = "Proximus DocDrop (FO)";
			break;
		case "SMS Solution":
			categoryMapped = "SMS Solution (FO)";
			break;
		case "SMS Solutions Pack":
			categoryMapped = "SMS Solutions Pack (FO)";
			break;
		
		// Section Voice
		case "Marketing Number":
			categoryMapped = "Marketing Number (FO)";
			break;
		case "Elevator line":
			categoryMapped = "Elevator line (FO)";
			break;
		case "PRA over IAD30":
			categoryMapped = "PRA over IAD30 (FO)";
			break;
		case "Tariff Plan":
			categoryMapped = "Tariff Plan (FO)";
			break;
		case "Directory Number (DDI/ISDN)":
			categoryMapped = "Directory Number (DDI/ISDN) (FO)";
			break;
		case "Marketing Number International":
			categoryMapped = "Marketing Number International (FO)";
			break;
		case "Marketing Number Mobile":
			categoryMapped = "Marketing Number Mobile (FO)";
			break;
		case "PRA":
			categoryMapped = "PRA (FO)";
			break;
		case "Temporary ISDN":
			categoryMapped = "Temporary ISDN (FO)";
			break;
		case "VMS ":
			categoryMapped = "VMS  (FO)";
			break;
		default:
			throw new Exception("Product not found");
		}

		return categoryMapped;
	}

}
