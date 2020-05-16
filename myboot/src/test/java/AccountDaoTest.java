
import com.pkc.boot.bo.Account;
import com.pkc.boot.dao.AccountDao;
import com.pkc.boot.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author pkc
 * @description
 * @date 2020/5/16 13:50
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class AccountDaoTest {

    @Autowired
    private AccountDao accountDao;
    @Test
    public void test() {

        Account account = new Account();
        account.setName("pkc");
        account.setBalance(470);

        accountDao.insertSelective(account);
    }

}
