package fr.agadbin.search.tsvector;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Component
public class ProductListener {

    @Autowired
    private SessionFactory sessionFactory;

    @PrePersist
    @PreUpdate
    public void updateTitleSearchVector(Product product) {
        if (product.getTitle() != null) {
            Session session = sessionFactory.getCurrentSession();
            String tsVector = (String) session.createNativeQuery("SELECT to_tsvector(:title)")
                    .setParameter("title", product.getTitle())
                    .getSingleResult();
            product.setTitleSearchVector(tsVector);
        }
    }
}
