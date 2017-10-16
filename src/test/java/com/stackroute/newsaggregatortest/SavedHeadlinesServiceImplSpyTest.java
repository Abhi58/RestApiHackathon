/*package com.stackroute.newsaggregatortest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import com.stackroute.hackathon.domain.News;
import com.stackroute.hackathon.repository.NewsRepository;
import com.stackroute.hackathon.services.SavedHeadlinesServiceImpl;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.when;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class SavedHeadlinesServiceImplSpyTest {

    @Spy
    private SavedHeadlinesServiceImpl prodServiceSpy;
    @Mock
    private NewsRepository productRepository;
    @Mock
    private News product;

  @Test(expected=NullPointerException.class)
    public void shouldThrowNullPointerException_whenGetProductByIdIsCalledWithoutContext() throws Exception {
        //Act
        News retrievedProduct = prodServiceSpy.getById(5);
        //Assert
        assertThat(retrievedProduct, is(equalTo(product)));
    }

  public void shouldThrowNullPointerException_whenSaveProductIsCalledWithoutContext() throws Exception {
        //Arrange
        Mockito.doReturn(product).when(productRepository).save(product);
        //Act
        News savedProduct = prodServiceSpy.insertHeadlines(product);
        //Assert
        assertThat(savedProduct, is(equalTo(product)));
    }

  @Test
    public void shouldVerifyThatGetProductByIdIsCalled() throws Exception {
        //Arrange
        Mockito.doReturn(product).when(prodServiceSpy).getById(5);
        //Act
        News retrievedProduct = prodServiceSpy.getById(5);
        //Assert
        Mockito.verify(prodServiceSpy).getById(5);
    }
    @Test
    public void shouldVerifyThatSaveProductIsNotCalled() throws Exception {
        //Arrange
        Mockito.doReturn(product).when(prodServiceSpy).getById(5);
        //Act
        News retrievedProduct = prodServiceSpy.getById(5);
        //Assert
        Mockito.verify(prodServiceSpy,never()).insertHeadlines(product);
    }
}
*/