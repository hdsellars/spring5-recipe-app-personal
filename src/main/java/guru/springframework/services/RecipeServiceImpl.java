package guru.springframework.services;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by jt on 6/13/17.
 */
@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

	 
    private final RecipeRepository recipeRepository;

    @Autowired 
    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Transactional 
    @Override 
    public Set<Recipe> getRecipes() {
        log.debug("I'm in the service");

        Set<Recipe> recipeSet = new HashSet<>();
        RecipeRepository resp = recipeRepository;
        Set<Recipe> allRecipes = (Set<Recipe>) resp.findAll();
       Iterator<Recipe> it =  allRecipes
    		   .iterator();  
        it.forEachRemaining(recipeSet::add);
        return recipeSet;
    }
}