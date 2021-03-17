package ru.netology.manager;

import lombok.Data;
import ru.netology.domain.CinemaItem;

@Data
public class AfishaManager {

    private final AfishaRepository repository;
    private final int showCount;

    public AfishaManager(AfishaRepository repo, int showCount){
        this.repository = repo;
        this.showCount = showCount;
    }

    public AfishaManager() {                    //Без этого окнструктора мокито отказался работать
        this(new AfishaRepository(), 9);
    }

    public void addFilms(CinemaItem item) { // Добавление эелементов
        System.out.println(item);
        repository.save(item);
    }

    public CinemaItem[] getAll(){
        CinemaItem[] itemsFromRepo = repository.findAll();
        int resultSize = Math.min(itemsFromRepo.length,showCount);
        CinemaItem[] result = new CinemaItem[resultSize];

        for (int i = 0; i < result.length; i++){
            int index = itemsFromRepo.length-i-1;
            result[i] = itemsFromRepo[index];
        }
        return result;
    }

    public void remove(int id){
        repository.removeById(id);
    }

    public void removeAll(){
        repository.removeAll();
    }

    public CinemaItem findId(int id){
        CinemaItem item = repository.findById(id);
        return item;
    }

}
