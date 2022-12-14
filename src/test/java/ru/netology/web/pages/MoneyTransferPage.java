package ru.netology.web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MoneyTransferPage {
    private SelenideElement amountFiled = $("[data-test-id='amount'] input");
    private SelenideElement fromFiled = $("[data-test-id='from'] input");
    private SelenideElement transferButton = $("[data-test-id='action-transfer'] span");
    private SelenideElement errorMessage = $(".notification__content");

    public DashboardPage moneyTransfer(int amount, String cardNumber) {
        amountFiled.setValue(String.valueOf(amount));
        fromFiled.setValue(cardNumber);
        transferButton.click();
        return new DashboardPage();
    }

    public boolean errorMessage() {
        return (errorMessage.isDisplayed());
    }
}