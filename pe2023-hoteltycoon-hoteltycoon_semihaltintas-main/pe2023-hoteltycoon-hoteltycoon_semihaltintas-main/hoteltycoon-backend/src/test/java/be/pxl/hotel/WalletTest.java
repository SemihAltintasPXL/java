package be.pxl.hotel;

import be.pxl.hotel.domain.Transaction;
import be.pxl.hotel.domain.TransactionType;
import be.pxl.hotel.domain.Wallet;
import be.pxl.hotel.exception.UnsufficientMoneyException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

public class WalletTest {
    private Wallet wallet;

    @BeforeEach
    void setUp() {
        wallet = new Wallet(100.0);
    }
    @Test
    void registerPaymentGivesCorrectAmount() {
        wallet.registerPayment(50.0, "test");
        assertEquals(50.0, wallet.getAmount());
        assertEquals(2, wallet.getTransactions().size());
    }
    @Test
    void registerReceiptGivesCorrectAmount() {
        wallet.registerReceipt(50.0, "test");
        assertEquals(150.0, wallet.getAmount());
        assertEquals(2, wallet.getTransactions().size());
    }
    @Test
    void registerPaymentThrowsUnsufficientMoneyExceptionWhenAmountIsNotEnough() {
        assertThrows(UnsufficientMoneyException.class, () -> wallet.registerPayment(200.0, "test"));
    }
    @Test
    void registerPaymentThrowsUnsufficientMoneyExceptionWhenAmountIsZero() {
        assertThrows(UnsufficientMoneyException.class, () -> wallet.registerPayment(0.0, "test"));
    }
    @Test
    void registerReceiptThrowsUnsufficientMoneyExceptionWhenAmountIsZero() {
        assertThrows(UnsufficientMoneyException.class, () -> wallet.registerReceipt(0.0, "test"));
    }
}
