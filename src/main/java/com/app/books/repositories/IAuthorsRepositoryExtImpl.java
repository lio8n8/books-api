package com.app.books.repositories;

import com.app.books.models.SuccessAuthorRate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class IAuthorsRepositoryExtImpl implements IAuthorsRepositoryExt {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * {@inheritDoc}.
     */
    @Override
    @Transactional
    // TODO: Fix mapping.
    public List<SuccessAuthorRate> findSuccessAuthorRate() {
//        List<SuccessAuthorRate> successAuthorRates = new ArrayList<>();
//        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("calculateSuccessAuthorRates", "calcSuccessAuthorRate");
//        query.execute();
//        successAuthorRates = query.getResultList();

        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("calculateSuccessAuthorRates", "calcSuccessAuthorRate");
        query.execute();
        List<Object[]> successAuthorRates = query.getResultList();
        List<SuccessAuthorRate> res = new ArrayList<>();

        for (Object[] o : successAuthorRates) {
            res.add(SuccessAuthorRate.builder()
                    .authorName(String.valueOf(o[0]))
                    .successAuthorRate(Double.valueOf(String.valueOf(o[2])))
                    .build());
        }

        return res;
    }
}
