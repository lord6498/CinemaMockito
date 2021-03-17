package ru.netology.manager;

import ru.netology.domain.CinemaItem;


public class AfishaRepository {

    CinemaItem[] items = new CinemaItem[0]; // Массив с фильмами

    public void save(CinemaItem item) { // создание массива с фильмами
        int length = items.length + 1;
        CinemaItem[] tmp = new CinemaItem[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
        System.out.println(items);


    }

    public CinemaItem[] findAll() { // вывод всех фильмов
        return items;

    }

    public CinemaItem findById(int id) {
        for (CinemaItem item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void removeById(int cinemaId) {
        int lenght = items.length - 1;
        CinemaItem[] tmp = new CinemaItem[lenght];
        int index = 0;
        for (CinemaItem item : items) {
            if (item.getId() != cinemaId) {
                tmp[index] = item;
                index++;
            }
        }

        items = tmp;
        System.out.println(items);
    }

    public void removeAll() {
        items = new CinemaItem[0];
    }

}