package resolvers; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import entities.Category;
import repo.CategoryRepository;

import java.util.List;

@Controller
public class CategoryResolver {

    @Autowired
    private CategoryRepository categoryRepository;

    @QueryMapping
    public List<Category> categories() {
        return categoryRepository.findAll();
    }

    @QueryMapping
    public Category category(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @MutationMapping
    public Category createCategory(@Argument String name) {
        Category category = new Category();
        category.setName(name);
        return categoryRepository.save(category);
    }
}
