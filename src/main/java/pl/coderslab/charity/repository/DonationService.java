package pl.coderslab.charity.repository;

import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Institution;

import java.util.List;

public interface DonationService {

    public List<Donation> findAllDonation();
    public List<Category> findAllCategory();
    public List<Institution> findAllInstitution();

    public long count();

    public Donation save(Donation donation);
    public Category save(Category category);
    public Institution save(Institution institution);
}
