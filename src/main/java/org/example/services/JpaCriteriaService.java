package org.example.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.*;
import org.example.model.Building;
import org.example.model.Flat;
import org.example.model.Member;
import org.example.model.Resident;

import java.util.List;

public class JpaCriteriaService {
    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;

    public JpaCriteriaService() {
        entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public List<MemberInfo> findMembersWithoutEntranceRights() {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<MemberInfo> query = criteriaBuilder.createQuery(MemberInfo.class);
        query.distinct(true);

        Root<Member> memberRoot = query.from(Member.class);
        Root<Resident> residentRoot = query.from(Resident.class);

        Join<Member, Flat> flatJoin = memberRoot.join("flat", JoinType.INNER);
        Join<Flat, Building> buildingJoin = flatJoin.join("building", JoinType.INNER);

        query.select(
                criteriaBuilder.construct(
                        MemberInfo.class,
                        memberRoot.get("id"),
                        memberRoot.get("name"),
                        memberRoot.get("email"),
                        buildingJoin.get("address"),
                        flatJoin.get("number"),
                        flatJoin.get("square")
                )
        );

        query.where(
                criteriaBuilder.and(
                        criteriaBuilder.isFalse(memberRoot.get("isEntranceAllowed")),
                        criteriaBuilder.isNotNull(residentRoot.get("member")),
                        criteriaBuilder.lessThan(
                                memberRoot.get("ownedApartmentsCount"), 2)
                )
        );

        return entityManager.createQuery(query).getResultList();
    }

    public void close() {
        entityManager.close();
        entityManagerFactory.close();
    }

}
