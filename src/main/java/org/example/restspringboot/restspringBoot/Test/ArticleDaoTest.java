package org.example.restspringboot.restspringBoot.Test;

import org.example.restspringboot.restspringBoot.rest_example.model.ARTICLE;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/console.sql"}, executionPhase = Sql.ExecutionPhase)
public class ArticleDaoTest {

    @Autowired
    private ArticleDAO articleDAO;

    @Test
    public void testGetAllArticle(){
        List<ARTICLE> articleList = articleDAO.getAllArticle();
        Assert.assertEquals(articleList.size(),2);
        System.out.println("Article:");
        articleList.forEach(article -> System.out.println(article.getARTICLE() + "/" + article.getNAME()));
    }
}
