package pl.coderslab.charity.calculator;


import org.springframework.stereotype.Repository;
import pl.coderslab.charity.entity.Donation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class Calculator {

    @PersistenceContext
    private EntityManager em;


    //donations numbers of bags
    public List<Donation> getAllBags() {
        Query q = em.createQuery ( "SELECT sum(d.quantity) FROM Donation d" );
        return q.getResultList ();

    }

    //    donations numbers of gifts
    public List<Donation> getAllGifts() {
        Query q = em.createQuery ( "SELECT count(d.id) FROM Donation d" );
        return q.getResultList ();

    }


}
