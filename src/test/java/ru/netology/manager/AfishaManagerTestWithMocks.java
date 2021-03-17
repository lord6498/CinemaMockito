package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import ru.netology.domain.CinemaItem;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class AfishaManagerTestWithMocks {

    @Mock
    private AfishaRepository repo;
    @InjectMocks
    AfishaManager manager;
    CinemaItem item1 = new CinemaItem(1, "King Arthur", 65);
    CinemaItem item2 = new CinemaItem(2, "King Arthur 2", 65);
    CinemaItem item3 = new CinemaItem(3, "Game of Thrones", 65);
    private CinemaItem item;

    @BeforeEach
    public void setUp(){
        manager.addFilms(item1);
        manager.addFilms(item2);
        manager.addFilms(item3);
    }

    @Test
    public void findAll(){
        AfishaManager manager = new AfishaManager(new AfishaRepository(),2);
        manager.addFilms(item1);
        manager.addFilms(item2);
        manager.addFilms(item3);

    CinemaItem[] actual = manager.getAll();
    CinemaItem[] expected = new CinemaItem[]{item3, item2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeObject(){ //удаление определенного массива данных
        int idToRemove = 2;
        doReturn(new CinemaItem[]{item3, item2, item1}).when(repo).findAll();
        doNothing().when(repo).removeById(idToRemove);
        manager.remove(idToRemove);

        CinemaItem[] actual = manager.getAll();
        CinemaItem[] expected = new CinemaItem[]{item3, item1};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeAll(){ //удаление всех обьектов из массива данных
        doNothing().when(repo).removeAll();
        manager.removeAll();

        CinemaItem[] actual = manager.getAll();
        CinemaItem[] expected = new CinemaItem[0];

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findById(){
        int idToFind = 2;
        doReturn(item).when(repo).findById(idToFind);
        CinemaItem actual = manager.findId(idToFind);
        CinemaItem expected = item2;

        Assertions.assertEquals(expected , actual);

    }


}