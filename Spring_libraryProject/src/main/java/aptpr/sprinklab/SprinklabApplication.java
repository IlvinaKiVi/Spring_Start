package aptpr.sprinklab;

import dbexamples.dao.BookDAOBeen;
import dbexamples.dao.BookDaoJDBC;
import dbexamples.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.security.spec.NamedParameterSpec;
import java.util.List;

@SpringBootApplication
public class SprinklabApplication implements CommandLineRunner {

    private BookDAOBeen bookDAOBeen;

    public SprinklabApplication(BookDAOBeen bookDAOBeen){
        this.bookDAOBeen = bookDAOBeen;
    }

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(SprinklabApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Шаг 1
        BookDaoJDBC bookDaoJDBC = new BookDaoJDBC();
        bookDaoJDBC.findBookById(2);


        List<Book> bookList = jdbcTemplate.query("select * from books",
                (((rs, rowNum) -> new Book(
                        rs.getInt("id"),
                        )))
    }
}


