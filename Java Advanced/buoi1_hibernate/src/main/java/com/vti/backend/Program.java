package com.vti.backend;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Department;

//public class Program {

//    public static void main(String[] args) {
//
//        // lấy ds department từ DB
//        // b1: tạo session kết nối đến DB
//        SessionFactory sessionFactory;
//        Configuration cfg = new Configuration();
//        cfg.configure();
//        sessionFactory = cfg.buildSessionFactory();
//        // kết nối đến DB
//        Session session = sessionFactory.openSession();

//        // lấy dữ liệu từ bảng department
//        List<Department> departments = new ArrayList<>();
//        String hql = "From Department";
//        Query<Department> query = session.createQuery(hql, Department.class);
//        departments = query.list();
//
//        for (Department de : departments) {
//            System.out.println(de.toString());
//        }



    // tim theo id
//        String hql = "From Department where id = :idParam";
//        Query<Department> query = session.createQuery(hql, Department.class);
//        query.setParameter("idParam", 1);
//        Department department = query.uniqueResult();
//        System.out.println(department);



        // Them moi 1 department

//        // mo transaction
//        session.beginTransaction();
//        try{
//            Department department = new Department();
//            department.setName("Duong123");
//
//            session.persist(department);
//            // commit
//            session.getTransaction().commit();
//        } catch (Exception e) {
//            // hoan lai du lieu khi gap loi
//            session.getTransaction().rollback();
//        }


//        // update ten 'departmentName5' cho department co id = 5
//        // b1: tim department co id =5
//        String hql = "From Department where id = :idParam";
//        Query<Department> query = session.createQuery(hql, Department.class);
//        query.setParameter("idParam", 5);
//        Department departmentUpdate = query.uniqueResult();
//        // b2: update thong tin cho department tren
//
//
//        session.beginTransaction();
//        departmentUpdate.setName("departmentName5");
//        session.getTransaction().commit();
//    }
//}
