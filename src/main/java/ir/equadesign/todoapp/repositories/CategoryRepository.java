package ir.equadesign.todoapp.repositories;

import ir.equadesign.todoapp.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    Optional<Category> findByCategory(String category);
}
