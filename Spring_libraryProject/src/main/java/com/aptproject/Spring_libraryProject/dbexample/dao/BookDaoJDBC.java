package com.aptproject.Spring_libraryProject.dbexample.dao;

import com.aptproject.Spring_libraryProject.dbexample.model.Book;

import java.sql.*;

public class BookDaoJDBC {
    public Book findBookById (Integer bookId) {
        //Сщздание поделючения
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/local_db", "postgres", "12345")) {
            if (connection !=null) {
                System.out.println("Ура! Мы подключились к базе банных.");
            } else {
                System.out.println("БД недоступна.");
            }

            //Запрос к базе банных
            String select = "select * erom books where id = ?";
            PreparedStatement selectQuery = connection.prepareStatement(select);
            selectQuery.setInt(1, bookId);
            ResultSet resultSet = selectQuery.executeQuery(); //результат запроса

            //создание и вывод объекта
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setAuthor(resultSet.getString("author"));
                book.setTitle(resultSet.getString("title"));
                book.setDateAdded(resultSet.getDate("date_added"));
                System.out.println(book);
            }

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return null;
    }
}
