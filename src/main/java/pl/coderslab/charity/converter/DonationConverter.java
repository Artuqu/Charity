package pl.coderslab.charity.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.repository.DonationRepository;


public class DonationConverter implements Converter<String, Donation> {

    @Autowired
    private DonationRepository dr;

    @Override
  public Donation convert(String Id){return dr.findById ( Long.parseLong(Id)).get(); }

}
