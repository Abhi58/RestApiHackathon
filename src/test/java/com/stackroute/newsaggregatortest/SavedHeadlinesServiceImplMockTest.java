/*package com.stackroute.newsaggregatortest;

import org.junit.Before;
import org.junit.Test;

import com.stackroute.hackathon.domain.News;
import com.stackroute.hackathon.repository.NewsRepository;
import com.stackroute.hackathon.services.SavedHeadlinesServiceImpl;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SavedHeadlinesServiceImplMockTest {
	


   private SavedHeadlinesServiceImpl productServiceImpl;
    @Mock
    private NewsRepository productRepository;
    @Mock
    private News product;
    @Before
    public void setupMock() {
        MockitoAnnotations.initMocks(this);
        productServiceImpl=new SavedHeadlinesServiceImpl();
        productServiceImpl.setNewsRepository(productRepository);
    }
    @Test
    public void shouldReturnProduct_whenGetProductByIdIsCalled() throws Exception {
        // Arrange
        when(productRepository.findOne(5)).thenReturn(product);
        // Act
        News retrievedProduct = productServiceImpl.getById(5);
        // Assert
        assertThat(retrievedProduct, is(equalTo(product)));

   }
    @Test
    public void shouldReturnProduct_whenSaveProductIsCalled() throws Exception {
        // Arrange
        when(productRepository.save(product)).thenReturn(product);
        // Act
        News savedProduct = productServiceImpl.insertHeadlines(product);
        // Assert
        assertThat(savedProduct, is(equalTo(product)));
    }
    @Test
    public void shouldCallDeleteMethodOfProductRepository_whenDeleteProductIsCalled() throws Exception {
        // Arrange
        doNothing().when(productRepository).delete(5);
        NewsRepository my = Mockito.mock(NewsRepository.class);
        // Act
        productServiceImpl.deleteHeadlines(5);
        // Assert
        verify(productRepository, times(1)).delete(5);
    }
}
*/