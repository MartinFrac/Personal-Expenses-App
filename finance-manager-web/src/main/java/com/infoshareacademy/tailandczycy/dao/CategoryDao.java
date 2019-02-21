package com.infoshareacademy.tailandczycy.dao;

import com.infoshareacademy.tailandczycy.model.Category;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static com.infoshareacademy.tailandczycy.dao.ExpenseDao.PARAM1;

@Stateless
public class CategoryDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Long save(Category c) {
        entityManager.persist(c);
        return c.getId();
    }

    public Category update(Category c) {
        return entityManager.merge(c);
    }

    public void delete(Long id) {
        final Category s = entityManager.find(Category.class, id);
        if (s != null) {
            entityManager.remove(s);
        }
    }

    public Optional<Category> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Category.class, id));
    }

    public List<Category> findAll() {
        final Query query = entityManager.createQuery("SELECT c FROM Category c join fetch c.expenses");

        return query.getResultList();
    }

    public List<Category> findCategoriesByNames(List<String> string) {
        final TypedQuery<Category> query = entityManager
                .createNamedQuery("Category.findCategoriesByNames", Category.class);
        query.setParameter(PARAM1, string);
        return query.getResultList();
    }

    public List<Category> findCategoriesCheaperOrEven(BigDecimal bigDecimal) {
        final TypedQuery<Category> query = entityManager
                .createNamedQuery("Category.findCategoriesCheaperOrEven", Category.class);
        query.setParameter(PARAM1, bigDecimal);
        return query.getResultList();
    }

    public List<Category> findCategoriesMoreExpOrEven(BigDecimal bigDecimal) {
        final TypedQuery<Category> query = entityManager
                .createNamedQuery("Category.findCategoriesMoreExpOrEven", Category.class);
        query.setParameter(PARAM1, bigDecimal);
        return query.getResultList();
    }

    public List<Category> findCategoriesEven(BigDecimal bigDecimal) {
        final TypedQuery<Category> query = entityManager
                .createNamedQuery("Category.findCategoriesEven", Category.class);
        query.setParameter(PARAM1, bigDecimal);
        return query.getResultList();
    }
}
