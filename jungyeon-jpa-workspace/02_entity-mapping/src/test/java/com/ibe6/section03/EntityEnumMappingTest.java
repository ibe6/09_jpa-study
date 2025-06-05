package com.ibe6.section03;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import java.time.LocalDateTime;
import java.util.Arrays;

public class EntityEnumMappingTest {

    private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @BeforeAll
    public static void initEntityManagerFactory() {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpa_test");
    }

    @BeforeEach
    public void initEntityManager() {
        entityManager = entityManagerFactory.createEntityManager();
    }

    @AfterEach
    public void destroyEntityManager() {
        entityManager.close();
    }

    @AfterAll
    public static void destroyEntityManagerFactory() {
        entityManagerFactory.close();
    }


    @Test
    public void enum_테스트() {
        System.out.println("UserRole.values(): " + Arrays.toString(UserRole.values()));
        System.out.println("UserRole.valueOf('ADMIN');" + UserRole.valueOf("ADMIN"));
        System.out.println("UserRole.USER: " + UserRole.USER);
        System.out.println("UserRole.USER.name(): " + UserRole.USER.name());
        System.out.println("UserRole.USER.ordinal(): " + UserRole.USER.ordinal());
    }

    @Test
    public void enum타입_매핑_테스트(){
        User user1 = User.builder()
                .userId("admin")
                .userPwd("1234")
                .nickname("관리자")
                .phone("010-2323-2111")
                .enrollDate(LocalDateTime.now())
                .userRole(UserRole.ADMIN)
                .build();

        User user2 = User.builder()
                .userId("user01")
                .userPwd("1234")
                .nickname("사용자")
                .phone("010-2366-2111")
                .enrollDate(LocalDateTime.now())
                .userRole(UserRole.USER)
                .build();

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        try {
            entityManager.persist(user1);
            entityManager.persist(user2);
            entityTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityTransaction.rollback();
        }
    }
}
