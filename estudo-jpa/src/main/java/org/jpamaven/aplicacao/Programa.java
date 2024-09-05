package org.jpamaven.aplicacao;

import org.jpamaven.dominio.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Programa {

    public static void main(String[] args) {
        Pessoa p1 = new Pessoa(null, "Carlos da Silva", "carlos@gmail.com");
        Pessoa p2 = new Pessoa(null, "Joaquim Torres", "joaquim@gmail.com");
        Pessoa p3 = new Pessoa(null, "Ana Maria", "ana@gmail.com");

        //Um objeto EntityManagerFactory é utilizado para instanciar objetos EntityManager.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");

        //Um objeto EntityManager encapsula uma conexão com a base de dados e serve para efetuar operações de acesso a dados (inserção, remoção, deleção, atualização) em entidades (clientes, produtos, pedidos, etc.) por ele monitoradas em um mesmo contexto de persistência.
        //
        //Escopo: tipicamente mantem-se uma instância única de EntityManager para cada thread do sistema (no caso de aplicações web, para cada requisição ao sistema).
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
//        em.persist(p1);
//        em.persist(p2);
//        em.persist(p3);
//        em.getTransaction().commit();

        Pessoa p = em.find(Pessoa.class, 2);

        System.out.println(p);
        System.out.println("Pronto!");

        em.close();
        emf.close();
    }
}
