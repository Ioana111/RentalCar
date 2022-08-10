package ro.sda.java37.finalProject.repository;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ro.sda.java37.finalProject.entities.Car;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


@Repository
public class CarRepositorySearchCriteria {
    @Autowired
    private EntityManager em;

    public List<Car>  findAllCars(ro.sda.java37.finalProject.dto.CarDto search){
        CriteriaBuilder builder=em.getCriteriaBuilder();
        CriteriaQuery<Car> query= builder.createQuery(Car.class);
        Root<Car> root= query.from(Car.class);
        List<Predicate> predicates = new ArrayList<>();
        if (StringUtils.isNotBlank(search.getBrand())){
            Predicate hasBrand = builder.equal(root.get("car0_.brand"),search.getBrand());
            predicates.add(hasBrand);
        }
        if (StringUtils.isNotBlank(search.getModel())){
            Predicate hasModel = builder.equal(root.get("car0_.model"),search.getModel());
            predicates.add(hasModel);
        }
        if (StringUtils.isNotBlank(search.getBodyType())){
            Predicate hasBodyType = builder.equal(root.get("car0_.bodyType"),search.getBodyType());
            predicates.add(hasBodyType);
        }
        if (StringUtils.isNotBlank(search.getColor())){
            Predicate hasColor = builder.equal(root.get("car0_.color"),search.getColor());
            predicates.add(hasColor);
        }
        if (search.getYear()!=null){
            Predicate hasYear  = builder.equal(root.get("car0_.year"),search.getYear());
            predicates.add(hasYear);
        }
        if (search.getMileage()!=null){
            Predicate hasMileage  = builder.equal(root.get("car0_.mileage"),search.getMileage());
            predicates.add(hasMileage);
        }



        query.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));

        return em.createQuery(query.select(root)).getResultList();
    }

}
