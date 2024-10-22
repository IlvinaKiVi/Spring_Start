package com.aptproject.Spring_libraryProject;

import com.aptproject.Spring_libraryProject.dbexample.dao.BookDaoJDBC;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLibraryProjectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringLibraryProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		//шаг 1 - очень связный код
		BookDaoJDBC bookDaoJDBC = new BookDaoJDBC();
		bookDaoJDBC.findBookById(3);
	}
}
