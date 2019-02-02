package com.hellofresh.pages;

import org.openqa.selenium.By;

public class PaymentPage extends PageBase {
	By PaymentMethodBankwire_link = By.xpath("//a[@class='bankwire']");
	By ConfirmOrder_button = By.xpath("//span[contains(text(),'I confirm my order')]");
	By SuccessAlert_label = By.xpath("//p[@class='cheque-indent']/strong");
	By OrderConfirmation_label = By.xpath("//h1[@class='page-heading']");
	By lastOrderStepPage_label = By.xpath("//li[@id='step_end' and @class='step_current last']");
	//////////////// Consolidate functions//////////////

	public void payByBankwire() {
		waitUntilElementIsClickable(PaymentMethodBankwire_link);
		click(PaymentMethodBankwire_link);
	}

	public void confirmOrder() {
		waitUntilElementIsClickable(ConfirmOrder_button);
		click(ConfirmOrder_button);
	}

	public String getOrderStatus() {
		waitTillElementVisible(SuccessAlert_label);
		return getText(SuccessAlert_label);
	}

	public String getHeader() {
		waitTillElementVisible(OrderConfirmation_label);
		return getText(OrderConfirmation_label);
	}

	public boolean isLastStepDisplayed() {
		return isDisplayed(lastOrderStepPage_label);
	}
}
