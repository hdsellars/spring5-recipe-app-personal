package guru.springframework.services;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.transaction.annotation.Transactional;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;

/**
 * Created by jt on 6/17/17.
 */
public class RecipeServiceImplTest {

	@InjectMocks 
    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;


    @Before
    @Transactional 
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        recipeService = new RecipeServiceImpl(recipeRepository);
    }

     
    @Test
    @Transactional 
    public void getRecipes() throws Exception {


        Recipe recipe = new Recipe();
        recipe.setId(1L);
        HashSet<Recipe> recipesData = new HashSet<Recipe>();
        recipesData.add(recipe);
        
        when(recipeRepository.findAll()).thenReturn(recipesData);
       //when(recipeService.getRecipes()).thenReturn(recipesData);

        Set<Recipe> recipes = recipeService.getRecipes();

        assertEquals(recipes.size(), 1);
        verify(recipeRepository, times(1)).findAll();
    }

}