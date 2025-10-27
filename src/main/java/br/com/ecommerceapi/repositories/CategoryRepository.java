package br.com.ecommerceapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ecommerceapi.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
