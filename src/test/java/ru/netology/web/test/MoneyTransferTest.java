package ru.netology.web.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.pages.LoginPage;

import static com.codeborne.selenide.Selenide.open;


public class MoneyTransferTest {

    @BeforeEach
    void openBrowser() {
        open("http://localhost:9999");
    }

    @Test
    void shouldTransferMoneyFromFirstToSecond() {
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        var dashboardPage = verificationPage.validVerify(verificationCode);
        int balanceFirstBeforeTransfer = dashboardPage.getCardBalance(0);
        int balanceSecondBeforeTransfer = dashboardPage.getCardBalance(1);
        var moneyTransferPage = dashboardPage.cardRefill(1);
        int amount = 1000;
        moneyTransferPage.moneyTransfer(amount, DataHelper.getFirstCardInfo().getCardNumber());

        Assertions.assertEquals(balanceFirstBeforeTransfer - amount, dashboardPage.getCardBalance(0));
        Assertions.assertEquals(balanceSecondBeforeTransfer + amount, dashboardPage.getCardBalance(1));
    }

    @Test
    void shouldTransferMoneyFromSecondToFirst() {
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        var dashboardPage = verificationPage.validVerify(verificationCode);
        int balanceFirstBeforeTransfer = dashboardPage.getCardBalance(0);
        int balanceSecondBeforeTransfer = dashboardPage.getCardBalance(1);
        var moneyTransferPage = dashboardPage.cardRefill(0);
        int amount = 1000;
        moneyTransferPage.moneyTransfer(amount, DataHelper.getSecondCardInfo().getCardNumber());
        Assertions.assertEquals(balanceFirstBeforeTransfer + amount, dashboardPage.getCardBalance(0));
        Assertions.assertEquals(balanceSecondBeforeTransfer - amount, dashboardPage.getCardBalance(1));
    }

    @Test
    void shouldTransferMoneyFromFirstToSecondZero() {
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        var dashboardPage = verificationPage.validVerify(verificationCode);
        int balanceFirstBeforeTransfer = dashboardPage.getCardBalance(0);
        int balanceSecondBeforeTransfer = dashboardPage.getCardBalance(1);
        var moneyTransferPage = dashboardPage.cardRefill(1);
        int amount = 0;
        moneyTransferPage.moneyTransfer(amount, DataHelper.getFirstCardInfo().getCardNumber());
        Assertions.assertEquals(balanceFirstBeforeTransfer - amount, dashboardPage.getCardBalance(0));
        Assertions.assertEquals(balanceSecondBeforeTransfer + amount, dashboardPage.getCardBalance(1));
    }

    @Test
    void shouldTransferMoneyFromSecondToFirstZero() {
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        var dashboardPage = verificationPage.validVerify(verificationCode);
        int balanceFirstBeforeTransfer = dashboardPage.getCardBalance(0);
        int balanceSecondBeforeTransfer = dashboardPage.getCardBalance(1);
        var moneyTransferPage = dashboardPage.cardRefill(0);
        int amount = 0;
        moneyTransferPage.moneyTransfer(amount, DataHelper.getSecondCardInfo().getCardNumber());
        Assertions.assertEquals(balanceFirstBeforeTransfer + amount, dashboardPage.getCardBalance(0));
        Assertions.assertEquals(balanceSecondBeforeTransfer - amount, dashboardPage.getCardBalance(1));
    }

    @Test
    void shouldTransferMoneyFromFirstToSecondAllMoney() {
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        var dashboardPage = verificationPage.validVerify(verificationCode);
        int balanceFirstBeforeTransfer = dashboardPage.getCardBalance(0);
        int balanceSecondBeforeTransfer = dashboardPage.getCardBalance(1);
        var moneyTransferPage = dashboardPage.cardRefill(1);
        int amount = balanceFirstBeforeTransfer;
        moneyTransferPage.moneyTransfer(amount, DataHelper.getFirstCardInfo().getCardNumber());
        Assertions.assertEquals(balanceFirstBeforeTransfer - amount, dashboardPage.getCardBalance(0));
        Assertions.assertEquals(balanceSecondBeforeTransfer + amount, dashboardPage.getCardBalance(1));
    }

    @Test
    void shouldTransferMoneyFromSecondToFirstAllMoney() {
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        var dashboardPage = verificationPage.validVerify(verificationCode);
        int balanceFirstBeforeTransfer = dashboardPage.getCardBalance(0);
        int balanceSecondBeforeTransfer = dashboardPage.getCardBalance(1);
        var moneyTransferPage = dashboardPage.cardRefill(0);
        int amount = balanceSecondBeforeTransfer;
        moneyTransferPage.moneyTransfer(amount, DataHelper.getSecondCardInfo().getCardNumber());
        Assertions.assertEquals(balanceFirstBeforeTransfer + amount, dashboardPage.getCardBalance(0));
        Assertions.assertEquals(balanceSecondBeforeTransfer - amount, dashboardPage.getCardBalance(1));
    }

    @Test
    void shouldTransferMoneyFromFirstToFirst() {
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        var dashboardPage = verificationPage.validVerify(verificationCode);
        int balanceFirstBeforeTransfer = dashboardPage.getCardBalance(0);
        int balanceSecondBeforeTransfer = dashboardPage.getCardBalance(1);
        var moneyTransferPage = dashboardPage.cardRefill(0);
        int amount = balanceFirstBeforeTransfer;
        moneyTransferPage.moneyTransfer(amount, DataHelper.getFirstCardInfo().getCardNumber());
        Assertions.assertEquals(balanceFirstBeforeTransfer, dashboardPage.getCardBalance(0));
        Assertions.assertEquals(balanceSecondBeforeTransfer, dashboardPage.getCardBalance(1));
    }

    @Test
    void shouldTransferMoneyFromSecondToSecond() {
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        var dashboardPage = verificationPage.validVerify(verificationCode);
        int balanceFirstBeforeTransfer = dashboardPage.getCardBalance(0);
        int balanceSecondBeforeTransfer = dashboardPage.getCardBalance(1);
        var moneyTransferPage = dashboardPage.cardRefill(1);
        int amount = balanceSecondBeforeTransfer;
        moneyTransferPage.moneyTransfer(amount, DataHelper.getSecondCardInfo().getCardNumber());
        Assertions.assertEquals(balanceFirstBeforeTransfer, dashboardPage.getCardBalance(0));
        Assertions.assertEquals(balanceSecondBeforeTransfer, dashboardPage.getCardBalance(1));
    }

    @Test
    void shouldTransferMoneyFromFirstToSecondOverMoneyAmount() {
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        var dashboardPage = verificationPage.validVerify(verificationCode);
        int balanceFirstBeforeTransfer = dashboardPage.getCardBalance(0);
        int balanceSecondBeforeTransfer = dashboardPage.getCardBalance(1);
        var moneyTransferPage = dashboardPage.cardRefill(1);
        int amount = balanceFirstBeforeTransfer + 1000;
        moneyTransferPage.moneyTransfer(amount, DataHelper.getFirstCardInfo().getCardNumber());
        Assertions.assertTrue(moneyTransferPage.errorMessage());
        Assertions.assertEquals(balanceFirstBeforeTransfer, dashboardPage.getCardBalance(0));
        Assertions.assertEquals(balanceSecondBeforeTransfer, dashboardPage.getCardBalance(1));
    }

    @Test
    void shouldTransferMoneyFromSecondToFirstOverMoneyAmount() {
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        var dashboardPage = verificationPage.validVerify(verificationCode);
        int balanceFirstBeforeTransfer = dashboardPage.getCardBalance(0);
        int balanceSecondBeforeTransfer = dashboardPage.getCardBalance(1);
        var moneyTransferPage = dashboardPage.cardRefill(0);
        int amount = balanceSecondBeforeTransfer + 1000;
        moneyTransferPage.moneyTransfer(amount, DataHelper.getSecondCardInfo().getCardNumber());
        Assertions.assertTrue(moneyTransferPage.errorMessage());
        Assertions.assertEquals(balanceFirstBeforeTransfer, dashboardPage.getCardBalance(0));
        Assertions.assertEquals(balanceSecondBeforeTransfer, dashboardPage.getCardBalance(1));
    }

    @Test
    void shouldTransferMoneyFromFirstToSecondNegativeAmount() {
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        var dashboardPage = verificationPage.validVerify(verificationCode);
        int balanceFirstBeforeTransfer = dashboardPage.getCardBalance(0);
        int balanceSecondBeforeTransfer = dashboardPage.getCardBalance(1);
        var moneyTransferPage = dashboardPage.cardRefill(1);
        int amount = -1000;
        moneyTransferPage.moneyTransfer(amount, DataHelper.getFirstCardInfo().getCardNumber());

        Assertions.assertEquals(balanceFirstBeforeTransfer - (amount * -1), dashboardPage.getCardBalance(0));
        Assertions.assertEquals(balanceSecondBeforeTransfer + (amount * -1), dashboardPage.getCardBalance(1));
    }

    @Test
    void shouldTransferMoneyFromSecondToFirstNegativeAmount() {
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        var dashboardPage = verificationPage.validVerify(verificationCode);
        int balanceFirstBeforeTransfer = dashboardPage.getCardBalance(0);
        int balanceSecondBeforeTransfer = dashboardPage.getCardBalance(1);
        var moneyTransferPage = dashboardPage.cardRefill(0);
        int amount = -1000;
        moneyTransferPage.moneyTransfer(amount, DataHelper.getSecondCardInfo().getCardNumber());
        Assertions.assertEquals(balanceFirstBeforeTransfer + (amount * -1), dashboardPage.getCardBalance(0));
        Assertions.assertEquals(balanceSecondBeforeTransfer - (amount * -1), dashboardPage.getCardBalance(1));
    }
}