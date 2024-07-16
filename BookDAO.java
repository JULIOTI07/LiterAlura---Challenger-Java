package com.literalura;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class BookDAO {
    public void saveBook(Book book) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(book);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Book> getBooks() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Book", Book.class).list();
        }
    }

    public List<Book> getBooksByAuthor(String author) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Book where author = :author", Book.class)
                    .setParameter("author", author)
                    .list();
        }
    }

    public List<Book> getBooksByTitle(String title) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Book where title = :title", Book.class)
                    .setParameter("title", title)
                    .list();
        }
    }

    public void deleteBook(Long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Book book = session.get(Book.class, id);
            if (book != null) {
                session.delete(book);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
