package transactionBank;


import com.yh.jdbcexercise.transaction.domain.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountTest {

     Account account;

     @BeforeEach
     void setUp(){
          this.account = new Account(1L, "nhnAcademy", 100000L);
     }

     @Test
     void getAccountNumber(){
          Assertions.assertEquals(1L, account.getAccountNumber());
     }

     @Test
     void getName() {
          Assertions.assertEquals(account.getName(),"nhnAcademy");
     }

     @Test
     void getBalance() {
          Assertions.assertEquals(account.getBalance(),10_0000l);
     }

     @Test
     void setAccountNumber() {
          account.setAccountNumber(2l);
          Assertions.assertEquals(account.getAccountNumber(),2l);
     }

     @Test
     void isWithdraw() {
          //출금가능 여부 테스트
          Assertions.assertAll(
                  ()->Assertions.assertTrue(account.isWithdraw(1_000l)),
                  ()->Assertions.assertFalse(account.isWithdraw(20_0000l))
          );
     }

}
