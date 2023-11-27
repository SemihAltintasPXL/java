package be.pxl.hotel.service;

import be.pxl.hotel.api.request.CreateTransactionRequest;
import be.pxl.hotel.domain.Wallet;
import be.pxl.hotel.repository.BankRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class BankService {
    private final BankRepository bankRepository;
    private Wallet wallet;
    public BankService(BankRepository bankRepository) throws IOException {
        this.bankRepository = bankRepository;
        wallet = new Wallet();
        bankRepository.save(wallet);
    }
    public double getAmountOfTheCurrentWallet() {
        return wallet.getAmount();
    }

    public void createTransaction(CreateTransactionRequest createTransactionRequest){
        wallet.registerPayment(createTransactionRequest.getAmount(), createTransactionRequest.getDescription());
    }

}
