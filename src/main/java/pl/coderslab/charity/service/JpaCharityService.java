package pl.coderslab.charity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.DonationService;
import pl.coderslab.charity.repository.InstitutionRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Primary
@Repository
public class JpaCharityService implements DonationService {

    private final DonationRepository dr;
    private final InstitutionRepository ir;
    private final CategoryRepository cr;

    @Autowired
    public JpaCharityService(DonationRepository dr, InstitutionRepository ir, CategoryRepository cr) {
        this.dr = dr;
        this.ir = ir;
        this.cr = cr;
    }

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Donation> findAllDonation() {
        return dr.findAll ();
    }

    @Override
    public List<Category> findAllCategory() {
        return cr.findAll ();
    }

    @Override
    public List<Institution> findAllInstitution() {
        return ir.findAll ();
    }

    @Override
    public long count() {
        return dr.count ();
    }

    @Override
    public Donation save(Donation donation) {
        return dr.save ( donation );
    }

    @Override
    public Category save(Category category) {
        return cr.save ( category );
    }

    @Override
    public Institution save(Institution institution) {
        return ir.save ( institution );
    }


}
